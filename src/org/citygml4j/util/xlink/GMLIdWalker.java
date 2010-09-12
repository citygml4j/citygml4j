package org.citygml4j.util.xlink;

import java.util.HashSet;
import java.util.Set;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.AbstractTextureParameterization;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.AppearanceMember;
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
import org.citygml4j.model.common.visitor.GMLFunctor;
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
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.xml.schema.ElementDecl;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GMLIdWalker implements GMLFunctor<Object> {
	private Set<Object> visited = new HashSet<Object>();
	private final String gmlId;

	GMLIdWalker(String gmlId) {
		this.gmlId = gmlId;
	}

	public Object apply(LodRepresentation lodRepresentation) {
		// no need to implement this method here
		return null;
	}
	
	public Object apply(AbstractGML abstractGML) {
		return (abstractGML.isSetId() && gmlId.equals(abstractGML.getId())) ? abstractGML : null;
	}

	public Object apply(AbstractCoverage abstractCoverage) {
		Object object = apply((AbstractFeature)abstractCoverage);
		if (object != null)
			return object;

		if (abstractCoverage.isSetRangeSet()) {
			RangeSet rangeSet = abstractCoverage.getRangeSet();
			if (rangeSet.isSetValueArray()) {
				for (ValueArray valueArray : rangeSet.getValueArray()) {
					object = apply(valueArray);
					if (object != null)
						return object;
				}
			}
			
			else if (rangeSet.isSetDataBlock()) {
				DataBlock dataBlock = rangeSet.getDataBlock();
				if (dataBlock.isSetRangeParameters() && dataBlock.getRangeParameters().isSetValueObject()) {
					object = apply(dataBlock.getRangeParameters().getValueObject());
					if (object != null)
						return object;
				}
			}
			
			else if (rangeSet.isSetFile()) {
				File file = rangeSet.getFile();
				if (file.isSetRangeParameters() && file.getRangeParameters().isSetValueObject()) {
					object = apply(file.getRangeParameters().getValueObject());
					if (object != null)
						return object;
				}
			}
		}

		return null;
	}

	public Object apply(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		return apply((AbstractCoverage)abstractDiscreteCoverage);
	}

	public Object apply(AbstractFeature abstractFeature) {
		Object object = apply((AbstractGML)abstractFeature);
		if (object != null)
			return object;

		if (abstractFeature.isSetLocation()) {
			object = apply(abstractFeature.getLocation());
			if (object != null)
				return object;
		}

		if (abstractFeature.isSetGenericADEComponent()) {
			for (ADEComponent ade : abstractFeature.getGenericADEComponent()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(AbstractFeatureCollection abstractFeatureCollection) {
		Object object = apply((AbstractFeature)abstractFeatureCollection);
		if (object != null)
			return object;

		if (abstractFeatureCollection.isSetFeatureMember()) {
			for (FeatureMember featureMember : abstractFeatureCollection.getFeatureMember()) {
				object = apply(featureMember);
				if (object != null)
					return object;
			}
		}

		if (abstractFeatureCollection.isSetFeatureMembers())
			apply(abstractFeatureCollection.getFeatureMembers());

		return null;
	}

	public Object apply(AbstractCityObject abstractCityObject) {
		Object object = apply((AbstractFeature)abstractCityObject);
		if (object != null)
			return object;

		if (abstractCityObject.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : abstractCityObject.getGeneralizesTo()) {
				object = apply(generalizationRelation);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : abstractCityObject.getAppearance()) {
				object = apply(appearanceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent ade : abstractCityObject.getGenericApplicationPropertyOfCityObject()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractTransportationObject abstractTransportationObject) {
		Object object = apply((AbstractCityObject)abstractTransportationObject);
		if (object != null)
			return object;

		if (abstractTransportationObject.isSetGenericApplicationPropertyOfTransportationObject()) {
			for (ADEComponent ade : abstractTransportationObject.getGenericApplicationPropertyOfTransportationObject()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractReliefComponent abstractReliefComponent) {
		Object object = apply((AbstractCityObject)abstractReliefComponent);
		if (object != null)
			return object;

		if (abstractReliefComponent.isSetExtent()) {
			object = apply(abstractReliefComponent.getExtent());
			if (object != null)
				return object;
		}

		if (abstractReliefComponent.isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent ade : abstractReliefComponent.getGenericApplicationPropertyOfReliefComponent()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractSite abstractSite) {
		Object object = apply((AbstractCityObject)abstractSite);
		if (object != null)
			return object;

		if (abstractSite.isSetGenericApplicationPropertyOfSite()) {
			for (ADEComponent ade : abstractSite.getGenericApplicationPropertyOfSite()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractBuilding abstractBuilding) {
		Object object = apply((AbstractSite)abstractBuilding);
		if (object != null)
			return object;

		if (abstractBuilding.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty buildingInstallationProperty : abstractBuilding.getOuterBuildingInstallation()) {
				object = apply(buildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : abstractBuilding.getInteriorBuildingInstallation()) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : abstractBuilding.getBoundedBySurface()) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty buildingPartProperty : abstractBuilding.getConsistsOfBuildingPart()) {
				object = apply(buildingPartProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorRoom()) {
			for (InteriorRoomProperty interiorRoomProperty : abstractBuilding.getInteriorRoom()) {
				object = apply(interiorRoomProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetAddress()) {
			for (AddressProperty addressProperty : abstractBuilding.getAddress()) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetLod1Solid()) {
			object = apply(abstractBuilding.getLod1Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2Solid()) {
			object = apply(abstractBuilding.getLod2Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3Solid()) {
			object = apply(abstractBuilding.getLod3Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4Solid()) {
			object = apply(abstractBuilding.getLod4Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod1TerrainIntersection()) {
			object = apply(abstractBuilding.getLod1TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2TerrainIntersection()) {
			object = apply(abstractBuilding.getLod2TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3TerrainIntersection()) {
			object = apply(abstractBuilding.getLod3TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4TerrainIntersection()) {
			object = apply(abstractBuilding.getLod4TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2MultiCurve()) {
			object = apply(abstractBuilding.getLod2MultiCurve());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3MultiCurve()) {
			object = apply(abstractBuilding.getLod3MultiCurve());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4MultiCurve()) {
			object = apply(abstractBuilding.getLod4MultiCurve());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod1MultiSurface()) {
			object = apply(abstractBuilding.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2MultiSurface()) {
			object = apply(abstractBuilding.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3MultiSurface()) {
			object = apply(abstractBuilding.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4MultiSurface()) {
			object = apply(abstractBuilding.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetGenericApplicationPropertyOfAbstractBuilding()) {
			for (ADEComponent ade : abstractBuilding.getGenericApplicationPropertyOfAbstractBuilding()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractBoundarySurface abstractBoundarySurface) {
		Object object = apply((AbstractCityObject)abstractBoundarySurface);
		if (object != null)
			return object;

		if (abstractBoundarySurface.isSetOpening()) {
			for (OpeningProperty openingProperty : abstractBoundarySurface.getOpening()) {
				object = apply(openingProperty);
				if (object != null)
					return object;					
			}
		}

		if (abstractBoundarySurface.isSetLod2MultiSurface()) {
			object = apply(abstractBoundarySurface.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBoundarySurface.isSetLod3MultiSurface()) {
			object = apply(abstractBoundarySurface.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBoundarySurface.isSetLod4MultiSurface()) {
			object = apply(abstractBoundarySurface.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent ade : abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractOpening abstractOpening) {
		Object object = apply((AbstractCityObject)abstractOpening);
		if (object != null)
			return object;

		if (abstractOpening.isSetLod3MultiSurface()) {
			object = apply(abstractOpening.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractOpening.isSetLod4MultiSurface()) {
			object = apply(abstractOpening.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening()) {
			for (ADEComponent ade : abstractOpening.getGenericApplicationPropertyOfOpening()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractSurfaceData abstractSurfaceData) {
		Object object = apply((AbstractFeature)abstractSurfaceData);
		if (object != null)
			return object;

		if (abstractSurfaceData.isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent ade : abstractSurfaceData.getGenericApplicationPropertyOfSurfaceData()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractTexture abstractTexture) {
		Object object = apply((AbstractSurfaceData)abstractTexture);
		if (object != null)
			return object;

		if (abstractTexture.isSetGenericApplicationPropertyOfTexture()) {
			for (ADEComponent ade : abstractTexture.getGenericApplicationPropertyOfTexture()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractTextureParameterization abstractTextureParameterization) {
		Object object = apply((AbstractGML)abstractTextureParameterization);
		if (object != null)
			return object;

		if (abstractTextureParameterization.isSetGenericADEComponent()) {
			for (ADEComponent ade : abstractTextureParameterization.getGenericADEComponent()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		if (abstractTextureParameterization.isSetGenericApplicationPropertyOfTextureParameterization()) {
			for (ADEComponent ade : abstractTextureParameterization.getGenericApplicationPropertyOfTextureParameterization()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractVegetationObject abstractVegetationObject) {
		Object object = apply((AbstractCityObject)abstractVegetationObject);
		if (object != null)
			return object;

		if (abstractVegetationObject.isSetGenericApplicationPropertyOfVegetationObject()) {
			for (ADEComponent ade : abstractVegetationObject.getGenericApplicationPropertyOfVegetationObject()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractWaterObject abstractWaterObject) {
		Object object = apply((AbstractCityObject)abstractWaterObject);
		if (object != null)
			return object;

		if (abstractWaterObject.isSetGenericApplicationPropertyOfWaterObject()) {
			for (ADEComponent ade : abstractWaterObject.getGenericApplicationPropertyOfWaterObject()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(AbstractWaterBoundarySurface abstractWaterBoundarySurface) {
		Object object = apply((AbstractCityObject)abstractWaterBoundarySurface);
		if (object != null)
			return object;

		if (abstractWaterBoundarySurface.isSetLod2Surface()) {
			object = apply(abstractWaterBoundarySurface.getLod2Surface());
			if (object != null)
				return object;
		}

		if (abstractWaterBoundarySurface.isSetLod3Surface()) {
			object = apply(abstractWaterBoundarySurface.getLod3Surface());
			if (object != null)
				return object;
		}

		if (abstractWaterBoundarySurface.isSetLod3Surface()) {
			object = apply(abstractWaterBoundarySurface.getLod3Surface());
			if (object != null)
				return object;
		}

		if (abstractWaterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent ade : abstractWaterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object apply(_AbstractAppearance abstractAppearance) {
		return apply((AbstractGML)abstractAppearance);
	}

	public Object apply(CompositeValue compositeValue) {
		Object object = apply((AbstractGML)compositeValue);
		if (object != null)
			return object;

		if (compositeValue.isSetValueComponent()) {
			for (ValueProperty valueProperty : compositeValue.getValueComponent()) {
				if (valueProperty.isSetValue()) {
					object = apply(valueProperty.getValue());
					if (object != null)
						return object;
				}
			}
		}

		if (compositeValue.isSetValueComponents()) {
			ValueArrayProperty valueArrayProperty = compositeValue.getValueComponents();
			if (valueArrayProperty.isSetValue()) {
				for (Value value : valueArrayProperty.getValue()) {
					object = apply(value);
					if (object != null)
						return object;
				}
			}
		}

		return null;
	}

	public Object apply(ValueArray valueArray) {
		return apply((CompositeValue)valueArray);
	}

	public Object apply(RectifiedGridCoverage rectifiedGridCoverage) {
		Object object = apply((AbstractDiscreteCoverage)rectifiedGridCoverage);
		if (object != null)
			return object;

		if (rectifiedGridCoverage.isSetRectifiedGridDomain()) {
			object = apply(rectifiedGridCoverage.getRectifiedGridDomain());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(Address address) {
		Object object = apply((AbstractFeature)address);
		if (object != null)
			return object;

		if (address.isSetMultiPoint()) {
			object = apply(address.getMultiPoint());
			if (object != null)
				return object;
		}			

		if (address.isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent ade : address.getGenericApplicationPropertyOfAddress()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Appearance appearance) {
		Object object = apply((AbstractFeature)appearance);
		if (object != null)
			return object;

		if (appearance.isSetSurfaceDataMember())
			for (SurfaceDataProperty surfaceDataProperty : appearance.getSurfaceDataMember()) {
				object = apply(surfaceDataProperty);
				if (object != null)
					return object;
			}

		if (appearance.isSetGenericApplicationPropertyOfAppearance()) {
			for (ADEComponent ade : appearance.getGenericApplicationPropertyOfAppearance()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		Object object = apply((AbstractTransportationObject)auxiliaryTrafficArea);
		if (object != null)
			return object;

		if (auxiliaryTrafficArea.isSetLod2MultiSurface()) {
			object = apply(auxiliaryTrafficArea.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (auxiliaryTrafficArea.isSetLod3MultiSurface()) {
			object = apply(auxiliaryTrafficArea.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (auxiliaryTrafficArea.isSetLod4MultiSurface()) {
			object = apply(auxiliaryTrafficArea.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (auxiliaryTrafficArea.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
			for (ADEComponent ade : auxiliaryTrafficArea.getGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(BreaklineRelief breaklineRelief) {
		Object object = apply((AbstractReliefComponent)breaklineRelief);
		if (object != null)
			return object;

		if (breaklineRelief.isSetBreaklines()) {
			object = apply(breaklineRelief.getBreaklines());
			if (object != null)
				return object;
		}

		if (breaklineRelief.isSetRidgeOrValleyLines()) {
			object = apply(breaklineRelief.getRidgeOrValleyLines());
			if (object != null)
				return object;
		}

		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent ade : breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Building building) {
		Object object = apply((AbstractBuilding)building);
		if (object != null)
			return object;

		if (building.isSetGenericApplicationPropertyOfBuilding()) {
			for (ADEComponent ade : building.getGenericApplicationPropertyOfBuilding()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(BuildingFurniture buildingFurniture) {
		Object object = apply((AbstractCityObject)buildingFurniture);
		if (object != null)
			return object;

		if (buildingFurniture.isSetLod4Geometry()) {
			object = apply(buildingFurniture.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (buildingFurniture.isSetLod4ImplicitRepresentation()) {
			object = apply(buildingFurniture.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (buildingFurniture.isSetGenericApplicationPropertyOfBuildingFurniture()) {
			for (ADEComponent ade : buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(BuildingInstallation buildingInstallation) {
		Object object = apply((AbstractCityObject)buildingInstallation);
		if (object != null)
			return object;

		if (buildingInstallation.isSetLod2Geometry()) {
			object = apply(buildingInstallation.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (buildingInstallation.isSetLod3Geometry()) {
			object = apply(buildingInstallation.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (buildingInstallation.isSetLod4Geometry()) {
			object = apply(buildingInstallation.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (buildingInstallation.isSetGenericApplicationPropertyOfBuildingInstallation()) {
			for (ADEComponent ade : buildingInstallation.getGenericApplicationPropertyOfBuildingInstallation()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(BuildingPart buildingPart) {
		Object object = apply((AbstractBuilding)buildingPart);
		if (object != null)
			return object;

		if (buildingPart.isSetGenericApplicationPropertyOfBuildingPart()) {
			for (ADEComponent ade : buildingPart.getGenericApplicationPropertyOfBuildingPart()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(CeilingSurface ceilingSurface) {
		Object object = apply((AbstractBoundarySurface)ceilingSurface);
		if (object != null)
			return object;

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface()) {
			for (ADEComponent ade : ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(CityFurniture cityFurniture) {
		Object object = apply((AbstractCityObject)cityFurniture);
		if (object != null)
			return object;

		if (cityFurniture.isSetLod1Geometry()) {
			object = apply(cityFurniture.getLod1Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod2Geometry()) {
			object = apply(cityFurniture.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod3Geometry()) {
			object = apply(cityFurniture.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod4Geometry()) {
			object = apply(cityFurniture.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod1TerrainIntersection()) {
			object = apply(cityFurniture.getLod1TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod2TerrainIntersection()) {
			object = apply(cityFurniture.getLod2TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod3TerrainIntersection()) {
			object = apply(cityFurniture.getLod3TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod4TerrainIntersection()) {
			object = apply(cityFurniture.getLod4TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod1ImplicitRepresentation()) {
			object = apply(cityFurniture.getLod1ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod2ImplicitRepresentation()) {
			object = apply(cityFurniture.getLod2ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod3ImplicitRepresentation()) {
			object = apply(cityFurniture.getLod3ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod4ImplicitRepresentation()) {
			object = apply(cityFurniture.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetGenericApplicationPropertyOfCityFurniture()) {
			for (ADEComponent ade : cityFurniture.getGenericApplicationPropertyOfCityFurniture()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(CityModel cityModel) {
		Object object = apply((AbstractFeatureCollection)cityModel);
		if (object != null)
			return object;

		if (cityModel.isSetCityObjectMember()) {
			for (CityObjectMember cityObjectMember : cityModel.getCityObjectMember()) {
				object = apply(cityObjectMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetAppearanceMember()) {
			for (AppearanceMember appearanceMember : cityModel.getAppearanceMember()) {
				object = apply(appearanceMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetGenericApplicationPropertyOfCityModel()) {
			for (ADEComponent ade : cityModel.getGenericApplicationPropertyOfCityModel()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(CityObjectGroup cityObjectGroup) {
		Object object = apply((AbstractCityObject)cityObjectGroup);
		if (object != null)
			return object;

		if (cityObjectGroup.isSetGroupMember()) {
			for (CityObjectGroupMember cityObjectGroupMember : cityObjectGroup.getGroupMember()) {
				object = apply(cityObjectGroupMember);
				if (object != null)
					return object;
			}
		}

		if (cityObjectGroup.isSetGroupParent()) {
			object = apply(cityObjectGroup.getGroupParent());
			if (object != null)
				return object;
		}

		if (cityObjectGroup.isSetGeometry()) {
			object = apply(cityObjectGroup.getGeometry());
			if (object != null)
				return object;
		}

		if (cityObjectGroup.isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent ade : cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(ClosureSurface closureSurface) {
		Object object = apply((AbstractBoundarySurface)closureSurface);
		if (object != null)
			return object;

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface()) {
			for (ADEComponent ade : closureSurface.getGenericApplicationPropertyOfClosureSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Door door) {
		Object object = apply((AbstractOpening)door);
		if (object != null)
			return object;

		if (door.isSetAddress()) {
			for (AddressProperty addressProperty : door.getAddress()) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (door.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent ade : door.getGenericApplicationPropertyOfDoor()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(FloorSurface floorSurface) {
		Object object = apply((AbstractBoundarySurface)floorSurface);
		if (object != null)
			return object;

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface()) {
			for (ADEComponent ade : floorSurface.getGenericApplicationPropertyOfFloorSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(GenericCityObject genericCityObject) {
		Object object = apply((AbstractCityObject)genericCityObject);
		if (object != null)
			return object;

		if (genericCityObject.isSetLod0Geometry()) {
			object = apply(genericCityObject.getLod0Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod1Geometry()) {
			object = apply(genericCityObject.getLod1Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod2Geometry()) {
			object = apply(genericCityObject.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod3Geometry()) {
			object = apply(genericCityObject.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod4Geometry()) {
			object = apply(genericCityObject.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod0TerrainIntersection()) {
			object = apply(genericCityObject.getLod0TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod1TerrainIntersection()) {
			object = apply(genericCityObject.getLod1TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod2TerrainIntersection()) {
			object = apply(genericCityObject.getLod2TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod3TerrainIntersection()) {
			object = apply(genericCityObject.getLod3TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod4TerrainIntersection()) {
			object = apply(genericCityObject.getLod4TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod0ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod0ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod1ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod1ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod2ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod2ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod3ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod3ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod4ImplicitRepresentation()) {
			object = apply(genericCityObject.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(GeoreferencedTexture georeferencedTexture) {
		Object object = apply((AbstractTexture)georeferencedTexture);
		if (object != null)
			return object;

		if (georeferencedTexture.isSetReferencePoint()) {
			object = apply(georeferencedTexture.getReferencePoint());
			if (object != null)
				return object;
		}

		if (georeferencedTexture.isSetGenericApplicationPropertyOfGeoreferencedTexture()) {
			for (ADEComponent ade : georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(GroundSurface groundSurface) {
		Object object = apply((AbstractBoundarySurface)groundSurface);
		if (object != null)
			return object;

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface()) {
			for (ADEComponent ade : groundSurface.getGenericApplicationPropertyOfGroundSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(IntBuildingInstallation intBuildingInstallation) {
		Object object = apply((AbstractCityObject)intBuildingInstallation);
		if (object != null)
			return object;

		if (intBuildingInstallation.isSetLod4Geometry()) {
			object = apply(intBuildingInstallation.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (intBuildingInstallation.isSetGenericApplicationPropertyOfIntBuildingInstallation()) {
			for (ADEComponent ade : intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(InteriorWallSurface interiorWallSurface) {
		Object object = apply((AbstractBoundarySurface)interiorWallSurface);
		if (object != null)
			return object;

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent ade : interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(LandUse landUse) {
		Object object = apply((AbstractCityObject)landUse);
		if (object != null)
			return object;

		if (landUse.isSetLod0MultiSurface()) {
			object = apply(landUse.getLod0MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod1MultiSurface()) {
			object = apply(landUse.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod2MultiSurface()) {
			object = apply(landUse.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod3MultiSurface()) {
			object = apply(landUse.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod4MultiSurface()) {
			object = apply(landUse.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetGenericApplicationPropertyOfLandUse()) {
			for (ADEComponent ade : landUse.getGenericApplicationPropertyOfLandUse()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(MassPointRelief massPointRelief) {
		Object object = apply((AbstractReliefComponent)massPointRelief);
		if (object != null)
			return object;

		if (massPointRelief.isSetReliefPoints()) {
			object = apply(massPointRelief.getReliefPoints());
			if (object != null)
				return object;
		}

		if (massPointRelief.isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent ade : massPointRelief.getGenericApplicationPropertyOfMassPointRelief()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(ParameterizedTexture parameterizedTexture) {
		Object object = apply((AbstractTexture)parameterizedTexture);
		if (object != null)
			return object;

		if (parameterizedTexture.isSetTarget()) {
			for (TextureAssociation textureAssociation : parameterizedTexture.getTarget()) {
				object = apply(textureAssociation);
				if (object != null)
					return object;
			}
		}

		if (parameterizedTexture.isSetGenericApplicationPropertyOfParameterizedTexture()) {
			for (ADEComponent ade : parameterizedTexture.getGenericApplicationPropertyOfParameterizedTexture()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(PlantCover plantCover) {
		Object object = apply((AbstractVegetationObject)plantCover);
		if (object != null)
			return object;

		if (plantCover.isSetLod1MultiSurface()) {
			object = apply(plantCover.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod2MultiSurface()) {
			object = apply(plantCover.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod3MultiSurface()) {
			object = apply(plantCover.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod4MultiSurface()) {
			object = apply(plantCover.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod1MultiSolid()) {
			object = apply(plantCover.getLod1MultiSolid());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod2MultiSolid()) {
			object = apply(plantCover.getLod2MultiSolid());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod3MultiSolid()) {
			object = apply(plantCover.getLod3MultiSolid());
			if (object != null)
				return object;
		}

		if (plantCover.isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent ade : plantCover.getGenericApplicationPropertyOfPlantCover()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Railway railway) {
		Object object = apply((TransportationComplex)railway);
		if (object != null)
			return object;

		if (railway.isSetGenericApplicationPropertyOfRailway()) {
			for (ADEComponent ade : railway.getGenericApplicationPropertyOfRailway()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(RasterRelief rasterRelief) {
		Object object = apply((AbstractReliefComponent)rasterRelief);
		if (object != null)
			return object;

		if (rasterRelief.isSetGrid()) {
			object = apply(rasterRelief.getGrid());
			if (object != null)
				return object;
		}

		if (rasterRelief.isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent ade : rasterRelief.getGenericApplicationPropertyOfRasterRelief()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(ReliefFeature reliefFeature) {
		Object object = apply((AbstractCityObject)reliefFeature);
		if (object != null)
			return object;

		if (reliefFeature.isSetReliefComponent()) {
			for (ReliefComponentProperty reliefComponentProperty : reliefFeature.getReliefComponent()) {
				object = apply(reliefComponentProperty);
				if (object != null)
					return object;
			}
		}

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent ade : reliefFeature.getGenericApplicationPropertyOfReliefFeature()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Road road) {
		Object object = apply((TransportationComplex)road);
		if (object != null)
			return object;

		if (road.isSetGenericApplicationPropertyOfRoad()) {
			for (ADEComponent ade : road.getGenericApplicationPropertyOfRoad()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(RoofSurface roofSurface) {
		Object object = apply((AbstractBoundarySurface)roofSurface);
		if (object != null)
			return object;

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface()) {
			for (ADEComponent ade : roofSurface.getGenericApplicationPropertyOfRoofSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Room room) {
		Object object = apply((AbstractCityObject)room);
		if (object != null)
			return object;

		if (room.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : room.getBoundedBySurface()) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty interiorFurnitureProperty : room.getInteriorFurniture()) {
				object = apply(interiorFurnitureProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetRoomInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : room.getRoomInstallation()) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetLod4MultiSurface()) {
			object = apply(room.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (room.isSetLod4Solid()) {
			object = apply(room.getLod4Solid());
			if (object != null)
				return object;
		}

		if (room.isSetGenericApplicationPropertyOfRoom()) {
			for (ADEComponent ade : room.getGenericApplicationPropertyOfRoom()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(SolitaryVegetationObject solitaryVegetationObject) {
		Object object = apply((AbstractVegetationObject)solitaryVegetationObject);
		if (object != null)
			return object;

		if (solitaryVegetationObject.isSetLod2Geometry()) {
			object = apply(solitaryVegetationObject.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod3Geometry()) {
			object = apply(solitaryVegetationObject.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod4Geometry()) {
			object = apply(solitaryVegetationObject.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod1ImplicitRepresentation()) {
			object = apply(solitaryVegetationObject.getLod1ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod2ImplicitRepresentation()) {
			object = apply(solitaryVegetationObject.getLod2ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod3ImplicitRepresentation()) {
			object = apply(solitaryVegetationObject.getLod3ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod4ImplicitRepresentation()) {
			object = apply(solitaryVegetationObject.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetGenericApplicationPropertyOfSolitaryVegetationObject()) {
			for (ADEComponent ade : solitaryVegetationObject.getGenericApplicationPropertyOfSolitaryVegetationObject()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Square square) {
		Object object = apply((TransportationComplex)square);
		if (object != null)
			return object;

		if (square.isSetGenericApplicationPropertyOfSquare()) {
			for (ADEComponent ade : square.getGenericApplicationPropertyOfSquare()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(TINRelief tinRelief) {
		Object object = apply((AbstractReliefComponent)tinRelief);
		if (object != null)
			return object;

		if (tinRelief.isSetTin()) {
			object = apply(tinRelief.getTin());
			if (object != null)
				return object;
		}

		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent ade : tinRelief.getGenericApplicationPropertyOfTinRelief()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Track track) {
		Object object = apply((TransportationComplex)track);
		if (object != null)
			return object;

		if (track.isSetGenericApplicationPropertyOfTrack()) {
			for (ADEComponent ade : track.getGenericApplicationPropertyOfTrack()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(TrafficArea trafficArea) {
		Object object = apply((AbstractTransportationObject)trafficArea);
		if (object != null)
			return object;

		if (trafficArea.isSetLod2MultiSurface()) {
			object = apply(trafficArea.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (trafficArea.isSetLod3MultiSurface()) {
			object = apply(trafficArea.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (trafficArea.isSetLod4MultiSurface()) {
			object = apply(trafficArea.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (trafficArea.isSetGenericApplicationPropertyOfTrafficArea()) {
			for (ADEComponent ade : trafficArea.getGenericApplicationPropertyOfTrafficArea()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(TransportationComplex transportationComplex) {
		Object object = apply((AbstractTransportationObject)transportationComplex);
		if (object != null)
			return object;

		if (transportationComplex.isSetTrafficArea()) {
			for (TrafficAreaProperty trafficAreaProperty : transportationComplex.getTrafficArea()) {
				object = apply(trafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : transportationComplex.getAuxiliaryTrafficArea()) {
				object = apply(auxiliaryTrafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetLod0Network()) {
			for (GeometricComplexProperty geometricComplexProperty : transportationComplex.getLod0Network()) {
				object = apply(geometricComplexProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetLod1MultiSurface()) {
			object = apply(transportationComplex.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetLod2MultiSurface()) {
			object = apply(transportationComplex.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetLod3MultiSurface()) {
			object = apply(transportationComplex.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetLod4MultiSurface()) {
			object = apply(transportationComplex.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex()) {
			for (ADEComponent ade : transportationComplex.getGenericApplicationPropertyOfTransportationComplex()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(WallSurface wallSurface) {
		Object object = apply((AbstractBoundarySurface)wallSurface);
		if (object != null)
			return object;

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent ade : wallSurface.getGenericApplicationPropertyOfWallSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(WaterBody waterBody) {
		Object object = apply((AbstractWaterObject)waterBody);
		if (object != null)
			return object;

		if (waterBody.isSetBoundedBySurface()) {
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : waterBody.getBoundedBySurface()) {
				object = apply(boundedByWaterSurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (waterBody.isSetLod0MultiCurve()) {
			object = apply(waterBody.getLod0MultiCurve());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod1MultiCurve()) {
			object = apply(waterBody.getLod1MultiCurve());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod0MultiSurface()) {
			object = apply(waterBody.getLod0MultiSurface());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod1MultiSurface()) {
			object = apply(waterBody.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod1Solid()) {
			object = apply(waterBody.getLod1Solid());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod2Solid()) {
			object = apply(waterBody.getLod2Solid());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod3Solid()) {
			object = apply(waterBody.getLod3Solid());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod4Solid()) {
			object = apply(waterBody.getLod4Solid());
			if (object != null)
				return object;
		}		

		if (waterBody.isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent ade : waterBody.getGenericApplicationPropertyOfWaterBody()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(WaterClosureSurface waterClosureSurface) {
		Object object = apply((AbstractWaterBoundarySurface)waterClosureSurface);
		if (object != null)
			return object;

		if (waterClosureSurface.isSetGenericApplicationPropertyOfWaterClosureSurface()) {
			for (ADEComponent ade : waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(WaterGroundSurface waterGroundSurface) {
		Object object = apply((AbstractWaterBoundarySurface)waterGroundSurface);
		if (object != null)
			return object;

		if (waterGroundSurface.isSetGenericApplicationPropertyOfWaterGroundSurface()) {
			for (ADEComponent ade : waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(WaterSurface waterSurface) {
		Object object = apply((AbstractWaterBoundarySurface)waterSurface);
		if (object != null)
			return object;

		if (waterSurface.isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent ade : waterSurface.getGenericApplicationPropertyOfWaterSurface()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Window window) {
		Object object = apply((AbstractOpening)window);
		if (object != null)
			return object;

		if (window.isSetGenericApplicationPropertyOfWindow()) {
			for (ADEComponent ade : window.getGenericApplicationPropertyOfWindow()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(X3DMaterial x3dMaterial) {
		Object object = apply((AbstractSurfaceData)x3dMaterial);
		if (object != null)
			return object;

		if (x3dMaterial.isSetGenericApplicationPropertyOfX3DMaterial()) {
			for (ADEComponent ade : x3dMaterial.getGenericApplicationPropertyOfX3DMaterial()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(_Material material) {
		return apply((_AbstractAppearance)material);
	}

	public Object apply(_SimpleTexture simpleTexture) {
		return apply((_AbstractAppearance)simpleTexture);
	}

	public Object apply(ImplicitGeometry implicitGeometry) {
		Object object = apply((AbstractGML)implicitGeometry);
		if (object != null)
			return object;

		if (implicitGeometry.isSetRelativeGMLGeometry()) {
			object = apply(implicitGeometry.getRelativeGMLGeometry());
			if (object != null)
				return object;
		}

		if (implicitGeometry.isSetReferencePoint()) {
			object = apply(implicitGeometry.getReferencePoint());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(TexCoordGen texCoordGen) {
		Object object = apply((AbstractTextureParameterization)texCoordGen);
		if (object != null)
			return object;

		if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen()) {
			for (ADEComponent ade : texCoordGen.getGenericApplicationPropertyOfTexCoordGen()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(TexCoordList texCoordList) {
		Object object = apply((AbstractTextureParameterization)texCoordList);
		if (object != null)
			return object;

		if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList()) {
			for (ADEComponent ade : texCoordList.getGenericApplicationPropertyOfTexCoordList()) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(AbstractGeometry abstractGeometry) {
		return apply((AbstractGML)abstractGeometry);
	}

	public Object apply(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		return apply((AbstractGeometry)abstractGeometricPrimitive);
	}

	public Object apply(AbstractGeometricAggregate abstractGeometricAggregate) {
		return apply((AbstractGeometry)abstractGeometricAggregate);
	}

	public Object apply(AbstractCurve abstractCurve) {
		return apply((AbstractGeometricPrimitive)abstractCurve);
	}

	public Object apply(AbstractSolid abstractSolid) {
		return apply((AbstractGeometricPrimitive)abstractSolid);
	}

	public Object apply(AbstractSurface abstractSurface) {
		return apply((AbstractGeometricPrimitive)abstractSurface);
	}

	public Object apply(AbstractRing abstractRing) {
		return apply((AbstractGeometry)abstractRing);
	}

	public Object apply(Triangle triangle) {
		if (triangle.isSetExterior()) {
			Object object = apply(triangle.getExterior());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(Rectangle rectangle) {
		if (rectangle.isSetExterior()) {
			Object object = apply(rectangle.getExterior());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(CompositeCurve compositeCurve) {
		Object object = apply((AbstractCurve)compositeCurve);
		if (object != null)
			return object;

		if (compositeCurve.isSetCurveMember()) {
			for (CurveProperty curveProperty : compositeCurve.getCurveMember()) {
				object = apply(curveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(CompositeSolid compositeSolid) {
		Object object = apply((AbstractSolid)compositeSolid);
		if (object != null)
			return object;

		if (compositeSolid.isSetSolidMember()) {
			for (SolidProperty solidProperty : compositeSolid.getSolidMember()) {
				object = apply(solidProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(CompositeSurface compositeSurface) {
		Object object = apply((AbstractSurface)compositeSurface);
		if (object != null)
			return object;

		if (compositeSurface.isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : compositeSurface.getSurfaceMember()) {
				object = apply(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Curve curve) {
		return apply((AbstractCurve)curve);
	}

	public Object apply(GeometricComplex geometricComplex) {
		Object object = apply((AbstractGeometry)geometricComplex);
		if (object != null)
			return object;

		if (geometricComplex.isSetElement()) {
			for (GeometricPrimitiveProperty geometricPrimitiveProperty : geometricComplex.getElement()) {
				object = apply(geometricPrimitiveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Grid grid) {
		return apply((AbstractGeometry)grid);
	}

	public Object apply(LinearRing linearRing) {
		return apply((AbstractRing)linearRing);
	}

	public Object apply(LineString lineString) {
		return apply((AbstractCurve)lineString);
	}

	public Object apply(MultiCurve multiCurve) {
		Object object = apply((AbstractGeometricAggregate)multiCurve);
		if (object != null)
			return object;

		if (multiCurve.isSetCurveMember()) {
			for (CurveProperty curveProperty : multiCurve.getCurveMember()) {
				object = apply(curveProperty);
				if (object != null)
					return object;
			}
		}

		if (multiCurve.isSetCurveMembers()) {
			object = apply(multiCurve.getCurveMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(MultiLineString multiLineString) {
		Object object = apply((AbstractGeometricAggregate)multiLineString);
		if (object != null)
			return object;

		if (multiLineString.isSetLineStringMember()) {
			for (LineStringProperty lineStringProperty : multiLineString.getLineStringMember()) {
				object = apply(lineStringProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(MultiPoint multiPoint) {
		Object object = apply((AbstractGeometricAggregate)multiPoint);
		if (object != null)
			return object;

		if (multiPoint.isSetPointMember()) {
			for (PointProperty pointProperty : multiPoint.getPointMember()) {
				object = apply(pointProperty);
				if (object != null)
					return object;
			}
		}

		if (multiPoint.isSetPointMembers()) {
			object = apply(multiPoint.getPointMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(MultiPolygon multiPolygon) {
		Object object = apply((AbstractGeometricAggregate)multiPolygon);
		if (object != null)
			return object;

		if (multiPolygon.isSetPolygonMember()) {
			for (PolygonProperty polygonProperty : multiPolygon.getPolygonMember()) {
				object = apply(polygonProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(MultiSolid multiSolid) {
		Object object = apply((AbstractGeometricAggregate)multiSolid);
		if (object != null)
			return object;

		if (multiSolid.isSetSolidMember()) {
			for (SolidProperty solidProperty : multiSolid.getSolidMember()) {
				object = apply(solidProperty);
				if (object != null)
					return object;
			}
		}

		if (multiSolid.isSetSolidMembers()) {
			object = apply(multiSolid.getSolidMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(MultiSurface multiSurface) {
		Object object = apply((AbstractGeometricAggregate)multiSurface);
		if (object != null)
			return object;

		if (multiSurface.isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : multiSurface.getSurfaceMember()) {
				object = apply(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (multiSurface.isSetSurfaceMembers()) {
			object = apply(multiSurface.getSurfaceMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(OrientableCurve orientableCurve) {
		Object object = apply((AbstractCurve)orientableCurve);
		if (object != null)
			return object;

		if (orientableCurve.isSetBaseCurve()) {
			object = apply(orientableCurve.getBaseCurve());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(OrientableSurface orientableSurface) {
		Object object = apply((AbstractSurface)orientableSurface);
		if (object != null)
			return object;

		if (orientableSurface.isSetBaseSurface()) {
			object = apply(orientableSurface.getBaseSurface());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(_TexturedSurface texturedSurface) {
		Object object = apply((OrientableSurface)texturedSurface);
		if (object != null)
			return object;

		if (texturedSurface.isSetAppearance()) {
			for (_AppearanceProperty appearanceProperty : texturedSurface.getAppearance()) {
				object = apply(appearanceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Point point) {
		return apply((AbstractGeometricPrimitive)point);
	}

	public Object apply(Polygon polygon) {
		Object object = apply((AbstractSurface)polygon);
		if (object != null)
			return object;

		if (polygon.isSetExterior()) {
			object = apply(polygon.getExterior());
			if (object != null)
				return object;
		}

		if (polygon.isSetInterior()) {
			for (AbstractRingProperty abstractRingProperty : polygon.getInterior()) {
				object = apply(abstractRingProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(RectifiedGrid rectifiedGrid) {
		Object object = apply((Grid)rectifiedGrid);
		if (object != null)
			return object;

		if (rectifiedGrid.isSetOrigin()) {
			object = apply(rectifiedGrid.getOrigin());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(Ring ring) {
		Object object = apply((AbstractRing)ring);
		if (object != null)
			return object;

		if (ring.isSetCurveMember()) {
			for (CurveProperty curveProperty : ring.getCurveMember()) {
				object = apply(curveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Solid solid) {
		Object object = apply((AbstractSolid)solid);
		if (object != null)
			return object;

		if (solid.isSetExterior()) {
			object = apply(solid.getExterior());
			if (object != null)
				return object;
		}

		if (solid.isSetInterior()) {
			for (SurfaceProperty surfaceProperty : solid.getInterior()) {
				object = apply(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object apply(Surface surface) {
		Object object = apply((AbstractSurface)surface);
		if (object != null)
			return object;

		if (surface.isSetPatches()) {
			object = apply(surface.getPatches());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(Tin tin) {
		return apply((TriangulatedSurface)tin);
	}

	public Object apply(TriangulatedSurface triangulatedSurface) {
		return apply((Surface)triangulatedSurface);
	}

	public <T extends AbstractGML> Object apply(AssociationByRep<T> association) {
		if (association.isSetObject() && visited.add(association.getObject())) {
			Object object = association.getObject().accept(this);
			if (object != null)
				return object;
		}

		return null;
	}

	public <T extends AbstractGML> Object apply(AssociationByRepOrRef<T> association) {
		return apply((AssociationByRep<T>)association);
	}

	public <T extends AbstractFeature> Object apply(FeatureProperty<T> featureProperty) {
		Object object = apply((AssociationByRepOrRef<T>)featureProperty);
		if (object != null)
			return object;

		if (featureProperty.isSetGenericADEComponent()) {
			object = apply(featureProperty.getGenericADEComponent());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object apply(FeatureArrayProperty featureArrayProperty) {
		if (featureArrayProperty.isSetFeature()) {
			for (AbstractFeature feature : featureArrayProperty.getFeature())
				if (visited.add(feature)) {
					Object object = feature.accept(this);
					if (object != null)
						return object;
				}					
		}

		if (featureArrayProperty.isSetGenericADEComponent()) {
			for (ADEComponent ade : featureArrayProperty.getGenericADEComponent()) {
				Object object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public <T extends AbstractGeometry> Object apply(GeometryProperty<T> geometryProperty) {
		return apply((AssociationByRepOrRef<T>)geometryProperty);
	}

	public <T extends AbstractGeometry> Object apply(InlineGeometryProperty<T> geometryProperty) {
		return apply((AssociationByRep<T>)geometryProperty);
	}

	public <T extends AbstractGeometry> Object apply(GeometryArrayProperty<T> geometryArrayProperty) {
		if (geometryArrayProperty.isSetGeometry()) {
			for (AbstractGeometry abstractGeometry : geometryArrayProperty.getGeometry())
				if (visited.add(abstractGeometry)) {
					Object object = abstractGeometry.accept(this);
					if (object != null)
						return object;
				}
		}

		return null;
	}

	public Object apply(SurfacePatchArrayProperty surfacePatchArrayProperty) {
		Object object = null;

		if (surfacePatchArrayProperty.isSetSurfacePatch()) {
			for (AbstractSurfacePatch abstractSurfacePatch : surfacePatchArrayProperty.getSurfacePatch()) {
				if (visited.add(abstractSurfacePatch)) {
					if (abstractSurfacePatch instanceof Triangle) {
						object = apply((Triangle)abstractSurfacePatch);
						if (object != null)
							return object;
					} else if (abstractSurfacePatch instanceof Rectangle) {
						object = apply((Rectangle)abstractSurfacePatch);
						if (object != null)
							return object;
					}
				}
			}
		}

		return null;
	}

	public Object apply(Element element, ElementDecl decl) {
		return null;
	}

	public Object apply(ADEComponent adeComponent) {
		if (adeComponent.isSetContent() && visited.add(adeComponent.getContent())) {
			ADEComponent result = adeComponent(adeComponent.getContent(), (Element)null);
			if (result != null)
				return (result.getContent() == adeComponent.getContent()) ? adeComponent : result;
		}

		return null;
	}

	protected ADEComponent adeComponent(Element element, Element parent) {	
		String elementId = element.getAttribute("id");
		if (elementId.length() == 0) {
			for (GMLCoreModule gml : GMLCoreModule.getInstances()) {
				switch (gml.getVersion()) {
				case v3_1_1:
					elementId = element.getAttributeNS(gml.getNamespaceURI(), "id");
					break;
				}

				if (elementId.length() > 0)
					break;
			}
		}

		if (elementId.length() > 0 && gmlId.equals(elementId))
			return new ADEComponent(element);

		NodeList childs = element.getChildNodes();
		for (int i = 0; i < childs.getLength(); ++i) {
			Node node = childs.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE && visited.add(node)) {
				ADEComponent ade = adeComponent((Element)node, element);
				if (ade != null)
					return ade;
			}
		}

		return null;
	}

	protected Object apply(Value value) {
		if (value.isSetGeometry() && visited.add(value.getGeometry())) {
			Object object = value.getGeometry().accept(this);
			if (object != null)
				return object;
		} else if (value.isSetValueObject()) {
			Object object = apply(value.getValueObject());
			if (object != null)
				return object;
		}

		return null;
	}

	protected Object apply(ValueObject valueObject) {
		if (valueObject.isSetCompositeValue()) {
			Object object = valueObject.getCompositeValue().accept(this);
			if (object != null)
				return object;
		}

		return null;
	}
}
