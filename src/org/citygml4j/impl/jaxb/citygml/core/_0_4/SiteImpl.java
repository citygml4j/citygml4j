package org.citygml4j.impl.jaxb.citygml.core._0_4;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml._0_4._SiteType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.Site;

public abstract class SiteImpl extends CityObjectImpl implements Site {
	private _SiteType site;

	public SiteImpl(_SiteType site) {
		super(site);
		this.site = site;
	}

	@Override
	public _SiteType getJAXBObject() {
		return site;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SITE;
	}

	@Override
	public CityGMLModule getCityGMLModule() {
		return CoreModule.v0_4_0;
	}

	public void addGenericApplicationPropertyOfSite(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			site.get_GenericApplicationPropertyOfSite().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfSite() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : site.get_GenericApplicationPropertyOfSite()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfSite(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			site.unset_GenericApplicationPropertyOfSite();
			site.get_GenericApplicationPropertyOfSite().addAll(elemList);
		}
	}

	public boolean isSetGenericApplicationPropertyOfSite() {
		return site.isSet_GenericApplicationPropertyOfSite();
	}

	public void unsetGenericApplicationPropertyOfSite() {
		site.unset_GenericApplicationPropertyOfSite();
	}

}
