package org.citygml4j.builder.json.marshal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.builder.json.marshal.CityJSONMarshaller;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.util.walker.GeometryWalker;

public class SurfaceCollector extends GeometryWalker {
	private int lod;
	private Map<Integer, List<AbstractSurface>> surfaces = new HashMap<>();

	public boolean hasSurfaces() {
		return !surfaces.isEmpty();
	}
	
	public Collection<AbstractSurface> getSurfaces(int lod) {
		return surfaces.get(lod);
	}
	
	public void setLod(int lod) {
		this.lod = lod;
	}
	
	@Override
	public void visit(CompositeSurface surface) {
		collect(surface);
	}

	@Override
	public void visit(OrientableSurface surface) {
		collect(surface);
	}

	@Override
	public void visit(Surface surface) {
		collect(surface);
	}

	@Override
	public void visit(Polygon surface) {
		collect(surface);
	}

	private void collect(AbstractSurface surface) {
		if (!surface.hasLocalProperty(CityJSONMarshaller.GEOMETRY_XLINK_TARGET)) {
			List<AbstractSurface> tmp = surfaces.get(lod);
			if (tmp == null) {
				tmp = new ArrayList<>();
				surfaces.put(lod, tmp);
			}

			tmp.add(surface);
		}
	}
}
