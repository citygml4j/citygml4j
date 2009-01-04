package org.citygml4j.builder.convert.gml;

import org.citygml4j.builder.convert.citygml.CityGMLConvertBuilder;
import org.citygml4j.factory.GMLFactory;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.MultiSolid;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.OrientableSurface;
import org.citygml4j.model.gml.SRSInformationGroup;
import org.citygml4j.model.gml.SRSReferenceGroup;
import org.citygml4j.model.gml.Solid;
import org.citygml4j.model.gml.SolidArrayProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.gml.SurfaceArrayProperty;
import org.citygml4j.model.gml.SurfaceProperty;

public class GeometryBasic0d1dConverter {
	private GMLConvertBuilder builder;
	private CityGMLConvertBuilder cityGMLBuilder;
	private GMLFactory gml;
	
	protected GeometryBasic0d1dConverter(GMLConvertBuilder builder, CityGMLConvertBuilder cityGMLBuilder) {
		this.builder = builder;
		this.cityGMLBuilder = cityGMLBuilder;
		gml = new GMLFactory();
	}
	
	protected GeometricPrimitiveProperty convertGeometricPrimitiveProperty(GeometricPrimitiveProperty src) {
		GeometricPrimitiveProperty dest = src;
		
		if (src.isSetGeometricPrimitive() && containsTexturedSurface(src.getGeometricPrimitive())) {
			dest = gml.createGeometricPrimitiveProperty();
			if (dest != null) {
				builder.gmlBase.convertAssociationAttributeGroup(src, dest);
				
				AbstractGeometricPrimitive primitive = src.getGeometricPrimitive();
				AbstractGeometricPrimitive tmp = null;
				
				switch (primitive.getGMLClass()) {
				case _TEXTUREDSURFACE:
					tmp = cityGMLBuilder.convert_TexturedSurface((_TexturedSurface)primitive);
					break;
				case ORIENTABLESURFACE:
					tmp = builder.geometryPrimitives.convertOrientableSurface((OrientableSurface)primitive);
					break;
				case COMPOSITESURFACE:
					tmp = builder.geometryComplexes.convertCompositeSurface((CompositeSurface)primitive);
					break;
				case SOLID:
					tmp = builder.geometryPrimitives.convertSolid((Solid)primitive);
					break;
				case COMPOSITESOLID:
					tmp = builder.geometryComplexes.convertCompositeSolid((CompositeSolid)primitive);
					break;
				}
				
				if (tmp != null)
					dest.setGeometricPrimitive(tmp);
			}
		}
		
		return dest;
	}
	
	protected GeometryProperty convertGeometryProperty(GeometryProperty src) {
		GeometryProperty dest = src;
		
		if (src.isSetGeometry() && containsTexturedSurface(src.getGeometry())) {
			dest = gml.createGeometryProperty();
			if (dest != null) {
				builder.gmlBase.convertAssociationAttributeGroup(src, dest);
				
				AbstractGeometry geometry = src.getGeometry();
				AbstractGeometry tmp = null;
				
				switch (geometry.getGMLClass()) {
				case _TEXTUREDSURFACE:
					tmp = cityGMLBuilder.convert_TexturedSurface((_TexturedSurface)geometry);
					break;
				case ORIENTABLESURFACE:
					tmp = builder.geometryPrimitives.convertOrientableSurface((OrientableSurface)geometry);
					break;
				case COMPOSITESURFACE:
					tmp = builder.geometryComplexes.convertCompositeSurface((CompositeSurface)geometry);
					break;
				case SOLID:
					tmp = builder.geometryPrimitives.convertSolid((Solid)geometry);
					break;
				case COMPOSITESOLID:
					tmp = builder.geometryComplexes.convertCompositeSolid((CompositeSolid)geometry);
					break;
				case MULTISURFACE:
					tmp = builder.geometryAggregates.convertMultiSurface((MultiSurface)geometry);
					break;
				case MULTISOLID:
					tmp = builder.geometryAggregates.convertMultiSolid((MultiSolid)geometry);
					break;
				case GEOMETRICCOMPLEX:
					tmp = builder.geometryComplexes.convertGeometricComplex((GeometricComplex)geometry);
					break;
				}
				
				if (tmp != null)
					dest.setGeometry(tmp);
			}
		}
		
		return dest;
	}
	
