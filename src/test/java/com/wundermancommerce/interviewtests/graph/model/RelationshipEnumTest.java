package com.wundermancommerce.interviewtests.graph.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class RelationshipEnumTest {

	@Test
	public void testGetRelationshipEnumByName_whenRelationshipNull() {
		
		assertNull(RelationshipEnum.getRelationshipEnumByName(null));
	}
	
	@Test
	public void testGetRelationshipEnumByName_whenRelationshipEmpty() {
		assertNull(RelationshipEnum.getRelationshipEnumByName(""));
	}
	
	@Test
	public void testGetRelationshipEnumByName_whenRelationshipNotValid() {
		assertNull(RelationshipEnum.getRelationshipEnumByName("invalid"));
	}
	
	@Test
	public void testGetRelationshipEnumByName_whenRelationshipFamily() {
		assertEquals(RelationshipEnum.FAMILY,RelationshipEnum.getRelationshipEnumByName("FAMILY"));
	}
	
	@Test
	public void testGetRelationshipEnumByName_whenRelationshipFriend() {
		assertEquals(RelationshipEnum.FRIEND,RelationshipEnum.getRelationshipEnumByName("FRIEND"));
	}

}
