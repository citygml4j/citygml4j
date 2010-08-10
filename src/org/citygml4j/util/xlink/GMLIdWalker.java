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
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.xml.schema.ElementDecl;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GMLIdWalker implements GMLFunction<Object> {
	private Set<Object> visited = new HashSet<Object>();
	private final String gmlId;

	GMLIdWalker(String gmlId) {
		this.gmlId = gmlId;
	}

	public Object accept(AbstractGML abstractGML) {
		return (abstractGML.isSetId() && gmlId.equals(abstractGML.getId())) ? abstractGML : null;
	}

	public Object accept(AbstractCoverage abstractCoverage) {
		Object object = accept((AbstractFeature)abstractCoverage);
		if (object != null)
			return object;

		if (abstractCoverage.isSetRangeSet()) {
			RangeSet rangeSet = abstractCoverage.getRangeSet();
			if (rangeSet.isSetValueArray()) {
				for (ValueArray valueArray : rangeSet.getValueArray()) {
					object = accept(valueArray);
					if (object != null)
						return object;
				}
			}
			
			else if (rangeSet.isSetDataBlock()) {
				DataBlock dataBlock = rangeSet.getDataBlock();
				if (dataBlock.isSetRangeParameters() && dataBlock.getRangeParameters().isSetValueObject()) {
					object = accept(dataBlock.getRangeParameters().getValueObject());
					if (object != null)
						return object;
				}
			}
			
			else if (rangeSet.isSetFile()) {
				File file = rangeSet.getFile();
				if (file.isSetRangeParameters() && file.getRangeParameters().isSetValueObject()) {
					object = accept(file.getRangeParameters().getValueObject());
					if (object != null)
						return object;
				}
			}
		}

		return null;
	}

	public Object accept(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		return accept((AbstractCoverage)abstractDiscreteCoverage);
	}

	public Object accept(AbstractFeature abstractFeature) {
		Object object = accept((AbstractGML)abstractFeature);
		if (object != null)
			return object;

		if (abstractFeature.isSetLocation()) {
			object = accept(abstractFeature.getLocation());
			if (object != null)
				return object;
		}

		if (abstractFeature.isSetGenericADEComponent()) {
			for (ADEComponent ade : abstractFeature.getGenericADEComponent()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(AbstractFeatureCollection abstractFeatureCollection) {
		Object object = accept((AbstractFeature)abstractFeatureCollection);
		if (object != null)
			return object;

		if (abstractFeatureCollection.isSetFeatureMember()) {
			for (FeatureMember featureMember : abstractFeatureCollection.getFeatureMember()) {
				object = accept(featureMember);
				if (object != null)
					return object;
			}
		}

		if (abstractFeatureCollection.isSetFeatureMembers())
			accept(abstractFeatureCollection.getFeatureMembers());

		return null;
	}

	public Object accept(AbstractCityObject abstractCityObject) {
		Object object = accept((AbstractFeature)abstractCityObject);
		if (object != null)
			return object;

		if (abstractCityObject.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : abstractCityObject.getGeneralizesTo()) {
				object = accept(generalizationRelation);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : abstractCityObject.getAppearance()) {
				object = accept(appearanceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent ade : abstractCityObject.getGenericApplicationPropertyOfCityObject()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractTransportationObject abstractTransportationObject) {
		Object object = accept((AbstractCityObject)abstractTransportationObject);
		if (object != null)
			return object;

		if (abstractTransportationObject.isSetGenericApplicationPropertyOfTransportationObject()) {
			for (ADEComponent ade : abstractTransportationObject.getGenericApplicationPropertyOfTransportationObject()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractReliefComponent abstractReliefComponent) {
		Object object = accept((AbstractCityObject)abstractReliefComponent);
		if (object != null)
			return object;

		if (abstractReliefComponent.isSetExtent()) {
			object = accept(abstractReliefComponent.getExtent());
			if (object != null)
				return object;
		}

		if (abstractReliefComponent.isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent ade : abstractReliefComponent.getGenericApplicationPropertyOfReliefComponent()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractSite abstractSite) {
		Object object = accept((AbstractCityObject)abstractSite);
		if (object != null)
			return object;

		if (abstractSite.isSetGenericApplicationPropertyOfSite()) {
			for (ADEComponent ade : abstractSite.getGenericApplicationPropertyOfSite()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractBuilding abstractBuilding) {
		Object object = accept((AbstractSite)abstractBuilding);
		if (object != null)
			return object;

		if (abstractBuilding.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty buildingInstallationProperty : abstractBuilding.getOuterBuildingInstallation()) {
				object = accept(buildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : abstractBuilding.getInteriorBuildingInstallation()) {
				object = accept(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : abstractBuilding.getBoundedBySurface()) {
				object = accept(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty buildingPartProperty : abstractBuilding.getConsistsOfBuildingPart()) {
				object = accept(buildingPartProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorRoom()) {
			for (InteriorRoomProperty interiorRoomProperty : abstractBuilding.getInteriorRoom()) {
				object = accept(interiorRoomProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetAddress()) {
			for (AddressProperty addressProperty : abstractBuilding.getAddress()) {
				object = accept(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetLod1Solid()) {
			object = accept(abstractBuilding.getLod1Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2Solid()) {
			object = accept(abstractBuilding.getLod2Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3Solid()) {
			object = accept(abstractBuilding.getLod3Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4Solid()) {
			object = accept(abstractBuilding.getLod4Solid());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod1TerrainIntersection()) {
			object = accept(abstractBuilding.getLod1TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2TerrainIntersection()) {
			object = accept(abstractBuilding.getLod2TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3TerrainIntersection()) {
			object = accept(abstractBuilding.getLod3TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4TerrainIntersection()) {
			object = accept(abstractBuilding.getLod4TerrainIntersection());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2MultiCurve()) {
			object = accept(abstractBuilding.getLod2MultiCurve());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3MultiCurve()) {
			object = accept(abstractBuilding.getLod3MultiCurve());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4MultiCurve()) {
			object = accept(abstractBuilding.getLod4MultiCurve());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod1MultiSurface()) {
			object = accept(abstractBuilding.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod2MultiSurface()) {
			object = accept(abstractBuilding.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod3MultiSurface()) {
			object = accept(abstractBuilding.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetLod4MultiSurface()) {
			object = accept(abstractBuilding.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBuilding.isSetGenericApplicationPropertyOfAbstractBuilding()) {
			for (ADEComponent ade : abstractBuilding.getGenericApplicationPropertyOfAbstractBuilding()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractBoundarySurface abstractBoundarySurface) {
		Object object = accept((AbstractCityObject)abstractBoundarySurface);
		if (object != null)
			return object;

		if (abstractBoundarySurface.isSetOpening()) {
			for (OpeningProperty openingProperty : abstractBoundarySurface.getOpening()) {
				object = accept(openingProperty);
				if (object != null)
					return object;					
			}
		}

		if (abstractBoundarySurface.isSetLod2MultiSurface()) {
			object = accept(abstractBoundarySurface.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBoundarySurface.isSetLod3MultiSurface()) {
			object = accept(abstractBoundarySurface.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBoundarySurface.isSetLod4MultiSurface()) {
			object = accept(abstractBoundarySurface.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent ade : abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractOpening abstractOpening) {
		Object object = accept((AbstractCityObject)abstractOpening);
		if (object != null)
			return object;

		if (abstractOpening.isSetLod3MultiSurface()) {
			object = accept(abstractOpening.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractOpening.isSetLod4MultiSurface()) {
			object = accept(abstractOpening.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening()) {
			for (ADEComponent ade : abstractOpening.getGenericApplicationPropertyOfOpening()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractSurfaceData abstractSurfaceData) {
		Object object = accept((AbstractFeature)abstractSurfaceData);
		if (object != null)
			return object;

		if (abstractSurfaceData.isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent ade : abstractSurfaceData.getGenericApplicationPropertyOfSurfaceData()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractTexture abstractTexture) {
		Object object = accept((AbstractSurfaceData)abstractTexture);
		if (object != null)
			return object;

		if (abstractTexture.isSetGenericApplicationPropertyOfTexture()) {
			for (ADEComponent ade : abstractTexture.getGenericApplicationPropertyOfTexture()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractTextureParameterization abstractTextureParameterization) {
		Object object = accept((AbstractGML)abstractTextureParameterization);
		if (object != null)
			return object;

		if (abstractTextureParameterization.isSetGenericADEComponent()) {
			for (ADEComponent ade : abstractTextureParameterization.getGenericADEComponent()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		if (abstractTextureParameterization.isSetGenericApplicationPropertyOfTextureParameterization()) {
			for (ADEComponent ade : abstractTextureParameterization.getGenericApplicationPropertyOfTextureParameterization()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractVegetationObject abstractVegetationObject) {
		Object object = accept((AbstractCityObject)abstractVegetationObject);
		if (object != null)
			return object;

		if (abstractVegetationObject.isSetGenericApplicationPropertyOfVegetationObject()) {
			for (ADEComponent ade : abstractVegetationObject.getGenericApplicationPropertyOfVegetationObject()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractWaterObject abstractWaterObject) {
		Object object = accept((AbstractCityObject)abstractWaterObject);
		if (object != null)
			return object;

		if (abstractWaterObject.isSetGenericApplicationPropertyOfWaterObject()) {
			for (ADEComponent ade : abstractWaterObject.getGenericApplicationPropertyOfWaterObject()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(AbstractWaterBoundarySurface abstractWaterBoundarySurface) {
		Object object = accept((AbstractCityObject)abstractWaterBoundarySurface);
		if (object != null)
			return object;

		if (abstractWaterBoundarySurface.isSetLod2Surface()) {
			object = accept(abstractWaterBoundarySurface.getLod2Surface());
			if (object != null)
				return object;
		}

		if (abstractWaterBoundarySurface.isSetLod3Surface()) {
			object = accept(abstractWaterBoundarySurface.getLod3Surface());
			if (object != null)
				return object;
		}

		if (abstractWaterBoundarySurface.isSetLod3Surface()) {
			object = accept(abstractWaterBoundarySurface.getLod3Surface());
			if (object != null)
				return object;
		}

		if (abstractWaterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent ade : abstractWaterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public Object accept(_AbstractAppearance abstractAppearance) {
		return accept((AbstractGML)abstractAppearance);
	}

	public Object accept(CompositeValue compositeValue) {
		Object object = accept((AbstractGML)compositeValue);
		if (object != null)
			return object;

		if (compositeValue.isSetValueComponent()) {
			for (ValueProperty valueProperty : compositeValue.getValueComponent()) {
				if (valueProperty.isSetValue()) {
					object = accept(valueProperty.getValue());
					if (object != null)
						return object;
				}
			}
		}

		if (compositeValue.isSetValueComponents()) {
			ValueArrayProperty valueArrayProperty = compositeValue.getValueComponents();
			if (valueArrayProperty.isSetValue()) {
				for (Value value : valueArrayProperty.getValue()) {
					object = accept(value);
					if (object != null)
						return object;
				}
			}
		}

		return null;
	}

	public Object accept(ValueArray valueArray) {
		return accept((CompositeValue)valueArray);
	}

	public Object accept(RectifiedGridCoverage rectifiedGridCoverage) {
		Object object = accept((AbstractDiscreteCoverage)rectifiedGridCoverage);
		if (object != null)
			return object;

		if (rectifiedGridCoverage.isSetRectifiedGridDomain()) {
			object = accept(rectifiedGridCoverage.getRectifiedGridDomain());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(Address address) {
		Object object = accept((AbstractFeature)address);
		if (object != null)
			return object;

		if (address.isSetMultiPoint()) {
			object = accept(address.getMultiPoint());
			if (object != null)
				return object;
		}			

		if (address.isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent ade : address.getGenericApplicationPropertyOfAddress()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Appearance appearance) {
		Object object = accept((AbstractFeature)appearance);
		if (object != null)
			return object;

		if (appearance.isSetSurfaceDataMember())
			for (SurfaceDataProperty surfaceDataProperty : appearance.getSurfaceDataMember()) {
				object = accept(surfaceDataProperty);
				if (object != null)
					return object;
			}

		if (appearance.isSetGenericApplicationPropertyOfAppearance()) {
			for (ADEComponent ade : appearance.getGenericApplicationPropertyOfAppearance()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		Object object = accept((AbstractTransportationObject)auxiliaryTrafficArea);
		if (object != null)
			return object;

		if (auxiliaryTrafficArea.isSetLod2MultiSurface()) {
			object = accept(auxiliaryTrafficArea.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (auxiliaryTrafficArea.isSetLod3MultiSurface()) {
			object = accept(auxiliaryTrafficArea.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (auxiliaryTrafficArea.isSetLod4MultiSurface()) {
			object = accept(auxiliaryTrafficArea.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (auxiliaryTrafficArea.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
			for (ADEComponent ade : auxiliaryTrafficArea.getGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(BreaklineRelief breaklineRelief) {
		Object object = accept((AbstractReliefComponent)breaklineRelief);
		if (object != null)
			return object;

		if (breaklineRelief.isSetBreaklines()) {
			object = accept(breaklineRelief.getBreaklines());
			if (object != null)
				return object;
		}

		if (breaklineRelief.isSetRidgeOrValleyLines()) {
			object = accept(breaklineRelief.getRidgeOrValleyLines());
			if (object != null)
				return object;
		}

		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent ade : breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Building building) {
		Object object = accept((AbstractBuilding)building);
		if (object != null)
			return object;

		if (building.isSetGenericApplicationPropertyOfBuilding()) {
			for (ADEComponent ade : building.getGenericApplicationPropertyOfBuilding()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(BuildingFurniture buildingFurniture) {
		Object object = accept((AbstractCityObject)buildingFurniture);
		if (object != null)
			return object;

		if (buildingFurniture.isSetLod4Geometry()) {
			object = accept(buildingFurniture.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (buildingFurniture.isSetLod4ImplicitRepresentation()) {
			object = accept(buildingFurniture.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (buildingFurniture.isSetGenericApplicationPropertyOfBuildingFurniture()) {
			for (ADEComponent ade : buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(BuildingInstallation buildingInstallation) {
		Object object = accept((AbstractCityObject)buildingInstallation);
		if (object != null)
			return object;

		if (buildingInstallation.isSetLod2Geometry()) {
			object = accept(buildingInstallation.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (buildingInstallation.isSetLod3Geometry()) {
			object = accept(buildingInstallation.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (buildingInstallation.isSetLod4Geometry()) {
			object = accept(buildingInstallation.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (buildingInstallation.isSetGenericApplicationPropertyOfBuildingInstallation()) {
			for (ADEComponent ade : buildingInstallation.getGenericApplicationPropertyOfBuildingInstallation()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(BuildingPart buildingPart) {
		Object object = accept((AbstractBuilding)buildingPart);
		if (object != null)
			return object;

		if (buildingPart.isSetGenericApplicationPropertyOfBuildingPart()) {
			for (ADEComponent ade : buildingPart.getGenericApplicationPropertyOfBuildingPart()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(CeilingSurface ceilingSurface) {
		Object object = accept((AbstractBoundarySurface)ceilingSurface);
		if (object != null)
			return object;

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface()) {
			for (ADEComponent ade : ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(CityFurniture cityFurniture) {
		Object object = accept((AbstractCityObject)cityFurniture);
		if (object != null)
			return object;

		if (cityFurniture.isSetLod1Geometry()) {
			object = accept(cityFurniture.getLod1Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod2Geometry()) {
			object = accept(cityFurniture.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod3Geometry()) {
			object = accept(cityFurniture.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod4Geometry()) {
			object = accept(cityFurniture.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod1TerrainIntersection()) {
			object = accept(cityFurniture.getLod1TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod2TerrainIntersection()) {
			object = accept(cityFurniture.getLod2TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod3TerrainIntersection()) {
			object = accept(cityFurniture.getLod3TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod4TerrainIntersection()) {
			object = accept(cityFurniture.getLod4TerrainIntersection());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod1ImplicitRepresentation()) {
			object = accept(cityFurniture.getLod1ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod2ImplicitRepresentation()) {
			object = accept(cityFurniture.getLod2ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod3ImplicitRepresentation()) {
			object = accept(cityFurniture.getLod3ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetLod4ImplicitRepresentation()) {
			object = accept(cityFurniture.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (cityFurniture.isSetGenericApplicationPropertyOfCityFurniture()) {
			for (ADEComponent ade : cityFurniture.getGenericApplicationPropertyOfCityFurniture()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(CityModel cityModel) {
		Object object = accept((AbstractFeatureCollection)cityModel);
		if (object != null)
			return object;

		if (cityModel.isSetCityObjectMember()) {
			for (CityObjectMember cityObjectMember : cityModel.getCityObjectMember()) {
				object = accept(cityObjectMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetAppearanceMember()) {
			for (AppearanceMember appearanceMember : cityModel.getAppearanceMember()) {
				object = accept(appearanceMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetGenericApplicationPropertyOfCityModel()) {
			for (ADEComponent ade : cityModel.getGenericApplicationPropertyOfCityModel()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(CityObjectGroup cityObjectGroup) {
		Object object = accept((AbstractCityObject)cityObjectGroup);
		if (object != null)
			return object;

		if (cityObjectGroup.isSetGroupMember()) {
			for (CityObjectGroupMember cityObjectGroupMember : cityObjectGroup.getGroupMember()) {
				object = accept(cityObjectGroupMember);
				if (object != null)
					return object;
			}
		}

		if (cityObjectGroup.isSetGroupParent()) {
			object = accept(cityObjectGroup.getGroupParent());
			if (object != null)
				return object;
		}

		if (cityObjectGroup.isSetGeometry()) {
			object = accept(cityObjectGroup.getGeometry());
			if (object != null)
				return object;
		}

		if (cityObjectGroup.isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent ade : cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(ClosureSurface closureSurface) {
		Object object = accept((AbstractBoundarySurface)closureSurface);
		if (object != null)
			return object;

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface()) {
			for (ADEComponent ade : closureSurface.getGenericApplicationPropertyOfClosureSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Door door) {
		Object object = accept((AbstractOpening)door);
		if (object != null)
			return object;

		if (door.isSetAddress()) {
			for (AddressProperty addressProperty : door.getAddress()) {
				object = accept(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (door.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent ade : door.getGenericApplicationPropertyOfDoor()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(FloorSurface floorSurface) {
		Object object = accept((AbstractBoundarySurface)floorSurface);
		if (object != null)
			return object;

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface()) {
			for (ADEComponent ade : floorSurface.getGenericApplicationPropertyOfFloorSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(GenericCityObject genericCityObject) {
		Object object = accept((AbstractCityObject)genericCityObject);
		if (object != null)
			return object;

		if (genericCityObject.isSetLod0Geometry()) {
			object = accept(genericCityObject.getLod0Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod1Geometry()) {
			object = accept(genericCityObject.getLod1Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod2Geometry()) {
			object = accept(genericCityObject.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod3Geometry()) {
			object = accept(genericCityObject.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod4Geometry()) {
			object = accept(genericCityObject.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod0TerrainIntersection()) {
			object = accept(genericCityObject.getLod0TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod1TerrainIntersection()) {
			object = accept(genericCityObject.getLod1TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod2TerrainIntersection()) {
			object = accept(genericCityObject.getLod2TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod3TerrainIntersection()) {
			object = accept(genericCityObject.getLod3TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod4TerrainIntersection()) {
			object = accept(genericCityObject.getLod4TerrainIntersection());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod0ImplicitRepresentation()) {
			object = accept(genericCityObject.getLod0ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod1ImplicitRepresentation()) {
			object = accept(genericCityObject.getLod1ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod2ImplicitRepresentation()) {
			object = accept(genericCityObject.getLod2ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod3ImplicitRepresentation()) {
			object = accept(genericCityObject.getLod3ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (genericCityObject.isSetLod4ImplicitRepresentation()) {
			object = accept(genericCityObject.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(GeoreferencedTexture georeferencedTexture) {
		Object object = accept((AbstractTexture)georeferencedTexture);
		if (object != null)
			return object;

		if (georeferencedTexture.isSetReferencePoint()) {
			object = accept(georeferencedTexture.getReferencePoint());
			if (object != null)
				return object;
		}

		if (georeferencedTexture.isSetGenericApplicationPropertyOfGeoreferencedTexture()) {
			for (ADEComponent ade : georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(GroundSurface groundSurface) {
		Object object = accept((AbstractBoundarySurface)groundSurface);
		if (object != null)
			return object;

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface()) {
			for (ADEComponent ade : groundSurface.getGenericApplicationPropertyOfGroundSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(IntBuildingInstallation intBuildingInstallation) {
		Object object = accept((AbstractCityObject)intBuildingInstallation);
		if (object != null)
			return object;

		if (intBuildingInstallation.isSetLod4Geometry()) {
			object = accept(intBuildingInstallation.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (intBuildingInstallation.isSetGenericApplicationPropertyOfIntBuildingInstallation()) {
			for (ADEComponent ade : intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(InteriorWallSurface interiorWallSurface) {
		Object object = accept((AbstractBoundarySurface)interiorWallSurface);
		if (object != null)
			return object;

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent ade : interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(LandUse landUse) {
		Object object = accept((AbstractCityObject)landUse);
		if (object != null)
			return object;

		if (landUse.isSetLod0MultiSurface()) {
			object = accept(landUse.getLod0MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod1MultiSurface()) {
			object = accept(landUse.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod2MultiSurface()) {
			object = accept(landUse.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod3MultiSurface()) {
			object = accept(landUse.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetLod4MultiSurface()) {
			object = accept(landUse.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (landUse.isSetGenericApplicationPropertyOfLandUse()) {
			for (ADEComponent ade : landUse.getGenericApplicationPropertyOfLandUse()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(MassPointRelief massPointRelief) {
		Object object = accept((AbstractReliefComponent)massPointRelief);
		if (object != null)
			return object;

		if (massPointRelief.isSetReliefPoints()) {
			object = accept(massPointRelief.getReliefPoints());
			if (object != null)
				return object;
		}

		if (massPointRelief.isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent ade : massPointRelief.getGenericApplicationPropertyOfMassPointRelief()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(ParameterizedTexture parameterizedTexture) {
		Object object = accept((AbstractTexture)parameterizedTexture);
		if (object != null)
			return object;

		if (parameterizedTexture.isSetTarget()) {
			for (TextureAssociation textureAssociation : parameterizedTexture.getTarget()) {
				object = accept(textureAssociation);
				if (object != null)
					return object;
			}
		}

		if (parameterizedTexture.isSetGenericApplicationPropertyOfParameterizedTexture()) {
			for (ADEComponent ade : parameterizedTexture.getGenericApplicationPropertyOfParameterizedTexture()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(PlantCover plantCover) {
		Object object = accept((AbstractVegetationObject)plantCover);
		if (object != null)
			return object;

		if (plantCover.isSetLod1MultiSurface()) {
			object = accept(plantCover.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod2MultiSurface()) {
			object = accept(plantCover.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod3MultiSurface()) {
			object = accept(plantCover.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod4MultiSurface()) {
			object = accept(plantCover.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod1MultiSolid()) {
			object = accept(plantCover.getLod1MultiSolid());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod2MultiSolid()) {
			object = accept(plantCover.getLod2MultiSolid());
			if (object != null)
				return object;
		}

		if (plantCover.isSetLod3MultiSolid()) {
			object = accept(plantCover.getLod3MultiSolid());
			if (object != null)
				return object;
		}

		if (plantCover.isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent ade : plantCover.getGenericApplicationPropertyOfPlantCover()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Railway railway) {
		Object object = accept((TransportationComplex)railway);
		if (object != null)
			return object;

		if (railway.isSetGenericApplicationPropertyOfRailway()) {
			for (ADEComponent ade : railway.getGenericApplicationPropertyOfRailway()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(RasterRelief rasterRelief) {
		Object object = accept((AbstractReliefComponent)rasterRelief);
		if (object != null)
			return object;

		if (rasterRelief.isSetGrid()) {
			object = accept(rasterRelief.getGrid());
			if (object != null)
				return object;
		}

		if (rasterRelief.isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent ade : rasterRelief.getGenericApplicationPropertyOfRasterRelief()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(ReliefFeature reliefFeature) {
		Object object = accept((AbstractCityObject)reliefFeature);
		if (object != null)
			return object;

		if (reliefFeature.isSetReliefComponent()) {
			for (ReliefComponentProperty reliefComponentProperty : reliefFeature.getReliefComponent()) {
				object = accept(reliefComponentProperty);
				if (object != null)
					return object;
			}
		}

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent ade : reliefFeature.getGenericApplicationPropertyOfReliefFeature()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Road road) {
		Object object = accept((TransportationComplex)road);
		if (object != null)
			return object;

		if (road.isSetGenericApplicationPropertyOfRoad()) {
			for (ADEComponent ade : road.getGenericApplicationPropertyOfRoad()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(RoofSurface roofSurface) {
		Object object = accept((AbstractBoundarySurface)roofSurface);
		if (object != null)
			return object;

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface()) {
			for (ADEComponent ade : roofSurface.getGenericApplicationPropertyOfRoofSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Room room) {
		Object object = accept((AbstractCityObject)room);
		if (object != null)
			return object;

		if (room.isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : room.getBoundedBySurface()) {
				object = accept(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty interiorFurnitureProperty : room.getInteriorFurniture()) {
				object = accept(interiorFurnitureProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetRoomInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : room.getRoomInstallation()) {
				object = accept(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetLod4MultiSurface()) {
			object = accept(room.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (room.isSetLod4Solid()) {
			object = accept(room.getLod4Solid());
			if (object != null)
				return object;
		}

		if (room.isSetGenericApplicationPropertyOfRoom()) {
			for (ADEComponent ade : room.getGenericApplicationPropertyOfRoom()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(SolitaryVegetationObject solitaryVegetationObject) {
		Object object = accept((AbstractVegetationObject)solitaryVegetationObject);
		if (object != null)
			return object;

		if (solitaryVegetationObject.isSetLod2Geometry()) {
			object = accept(solitaryVegetationObject.getLod2Geometry());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod3Geometry()) {
			object = accept(solitaryVegetationObject.getLod3Geometry());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod4Geometry()) {
			object = accept(solitaryVegetationObject.getLod4Geometry());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod1ImplicitRepresentation()) {
			object = accept(solitaryVegetationObject.getLod1ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod2ImplicitRepresentation()) {
			object = accept(solitaryVegetationObject.getLod2ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod3ImplicitRepresentation()) {
			object = accept(solitaryVegetationObject.getLod3ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetLod4ImplicitRepresentation()) {
			object = accept(solitaryVegetationObject.getLod4ImplicitRepresentation());
			if (object != null)
				return object;
		}

		if (solitaryVegetationObject.isSetGenericApplicationPropertyOfSolitaryVegetationObject()) {
			for (ADEComponent ade : solitaryVegetationObject.getGenericApplicationPropertyOfSolitaryVegetationObject()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Square square) {
		Object object = accept((TransportationComplex)square);
		if (object != null)
			return object;

		if (square.isSetGenericApplicationPropertyOfSquare()) {
			for (ADEComponent ade : square.getGenericApplicationPropertyOfSquare()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(TINRelief tinRelief) {
		Object object = accept((AbstractReliefComponent)tinRelief);
		if (object != null)
			return object;

		if (tinRelief.isSetTin()) {
			object = accept(tinRelief.getTin());
			if (object != null)
				return object;
		}

		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent ade : tinRelief.getGenericApplicationPropertyOfTinRelief()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Track track) {
		Object object = accept((TransportationComplex)track);
		if (object != null)
			return object;

		if (track.isSetGenericApplicationPropertyOfTrack()) {
			for (ADEComponent ade : track.getGenericApplicationPropertyOfTrack()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(TrafficArea trafficArea) {
		Object object = accept((AbstractTransportationObject)trafficArea);
		if (object != null)
			return object;

		if (trafficArea.isSetLod2MultiSurface()) {
			object = accept(trafficArea.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (trafficArea.isSetLod3MultiSurface()) {
			object = accept(trafficArea.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (trafficArea.isSetLod4MultiSurface()) {
			object = accept(trafficArea.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (trafficArea.isSetGenericApplicationPropertyOfTrafficArea()) {
			for (ADEComponent ade : trafficArea.getGenericApplicationPropertyOfTrafficArea()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(TransportationComplex transportationComplex) {
		Object object = accept((AbstractTransportationObject)transportationComplex);
		if (object != null)
			return object;

		if (transportationComplex.isSetTrafficArea()) {
			for (TrafficAreaProperty trafficAreaProperty : transportationComplex.getTrafficArea()) {
				object = accept(trafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : transportationComplex.getAuxiliaryTrafficArea()) {
				object = accept(auxiliaryTrafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetLod0Network()) {
			for (GeometricComplexProperty geometricComplexProperty : transportationComplex.getLod0Network()) {
				object = accept(geometricComplexProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetLod1MultiSurface()) {
			object = accept(transportationComplex.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetLod2MultiSurface()) {
			object = accept(transportationComplex.getLod2MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetLod3MultiSurface()) {
			object = accept(transportationComplex.getLod3MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetLod4MultiSurface()) {
			object = accept(transportationComplex.getLod4MultiSurface());
			if (object != null)
				return object;
		}

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex()) {
			for (ADEComponent ade : transportationComplex.getGenericApplicationPropertyOfTransportationComplex()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(WallSurface wallSurface) {
		Object object = accept((AbstractBoundarySurface)wallSurface);
		if (object != null)
			return object;

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent ade : wallSurface.getGenericApplicationPropertyOfWallSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(WaterBody waterBody) {
		Object object = accept((AbstractWaterObject)waterBody);
		if (object != null)
			return object;

		if (waterBody.isSetBoundedBySurface()) {
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : waterBody.getBoundedBySurface()) {
				object = accept(boundedByWaterSurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (waterBody.isSetLod0MultiCurve()) {
			object = accept(waterBody.getLod0MultiCurve());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod1MultiCurve()) {
			object = accept(waterBody.getLod1MultiCurve());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod0MultiSurface()) {
			object = accept(waterBody.getLod0MultiSurface());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod1MultiSurface()) {
			object = accept(waterBody.getLod1MultiSurface());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod1Solid()) {
			object = accept(waterBody.getLod1Solid());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod2Solid()) {
			object = accept(waterBody.getLod2Solid());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod3Solid()) {
			object = accept(waterBody.getLod3Solid());
			if (object != null)
				return object;
		}

		if (waterBody.isSetLod4Solid()) {
			object = accept(waterBody.getLod4Solid());
			if (object != null)
				return object;
		}		

		if (waterBody.isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent ade : waterBody.getGenericApplicationPropertyOfWaterBody()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(WaterClosureSurface waterClosureSurface) {
		Object object = accept((AbstractWaterBoundarySurface)waterClosureSurface);
		if (object != null)
			return object;

		if (waterClosureSurface.isSetGenericApplicationPropertyOfWaterClosureSurface()) {
			for (ADEComponent ade : waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(WaterGroundSurface waterGroundSurface) {
		Object object = accept((AbstractWaterBoundarySurface)waterGroundSurface);
		if (object != null)
			return object;

		if (waterGroundSurface.isSetGenericApplicationPropertyOfWaterGroundSurface()) {
			for (ADEComponent ade : waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(WaterSurface waterSurface) {
		Object object = accept((AbstractWaterBoundarySurface)waterSurface);
		if (object != null)
			return object;

		if (waterSurface.isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent ade : waterSurface.getGenericApplicationPropertyOfWaterSurface()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Window window) {
		Object object = accept((AbstractOpening)window);
		if (object != null)
			return object;

		if (window.isSetGenericApplicationPropertyOfWindow()) {
			for (ADEComponent ade : window.getGenericApplicationPropertyOfWindow()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(X3DMaterial x3dMaterial) {
		Object object = accept((AbstractSurfaceData)x3dMaterial);
		if (object != null)
			return object;

		if (x3dMaterial.isSetGenericApplicationPropertyOfX3DMaterial()) {
			for (ADEComponent ade : x3dMaterial.getGenericApplicationPropertyOfX3DMaterial()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(_Material material) {
		return accept((_AbstractAppearance)material);
	}

	public Object accept(_SimpleTexture simpleTexture) {
		return accept((_AbstractAppearance)simpleTexture);
	}

	public Object accept(ImplicitGeometry implicitGeometry) {
		Object object = accept((AbstractGML)implicitGeometry);
		if (object != null)
			return object;

		if (implicitGeometry.isSetRelativeGMLGeometry()) {
			object = accept(implicitGeometry.getRelativeGMLGeometry());
			if (object != null)
				return object;
		}

		if (implicitGeometry.isSetReferencePoint()) {
			object = accept(implicitGeometry.getReferencePoint());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(TexCoordGen texCoordGen) {
		Object object = accept((AbstractTextureParameterization)texCoordGen);
		if (object != null)
			return object;

		if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen()) {
			for (ADEComponent ade : texCoordGen.getGenericApplicationPropertyOfTexCoordGen()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(TexCoordList texCoordList) {
		Object object = accept((AbstractTextureParameterization)texCoordList);
		if (object != null)
			return object;

		if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList()) {
			for (ADEComponent ade : texCoordList.getGenericApplicationPropertyOfTexCoordList()) {
				object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(AbstractGeometry abstractGeometry) {
		return accept((AbstractGML)abstractGeometry);
	}

	public Object accept(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		return accept((AbstractGeometry)abstractGeometricPrimitive);
	}

	public Object accept(AbstractGeometricAggregate abstractGeometricAggregate) {
		return accept((AbstractGeometry)abstractGeometricAggregate);
	}

	public Object accept(AbstractCurve abstractCurve) {
		return accept((AbstractGeometricPrimitive)abstractCurve);
	}

	public Object accept(AbstractSolid abstractSolid) {
		return accept((AbstractGeometricPrimitive)abstractSolid);
	}

	public Object accept(AbstractSurface abstractSurface) {
		return accept((AbstractGeometricPrimitive)abstractSurface);
	}

	public Object accept(AbstractRing abstractRing) {
		return accept((AbstractGeometry)abstractRing);
	}

	public Object accept(Triangle triangle) {
		if (triangle.isSetExterior()) {
			Object object = accept(triangle.getExterior());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(Rectangle rectangle) {
		if (rectangle.isSetExterior()) {
			Object object = accept(rectangle.getExterior());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(CompositeCurve compositeCurve) {
		Object object = accept((AbstractCurve)compositeCurve);
		if (object != null)
			return object;

		if (compositeCurve.isSetCurveMember()) {
			for (CurveProperty curveProperty : compositeCurve.getCurveMember()) {
				object = accept(curveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(CompositeSolid compositeSolid) {
		Object object = accept((AbstractSolid)compositeSolid);
		if (object != null)
			return object;

		if (compositeSolid.isSetSolidMember()) {
			for (SolidProperty solidProperty : compositeSolid.getSolidMember()) {
				object = accept(solidProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(CompositeSurface compositeSurface) {
		Object object = accept((AbstractSurface)compositeSurface);
		if (object != null)
			return object;

		if (compositeSurface.isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : compositeSurface.getSurfaceMember()) {
				object = accept(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Curve curve) {
		return accept((AbstractCurve)curve);
	}

	public Object accept(GeometricComplex geometricComplex) {
		Object object = accept((AbstractGeometry)geometricComplex);
		if (object != null)
			return object;

		if (geometricComplex.isSetElement()) {
			for (GeometricPrimitiveProperty geometricPrimitiveProperty : geometricComplex.getElement()) {
				object = accept(geometricPrimitiveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Grid grid) {
		return accept((AbstractGeometry)grid);
	}

	public Object accept(LinearRing linearRing) {
		return accept((AbstractRing)linearRing);
	}

	public Object accept(LineString lineString) {
		return accept((AbstractCurve)lineString);
	}

	public Object accept(MultiCurve multiCurve) {
		Object object = accept((AbstractGeometricAggregate)multiCurve);
		if (object != null)
			return object;

		if (multiCurve.isSetCurveMember()) {
			for (CurveProperty curveProperty : multiCurve.getCurveMember()) {
				object = accept(curveProperty);
				if (object != null)
					return object;
			}
		}

		if (multiCurve.isSetCurveMembers()) {
			object = accept(multiCurve.getCurveMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(MultiLineString multiLineString) {
		Object object = accept((AbstractGeometricAggregate)multiLineString);
		if (object != null)
			return object;

		if (multiLineString.isSetLineStringMember()) {
			for (LineStringProperty lineStringProperty : multiLineString.getLineStringMember()) {
				object = accept(lineStringProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(MultiPoint multiPoint) {
		Object object = accept((AbstractGeometricAggregate)multiPoint);
		if (object != null)
			return object;

		if (multiPoint.isSetPointMember()) {
			for (PointProperty pointProperty : multiPoint.getPointMember()) {
				object = accept(pointProperty);
				if (object != null)
					return object;
			}
		}

		if (multiPoint.isSetPointMembers()) {
			object = accept(multiPoint.getPointMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(MultiPolygon multiPolygon) {
		Object object = accept((AbstractGeometricAggregate)multiPolygon);
		if (object != null)
			return object;

		if (multiPolygon.isSetPolygonMember()) {
			for (PolygonProperty polygonProperty : multiPolygon.getPolygonMember()) {
				object = accept(polygonProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(MultiSolid multiSolid) {
		Object object = accept((AbstractGeometricAggregate)multiSolid);
		if (object != null)
			return object;

		if (multiSolid.isSetSolidMember()) {
			for (SolidProperty solidProperty : multiSolid.getSolidMember()) {
				object = accept(solidProperty);
				if (object != null)
					return object;
			}
		}

		if (multiSolid.isSetSolidMembers()) {
			object = accept(multiSolid.getSolidMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(MultiSurface multiSurface) {
		Object object = accept((AbstractGeometricAggregate)multiSurface);
		if (object != null)
			return object;

		if (multiSurface.isSetSurfaceMember()) {
			for (SurfaceProperty surfaceProperty : multiSurface.getSurfaceMember()) {
				object = accept(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (multiSurface.isSetSurfaceMembers()) {
			object = accept(multiSurface.getSurfaceMembers());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(OrientableCurve orientableCurve) {
		Object object = accept((AbstractCurve)orientableCurve);
		if (object != null)
			return object;

		if (orientableCurve.isSetBaseCurve()) {
			object = accept(orientableCurve.getBaseCurve());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(OrientableSurface orientableSurface) {
		Object object = accept((AbstractSurface)orientableSurface);
		if (object != null)
			return object;

		if (orientableSurface.isSetBaseSurface()) {
			object = accept(orientableSurface.getBaseSurface());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(_TexturedSurface texturedSurface) {
		Object object = accept((OrientableSurface)texturedSurface);
		if (object != null)
			return object;

		if (texturedSurface.isSetAppearance()) {
			for (_AppearanceProperty appearanceProperty : texturedSurface.getAppearance()) {
				object = accept(appearanceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Point point) {
		return accept((AbstractGeometricPrimitive)point);
	}

	public Object accept(Polygon polygon) {
		Object object = accept((AbstractSurface)polygon);
		if (object != null)
			return object;

		if (polygon.isSetExterior()) {
			object = accept(polygon.getExterior());
			if (object != null)
				return object;
		}

		if (polygon.isSetInterior()) {
			for (AbstractRingProperty abstractRingProperty : polygon.getInterior()) {
				object = accept(abstractRingProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(RectifiedGrid rectifiedGrid) {
		Object object = accept((Grid)rectifiedGrid);
		if (object != null)
			return object;

		if (rectifiedGrid.isSetOrigin()) {
			object = accept(rectifiedGrid.getOrigin());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(Ring ring) {
		Object object = accept((AbstractRing)ring);
		if (object != null)
			return object;

		if (ring.isSetCurveMember()) {
			for (CurveProperty curveProperty : ring.getCurveMember()) {
				object = accept(curveProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Solid solid) {
		Object object = accept((AbstractSolid)solid);
		if (object != null)
			return object;

		if (solid.isSetExterior()) {
			object = accept(solid.getExterior());
			if (object != null)
				return object;
		}

		if (solid.isSetInterior()) {
			for (SurfaceProperty surfaceProperty : solid.getInterior()) {
				object = accept(surfaceProperty);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(Surface surface) {
		Object object = accept((AbstractSurface)surface);
		if (object != null)
			return object;

		if (surface.isSetPatches()) {
			object = accept(surface.getPatches());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(Tin tin) {
		return accept((TriangulatedSurface)tin);
	}

	public Object accept(TriangulatedSurface triangulatedSurface) {
		return accept((Surface)triangulatedSurface);
	}

	public Object accept(AssociationByRep<? extends AbstractGML> association) {
		if (association.isSetObject() && visited.add(association.getObject())) {
			Object object = association.getObject().apply(this);
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(AssociationByRepOrRef<? extends AbstractGML> association) {
		return accept((AssociationByRep<? extends AbstractGML>)association);
	}

	public Object accept(FeatureProperty<? extends AbstractFeature> featureProperty) {
		Object object = accept((AssociationByRepOrRef<? extends AbstractFeature>)featureProperty);
		if (object != null)
			return object;

		if (featureProperty.isSetGenericADEComponent()) {
			object = accept(featureProperty.getGenericADEComponent());
			if (object != null)
				return object;
		}

		return null;
	}

	public Object accept(FeatureArrayProperty featureArrayProperty) {
		if (featureArrayProperty.isSetFeature()) {
			for (AbstractFeature feature : featureArrayProperty.getFeature())
				if (visited.add(feature)) {
					Object object = feature.apply(this);
					if (object != null)
						return object;
				}					
		}

		if (featureArrayProperty.isSetGenericADEComponent()) {
			for (ADEComponent ade : featureArrayProperty.getGenericADEComponent()) {
				Object object = accept(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public Object accept(GeometryProperty<? extends AbstractGeometry> geometryProperty) {
		return accept((AssociationByRepOrRef<? extends AbstractGeometry>)geometryProperty);
	}

	public Object accept(InlineGeometryProperty<? extends AbstractGeometry> geometryProperty) {
		return accept((AssociationByRep<? extends AbstractGeometry>)geometryProperty);
	}

	public Object accept(GeometryArrayProperty<? extends AbstractGeometry> geometryArrayProperty) {
		if (geometryArrayProperty.isSetGeometry()) {
			for (AbstractGeometry abstractGeometry : geometryArrayProperty.getGeometry())
				if (visited.add(abstractGeometry)) {
					Object object = abstractGeometry.apply(this);
					if (object != null)
						return object;
				}
		}

		return null;
	}

	public Object accept(SurfacePatchArrayProperty surfacePatchArrayProperty) {
		Object object = null;

		if (surfacePatchArrayProperty.isSetSurfacePatch()) {
			for (AbstractSurfacePatch abstractSurfacePatch : surfacePatchArrayProperty.getSurfacePatch()) {
				if (visited.add(abstractSurfacePatch)) {
					if (abstractSurfacePatch instanceof Triangle) {
						object = accept((Triangle)abstractSurfacePatch);
						if (object != null)
							return object;
					} else if (abstractSurfacePatch instanceof Rectangle) {
						object = accept((Rectangle)abstractSurfacePatch);
						if (object != null)
							return object;
					}
				}
			}
		}

		return null;
	}

	public Object accept(Element element, ElementDecl decl) {
		return null;
	}

	public Object accept(ADEComponent adeComponent) {
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

	protected Object accept(Value value) {
		if (value.isSetGeometry() && visited.add(value.getGeometry())) {
			Object object = value.getGeometry().apply(this);
			if (object != null)
				return object;
		} else if (value.isSetValueObject()) {
			Object object = accept(value.getValueObject());
			if (object != null)
				return object;
		}

		return null;
	}

	protected Object accept(ValueObject valueObject) {
		if (valueObject.isSetCompositeValue()) {
			Object object = valueObject.getCompositeValue().apply(this);
			if (object != null)
				return object;
		}

		return null;
	}
}
