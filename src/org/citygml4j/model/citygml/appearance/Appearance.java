package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.feature.AbstractFeature;

public interface Appearance extends AppearanceModuleComponent, AbstractFeature {
	public String getTheme();
	public List<SurfaceDataProperty> getSurfaceDataMember();
	public List<ADEComponent> getGenericApplicationPropertyOfAppearance();
	public boolean isSetTheme();
	public boolean isSetSurfaceDataMember();
	public boolean isSetGenericApplicationPropertyOfAppearance();
	
	public void setTheme(String theme);
	public void setSurfaceDataMember(List<SurfaceDataProperty> surfaceDataMember);
	public void addSurfaceDataMember(SurfaceDataProperty surfaceDataMember);	
	public void addGenericApplicationPropertyOfAppearance(ADEComponent ade);
	public void setGenericApplicationPropertyOfAppearance(List<ADEComponent> ade);
	public void unsetTheme();
	public void unsetSurfaceDataMember();
	public boolean unsetSurfaceDataMember(SurfaceDataProperty surfaceDataMember);
	public void unsetGenericApplicationPropertyOfAppearance();
	public boolean unsetGenericApplicationPropertyOfAppearance(ADEComponent ade);
}
