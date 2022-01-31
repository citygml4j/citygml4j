/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.SpatialRepresentation;
import org.citygml4j.model.module.Module;
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

	public AbstractCityObject() {

	}

	public AbstractCityObject(Module module) {
		super(module);
	}
	
	public void addAppearance(AppearanceProperty appearance) {
		getAppearance().add(appearance);
	}

	public void addExternalReference(ExternalReference externalReference) {
		getExternalReference().add(externalReference);
	}

	public void addGeneralizesTo(GeneralizationRelation generalizesTo) {
		getGeneralizesTo().add(generalizesTo);
	}

	public void addGenericApplicationPropertyOfCityObject(ADEComponent ade) {
		getGenericApplicationPropertyOfCityObject().add(ade);
	}

	public void addGenericAttribute(AbstractGenericAttribute genericAttribute) {
		getGenericAttribute().add(genericAttribute);
	}

	public List<AppearanceProperty> getAppearance() {
		if (appearance == null)
			appearance = new ChildList<>(this);

		return appearance;
	}

	public ZonedDateTime getCreationDate() {
		return creationDate;
	}

	public List<ExternalReference> getExternalReference() {
		if (externalReference == null)
			externalReference = new ChildList<>(this);

		return externalReference;
	}

	public List<GeneralizationRelation> getGeneralizesTo() {
		if (generalizesTo == null)
			generalizesTo = new ChildList<>(this);

		return generalizesTo;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfCityObject() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public List<AbstractGenericAttribute> getGenericAttribute() {
		if (genericAttribute == null)
			genericAttribute = new ChildList<>(this);

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
		this.appearance = new ChildList<>(this, appearance);
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
		this.externalReference = new ChildList<>(this, externalReference);
	}

	public void setGeneralizesTo(List<GeneralizationRelation> generalizesTo) {
		this.generalizesTo = new ChildList<>(this, generalizesTo);
	}

	public void setGenericApplicationPropertyOfCityObject(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setGenericAttribute(List<AbstractGenericAttribute> genericAttribute) {
		this.genericAttribute = new ChildList<>(this, genericAttribute);
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
		appearance = ModelObjects.setNull(appearance);
	}

	public boolean unsetAppearance(AppearanceProperty appearance) {
		return isSetAppearance() && this.appearance.remove(appearance);
	}

	public void unsetCreationDate() {
		creationDate = null;
	}

	public void unsetExternalReference() {
		externalReference = ModelObjects.setNull(externalReference);
	}

	public boolean unsetExternalReference(ExternalReference externalReference) {
		return isSetExternalReference() && this.externalReference.remove(externalReference);
	}

	public void unsetGeneralizesTo() {
		generalizesTo = ModelObjects.setNull(generalizesTo);
	}

	public boolean unsetGeneralizesTo(GeneralizationRelation generalizesTo) {
		return isSetGeneralizesTo() && this.generalizesTo.remove(generalizesTo);
	}

	public void unsetGenericApplicationPropertyOfCityObject() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfCityObject(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfCityObject() && this.ade.remove(ade);
	}

	public void unsetGenericAttribute() {
		genericAttribute = ModelObjects.setNull(genericAttribute);
	}

	public boolean unsetGenericAttribute(AbstractGenericAttribute genericAttribute) {
		return isSetGenericAttribute() && this.genericAttribute.remove(genericAttribute);
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

	@Override
	public final SpatialRepresentation getSpatialRepresentation() {
		return getLodRepresentation();
	}

	public LodRepresentation getLodRepresentation() {
		// return an empty spatial representation per default
		return LodRepresentation.emptyRepresentation();
	}

	public void unsetLod(int lod) {
		LodRepresentation representation = getLodRepresentation();
		if (representation != null && representation.isSetRepresentation(lod)) {
			for (AssociationByRepOrRef<?> property : representation.getRepresentation(lod)) {
				ModelObject parent = property.getParent();
				ModelObjects.unsetProperty(parent != null ? parent : this, property);
			}
		}
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		if (isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfCityObject()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, options).getEnvelope());
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
