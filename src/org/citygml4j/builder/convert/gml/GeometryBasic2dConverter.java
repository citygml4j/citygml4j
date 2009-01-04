package org.citygml4j.builder.convert.gml;

import org.citygml4j.builder.convert.citygml.CityGMLConvertBuilder;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.OrientableSurface;
import org.citygml4j.model.gml.SurfaceArrayProperty;
import org.citygml4j.model.gml.SurfaceProperty;

public class GeometryBasic2dConverter {
	private GMLConvertBuilder builder;
	private CityGMLConvertBuilder cityGMLBuilder;
	private GMLFactory gml;

	protected GeometryBasic2dConverter(GMLConvertBuilder builder, CityGMLConvertBuilder cityGMLBuilder) {
		this.builder = builder;
		this.cityGMLBuilder = cityGMLBuilder;
		gml = new GMLFactory();
	}

	protected SurfaceArrayProperty convertSurfaceArrayProperty(SurfaceArrayProperty src) {
		SurfaceArrayProperty dest = gml.createSurfaceArrayProperty();
		
		for (AbstractSurface surface : src.getSurface()) {
			if (builder.geometryBasic0d1d.containsTexturedSurface(surface)) {
				switch (surface.getGMLClass()) {
				case _TEXTUREDSURFACE:
					surface = cityGMLBuilder.convert_TexturedSurface((_TexturedSurface)surface);
					break;
				case ORIENTABLESURFACE:
					surface = builder.geometryPrimitives.convertOrientableSurface((OrientableSurface)surface);
					break;
				case COMPOSITESURFACE:
					surface = builder.geometryComplexes.convertCompositeSurface((CompositeSurface)surface);
					break;
				}
			}
			
			if (surface != null)
				dest.addSurface(surface);
		}
		
		return dest;
	}
	
	protected SurfaceProperty convertSurfaceProperty(SurfaceProperty src) {
		SurfaceProperty dest = src;
		
		if (src.isSetSurface() && builder.geometryBasic0d1d.containsTexturedSurface(src.getSurface())) {
			dest = gml.createSurfaceProperty();
			if (dest != null) {
				builder.gmlBase.convertAssociationAttributeGroup(src, dest);

				AbstractSurface surface = src.getSurface();
				AbstractSurface tmp = null;
				
				switch (surface.getGMLClass()) {
				case _TEXTUREDSURFACE:
					tmp = cityGMLBuilder.convert_TexturedSurface((_TexturedSurface)surface);
					break;
				case ORIENTABLESURFACE:
					tmp = builder.geometryPrimitives.convertOrientableSurface((OrientableSurface)surface);
					break;
				case COMPOSITESURFACE:
					tmp = builder.geometryComplexes.convertCompositeSurface((CompositeSurface)surface);
					break;
				}

				if (tmp != null)
					dest.setSurface(tmp);
			}
		}
		
		return dest;
	}

	protected void convertAbstractSurface(AbstractSurface src, AbstractSurface dest) {
		builder.geometryBasic0d1d.convertAbstractGeometricPrimitive(src, dest);
	}

}
