package com.wundermancommerce.interviewtests.graph;

import java.util.Map;
import java.util.Set;

public interface FamilyGraph {
	

	/**
	 * Return Total people
	 * @return
	 */
	 public int getTotalPeople();
	
	 /**
	  * Return Total Relationships
	  * @return
	  */
	 
	 public int getTotalRelationships();
	
	 /**
	  * Return total Relations per Person
	  * @return
	  */
	 
	 public Integer getTotalPersonRelations(String personEmail);
	 
	 /**
	  * Return total Extended Family Relations
	  * @return
	  */
	 
	 public Integer getTotalPersonExtendedFamilyRelations(String personEmail);
	
	 /**
	 *Return All Relations per Person
	 * @param personEmail
	 * @return
	 */
	public Set<String> personAllRelations(String personEmail) ;
	
	/**
	 * Return All Person Relations by  Person
	 * @return
	 */

	public Map<String, Set<String>> allPersonAllRelations() ;
	
	/**
	 * Return ExtendedFamilyRelations per Person
	 * @param personEmail
	 * @return
	 */

	public Set<String> personExtendedFamilyRelations(String personEmail) ;


	/**
	 * Return all persons Extended Family Relations by  Person
	 * @return
	 */
	public Map<String, Set<String>> allPersonExtendedFamilyRelations() ;




}
