package org.citygml4j.impl.citygml.appearance;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.module.citygml.AppearanceModule;

public class AppearancePropertyImpl extends FeaturePropertyImpl<Appearance> implements AppearanceProperty {
	private AppearanceModule module;
	
	public AppearancePropertyImpl() {

	}
	
	public AppearancePropertyImpl(AppearanceModule module) {
		this.module = module;
	}
	
	public Appearance getAppearance() {
		return super.getFeature();
	}

	public boolean isSetAppearance() {
		return super.isSetFeature();
	}

	public void setAppearance(Appearance appearance) {
		super.setFeature(appearance);
	}

	public void unsetAppearance() {
		super.unsetFeature();
	}
	
	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.APPEARANCE_PROPERTY;
	}

	public final AppearanceModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new AppearancePropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		AppearanceProperty copy = (target == null) ? new AppearancePropertyImpl() : (AppearanceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
