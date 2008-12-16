package org.citygml4j.model.citygml.core;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.generics.GenericAttribute;
import org.citygml4j.model.gml.AbstractFeature;

public interface CityObject extends CityGMLBase, AbstractFeature {
	public XMLGregorianCalendar getCreationDate();
	public XMLGregorianCalendar getTerminationDate();
	public List<ExternalReference> getExternalReference();
	public List<GenericAttribute> getGenericAttribute();
	public List<GeneralizationRelation> getGeneralizesTo();
	public List<AppearanceProperty> getAppearance();
	public List<ADEComponent> getGenericApplicationPropertyOfCityObject();
	public boolean isSetCreationDate();
	public boolean isSetTerminationDate();
	public boolean isSetExternalReference();
	public boolean isSetGenericAttribute();
	public boolean isSetGeneralizesTo();
	public boolean isSetAppearance();
	public boolean isSetGenericApplicationPropertyOfCityObject();

	public void setCreationDate(XMLGregorianCalendar creationDate);
	public void setTerminationDate(XMLGregorianCalendar terminationDate);
	public void setGenericAttribute(List<GenericAttribute> genericAttribute);
	public void addGenericAttribute(GenericAttribute genericAttribute);
	public void setExternalReference(List<ExternalReference> externalReference);
	public void addExternalReference(ExternalReference externalReference);
	public void setGeneralizesTo(List<GeneralizationRelation> generalizesTo);
	public void addGeneralizesTo(GeneralizationRelation generalizesTo);
	public void setAppearance(List<AppearanceProperty> appearance);
	public void addAppearance(AppearanceProperty appearanceMember);	
	public void addGenericApplicationPropertyOfCityObject(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfCityObject(List<ADEComponent> adeObject);
	public void unsetCreationDate();
	public void unsetTerminationDate();
	public void unsetExternalReference();
	public boolean unsetExternalReference(ExternalReference externalReference);
	public void unsetGenericAttribute();
	public boolean unsetGenericAttribute(GenericAttribute genericAttribute);
	public void unsetGeneralizesTo();
	public boolean unsetGeneralizesTo(GeneralizationRelation generalizesTo);
	public void unsetAppearance();
	public boolean unsetAppearance(AppearanceProperty appearanceMember);
	public void unsetGenericApplicationPropertyOfCityObject();
	public boolean unsetGenericApplicationPropertyOfCityObject(ADEComponent adeObject);
}
