package org.citygml4j.impl.citygml.transportation;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.citygml.core.AbstractCityObjectImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.module.citygml.TransportationModule;

public abstract class AbstractTransportationObjectImpl extends AbstractCityObjectImpl implements AbstractTransportationObject {
	private List<ADEComponent> ade;
	private TransportationModule module;
	
	public AbstractTransportationObjectImpl() {
		
	}
	
	public AbstractTransportationObjectImpl(TransportationModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfTransportationObject(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfTransportationObject() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public boolean isSetGenericApplicationPropertyOfTransportationObject() {
		return ade != null && !ade.isEmpty();
	}

	public void setGenericApplicationPropertyOfTransportationObject(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void unsetGenericApplicationPropertyOfTransportationObject() {
		if (isSetGenericApplicationPropertyOfTransportationObject())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfTransportationObject(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfTransportationObject() ? this.ade.remove(ade) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACT_TRANSPORTATION_OBJECT;
	}

	public final TransportationModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractTransportationObject copy = (AbstractTransportationObject)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetGenericApplicationPropertyOfTransportationObject()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfTransportationObject(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		return copy;
	}
	
}
