package org.citygml4j.impl.citygml.relief;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public class ReliefComponentPropertyImpl extends FeaturePropertyImpl<AbstractReliefComponent> implements ReliefComponentProperty {
	private ReliefModule module;
	
	public ReliefComponentPropertyImpl() {
		
	}
	
	public ReliefComponentPropertyImpl(ReliefModule module) {
		this.module = module;
	}
	
	public AbstractReliefComponent getReliefComponent() {
		return super.getObject();
	}

	public boolean isSetReliefComponent() {
		return super.isSetObject();
	}

	public void setReliefComponent(AbstractReliefComponent reliefComponent) {
		super.setObject(reliefComponent);
	}

	public void unsetReliefComponent() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.RELIEF_COMPONENT_PROPERTY;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ReliefComponentPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ReliefComponentProperty copy = (target == null) ? new ReliefComponentPropertyImpl() : (ReliefComponentProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
