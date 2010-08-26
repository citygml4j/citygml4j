package org.citygml4j.impl.citygml.core;

import java.util.GregorianCalendar;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.AbstractFeatureImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ExternalReference;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.generics.AbstractGenericAttribute;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.module.citygml.CityGMLModule;

public abstract class AbstractCityObjectImpl extends AbstractFeatureImpl implements AbstractCityObject {
	private GregorianCalendar creationDate;
	private GregorianCalendar terminationDate;
	private List<ExternalReference> externalReference;
	private List<AbstractGenericAttribute> genericAttribute;
	private List<GeneralizationRelation> generalizesTo;
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

	public GregorianCalendar getCreationDate() {
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

	public GregorianCalendar getTerminationDate() {
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

	public boolean isSetTerminationDate() {
		return terminationDate != null;
	}

	public void setAppearance(List<AppearanceProperty> appearance) {
		this.appearance = new ChildList<AppearanceProperty>(this, appearance);
	}

	public void setCreationDate(GregorianCalendar creationDate) {
		this.creationDate = creationDate;
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

	public void setTerminationDate(GregorianCalendar terminationDate) {
		this.terminationDate = terminationDate;
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

	public void unsetTerminationDate() {
		terminationDate = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACT_CITY_OBJECT;
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
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractCityObject copy = (AbstractCityObject)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetCreationDate())
			copy.setCreationDate((GregorianCalendar)copyBuilder.copy(creationDate));
		
		if (isSetTerminationDate())
			copy.setTerminationDate((GregorianCalendar)copyBuilder.copy(terminationDate));
		
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
