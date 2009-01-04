package org.citygml4j.builder.convert.gml;

import org.citygml4j.builder.convert.citygml.CityGMLConvertBuilder;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.AbstractFeatureCollection;
import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.AbstractGeometricAggregate;
import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.Association;
import org.citygml4j.model.gml.AssociationAttributeGroup;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSolidProperty;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.CompositeSurfaceProperty;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricComplexProperty;
import org.citygml4j.model.gml.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.MultiSolid;
import org.citygml4j.model.gml.MultiSolidProperty;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.OrientableSurface;
import org.citygml4j.model.gml.SRSInformationGroup;
import org.citygml4j.model.gml.SRSReferenceGroup;
import org.citygml4j.model.gml.Solid;
import org.citygml4j.model.gml.SolidArrayProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.gml.StandardObjectProperties;
import org.citygml4j.model.gml.SurfaceArrayProperty;
import org.citygml4j.model.gml.SurfaceProperty;

public class GMLConvertBuilder {
	protected FeatureConverter feature;
	protected GeometryAggregatesConverter geometryAggregates;
	protected GeometryBasic0d1dConverter geometryBasic0d1d;
	protected GeometryBasic2dConverter geometryBasic2d;
	protected GeometryPrimitivesConverter geometryPrimitives;
	protected GeometryComplexesConverter geometryComplexes;
	protected GMLBaseConverter gmlBase;
	
	public GMLConvertBuilder(CityGMLConvertBuilder cityGMLBuilder) {
		feature = new FeatureConverter(this);
		geometryAggregates = new GeometryAggregatesConverter(this);
		geometryBasic0d1d = new GeometryBasic0d1dConverter(this, cityGMLBuilder);
		geometryBasic2d = new GeometryBasic2dConverter(this, cityGMLBuilder);
		geometryPrimitives = new GeometryPrimitivesConverter(this);
		geometryComplexes = new GeometryComplexesConverter(this);
		gmlBase = new GMLBaseConverter();
	}
	
	// feature
	public void convertAbstractFeature(AbstractFeature src, AbstractFeature dest) {
		feature.convertAbstractFeature(src, dest);
	}
	
	public void convertAbstractFeatureCollection(AbstractFeatureCollection src, AbstractFeatureCollection dest) {
		feature.convertAbstractFeatureCollection(src, dest);
	}
	
	public void convertFeatureProperty(FeatureProperty src, FeatureProperty dest) {
		feature.convertFeatureProperty(src, dest);
	}
	
	// gmlBase
	public void convertAbstractGML(AbstractGML src, AbstractGML dest) {
		gmlBase.convertAbstractGML(src, dest);	
	}
	
	public <T extends AbstractGML> void convertAssociation(Association<T> src, Association<T> dest) {
		gmlBase.convertAssociation(src, dest);
	}
	
	public void convertStandardObjectProperties(StandardObjectProperties src, StandardObjectProperties dest) {
		gmlBase.convertStandardObjectProperties(src, dest);
	}
	
	public void convertAssociationAttributeGroup(AssociationAttributeGroup src, AssociationAttributeGroup dest) {
		gmlBase.convertAssociationAttributeGroup(src, dest);
	}
	
	// geometryAggregates
	public MultiSolid convertMultiSolid(MultiSolid multiSolid) {
		return geometryAggregates.convertMultiSolid(multiSolid);
	}
	
	public MultiSolidProperty convertMultiSolidProperty(MultiSolidProperty multiSolidProperty) {
		return geometryAggregates.convertMultiSolidProperty(multiSolidProperty);
	}
	
	public MultiSurface convertMultiSurface(MultiSurface multiSurface) {
		return geometryAggregates.convertMultiSurface(multiSurface);
	}
	
	public MultiSurfaceProperty convertMultiSurfaceProperty(MultiSurfaceProperty multiSurfaceProperty) {
		return geometryAggregates.convertMultiSurfaceProperty(multiSurfaceProperty);
	}
	
	public void convertAbstractGeometricAggregate(AbstractGeometricAggregate src, AbstractGeometricAggregate dest) {
		geometryAggregates.convertAbstractGeometricAggregate(src, dest);
	}
	
