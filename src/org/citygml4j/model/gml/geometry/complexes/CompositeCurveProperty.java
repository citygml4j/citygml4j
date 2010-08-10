package org.citygml4j.model.gml.geometry.complexes;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface CompositeCurveProperty extends GeometryProperty<CompositeCurve> {
	public CompositeCurve getCompositeCurve();
	public boolean isSetCompositeCurve();
	
	public void setCompositeCurve(CompositeCurve compositeCurve);
	public void unsetCompositeCurve();
}
