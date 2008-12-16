package org.citygml4j.model.gml;

import java.util.List;

public interface MultiSolid extends AbstractGeometricAggregate {
	public List<SolidProperty> getSolidMember();
	public SolidArrayProperty getSolidMembers();
	public boolean isSetSolidMember();
	public boolean isSetSolidMembers();

	public void setSolidMember(List<SolidProperty> solidMember);
	public void addSolidMember(SolidProperty solidMember);
	public void setSolidMembers(SolidArrayProperty solidMembers);
	public void unsetSolidMember();
	public boolean unsetSolidMember(SolidProperty solidMember);
	public void unsetSolidMembers();
}
