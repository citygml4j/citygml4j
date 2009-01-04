package org.citygml4j.builder.convert.gml;

import org.citygml4j.factory.GMLFactory;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSolidProperty;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.CompositeSurfaceProperty;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricComplexProperty;
import org.citygml4j.model.gml.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.gml.SurfaceProperty;

public class GeometryComplexesConverter {
	private GMLConvertBuilder builder;
	private GMLFactory gml;

	protected GeometryComplexesConverter(GMLConvertBuilder builder) {
		this.builder = builder;
		gml = new GMLFactory();
	}

	protected CompositeSolid convertCompositeSolid(CompositeSolid src) {
		CompositeSolid dest = gml.createCompositeSolid();
		if (dest != null) {
			builder.geometryPrimitives.convertAbstractSolid(src, dest);

			for (SolidProperty member : src.getSolidMember()) {
				SolidProperty tmp = builder.geometryPrimitives.convertSolidProperty(member);
				if (tmp != null)
					dest.addSolidMember(tmp);
			}
		}
		
		return dest;
	}
	
	protected CompositeSolidProperty convertCompositeSolidProperty(CompositeSolidProperty src) {
		CompositeSolidProperty dest = src;
		
		if (src.isSetCompositeSolid() && builder.geometryBasic0d1d.containsTexturedSurface(src.getCompositeSolid())) {
			dest = gml.createCompositeSolidProperty();
			if (dest != null) {
				builder.gmlBase.convertAssociationAttributeGroup(src, dest);
				
				CompositeSolid tmp = convertCompositeSolid(src.getCompositeSolid());
				if (tmp != null)
					dest.setCompositeSolid(tmp);
			}
		}
		
		return dest;
	}
	
	protected CompositeSurface convertCompositeSurface(CompositeSurface src) {
		CompositeSurface dest = gml.createCompositeSurface();
		if (dest != null) {
			builder.geometryBasic2d.convertAbstractSurface(src, dest);

			for (SurfaceProperty member : src.getSurfaceMember()) {
				SurfaceProperty tmp = builder.geometryBasic2d.convertSurfaceProperty(member);
				if (tmp != null)
					dest.addSurfaceMember(tmp);
			}
		}

		return dest;
	}
	
	protected CompositeSurfaceProperty convertCompositeSurfaceProperty(CompositeSurfaceProperty src) {
		CompositeSurfaceProperty dest = src;
		
		if (src.isSetCompositeSurface() && builder.geometryBasic0d1d.containsTexturedSurface(src.getCompositeSurface())) {
			dest = gml.createCompositeSurfaceProperty();
			if (dest != null) {
				builder.gmlBase.convertAssociationAttributeGroup(src, dest);
				
				CompositeSurface tmp = convertCompositeSurface(src.getCompositeSurface());
				if (tmp != null)
					dest.setCompositeSurface(tmp);
			}			
		}
		
		return dest;
	}
	
	protected GeometricComplex convertGeometricComplex(GeometricComplex src) {
		GeometricComplex dest = gml.createGeometricComplex();
		if (dest != null) {
			builder.geometryBasic0d1d.convertAbstractGeometry(src, dest);

			for (GeometricPrimitiveProperty primitive : src.getElement()) {
				GeometricPrimitiveProperty tmp = builder.geometryBasic0d1d.convertGeometricPrimitiveProperty(primitive);
				if (tmp != null)
					dest.addElement(tmp);
			}
		}
		
		return dest;
	}
	
	protected GeometricComplexProperty convertGeometricComplexProperty(GeometricComplexProperty src) {
		GeometricComplexProperty dest = src;
		
		if (src.isSetCompositeSolid()) {
			if (builder.geometryBasic0d1d.containsTexturedSurface(src.getCompositeSolid())) {
				dest = gml.createGeometricComplexProperty();
				if (dest != null) {
					builder.gmlBase.convertAssociationAttributeGroup(src, dest);
					
					CompositeSolid tmp = convertCompositeSolid(src.getCompositeSolid());
					if (tmp != null)
						dest.setCompositeSolid(tmp);
				}
			}
		} else if (src.isSetCompositeSurface()) {
			if (builder.geometryBasic0d1d.containsTexturedSurface(src.getCompositeSurface())) {
				dest = gml.createGeometricComplexProperty();
				if (dest != null) {
					builder.gmlBase.convertAssociationAttributeGroup(src, dest);
					
					CompositeSurface tmp = convertCompositeSurface(src.getCompositeSurface());
					if (tmp != null)
						dest.setCompositeSurface(tmp);
				}
			}
		} else if (src.isSetGeometricComplex()) {
			if (builder.geometryBasic0d1d.containsTexturedSurface(src.getGeometricComplex())) {
				dest = gml.createGeometricComplexProperty();
				if (dest != null) {
					builder.gmlBase.convertAssociationAttributeGroup(src, dest);
					
					GeometricComplex tmp = convertGeometricComplex(src.getGeometricComplex());
					if (tmp != null)
						dest.setGeometricComplex(tmp);
				}
			}
		}
		
		return dest;
	}
}