	// geometryBasic0d1d
	public GeometricPrimitiveProperty convertGeometricPrimitiveProperty(GeometricPrimitiveProperty geometricPrimitiveProperty) {
		return geometryBasic0d1d.convertGeometricPrimitiveProperty(geometricPrimitiveProperty);
	}
	
	public GeometryProperty convertGeometryProperty(GeometryProperty geometryProperty) {
		return geometryBasic0d1d.convertGeometryProperty(geometryProperty);
	}
	
	public void convertAbstractGeometry(AbstractGeometry src, AbstractGeometry dest) {
		geometryBasic0d1d.convertAbstractGeometry(src, dest);
	}
	
	public void convertAbstractGeometricPrimitive(AbstractGeometricPrimitive src, AbstractGeometricPrimitive dest) {
		geometryBasic0d1d.convertAbstractGeometricPrimitive(src, dest);
	}
	
	public void convertSRSInformationGroup(SRSInformationGroup src, SRSInformationGroup dest) {
		geometryBasic0d1d.convertSRSInformationGroup(src, dest);
	}
	
	public void convertSRSReferenceGroup(SRSReferenceGroup src, SRSReferenceGroup dest) {
		geometryBasic0d1d.convertSRSReferenceGroup(src, dest);
	}
	
	public boolean containsTexturedSurface(AbstractGeometry abstractGeometry) {
		return geometryBasic0d1d.containsTexturedSurface(abstractGeometry);
	}
	
	// geometryBasic2d
	public SurfaceArrayProperty convertSurfaceArrayProperty(SurfaceArrayProperty surfaceArrayProperty) {
		return geometryBasic2d.convertSurfaceArrayProperty(surfaceArrayProperty);
	}
	
	public SurfaceProperty convertSurfaceProperty(SurfaceProperty surfaceProperty) {
		return geometryBasic2d.convertSurfaceProperty(surfaceProperty);
	}
	
	public void convertAbstractSurface(AbstractSurface src, AbstractSurface dest) {
		geometryBasic2d.convertAbstractSurface(src, dest);
	}
	
	// geometryPrimitives
	public OrientableSurface convertOrientableSurface(OrientableSurface orientableSurface) {
		return geometryPrimitives.convertOrientableSurface(orientableSurface);
	}
	
	public Solid convertSolid(Solid solid) {
		return geometryPrimitives.convertSolid(solid);
	}
	
	public SolidArrayProperty convertSolidArrayProperty(SolidArrayProperty solidArrayProperty) {
		return geometryPrimitives.convertSolidArrayProperty(solidArrayProperty);
	}
	
	public SolidProperty convertSolidProperty(SolidProperty solidProperty) {
		return geometryPrimitives.convertSolidProperty(solidProperty);
	}
	
	public void convertOrientableSurface(OrientableSurface src, OrientableSurface dest) {
		geometryPrimitives.convertOrientableSurface(src, dest);
	}
	
	public void convertAbstractSolid(AbstractSolid src, AbstractSolid dest) {
		geometryPrimitives.convertAbstractSolid(src, dest);
	}
	
	// geometryComplexes
	public CompositeSolid convertCompositeSolid(CompositeSolid compositeSolid) {
		return geometryComplexes.convertCompositeSolid(compositeSolid);
	}
	
	public CompositeSolidProperty convertCompositeSolidProperty(CompositeSolidProperty compositeSolidProperty) {
		return geometryComplexes.convertCompositeSolidProperty(compositeSolidProperty);
	}
	
	public CompositeSurface convertCompositeSurface(CompositeSurface compositeSurface) {
		return geometryComplexes.convertCompositeSurface(compositeSurface);
	}
	
	public CompositeSurfaceProperty convertCompositeSurfaceProperty(CompositeSurfaceProperty compositeSurfaceProperty) {
		return geometryComplexes.convertCompositeSurfaceProperty(compositeSurfaceProperty);
	}
	
	public GeometricComplex convertGeometricComplex(GeometricComplex geometricComplex) {
		return geometryComplexes.convertGeometricComplex(geometricComplex);
	}
	
	public GeometricComplexProperty convertGeometricComplexProperty(GeometricComplexProperty geometricComplexProperty) {
		return geometryComplexes.convertGeometricComplexProperty(geometricComplexProperty);
	}
	
}
