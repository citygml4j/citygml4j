package org.citygml4j.visitor.walker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.citygml4j.model.citygml.ade.ADEComponent;
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
import org.citygml4j.model.citygml.building.AbstractBoundarySurface;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.AbstractOpening;
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
import org.citygml4j.model.citygml.building.OpeningProperty;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
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
import org.citygml4j.model.citygml.texturedsurface._AppearanceProperty;
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
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class GMLWalker implements GMLVisitor, Walker {
	private Set<Object> visited = new HashSet<Object>();
	private boolean shouldWalk = true;
	private SchemaHandler schemaHandler;

	public GMLWalker() {
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
				for (ValueArray valueArray : new ArrayList<ValueArray>(rangeSet.getValueArray()))
					accept(valueArray);
			}
			
			else if (rangeSet.isSetDataBlock()) {
				DataBlock dataBlock = rangeSet.getDataBlock();
				if (dataBlock.isSetRangeParameters() && dataBlock.getRangeParameters().isSetValueObject())
					accept(dataBlock.getRangeParameters().getValueObject());
			}
			
			else if (rangeSet.isSetFile()) {
				File file = rangeSet.getFile();
				if (file.isSetRangeParameters() && file.getRangeParameters().isSetValueObject())
					accept(file.getRangeParameters().getValueObject());
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
			for (FeatureMember member : new ArrayList<FeatureMember>(abstractFeatureCollection.getFeatureMember()))
				accept(member);

		if (abstractFeatureCollection.isSetFeatureMembers())
			accept(abstractFeatureCollection.getFeatureMembers());

		accept((AbstractFeature)abstractFeatureCollection);
	}

	public void accept(AbstractCityObject abstractCityObject) {
		if (abstractCityObject.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : new ArrayList<GeneralizationRelation>(abstractCityObject.getGeneralizesTo()))
				accept(generalizationRelation);
		}

		if (abstractCityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : new ArrayList<AppearanceProperty>(abstractCityObject.getAppearance()))
				accept(appearanceProperty);
		}

		if (abstractCityObject.isSetGenericApplicationPropertyOfCityObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractCityObject.getGenericApplicationPropertyOfCityObject()))
				accept(ade);

		accept((AbstractFeature)abstractCityObject);		
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

		accept((AbstractSite)abstractBuilding);
	}

	public void accept(AbstractTransportationObject abstractTransportationObject) {
		if (abstractTransportationObject.isSetGenericApplicationPropertyOfTransportationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTransportationObject.getGenericApplicationPropertyOfTransportationObject()))
				accept(ade);

		accept((AbstractCityObject)abstractTransportationObject);
	}

	public void accept(AbstractReliefComponent abstractReliefComponent) {
		if (abstractReliefComponent.isSetExtent())
			accept(abstractReliefComponent.getExtent());

		if (abstractReliefComponent.isSetGenericApplicationPropertyOfReliefComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractReliefComponent.getGenericApplicationPropertyOfReliefComponent()))
				accept(ade);

		accept((AbstractCityObject)abstractReliefComponent);
	}

	public void accept(AbstractSite abstractSite) {
		if (abstractSite.isSetGenericApplicationPropertyOfSite())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSite.getGenericApplicationPropertyOfSite()))
				accept(ade);

		accept((AbstractCityObject)abstractSite);
	}

	public void accept(AbstractBoundarySurface abstractBoundarySurface) {
		if (abstractBoundarySurface.isSetOpening())
			for (OpeningProperty openingProperty : new ArrayList<OpeningProperty>(abstractBoundarySurface.getOpening()))
				accept(openingProperty);

		if (abstractBoundarySurface.isSetLod2MultiSurface())
			accept(abstractBoundarySurface.getLod2MultiSurface());

		if (abstractBoundarySurface.isSetLod3MultiSurface())
			accept(abstractBoundarySurface.getLod3MultiSurface());

		if (abstractBoundarySurface.isSetLod4MultiSurface())
			accept(abstractBoundarySurface.getLod4MultiSurface());

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()))
				accept(ade);

		accept((AbstractCityObject)abstractBoundarySurface);
	}

	public void accept(AbstractOpening abstractOpening) {
		if (abstractOpening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening()))
				accept(ade);

		if (abstractOpening.isSetLod3MultiSurface())
			accept(abstractOpening.getLod3MultiSurface());

		if (abstractOpening.isSetLod4MultiSurface())
			accept(abstractOpening.getLod4MultiSurface());

		accept((AbstractCityObject)abstractOpening);
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
	
	public void accept(AbstractTextureParameterization abstractTextureParameterization) {
		if (abstractTextureParameterization.isSetGenericApplicationPropertyOfTextureParameterization())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTextureParameterization.getGenericApplicationPropertyOfTextureParameterization()))
				accept(ade);

		if (abstractTextureParameterization.isSetGenericADEComponent())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTextureParameterization.getGenericADEComponent()))
				accept(ade);		

		accept((AbstractGML)abstractTextureParameterization);
	}


	public void accept(AbstractVegetationObject abstractVegetationObject) {
		if (abstractVegetationObject.isSetGenericApplicationPropertyOfVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractVegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				accept(ade);

		accept((AbstractCityObject)abstractVegetationObject);
	}

	public void accept(AbstractWaterObject abstractWaterObject) {
		if (abstractWaterObject.isSetGenericApplicationPropertyOfWaterObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterObject.getGenericApplicationPropertyOfWaterObject()))
				accept(ade);

		accept((AbstractCityObject)abstractWaterObject);
	}

	public void accept(AbstractWaterBoundarySurface abstractWaterBoundarySurface) {
		if (abstractWaterBoundarySurface.isSetLod2Surface())
			accept(abstractWaterBoundarySurface.getLod2Surface());

		if (abstractWaterBoundarySurface.isSetLod3Surface())
			accept(abstractWaterBoundarySurface.getLod3Surface());

		if (abstractWaterBoundarySurface.isSetLod3Surface())
			accept(abstractWaterBoundarySurface.getLod3Surface());

		if (abstractWaterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface()))
				accept(ade);

		accept((AbstractCityObject)abstractWaterBoundarySurface);
	}

	public void accept(_AbstractAppearance abstractAppearance) {
		accept((AbstractGML)abstractAppearance);
	}

	public void accept(CompositeValue compositeValue) {
		if (compositeValue.isSetValueComponent()) {
			for (ValueProperty valueProperty : new ArrayList<ValueProperty>(compositeValue.getValueComponent())) {
				if (valueProperty.isSetValue())
					accept(valueProperty.getValue());
			}
		}

		if (compositeValue.isSetValueComponents()) {
			ValueArrayProperty valueArrayProperty = compositeValue.getValueComponents();
			if (valueArrayProperty.isSetValue()) {
				for (Value value : new ArrayList<Value>(valueArrayProperty.getValue()))
					accept(value);
			}
		}

		accept((AbstractGML)compositeValue);
	}

	public void accept(ValueArray valueArray) {
		accept((CompositeValue)valueArray);
	}

	public void accept(RectifiedGridCoverage rectifiedGridCoverage) {
		if (rectifiedGridCoverage.isSetRectifiedGridDomain())
			accept(rectifiedGridCoverage.getRectifiedGridDomain());

		accept((AbstractDiscreteCoverage)rectifiedGridCoverage);
	}
	
	public void accept(_Material material) {
		accept((_AbstractAppearance)material);
	}

	public void accept(_SimpleTexture simpleTexture) {
		accept((_AbstractAppearance)simpleTexture);
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

	public void accept(TexCoordGen texCoordGen) {
		if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen())
			for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordGen.getGenericApplicationPropertyOfTexCoordGen()))
				accept(ade);

		accept((AbstractTextureParameterization)texCoordGen);
	}

	public void accept(TexCoordList texCoordList) {
		if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList())
			for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordList.getGenericApplicationPropertyOfTexCoordList()))
				accept(ade);

		accept((AbstractTextureParameterization)texCoordList);
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
		if (parameterizedTexture.isSetTarget())
			for (TextureAssociation textureAssociation : new ArrayList<TextureAssociation>(parameterizedTexture.getTarget()))
				accept(textureAssociation);

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

		accept((AbstractCityObject)buildingFurniture);
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

		accept((AbstractCityObject)buildingInstallation);
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

		accept((AbstractBoundarySurface)ceilingSurface);
	}

	public void accept(ClosureSurface closureSurface) {
		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface()))
				accept(ade);

		accept((AbstractBoundarySurface)closureSurface);
	}

	public void accept(Door door) {
		if (door.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress()))
				accept(addressProperty);

		if (door.isSetGenericApplicationPropertyOfDoor())
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor()))
				accept(ade);

		accept((AbstractOpening)door);
	}

	public void accept(FloorSurface floorSurface) {
		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface()))
				accept(ade);

		accept((AbstractBoundarySurface)floorSurface);
	}

	public void accept(GroundSurface groundSurface) {
		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface()))
				accept(ade);

		accept((AbstractBoundarySurface)groundSurface);
	}

	public void accept(IntBuildingInstallation intBuildingInstallation) {
		if (intBuildingInstallation.isSetLod4Geometry())
			accept(intBuildingInstallation.getLod4Geometry());

		if (intBuildingInstallation.isSetGenericApplicationPropertyOfIntBuildingInstallation())
			for (ADEComponent ade : new ArrayList<ADEComponent>(intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation()))
				accept(ade);

		accept((AbstractCityObject)intBuildingInstallation);
	}

	public void accept(InteriorWallSurface interiorWallSurface) {
		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()))
				accept(ade);

		accept((AbstractBoundarySurface)interiorWallSurface);
	}

	public void accept(RoofSurface roofSurface) {
		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface()))
				accept(ade);

		accept((AbstractBoundarySurface)roofSurface);
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

		accept((AbstractCityObject)room);
	}

	public void accept(WallSurface wallSurface) {
		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface()))
				accept(ade);

		accept((AbstractBoundarySurface)wallSurface);
	}

	public void accept(Window window) {
		if (window.isSetGenericApplicationPropertyOfWindow())
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow()))
				accept(ade);

		accept((AbstractOpening)window);
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

		accept((AbstractCityObject)cityFurniture);
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

		accept((AbstractCityObject)cityObjectGroup);
	}

	public void accept(Address address) {
		if (address.isSetMultiPoint())
			accept(address.getMultiPoint());

		if (address.isSetGenericApplicationPropertyOfAddress())
			for (ADEComponent ade : new ArrayList<ADEComponent>(address.getGenericApplicationPropertyOfAddress()))
				accept(ade);

		accept((AbstractFeature)address);
	}
	
	public void accept(ImplicitGeometry implicitGeometry) {
		if (implicitGeometry.isSetRelativeGMLGeometry())
			accept(implicitGeometry.getRelativeGMLGeometry());

		if (implicitGeometry.isSetReferencePoint())
			accept(implicitGeometry.getReferencePoint());

		accept((AbstractGML)implicitGeometry);
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

		accept((AbstractCityObject)genericCityObject);
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

		accept((AbstractCityObject)landUse);
	}

	public void accept(BreaklineRelief breaklineRelief) {
		if (breaklineRelief.isSetBreaklines())
			accept(breaklineRelief.getBreaklines());

		if (breaklineRelief.isSetRidgeOrValleyLines())
			accept(breaklineRelief.getRidgeOrValleyLines());

		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief()))
				accept(ade);

		accept((AbstractReliefComponent)breaklineRelief);
	}

	public void accept(MassPointRelief massPointRelief) {
		if (massPointRelief.isSetReliefPoints())
			accept(massPointRelief.getReliefPoints());

		if (massPointRelief.isSetGenericApplicationPropertyOfMassPointRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(massPointRelief.getGenericApplicationPropertyOfMassPointRelief()))
				accept(ade);

		accept((AbstractReliefComponent)massPointRelief);
	}

	public void accept(RasterRelief rasterRelief) {
		if (rasterRelief.isSetGrid())
			accept(rasterRelief.getGrid());

		if (rasterRelief.isSetGenericApplicationPropertyOfRasterRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(rasterRelief.getGenericApplicationPropertyOfRasterRelief()))
				accept(ade);

		accept((AbstractReliefComponent)rasterRelief);
	}

	public void accept(ReliefFeature reliefFeature) {
		if (reliefFeature.isSetReliefComponent())
			for (ReliefComponentProperty reliefComponentProperty : new ArrayList<ReliefComponentProperty>(reliefFeature.getReliefComponent()))
				accept(reliefComponentProperty);

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature())
			for (ADEComponent ade : new ArrayList<ADEComponent>(reliefFeature.getGenericApplicationPropertyOfReliefFeature()))
				accept(ade);

		accept((AbstractCityObject)reliefFeature);
	}

	public void accept(TINRelief tinRelief) {
		if (tinRelief.isSetTin())
			accept(tinRelief.getTin());

		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tinRelief.getGenericApplicationPropertyOfTinRelief()))
				accept(ade);

		accept((AbstractReliefComponent)tinRelief);
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

		accept((AbstractTransportationObject)auxiliaryTrafficArea);
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

		accept((AbstractTransportationObject)trafficArea);
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

		accept((AbstractTransportationObject)transportationComplex);
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

		accept((AbstractVegetationObject)plantCover);
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

		accept((AbstractVegetationObject)solitaryVegetationObject);
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

		accept((AbstractWaterObject)waterBody);
	}

	public void accept(WaterClosureSurface waterClosureSurface) {
		if (waterClosureSurface.isSetGenericApplicationPropertyOfWaterClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface()))
				accept(ade);

		accept((AbstractWaterBoundarySurface)waterClosureSurface);
	}

	public void accept(WaterGroundSurface waterGroundSurface) {
		if (waterGroundSurface.isSetGenericApplicationPropertyOfWaterGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface()))
				accept(ade);

		accept((AbstractWaterBoundarySurface)waterGroundSurface);
	}

	public void accept(WaterSurface waterSurface) {
		if (waterSurface.isSetGenericApplicationPropertyOfWaterSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterSurface.getGenericApplicationPropertyOfWaterSurface()))
				accept(ade);

		accept((AbstractWaterBoundarySurface)waterSurface);
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
			for (_AppearanceProperty appearanceProperty : new ArrayList<_AppearanceProperty>(texturedSurface.getAppearance()))
				accept(appearanceProperty);

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
	
	public void accept(AssociationByRep<? extends AbstractGML> association) {
		if (association.isSetObject() && shouldWalk && visited.add(association.getObject()))
			association.getObject().visit(this);
	}

	public void accept(AssociationByRepOrRef<? extends AbstractGML> association) {
		accept((AssociationByRep<? extends AbstractGML>)association);
	}

	public void accept(FeatureProperty<? extends AbstractFeature> featureProperty) {
		if (featureProperty.isSetGenericADEComponent())
			accept(featureProperty.getGenericADEComponent());

		accept((AssociationByRepOrRef<? extends AbstractFeature>)featureProperty);		
	}
	
	public void accept(FeatureArrayProperty featureArrayProperty) {
		if (featureArrayProperty.isSetFeature()) {
			for (AbstractFeature feature : new ArrayList<AbstractFeature>(featureArrayProperty.getFeature()))
				if (shouldWalk && visited.add(feature))
					feature.visit(this);

			if (featureArrayProperty.isSetGenericADEComponent())
				for (ADEComponent ade : new ArrayList<ADEComponent>(featureArrayProperty.getGenericADEComponent()))
					accept(ade);
		}
	}

	public void accept(GeometryProperty<? extends AbstractGeometry> geometryProperty) {
		accept((AssociationByRepOrRef<? extends AbstractGeometry>)geometryProperty);
	}

	public void accept(InlineGeometryProperty<? extends AbstractGeometry> geometryProperty) {
		accept((AssociationByRep<? extends AbstractGeometry>)geometryProperty);
	}
	
	public void accept(GeometryArrayProperty<? extends AbstractGeometry> geometryArrayProperty) {
		if (geometryArrayProperty.isSetGeometry()) {
			for (AbstractGeometry abstractGeometry : new ArrayList<AbstractGeometry>(geometryArrayProperty.getGeometry()))
				if (shouldWalk && visited.add(abstractGeometry))
					abstractGeometry.visit(this);
		}
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
		if (value.isSetGeometry() && shouldWalk && visited.add(value.getGeometry()))
			value.getGeometry().visit(this);		
		else if (value.isSetValueObject())
			accept(value.getValueObject());
	}
	
	protected void accept(ValueObject valueObject) {
		if (valueObject.isSetCompositeValue())
			valueObject.getCompositeValue().visit(this);
	}

}
