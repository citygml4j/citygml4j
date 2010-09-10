package org.citygml4j.model.citygml.relief;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface ReliefComponentProperty extends ReliefModuleComponent, FeatureProperty<AbstractReliefComponent> {
	public AbstractReliefComponent getReliefComponent();
	public boolean isSetReliefComponent();
	
	public void setReliefComponent(AbstractReliefComponent reliefComponent);
	public void unsetReliefComponent();
}
