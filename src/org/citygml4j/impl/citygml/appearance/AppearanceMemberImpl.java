package org.citygml4j.impl.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class AppearanceMemberImpl extends AppearancePropertyImpl implements AppearanceMember {

	public AppearanceMemberImpl() {
		
	}
	
	public AppearanceMemberImpl(AppearanceModule module) {
		super(module);
	}
	
	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.APPEARANCEMEMBER;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AppearanceMemberImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AppearanceMember copy = (target == null) ? new AppearanceMemberImpl() : (AppearanceMember)target;
		return super.copyTo(copy, copyBuilder);
	}

}
