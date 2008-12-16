package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.AppearanceMember;

public class AppearanceMemberImpl extends AppearancePropertyImpl implements AppearanceMember {
	private AppearancePropertyType appearancePropertyType;

	public AppearanceMemberImpl() {
		this(new AppearancePropertyType());
	}

	public AppearanceMemberImpl(AppearancePropertyType appearancePropertyType) {
		super(appearancePropertyType);
		this.appearancePropertyType = appearancePropertyType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.APPEARANCEMEMBER;
	}

	@Override
	public AppearancePropertyType getJAXBObject() {
		return appearancePropertyType;
	}
}
