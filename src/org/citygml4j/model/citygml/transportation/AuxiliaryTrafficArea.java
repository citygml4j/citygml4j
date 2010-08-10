package org.citygml4j.model.citygml.transportation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;

public interface AuxiliaryTrafficArea extends AbstractTransportationObject {
	public List<String> getFunction();
	public String getSurfaceMaterial();
	public MultiSurfaceProperty getLod2MultiSurface();
	public MultiSurfaceProperty getLod3MultiSurface();
	public MultiSurfaceProperty getLod4MultiSurface();
	public List<ADEComponent> getGenericApplicationPropertyOfAuxiliaryTrafficArea();
	public boolean isSetFunction();
	public boolean isSetSurfaceMaterial();
	public boolean isSetLod2MultiSurface();
	public boolean isSetLod3MultiSurface();
	public boolean isSetLod4MultiSurface();
	public boolean isSetGenericApplicationPropertyOfAuxiliaryTrafficArea();
	
	public void setFunction(List<String> function);
	public void addFunction(String function);
	public void setSurfaceMaterial(String surfaceMaterial);
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface);
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);	
	public void addGenericApplicationPropertyOfAuxiliaryTrafficArea(ADEComponent ade);
	public void setGenericApplicationPropertyOfAuxiliaryTrafficArea(List<ADEComponent> ade);
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetSurfaceMaterial();
	public void unsetLod2MultiSurface();
	public void unsetLod3MultiSurface();
	public void unsetLod4MultiSurface();
	public void unsetGenericApplicationPropertyOfAuxiliaryTrafficArea();
	public boolean unsetGenericApplicationPropertyOfAuxiliaryTrafficArea(ADEComponent ade);
}
