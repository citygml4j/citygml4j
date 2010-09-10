package org.citygml4j.model.citygml.transportation;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;

public interface TrafficArea extends AbstractTransportationObject {
	public List<String> getFunction();
	public List<String> getUsage();
	public String getSurfaceMaterial();
	public MultiSurfaceProperty getLod2MultiSurface();
	public MultiSurfaceProperty getLod3MultiSurface();
	public MultiSurfaceProperty getLod4MultiSurface();
	public List<ADEComponent> getGenericApplicationPropertyOfTrafficArea();
	public boolean isSetFunction();
	public boolean isSetUsage();
	public boolean isSetSurfaceMaterial();
	public boolean isSetLod2MultiSurface();
	public boolean isSetLod3MultiSurface();
	public boolean isSetLod4MultiSurface();
	public boolean isSetGenericApplicationPropertyOfTrafficArea();

	public void setFunction(List<String> function);
	public void addFunction(String function);
	public void setUsage(List<String> usage);
	public void addUsage(String usage);
	public void setSurfaceMaterial(String surfaceMaterial);
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface);
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface);
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface);	
	public void addGenericApplicationPropertyOfTrafficArea(ADEComponent ade);
	public void setGenericApplicationPropertyOfTrafficArea(List<ADEComponent> ade);
	public void unsetFunction();
	public boolean unsetFunction(String function);
	public void unsetUsage();
	public boolean unsetUsage(String usage);
	public void unsetSurfaceMaterial();
	public void unsetLod2MultiSurface();
	public void unsetLod3MultiSurface();
	public void unsetLod4MultiSurface();
	public void unsetGenericApplicationPropertyOfTrafficArea();
	public boolean unsetGenericApplicationPropertyOfTrafficArea(ADEComponent ade);
}
