package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;

public interface TINRelief extends ReliefComponent {
	public TinProperty getTin();
	public List<ADEComponent> getGenericApplicationPropertyOfTinRelief();
	public boolean isSetTin();
	public boolean isSetGenericApplicationPropertyOfTinRelief();

	public void setTin(TinProperty tin);	
	public void addGenericApplicationPropertyOfTinRelief(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfTinRelief(List<ADEComponent> adeObject);
	public void unsetTin();
	public void unsetGenericApplicationPropertyOfTinRelief();
	public boolean unsetGenericApplicationPropertyOfTinRelief(ADEComponent adeObject);
}
