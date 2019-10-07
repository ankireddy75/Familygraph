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
public class FamilyGraphTotalPeoplelRelationshipsTest {
	
	@Autowired
	private FamilyGraph familyGraph;
	
		@Test
		public void testGetTotalPeople() {
			int totalPeople = familyGraph.getTotalPeople();
			assertEquals(12,totalPeople);
			
		}
	 
		@Test
		public void testGetTotalRelationships() {
			int totalRelationships = familyGraph.getTotalRelationships();
			assertEquals(16,totalRelationships);
			
		}
			
		@Test
		public void testGetTotalPersonRelations_whenBob() {
			int totalRelationships = familyGraph.getTotalPersonRelations("bob@bob.com");
			assertEquals(4,totalRelationships);
			
		}
		
		@Test
		public void testGetTotalPersonRelations_whenJenny() {
			int totalRelationships = familyGraph.getTotalPersonRelations("jenny@toys.com");
			assertEquals(3,totalRelationships);
			
		}
		
		@Test
		public void testGetTotalPersonRelations_whenNigel() {
			int totalRelationships = familyGraph.getTotalPersonRelations("nigel@marketing.com");
			assertEquals(2,totalRelationships);
			
		}

		@Test
		public void testGetTotalPersonRelations_whenAlan() {
			int totalRelationships = familyGraph.getTotalPersonRelations("alan@lonely.org");
			assertEquals(0,totalRelationships);
			
		}
		
		@Test
		public void testGetTotalPersonExtendedFamilyRelations_whenBob() {
			int totalRelationships = familyGraph.getTotalPersonExtendedFamilyRelations("bob@bob.com");
			assertEquals(4,totalRelationships);
			
		}
		
		@Test
		public void testGeetTotalPersonExtendedFamilyRelations_whenJenny() {
			int totalRelationships = familyGraph.getTotalPersonExtendedFamilyRelations("jenny@toys.com");
			assertEquals(4,totalRelationships);
			
		}
		
		@Test
		public void testGetTotalPersonExtendedFamilyRelations_whenNigel() {
			int totalRelationships = familyGraph.getTotalPersonExtendedFamilyRelations("nigel@marketing.com");
			assertEquals(2,totalRelationships);
			
		}

		@Test
		public void testGetTotalPersonExtendedFamilyRelations_whenAlan() {
			int totalRelationships = familyGraph.getTotalPersonExtendedFamilyRelations("alan@lonely.org");
			assertEquals(1,totalRelationships);
			
		}
		

}
