package org.citygml4j.model.gml.geometry.aggregates;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.SolidArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;

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
