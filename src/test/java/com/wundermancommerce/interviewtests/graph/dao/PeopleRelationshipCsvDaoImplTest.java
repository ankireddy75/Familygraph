package com.wundermancommerce.interviewtests.graph.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import com.wundermancommerce.interviewtests.graph.FamilyGraphConfig;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.wundermancommerce.interviewtests.graph.model.Person;
import com.wundermancommerce.interviewtests.graph.model.Relationship;
import com.wundermancommerce.interviewtests.graph.model.RelationshipEnum;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FamilyGraphConfig.class})
public class PeopleRelationshipCsvDaoImplTest {
	
	 @Autowired
	 private PeopleRelationshipCsvDaoImpl peopleRelationshipCsvDao;


	@Test
	public void testGetPeople() {
		 
		
		Set<Person> actualPersons=peopleRelationshipCsvDao.getPeople();
		Set<Person> expectedPersons=getExpectedPeople();
		assertNotNull(expectedPersons); 
		assertEquals(12,actualPersons.size());
		assertTrue(expectedPersons.containsAll(actualPersons));
	
	}

	@Test
	public void testGetRelationship() {
		Set<Relationship> actualRelationships = peopleRelationshipCsvDao.getRelationships();
		assertNotNull(actualRelationships); 
		assertEquals(16,actualRelationships.size());
		Set<Relationship> expectedRelationships =  getExpectedRelationship();
		assertTrue(expectedRelationships.containsAll(actualRelationships));;
	}
	
	
	private Set<Person> getExpectedPeople(){
		Set<Person> persons = new HashSet<Person>();
	
		persons.add(new Person("31","Bob","bob@bob.com"));
		persons.add(new Person("25","Derek","derek@bob.com"));
		persons.add(new Person("25","Anna","anna@clothes.com"));
		persons.add(new Person("52","Jenny","jenny@toys.com"));
		persons.add(new Person("57","Pete","pete@timber.com"));
		persons.add(new Person("29","Kerry","kerry@oilcompany.org"));
		persons.add(new Person("28","Joe","joe@construction.net"));
		persons.add(new Person("40","Nigel","nigel@marketing.com"));
		persons.add(new Person("12","Amber","amber@gmail.com"));
		persons.add(new Person("15","Finn","finn@gmail.com"));
		persons.add(new Person("23","Alan","alan@lonely.org"));
	    persons.add(new Person("49","Dave","dave@dentists.com"));
	    return persons;
	}

	private Set<Relationship> getExpectedRelationship(){
		Set<Relationship> relationships = new HashSet<Relationship>();
		
		relationships.add(new Relationship("bob@bob.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"finn@gmail.com"));
		relationships.add(new Relationship("bob@bob.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"amber@gmail.com"));
		relationships.add(new Relationship("bob@bob.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"anna@clothes.com"));
		relationships.add(new Relationship("anna@clothes.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"finn@gmail.com"));
		relationships.add(new Relationship("anna@clothes.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"amber@gmail.com"));
		relationships.add(new Relationship("amber@gmail.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"finn@gmail.com"));

		relationships.add(new Relationship("anna@clothes.com",RelationshipEnum.getRelationshipEnumByName("FRIEND"),"jenny@toys.com"));
		relationships.add(new Relationship("jenny@toys.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"pete@timber.com"));
		relationships.add(new Relationship("jenny@toys.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"kerry@oilcompany.org"));
		relationships.add(new Relationship("pete@timber.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"kerry@oilcompany.org"));
		relationships.add(new Relationship("dave@dentists.com",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"pete@timber.com"));

		relationships.add(new Relationship("kerry@oilcompany.org",RelationshipEnum.getRelationshipEnumByName("FRIEND"),"joe@construction.net"));
		relationships.add(new Relationship("joe@construction.net",RelationshipEnum.getRelationshipEnumByName("FAMILY"),"nigel@marketing.com"));
		relationships.add(new Relationship("nigel@marketing.com",RelationshipEnum.getRelationshipEnumByName("FRIEND"),"derek@bob.com"));
		relationships.add(new Relationship("derek@bob.com",RelationshipEnum.getRelationshipEnumByName("FRIEND"),"bob@bob.com"));
		relationships.add(new Relationship("derek@bob.com",RelationshipEnum.getRelationshipEnumByName("FRIEND"),"pete@timber.com"));		
				
		
		return relationships;
	}
}
