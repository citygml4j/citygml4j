package org.citygml4j.builder.json.objects;

import java.util.Date;

public class TINReliefAttributes extends AbstractAttributes {
	private Date creationDate;
	private Date terminationDate;
	
	public boolean isSetCreationDate() {
		return creationDate != null;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public boolean isSetTerminationDate() {
		return terminationDate != null;
	}
	
	public Date getTerminationDate() {
		return terminationDate;
	}
	
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	
}
