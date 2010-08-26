package org.citygml4j.impl.citygml.waterbody;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.citygml.core.AbstractCityObjectImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.waterbody.AbstractWaterObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.module.citygml.WaterBodyModule;

public abstract class AbstractWaterObjectImpl extends AbstractCityObjectImpl implements AbstractWaterObject {
	private List<ADEComponent> ade;
	private WaterBodyModule module;
	
	public AbstractWaterObjectImpl() {

	}

	public AbstractWaterObjectImpl(WaterBodyModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfWaterObject(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfWaterObject() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfWaterObject() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfWaterObject(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfWaterObject() {
		if (isSetGenericApplicationPropertyOfWaterObject())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfWaterObject(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfWaterObject() ? this.ade.remove(ade) : false;
	}

	public final WaterBodyModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACT_WATER_OBJECT;
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractWaterObject copy = (AbstractWaterObject)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfWaterObject()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfWaterObject(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}

}
