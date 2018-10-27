/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.util.walker;

import org.citygml4j.CityGMLContext;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.ade.binding.ADEWalker;
import org.citygml4j.model.citygml.ade.binding.ADEWalkerHelper;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.bridge.AbstractBridge;
import org.citygml4j.model.citygml.bridge.Bridge;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElement;
import org.citygml4j.model.citygml.bridge.BridgeConstructionElementProperty;
import org.citygml4j.model.citygml.bridge.BridgeFurniture;
import org.citygml4j.model.citygml.bridge.BridgeInstallation;
import org.citygml4j.model.citygml.bridge.BridgeInstallationProperty;
import org.citygml4j.model.citygml.bridge.BridgePart;
import org.citygml4j.model.citygml.bridge.BridgePartProperty;
import org.citygml4j.model.citygml.bridge.BridgeRoom;
import org.citygml4j.model.citygml.bridge.IntBridgeInstallation;
import org.citygml4j.model.citygml.bridge.IntBridgeInstallationProperty;
import org.citygml4j.model.citygml.bridge.InteriorBridgeRoomProperty;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.BuildingPartProperty;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.AbstractSite;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.texturedsurface._AbstractAppearance;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.tunnel.AbstractTunnel;
import org.citygml4j.model.citygml.tunnel.HollowSpace;
import org.citygml4j.model.citygml.tunnel.IntTunnelInstallation;
import org.citygml4j.model.citygml.tunnel.IntTunnelInstallationProperty;
import org.citygml4j.model.citygml.tunnel.InteriorHollowSpaceProperty;
import org.citygml4j.model.citygml.tunnel.Tunnel;
import org.citygml4j.model.citygml.tunnel.TunnelFurniture;
import org.citygml4j.model.citygml.tunnel.TunnelInstallation;
import org.citygml4j.model.citygml.tunnel.TunnelInstallationProperty;
import org.citygml4j.model.citygml.tunnel.TunnelPart;
import org.citygml4j.model.citygml.tunnel.TunnelPartProperty;
import org.citygml4j.model.citygml.vegetation.AbstractVegetationObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.AbstractWaterObject;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.base.AssociationByRep;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.coverage.AbstractCoverage;
import org.citygml4j.model.gml.coverage.AbstractDiscreteCoverage;
import org.citygml4j.model.gml.coverage.DataBlock;
import org.citygml4j.model.gml.coverage.File;
import org.citygml4j.model.gml.coverage.RangeSet;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.AbstractFeatureCollection;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.InlineGeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.AbstractGeometricAggregate;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiGeometry;
import org.citygml4j.model.gml.geometry.aggregates.MultiLineString;
import org.citygml4j.model.gml.geometry.aggregates.MultiPoint;
import org.citygml4j.model.gml.geometry.aggregates.MultiPolygon;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurve;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolid;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplex;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.geometry.primitives.AbstractRing;
import org.citygml4j.model.gml.geometry.primitives.AbstractRingProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurfacePatch;
import org.citygml4j.model.gml.geometry.primitives.Curve;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringProperty;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.OrientableCurve;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;
import org.citygml4j.model.gml.geometry.primitives.Rectangle;
import org.citygml4j.model.gml.geometry.primitives.Ring;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.model.gml.geometry.primitives.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.Tin;
import org.citygml4j.model.gml.geometry.primitives.Triangle;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.model.gml.grids.Grid;
import org.citygml4j.model.gml.grids.RectifiedGrid;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
import org.citygml4j.model.gml.valueObjects.Value;
import org.citygml4j.model.gml.valueObjects.ValueArray;
import org.citygml4j.model.gml.valueObjects.ValueArrayProperty;
import org.citygml4j.model.gml.valueObjects.ValueObject;
import org.citygml4j.model.gml.valueObjects.ValueProperty;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public abstract class GMLWalker extends Walker implements GMLVisitor {
	protected SchemaHandler schemaHandler;
	protected ADEWalkerHelper<GMLWalker> adeWalkerHelper;

	public GMLWalker() {
		CityGMLContext context = CityGMLContext.getInstance();
		if (context.hasADEContexts()) {
			for (ADEContext adeContext : CityGMLContext.getInstance().getADEContexts())
				useADEWalker(adeContext.createDefaultGMLWalker());
		}
	}

	public final GMLWalker setSchemaHandler(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
		return this;
	}

	public final SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}
	
	public final GMLWalker useADEWalker(ADEWalker<GMLWalker> walker) {
		if (walker != null) {
			if (adeWalkerHelper == null)
				adeWalkerHelper = new ADEWalkerHelper<>();

			walker.setParentWalker(this);
			adeWalkerHelper.addADEWalker(walker);
		}

		return this;
	}
	
	@SafeVarargs
	public final GMLWalker useADEWalkers(ADEWalker<GMLWalker>... walkers) {
		for (ADEWalker<GMLWalker> walker : walkers)
			useADEWalker(walker);

		return this;
	}

	public void visit(LodRepresentation lodRepresentation) {
		if (lodRepresentation != null) {
			for (int lod = 0; lod < 5; lod++) {
				for (AssociationByRepOrRef<? extends AbstractGML> property : lodRepresentation.getRepresentation(lod))
					visit(property);
			}
		}
	}

	public void visit(AbstractGML abstractGML) {
	}

	public void visit(AbstractGeometry abstractGeometry) {
		visit((AbstractGML)abstractGeometry);
	}

	public void visit(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		visit((AbstractGeometry)abstractGeometricPrimitive);
	}

	public void visit(AbstractGeometricAggregate abstractGeometricAggregate) {
		visit((AbstractGeometry)abstractGeometricAggregate);
	}

	public void visit(AbstractCurve abstractCurve) {
		visit((AbstractGeometricPrimitive)abstractCurve);
	}

	public void visit(AbstractSolid abstractSolid) {
		visit((AbstractGeometricPrimitive)abstractSolid);
	}

	public void visit(AbstractSurface abstractSurface) {
		visit((AbstractGeometricPrimitive)abstractSurface);
	}

	public void visit(AbstractRing abstractRing) {
		visit((AbstractGeometry)abstractRing);
	}

	public void visit(Triangle triangle) {
		if (triangle.isSetExterior())
			visit(triangle.getExterior());
	}

	public void visit(Rectangle rectangle) {
		if (rectangle.isSetExterior())
			visit(rectangle.getExterior());
	}

	public void visit(CompositeCurve compositeCurve) {
		visit((AbstractCurve)compositeCurve);

		for (CurveProperty curveProperty : new ArrayList<CurveProperty>(compositeCurve.getCurveMember()))
			visit(curveProperty);
	}

	public void visit(CompositeSolid compositeSolid) {
		visit((AbstractSolid)compositeSolid);

		for (SolidProperty solidProperty : new ArrayList<SolidProperty>(compositeSolid.getSolidMember()))
			visit(solidProperty);
	}

	public void visit(CompositeSurface compositeSurface) {
		visit((AbstractSurface)compositeSurface);

		for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(compositeSurface.getSurfaceMember()))
			visit(surfaceProperty);
	}

	public void visit(Curve curve) {
		visit((AbstractCurve)curve);
	}

	public void visit(GeometricComplex geometricComplex) {
		visit((AbstractGeometry)geometricComplex);

		if (geometricComplex.isSetElement())
			for (GeometricPrimitiveProperty geometricPrimitiveProperty : new ArrayList<GeometricPrimitiveProperty>(geometricComplex.getElement()))
				visit(geometricPrimitiveProperty);
	}

	public void visit(Grid grid) {
		visit((AbstractGeometry)grid);
	}

	public void visit(LinearRing linearRing) {
		visit((AbstractRing)linearRing);
	}

	public void visit(LineString lineString) {
		visit((AbstractCurve)lineString);
	}

	public void visit(MultiCurve multiCurve) {
		visit((AbstractGeometricAggregate)multiCurve);

		if (multiCurve.isSetCurveMember())
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(multiCurve.getCurveMember()))
				visit(curveProperty);

		if (multiCurve.isSetCurveMembers())
			visit(multiCurve.getCurveMembers());
	}

	public void visit(MultiGeometry multiGeometry) {
		visit((AbstractGeometricAggregate)multiGeometry);

		if (multiGeometry.isSetGeometryMember())
			for (GeometryProperty<? extends AbstractGeometry> geometryProperty : new ArrayList<GeometryProperty<? extends AbstractGeometry>>(multiGeometry.getGeometryMember()))
				visit(geometryProperty);

		if (multiGeometry.isSetGeometryMembers())
			visit(multiGeometry.getGeometryMembers());
	}

	public void visit(MultiLineString multiLineString) {
		visit((AbstractGeometricAggregate)multiLineString);

		if (multiLineString.isSetLineStringMember())
			for (LineStringProperty lineStringProperty : new ArrayList<LineStringProperty>(multiLineString.getLineStringMember()))
				visit(lineStringProperty);
	}

	public void visit(MultiPoint multiPoint) {
		visit((AbstractGeometricAggregate)multiPoint);

		if (multiPoint.isSetPointMember())
			for (PointProperty pointProperty : new ArrayList<PointProperty>(multiPoint.getPointMember()))
				visit(pointProperty);

		if (multiPoint.isSetPointMembers())
			visit(multiPoint.getPointMembers());
	}

	public void visit(MultiPolygon multiPolygon) {
		visit((AbstractGeometricAggregate)multiPolygon);

		if (multiPolygon.isSetPolygonMember())
			for (PolygonProperty polygonProperty : new ArrayList<PolygonProperty>(multiPolygon.getPolygonMember()))
				visit(polygonProperty);
	}

	public void visit(MultiSolid multiSolid) {
		visit((AbstractGeometricAggregate)multiSolid);

		if (multiSolid.isSetSolidMember())
			for (SolidProperty solidProperty : new ArrayList<SolidProperty>(multiSolid.getSolidMember()))
				visit(solidProperty);

		if (multiSolid.isSetSolidMembers())
			visit(multiSolid.getSolidMembers());
	}

	public void visit(MultiSurface multiSurface) {
		visit((AbstractGeometricAggregate)multiSurface);

		if (multiSurface.isSetSurfaceMember())
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(multiSurface.getSurfaceMember()))
				visit(surfaceProperty);

		if (multiSurface.isSetSurfaceMembers())
			visit(multiSurface.getSurfaceMembers());
	}

	public void visit(OrientableCurve orientableCurve) {
		visit((AbstractCurve)orientableCurve);

		if (orientableCurve.isSetBaseCurve())
			visit(orientableCurve.getBaseCurve());
	}

	public void visit(OrientableSurface orientableSurface) {
		visit((AbstractSurface)orientableSurface);

		if (orientableSurface.isSetBaseSurface())
			visit(orientableSurface.getBaseSurface());
	}

	public void visit(_TexturedSurface texturedSurface) {
		visit((OrientableSurface)texturedSurface);
	}

	public void visit(Point point) {
		visit((AbstractGeometricPrimitive)point);
	}

	public void visit(Polygon polygon) {
		visit((AbstractSurface)polygon);

		if (polygon.isSetExterior())
			visit(polygon.getExterior());

		if (polygon.isSetInterior())
			for (AbstractRingProperty interior : new ArrayList<AbstractRingProperty>(polygon.getInterior()))
				visit(interior);
	}

	public void visit(RectifiedGrid rectifiedGrid) {
		visit((Grid)rectifiedGrid);

		if (rectifiedGrid.isSetOrigin())
			visit(rectifiedGrid.getOrigin());
	}

	public void visit(Ring ring) {
		visit((AbstractRing)ring);

		if (ring.isSetCurveMember())
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(ring.getCurveMember()))
				visit(curveProperty);
	}

	public void visit(Solid solid) {
		visit((AbstractSolid)solid);

		if (solid.isSetExterior())
			visit(solid.getExterior());

		if (solid.isSetInterior())
			for (SurfaceProperty interior : new ArrayList<SurfaceProperty>(solid.getInterior()))
				visit(interior);
	}

	public void visit(Surface surface) {
		visit((AbstractSurface)surface);

		if (surface.isSetPatches())
			visit(surface.getPatches());
	}

	public void visit(Tin tin) {
		visit((TriangulatedSurface)tin);
	}

	public void visit(TriangulatedSurface triangulatedSurface) {
		visit((Surface)triangulatedSurface);
	}

	public void visit(org.citygml4j.model.citygml.bridge.AbstractBoundarySurface abstractBoundarySurface) {
		visit((AbstractCityObject)abstractBoundarySurface);

		if (abstractBoundarySurface.isSetOpening())
			for (org.citygml4j.model.citygml.bridge.OpeningProperty openingProperty : new ArrayList<org.citygml4j.model.citygml.bridge.OpeningProperty>(abstractBoundarySurface.getOpening()))
				visit(openingProperty);

		if (abstractBoundarySurface.isSetLod2MultiSurface())
			visit(abstractBoundarySurface.getLod2MultiSurface());

		if (abstractBoundarySurface.isSetLod3MultiSurface())
			visit(abstractBoundarySurface.getLod3MultiSurface());

		if (abstractBoundarySurface.isSetLod4MultiSurface())
			visit(abstractBoundarySurface.getLod4MultiSurface());

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.AbstractBoundarySurface abstractBoundarySurface) {
		visit((AbstractCityObject)abstractBoundarySurface);

		if (abstractBoundarySurface.isSetOpening())
			for (org.citygml4j.model.citygml.building.OpeningProperty openingProperty : new ArrayList<org.citygml4j.model.citygml.building.OpeningProperty>(abstractBoundarySurface.getOpening()))
				visit(openingProperty);

		if (abstractBoundarySurface.isSetLod2MultiSurface())
			visit(abstractBoundarySurface.getLod2MultiSurface());

		if (abstractBoundarySurface.isSetLod3MultiSurface())
			visit(abstractBoundarySurface.getLod3MultiSurface());

		if (abstractBoundarySurface.isSetLod4MultiSurface())
			visit(abstractBoundarySurface.getLod4MultiSurface());

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface abstractBoundarySurface) {
		visit((AbstractCityObject)abstractBoundarySurface);

		if (abstractBoundarySurface.isSetOpening())
			for (org.citygml4j.model.citygml.tunnel.OpeningProperty openingProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.OpeningProperty>(abstractBoundarySurface.getOpening()))
				visit(openingProperty);

		if (abstractBoundarySurface.isSetLod2MultiSurface())
			visit(abstractBoundarySurface.getLod2MultiSurface());

		if (abstractBoundarySurface.isSetLod3MultiSurface())
			visit(abstractBoundarySurface.getLod3MultiSurface());

		if (abstractBoundarySurface.isSetLod4MultiSurface())
			visit(abstractBoundarySurface.getLod4MultiSurface());

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()))
				visit(ade);
	}

	public void visit(AbstractBridge abstractBridge) {
		visit((AbstractSite)abstractBridge);

		if (abstractBridge.isSetOuterBridgeInstallation())
			for (BridgeInstallationProperty bridgeInstallationProperty : new ArrayList<BridgeInstallationProperty>(abstractBridge.getOuterBridgeInstallation()))
				visit(bridgeInstallationProperty);

		if (abstractBridge.isSetOuterBridgeConstructionElement())
			for (BridgeConstructionElementProperty constructionElementProperty : new ArrayList<BridgeConstructionElementProperty>(abstractBridge.getOuterBridgeConstructionElement()))
				visit(constructionElementProperty);

		if (abstractBridge.isSetInteriorBridgeInstallation())
			for (IntBridgeInstallationProperty intBridgeInstallationProperty : new ArrayList<IntBridgeInstallationProperty>(abstractBridge.getInteriorBridgeInstallation())) 
				visit(intBridgeInstallationProperty);

		if (abstractBridge.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(abstractBridge.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (abstractBridge.isSetConsistsOfBridgePart())
			for (BridgePartProperty bridgePartProperty : new ArrayList<BridgePartProperty>(abstractBridge.getConsistsOfBridgePart()))
				visit(bridgePartProperty);

		if (abstractBridge.isSetInteriorBridgeRoom())
			for (InteriorBridgeRoomProperty interiorBridgeRoomProperty : new ArrayList<InteriorBridgeRoomProperty>(abstractBridge.getInteriorBridgeRoom()))
				visit(interiorBridgeRoomProperty);

		if (abstractBridge.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(abstractBridge.getAddress()))
				visit(addressProperty);

		if (abstractBridge.isSetLod1Solid())
			visit(abstractBridge.getLod1Solid());

		if (abstractBridge.isSetLod2Solid())
			visit(abstractBridge.getLod2Solid());

		if (abstractBridge.isSetLod3Solid())
			visit(abstractBridge.getLod3Solid());

		if (abstractBridge.isSetLod4Solid())
			visit(abstractBridge.getLod4Solid());

		if (abstractBridge.isSetLod1TerrainIntersection())
			visit(abstractBridge.getLod1TerrainIntersection());

		if (abstractBridge.isSetLod2TerrainIntersection())
			visit(abstractBridge.getLod2TerrainIntersection());

		if (abstractBridge.isSetLod3TerrainIntersection())
			visit(abstractBridge.getLod3TerrainIntersection());

		if (abstractBridge.isSetLod4TerrainIntersection())
			visit(abstractBridge.getLod4TerrainIntersection());

		if (abstractBridge.isSetLod2MultiCurve())
			visit(abstractBridge.getLod2MultiCurve());

		if (abstractBridge.isSetLod3MultiCurve())
			visit(abstractBridge.getLod3MultiCurve());

		if (abstractBridge.isSetLod4MultiCurve())
			visit(abstractBridge.getLod4MultiCurve());

		if (abstractBridge.isSetLod1MultiSurface())
			visit(abstractBridge.getLod1MultiSurface());

		if (abstractBridge.isSetLod2MultiSurface())
			visit(abstractBridge.getLod2MultiSurface());

		if (abstractBridge.isSetLod3MultiSurface())
			visit(abstractBridge.getLod3MultiSurface());

		if (abstractBridge.isSetLod4MultiSurface())
			visit(abstractBridge.getLod4MultiSurface());

		if (abstractBridge.isSetGenericApplicationPropertyOfAbstractBridge())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBridge.getGenericApplicationPropertyOfAbstractBridge()))
				visit(ade);
	}

	public void visit(AbstractBuilding abstractBuilding) {
		visit((AbstractSite)abstractBuilding);

		if (abstractBuilding.isSetOuterBuildingInstallation())
			for (BuildingInstallationProperty buildingInstallationProperty : new ArrayList<BuildingInstallationProperty>(abstractBuilding.getOuterBuildingInstallation()))
				visit(buildingInstallationProperty);

		if (abstractBuilding.isSetInteriorBuildingInstallation())
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(abstractBuilding.getInteriorBuildingInstallation())) 
				visit(intBuildingInstallationProperty);

		if (abstractBuilding.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.building.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.building.BoundarySurfaceProperty>(abstractBuilding.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (abstractBuilding.isSetConsistsOfBuildingPart())
			for (BuildingPartProperty buildingPartProperty : new ArrayList<BuildingPartProperty>(abstractBuilding.getConsistsOfBuildingPart()))
				visit(buildingPartProperty);

		if (abstractBuilding.isSetInteriorRoom())
			for (InteriorRoomProperty interiorRoomProperty : new ArrayList<InteriorRoomProperty>(abstractBuilding.getInteriorRoom()))
				visit(interiorRoomProperty);

		if (abstractBuilding.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(abstractBuilding.getAddress()))
				visit(addressProperty);

		if (abstractBuilding.isSetLod1Solid())
			visit(abstractBuilding.getLod1Solid());

		if (abstractBuilding.isSetLod2Solid())
			visit(abstractBuilding.getLod2Solid());

		if (abstractBuilding.isSetLod3Solid())
			visit(abstractBuilding.getLod3Solid());

		if (abstractBuilding.isSetLod4Solid())
			visit(abstractBuilding.getLod4Solid());

		if (abstractBuilding.isSetLod1TerrainIntersection())
			visit(abstractBuilding.getLod1TerrainIntersection());

		if (abstractBuilding.isSetLod2TerrainIntersection())
			visit(abstractBuilding.getLod2TerrainIntersection());

		if (abstractBuilding.isSetLod3TerrainIntersection())
			visit(abstractBuilding.getLod3TerrainIntersection());

		if (abstractBuilding.isSetLod4TerrainIntersection())
			visit(abstractBuilding.getLod4TerrainIntersection());

		if (abstractBuilding.isSetLod2MultiCurve())
			visit(abstractBuilding.getLod2MultiCurve());

		if (abstractBuilding.isSetLod3MultiCurve())
			visit(abstractBuilding.getLod3MultiCurve());

		if (abstractBuilding.isSetLod4MultiCurve())
			visit(abstractBuilding.getLod4MultiCurve());

		if (abstractBuilding.isSetLod0FootPrint())
			visit(abstractBuilding.getLod0FootPrint());

		if (abstractBuilding.isSetLod0RoofEdge())
			visit(abstractBuilding.getLod0RoofEdge());

		if (abstractBuilding.isSetLod1MultiSurface())
			visit(abstractBuilding.getLod1MultiSurface());

		if (abstractBuilding.isSetLod2MultiSurface())
			visit(abstractBuilding.getLod2MultiSurface());

		if (abstractBuilding.isSetLod3MultiSurface())
			visit(abstractBuilding.getLod3MultiSurface());

		if (abstractBuilding.isSetLod4MultiSurface())
			visit(abstractBuilding.getLod4MultiSurface());

		if (abstractBuilding.isSetGenericApplicationPropertyOfAbstractBuilding())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBuilding.getGenericApplicationPropertyOfAbstractBuilding()))
				visit(ade);
	}

	public void visit(AbstractCityObject abstractCityObject) {
		visit((AbstractFeature)abstractCityObject);

		if (abstractCityObject.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : new ArrayList<GeneralizationRelation>(abstractCityObject.getGeneralizesTo()))
				visit(generalizationRelation);
		}

		if (abstractCityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : new ArrayList<AppearanceProperty>(abstractCityObject.getAppearance()))
				visit(appearanceProperty);
		}

		if (abstractCityObject.isSetGenericApplicationPropertyOfCityObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractCityObject.getGenericApplicationPropertyOfCityObject()))
				visit(ade);
	}

	public void visit(AbstractCoverage abstractCoverage) {
		visit((AbstractFeature)abstractCoverage);

		if (abstractCoverage.isSetRangeSet()) {
			RangeSet rangeSet = abstractCoverage.getRangeSet();
			if (rangeSet.isSetValueArray()) {
				for (ValueArray valueArray : new ArrayList<ValueArray>(rangeSet.getValueArray()))
					visit(valueArray);
			}

			else if (rangeSet.isSetDataBlock()) {
				DataBlock dataBlock = rangeSet.getDataBlock();
				if (dataBlock.isSetRangeParameters() && dataBlock.getRangeParameters().isSetValueObject())
					visit(dataBlock.getRangeParameters().getValueObject());
			}

			else if (rangeSet.isSetFile()) {
				File file = rangeSet.getFile();
				if (file.isSetRangeParameters() && file.getRangeParameters().isSetValueObject())
					visit(file.getRangeParameters().getValueObject());
			}
		}
	}

	public void visit(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		visit((AbstractCoverage)abstractDiscreteCoverage);
	}

	public void visit(AbstractFeature abstractFeature) {
		visit((AbstractGML)abstractFeature);

		if (abstractFeature.isSetLocation())
			visit(abstractFeature.getLocation());

		if (abstractFeature.isSetGenericADEElement())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractFeature.getGenericADEElement()))
				visit(ade);
	}

	public void visit(AbstractFeatureCollection abstractFeatureCollection) {
		visit((AbstractFeature)abstractFeatureCollection);

		if (abstractFeatureCollection.isSetFeatureMember())
			for (FeatureMember member : new ArrayList<FeatureMember>(abstractFeatureCollection.getFeatureMember()))
				visit(member);

		if (abstractFeatureCollection.isSetFeatureMembers())
			visit(abstractFeatureCollection.getFeatureMembers());
	}

	public void visit(org.citygml4j.model.citygml.bridge.AbstractOpening abstractOpening) {
		visit((AbstractCityObject)abstractOpening);

		if (abstractOpening.isSetLod3MultiSurface())
			visit(abstractOpening.getLod3MultiSurface());

		if (abstractOpening.isSetLod4MultiSurface())
			visit(abstractOpening.getLod4MultiSurface());

		if (abstractOpening.isSetLod3ImplicitRepresentation())
			visit(abstractOpening.getLod3ImplicitRepresentation());

		if (abstractOpening.isSetLod4ImplicitRepresentation())
			visit(abstractOpening.getLod4ImplicitRepresentation());

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.AbstractOpening abstractOpening) {
		visit((AbstractCityObject)abstractOpening);

		if (abstractOpening.isSetLod3MultiSurface())
			visit(abstractOpening.getLod3MultiSurface());

		if (abstractOpening.isSetLod4MultiSurface())
			visit(abstractOpening.getLod4MultiSurface());

		if (abstractOpening.isSetLod3ImplicitRepresentation())
			visit(abstractOpening.getLod3ImplicitRepresentation());

		if (abstractOpening.isSetLod4ImplicitRepresentation())
			visit(abstractOpening.getLod4ImplicitRepresentation());

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.AbstractOpening abstractOpening) {
		visit((AbstractCityObject)abstractOpening);

		if (abstractOpening.isSetLod3MultiSurface())
			visit(abstractOpening.getLod3MultiSurface());

		if (abstractOpening.isSetLod4MultiSurface())
			visit(abstractOpening.getLod4MultiSurface());

		if (abstractOpening.isSetLod3ImplicitRepresentation())
			visit(abstractOpening.getLod3ImplicitRepresentation());

		if (abstractOpening.isSetLod4ImplicitRepresentation())
			visit(abstractOpening.getLod4ImplicitRepresentation());

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening()))
				visit(ade);
	}

	public void visit(AbstractReliefComponent abstractReliefComponent) {
		visit((AbstractCityObject)abstractReliefComponent);

		if (abstractReliefComponent.isSetExtent())
			visit(abstractReliefComponent.getExtent());

		if (abstractReliefComponent.isSetGenericApplicationPropertyOfReliefComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractReliefComponent.getGenericApplicationPropertyOfReliefComponent()))
				visit(ade);
	}

	public void visit(AbstractSite abstractSite) {
		visit((AbstractCityObject)abstractSite);

		if (abstractSite.isSetGenericApplicationPropertyOfSite())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSite.getGenericApplicationPropertyOfSite()))
				visit(ade);
	}

	public void visit(AbstractSurfaceData abstractSurfaceData) {
		visit((AbstractFeature)abstractSurfaceData);

		if (abstractSurfaceData.isSetGenericApplicationPropertyOfSurfaceData())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSurfaceData.getGenericApplicationPropertyOfSurfaceData()))
				visit(ade);
	}

	public void visit(AbstractTexture abstractTexture) {
		visit((AbstractSurfaceData)abstractTexture);

		if (abstractTexture.isSetGenericApplicationPropertyOfTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTexture.getGenericApplicationPropertyOfTexture()))
				visit(ade);
	}

	public void visit(AbstractTransportationObject abstractTransportationObject) {
		visit((AbstractCityObject)abstractTransportationObject);

		if (abstractTransportationObject.isSetGenericApplicationPropertyOfTransportationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTransportationObject.getGenericApplicationPropertyOfTransportationObject()))
				visit(ade);
	}

	public void visit(AbstractTunnel abstractTunnel) {
		visit((AbstractSite)abstractTunnel);

		if (abstractTunnel.isSetOuterTunnelInstallation())
			for (TunnelInstallationProperty tunnelInstallationProperty : new ArrayList<TunnelInstallationProperty>(abstractTunnel.getOuterTunnelInstallation()))
				visit(tunnelInstallationProperty);

		if (abstractTunnel.isSetInteriorTunnelInstallation())
			for (IntTunnelInstallationProperty intTunnelInstallationProperty : new ArrayList<IntTunnelInstallationProperty>(abstractTunnel.getInteriorTunnelInstallation())) 
				visit(intTunnelInstallationProperty);

		if (abstractTunnel.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(abstractTunnel.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (abstractTunnel.isSetConsistsOfTunnelPart())
			for (TunnelPartProperty tunnelPartProperty : new ArrayList<TunnelPartProperty>(abstractTunnel.getConsistsOfTunnelPart()))
				visit(tunnelPartProperty);

		if (abstractTunnel.isSetInteriorHollowSpace())
			for (InteriorHollowSpaceProperty interiorHollowSpaceProperty : new ArrayList<InteriorHollowSpaceProperty>(abstractTunnel.getInteriorHollowSpace()))
				visit(interiorHollowSpaceProperty);

		if (abstractTunnel.isSetLod1Solid())
			visit(abstractTunnel.getLod1Solid());

		if (abstractTunnel.isSetLod2Solid())
			visit(abstractTunnel.getLod2Solid());

		if (abstractTunnel.isSetLod3Solid())
			visit(abstractTunnel.getLod3Solid());

		if (abstractTunnel.isSetLod4Solid())
			visit(abstractTunnel.getLod4Solid());

		if (abstractTunnel.isSetLod1TerrainIntersection())
			visit(abstractTunnel.getLod1TerrainIntersection());

		if (abstractTunnel.isSetLod2TerrainIntersection())
			visit(abstractTunnel.getLod2TerrainIntersection());

		if (abstractTunnel.isSetLod3TerrainIntersection())
			visit(abstractTunnel.getLod3TerrainIntersection());

		if (abstractTunnel.isSetLod4TerrainIntersection())
			visit(abstractTunnel.getLod4TerrainIntersection());

		if (abstractTunnel.isSetLod2MultiCurve())
			visit(abstractTunnel.getLod2MultiCurve());

		if (abstractTunnel.isSetLod3MultiCurve())
			visit(abstractTunnel.getLod3MultiCurve());

		if (abstractTunnel.isSetLod4MultiCurve())
			visit(abstractTunnel.getLod4MultiCurve());

		if (abstractTunnel.isSetLod1MultiSurface())
			visit(abstractTunnel.getLod1MultiSurface());

		if (abstractTunnel.isSetLod2MultiSurface())
			visit(abstractTunnel.getLod2MultiSurface());

		if (abstractTunnel.isSetLod3MultiSurface())
			visit(abstractTunnel.getLod3MultiSurface());

		if (abstractTunnel.isSetLod4MultiSurface())
			visit(abstractTunnel.getLod4MultiSurface());

		if (abstractTunnel.isSetGenericApplicationPropertyOfAbstractTunnel())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTunnel.getGenericApplicationPropertyOfAbstractTunnel()))
				visit(ade);
	}

	public void visit(AbstractVegetationObject abstractVegetationObject) {
		visit((AbstractCityObject)abstractVegetationObject);

		if (abstractVegetationObject.isSetGenericApplicationPropertyOfVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractVegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				visit(ade);
	}

	public void visit(AbstractWaterObject abstractWaterObject) {
		visit((AbstractCityObject)abstractWaterObject);

		if (abstractWaterObject.isSetGenericApplicationPropertyOfWaterObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterObject.getGenericApplicationPropertyOfWaterObject()))
				visit(ade);
	}

	public void visit(AbstractWaterBoundarySurface abstractWaterBoundarySurface) {
		visit((AbstractCityObject)abstractWaterBoundarySurface);

		if (abstractWaterBoundarySurface.isSetLod2Surface())
			visit(abstractWaterBoundarySurface.getLod2Surface());

		if (abstractWaterBoundarySurface.isSetLod3Surface())
			visit(abstractWaterBoundarySurface.getLod3Surface());

		if (abstractWaterBoundarySurface.isSetLod4Surface())
			visit(abstractWaterBoundarySurface.getLod4Surface());

		if (abstractWaterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface()))
				visit(ade);
	}

	public void visit(Appearance appearance) {
		visit((AbstractFeature)appearance);

		if (appearance.isSetSurfaceDataMember())
			for (SurfaceDataProperty surfaceDataProperty : new ArrayList<SurfaceDataProperty>(appearance.getSurfaceDataMember()))
				visit(surfaceDataProperty);

		if (appearance.isSetGenericApplicationPropertyOfAppearance())
			for (ADEComponent ade : new ArrayList<ADEComponent>(appearance.getGenericApplicationPropertyOfAppearance()))
				visit(ade);
	}

	public void visit(GeoreferencedTexture georeferencedTexture) {
		visit((AbstractTexture)georeferencedTexture);

		if (georeferencedTexture.isSetReferencePoint())
			visit(georeferencedTexture.getReferencePoint());

		if (georeferencedTexture.isSetGenericApplicationPropertyOfGeoreferencedTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture()))
				visit(ade);
	}

	public void visit(ParameterizedTexture parameterizedTexture) {
		visit((AbstractTexture)parameterizedTexture);

		if (parameterizedTexture.isSetTarget())
			for (TextureAssociation textureAssociation : new ArrayList<TextureAssociation>(parameterizedTexture.getTarget()))
				visit(textureAssociation);

		if (parameterizedTexture.isSetGenericApplicationPropertyOfParameterizedTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(parameterizedTexture.getGenericApplicationPropertyOfParameterizedTexture()))
				visit(ade);
	}

	public void visit(X3DMaterial x3dMaterial) {
		visit((AbstractSurfaceData)x3dMaterial);

		if (x3dMaterial.isSetGenericApplicationPropertyOfX3DMaterial())
			for (ADEComponent ade : new ArrayList<ADEComponent>(x3dMaterial.getGenericApplicationPropertyOfX3DMaterial()))
				visit(ade);
	}

	public void visit(Bridge bridge) {
		visit((AbstractBridge)bridge);

		if (bridge.isSetGenericApplicationPropertyOfBridge())
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridge.getGenericApplicationPropertyOfBridge()))
				visit(ade);
	}

	public void visit(BridgeConstructionElement bridgeConstructionElement) {
		visit((AbstractCityObject)bridgeConstructionElement);

		if (bridgeConstructionElement.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(bridgeConstructionElement.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (bridgeConstructionElement.isSetLod1Geometry())
			visit(bridgeConstructionElement.getLod1Geometry());

		if (bridgeConstructionElement.isSetLod2Geometry())
			visit(bridgeConstructionElement.getLod2Geometry());

		if (bridgeConstructionElement.isSetLod3Geometry())
			visit(bridgeConstructionElement.getLod3Geometry());

		if (bridgeConstructionElement.isSetLod4Geometry())
			visit(bridgeConstructionElement.getLod4Geometry());

		if (bridgeConstructionElement.isSetLod1ImplicitRepresentation())
			visit(bridgeConstructionElement.getLod1ImplicitRepresentation());

		if (bridgeConstructionElement.isSetLod2ImplicitRepresentation())
			visit(bridgeConstructionElement.getLod2ImplicitRepresentation());

		if (bridgeConstructionElement.isSetLod3ImplicitRepresentation())
			visit(bridgeConstructionElement.getLod3ImplicitRepresentation());

		if (bridgeConstructionElement.isSetLod4ImplicitRepresentation())
			visit(bridgeConstructionElement.getLod4ImplicitRepresentation());

		if (bridgeConstructionElement.isSetLod1TerrainIntersection())
			visit(bridgeConstructionElement.getLod1TerrainIntersection());

		if (bridgeConstructionElement.isSetLod2TerrainIntersection())
			visit(bridgeConstructionElement.getLod2TerrainIntersection());

		if (bridgeConstructionElement.isSetLod3TerrainIntersection())
			visit(bridgeConstructionElement.getLod3TerrainIntersection());

		if (bridgeConstructionElement.isSetLod4TerrainIntersection())
			visit(bridgeConstructionElement.getLod4TerrainIntersection());

		if (bridgeConstructionElement.isSetGenericApplicationPropertyOfBridgeConstructionElement())
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeConstructionElement.getGenericApplicationPropertyOfBridgeConstructionElement()))
				visit(ade);
	}

	public void visit(BridgeFurniture bridgeFurniture) {
		visit((AbstractCityObject)bridgeFurniture);

		if (bridgeFurniture.isSetLod4Geometry())
			visit(bridgeFurniture.getLod4Geometry());

		if (bridgeFurniture.isSetLod4ImplicitRepresentation())
			visit(bridgeFurniture.getLod4ImplicitRepresentation());

		if (bridgeFurniture.isSetGenericApplicationPropertyOfBridgeFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeFurniture.getGenericApplicationPropertyOfBridgeFurniture()))
				visit(ade);
	}

	public void visit(BridgeInstallation bridgeInstallation) {
		visit((AbstractCityObject)bridgeInstallation);

		if (bridgeInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(bridgeInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (bridgeInstallation.isSetLod2Geometry())
			visit(bridgeInstallation.getLod2Geometry());

		if (bridgeInstallation.isSetLod3Geometry())
			visit(bridgeInstallation.getLod3Geometry());

		if (bridgeInstallation.isSetLod4Geometry())
			visit(bridgeInstallation.getLod4Geometry());

		if (bridgeInstallation.isSetLod2ImplicitRepresentation())
			visit(bridgeInstallation.getLod2ImplicitRepresentation());

		if (bridgeInstallation.isSetLod3ImplicitRepresentation())
			visit(bridgeInstallation.getLod3ImplicitRepresentation());

		if (bridgeInstallation.isSetLod4ImplicitRepresentation())
			visit(bridgeInstallation.getLod4ImplicitRepresentation());

		if (bridgeInstallation.isSetGenericApplicationPropertyOfBridgeInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeInstallation.getGenericApplicationPropertyOfBridgeInstallation()))
				visit(ade);
	}

	public void visit(BridgePart bridgePart) {
		visit((AbstractBridge)bridgePart);

		if (bridgePart.isSetGenericApplicationPropertyOfBridgePart())
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgePart.getGenericApplicationPropertyOfBridgePart()))
				visit(ade);
	}

	public void visit(BridgeRoom bridgeRoom) {
		visit((AbstractCityObject)bridgeRoom);

		if (bridgeRoom.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(bridgeRoom.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (bridgeRoom.isSetInteriorFurniture())
			for (org.citygml4j.model.citygml.bridge.InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<org.citygml4j.model.citygml.bridge.InteriorFurnitureProperty>(bridgeRoom.getInteriorFurniture()))
				visit(interiorFurnitureProperty);

		if (bridgeRoom.isSetBridgeRoomInstallation())
			for (IntBridgeInstallationProperty intBridgeInstallationProperty : new ArrayList<IntBridgeInstallationProperty>(bridgeRoom.getBridgeRoomInstallation()))
				visit(intBridgeInstallationProperty);

		if (bridgeRoom.isSetLod4MultiSurface())
			visit(bridgeRoom.getLod4MultiSurface());

		if (bridgeRoom.isSetLod4Solid())
			visit(bridgeRoom.getLod4Solid());

		if (bridgeRoom.isSetGenericApplicationPropertyOfBridgeRoom())
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeRoom.getGenericApplicationPropertyOfBridgeRoom()))
				visit(ade);
	}

	public void visit(IntBridgeInstallation intBridgeInstallation) {
		visit((AbstractCityObject)intBridgeInstallation);

		if (intBridgeInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(intBridgeInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (intBridgeInstallation.isSetLod4Geometry())
			visit(intBridgeInstallation.getLod4Geometry());

		if (intBridgeInstallation.isSetLod4ImplicitRepresentation())
			visit(intBridgeInstallation.getLod4ImplicitRepresentation());

		if (intBridgeInstallation.isSetGenericApplicationPropertyOfIntBridgeInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(intBridgeInstallation.getGenericApplicationPropertyOfIntBridgeInstallation()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.CeilingSurface ceilingSurface) {
		visit((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)ceilingSurface);

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.OuterCeilingSurface outerCeilingSurface) {
		visit((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)outerCeilingSurface);

		if (outerCeilingSurface.isSetGenericApplicationPropertyOfOuterCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerCeilingSurface.getGenericApplicationPropertyOfOuterCeilingSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.ClosureSurface closureSurface) {
		visit((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)closureSurface);

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.FloorSurface floorSurface) {
		visit((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)floorSurface);

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.OuterFloorSurface outerFloorSurface) {
		visit((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)outerFloorSurface);

		if (outerFloorSurface.isSetGenericApplicationPropertyOfOuterFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerFloorSurface.getGenericApplicationPropertyOfOuterFloorSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.GroundSurface groundSurface) {
		visit((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)groundSurface);

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.InteriorWallSurface interiorWallSurface) {
		visit((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)interiorWallSurface);

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.RoofSurface roofSurface) {
		visit((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)roofSurface);

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.WallSurface wallSurface) {
		visit((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)wallSurface);

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.Door door) {
		visit((org.citygml4j.model.citygml.bridge.AbstractOpening)door);

		if (door.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress()))
				visit(addressProperty);

		if (door.isSetGenericApplicationPropertyOfDoor())
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.bridge.Window window) {
		visit((org.citygml4j.model.citygml.bridge.AbstractOpening)window);

		if (window.isSetGenericApplicationPropertyOfWindow())
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow()))
				visit(ade);
	}

	public void visit(Building building) {
		visit((AbstractBuilding)building);

		if (building.isSetGenericApplicationPropertyOfBuilding())
			for (ADEComponent ade : new ArrayList<ADEComponent>(building.getGenericApplicationPropertyOfBuilding()))
				visit(ade);
	}

	public void visit(BuildingFurniture buildingFurniture) {
		visit((AbstractCityObject)buildingFurniture);

		if (buildingFurniture.isSetLod4Geometry())
			visit(buildingFurniture.getLod4Geometry());

		if (buildingFurniture.isSetLod4ImplicitRepresentation())
			visit(buildingFurniture.getLod4ImplicitRepresentation());

		if (buildingFurniture.isSetGenericApplicationPropertyOfBuildingFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture()))
				visit(ade);
	}

	public void visit(BuildingInstallation buildingInstallation) {
		visit((AbstractCityObject)buildingInstallation);

		if (buildingInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.building.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.building.BoundarySurfaceProperty>(buildingInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (buildingInstallation.isSetLod2Geometry())
			visit(buildingInstallation.getLod2Geometry());

		if (buildingInstallation.isSetLod3Geometry())
			visit(buildingInstallation.getLod3Geometry());

		if (buildingInstallation.isSetLod4Geometry())
			visit(buildingInstallation.getLod4Geometry());

		if (buildingInstallation.isSetLod2ImplicitRepresentation())
			visit(buildingInstallation.getLod2ImplicitRepresentation());

		if (buildingInstallation.isSetLod3ImplicitRepresentation())
			visit(buildingInstallation.getLod3ImplicitRepresentation());

		if (buildingInstallation.isSetLod4ImplicitRepresentation())
			visit(buildingInstallation.getLod4ImplicitRepresentation());

		if (buildingInstallation.isSetGenericApplicationPropertyOfBuildingInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingInstallation.getGenericApplicationPropertyOfBuildingInstallation()))
				visit(ade);
	}

	public void visit(BuildingPart buildingPart) {
		visit((AbstractBuilding)buildingPart);

		if (buildingPart.isSetGenericApplicationPropertyOfBuildingPart())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingPart.getGenericApplicationPropertyOfBuildingPart()))
				visit(ade);
	}

	public void visit(IntBuildingInstallation intBuildingInstallation) {
		visit((AbstractCityObject)intBuildingInstallation);

		if (intBuildingInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.building.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.building.BoundarySurfaceProperty>(intBuildingInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (intBuildingInstallation.isSetLod4Geometry())
			visit(intBuildingInstallation.getLod4Geometry());

		if (intBuildingInstallation.isSetLod4ImplicitRepresentation())
			visit(intBuildingInstallation.getLod4ImplicitRepresentation());

		if (intBuildingInstallation.isSetGenericApplicationPropertyOfIntBuildingInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation()))
				visit(ade);
	}

	public void visit(Room room) {
		visit((AbstractCityObject)room);

		if (room.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.building.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.building.BoundarySurfaceProperty>(room.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (room.isSetInteriorFurniture())
			for (org.citygml4j.model.citygml.building.InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<org.citygml4j.model.citygml.building.InteriorFurnitureProperty>(room.getInteriorFurniture()))
				visit(interiorFurnitureProperty);

		if (room.isSetRoomInstallation())
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(room.getRoomInstallation()))
				visit(intBuildingInstallationProperty);

		if (room.isSetLod4MultiSurface())
			visit(room.getLod4MultiSurface());

		if (room.isSetLod4Solid())
			visit(room.getLod4Solid());

		if (room.isSetGenericApplicationPropertyOfRoom())
			for (ADEComponent ade : new ArrayList<ADEComponent>(room.getGenericApplicationPropertyOfRoom()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.CeilingSurface ceilingSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)ceilingSurface);

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.OuterCeilingSurface outerCeilingSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)outerCeilingSurface);

		if (outerCeilingSurface.isSetGenericApplicationPropertyOfOuterCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerCeilingSurface.getGenericApplicationPropertyOfOuterCeilingSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.ClosureSurface closureSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)closureSurface);

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.FloorSurface floorSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)floorSurface);

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.OuterFloorSurface outerFloorSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)outerFloorSurface);

		if (outerFloorSurface.isSetGenericApplicationPropertyOfOuterFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerFloorSurface.getGenericApplicationPropertyOfOuterFloorSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.GroundSurface groundSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)groundSurface);

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.InteriorWallSurface interiorWallSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)interiorWallSurface);

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.RoofSurface roofSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)roofSurface);

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.WallSurface wallSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)wallSurface);

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.Door door) {
		visit((org.citygml4j.model.citygml.building.AbstractOpening)door);

		if (door.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress()))
				visit(addressProperty);

		if (door.isSetGenericApplicationPropertyOfDoor())
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.Window window) {
		visit((org.citygml4j.model.citygml.building.AbstractOpening)window);

		if (window.isSetGenericApplicationPropertyOfWindow())
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow()))
				visit(ade);
	}

	public void visit(HollowSpace hollowSpace) {
		visit((AbstractCityObject)hollowSpace);

		if (hollowSpace.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(hollowSpace.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (hollowSpace.isSetInteriorFurniture())
			for (org.citygml4j.model.citygml.tunnel.InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.InteriorFurnitureProperty>(hollowSpace.getInteriorFurniture()))
				visit(interiorFurnitureProperty);

		if (hollowSpace.isSetHollowSpaceInstallation())
			for (IntTunnelInstallationProperty intTunnelInstallationProperty : new ArrayList<IntTunnelInstallationProperty>(hollowSpace.getHollowSpaceInstallation()))
				visit(intTunnelInstallationProperty);

		if (hollowSpace.isSetLod4MultiSurface())
			visit(hollowSpace.getLod4MultiSurface());

		if (hollowSpace.isSetLod4Solid())
			visit(hollowSpace.getLod4Solid());

		if (hollowSpace.isSetGenericApplicationPropertyOfHollowSpace())
			for (ADEComponent ade : new ArrayList<ADEComponent>(hollowSpace.getGenericApplicationPropertyOfHollowSpace()))
				visit(ade);
	}

	public void visit(IntTunnelInstallation intTunnelInstallation) {
		visit((AbstractCityObject)intTunnelInstallation);

		if (intTunnelInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(intTunnelInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (intTunnelInstallation.isSetLod4Geometry())
			visit(intTunnelInstallation.getLod4Geometry());

		if (intTunnelInstallation.isSetLod4ImplicitRepresentation())
			visit(intTunnelInstallation.getLod4ImplicitRepresentation());

		if (intTunnelInstallation.isSetGenericApplicationPropertyOfIntTunnelInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(intTunnelInstallation.getGenericApplicationPropertyOfIntTunnelInstallation()))
				visit(ade);
	}

	public void visit(Tunnel tunnel) {
		visit((AbstractTunnel)tunnel);

		if (tunnel.isSetGenericApplicationPropertyOfTunnel())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tunnel.getGenericApplicationPropertyOfTunnel()))
				visit(ade);
	}

	public void visit(TunnelFurniture tunnelFurniture) {
		visit((AbstractCityObject)tunnelFurniture);

		if (tunnelFurniture.isSetLod4Geometry())
			visit(tunnelFurniture.getLod4Geometry());

		if (tunnelFurniture.isSetLod4ImplicitRepresentation())
			visit(tunnelFurniture.getLod4ImplicitRepresentation());

		if (tunnelFurniture.isSetGenericApplicationPropertyOfTunnelFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tunnelFurniture.getGenericApplicationPropertyOfTunnelFurniture()))
				visit(ade);
	}

	public void visit(TunnelInstallation tunnelInstallation) {
		visit((AbstractCityObject)tunnelInstallation);

		if (tunnelInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(tunnelInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

		if (tunnelInstallation.isSetLod2Geometry())
			visit(tunnelInstallation.getLod2Geometry());

		if (tunnelInstallation.isSetLod3Geometry())
			visit(tunnelInstallation.getLod3Geometry());

		if (tunnelInstallation.isSetLod4Geometry())
			visit(tunnelInstallation.getLod4Geometry());

		if (tunnelInstallation.isSetLod2ImplicitRepresentation())
			visit(tunnelInstallation.getLod2ImplicitRepresentation());

		if (tunnelInstallation.isSetLod3ImplicitRepresentation())
			visit(tunnelInstallation.getLod3ImplicitRepresentation());

		if (tunnelInstallation.isSetLod4ImplicitRepresentation())
			visit(tunnelInstallation.getLod4ImplicitRepresentation());

		if (tunnelInstallation.isSetGenericApplicationPropertyOfTunnelInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tunnelInstallation.getGenericApplicationPropertyOfTunnelInstallation()))
				visit(ade);
	}

	public void visit(TunnelPart tunnelPart) {
		visit((AbstractTunnel)tunnelPart);

		if (tunnelPart.isSetGenericApplicationPropertyOfTunnelPart())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tunnelPart.getGenericApplicationPropertyOfTunnelPart()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.CeilingSurface ceilingSurface) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)ceilingSurface);

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.OuterCeilingSurface outerCeilingSurface) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)outerCeilingSurface);

		if (outerCeilingSurface.isSetGenericApplicationPropertyOfOuterCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerCeilingSurface.getGenericApplicationPropertyOfOuterCeilingSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.ClosureSurface closureSurface) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)closureSurface);

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.FloorSurface floorSurface) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)floorSurface);

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.OuterFloorSurface outerFloorSurface) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)outerFloorSurface);

		if (outerFloorSurface.isSetGenericApplicationPropertyOfOuterFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerFloorSurface.getGenericApplicationPropertyOfOuterFloorSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.GroundSurface groundSurface) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)groundSurface);

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.InteriorWallSurface interiorWallSurface) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)interiorWallSurface);

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.RoofSurface roofSurface) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)roofSurface);

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.WallSurface wallSurface) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)wallSurface);

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.Door door) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractOpening)door);

		if (door.isSetGenericApplicationPropertyOfDoor())
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.Window window) {
		visit((org.citygml4j.model.citygml.tunnel.AbstractOpening)window);

		if (window.isSetGenericApplicationPropertyOfWindow())
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow()))
				visit(ade);
	}

	public void visit(CityFurniture cityFurniture) {
		visit((AbstractCityObject)cityFurniture);

		if (cityFurniture.isSetLod1Geometry())
			visit(cityFurniture.getLod1Geometry());

		if (cityFurniture.isSetLod2Geometry())
			visit(cityFurniture.getLod2Geometry());

		if (cityFurniture.isSetLod3Geometry())
			visit(cityFurniture.getLod3Geometry());

		if (cityFurniture.isSetLod4Geometry())
			visit(cityFurniture.getLod4Geometry());

		if (cityFurniture.isSetLod1TerrainIntersection())
			visit(cityFurniture.getLod1TerrainIntersection());

		if (cityFurniture.isSetLod2TerrainIntersection())
			visit(cityFurniture.getLod2TerrainIntersection());

		if (cityFurniture.isSetLod3TerrainIntersection())
			visit(cityFurniture.getLod3TerrainIntersection());

		if (cityFurniture.isSetLod4TerrainIntersection())
			visit(cityFurniture.getLod4TerrainIntersection());

		if (cityFurniture.isSetLod1ImplicitRepresentation())
			visit(cityFurniture.getLod1ImplicitRepresentation());

		if (cityFurniture.isSetLod2ImplicitRepresentation())
			visit(cityFurniture.getLod2ImplicitRepresentation());

		if (cityFurniture.isSetLod3ImplicitRepresentation())
			visit(cityFurniture.getLod3ImplicitRepresentation());

		if (cityFurniture.isSetLod4ImplicitRepresentation())
			visit(cityFurniture.getLod4ImplicitRepresentation());

		if (cityFurniture.isSetGenericApplicationPropertyOfCityFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityFurniture.getGenericApplicationPropertyOfCityFurniture()))
				visit(ade);
	}

	public void visit(CityObjectGroup cityObjectGroup) {
		visit((AbstractCityObject)cityObjectGroup);

		if (cityObjectGroup.isSetGroupMember())
			for (CityObjectGroupMember cityObjectGroupMember : new ArrayList<CityObjectGroupMember>(cityObjectGroup.getGroupMember()))
				visit(cityObjectGroupMember);

		if (cityObjectGroup.isSetGroupParent())
			visit(cityObjectGroup.getGroupParent());

		if (cityObjectGroup.isSetGeometry())
			visit(cityObjectGroup.getGeometry());

		if (cityObjectGroup.isSetGenericApplicationPropertyOfCityObjectGroup())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup()))
				visit(ade);
	}

	public void visit(Address address) {
		visit((AbstractFeature)address);

		if (address.isSetMultiPoint())
			visit(address.getMultiPoint());

		if (address.isSetGenericApplicationPropertyOfAddress())
			for (ADEComponent ade : new ArrayList<ADEComponent>(address.getGenericApplicationPropertyOfAddress()))
				visit(ade);
	}

	public void visit(CityModel cityModel) {
		visit((AbstractFeatureCollection)cityModel);

		if (cityModel.isSetCityObjectMember())
			for (CityObjectMember member : new ArrayList<CityObjectMember>(cityModel.getCityObjectMember()))
				visit(member);

		if (cityModel.isSetAppearanceMember())
			for (AppearanceProperty member : new ArrayList<AppearanceProperty>(cityModel.getAppearanceMember()))
				visit(member);

		if (cityModel.isSetGenericApplicationPropertyOfCityModel())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityModel.getGenericApplicationPropertyOfCityModel()))
				visit(ade);
	}

	public void visit(GenericCityObject genericCityObject) {
		visit((AbstractCityObject)genericCityObject);

		if (genericCityObject.isSetLod0Geometry())
			visit(genericCityObject.getLod0Geometry());

		if (genericCityObject.isSetLod1Geometry())
			visit(genericCityObject.getLod1Geometry());

		if (genericCityObject.isSetLod2Geometry())
			visit(genericCityObject.getLod2Geometry());

		if (genericCityObject.isSetLod3Geometry())
			visit(genericCityObject.getLod3Geometry());

		if (genericCityObject.isSetLod4Geometry())
			visit(genericCityObject.getLod4Geometry());

		if (genericCityObject.isSetLod0TerrainIntersection())
			visit(genericCityObject.getLod0TerrainIntersection());

		if (genericCityObject.isSetLod1TerrainIntersection())
			visit(genericCityObject.getLod1TerrainIntersection());

		if (genericCityObject.isSetLod2TerrainIntersection())
			visit(genericCityObject.getLod2TerrainIntersection());

		if (genericCityObject.isSetLod3TerrainIntersection())
			visit(genericCityObject.getLod3TerrainIntersection());

		if (genericCityObject.isSetLod4TerrainIntersection())
			visit(genericCityObject.getLod4TerrainIntersection());

		if (genericCityObject.isSetLod0ImplicitRepresentation())
			visit(genericCityObject.getLod0ImplicitRepresentation());

		if (genericCityObject.isSetLod1ImplicitRepresentation())
			visit(genericCityObject.getLod1ImplicitRepresentation());

		if (genericCityObject.isSetLod2ImplicitRepresentation())
			visit(genericCityObject.getLod2ImplicitRepresentation());

		if (genericCityObject.isSetLod3ImplicitRepresentation())
			visit(genericCityObject.getLod3ImplicitRepresentation());

		if (genericCityObject.isSetLod4ImplicitRepresentation())
			visit(genericCityObject.getLod4ImplicitRepresentation());
	}

	public void visit(LandUse landUse) {
		visit((AbstractCityObject)landUse);

		if (landUse.isSetLod0MultiSurface())
			visit(landUse.getLod0MultiSurface());

		if (landUse.isSetLod1MultiSurface())
			visit(landUse.getLod1MultiSurface());

		if (landUse.isSetLod2MultiSurface())
			visit(landUse.getLod2MultiSurface());

		if (landUse.isSetLod3MultiSurface())
			visit(landUse.getLod3MultiSurface());

		if (landUse.isSetLod4MultiSurface())
			visit(landUse.getLod4MultiSurface());

		if (landUse.isSetGenericApplicationPropertyOfLandUse())
			for (ADEComponent ade : new ArrayList<ADEComponent>(landUse.getGenericApplicationPropertyOfLandUse()))
				visit(ade);
	}

	public void visit(BreaklineRelief breaklineRelief) {
		visit((AbstractReliefComponent)breaklineRelief);

		if (breaklineRelief.isSetBreaklines())
			visit(breaklineRelief.getBreaklines());

		if (breaklineRelief.isSetRidgeOrValleyLines())
			visit(breaklineRelief.getRidgeOrValleyLines());

		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief()))
				visit(ade);
	}

	public void visit(MassPointRelief massPointRelief) {
		visit((AbstractReliefComponent)massPointRelief);

		if (massPointRelief.isSetReliefPoints())
			visit(massPointRelief.getReliefPoints());

		if (massPointRelief.isSetGenericApplicationPropertyOfMassPointRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(massPointRelief.getGenericApplicationPropertyOfMassPointRelief()))
				visit(ade);
	}

	public void visit(RasterRelief rasterRelief) {
		visit((AbstractReliefComponent)rasterRelief);

		if (rasterRelief.isSetGrid())
			visit(rasterRelief.getGrid());

		if (rasterRelief.isSetGenericApplicationPropertyOfRasterRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(rasterRelief.getGenericApplicationPropertyOfRasterRelief()))
				visit(ade);
	}

	public void visit(ReliefFeature reliefFeature) {
		visit((AbstractCityObject)reliefFeature);

		if (reliefFeature.isSetReliefComponent())
			for (ReliefComponentProperty reliefComponentProperty : new ArrayList<ReliefComponentProperty>(reliefFeature.getReliefComponent()))
				visit(reliefComponentProperty);

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature())
			for (ADEComponent ade : new ArrayList<ADEComponent>(reliefFeature.getGenericApplicationPropertyOfReliefFeature()))
				visit(ade);
	}

	public void visit(TINRelief tinRelief) {
		visit((AbstractReliefComponent)tinRelief);

		if (tinRelief.isSetTin())
			visit(tinRelief.getTin());

		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tinRelief.getGenericApplicationPropertyOfTinRelief()))
				visit(ade);
	}

	public void visit(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		visit((AbstractTransportationObject)auxiliaryTrafficArea);

		if (auxiliaryTrafficArea.isSetLod2MultiSurface())
			visit(auxiliaryTrafficArea.getLod2MultiSurface());

		if (auxiliaryTrafficArea.isSetLod3MultiSurface())
			visit(auxiliaryTrafficArea.getLod3MultiSurface());

		if (auxiliaryTrafficArea.isSetLod4MultiSurface())
			visit(auxiliaryTrafficArea.getLod4MultiSurface());

		if (auxiliaryTrafficArea.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea())
			for (ADEComponent ade : new ArrayList<ADEComponent>(auxiliaryTrafficArea.getGenericApplicationPropertyOfAuxiliaryTrafficArea()))
				visit(ade);
	}

	public void visit(Railway railway) {
		visit((TransportationComplex)railway);

		if (railway.isSetGenericApplicationPropertyOfRailway())
			for (ADEComponent ade : new ArrayList<ADEComponent>(railway.getGenericApplicationPropertyOfRailway()))
				visit(ade);
	}

	public void visit(RectifiedGridCoverage rectifiedGridCoverage) {
		visit((AbstractDiscreteCoverage)rectifiedGridCoverage);

		if (rectifiedGridCoverage.isSetRectifiedGridDomain())
			visit(rectifiedGridCoverage.getRectifiedGridDomain());
	}

	public void visit(Road road) {
		visit((TransportationComplex)road);

		if (road.isSetGenericApplicationPropertyOfRoad())
			for (ADEComponent ade : new ArrayList<ADEComponent>(road.getGenericApplicationPropertyOfRoad()))
				visit(ade);
	}

	public void visit(Square square) {
		visit((TransportationComplex)square);

		if (square.isSetGenericApplicationPropertyOfSquare())
			for (ADEComponent ade : new ArrayList<ADEComponent>(square.getGenericApplicationPropertyOfSquare()))
				visit(ade);
	}

	public void visit(Track track) {
		visit((TransportationComplex)track);

		if (track.isSetGenericApplicationPropertyOfTrack())
			for (ADEComponent ade : new ArrayList<ADEComponent>(track.getGenericApplicationPropertyOfTrack()))
				visit(ade);
	}

	public void visit(TrafficArea trafficArea) {
		visit((AbstractTransportationObject)trafficArea);

		if (trafficArea.isSetLod2MultiSurface())
			visit(trafficArea.getLod2MultiSurface());

		if (trafficArea.isSetLod3MultiSurface())
			visit(trafficArea.getLod3MultiSurface());

		if (trafficArea.isSetLod4MultiSurface())
			visit(trafficArea.getLod4MultiSurface());

		if (trafficArea.isSetGenericApplicationPropertyOfTrafficArea())
			for (ADEComponent ade : new ArrayList<ADEComponent>(trafficArea.getGenericApplicationPropertyOfTrafficArea()))
				visit(ade);
	}

	public void visit(TransportationComplex transportationComplex) {
		visit((AbstractTransportationObject)transportationComplex);

		if (transportationComplex.isSetTrafficArea())
			for (TrafficAreaProperty trafficAreaProperty : new ArrayList<TrafficAreaProperty>(transportationComplex.getTrafficArea()))
				visit(trafficAreaProperty);

		if (transportationComplex.isSetAuxiliaryTrafficArea())
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : new ArrayList<AuxiliaryTrafficAreaProperty>(transportationComplex.getAuxiliaryTrafficArea()))
				visit(auxiliaryTrafficAreaProperty);

		if (transportationComplex.isSetLod0Network())
			for (GeometricComplexProperty geometricComplexProperty : new ArrayList<GeometricComplexProperty>(transportationComplex.getLod0Network()))
				visit(geometricComplexProperty);

		if (transportationComplex.isSetLod1MultiSurface())
			visit(transportationComplex.getLod1MultiSurface());

		if (transportationComplex.isSetLod2MultiSurface())
			visit(transportationComplex.getLod2MultiSurface());

		if (transportationComplex.isSetLod3MultiSurface())
			visit(transportationComplex.getLod3MultiSurface());

		if (transportationComplex.isSetLod4MultiSurface())
			visit(transportationComplex.getLod4MultiSurface());

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex())
			for (ADEComponent ade : new ArrayList<ADEComponent>(transportationComplex.getGenericApplicationPropertyOfTransportationComplex()))
				visit(ade);
	}

	public void visit(PlantCover plantCover) {
		visit((AbstractVegetationObject)plantCover);

		if (plantCover.isSetLod1MultiSurface())
			visit(plantCover.getLod1MultiSurface());

		if (plantCover.isSetLod2MultiSurface())
			visit(plantCover.getLod2MultiSurface());

		if (plantCover.isSetLod3MultiSurface())
			visit(plantCover.getLod3MultiSurface());

		if (plantCover.isSetLod4MultiSurface())
			visit(plantCover.getLod4MultiSurface());

		if (plantCover.isSetLod1MultiSolid())
			visit(plantCover.getLod1MultiSolid());

		if (plantCover.isSetLod2MultiSolid())
			visit(plantCover.getLod2MultiSolid());

		if (plantCover.isSetLod3MultiSolid())
			visit(plantCover.getLod3MultiSolid());

		if (plantCover.isSetLod4MultiSolid())
			visit(plantCover.getLod4MultiSolid());

		if (plantCover.isSetGenericApplicationPropertyOfPlantCover())
			for (ADEComponent ade : new ArrayList<ADEComponent>(plantCover.getGenericApplicationPropertyOfPlantCover()))
				visit(ade);
	}

	public void visit(SolitaryVegetationObject solitaryVegetationObject) {
		visit((AbstractVegetationObject)solitaryVegetationObject);

		if (solitaryVegetationObject.isSetLod1Geometry())
			visit(solitaryVegetationObject.getLod1Geometry());

		if (solitaryVegetationObject.isSetLod2Geometry())
			visit(solitaryVegetationObject.getLod2Geometry());

		if (solitaryVegetationObject.isSetLod3Geometry())
			visit(solitaryVegetationObject.getLod3Geometry());

		if (solitaryVegetationObject.isSetLod4Geometry())
			visit(solitaryVegetationObject.getLod4Geometry());

		if (solitaryVegetationObject.isSetLod1ImplicitRepresentation())
			visit(solitaryVegetationObject.getLod1ImplicitRepresentation());

		if (solitaryVegetationObject.isSetLod2ImplicitRepresentation())
			visit(solitaryVegetationObject.getLod2ImplicitRepresentation());

		if (solitaryVegetationObject.isSetLod3ImplicitRepresentation())
			visit(solitaryVegetationObject.getLod3ImplicitRepresentation());

		if (solitaryVegetationObject.isSetLod4ImplicitRepresentation())
			visit(solitaryVegetationObject.getLod4ImplicitRepresentation());

		if (solitaryVegetationObject.isSetGenericApplicationPropertyOfSolitaryVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(solitaryVegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				visit(ade);
	}

	public void visit(WaterBody waterBody) {
		visit((AbstractWaterObject)waterBody);

		if (waterBody.isSetBoundedBySurface())
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : new ArrayList<BoundedByWaterSurfaceProperty>(waterBody.getBoundedBySurface()))
				visit(boundedByWaterSurfaceProperty);

		if (waterBody.isSetLod0MultiCurve())
			visit(waterBody.getLod0MultiCurve());

		if (waterBody.isSetLod1MultiCurve())
			visit(waterBody.getLod1MultiCurve());

		if (waterBody.isSetLod0MultiSurface())
			visit(waterBody.getLod0MultiSurface());

		if (waterBody.isSetLod1MultiSurface())
			visit(waterBody.getLod1MultiSurface());

		if (waterBody.isSetLod1Solid())
			visit(waterBody.getLod1Solid());

		if (waterBody.isSetLod2Solid())
			visit(waterBody.getLod2Solid());

		if (waterBody.isSetLod3Solid())
			visit(waterBody.getLod3Solid());

		if (waterBody.isSetLod4Solid())
			visit(waterBody.getLod4Solid());

		if (waterBody.isSetGenericApplicationPropertyOfWaterBody())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterBody.getGenericApplicationPropertyOfWaterBody()))
				visit(ade);
	}

	public void visit(WaterClosureSurface waterClosureSurface) {
		visit((AbstractWaterBoundarySurface)waterClosureSurface);

		if (waterClosureSurface.isSetGenericApplicationPropertyOfWaterClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface()))
				visit(ade);
	}

	public void visit(WaterGroundSurface waterGroundSurface) {
		visit((AbstractWaterBoundarySurface)waterGroundSurface);

		if (waterGroundSurface.isSetGenericApplicationPropertyOfWaterGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface()))
				visit(ade);
	}

	public void visit(WaterSurface waterSurface) {
		visit((AbstractWaterBoundarySurface)waterSurface);

		if (waterSurface.isSetGenericApplicationPropertyOfWaterSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterSurface.getGenericApplicationPropertyOfWaterSurface()))
				visit(ade);
	}

	public void visit(AbstractTextureParameterization abstractTextureParameterization) {
		visit((AbstractGML)abstractTextureParameterization);

		if (abstractTextureParameterization.isSetGenericApplicationPropertyOfTextureParameterization())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTextureParameterization.getGenericApplicationPropertyOfTextureParameterization()))
				visit(ade);

		if (abstractTextureParameterization.isSetGenericADEComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTextureParameterization.getGenericADEElement()))
				visit(ade);		
	}

	public void visit(_AbstractAppearance abstractAppearance) {
		visit((AbstractGML)abstractAppearance);
	}

	public void visit(CompositeValue compositeValue) {
		visit((AbstractGML)compositeValue);

		if (compositeValue.isSetValueComponent()) {
			for (ValueProperty valueProperty : new ArrayList<ValueProperty>(compositeValue.getValueComponent())) {
				if (valueProperty.isSetValue())
					visit(valueProperty.getValue());
			}
		}

		if (compositeValue.isSetValueComponents()) {
			ValueArrayProperty valueArrayProperty = compositeValue.getValueComponents();
			if (valueArrayProperty.isSetValue()) {
				for (Value value : new ArrayList<Value>(valueArrayProperty.getValue()))
					visit(value);
			}
		}
	}

	public void visit(ValueArray valueArray) {
		visit((CompositeValue)valueArray);
	}

	public void visit(TexCoordGen texCoordGen) {
		visit((AbstractTextureParameterization)texCoordGen);

		if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen())
			for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordGen.getGenericApplicationPropertyOfTexCoordGen()))
				visit(ade);
	}

	public void visit(TexCoordList texCoordList) {
		visit((AbstractTextureParameterization)texCoordList);

		if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList())
			for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordList.getGenericApplicationPropertyOfTexCoordList()))
				visit(ade);
	}

	public void visit(ImplicitGeometry implicitGeometry) {
		visit((AbstractGML)implicitGeometry);

		if (implicitGeometry.isSetRelativeGMLGeometry())
			visit(implicitGeometry.getRelativeGMLGeometry());

		if (implicitGeometry.isSetReferencePoint())
			visit(implicitGeometry.getReferencePoint());
	}

	public void visit(_Material material) {
		visit((_AbstractAppearance)material);
	}

	public void visit(_SimpleTexture simpleTexture) {
		visit((_AbstractAppearance)simpleTexture);
	}

	public <T extends AbstractGML> void visit(AssociationByRep<T> association) {
		if (association.isSetObject() && shouldWalk)
			association.getObject().accept(this);
	}

	public <T extends AbstractGML> void visit(AssociationByRepOrRef<T> association) {
		visit((AssociationByRep<T>)association);
	}

	public <T extends AbstractFeature> void visit(FeatureProperty<T> featureProperty) {
		if (featureProperty.isSetFeature() && shouldWalk)
			featureProperty.getFeature().accept(this);

		if (featureProperty.isSetGenericADEElement())
			visit(featureProperty.getGenericADEElement());
	}

	public void visit(FeatureArrayProperty featureArrayProperty) {
		if (featureArrayProperty.isSetFeature()) {
			for (AbstractFeature feature : new ArrayList<AbstractFeature>(featureArrayProperty.getFeature()))
				if (shouldWalk)
					feature.accept(this);

			if (featureArrayProperty.isSetGenericADEElement())
				for (ADEComponent ade : new ArrayList<ADEComponent>(featureArrayProperty.getGenericADEElement()))
					visit(ade);
		}
	}

	public <T extends AbstractGeometry> void visit(GeometryProperty<T> geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk)
			geometryProperty.getGeometry().accept(this);
	}

	public <T extends AbstractGeometry> void visit(InlineGeometryProperty<T> geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk)
			geometryProperty.getGeometry().accept(this);
	}

	public <T extends AbstractGeometry> void visit(GeometryArrayProperty<T> geometryArrayProperty) {
		if (geometryArrayProperty.isSetGeometry()) {
			for (AbstractGeometry abstractGeometry : new ArrayList<AbstractGeometry>(geometryArrayProperty.getGeometry()))
				if (shouldWalk)
					abstractGeometry.accept(this);
		}
	}

	public void visit(SurfacePatchArrayProperty surfacePatchArrayProperty) {
		if (surfacePatchArrayProperty.isSetSurfacePatch())
			for (AbstractSurfacePatch abstractSurfacePatch : new ArrayList<AbstractSurfacePatch>(surfacePatchArrayProperty.getSurfacePatch())) {
				if (shouldWalk) {
					if (abstractSurfacePatch instanceof Triangle)
						visit((Triangle)abstractSurfacePatch);
					else if (abstractSurfacePatch instanceof Rectangle)
						visit((Rectangle)abstractSurfacePatch);
				}
			}
	}

	public void visit(Element element, ElementDecl decl) {
		iterateNodeList(element, decl);
	}

	public void visit(ADEComponent adeComponent) {
		switch (adeComponent.getADEClass()) {
		case GENERIC_ELEMENT:
			visit((ADEGenericElement)adeComponent);
			break;
		case MODEL_OBJECT:
			visit((ADEModelObject)adeComponent);
			break;
		}
	}

	public void visit(ADEModelObject adeModelObject) {
		if (adeWalkerHelper != null)
			adeWalkerHelper.invokeWalkerMethod(adeModelObject, "visit");
	}

	public void visit(ADEGenericElement adeGenericElement) {
		if (adeGenericElement.isSetContent() && shouldWalk && schemaHandler != null)
			adeGenericElement(adeGenericElement.getContent(), null); 
	}

	private void adeGenericElement(Element element, ElementDecl decl) {
		Schema schema = schemaHandler.getSchema(element.getNamespaceURI());

		if (schema != null) {
			decl = schema.getElementDecl(element.getLocalName(), decl);
			if (decl != null && (decl.isAbstractGML() || decl.isFeatureProperty() || decl.isGeometryProperty()))
				visit(element, decl);
			else
				iterateNodeList(element, decl);
		}
	}

	private void iterateNodeList(Element element, ElementDecl decl) {
		NodeList nodeList = element.getChildNodes();

		List<Element> children = new ArrayList<Element>(nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); ++i) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
				children.add((Element)node);
		}	

		for (Element child : children)
			if (shouldWalk)
				adeGenericElement((Element)child, decl);
	}

	protected void visit(Value value) {
		if (value.isSetGeometry() && shouldWalk)
			value.getGeometry().accept(this);		
		else if (value.isSetValueObject())
			visit(value.getValueObject());
	}

	protected void visit(ValueObject valueObject) {
		if (valueObject.isSetCompositeValue())
			valueObject.getCompositeValue().accept(this);
	}

}
