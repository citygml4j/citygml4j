package org.citygml4j.model.citygml.waterbody;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.gml.SurfaceProperty;

public interface WaterBoundarySurface extends CityObject {
	public SurfaceProperty getLod2Surface();
	public SurfaceProperty getLod3Surface();
	public SurfaceProperty getLod4Surface();
	public List<ADEComponent> getGenericApplicationPropertyOfWaterBoundarySurface();
	public boolean isSetLod2Surface();
	public boolean isSetLod3Surface();
	public boolean isSetLod4Surface();
	public boolean isSetGenericApplicationPropertyOfWaterBoundarySurface();
	
	public void setLod2Surface(SurfaceProperty lod2Surface);
	public void setLod3Surface(SurfaceProperty lod3Surface);
	public void setLod4Surface(SurfaceProperty lod4Surface);	
	public void addGenericApplicationPropertyOfWaterBoundarySurface(ADEComponent adeObject);
	public void setGenericApplicationPropertyOfWaterBoundarySurface(List<ADEComponent> adeObject);
	public void unsetLod2Surface();
	public void unsetLod3Surface();
	public void unsetLod4Surface();
	public void unsetGenericApplicationPropertyOfWaterBoundarySurface();
	public boolean unsetGenericApplicationPropertyOfWaterBoundarySurface(ADEComponent adeObject);
}
