package org.citygml4j.model.gml.geometry;

public interface SRSReferenceGroup extends SRSInformationGroup {
	public String getSrsName();
	public Integer getSrsDimension();
	public boolean isSetSrsName();
	public boolean isSetSrsDimension();

	public void setSrsName(String srsName);
	public void setSrsDimension(Integer srsDimension);
	public void unsetSrsName();
	public void unsetSrsDimension();
}
