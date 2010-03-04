package org.citygml4j.model.citygml.relief;

import org.citygml4j.model.gml.Association;

public interface ReliefComponentProperty extends ReliefModuleComponent, Association<ReliefComponent> {
	public ReliefComponent getReliefComponent();
	public boolean isSetReliefComponent();
	
	public void setReliefComponent(ReliefComponent reliefComponent);
	public void unsetReliefComponent();
}
