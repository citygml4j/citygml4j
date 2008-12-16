package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.gml.AbstractFeature;

public interface Appearance extends CityGMLBase, AbstractFeature {
	public String getTheme();
	public List<SurfaceDataProperty> getSurfaceDataMember();
	public List<ADEComponent> getGenericApplicationPropertyOfAppearance();
	public boolean isSetTheme();
	public boolean isSetSurfaceDataMember();
	public boolean isSetGenericApplicationPropertyOfAppearance();
	
	public void setTheme(String theme);
	public void setSurfaceDataMember(List<SurfaceDataProperty> surfaceDataMember);
	public void addSurfaceDataMember(SurfaceDataProperty surfaceDataMember);	
	public void addGenericApplicationPropertyOfAppearance(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfAppearance(List<ADEComponent> adeObject);
	public void unsetTheme();
	public void unsetSurfaceDataMember();
	public boolean unsetSurfaceDataMember(SurfaceDataProperty surfaceDataMember);
	public void unsetGenericApplicationPropertyOfAppearance();
	public boolean unsetGenericApplicationPropertyOfAppearance(ADEComponent adeObject);
}
