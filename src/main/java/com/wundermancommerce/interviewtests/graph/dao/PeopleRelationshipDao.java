package com.wundermancommerce.interviewtests.graph.dao;

import java.util.Set;

import com.wundermancommerce.interviewtests.graph.model.Person;
import com.wundermancommerce.interviewtests.graph.model.Relationship;

public interface PeopleRelationshipDao {
	 
	public Set<Person> getPeople();
	
	public Set<Relationship> getRelationships() ;
}
