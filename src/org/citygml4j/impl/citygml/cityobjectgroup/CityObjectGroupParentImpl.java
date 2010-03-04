package org.citygml4j.impl.citygml.cityobjectgroup;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.AssociationImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;

public class CityObjectGroupParentImpl extends AssociationImpl<CityObject> implements CityObjectGroupParent {
	private CityObjectGroupModule module;
	
	public CityObjectGroupParentImpl() {
		
	}
	
	public CityObjectGroupParentImpl(CityObjectGroupModule module) {
		this.module = module;
	}
	
	public CityObject getCityObject() {
		return super.getObject();
	}

	public boolean isSetCityObject() {
		return super.isSetObject();
	}

	public void setCityObject(CityObject cityObject) {
		super.setObject(cityObject);
	}

	public void unsetCityObject() {
		super.unsetObject();
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITYOBJECTGROUPPARENT;
	}

	public final CityObjectGroupModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CityObjectGroupParentImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CityObjectGroupParent copy = (target == null) ? new CityObjectGroupParentImpl() : (CityObjectGroupParent)target;
		return super.copyTo(copy, copyBuilder);
	}

}
