package com.wundermancommerce.interviewtests.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import com.wundermancommerce.interviewtests.graph.dao.PeopleRelationshipCsvDaoImpl;
import com.wundermancommerce.interviewtests.graph.dao.PeopleRelationshipDao;
import com.wundermancommerce.interviewtests.graph.model.Person;
import com.wundermancommerce.interviewtests.graph.model.Relationship;
import com.wundermancommerce.interviewtests.graph.model.RelationshipEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FamilyGraphImpl implements FamilyGraph{
	
	private static final Logger LOGGER = Logger.getLogger(FamilyGraphImpl.class.getName());
	
	@Autowired
	private PeopleRelationshipDao peopleRelationshipDao;

	@Override
	public int getTotalPeople() {
		Set<Person> persons =peopleRelationshipDao.getPeople();
		return persons.size();
	}

	@Override
	public int getTotalRelationships() {
		Set<Relationship> relationships = peopleRelationshipDao.getRelationships();
		return relationships.size();
	}
	

	@Override
	public Integer getTotalPersonRelations(String personEmail) {
		
		Set<String> personRelationEmails = personAllRelations(personEmail);
		if(personRelationEmails != null) {
			return personRelationEmails.size();
		}
		return null;
	}

	@Override
	public Integer getTotalPersonExtendedFamilyRelations(String personEmail) {
		
		Set<String> extendedFamilyRelationEmail = personExtendedFamilyRelations(personEmail);
		if(extendedFamilyRelationEmail != null) {
			return extendedFamilyRelationEmail.size();
		}
		return null;
	}

	@Override
	public Set<String> personAllRelations(String personEmail) {
		if(personEmail == null || personEmail.isEmpty()) {
			return null;
		}

		Set<String> personRelationEmails = new HashSet<String>();
		Set<Relationship> relationships = peopleRelationshipDao.getRelationships();
		addPersonRelationEmail(personEmail, relationships, personRelationEmails, null);
		return personRelationEmails;

	}
	
	@Override
	public Map<String, Set<String>> allPersonAllRelations() {

		Map<String, Set<String>> personAllRelation = new HashMap<String, Set<String>>();

		Set<Person> persons =peopleRelationshipDao.getPeople();
		Set<Relationship> relationships =peopleRelationshipDao.getRelationships();

		Set<String> personRelationEmails = null;

		for (Person person1 : persons) {
			personRelationEmails = new HashSet<String>();
			//Search for  all relationships on first level and add
			addPersonRelationEmail(person1.getEmail(), relationships, personRelationEmails, null);
			personAllRelation.put(person1.getEmail(), personRelationEmails);
		}

		return personAllRelation;
	}

	@Override
	public Set<String> personExtendedFamilyRelations(String personEmail) {
		if(personEmail == null || personEmail.isEmpty()) {
			return null;
		}
		
		Set<Relationship> relationships = peopleRelationshipDao.getRelationships();
		
		Set<String> extendedFamilyRelationEmail = getExtendedFamilyRelations(personEmail, relationships);

		return extendedFamilyRelationEmail;

	}


	@Override
	public Map<String, Set<String>> allPersonExtendedFamilyRelations() {

		Set<Person> persons = peopleRelationshipDao.getPeople();
		Set<Relationship> relationships = peopleRelationshipDao.getRelationships();

		Map<String, Set<String>> personExtendedFamilyRelation = new HashMap<String, Set<String>>();

		Set<String> familyRelationEmail = null;

		for (Person person : persons) {
			//Search for extend family relation for person
			familyRelationEmail = getExtendedFamilyRelations(person.getEmail(), relationships);
			personExtendedFamilyRelation.put(person.getEmail(), familyRelationEmail);
		}

		return personExtendedFamilyRelation;

	}
	
	/**
	 * Search for extend family relationship per person
	 * @param personEmail
	 * @param relationships
	 * @return
	 */
	
	private Set<String> getExtendedFamilyRelations(String personEmail, Set<Relationship> relationships) {
		
		Set<String> familyRelationEmail = new HashSet<String>();
		
		//Add First level Relationships
		addPersonRelationEmail(personEmail, relationships, familyRelationEmail, RelationshipEnum.FAMILY);

		//same person relationships himself or relationship with extended family person
		familyRelationEmail.add(personEmail);
		
		//Add Extended Family Relationships
		addExtendedFamilyRelations(familyRelationEmail,relationships);
		return familyRelationEmail;
	}
	
	/**Search for Extended family relation by EXTENDED FAMILY RELATIONSHIP DEPTH and added to set
	 *for example, 
	 *if EXTENDED FAMILY RELATIONSHIP DEPTH is one it searches for first level
	 *if EXTENDED FAMILY RELATIONSHIP DEPTH is two it searches for second level etc
	 * 
	 * @param familyRelationEmail
	 * @param relationships
	 */
	
	private void addExtendedFamilyRelations(Set<String> familyRelationEmail, Set<Relationship> relationships) {
		
		//if depth is one  searches for first level
		//if depth is two searches for second level etc

		Set<String> tempFamilyRelationEmail = new HashSet<String>();
		tempFamilyRelationEmail.addAll(familyRelationEmail);
		int depth = 1;
		while (depth < FamilyGraphConstants.EXTENDED_FAMILY_RELATIONSHIP_DEPTH) {

			for (String personEmail : tempFamilyRelationEmail) {
				addPersonRelationEmail(personEmail, relationships, familyRelationEmail, RelationshipEnum.FAMILY);

			}
			depth++;
			tempFamilyRelationEmail.clear();
			tempFamilyRelationEmail.addAll(familyRelationEmail);

		}

	}

	/**
	 * Search Relation, if Person have relation with another Person and add Set
	 * If Relationship null, search for all relations
	 * If Relationship not null, search for specified relationship (Like FAMILY passed, search for family relationship)
	 * @param personEmail
	 * @param relationships
	 * @param familyRelationEmail
	 * @param relationshipEnum
	 */
	private void addPersonRelationEmail(String personEmail, Set<Relationship> relationships,
			Set<String> familyRelationEmail, RelationshipEnum relationshipEnum) {

		for (Relationship relationship : relationships) {
			
			//If Relationship null, search for all relations
			//If Relationship not null, search for specified relationship(Like FAMILY family relationship)
			
			if (relationshipEnum == null || relationshipEnum == relationship.getRelationship()) {
				addPersonRelationEmail(personEmail, relationship.getPersion1Email(), relationship.getPersion2Email(), familyRelationEmail);
			}
		}

	}
	
	/**
	 * 
	 * @param personEmail
	 * @param person1RelationEmail
	 * @param person2RelationEmail
	 * @param familyRelationEmail
	 */

	private void addPersonRelationEmail(String personEmail, String person1RelationEmail, String person2RelationEmail, Set<String> familyRelationEmail) {
		
		//If person email equals to first person email, add second person email
		//If person email equals to second person email, add first person email
		
		if (person1RelationEmail.equalsIgnoreCase(personEmail)) {
			familyRelationEmail.add(person2RelationEmail);

		} else if (person2RelationEmail.equalsIgnoreCase(personEmail)) {
			familyRelationEmail.add(person1RelationEmail);

		}
	}


}
