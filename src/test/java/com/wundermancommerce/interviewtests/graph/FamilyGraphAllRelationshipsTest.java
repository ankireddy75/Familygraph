package com.wundermancommerce.interviewtests.graph;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FamilyGraphConfig.class})
public class FamilyGraphAllRelationshipsTest {
	
	@Autowired
	private FamilyGraph familyGraph;
	
		@Test
		public void testPersonAllRelations_whenPersonEmailNull() {
			Set<String>  actualPersonRelationEmails= familyGraph.personAllRelations(null);
			assertNull(actualPersonRelationEmails);
			
		}
	 
		@Test
		public void testPersonAllRelations_whennPersonEmailEmpty() {
			Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("");
			assertNull(actualPersonRelationEmails);
			
		}
		
		@Test
		public void testPersonAllRelations_whenPersonEmailInvalid() {
			Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("invalid");
			assertNotNull(actualPersonRelationEmails);
			assertEquals(0, actualPersonRelationEmails.size());
			
		}

	@Test
	public void testPersonAllRelations_whenBob() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("bob@bob.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("finn@gmail.com");
		expectedPersonRelationEmails.add("amber@gmail.com");
		expectedPersonRelationEmails.add("anna@clothes.com");
		expectedPersonRelationEmails.add("derek@bob.com");

		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4 );
		
	}

	
	@Test
	public void testPersonAllRelations_whenDerek() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("derek@bob.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("nigel@marketing.com");
		expectedPersonRelationEmails.add("bob@bob.com");
		expectedPersonRelationEmails.add("pete@timber.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,3 );
	}
	
	@Test
	public void testPersonAllRelations_whenAnna() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("anna@clothes.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("bob@bob.com");
		expectedPersonRelationEmails.add("finn@gmail.com");
		expectedPersonRelationEmails.add("amber@gmail.com");
		expectedPersonRelationEmails.add("jenny@toys.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4 );
	}
	
	@Test
	public void testPersonAllRelations_whenJenny() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("jenny@toys.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("anna@clothes.com");
		expectedPersonRelationEmails.add("pete@timber.com");
		expectedPersonRelationEmails.add("kerry@oilcompany.org");
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,3 );
	}
	
	@Test
	public void testPersonAllRelations_whenPete() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("pete@timber.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("jenny@toys.com");
		expectedPersonRelationEmails.add("kerry@oilcompany.org");
		expectedPersonRelationEmails.add("dave@dentists.com");
		expectedPersonRelationEmails.add("derek@bob.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4 );
	}
	
	@Test
	public void testPersonAllRelations_whenKerry() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("kerry@oilcompany.org");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("jenny@toys.com");
		expectedPersonRelationEmails.add("pete@timber.com");
		expectedPersonRelationEmails.add("joe@construction.net");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,3);
	}
	
	@Test
	public void testPersonAllRelations_whenJoe() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("joe@construction.net");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("kerry@oilcompany.org");
		expectedPersonRelationEmails.add("nigel@marketing.com");
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,2 );
	}
	
	@Test
	public void testPersonAllRelations_whenNigel(){
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("nigel@marketing.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("joe@construction.net");
		expectedPersonRelationEmails.add("derek@bob.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,2 );
	}
	
	@Test
	public void testPersonAllRelations_whenAmber() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("amber@gmail.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("bob@bob.com");
		expectedPersonRelationEmails.add("anna@clothes.com");
		expectedPersonRelationEmails.add("finn@gmail.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,3 );
	}
	
	@Test
	public void testPersonAllRelations_whenFinn() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("finn@gmail.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("bob@bob.com");
		expectedPersonRelationEmails.add("anna@clothes.com");
		expectedPersonRelationEmails.add("amber@gmail.com");

		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,3 );
	}
	
	@Test
	public void testPersonAllRelations_whenAlan() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("alan@lonely.org");
		Set<String> expectedPersonRelationEmails = new HashSet<String>();
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,0);
	}
	
	@Test
	public void testPersonAllRelations_whenDave() {
		Set<String> actualPersonRelationEmails = familyGraph.personAllRelations("dave@dentists.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("pete@timber.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,1);
	}

	@Test
	public void testAllPersonAllRelations() {
		Map<String, Set<String>> actualAllPersonAllRelation = familyGraph.allPersonAllRelations();
		assertNotNull(actualAllPersonAllRelation);
		assertEquals(12, actualAllPersonAllRelation.size());
		
		assertPersonRelation(actualAllPersonAllRelation,"bob@bob.com", 4);
		
		assertPersonRelation(actualAllPersonAllRelation,"derek@bob.com", 3);
		assertPersonRelation(actualAllPersonAllRelation,"anna@clothes.com", 4);
		assertPersonRelation(actualAllPersonAllRelation,"jenny@toys.com", 3);
		assertPersonRelation(actualAllPersonAllRelation,"pete@timber.com", 4);
		assertPersonRelation(actualAllPersonAllRelation,"kerry@oilcompany.org", 3);
		
		assertPersonRelation(actualAllPersonAllRelation,"joe@construction.net", 2);
		assertPersonRelation(actualAllPersonAllRelation,"nigel@marketing.com", 2);
		assertPersonRelation(actualAllPersonAllRelation,"amber@gmail.com", 3);
		assertPersonRelation(actualAllPersonAllRelation,"finn@gmail.com", 3);
		assertPersonRelation(actualAllPersonAllRelation,"alan@lonely.org", 0);
		assertPersonRelation(actualAllPersonAllRelation,"dave@dentists.com", 1);
	
	}
	
	private void assertPersonRelation(Map<String, Set<String>> actualAllPersonAllRelation, String personEmail, int numberOfRelation) {
		assertNotNull(actualAllPersonAllRelation.get(personEmail));
		assertEquals(numberOfRelation, actualAllPersonAllRelation.get(personEmail).size());
	}
	
	private void assertPersonRelation(Set<String> expectedPersonRelationEmails, Set<String> actualPersonRelationEmails, int numberOfRelations) {
		assertNotNull(actualPersonRelationEmails);
		assertEquals(numberOfRelations, actualPersonRelationEmails.size());
		assertTrue(expectedPersonRelationEmails.containsAll(actualPersonRelationEmails));;
	}


}