	protected void convertAbstractGeometry(AbstractGeometry src, AbstractGeometry dest) {
		builder.gmlBase.convertAbstractGML(src, dest);
		convertSRSReferenceGroup(src, dest);
		
		if (src.isSetGid())
			dest.setGid(src.getGid());
	}
	
	protected void convertAbstractGeometricPrimitive(AbstractGeometricPrimitive src, AbstractGeometricPrimitive dest) {
		convertAbstractGeometry(src, dest);
	}
	
	protected void convertSRSInformationGroup(SRSInformationGroup src, SRSInformationGroup dest) {
		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());
		
		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());
	}
	
	protected void convertSRSReferenceGroup(SRSReferenceGroup src, SRSReferenceGroup dest) {
		convertSRSInformationGroup(src, dest);
		
		if (src.isSetSrsDimension())
			dest.setSrsDimension(src.getSrsDimension());
		
		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());		
	}
	
	protected boolean containsTexturedSurface(AbstractGeometry src) {

		if (src instanceof _TexturedSurface)
			return true;
		
		else if (src instanceof OrientableSurface) {
			OrientableSurface orientableSurface = (OrientableSurface)src;
			if (orientableSurface.isSetBaseSurface()) {
				SurfaceProperty baseSurface = orientableSurface.getBaseSurface();
				if (baseSurface.isSetSurface())
					return containsTexturedSurface(baseSurface.getSurface());
			}
		}
		
		else if (src instanceof CompositeSurface) {
			CompositeSurface compositeSurface = (CompositeSurface)src;
			for (SurfaceProperty surfaceMember : compositeSurface.getSurfaceMember()) {
				if (surfaceMember.isSetSurface())
					if (containsTexturedSurface(surfaceMember.getSurface()))
						return true;
			}
		}
		
		else if (src instanceof Solid) {
			Solid solid = (Solid)src;
			if (solid.isSetExterior()) {
				SurfaceProperty exterior = solid.getExterior();
				if (exterior.isSetSurface())
					if (containsTexturedSurface(exterior.getSurface()))
						return true;
			}
			
			if (solid.isSetInterior()) {
				for (SurfaceProperty interior : solid.getInterior()) 
					if (interior.isSetSurface())
						if (containsTexturedSurface(interior.getSurface()))
							return true;
			}
		}
		
		else if (src instanceof CompositeSolid) {
			CompositeSolid compositeSolid = (CompositeSolid)src;
			for (SolidProperty solid : compositeSolid.getSolidMember())
				if (solid.isSetSolid())
					if (containsTexturedSurface(solid.getSolid()))
						return true;
		}
		
		else if (src instanceof MultiSurface) {
			MultiSurface multiSurface = (MultiSurface)src;
			for (SurfaceProperty surface : multiSurface.getSurfaceMember()) 
				if (surface.isSetSurface())
					if (containsTexturedSurface(surface.getSurface()))
						return true;
			
			if (multiSurface.isSetSurfaceMembers()) {
				SurfaceArrayProperty surfaceArray = multiSurface.getSurfaceMembers();
				for (AbstractSurface abstractSurface : surfaceArray.getSurface())
					if (containsTexturedSurface(abstractSurface))
						return true;
			}
		}
		
		else if (src instanceof MultiSolid) {
			MultiSolid multiSolid = (MultiSolid)src;
			for (SolidProperty solid : multiSolid.getSolidMember())
				if (solid.isSetSolid())
					if (containsTexturedSurface(solid.getSolid()))
						return true;
			
			if (multiSolid.isSetSolidMembers()) {
				SolidArrayProperty solidArray = multiSolid.getSolidMembers();
				for (AbstractSolid abstractSolid : solidArray.getSolid())
					if (containsTexturedSurface(abstractSolid))
						return true;
			}
		}
		
		else if (src instanceof GeometricComplex) {
			GeometricComplex geometricComplex = (GeometricComplex)src;
			for (GeometricPrimitiveProperty geometricPrimitive : geometricComplex.getElement())
				if (geometricPrimitive.isSetGeometricPrimitive())
					if (containsTexturedSurface(geometricPrimitive.getGeometricPrimitive()))
						return true;
		}
		
		return false;
	}
}
