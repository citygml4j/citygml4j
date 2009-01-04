package org.citygml4j.builder.convert.gml;

import org.citygml4j.factory.GMLFactory;
import org.citygml4j.model.gml.AbstractGeometricAggregate;
import org.citygml4j.model.gml.MultiSolid;
import org.citygml4j.model.gml.MultiSolidProperty;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.SolidArrayProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.gml.SurfaceArrayProperty;
import org.citygml4j.model.gml.SurfaceProperty;

public class GeometryAggregatesConverter {
	private GMLConvertBuilder builder;
	private GMLFactory gml;

	protected GeometryAggregatesConverter(GMLConvertBuilder builder) {
		this.builder = builder;
		gml = new GMLFactory();
	}
	
	protected MultiSolid convertMultiSolid(MultiSolid src) {
		MultiSolid dest = gml.createMultiSolid();
		if (dest != null) {
			convertAbstractGeometricAggregate(src, dest);
			
			for (SolidProperty member : src.getSolidMember()) {
				SolidProperty tmp = builder.geometryPrimitives.convertSolidProperty(member);
				if (tmp != null)
					dest.addSolidMember(tmp);
			}
			
			if (src.isSetSolidMembers()) {
				SolidArrayProperty tmp = builder.geometryPrimitives.convertSolidArrayProperty(src.getSolidMembers());
				if (tmp != null)
					dest.setSolidMembers(tmp);
			}
		}
		
		return dest;
	}
	
	protected MultiSolidProperty convertMultiSolidProperty(MultiSolidProperty src) {
		MultiSolidProperty dest = src;
		
		if (src.isSetMultiSolid() && builder.geometryBasic0d1d.containsTexturedSurface(src.getMultiSolid())) {
			dest = gml.createMultiSolidProperty();
			if (dest != null) {
				builder.gmlBase.convertAssociationAttributeGroup(src, dest);
				
				MultiSolid tmp = convertMultiSolid(src.getMultiSolid());
				if (tmp != null)
					dest.setMultiSolid(tmp);
			}
		} 
		
		return dest;
	}
	
	protected MultiSurface convertMultiSurface(MultiSurface src) {
		MultiSurface dest = gml.createMultiSurface();
		if (dest != null) {
			convertAbstractGeometricAggregate(src, dest);
			
			for (SurfaceProperty member : src.getSurfaceMember()) {
				SurfaceProperty tmp = builder.geometryBasic2d.convertSurfaceProperty(member);
				if (tmp != null)
					dest.addSurfaceMember(tmp);
			}
			
			if (src.isSetSurfaceMembers()) {
				SurfaceArrayProperty tmp = builder.geometryBasic2d.convertSurfaceArrayProperty(src.getSurfaceMembers());
				if (tmp != null)
					dest.setSurfaceMembers(tmp);
			}
		}
		
		return dest;
	}
	
	protected MultiSurfaceProperty convertMultiSurfaceProperty(MultiSurfaceProperty src) {
		MultiSurfaceProperty dest = src;
	
		if (src.isSetMultiSurface() && builder.geometryBasic0d1d.containsTexturedSurface(src.getMultiSurface())) {
			dest = gml.createMultiSurfaceProperty();
			if (dest != null) {
				builder.gmlBase.convertAssociationAttributeGroup(src, dest);
				
				MultiSurface tmp = convertMultiSurface(src.getMultiSurface());
				if (tmp != null)
					dest.setMultiSurface(tmp);
			}
		}
		
		return dest;
	}
	
	protected void convertAbstractGeometricAggregate(AbstractGeometricAggregate src, AbstractGeometricAggregate dest) {
		builder.geometryBasic0d1d.convertAbstractGeometry(src, dest);
	}
}
