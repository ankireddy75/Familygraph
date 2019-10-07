package com.wundermancommerce.interviewtests.graph.dao;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.wundermancommerce.interviewtests.graph.FamilyGraphConstants;
import com.wundermancommerce.interviewtests.graph.model.Person;
import com.wundermancommerce.interviewtests.graph.model.Relationship;
import com.wundermancommerce.interviewtests.graph.model.RelationshipEnum;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleRelationshipCsvDaoImpl  implements PeopleRelationshipDao{
	 private static final Logger LOGGER = Logger.getLogger(PeopleRelationshipCsvDaoImpl.class.getName());

	@Override
	 public Set<Person> getPeople() {
		Set<Person> persons = new HashSet<Person>();
		String personRow= null;
		try (Scanner scanner = new Scanner(getInputStream(FamilyGraphConstants.PEOPLE_FILE))) {
			while (scanner.hasNextLine()) {
				personRow = scanner.nextLine();
				addPerson(personRow, persons);
			}

		} 
		return persons;
	}
	
	@Override
	public Set<Relationship> getRelationships() {
		Set<Relationship> relationships = new HashSet<Relationship>();
		String relationshipRow = null;
		try (Scanner scanner = new Scanner(getInputStream(FamilyGraphConstants.RELATIONSHIPS_FILE))) {
			
			while (scanner.hasNextLine()) {

				relationshipRow = scanner.nextLine();
				addRelationship(relationshipRow, relationships);
			}

		} 
		return relationships;
	}
	
	private InputStream getInputStream(String csvFilePath) {
		InputStream inputStream = this.getClass().getResourceAsStream(csvFilePath);
		return inputStream;
	}

	private void addPerson(String row, Set<Person> persons) {
		if (row != null & !row.isEmpty()) {
			String[] personArray = row.split(FamilyGraphConstants.CSV_DELIMITER);
			if (personArray.length >= FamilyGraphConstants.PEOPLE_ROW_COLUMNS) {
				Person person = new Person();
				person.setName(personArray[0]);
				person.setEmail(personArray[1]);
				person.setId(personArray[2]);
				persons.add(person);
			}else {
				LOGGER.log(Level.WARNING, "Invalid row:("+row+") in people csv file");
			}
		}
	}
	private void addRelationship(String relationshipRow, Set<Relationship> relationships) {
		if (relationshipRow != null & !relationshipRow.isEmpty()) {
			String[] relationshipArray = relationshipRow.split(FamilyGraphConstants.CSV_DELIMITER);
			if (relationshipArray.length >= FamilyGraphConstants.RELATIONSHIPS_ROW_COLUMNS) {
				Relationship relationship = new Relationship();
				relationship.setPersion1Email(relationshipArray[0]);
				String relationshipString = relationshipArray[1];
				RelationshipEnum relationshipEnum = RelationshipEnum.getRelationshipEnumByName(relationshipString);
				relationship.setRelationship(relationshipEnum);
				relationship.setPersion2Email(relationshipArray[2]);
				relationships.add(relationship);
			}else {
				LOGGER.log(Level.WARNING, "Invalid row:("+relationshipRow+") in relationship csv file");
			}
		}
	}

}
