package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSolidType;
import org.citygml4j.jaxb.gml._3_1_1.SolidPropertyType;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SolidProperty;

public class CompositeSolidImpl extends AbstractSolidImpl implements CompositeSolid {
	private CompositeSolidType compositeSolidType;

	public CompositeSolidImpl() {
		this(new CompositeSolidType());
	}

	public CompositeSolidImpl(CompositeSolidType compositeSolidType) {
		super(compositeSolidType);
		this.compositeSolidType = compositeSolidType;
	}

	@Override
	public CompositeSolidType getJAXBObject() {
		return compositeSolidType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITESOLID;
	}

	@Override
	public List<SolidProperty> getSolidMember() {
		List<SolidProperty> solidPropertyList = new ArrayList<SolidProperty>();

		for (SolidPropertyType solidPropertyType : compositeSolidType.getSolidMember())
			solidPropertyList.add(new SolidPropertyImpl(solidPropertyType));

		return solidPropertyList;
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (isSetSolidMember()) {
			for (SolidProperty solidProperty : getSolidMember()) {
				AbstractSolid abstractSolid = solidProperty.getSolid();
				if (abstractSolid != null)
					abstractSolid.calcBoundingBox(min, max);
			}
		}
	}

	@Override
	public void addSolidMember(SolidProperty solidMember) {
		compositeSolidType.getSolidMember().add(((SolidPropertyImpl)solidMember).getJAXBObject());
	}

	@Override
	public void setSolidMember(List<SolidProperty> solidMember) {
		List<SolidPropertyType> solidPropertyList = new ArrayList<SolidPropertyType>();

		for (SolidProperty solidProperty : solidMember)
			solidPropertyList.add(((SolidPropertyImpl)solidProperty).getJAXBObject());

		compositeSolidType.unsetSolidMember();
		compositeSolidType.getSolidMember().addAll(solidPropertyList);
	}

	@Override
	public boolean isSetSolidMember() {
		return compositeSolidType.isSetSolidMember();
	}

	@Override
	public void unsetSolidMember() {
		compositeSolidType.unsetSolidMember();
	}

	@Override
	public boolean unsetSolidMember(SolidProperty solidMember) {
		if (compositeSolidType.isSetSolidMember())
			return compositeSolidType.getSolidMember().remove(((SolidPropertyImpl)solidMember).getJAXBObject());

		return false;
	}

}
