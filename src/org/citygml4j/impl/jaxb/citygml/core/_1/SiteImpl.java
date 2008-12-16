package org.citygml4j.impl.jaxb.citygml.core._1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.jaxb.citygml.core._1.AbstractSiteType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.Site;

public abstract class SiteImpl extends CityObjectImpl implements Site {
	private AbstractSiteType site;

	public SiteImpl(AbstractSiteType site) {
		super(site);
		this.site = site;
	}

	@Override
	public AbstractSiteType getJAXBObject() {
		return site;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.SITE;
	}
	
	@Override
	public CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}
	
	@Override
	public void addGenericApplicationPropertyOfSite(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			site.get_GenericApplicationPropertyOfSite().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfSite() {
		if (site.isSet_GenericApplicationPropertyOfSite()) {
			List<ADEComponent> adeList = new ArrayList<ADEComponent>();
			List<JAXBElement<?>> elemList = site.get_GenericApplicationPropertyOfSite();
			
			for (JAXBElement<?> elem : elemList) {
				if (elem.getValue() != null) {
					ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
					if (ade != null)
						adeList.add(ade);
				}
			}
			
			if (!adeList.isEmpty())
				return adeList;
		}
		
		return null;
	}

	@Override
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
	
	@Override
	public boolean isSetGenericApplicationPropertyOfSite() {
		return site.isSet_GenericApplicationPropertyOfSite();
	}

	@Override
	public void unsetGenericApplicationPropertyOfSite() {
		site.unset_GenericApplicationPropertyOfSite();
	}
}
