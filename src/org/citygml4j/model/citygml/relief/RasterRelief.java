package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface RasterRelief extends ReliefComponent {
	public List<ADEComponent> getGenericApplicationPropertyOfRasterRelief();
	public boolean isSetGenericApplicationPropertyOfRasterRelief();
	
	public void addGenericApplicationPropertyOfRasterRelief(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfRasterRelief(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfRasterRelief();
	public boolean unsetGenericApplicationPropertyOfRasterRelief(ADEComponent adeObject);
}
