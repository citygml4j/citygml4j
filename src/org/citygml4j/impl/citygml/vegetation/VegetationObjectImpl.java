package org.citygml4j.impl.citygml.vegetation;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.citygml.core.CityObjectImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.vegetation.VegetationObject;
import org.citygml4j.model.module.citygml.VegetationModule;

public abstract class VegetationObjectImpl extends CityObjectImpl implements VegetationObject {
	private List<ADEComponent> ade;
	private VegetationModule module;
	
	public VegetationObjectImpl() {
		
	}
	
	public VegetationObjectImpl(VegetationModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfVegetationObject(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfVegetationObject() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfVegetationObject() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfVegetationObject(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfVegetationObject() {
		if (isSetGenericApplicationPropertyOfVegetationObject())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfVegetationObject(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfVegetationObject() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.VEGETATIONOBJECT;
	}

	public final VegetationModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		VegetationObject copy = (VegetationObject)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfVegetationObject()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfVegetationObject(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;		
	}

}
