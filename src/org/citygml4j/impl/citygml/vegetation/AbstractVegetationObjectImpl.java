package org.citygml4j.impl.citygml.vegetation;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.citygml.core.AbstractCityObjectImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.vegetation.AbstractVegetationObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.module.citygml.VegetationModule;

public abstract class AbstractVegetationObjectImpl extends AbstractCityObjectImpl implements AbstractVegetationObject {
	private List<ADEComponent> ade;
	private VegetationModule module;
	
	public AbstractVegetationObjectImpl() {
		
	}
	
	public AbstractVegetationObjectImpl(VegetationModule module) {
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
		return CityGMLClass.ABSTRACT_VEGETATION_OBJECT;
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

		AbstractVegetationObject copy = (AbstractVegetationObject)target;		
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
