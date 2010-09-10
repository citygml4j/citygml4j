package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface TINRelief extends AbstractReliefComponent {
	public TinProperty getTin();
	public List<ADEComponent> getGenericApplicationPropertyOfTinRelief();
	public boolean isSetTin();
	public boolean isSetGenericApplicationPropertyOfTinRelief();

	public void setTin(TinProperty tin);	
	public void addGenericApplicationPropertyOfTinRelief(ADEComponent ade);
	public void setGenericApplicationPropertyOfTinRelief(List<ADEComponent> ade);
	public void unsetTin();
	public void unsetGenericApplicationPropertyOfTinRelief();
	public boolean unsetGenericApplicationPropertyOfTinRelief(ADEComponent ade);
}
