package com.wundermancommerce.interviewtests.graph;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FamilyGraphConfig.class})
public class FamilyGraphExtendedFamilyRelationshipsTest {
	
	@Autowired
	private FamilyGraph familyGraph;
	

		@Test
		public void testPersonExtendedFamilyRelations_whenPersonNull() {
			Set<String>  actualPersonRelationEmails= familyGraph.personExtendedFamilyRelations(null);
			assertNull(actualPersonRelationEmails);
			
		}
	 
		@Test
		public void testPersonExtendedFamilyRelations_whenEmpty() {
			Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("");
			assertNull(actualPersonRelationEmails);
			
		}
		
		@Test
		public void testPersonExtendedFamilyRelations_whenPersonInvalid() {
			Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("invalid");
			assertEquals(1, actualPersonRelationEmails.size());

			
		}

	@Test
	public void testPersonExtendedFamilyRelations_whenBob() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("bob@bob.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("bob@bob.com");
		expectedPersonRelationEmails.add("amber@gmail.com");
		expectedPersonRelationEmails.add("anna@clothes.com");
		expectedPersonRelationEmails.add("finn@gmail.com");
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4 );
		
	}

	
	@Test
	public void testPersonExtendedFamilyRelations_whenDerek() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("derek@bob.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("derek@bob.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,1 );
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenAnna() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("anna@clothes.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("anna@clothes.com");
		expectedPersonRelationEmails.add("bob@bob.com");
		expectedPersonRelationEmails.add("finn@gmail.com");
		expectedPersonRelationEmails.add("amber@gmail.com");
		
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4 );
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenJenny() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("jenny@toys.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("jenny@toys.com");
		expectedPersonRelationEmails.add("pete@timber.com");
		expectedPersonRelationEmails.add("kerry@oilcompany.org");
		expectedPersonRelationEmails.add("dave@dentists.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4 );
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenPete() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("pete@timber.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("pete@timber.com");
		expectedPersonRelationEmails.add("jenny@toys.com");
		expectedPersonRelationEmails.add("kerry@oilcompany.org");
		expectedPersonRelationEmails.add("dave@dentists.com");

		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4 );
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenKerry() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("kerry@oilcompany.org");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("kerry@oilcompany.org");
		expectedPersonRelationEmails.add("jenny@toys.com");
		expectedPersonRelationEmails.add("pete@timber.com");
		expectedPersonRelationEmails.add("dave@dentists.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4);
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenJoe() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("joe@construction.net");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("joe@construction.net");
		expectedPersonRelationEmails.add("nigel@marketing.com");
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,2 );
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenNigel(){
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("nigel@marketing.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("nigel@marketing.com");
		expectedPersonRelationEmails.add("joe@construction.net");
		
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,2 );
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenAmber() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("amber@gmail.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("amber@gmail.com");
		expectedPersonRelationEmails.add("bob@bob.com");
		expectedPersonRelationEmails.add("anna@clothes.com");
		expectedPersonRelationEmails.add("finn@gmail.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4 );
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenFinn() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("finn@gmail.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("finn@gmail.com");
		expectedPersonRelationEmails.add("bob@bob.com");
		expectedPersonRelationEmails.add("anna@clothes.com");
		expectedPersonRelationEmails.add("amber@gmail.com");

		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4 );
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenAlan() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("alan@lonely.org");
		Set<String> expectedPersonRelationEmails = new HashSet<String>();
		expectedPersonRelationEmails.add("alan@lonely.org");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,1);
	}
	
	@Test
	public void testPersonExtendedFamilyRelations_whenDave() {
		Set<String> actualPersonRelationEmails = familyGraph.personExtendedFamilyRelations("dave@dentists.com");

		Set<String> expectedPersonRelationEmails =new HashSet<String>();
		expectedPersonRelationEmails.add("dave@dentists.com");
		expectedPersonRelationEmails.add("kerry@oilcompany.org");
		expectedPersonRelationEmails.add("pete@timber.com");
		expectedPersonRelationEmails.add("jenny@toys.com");
		
		assertPersonRelation(expectedPersonRelationEmails, actualPersonRelationEmails,4);
	}

	@Test
	public void testAllPersonExtendedFamilyRelations() {
		Map<String, Set<String>> actualAllPersonAllRelation = familyGraph.allPersonExtendedFamilyRelations();
		assertNotNull(actualAllPersonAllRelation);
		assertEquals(12, actualAllPersonAllRelation.size());
		
		assertPersonRelation(actualAllPersonAllRelation,"bob@bob.com", 4);
		
		assertPersonRelation(actualAllPersonAllRelation,"derek@bob.com", 1);
		assertPersonRelation(actualAllPersonAllRelation,"anna@clothes.com", 4);
		assertPersonRelation(actualAllPersonAllRelation,"jenny@toys.com", 4);
		assertPersonRelation(actualAllPersonAllRelation,"pete@timber.com", 4);
		assertPersonRelation(actualAllPersonAllRelation,"kerry@oilcompany.org", 4);
		
		assertPersonRelation(actualAllPersonAllRelation,"joe@construction.net", 2);
		assertPersonRelation(actualAllPersonAllRelation,"nigel@marketing.com", 2);
		assertPersonRelation(actualAllPersonAllRelation,"amber@gmail.com", 4);
		assertPersonRelation(actualAllPersonAllRelation,"finn@gmail.com", 4);
		assertPersonRelation(actualAllPersonAllRelation,"alan@lonely.org", 1);
		assertPersonRelation(actualAllPersonAllRelation,"dave@dentists.com", 4);
	
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
