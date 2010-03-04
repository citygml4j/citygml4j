package org.citygml4j.impl.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.AssociationImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.Opening;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.module.citygml.BuildingModule;

public class OpeningPropertyImpl extends AssociationImpl<Opening> implements OpeningProperty {
	private BuildingModule module;
	
	public OpeningPropertyImpl() {
		
	}
	
	public OpeningPropertyImpl(BuildingModule module) {
		this.module = module;
	}
	
	public Opening getOpening() {
		return super.getObject();
	}

	public boolean isSetOpening() {
		return super.isSetObject();
	}

	public void setOpening(Opening opening) {
		super.setObject(opening);
	}

	public void unsetOpening() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.OPENINGPROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new OpeningPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		OpeningProperty copy = (target == null) ? new OpeningPropertyImpl() : (OpeningProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
