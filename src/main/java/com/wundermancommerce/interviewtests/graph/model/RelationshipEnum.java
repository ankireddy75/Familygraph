package com.wundermancommerce.interviewtests.graph.model;

public enum RelationshipEnum {
	FAMILY,
	FRIEND;
	
	
	public static RelationshipEnum getRelationshipEnumByName(String relationshipName) {

			for(RelationshipEnum relationshipEnum:RelationshipEnum.values()) {
				if(relationshipEnum.name().equalsIgnoreCase(relationshipName)) {
					return relationshipEnum;
				}
			}
			return null;
		}

}
