package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.gml._3_1_1.FeaturePropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType;
import org.citygml4j.jaxb.citygml._0_4.AppearanceType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.gml.AbstractFeature;

public class AppearancePropertyImpl extends FeaturePropertyImpl implements AppearanceProperty {
	private AppearancePropertyType appearancePropertyType;

	public AppearancePropertyImpl() {
		this(new AppearancePropertyType());
	}

	public AppearancePropertyImpl(AppearancePropertyType appearancePropertyType) {
		super(appearancePropertyType);
		this.appearancePropertyType = appearancePropertyType;
	}

	@Override
	public AbstractFeature getFeature() {
		if (appearancePropertyType.isSet_Feature()) {
			JAXBElement<? extends AbstractFeatureType> abstractFeatureType = appearancePropertyType.get_Feature();

			if (abstractFeatureType.getValue() != null && abstractFeatureType.getValue() instanceof AppearanceType)
				return new AppearanceImpl((AppearanceType)abstractFeatureType.getValue());
		}

		return null;
	}

	@Override
	public void setFeature(AbstractFeature abstractFeature) {
		// we will not set anything else than an appearance element
		if (abstractFeature instanceof Appearance)
			setAppearance((Appearance)abstractFeature);
	}

	public Appearance getAppearance() {
		if (appearancePropertyType.isSetAppearance())
			return new AppearanceImpl(appearancePropertyType.getAppearance());

		return null;
	}

	public void setAppearance(Appearance appearance) {
		appearancePropertyType.setAppearance(((AppearanceImpl)appearance).getJAXBObject());
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.APPEARANCEPROPERTY;
	}

	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}

	@Override
	public AppearancePropertyType getJAXBObject() {
		return appearancePropertyType;
	}

	public boolean isSetAppearance() {
		return appearancePropertyType.isSetAppearance();
	}

	public void unsetAppearance() {
		appearancePropertyType.setAppearance(null);
	}

}
