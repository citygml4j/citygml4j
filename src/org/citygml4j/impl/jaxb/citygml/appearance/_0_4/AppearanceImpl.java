package org.citygml4j.impl.jaxb.citygml.appearance._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractFeatureImpl;
import org.citygml4j.jaxb.citygml._0_4.AppearanceType;
import org.citygml4j.jaxb.citygml._0_4.SurfaceDataPropertyType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceModule;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;

public class AppearanceImpl extends AbstractFeatureImpl implements Appearance {
	private AppearanceType appearanceType;

	public AppearanceImpl() {
		this(new AppearanceType());
	}

	public AppearanceImpl(AppearanceType appearanceType) {
		super(appearanceType);
		this.appearanceType = appearanceType;
	}

	@Override
	public AppearanceType getJAXBObject() {
		return appearanceType;
	}

	public String getTheme() {
		return appearanceType.getTheme();
	}

	public void setTheme(String theme) {
		appearanceType.setTheme(theme);
	}

	public void addSurfaceDataMember(SurfaceDataProperty surfaceDataMember) {
		appearanceType.getSurfaceDataMember().add(((SurfaceDataPropertyImpl)surfaceDataMember).getJAXBObject());
	}

	public List<SurfaceDataProperty> getSurfaceDataMember() {
		List<SurfaceDataProperty> surfaceDataPropList = new ArrayList<SurfaceDataProperty>();

		for (SurfaceDataPropertyType surfDataPropType : appearanceType.getSurfaceDataMember())
			surfaceDataPropList.add(new SurfaceDataPropertyImpl(surfDataPropType));

		return surfaceDataPropList;
	}

	public void setSurfaceDataMember(List<SurfaceDataProperty> surfaceDataMember) {
		List<SurfaceDataPropertyType> surfaceDataPropTypeList = new ArrayList<SurfaceDataPropertyType>();

		for (SurfaceDataProperty surfaceDataProp : surfaceDataMember)
			surfaceDataPropTypeList.add(((SurfaceDataPropertyImpl)surfaceDataProp).getJAXBObject());

		appearanceType.unsetSurfaceDataMember();
		appearanceType.getSurfaceDataMember().addAll(surfaceDataPropTypeList);
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.APPEARANCE;
	}

	public final CityGMLModule getCityGMLModule() {
		return AppearanceModule.v0_4_0;
	}

	@Override
	public void calcBoundedBy() {
		// we do not need this here?!
	}

	public void addGenericApplicationPropertyOfAppearance(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			appearanceType.get_GenericApplicationPropertyOfAppearance().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAppearance() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : appearanceType.get_GenericApplicationPropertyOfAppearance()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfAppearance(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			appearanceType.unset_GenericApplicationPropertyOfAppearance();
			appearanceType.get_GenericApplicationPropertyOfAppearance().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfAppearance() {
		return appearanceType.isSet_GenericApplicationPropertyOfAppearance();
	}

	public boolean isSetSurfaceDataMember() {
		return appearanceType.isSetSurfaceDataMember();
	}

	public boolean isSetTheme() {
		return appearanceType.isSetTheme();
	}

	public void unsetGenericApplicationPropertyOfAppearance() {
		appearanceType.unset_GenericApplicationPropertyOfAppearance();
	}

	public void unsetSurfaceDataMember() {
		appearanceType.unsetSurfaceDataMember();
	}

	public void unsetTheme() {
		appearanceType.setTheme(null);
	}

	public boolean unsetGenericApplicationPropertyOfAppearance(ADEComponent adeObject) {
		if (appearanceType.isSet_GenericApplicationPropertyOfAppearance()) {
			Iterator<JAXBElement<?>> iter = appearanceType.get_GenericApplicationPropertyOfAppearance().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}
		
		return false;
	}

	public boolean unsetSurfaceDataMember(SurfaceDataProperty surfaceDataMember) {
		if (appearanceType.isSetSurfaceDataMember())
			return appearanceType.getSurfaceDataMember().remove(((SurfaceDataPropertyImpl)surfaceDataMember).getJAXBObject());
		
		return false;
	}

}
