package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
import org.citygml4j.model.gml.feature.AbstractFeatureCollection;

public interface CityModel extends CoreModuleComponent, AbstractFeatureCollection {
	public List<CityObjectMember> getCityObjectMember();
	public List<AppearanceMember> getAppearanceMember();
	public List<ADEComponent> getGenericApplicationPropertyOfCityModel();
	public boolean isSetCityObjectMember();
	public boolean isSetAppearanceMember();
	public boolean isSetGenericApplicationPropertyOfCityModel();

	public void addCityObjectMember(CityObjectMember cityObjectMember);
	public void setCityObjectMember(List<CityObjectMember> cityObjectMember);
	public void addAppearanceMember(AppearanceMember appearanceMember);	
	public void setAppearanceMember(List<AppearanceMember> appearanceMember);	
	public void addGenericApplicationPropertyOfCityModel(ADEComponent ade);
	public void setGenericApplicationPropertyOfCityModel(List<ADEComponent> ade);
	public void unsetCityObjectMember();
	public boolean unsetCityObjectMember(CityObjectMember cityObjectMember);
	public void unsetAppearanceMember();
	public boolean unsetAppearanceMember(AppearanceMember appearanceMember);
	public void unsetGenericApplicationPropertyOfCityModel();
	public boolean unsetGenericApplicationPropertyOfCityModel(ADEComponent ade);
}
