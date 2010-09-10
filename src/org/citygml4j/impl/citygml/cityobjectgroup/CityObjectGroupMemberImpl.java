package org.citygml4j.impl.citygml.cityobjectgroup;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;

public class CityObjectGroupMemberImpl extends FeaturePropertyImpl<AbstractCityObject> implements CityObjectGroupMember {
	private String groupRole;
	private CityObjectGroupModule module;
	
	public CityObjectGroupMemberImpl() {
		
	}
	
	public CityObjectGroupMemberImpl(CityObjectGroupModule module) {
		this.module = module;
	}
	
	public AbstractCityObject getCityObject() {
		return super.getObject();
	}

	public boolean isSetCityObject() {
		return super.isSetObject();
	}

	public void setCityObject(AbstractCityObject cityObject) {
		super.setObject(cityObject);
	}

	public void unsetCityObject() {
		super.unsetObject();
	}

	public String getGroupRole() {
		return groupRole;
	}

	public boolean isSetGroupRole() {
		return groupRole != null;
	}

	public void setGroupRole(String groupRole) {
		this.groupRole = groupRole;
	}

	public void unsetGroupRole() {
		groupRole = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITY_OBJECT_GROUP_MEMBER;
	}

	public final CityObjectGroupModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CityObjectGroupMemberImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CityObjectGroupMember copy = (target == null) ? new CityObjectGroupMemberImpl() : (CityObjectGroupMember)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetGroupRole())
			copy.setGroupRole(copyBuilder.copy(groupRole));
		
		return copy;
	}

}
