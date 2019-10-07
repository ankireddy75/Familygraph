package com.wundermancommerce.interviewtests.graph.model;

public class Relationship { 

	private String persion1Email;
	private RelationshipEnum relationship;
	private String persion2Email;
	
	public Relationship() {
		
	}
	
	public Relationship(String persion1Email, RelationshipEnum relationship, String persion2Email) {
		super();
		this.persion1Email = persion1Email;
		this.relationship = relationship;
		this.persion2Email = persion2Email;
	}
	public String getPersion1Email() {
		return persion1Email;
	}
	public void setPersion1Email(String persion1Email) {
		this.persion1Email = persion1Email;
	}
	public RelationshipEnum getRelationship() {
		return relationship;
	}
	public void setRelationship(RelationshipEnum relationship) {
		this.relationship = relationship;
	}
	public String getPersion2Email() {
		return persion2Email;
	}
	public void setPersion2Email(String persion2Email) {
		this.persion2Email = persion2Email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((persion1Email == null) ? 0 : persion1Email.hashCode());
		result = prime * result + ((persion2Email == null) ? 0 : persion2Email.hashCode());
		result = prime * result + ((relationship == null) ? 0 : relationship.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relationship other = (Relationship) obj;
		if (persion1Email == null) {
			if (other.persion1Email != null)
				return false;
		} else if (!persion1Email.equals(other.persion1Email))
			return false;
		if (persion2Email == null) {
			if (other.persion2Email != null)
				return false;
		} else if (!persion2Email.equals(other.persion2Email))
			return false;
		if (relationship != other.relationship)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Relationship [persion1Email=" + persion1Email + ", relationship=" + relationship + ", persion2Email="
				+ persion2Email + "]";
	}
	
	

}
