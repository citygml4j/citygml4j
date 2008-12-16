package org.citygml4j.model.gml;

import java.util.List;

public interface CompositeSolid extends AbstractSolid {
	public List<SolidProperty> getSolidMember();
	public boolean isSetSolidMember();

	public void setSolidMember(List<SolidProperty> solidMember);
	public void addSolidMember(SolidProperty solidMember);
	public void unsetSolidMember();
	public boolean unsetSolidMember(SolidProperty solidMember);
}
