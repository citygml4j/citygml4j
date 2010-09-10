package org.citygml4j.model.citygml.core;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class LodRepresentation {
	private List<GeometryProperty<? extends AbstractGeometry>> lod0Representation;
	private List<GeometryProperty<? extends AbstractGeometry>> lod1Representation;
	private List<GeometryProperty<? extends AbstractGeometry>> lod2Representation;
	private List<GeometryProperty<? extends AbstractGeometry>> lod3Representation;
	private List<GeometryProperty<? extends AbstractGeometry>> lod4Representation;

	public List<GeometryProperty<? extends AbstractGeometry>> getLod0Representation() {
		if (lod0Representation == null)
			lod0Representation = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod0Representation;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod1Representation() {
		if (lod1Representation == null)
			lod1Representation = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod1Representation;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod2Representation() {
		if (lod2Representation == null)
			lod2Representation = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod2Representation;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod3Representation() {
		if (lod3Representation == null)
			lod3Representation = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod3Representation;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLod4Representation() {
		if (lod4Representation == null)
			lod4Representation = new ArrayList<GeometryProperty<? extends AbstractGeometry>>();

		return lod4Representation;
	}

	public List<GeometryProperty<? extends AbstractGeometry>> getLodRepresentation(int lod) {
		switch (lod) {
		case 0:
			return getLod0Representation();
		case 1:
			return getLod1Representation();
		case 2:
			return getLod2Representation();
		case 3:
			return getLod3Representation();
		case 4:
			return getLod4Representation();
		default:
			return null;
		}
	}

	public boolean isSetLod0Representation() {
		return lod0Representation != null && !lod0Representation.isEmpty();
	}

	public boolean isSetLod1Representation() {
		return lod1Representation != null && !lod1Representation.isEmpty();
	}

	public boolean isSetLod2Representation() {
		return lod2Representation != null && !lod2Representation.isEmpty();
	}

	public boolean isSetLod3Representation() {
		return lod3Representation != null && !lod3Representation.isEmpty();
	}

	public boolean isSetLod4Representation() {
		return lod4Representation != null && !lod4Representation.isEmpty();
	}

	public boolean isSetLodRepresentation(int lod) {
		switch (lod) {
		case 0:
			return isSetLod0Representation();
		case 1:
			return isSetLod1Representation();
		case 2:
			return isSetLod2Representation();
		case 3:
			return isSetLod3Representation();
		case 4:
			return isSetLod4Representation();
		default:
			return false;
		}
	}

}
