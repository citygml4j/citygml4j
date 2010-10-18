/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.citygml.core;

import java.util.GregorianCalendar;
import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.gml.feature.AbstractFeature;

public interface AbstractCityObject extends CoreModuleComponent, AbstractFeature {
	public GregorianCalendar getCreationDate();
	public GregorianCalendar getTerminationDate();
	public List<ExternalReference> getExternalReference();
	public List<AbstractGenericAttribute> getGenericAttribute();
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

	public LodRepresentation getLodRepresentation();
	
	public void setCreationDate(GregorianCalendar creationDate);
	public void setTerminationDate(GregorianCalendar terminationDate);
	public void setGenericAttribute(List<AbstractGenericAttribute> genericAttribute);
	public void addGenericAttribute(AbstractGenericAttribute genericAttribute);
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
	public boolean unsetGenericAttribute(AbstractGenericAttribute genericAttribute);
	public void unsetGeneralizesTo();
	public boolean unsetGeneralizesTo(GeneralizationRelation generalizesTo);
	public void unsetAppearance();
	public boolean unsetAppearance(AppearanceProperty appearance);
	public void unsetGenericApplicationPropertyOfCityObject();
	public boolean unsetGenericApplicationPropertyOfCityObject(ADEComponent ade);
}
