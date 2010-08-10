package org.citygml4j.model.gml.geometry.complexes;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;

public interface CompositeSolid extends AbstractSolid {
	public List<SolidProperty> getSolidMember();
	public boolean isSetSolidMember();

	public void setSolidMember(List<SolidProperty> solidMember);
	public void addSolidMember(SolidProperty solidMember);
	public void unsetSolidMember();
	public boolean unsetSolidMember(SolidProperty solidMember);
}
