/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public abstract class AbstractCityObject extends AbstractFeature implements CoreModuleComponent {
	private ZonedDateTime creationDate;
	private ZonedDateTime terminationDate;
	private List<ExternalReference> externalReference;
	private List<AbstractGenericAttribute> genericAttribute;
	private List<GeneralizationRelation> generalizesTo;
	private RelativeToTerrain relativeToTerrain;
	private RelativeToWater relativeToWater;
	private List<AppearanceProperty> appearance;
	private List<ADEComponent> ade;
	
	public void addAppearance(AppearanceProperty appearance) {
		if (this.appearance == null)
			this.appearance = new ChildList<AppearanceProperty>(this);
		
		this.appearance.add(appearance);
	}

	public void addExternalReference(ExternalReference externalReference) {
		if (this.externalReference == null)
			this.externalReference = new ChildList<ExternalReference>(this);
		
		this.externalReference.add(externalReference);
	}

	public void addGeneralizesTo(GeneralizationRelation generalizesTo) {
		if (this.generalizesTo == null)
			this.generalizesTo = new ChildList<GeneralizationRelation>(this);
		
		this.generalizesTo.add(generalizesTo);
	}

	public void addGenericApplicationPropertyOfCityObject(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addGenericAttribute(AbstractGenericAttribute genericAttribute) {
		if (this.genericAttribute == null)
			this.genericAttribute = new ChildList<AbstractGenericAttribute>(this);
		
		this.genericAttribute.add(genericAttribute);
	}

	public List<AppearanceProperty> getAppearance() {
		if (appearance == null)
			appearance = new ChildList<AppearanceProperty>(this);

		return appearance;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public List<ExternalReference> getExternalReference() {
		if (externalReference == null)
			externalReference = new ChildList<ExternalReference>(this);

		return externalReference;
	}

	public List<GeneralizationRelation> getGeneralizesTo() {
		if (generalizesTo == null)
			generalizesTo = new ChildList<GeneralizationRelation>(this);

		return generalizesTo;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfCityObject() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<AbstractGenericAttribute> getGenericAttribute() {
		if (genericAttribute == null)
			genericAttribute = new ChildList<AbstractGenericAttribute>(this);

		return genericAttribute;
	}

	public RelativeToTerrain getRelativeToTerrain() {
		return relativeToTerrain;
	}

	public RelativeToWater getRelativeToWater() {
		return relativeToWater;
	}

	public ZonedDateTime getTerminationDate() {
		return terminationDate;
	}

	public boolean isSetAppearance() {
		return appearance != null && !appearance.isEmpty();
	}

	public boolean isSetCreationDate() {
		return creationDate != null;
	}

	public boolean isSetExternalReference() {
		return externalReference != null && !externalReference.isEmpty();
	}

	public boolean isSetGeneralizesTo() {
		return generalizesTo != null && !generalizesTo.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfCityObject() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetGenericAttribute() {
		return genericAttribute != null && !genericAttribute.isEmpty();
	}

	public boolean isSetRelativeToTerrain() {
		return relativeToTerrain != null;
	}

	public boolean isSetRelativeToWater() {
		return relativeToWater != null;
	}

	public boolean isSetTerminationDate() {
		return terminationDate != null;
	}

	public void setAppearance(List<AppearanceProperty> appearance) {
		this.appearance = new ChildList<AppearanceProperty>(this, appearance);
	}

	public void setCreationDate(ZonedDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate.atZone(ZoneId.systemDefault());
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate.atStartOfDay(ZoneId.systemDefault());
	}

	public void setExternalReference(List<ExternalReference> externalReference) {
		this.externalReference = new ChildList<ExternalReference>(this, externalReference);
	}

	public void setGeneralizesTo(List<GeneralizationRelation> generalizesTo) {
		this.generalizesTo = new ChildList<GeneralizationRelation>(this, generalizesTo);
	}

	public void setGenericApplicationPropertyOfCityObject(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setGenericAttribute(List<AbstractGenericAttribute> genericAttribute) {
		this.genericAttribute = new ChildList<AbstractGenericAttribute>(this, genericAttribute);
	}

	public void setRelativeToTerrain(RelativeToTerrain relativeToTerrain) {
		this.relativeToTerrain = relativeToTerrain;
	}

	public void setRelativeToWater(RelativeToWater relativeToWater) {
		this.relativeToWater = relativeToWater;
	}

	public void setTerminationDate(ZonedDateTime terminationDate) {
		this.terminationDate = terminationDate;
	}

	public void setTerminationDate(LocalDateTime terminationDate) {
		this.terminationDate = terminationDate.atZone(ZoneId.systemDefault());
	}

	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate.atStartOfDay(ZoneId.systemDefault());
	}

	public void unsetAppearance() {
		if (isSetAppearance())
			appearance.clear();

		appearance = null;
	}

	public boolean unsetAppearance(AppearanceProperty appearance) {
		return isSetAppearance() ? this.appearance.remove(appearance) : false;
	}

	public void unsetCreationDate() {
		creationDate = null;
	}

	public void unsetExternalReference() {
		if (isSetExternalReference())
			externalReference.clear();

		externalReference = null;
	}

	public boolean unsetExternalReference(ExternalReference externalReference) {
		return isSetExternalReference() ? this.externalReference.remove(externalReference) : false;
	}

	public void unsetGeneralizesTo() {
		if (isSetGeneralizesTo())
			generalizesTo.clear();

		generalizesTo = null;
	}

	public boolean unsetGeneralizesTo(GeneralizationRelation generalizesTo) {
		return isSetGeneralizesTo() ? this.generalizesTo.remove(generalizesTo) : false;
	}

	public void unsetGenericApplicationPropertyOfCityObject() {
		if (isSetGenericApplicationPropertyOfCityObject())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfCityObject(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfCityObject() ? this.ade.remove(ade) : false;
	}

	public void unsetGenericAttribute() {
		if (isSetGenericAttribute())
			genericAttribute.clear();

		genericAttribute = null;
	}

	public boolean unsetGenericAttribute(AbstractGenericAttribute genericAttribute) {
		return isSetGenericAttribute() ? this.genericAttribute.remove(genericAttribute) : false;
	}

	public void unsetRelativeToTerrain() {
		relativeToTerrain = null;
	}

	public void unsetRelativeToWater() {
		relativeToWater = null;
	}

	public void unsetTerminationDate() {
		terminationDate = null;
	}

	public CityGMLModule getCityGMLModule() {
		// return null by default 
		return null;
	}

	public boolean isSetCityGMLModule() {
		// return false by default
		return false;
	}

	public LodRepresentation getLodRepresentation() {
		// return empty LodRepresentation instance by default
		return new LodRepresentation();
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfCityObject()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractCityObject copy = (AbstractCityObject)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetCreationDate())
			copy.setCreationDate((ZonedDateTime)copyBuilder.copy(creationDate));
		
		if (isSetTerminationDate())
			copy.setTerminationDate((ZonedDateTime)copyBuilder.copy(terminationDate));
		
		if (isSetRelativeToTerrain())
			copy.setRelativeToTerrain((RelativeToTerrain)copyBuilder.copy(relativeToTerrain));
		
		if (isSetRelativeToWater())
			copy.setRelativeToWater((RelativeToWater)copyBuilder.copy(relativeToWater));
		
		if (isSetExternalReference()) {
			for (ExternalReference part : externalReference) {
				ExternalReference copyPart = (ExternalReference)copyBuilder.copy(part);
				copy.addExternalReference(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericAttribute()) {
			for (AbstractGenericAttribute part : genericAttribute) {
				AbstractGenericAttribute copyPart = (AbstractGenericAttribute)copyBuilder.copy(part);
				copy.addGenericAttribute(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGeneralizesTo()) {
			for (GeneralizationRelation part : generalizesTo) {
				GeneralizationRelation copyPart = (GeneralizationRelation)copyBuilder.copy(part);
				copy.addGeneralizesTo(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetAppearance()) {
			for (AppearanceProperty part : appearance) {
				AppearanceProperty copyPart = (AppearanceProperty)copyBuilder.copy(part);
				copy.addAppearance(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfCityObject(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
}
