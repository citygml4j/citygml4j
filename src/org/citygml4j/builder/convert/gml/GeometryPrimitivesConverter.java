package org.citygml4j.builder.convert.gml;

import org.citygml4j.factory.GMLFactory;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.OrientableSurface;
import org.citygml4j.model.gml.Solid;
import org.citygml4j.model.gml.SolidArrayProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.gml.SurfaceProperty;

public class GeometryPrimitivesConverter {
	private GMLConvertBuilder builder;
	private GMLFactory gml;

	protected GeometryPrimitivesConverter(GMLConvertBuilder builder) {
		this.builder = builder;
		gml = new GMLFactory();
	}

	protected OrientableSurface convertOrientableSurface(OrientableSurface src) {
		OrientableSurface dest = gml.createOrientableSurface();
		if (dest != null)
			convertOrientableSurface(src, dest);

		return dest;
	}

	protected Solid convertSolid(Solid src) {
		Solid dest = gml.createSolid();
		if (dest != null) {
			convertAbstractSolid(src, dest);

			if (src.isSetExterior()) {
				SurfaceProperty tmp = builder.geometryBasic2d.convertSurfaceProperty(src.getExterior());
				if (tmp != null)
					dest.setExterior(tmp);
			}

			for (SurfaceProperty interior : src.getInterior()) {
				SurfaceProperty tmp = builder.geometryBasic2d.convertSurfaceProperty(interior);
				if (tmp != null)
					dest.addInterior(tmp);
			}
		}

		return dest;
	}

	protected SolidArrayProperty convertSolidArrayProperty(SolidArrayProperty src) {
		SolidArrayProperty dest = gml.createSolidArrayProperty();

		for (AbstractSolid solid : src.getSolid()) {
			if (builder.geometryBasic0d1d.containsTexturedSurface(solid)) {
				switch (solid.getGMLClass()) {
				case SOLID:
					solid = convertSolid((Solid)solid);
					break;
				case COMPOSITESOLID:
					solid = builder.geometryComplexes.convertCompositeSolid((CompositeSolid)solid);
					break;
				}
			} 
			
			if (solid != null)
				dest.addSolid(solid);
		}

		return dest;
	}

	protected SolidProperty convertSolidProperty(SolidProperty src) {
		SolidProperty dest = src;

		if (src.isSetSolid() && builder.geometryBasic0d1d.containsTexturedSurface(src.getSolid())) {
			dest = gml.createSolidProperty();
			if (dest != null) {
				builder.gmlBase.convertAssociationAttributeGroup(src, dest);

				AbstractSolid solid = src.getSolid();
				AbstractSolid tmp = null;

				switch (solid.getGMLClass()) {
				case SOLID:
					tmp = convertSolid((Solid)solid);
					break;
				case COMPOSITESOLID:
					tmp = builder.geometryComplexes.convertCompositeSolid((CompositeSolid)solid);
					break;
				}

				if (tmp != null)
					dest.setSolid(tmp);
			}
		}

		return dest;
	}

	protected void convertOrientableSurface(OrientableSurface src, OrientableSurface dest) {
		builder.geometryBasic2d.convertAbstractSurface(src, dest);

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation());

		if (src.isSetBaseSurface()) {
			SurfaceProperty tmp = builder.geometryBasic2d.convertSurfaceProperty(src.getBaseSurface());
			if (tmp != null)
				dest.setBaseSurface(tmp);
		}
	}

	protected void convertAbstractSolid(AbstractSolid src, AbstractSolid dest) {
		builder.geometryBasic0d1d.convertAbstractGeometricPrimitive(src, dest);
	}
}
