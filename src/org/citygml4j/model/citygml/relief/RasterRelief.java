package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface RasterRelief extends AbstractReliefComponent {
	public GridProperty getGrid();
	public List<ADEComponent> getGenericApplicationPropertyOfRasterRelief();
	public boolean isSetGrid();
	public boolean isSetGenericApplicationPropertyOfRasterRelief();
	
	public void setGrid(GridProperty grid);
	public void addGenericApplicationPropertyOfRasterRelief(ADEComponent ade);
	public void setGenericApplicationPropertyOfRasterRelief(List<ADEComponent> ade);
	public void unsetGrid();
	public void unsetGenericApplicationPropertyOfRasterRelief();
	public boolean unsetGenericApplicationPropertyOfRasterRelief(ADEComponent ade);
}
