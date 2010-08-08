package org.citygml4j.visitor.walker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceProperty;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.SurfaceDataProperty;
import org.citygml4j.model.citygml.appearance.TexCoordGen;
import org.citygml4j.model.citygml.appearance.TexCoordList;
import org.citygml4j.model.citygml.appearance.TextureAssociation;
import org.citygml4j.model.citygml.appearance.TextureParameterization;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.BoundarySurface;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.BuildingPartProperty;
import org.citygml4j.model.citygml.building.CeilingSurface;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.InteriorWallSurface;
import org.citygml4j.model.citygml.building.Opening;
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.cityfurniture.CityFurniture;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObject;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.core.GeneralizationRelation;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.Site;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponent;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.texturedsurface._Appearance;
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
import org.citygml4j.model.citygml.texturedsurface._Material;
import org.citygml4j.model.citygml.texturedsurface._SimpleTexture;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.Track;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.citygml.transportation.TransportationObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.citygml.vegetation.VegetationObject;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterObject;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.gml.AbstractCoverage;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.AbstractDiscreteCoverage;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.AbstractFeatureCollection;
import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.AbstractGeometricAggregate;
import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.AbstractRingProperty;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.Association;
import org.citygml4j.model.gml.CompositeCurve;
import org.citygml4j.model.gml.CompositeCurveProperty;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSolidProperty;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.CompositeSurfaceProperty;
import org.citygml4j.model.gml.CompositeValue;
import org.citygml4j.model.gml.Curve;
import org.citygml4j.model.gml.CurveArrayProperty;
import org.citygml4j.model.gml.CurveProperty;
import org.citygml4j.model.gml.FeatureArrayProperty;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.GenericValueObject;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricComplexProperty;
import org.citygml4j.model.gml.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.Grid;
import org.citygml4j.model.gml.LineString;
import org.citygml4j.model.gml.LineStringProperty;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.LinearRingProperty;
import org.citygml4j.model.gml.LocationProperty;
import org.citygml4j.model.gml.MultiCurve;
import org.citygml4j.model.gml.MultiCurveProperty;
import org.citygml4j.model.gml.MultiLineString;
import org.citygml4j.model.gml.MultiLineStringProperty;
import org.citygml4j.model.gml.MultiPoint;
import org.citygml4j.model.gml.MultiPointProperty;
import org.citygml4j.model.gml.MultiPolygon;
import org.citygml4j.model.gml.MultiPolygonProperty;
import org.citygml4j.model.gml.MultiSolid;
import org.citygml4j.model.gml.MultiSolidProperty;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.OrientableCurve;
import org.citygml4j.model.gml.OrientableSurface;
import org.citygml4j.model.gml.Point;
import org.citygml4j.model.gml.PointArrayProperty;
import org.citygml4j.model.gml.PointProperty;
import org.citygml4j.model.gml.Polygon;
import org.citygml4j.model.gml.PolygonProperty;
import org.citygml4j.model.gml.PriorityLocationProperty;
import org.citygml4j.model.gml.RangeSet;
import org.citygml4j.model.gml.Rectangle;
import org.citygml4j.model.gml.RectifiedGrid;
import org.citygml4j.model.gml.RectifiedGridCoverage;
import org.citygml4j.model.gml.RectifiedGridDomain;
import org.citygml4j.model.gml.Ring;
import org.citygml4j.model.gml.Solid;
import org.citygml4j.model.gml.SolidArrayProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.gml.Surface;
import org.citygml4j.model.gml.SurfaceArrayProperty;
import org.citygml4j.model.gml.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.SurfaceProperty;
import org.citygml4j.model.gml.Tin;
import org.citygml4j.model.gml.Triangle;
import org.citygml4j.model.gml.TrianglePatchArrayProperty;
import org.citygml4j.model.gml.TriangulatedSurface;
import org.citygml4j.model.gml.Value;
import org.citygml4j.model.gml.ValueArray;
import org.citygml4j.model.gml.ValueArrayProperty;
import org.citygml4j.model.gml.ValueObject;
import org.citygml4j.model.gml.ValueProperty;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class GMLWalker implements GMLVisitor, Walker {
	private Set<Object> visited = new HashSet<Object>();
	private boolean shouldWalk = true;
	private SchemaHandler schemaHandler;

	public GMLWalker() {
		try {
			schemaHandler = SchemaHandler.newInstance();
		} catch (SAXException e) {
			//
		}
	}

	public GMLWalker(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
	}

	public void reset() {		
		visited.clear();
		shouldWalk = true;
	}

	public boolean shouldWalk() {
		return shouldWalk;
	}

	public void setShouldWalk(boolean shouldWalk) {
		this.shouldWalk = shouldWalk;
	}

	public void setSchemaHandler(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
	}

	public SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}

	public boolean addToVisited(Object object) {
		return visited.add(object);
	}

	public boolean hasVisited(Object object) {
		return visited.contains(object);
	}

	public void accept(AbstractGML abstractGML) {
	}

	public void accept(AbstractCoverage abstractCoverage) {
		if (abstractCoverage.isSetRangeSet()) {
			RangeSet rangeSet = abstractCoverage.getRangeSet();
			if (rangeSet.isSetValueArray()) {
				for (ValueArray valueArray : rangeSet.getValueArray())
					accept(valueArray);
			}
		}

		accept((AbstractFeature)abstractCoverage);
	}
	
	public void accept(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		accept((AbstractCoverage)abstractDiscreteCoverage);
	}
	
	public void accept(AbstractFeature abstractFeature) {
		if (abstractFeature.isSetLocation())
			accept(abstractFeature.getLocation());

		if (abstractFeature.isSetGenericADEComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractFeature.getGenericADEComponent()))
				accept(ade);

		accept((AbstractGML)abstractFeature);
	}

	public void accept(AbstractFeatureCollection abstractFeatureCollection) {
		if (abstractFeatureCollection.isSetFeatureMember())
			for (FeatureProperty<? extends AbstractFeature> member : new ArrayList<FeatureProperty<? extends AbstractFeature>>(abstractFeatureCollection.getFeatureMember()))
				accept(member);

		if (abstractFeatureCollection.isSetFeatureMembers()) {
			FeatureArrayProperty featureProperty = abstractFeatureCollection.getFeatureMembers();
			for (AbstractFeature feature : new ArrayList<AbstractFeature>(featureProperty.getFeature()))
				if (feature != null && shouldWalk && visited.add(feature))
					feature.visit(this);

			if (featureProperty.isSetGenericADEComponent())
				for (ADEComponent ade : new ArrayList<ADEComponent>(featureProperty.getGenericADEComponent()))
					accept(ade);
		}

		accept((AbstractFeature)abstractFeatureCollection);
	}

	public void accept(CityObject cityObject) {
		if (cityObject.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : new ArrayList<GeneralizationRelation>(cityObject.getGeneralizesTo()))
				accept(generalizationRelation);
		}

		if (cityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : new ArrayList<AppearanceProperty>(cityObject.getAppearance()))
				accept(appearanceProperty);
		}

		if (cityObject.isSetGenericApplicationPropertyOfCityObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityObject.getGenericApplicationPropertyOfCityObject()))
				accept(ade);

		accept((AbstractFeature)cityObject);		
	}

	public void accept(AbstractBuilding abstractBuilding) {
		if (abstractBuilding.isSetOuterBuildingInstallation())
			for (BuildingInstallationProperty buildingInstallationProperty : new ArrayList<BuildingInstallationProperty>(abstractBuilding.getOuterBuildingInstallation()))
				accept(buildingInstallationProperty);

		if (abstractBuilding.isSetInteriorBuildingInstallation())
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(abstractBuilding.getInteriorBuildingInstallation())) 
				accept(intBuildingInstallationProperty);

		if (abstractBuilding.isSetBoundedBySurface())
			for (BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<BoundarySurfaceProperty>(abstractBuilding.getBoundedBySurface()))
				accept(boundarySurfaceProperty);

		if (abstractBuilding.isSetConsistsOfBuildingPart())
			for (BuildingPartProperty buildingPartProperty : new ArrayList<BuildingPartProperty>(abstractBuilding.getConsistsOfBuildingPart()))
				accept(buildingPartProperty);

		if (abstractBuilding.isSetInteriorRoom())
			for (InteriorRoomProperty interiorRoomProperty : new ArrayList<InteriorRoomProperty>(abstractBuilding.getInteriorRoom()))
				accept(interiorRoomProperty);

		if (abstractBuilding.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(abstractBuilding.getAddress()))
				accept(addressProperty);

		if (abstractBuilding.isSetLod1Solid())
			accept(abstractBuilding.getLod1Solid());

		if (abstractBuilding.isSetLod2Solid())
			accept(abstractBuilding.getLod2Solid());

		if (abstractBuilding.isSetLod3Solid())
			accept(abstractBuilding.getLod3Solid());

		if (abstractBuilding.isSetLod4Solid())
			accept(abstractBuilding.getLod4Solid());

		if (abstractBuilding.isSetLod1TerrainIntersection())
			accept(abstractBuilding.getLod1TerrainIntersection());

		if (abstractBuilding.isSetLod2TerrainIntersection())
			accept(abstractBuilding.getLod2TerrainIntersection());

		if (abstractBuilding.isSetLod3TerrainIntersection())
			accept(abstractBuilding.getLod3TerrainIntersection());

		if (abstractBuilding.isSetLod4TerrainIntersection())
			accept(abstractBuilding.getLod4TerrainIntersection());

		if (abstractBuilding.isSetLod2MultiCurve())
			accept(abstractBuilding.getLod2MultiCurve());

		if (abstractBuilding.isSetLod3MultiCurve())
			accept(abstractBuilding.getLod3MultiCurve());

		if (abstractBuilding.isSetLod4MultiCurve())
			accept(abstractBuilding.getLod4MultiCurve());

		if (abstractBuilding.isSetLod1MultiSurface())
			accept(abstractBuilding.getLod1MultiSurface());

		if (abstractBuilding.isSetLod2MultiSurface())
			accept(abstractBuilding.getLod2MultiSurface());

		if (abstractBuilding.isSetLod3MultiSurface())
			accept(abstractBuilding.getLod3MultiSurface());

		if (abstractBuilding.isSetLod4MultiSurface())
			accept(abstractBuilding.getLod4MultiSurface());

		if (abstractBuilding.isSetGenericApplicationPropertyOfAbstractBuilding())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBuilding.getGenericApplicationPropertyOfAbstractBuilding()))
				accept(ade);

		accept((Site)abstractBuilding);
	}

	public void accept(TransportationObject transportationObject) {
		if (transportationObject.isSetGenericApplicationPropertyOfTransportationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(transportationObject.getGenericApplicationPropertyOfTransportationObject()))
				accept(ade);

		accept((CityObject)transportationObject);
	}

	public void accept(ReliefComponent reliefComponent) {
		if (reliefComponent.isSetExtent())
			accept(reliefComponent.getExtent());

		if (reliefComponent.isSetGenericApplicationPropertyOfReliefComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(reliefComponent.getGenericApplicationPropertyOfReliefComponent()))
				accept(ade);

		accept((CityObject)reliefComponent);
	}

	public void accept(Site site) {
		if (site.isSetGenericApplicationPropertyOfSite())
			for (ADEComponent ade : new ArrayList<ADEComponent>(site.getGenericApplicationPropertyOfSite()))
				accept(ade);

		accept((CityObject)site);
	}

	public void accept(BoundarySurface boundarySurface) {
		if (boundarySurface.isSetOpening())
			for (OpeningProperty openingProperty : new ArrayList<OpeningProperty>(boundarySurface.getOpening()))
				accept(openingProperty);

		if (boundarySurface.isSetLod2MultiSurface())
			accept(boundarySurface.getLod2MultiSurface());

		if (boundarySurface.isSetLod3MultiSurface())
			accept(boundarySurface.getLod3MultiSurface());

		if (boundarySurface.isSetLod4MultiSurface())
			accept(boundarySurface.getLod4MultiSurface());

		if (boundarySurface.isSetGenericApplicationPropertyOfBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(boundarySurface.getGenericApplicationPropertyOfBoundarySurface()))
				accept(ade);

		accept((CityObject)boundarySurface);
	}

	public void accept(Opening opening) {
		if (opening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(opening.getGenericApplicationPropertyOfOpening()))
				accept(ade);

		if (opening.isSetLod3MultiSurface())
			accept(opening.getLod3MultiSurface());

		if (opening.isSetLod4MultiSurface())
			accept(opening.getLod4MultiSurface());

		accept((CityObject)opening);
	}

	public void accept(AbstractSurfaceData abstractSurfaceData) {
		if (abstractSurfaceData.isSetGenericApplicationPropertyOfSurfaceData())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSurfaceData.getGenericApplicationPropertyOfSurfaceData()))
				accept(ade);

		accept((AbstractFeature)abstractSurfaceData);
	}

	public void accept(AbstractTexture abstractTexture) {
		if (abstractTexture.isSetGenericApplicationPropertyOfTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTexture.getGenericApplicationPropertyOfTexture()))
				accept(ade);

		accept((AbstractSurfaceData)abstractTexture);
	}

	public void accept(VegetationObject vegetationObject) {
		if (vegetationObject.isSetGenericApplicationPropertyOfVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(vegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				accept(ade);

		accept((CityObject)vegetationObject);
	}

	public void accept(WaterObject waterObject) {
		if (waterObject.isSetGenericApplicationPropertyOfWaterObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterObject.getGenericApplicationPropertyOfWaterObject()))
				accept(ade);

		accept((CityObject)waterObject);
	}

	public void accept(WaterBoundarySurface waterBoundarySurface) {
		if (waterBoundarySurface.isSetLod2Surface())
			accept(waterBoundarySurface.getLod2Surface());

		if (waterBoundarySurface.isSetLod3Surface())
			accept(waterBoundarySurface.getLod3Surface());

		if (waterBoundarySurface.isSetLod3Surface())
			accept(waterBoundarySurface.getLod3Surface());

		if (waterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface()))
				accept(ade);

		accept((CityObject)waterBoundarySurface);
	}

	public void accept(FeatureProperty<? extends AbstractFeature> featureProperty) {
		if (featureProperty.isSetFeature() && shouldWalk && visited.add(featureProperty.getFeature()))
			featureProperty.getFeature().visit(this);

		if (featureProperty.isSetGenericADEComponent())
			accept(featureProperty.getGenericADEComponent());
	}

	public void accept(Association<? extends AbstractGML> association) {
		if (association.isSetObject() && shouldWalk && visited.add(association.getObject()))
			association.getObject().visit(this);

		if (association.isSetGenericADEComponent())
			accept(association.getGenericADEComponent());
	}

	public void accept(_Appearance appearance) {
		accept((AbstractGML)appearance);
	}
	
	public void accept(CompositeValue compositeValue) {
		if (compositeValue.isSetValueComponent()) {
			for (ValueProperty valueProperty : compositeValue.getValueComponent()) {
				if (valueProperty.isSetValue())
					accept(valueProperty.getValue());
			}
		}

		if (compositeValue.isSetValueComponents()) {
			ValueArrayProperty valueArrayProperty = compositeValue.getValueComponents();
			if (valueArrayProperty.isSetValue()) {
				for (Value value : valueArrayProperty.getValue())
					accept(value);
			}
		}
		
		accept((AbstractGML)compositeValue);
	}

	public void accept(ValueArray valueArray) {
		accept((CompositeValue)valueArray);
	}
	
	public void accept(RectifiedGridCoverage rectifiedGridCoverage) {
		if (rectifiedGridCoverage.isSetRectifiedGridDomain()) {
			RectifiedGridDomain rectifiedGridDomain = rectifiedGridCoverage.getRectifiedGridDomain();
			if (rectifiedGridDomain.isSetGeometry() && shouldWalk && visited.add(rectifiedGridDomain.getGeometry()))
				rectifiedGridDomain.getGeometry().visit(this);
		}
		
		accept((AbstractDiscreteCoverage)rectifiedGridCoverage);
	}

	public void accept(TextureParameterization textureParameterization) {
		if (textureParameterization.isSetGenericApplicationPropertyOfTextureParameterization())
			for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericApplicationPropertyOfTextureParameterization()))
				accept(ade);

		if (textureParameterization.isSetGenericADEComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericADEComponent()))
				accept(ade);		

		accept((AbstractGML)textureParameterization);
	}

	public void accept(TexCoordGen texCoordGen) {
		if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen())
			for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordGen.getGenericApplicationPropertyOfTexCoordGen()))
				accept(ade);

		accept((TextureParameterization)texCoordGen);
	}

	public void accept(TexCoordList texCoordList) {
		if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList())
			for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordList.getGenericApplicationPropertyOfTexCoordList()))
				accept(ade);

		accept((TextureParameterization)texCoordList);
	}

	public void accept(ImplicitGeometry implicitGeometry) {
		if (implicitGeometry.isSetRelativeGMLGeometry())
			accept(implicitGeometry.getRelativeGMLGeometry());

		if (implicitGeometry.isSetReferencePoint())
			accept(implicitGeometry.getReferencePoint());

		accept((AbstractGML)implicitGeometry);
	}

	public void accept(_Material material) {
		accept((_Appearance)material);
	}

	public void accept(_SimpleTexture simpleTexture) {
		accept((_Appearance)simpleTexture);
	}	

	public void accept(Appearance appearance) {
		if (appearance.isSetSurfaceDataMember())
			for (SurfaceDataProperty surfaceDataProperty : new ArrayList<SurfaceDataProperty>(appearance.getSurfaceDataMember()))
				accept(surfaceDataProperty);

		if (appearance.isSetGenericApplicationPropertyOfAppearance())
			for (ADEComponent ade : new ArrayList<ADEComponent>(appearance.getGenericApplicationPropertyOfAppearance()))
				accept(ade);

		accept((AbstractFeature)appearance);
	}

	public void accept(GeoreferencedTexture georeferencedTexture) {
		if (georeferencedTexture.isSetReferencePoint())
			accept(georeferencedTexture.getReferencePoint());

		if (georeferencedTexture.isSetGenericApplicationPropertyOfGeoreferencedTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture()))
				accept(ade);

		accept((AbstractTexture)georeferencedTexture);	
	}

	public void accept(ParameterizedTexture parameterizedTexture) {
		if (parameterizedTexture.isSetTarget()) {
			for (TextureAssociation textureAssociation : new ArrayList<TextureAssociation>(parameterizedTexture.getTarget())) {
				if (textureAssociation.isSetTextureParameterization() && shouldWalk && visited.add(textureAssociation.getTextureParameterization()))
					textureAssociation.getTextureParameterization().visit(this);
			}
		}

		if (parameterizedTexture.isSetGenericApplicationPropertyOfParameterizedTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(parameterizedTexture.getGenericApplicationPropertyOfParameterizedTexture()))
				accept(ade);

		accept((AbstractTexture)parameterizedTexture);
	}

	public void accept(X3DMaterial x3dMaterial) {
		if (x3dMaterial.isSetGenericApplicationPropertyOfX3DMaterial())
			for (ADEComponent ade : new ArrayList<ADEComponent>(x3dMaterial.getGenericApplicationPropertyOfX3DMaterial()))
				accept(ade);

		accept((AbstractSurfaceData)x3dMaterial);
	}

	public void accept(BuildingFurniture buildingFurniture) {
		if (buildingFurniture.isSetLod4Geometry())
			accept(buildingFurniture.getLod4Geometry());

		if (buildingFurniture.isSetLod4ImplicitRepresentation())
			accept(buildingFurniture.getLod4ImplicitRepresentation());

		if (buildingFurniture.isSetGenericApplicationPropertyOfBuildingFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture()))
				accept(ade);

		accept((CityObject)buildingFurniture);
	}

	public void accept(Building building) {
		if (building.isSetGenericApplicationPropertyOfBuilding())
			for (ADEComponent ade : new ArrayList<ADEComponent>(building.getGenericApplicationPropertyOfBuilding()))
				accept(ade);

		accept((AbstractBuilding)building);
	}

	public void accept(BuildingInstallation buildingInstallation) {
		if (buildingInstallation.isSetLod2Geometry())
			accept(buildingInstallation.getLod2Geometry());

		if (buildingInstallation.isSetLod3Geometry())
			accept(buildingInstallation.getLod3Geometry());

		if (buildingInstallation.isSetLod4Geometry())
			accept(buildingInstallation.getLod4Geometry());

		if (buildingInstallation.isSetGenericApplicationPropertyOfBuildingInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingInstallation.getGenericApplicationPropertyOfBuildingInstallation()))
				accept(ade);

		accept((CityObject)buildingInstallation);
	}

	public void accept(BuildingPart buildingPart) {
		if (buildingPart.isSetGenericApplicationPropertyOfBuildingPart())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingPart.getGenericApplicationPropertyOfBuildingPart()))
				accept(ade);

		accept((AbstractBuilding)buildingPart);
	}

	public void accept(CeilingSurface ceilingSurface) {
		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()))
				accept(ade);

		accept((BoundarySurface)ceilingSurface);
	}

	public void accept(ClosureSurface closureSurface) {
		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface()))
				accept(ade);

		accept((BoundarySurface)closureSurface);
	}

	public void accept(Door door) {
		if (door.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress()))
				accept(addressProperty);

		if (door.isSetGenericApplicationPropertyOfDoor())
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor()))
				accept(ade);

		accept((Opening)door);
	}

	public void accept(FloorSurface floorSurface) {
		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface()))
				accept(ade);

		accept((BoundarySurface)floorSurface);
	}

	public void accept(GroundSurface groundSurface) {
		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface()))
				accept(ade);

		accept((BoundarySurface)groundSurface);
	}

	public void accept(IntBuildingInstallation intBuildingInstallation) {
		if (intBuildingInstallation.isSetLod4Geometry())
			accept(intBuildingInstallation.getLod4Geometry());

		if (intBuildingInstallation.isSetGenericApplicationPropertyOfIntBuildingInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation()))
				accept(ade);

		accept((CityObject)intBuildingInstallation);
	}

	public void accept(InteriorWallSurface interiorWallSurface) {
		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()))
				accept(ade);

		accept((BoundarySurface)interiorWallSurface);
	}

	public void accept(RoofSurface roofSurface) {
		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface()))
				accept(ade);

		accept((BoundarySurface)roofSurface);
	}

	public void accept(Room room) {
		if (room.isSetBoundedBySurface())
			for (BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<BoundarySurfaceProperty>(room.getBoundedBySurface()))
				accept(boundarySurfaceProperty);

		if (room.isSetInteriorFurniture())
			for (InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<InteriorFurnitureProperty>(room.getInteriorFurniture()))
				accept(interiorFurnitureProperty);

		if (room.isSetRoomInstallation())
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(room.getRoomInstallation()))
				accept(intBuildingInstallationProperty);

		if (room.isSetLod4MultiSurface())
			accept(room.getLod4MultiSurface());

		if (room.isSetLod4Solid())
			accept(room.getLod4Solid());

		if (room.isSetGenericApplicationPropertyOfRoom())
			for (ADEComponent ade : new ArrayList<ADEComponent>(room.getGenericApplicationPropertyOfRoom()))
				accept(ade);

		accept((CityObject)room);
	}

	public void accept(WallSurface wallSurface) {
		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface()))
				accept(ade);

		accept((BoundarySurface)wallSurface);
	}

	public void accept(Window window) {
		if (window.isSetGenericApplicationPropertyOfWindow())
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow()))
				accept(ade);

		accept((Opening)window);
	}

	public void accept(CityFurniture cityFurniture) {
		if (cityFurniture.isSetLod1Geometry())
			accept(cityFurniture.getLod1Geometry());

		if (cityFurniture.isSetLod2Geometry())
			accept(cityFurniture.getLod2Geometry());

		if (cityFurniture.isSetLod3Geometry())
			accept(cityFurniture.getLod3Geometry());

		if (cityFurniture.isSetLod4Geometry())
			accept(cityFurniture.getLod4Geometry());

		if (cityFurniture.isSetLod1TerrainIntersection())
			accept(cityFurniture.getLod1TerrainIntersection());

		if (cityFurniture.isSetLod2TerrainIntersection())
			accept(cityFurniture.getLod2TerrainIntersection());

		if (cityFurniture.isSetLod3TerrainIntersection())
			accept(cityFurniture.getLod3TerrainIntersection());

		if (cityFurniture.isSetLod4TerrainIntersection())
			accept(cityFurniture.getLod4TerrainIntersection());

		if (cityFurniture.isSetLod1ImplicitRepresentation())
			accept(cityFurniture.getLod1ImplicitRepresentation());

		if (cityFurniture.isSetLod2ImplicitRepresentation())
			accept(cityFurniture.getLod2ImplicitRepresentation());

		if (cityFurniture.isSetLod3ImplicitRepresentation())
			accept(cityFurniture.getLod3ImplicitRepresentation());

		if (cityFurniture.isSetLod4ImplicitRepresentation())
			accept(cityFurniture.getLod4ImplicitRepresentation());

		if (cityFurniture.isSetGenericApplicationPropertyOfCityFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityFurniture.getGenericApplicationPropertyOfCityFurniture()))
				accept(ade);

		accept((CityObject)cityFurniture);
	}

	public void accept(CityObjectGroup cityObjectGroup) {
		if (cityObjectGroup.isSetGroupMember())
			for (CityObjectGroupMember cityObjectGroupMember : new ArrayList<CityObjectGroupMember>(cityObjectGroup.getGroupMember()))
				accept(cityObjectGroupMember);

		if (cityObjectGroup.isSetGroupParent())
			accept(cityObjectGroup.getGroupParent());

		if (cityObjectGroup.isSetGeometry())
			accept(cityObjectGroup.getGeometry());

		if (cityObjectGroup.isSetGenericApplicationPropertyOfCityObjectGroup())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup()))
				accept(ade);

		accept((CityObject)cityObjectGroup);
	}

	public void accept(Address address) {
		if (address.isSetMultiPoint())
			accept(address.getMultiPoint());

		if (address.isSetGenericApplicationPropertyOfAddress())
			for (ADEComponent ade : new ArrayList<ADEComponent>(address.getGenericApplicationPropertyOfAddress()))
				accept(ade);

		accept((AbstractFeature)address);
	}

	public void accept(CityModel cityModel) {
		if (cityModel.isSetCityObjectMember())
			for (CityObjectMember member : new ArrayList<CityObjectMember>(cityModel.getCityObjectMember()))
				accept(member);

		if (cityModel.isSetAppearanceMember())
			for (AppearanceProperty member : new ArrayList<AppearanceProperty>(cityModel.getAppearanceMember()))
				accept(member);

		if (cityModel.isSetGenericApplicationPropertyOfCityModel())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityModel.getGenericApplicationPropertyOfCityModel()))
				accept(ade);

		accept((AbstractFeatureCollection)cityModel);
	}

	public void accept(GenericCityObject genericCityObject) {
		if (genericCityObject.isSetLod0Geometry())
			accept(genericCityObject.getLod0Geometry());

		if (genericCityObject.isSetLod1Geometry())
			accept(genericCityObject.getLod1Geometry());

		if (genericCityObject.isSetLod2Geometry())
			accept(genericCityObject.getLod2Geometry());

		if (genericCityObject.isSetLod3Geometry())
			accept(genericCityObject.getLod3Geometry());

		if (genericCityObject.isSetLod4Geometry())
			accept(genericCityObject.getLod4Geometry());

		if (genericCityObject.isSetLod0TerrainIntersection())
			accept(genericCityObject.getLod0TerrainIntersection());

		if (genericCityObject.isSetLod1TerrainIntersection())
			accept(genericCityObject.getLod1TerrainIntersection());

		if (genericCityObject.isSetLod2TerrainIntersection())
			accept(genericCityObject.getLod2TerrainIntersection());

		if (genericCityObject.isSetLod3TerrainIntersection())
			accept(genericCityObject.getLod3TerrainIntersection());

		if (genericCityObject.isSetLod4TerrainIntersection())
			accept(genericCityObject.getLod4TerrainIntersection());

		if (genericCityObject.isSetLod0ImplicitRepresentation())
			accept(genericCityObject.getLod0ImplicitRepresentation());

		if (genericCityObject.isSetLod1ImplicitRepresentation())
			accept(genericCityObject.getLod1ImplicitRepresentation());

		if (genericCityObject.isSetLod2ImplicitRepresentation())
			accept(genericCityObject.getLod2ImplicitRepresentation());

		if (genericCityObject.isSetLod3ImplicitRepresentation())
			accept(genericCityObject.getLod3ImplicitRepresentation());

		if (genericCityObject.isSetLod4ImplicitRepresentation())
			accept(genericCityObject.getLod4ImplicitRepresentation());

		accept((CityObject)genericCityObject);
	}

	public void accept(LandUse landUse) {
		if (landUse.isSetLod0MultiSurface())
			accept(landUse.getLod0MultiSurface());

		if (landUse.isSetLod1MultiSurface())
			accept(landUse.getLod1MultiSurface());

		if (landUse.isSetLod2MultiSurface())
			accept(landUse.getLod2MultiSurface());

		if (landUse.isSetLod3MultiSurface())
			accept(landUse.getLod3MultiSurface());

		if (landUse.isSetLod4MultiSurface())
			accept(landUse.getLod4MultiSurface());

		if (landUse.isSetGenericApplicationPropertyOfLandUse())
			for (ADEComponent ade : new ArrayList<ADEComponent>(landUse.getGenericApplicationPropertyOfLandUse()))
				accept(ade);

		accept((CityObject)landUse);
	}

	public void accept(BreaklineRelief breaklineRelief) {
		if (breaklineRelief.isSetBreaklines())
			accept(breaklineRelief.getBreaklines());

		if (breaklineRelief.isSetRidgeOrValleyLines())
			accept(breaklineRelief.getRidgeOrValleyLines());

		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief()))
				accept(ade);

		accept((ReliefComponent)breaklineRelief);
	}

	public void accept(MassPointRelief massPointRelief) {
		if (massPointRelief.isSetReliefPoints())
			accept(massPointRelief.getReliefPoints());

		if (massPointRelief.isSetGenericApplicationPropertyOfMassPointRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(massPointRelief.getGenericApplicationPropertyOfMassPointRelief()))
				accept(ade);

		accept((ReliefComponent)massPointRelief);
	}

	public void accept(RasterRelief rasterRelief) {
		if (rasterRelief.isSetGrid())
			accept(rasterRelief.getGrid());
		
		if (rasterRelief.isSetGenericApplicationPropertyOfRasterRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(rasterRelief.getGenericApplicationPropertyOfRasterRelief()))
				accept(ade);

		accept((ReliefComponent)rasterRelief);
	}

	public void accept(ReliefFeature reliefFeature) {
		if (reliefFeature.isSetReliefComponent())
			for (ReliefComponentProperty reliefComponentProperty : new ArrayList<ReliefComponentProperty>(reliefFeature.getReliefComponent()))
				accept(reliefComponentProperty);

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature())
			for (ADEComponent ade : new ArrayList<ADEComponent>(reliefFeature.getGenericApplicationPropertyOfReliefFeature()))
				accept(ade);

		accept((CityObject)reliefFeature);
	}

	public void accept(TINRelief tinRelief) {
		if (tinRelief.isSetTin())
			accept(tinRelief.getTin());

		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tinRelief.getGenericApplicationPropertyOfTinRelief()))
				accept(ade);

		accept((ReliefComponent)tinRelief);
	}

	public void accept(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		if (auxiliaryTrafficArea.isSetLod2MultiSurface())
			accept(auxiliaryTrafficArea.getLod2MultiSurface());

		if (auxiliaryTrafficArea.isSetLod3MultiSurface())
			accept(auxiliaryTrafficArea.getLod3MultiSurface());

		if (auxiliaryTrafficArea.isSetLod4MultiSurface())
			accept(auxiliaryTrafficArea.getLod4MultiSurface());

		if (auxiliaryTrafficArea.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea())
			for (ADEComponent ade : new ArrayList<ADEComponent>(auxiliaryTrafficArea.getGenericApplicationPropertyOfAuxiliaryTrafficArea()))
				accept(ade);

		accept((TransportationObject)auxiliaryTrafficArea);
	}

	public void accept(Railway railway) {
		if (railway.isSetGenericApplicationPropertyOfRailway())
			for (ADEComponent ade : new ArrayList<ADEComponent>(railway.getGenericApplicationPropertyOfRailway()))
				accept(ade);

		accept((TransportationComplex)railway);
	}

	public void accept(Road road) {
		if (road.isSetGenericApplicationPropertyOfRoad())
			for (ADEComponent ade : new ArrayList<ADEComponent>(road.getGenericApplicationPropertyOfRoad()))
				accept(ade);

		accept((TransportationComplex)road);
	}

	public void accept(Square square) {
		if (square.isSetGenericApplicationPropertyOfSquare())
			for (ADEComponent ade : new ArrayList<ADEComponent>(square.getGenericApplicationPropertyOfSquare()))
				accept(ade);

		accept((TransportationComplex)square);
	}

	public void accept(Track track) {
		if (track.isSetGenericApplicationPropertyOfTrack())
			for (ADEComponent ade : new ArrayList<ADEComponent>(track.getGenericApplicationPropertyOfTrack()))
				accept(ade);

		accept((TransportationComplex)track);
	}

	public void accept(TrafficArea trafficArea) {
		if (trafficArea.isSetLod2MultiSurface())
			accept(trafficArea.getLod2MultiSurface());

		if (trafficArea.isSetLod3MultiSurface())
			accept(trafficArea.getLod3MultiSurface());

		if (trafficArea.isSetLod4MultiSurface())
			accept(trafficArea.getLod4MultiSurface());

		if (trafficArea.isSetGenericApplicationPropertyOfTrafficArea())
			for (ADEComponent ade : new ArrayList<ADEComponent>(trafficArea.getGenericApplicationPropertyOfTrafficArea()))
				accept(ade);

		accept((TransportationObject)trafficArea);
	}

	public void accept(TransportationComplex transportationComplex) {
		if (transportationComplex.isSetTrafficArea())
			for (TrafficAreaProperty trafficAreaProperty : new ArrayList<TrafficAreaProperty>(transportationComplex.getTrafficArea()))
				accept(trafficAreaProperty);

		if (transportationComplex.isSetAuxiliaryTrafficArea())
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : new ArrayList<AuxiliaryTrafficAreaProperty>(transportationComplex.getAuxiliaryTrafficArea()))
				accept(auxiliaryTrafficAreaProperty);

		if (transportationComplex.isSetLod0Network())
			for (GeometricComplexProperty geometricComplexProperty : new ArrayList<GeometricComplexProperty>(transportationComplex.getLod0Network()))
				accept(geometricComplexProperty);

		if (transportationComplex.isSetLod1MultiSurface())
			accept(transportationComplex.getLod1MultiSurface());

		if (transportationComplex.isSetLod2MultiSurface())
			accept(transportationComplex.getLod2MultiSurface());

		if (transportationComplex.isSetLod3MultiSurface())
			accept(transportationComplex.getLod3MultiSurface());

		if (transportationComplex.isSetLod4MultiSurface())
			accept(transportationComplex.getLod4MultiSurface());

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex())
			for (ADEComponent ade : new ArrayList<ADEComponent>(transportationComplex.getGenericApplicationPropertyOfTransportationComplex()))
				accept(ade);

		accept((TransportationObject)transportationComplex);
	}

	public void accept(PlantCover plantCover) {
		if (plantCover.isSetLod1MultiSurface())
			accept(plantCover.getLod1MultiSurface());

		if (plantCover.isSetLod2MultiSurface())
			accept(plantCover.getLod2MultiSurface());

		if (plantCover.isSetLod3MultiSurface())
			accept(plantCover.getLod3MultiSurface());

		if (plantCover.isSetLod4MultiSurface())
			accept(plantCover.getLod4MultiSurface());

		if (plantCover.isSetLod1MultiSolid())
			accept(plantCover.getLod1MultiSolid());

		if (plantCover.isSetLod2MultiSolid())
			accept(plantCover.getLod2MultiSolid());

		if (plantCover.isSetLod3MultiSolid())
			accept(plantCover.getLod3MultiSolid());

		if (plantCover.isSetGenericApplicationPropertyOfPlantCover())
			for (ADEComponent ade : new ArrayList<ADEComponent>(plantCover.getGenericApplicationPropertyOfPlantCover()))
				accept(ade);

		accept((VegetationObject)plantCover);
	}

	public void accept(SolitaryVegetationObject solitaryVegetationObject) {
		if (solitaryVegetationObject.isSetLod2Geometry())
			accept(solitaryVegetationObject.getLod2Geometry());

		if (solitaryVegetationObject.isSetLod3Geometry())
			accept(solitaryVegetationObject.getLod3Geometry());

		if (solitaryVegetationObject.isSetLod4Geometry())
			accept(solitaryVegetationObject.getLod4Geometry());

		if (solitaryVegetationObject.isSetLod1ImplicitRepresentation())
			accept(solitaryVegetationObject.getLod1ImplicitRepresentation());

		if (solitaryVegetationObject.isSetLod2ImplicitRepresentation())
			accept(solitaryVegetationObject.getLod2ImplicitRepresentation());

		if (solitaryVegetationObject.isSetLod3ImplicitRepresentation())
			accept(solitaryVegetationObject.getLod3ImplicitRepresentation());

		if (solitaryVegetationObject.isSetLod4ImplicitRepresentation())
			accept(solitaryVegetationObject.getLod4ImplicitRepresentation());

		if (solitaryVegetationObject.isSetGenericApplicationPropertyOfSolitaryVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(solitaryVegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				accept(ade);

		accept((VegetationObject)solitaryVegetationObject);
	}

	public void accept(WaterBody waterBody) {
		if (waterBody.isSetLod0MultiCurve())
			accept(waterBody.getLod0MultiCurve());

		if (waterBody.isSetLod1MultiCurve())
			accept(waterBody.getLod1MultiCurve());

		if (waterBody.isSetLod0MultiSurface())
			accept(waterBody.getLod0MultiSurface());

		if (waterBody.isSetLod1MultiSurface())
			accept(waterBody.getLod1MultiSurface());

		if (waterBody.isSetLod1Solid())
			accept(waterBody.getLod1Solid());

		if (waterBody.isSetLod2Solid())
			accept(waterBody.getLod2Solid());

		if (waterBody.isSetLod3Solid())
			accept(waterBody.getLod3Solid());

		if (waterBody.isSetLod4Solid())
			accept(waterBody.getLod4Solid());

		if (waterBody.isSetBoundedBySurface())
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : new ArrayList<BoundedByWaterSurfaceProperty>(waterBody.getBoundedBySurface()))
				accept(boundedByWaterSurfaceProperty);

		if (waterBody.isSetGenericApplicationPropertyOfWaterBody())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterBody.getGenericApplicationPropertyOfWaterBody()))
				accept(ade);

		accept((WaterObject)waterBody);
	}

	public void accept(WaterClosureSurface waterClosureSurface) {
		if (waterClosureSurface.isSetGenericApplicationPropertyOfWaterClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface()))
				accept(ade);

		accept((WaterBoundarySurface)waterClosureSurface);
	}

	public void accept(WaterGroundSurface waterGroundSurface) {
		if (waterGroundSurface.isSetGenericApplicationPropertyOfWaterGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface()))
				accept(ade);

		accept((WaterBoundarySurface)waterGroundSurface);
	}

	public void accept(WaterSurface waterSurface) {
		if (waterSurface.isSetGenericApplicationPropertyOfWaterSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterSurface.getGenericApplicationPropertyOfWaterSurface()))
				accept(ade);

		accept((WaterBoundarySurface)waterSurface);
	}

	public void accept(AbstractGeometry abstractGeometry) {
		accept((AbstractGML)abstractGeometry);
	}

	public void accept(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		accept((AbstractGeometry)abstractGeometricPrimitive);
	}

	public void accept(AbstractGeometricAggregate abstractGeometricAggregate) {
		accept((AbstractGeometry)abstractGeometricAggregate);
	}

	public void accept(AbstractCurve abstractCurve) {
		accept((AbstractGeometricPrimitive)abstractCurve);
	}

	public void accept(AbstractSolid abstractSolid) {
		accept((AbstractGeometricPrimitive)abstractSolid);
	}

	public void accept(AbstractSurface abstractSurface) {
		accept((AbstractGeometricPrimitive)abstractSurface);
	}

	public void accept(AbstractRing abstractRing) {
		accept((AbstractGeometry)abstractRing);
	}

	public void accept(PointProperty pointProperty) {
		if (pointProperty.isSetPoint() && shouldWalk && visited.add(pointProperty.getPoint()))
			pointProperty.getPoint().visit(this);
	}

	public void accept(CurveProperty curveProperty) {
		if (curveProperty.isSetCurve() && shouldWalk && visited.add(curveProperty.getCurve()))
			curveProperty.getCurve().visit(this);
	}

	public void accept(PolygonProperty polygonProperty) {
		if (polygonProperty.isSetPolygon() && shouldWalk && visited.add(polygonProperty.getPolygon()))
			polygonProperty.getPolygon().visit(this);
	}

	public void accept(SurfaceProperty surfaceProperty) {
		if (surfaceProperty.isSetSurface() && shouldWalk && visited.add(surfaceProperty.getSurface()))
			surfaceProperty.getSurface().visit(this);
	}	

	public void accept(SolidProperty solidProperty) {
		if (solidProperty.isSetSolid() && shouldWalk && visited.add(solidProperty.getSolid()))
			solidProperty.getSolid().visit(this);
	}

	public void accept(CompositeCurveProperty compositeCurveProperty) {
		if (compositeCurveProperty.isSetCompositeCurve() && shouldWalk && visited.add(compositeCurveProperty.getCompositeCurve()))
			compositeCurveProperty.getCompositeCurve().visit(this);
	}

	public void accept(CompositeSolidProperty compositeSolidProperty) {
		if (compositeSolidProperty.isSetCompositeSolid() && shouldWalk && visited.add(compositeSolidProperty.getCompositeSolid()))
			compositeSolidProperty.getCompositeSolid().visit(this);
	}

	public void accept(CompositeSurfaceProperty compositeSurfaceProperty) {
		if (compositeSurfaceProperty.isSetCompositeSurface() && shouldWalk && visited.add(compositeSurfaceProperty.getCompositeSurface()))
			compositeSurfaceProperty.getCompositeSurface().visit(this);
	}

	public void accept(MultiPointProperty multiPointProperty) {
		if (multiPointProperty.isSetMultiPoint() && shouldWalk && visited.add(multiPointProperty.getMultiPoint()))
			multiPointProperty.getMultiPoint().visit(this);
	}

	public void accept(MultiCurveProperty multiCurveProperty) {
		if (multiCurveProperty.isSetMultiCurve() && shouldWalk && visited.add(multiCurveProperty.getMultiCurve()))
			multiCurveProperty.getMultiCurve().visit(this);
	}

	public void accept(MultiLineStringProperty multiLineStringProperty) {
		if (multiLineStringProperty.isSetMultiLineString() && shouldWalk && visited.add(multiLineStringProperty.getMultiLineString()))
			multiLineStringProperty.getMultiLineString().visit(this);
	}

	public void accept(MultiSurfaceProperty multiSurfaceProperty) {
		if (multiSurfaceProperty.isSetMultiSurface() && shouldWalk && visited.add(multiSurfaceProperty.getMultiSurface()))
			multiSurfaceProperty.getMultiSurface().visit(this);
	}

	public void accept(MultiPolygonProperty multiPolygonProperty) {
		if (multiPolygonProperty.isSetMultiPolygon() && shouldWalk && visited.add(multiPolygonProperty.getMultiPolygon()))
			multiPolygonProperty.getMultiPolygon().visit(this);
	}

	public void accept(MultiSolidProperty multiSolidProperty) {
		if (multiSolidProperty.isSetMultiSolid() && shouldWalk && visited.add(multiSolidProperty.getMultiSolid()))
			multiSolidProperty.getMultiSolid().visit(this);
	}

	public void accept(GeometryProperty geometryProperty) {
		if (geometryProperty.isSetGeometry() && shouldWalk && visited.add(geometryProperty.getGeometry()))
			geometryProperty.getGeometry().visit(this);
	}

	public void accept(GeometricPrimitiveProperty geometricPrimitiveProperty) {
		if (geometricPrimitiveProperty.isSetGeometricPrimitive() && shouldWalk && visited.add(geometricPrimitiveProperty.getGeometricPrimitive()))
			geometricPrimitiveProperty.getGeometricPrimitive().visit(this);
	}

	public void accept(GeometricComplexProperty geometricComplexProperty) {
		if (geometricComplexProperty.isSetGeometricComplex() && shouldWalk && visited.add(geometricComplexProperty.getGeometricComplex()))
			geometricComplexProperty.getGeometricComplex().visit(this);

		if (geometricComplexProperty.isSetCompositeCurve() && shouldWalk && visited.add(geometricComplexProperty.getCompositeCurve()))
			geometricComplexProperty.getCompositeCurve().visit(this);

		if (geometricComplexProperty.isSetCompositeSolid() && shouldWalk && visited.add(geometricComplexProperty.getCompositeSolid()))
			geometricComplexProperty.getCompositeSolid().visit(this);

		if (geometricComplexProperty.isSetCompositeSurface() && shouldWalk && visited.add(geometricComplexProperty.getCompositeSurface()))
			geometricComplexProperty.getCompositeSurface().visit(this);
	}

	public void accept(CurveArrayProperty curveArrayProperty) {
		if (curveArrayProperty.isSetCurve())
			for (AbstractCurve abstractCurve : new ArrayList<AbstractCurve>(curveArrayProperty.getCurve()))
				if (shouldWalk && visited.add(abstractCurve))
					abstractCurve.visit(this);
	}

	public void accept(LinearRingProperty linearRingProperty) {
		if (linearRingProperty.isSetLinearRing() && shouldWalk && visited.add(linearRingProperty.getLinearRing()))
			linearRingProperty.getLinearRing().visit(this);
	}

	public void accept(LineStringProperty lineStringProperty) {
		if (lineStringProperty.isSetLineString() && shouldWalk && visited.add(lineStringProperty.getLineString()))
			lineStringProperty.getLineString().visit(this);
	}

	public void accept(PointArrayProperty pointArrayProperty) {
		if (pointArrayProperty.isSetPoint())
			for (Point point : new ArrayList<Point>(pointArrayProperty.getPoint()))
				if (shouldWalk && visited.add(point))
					point.visit(this);
	}

	public void accept(SolidArrayProperty solidArrayProperty) {
		if (solidArrayProperty.isSetSolid())
			for (AbstractSolid abstractSolid : new ArrayList<AbstractSolid>(solidArrayProperty.getSolid()))
				if (shouldWalk && visited.add(abstractSolid))
					abstractSolid.visit(this);
	}

	public void accept(SurfaceArrayProperty surfaceArrayProperty) {
		if (surfaceArrayProperty.isSetSurface())
			for (AbstractSurface abstractSurface : new ArrayList<AbstractSurface>(surfaceArrayProperty.getSurface()))
				if (shouldWalk && visited.add(abstractSurface))
					abstractSurface.visit(this);
	}

	public void accept(AbstractRingProperty abstractRingProperty) {
		if (abstractRingProperty.isSetRing() && shouldWalk && visited.add(abstractRingProperty.getRing()))
			abstractRingProperty.getRing().visit(this);
	}
	
	public void accept(SurfacePatchArrayProperty surfacePatchArrayProperty) {
		if (surfacePatchArrayProperty.isSetSurfacePatch())
			for (AbstractSurfacePatch abstractSurfacePatch : new ArrayList<AbstractSurfacePatch>(surfacePatchArrayProperty.getSurfacePatch())) {
				if (shouldWalk && visited.add(abstractSurfacePatch)) {
					if (abstractSurfacePatch instanceof Triangle)
						accept((Triangle)abstractSurfacePatch);
					else if (abstractSurfacePatch instanceof Rectangle)
						accept((Rectangle)abstractSurfacePatch);
				}
			}
	}

	public void accept(TrianglePatchArrayProperty trianglePatchArrayProperty) {
		accept((SurfacePatchArrayProperty)trianglePatchArrayProperty);
	}

	public void accept(LocationProperty locationProperty) {
		if (locationProperty.isSetGeometry() && shouldWalk && visited.add(locationProperty.getGeometry()))
			locationProperty.getGeometry().visit(this);
	}

	public void accept(PriorityLocationProperty priorityLocationProperty) {
		accept((LocationProperty)priorityLocationProperty);
	}

	public void accept(Triangle triangle) {
		if (triangle.isSetExterior())
			accept(triangle.getExterior());
	}

	public void accept(Rectangle rectangle) {
		if (rectangle.isSetExterior())
			accept(rectangle.getExterior());
	}

	public void accept(CompositeCurve compositeCurve) {
		for (CurveProperty curveProperty : new ArrayList<CurveProperty>(compositeCurve.getCurveMember()))
			accept(curveProperty);

		accept((AbstractCurve)compositeCurve);
	}

	public void accept(CompositeSolid compositeSolid) {
		for (SolidProperty solidProperty : new ArrayList<SolidProperty>(compositeSolid.getSolidMember()))
			accept(solidProperty);

		accept((AbstractSolid)compositeSolid);
	}

	public void accept(CompositeSurface compositeSurface) {
		for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(compositeSurface.getSurfaceMember()))
			accept(surfaceProperty);

		accept((AbstractSurface)compositeSurface);
	}

	public void accept(Curve curve) {
		accept((AbstractCurve)curve);
	}

	public void accept(GeometricComplex geometricComplex) {
		if (geometricComplex.isSetElement())
			for (GeometricPrimitiveProperty geometricPrimitiveProperty : new ArrayList<GeometricPrimitiveProperty>(geometricComplex.getElement()))
				accept(geometricPrimitiveProperty);

		accept((AbstractGeometry)geometricComplex);
	}
	
	public void accept(Grid grid) {
		accept((AbstractGeometry)grid);
	}

	public void accept(LinearRing linearRing) {
		accept((AbstractRing)linearRing);
	}

	public void accept(LineString lineString) {
		accept((AbstractCurve)lineString);
	}

	public void accept(MultiCurve multiCurve) {
		if (multiCurve.isSetCurveMember())
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(multiCurve.getCurveMember()))
				accept(curveProperty);

		if (multiCurve.isSetCurveMembers())
			accept(multiCurve.getCurveMembers());

		accept((AbstractGeometricAggregate)multiCurve);
	}

	public void accept(MultiLineString multiLineString) {
		if (multiLineString.isSetLineStringMember())
			for (LineStringProperty lineStringProperty : new ArrayList<LineStringProperty>(multiLineString.getLineStringMember()))
				accept(lineStringProperty);

		accept((AbstractGeometricAggregate)multiLineString);
	}

	public void accept(MultiPoint multiPoint) {
		if (multiPoint.isSetPointMember())
			for (PointProperty pointProperty : new ArrayList<PointProperty>(multiPoint.getPointMember()))
				accept(pointProperty);

		if (multiPoint.isSetPointMembers())
			accept(multiPoint.getPointMembers());

		accept((AbstractGeometricAggregate)multiPoint);
	}

	public void accept(MultiPolygon multiPolygon) {
		if (multiPolygon.isSetPolygonMember())
			for (PolygonProperty polygonProperty : new ArrayList<PolygonProperty>(multiPolygon.getPolygonMember()))
				accept(polygonProperty);

		accept((AbstractGeometricAggregate)multiPolygon);
	}

	public void accept(MultiSolid multiSolid) {
		if (multiSolid.isSetSolidMember())
			for (SolidProperty solidProperty : new ArrayList<SolidProperty>(multiSolid.getSolidMember()))
				accept(solidProperty);

		if (multiSolid.isSetSolidMembers())
			accept(multiSolid.getSolidMembers());

		accept((AbstractGeometricAggregate)multiSolid);
	}

	public void accept(MultiSurface multiSurface) {
		if (multiSurface.isSetSurfaceMember())
			for (SurfaceProperty surfaceProperty : new ArrayList<SurfaceProperty>(multiSurface.getSurfaceMember()))
				accept(surfaceProperty);

		if (multiSurface.isSetSurfaceMembers())
			accept(multiSurface.getSurfaceMembers());

		accept((AbstractGeometricAggregate)multiSurface);
	}

	public void accept(OrientableCurve orientableCurve) {
		if (orientableCurve.isSetBaseCurve())
			accept(orientableCurve.getBaseCurve());

		accept((AbstractCurve)orientableCurve);

	}

	public void accept(OrientableSurface orientableSurface) {
		if (orientableSurface.isSetBaseSurface())
			accept(orientableSurface.getBaseSurface());

		accept((AbstractSurface)orientableSurface);
	}

	public void accept(_TexturedSurface texturedSurface) {
		if (texturedSurface.isSetAppearance())
			for (_AppearanceProperty appearanceProperty : new ArrayList<_AppearanceProperty>(texturedSurface.getAppearance())) {
				if (appearanceProperty.isSetAppearance() && shouldWalk && visited.add(appearanceProperty.getAppearance()))
					appearanceProperty.getAppearance().visit(this);
			}

		accept((OrientableSurface)texturedSurface);
	}

	public void accept(Point point) {
		accept((AbstractGeometricPrimitive)point);
	}

	public void accept(Polygon polygon) {
		if (polygon.isSetExterior())
			accept(polygon.getExterior());

		if (polygon.isSetInterior())
			for (AbstractRingProperty interior : new ArrayList<AbstractRingProperty>(polygon.getInterior()))
				accept(interior);

		accept((AbstractSurface)polygon);
	}
	
	public void accept(RectifiedGrid rectifiedGrid) {
		if (rectifiedGrid.isSetOrigin())
			accept(rectifiedGrid.getOrigin());
		
		accept((Grid)rectifiedGrid);
	}

	public void accept(Ring ring) {
		if (ring.isSetCurveMember())
			for (CurveProperty curveProperty : new ArrayList<CurveProperty>(ring.getCurveMember()))
				accept(curveProperty);

		accept((AbstractRing)ring);
	}

	public void accept(Solid solid) {
		if (solid.isSetExterior())
			accept(solid.getExterior());

		if (solid.isSetInterior())
			for (SurfaceProperty interior : new ArrayList<SurfaceProperty>(solid.getInterior()))
				accept(interior);

		accept((AbstractSolid)solid);
	}

	public void accept(Surface surface) {
		if (surface.isSetPatches())
			accept(surface.getPatches());

		accept((AbstractSurface)surface);
	}

	public void accept(Tin tin) {
		accept((TriangulatedSurface)tin);
	}

	public void accept(TriangulatedSurface triangulatedSurface) {
		accept((Surface)triangulatedSurface);
	}

	public void accept(Element element, ElementDecl decl) {
		iterateNodeList(element, decl);
	}

	public void accept(ADEComponent adeComponent) {
		if (adeComponent.isSetContent() && shouldWalk && visited.add(adeComponent.getContent()) && schemaHandler != null)
			adeComponent(adeComponent.getContent(), null); 
	}

	protected void adeComponent(Element element, ElementDecl decl) {
		Schema schema = schemaHandler.getSchema(element.getNamespaceURI());

		if (schema != null) {
			decl = schema.getElementDecl(element.getLocalName(), decl);
			if (decl != null && decl.isAbstractGML())
				accept(element, decl);
			else
				iterateNodeList(element, decl);
		}
	}
	
	protected void iterateNodeList(Element element, ElementDecl decl) {
		NodeList nodeList = element.getChildNodes();
		
		List<Element> children = new ArrayList<Element>(nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); ++i) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
				children.add((Element)node);
		}	
		
		for (Element child : children)
			if (shouldWalk && visited.add(child))
				adeComponent((Element)child, decl);
	}
	
	protected void accept(Value value) {
		if (value.isSetGMLObject()) {
			AbstractGML abstractGML = value.getGMLObject();
			if (abstractGML instanceof AbstractFeature && shouldWalk && visited.add(abstractGML))
				((AbstractFeature)abstractGML).visit(this);		
		} else if (value.isSetValueObject()) {
			ValueObject valueObject = value.getValueObject();
			if (valueObject.isSetCompositeValue())
				accept((CompositeValue)valueObject.getCompositeValue());
		} else if (value.isSetGenericValueObject()) {
			GenericValueObject genericValueObject = value.getGenericValueObject();
			if (genericValueObject.isSetContent() && shouldWalk && visited.add(genericValueObject.getContent()))
				adeComponent(genericValueObject.getContent(), null);
		}
	}

}
