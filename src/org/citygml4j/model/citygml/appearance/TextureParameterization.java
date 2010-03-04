package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.AbstractGML;

public interface TextureParameterization extends AppearanceModuleComponent, AbstractGML {
	public List<ADEComponent> getGenericADEComponent();
	public List<ADEComponent> getGenericApplicationPropertyOfTextureParameterization();
	public boolean isSetGenericADEComponent();
	public boolean isSetGenericApplicationPropertyOfTextureParameterization();
	
	public void addGenericADEComponent(ADEComponent genericADEComponent);
	public void setGenericADEComponent(List<ADEComponent> genericADEComponent);
	public void addGenericApplicationPropertyOfTextureParameterization(ADEComponent ade);
	public void setGenericApplicationPropertyOfTextureParameterization(List<ADEComponent> ade);
	public void unsetGenericADEComponent();
	public boolean unsetGenericADEComponent(ADEComponent genericADEComponent);
	public void unsetGenericApplicationPropertyOfTextureParameterization();
	public boolean unsetGenericApplicationPropertyOfTextureParameterization(ADEComponent ade);
}
