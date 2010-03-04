package org.citygml4j.model.citygml.core;

import java.util.GregorianCalendar;
import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.generics.GenericAttribute;
import org.citygml4j.model.gml.AbstractFeature;

public interface CityObject extends CoreModuleComponent, AbstractFeature {
	public GregorianCalendar getCreationDate();
	public GregorianCalendar getTerminationDate();
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

	public void setCreationDate(GregorianCalendar creationDate);
	public void setTerminationDate(GregorianCalendar terminationDate);
	public void setGenericAttribute(List<GenericAttribute> genericAttribute);
	public void addGenericAttribute(GenericAttribute genericAttribute);
	public void setExternalReference(List<ExternalReference> externalReference);
	public void addExternalReference(ExternalReference externalReference);
	public void setGeneralizesTo(List<GeneralizationRelation> generalizesTo);
	public void addGeneralizesTo(GeneralizationRelation generalizesTo);
	public void setAppearance(List<AppearanceProperty> appearance);
	public void addAppearance(AppearanceProperty appearance);	
	public void addGenericApplicationPropertyOfCityObject(ADEComponent ade);
	public void setGenericApplicationPropertyOfCityObject(List<ADEComponent> ade);
	public void unsetCreationDate();
	public void unsetTerminationDate();
	public void unsetExternalReference();
	public boolean unsetExternalReference(ExternalReference externalReference);
	public void unsetGenericAttribute();
	public boolean unsetGenericAttribute(GenericAttribute genericAttribute);
	public void unsetGeneralizesTo();
	public boolean unsetGeneralizesTo(GeneralizationRelation generalizesTo);
	public void unsetAppearance();
	public boolean unsetAppearance(AppearanceProperty appearance);
	public void unsetGenericApplicationPropertyOfCityObject();
	public boolean unsetGenericApplicationPropertyOfCityObject(ADEComponent ade);
}
