package org.citygml4j.model.citygml.appearance;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.gml.AbstractGML;

public interface TextureParameterization extends CityGMLBase, AbstractGML {
	public List<ADEComponent> getGenericApplicationPropertyOfTextureParameterization();
	public boolean isSetGenericApplicationPropertyOfTextureParameterization();
	
	public void addGenericApplicationPropertyOfTextureParameterization(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfTextureParameterization(List<ADEComponent> adeObject);
	public void unsetGenericApplicationPropertyOfTextureParameterization();
	public boolean unsetGenericApplicationPropertyOfTextureParameterization(ADEComponent adeObject);
}
