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
import org.citygml4j.model.citygml.appearance.AppearanceMember;
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
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
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
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.gml.coverage.AbstractCoverage;
import org.citygml4j.model.gml.coverage.AbstractDiscreteCoverage;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.AbstractFeatureCollection;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public abstract class FeatureFunctionWalker<T> extends Walker implements FeatureFunctor<T> {
	protected SchemaHandler schemaHandler;
	protected ADEWalkerHelper<FeatureFunctionWalker<T>> adeWalkerHelper;

	public FeatureFunctionWalker() {
		CityGMLContext context = CityGMLContext.getInstance();
		if (context.hasADEContexts()) {
			for (ADEContext adeContext : CityGMLContext.getInstance().getADEContexts())
				useADEWalker(adeContext.createDefaultFeatureFunctionWalker());
		}
	}

	public final FeatureFunctionWalker<T> setSchemaHandler(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
		return this;
	}

	public final SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}
	
	public final FeatureFunctionWalker<T> useADEWalker(ADEWalker<FeatureFunctionWalker<T>> walker) {
		if (walker != null) {
			if (adeWalkerHelper == null) {
				adeWalkerHelper = new ADEWalkerHelper<>();
				adeWalkerHelper.inferFunctionType(this, FeatureFunctionWalker.class);
			}

			walker.setParentWalker(this);
			adeWalkerHelper.addADEWalker(walker);
		}

		return this;
	}
	
	@SafeVarargs
	public final FeatureFunctionWalker<T> useADEWalkers(ADEWalker<FeatureFunctionWalker<T>>... walkers) {
		for (ADEWalker<FeatureFunctionWalker<T>> walker : walkers)
			useADEWalker(walker);

		return this;
	}

	public T apply(org.citygml4j.model.citygml.bridge.AbstractBoundarySurface abstractBoundarySurface) {
		T object = apply((AbstractCityObject)abstractBoundarySurface);
		if (object != null)
			return object;

		if (abstractBoundarySurface.isSetOpening()) {
			for (org.citygml4j.model.citygml.bridge.OpeningProperty openingProperty : new ArrayList<org.citygml4j.model.citygml.bridge.OpeningProperty>(abstractBoundarySurface.getOpening())) {
				object = apply(openingProperty);
				if (object != null)
					return object;					
			}
		}

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.AbstractBoundarySurface abstractBoundarySurface) {
		T object = apply((AbstractCityObject)abstractBoundarySurface);
		if (object != null)
			return object;

		if (abstractBoundarySurface.isSetOpening()) {
			for (org.citygml4j.model.citygml.building.OpeningProperty openingProperty : new ArrayList<org.citygml4j.model.citygml.building.OpeningProperty>(abstractBoundarySurface.getOpening())) {
				object = apply(openingProperty);
				if (object != null)
					return object;					
			}
		}

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface abstractBoundarySurface) {
		T object = apply((AbstractCityObject)abstractBoundarySurface);
		if (object != null)
			return object;

		if (abstractBoundarySurface.isSetOpening()) {
			for (org.citygml4j.model.citygml.tunnel.OpeningProperty openingProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.OpeningProperty>(abstractBoundarySurface.getOpening())) {
				object = apply(openingProperty);
				if (object != null)
					return object;					
			}
		}

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractBridge abstractBridge) {
		T object = apply((AbstractSite)abstractBridge);
		if (object != null)
			return object;

		if (abstractBridge.isSetOuterBridgeConstructionElement()) {
			for (BridgeConstructionElementProperty bridgeConstructionElementProperty : new ArrayList<BridgeConstructionElementProperty>(abstractBridge.getOuterBridgeConstructionElement())) {
				object = apply(bridgeConstructionElementProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBridge.isSetOuterBridgeInstallation()) {
			for (BridgeInstallationProperty bridgeInstallationProperty : new ArrayList<BridgeInstallationProperty>(abstractBridge.getOuterBridgeInstallation())) {
				object = apply(bridgeInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBridge.isSetInteriorBridgeInstallation()) {
			for (IntBridgeInstallationProperty intBridgeInstallationProperty : new ArrayList<IntBridgeInstallationProperty>(abstractBridge.getInteriorBridgeInstallation())) {
				object = apply(intBridgeInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBridge.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(abstractBridge.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBridge.isSetConsistsOfBridgePart()) {
			for (BridgePartProperty bridgePartProperty : new ArrayList<BridgePartProperty>(abstractBridge.getConsistsOfBridgePart())) {
				object = apply(bridgePartProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBridge.isSetInteriorBridgeRoom()) {
			for (InteriorBridgeRoomProperty interiorBridgeRoomProperty : new ArrayList<InteriorBridgeRoomProperty>(abstractBridge.getInteriorBridgeRoom())) {
				object = apply(interiorBridgeRoomProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBridge.isSetAddress()) {
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(abstractBridge.getAddress())) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBridge.isSetGenericApplicationPropertyOfAbstractBridge()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBridge.getGenericApplicationPropertyOfAbstractBridge())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractBuilding abstractBuilding) {
		T object = apply((AbstractSite)abstractBuilding);
		if (object != null)
			return object;

		if (abstractBuilding.isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty buildingInstallationProperty : new ArrayList<BuildingInstallationProperty>(abstractBuilding.getOuterBuildingInstallation())) {
				object = apply(buildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(abstractBuilding.getInteriorBuildingInstallation())) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.building.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.building.BoundarySurfaceProperty>(abstractBuilding.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty buildingPartProperty : new ArrayList<BuildingPartProperty>(abstractBuilding.getConsistsOfBuildingPart())) {
				object = apply(buildingPartProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetInteriorRoom()) {
			for (InteriorRoomProperty interiorRoomProperty : new ArrayList<InteriorRoomProperty>(abstractBuilding.getInteriorRoom())) {
				object = apply(interiorRoomProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetAddress()) {
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(abstractBuilding.getAddress())) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractBuilding.isSetGenericApplicationPropertyOfAbstractBuilding()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBuilding.getGenericApplicationPropertyOfAbstractBuilding())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractCityObject abstractCityObject) {
		T object = apply((AbstractFeature)abstractCityObject);
		if (object != null)
			return object;

		if (abstractCityObject.isSetGeneralizesTo()) {
			for (GeneralizationRelation generalizationRelation : new ArrayList<GeneralizationRelation>(abstractCityObject.getGeneralizesTo())) {
				object = apply(generalizationRelation);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetAppearance()) {
			for (AppearanceProperty appearanceProperty : new ArrayList<AppearanceProperty>(abstractCityObject.getAppearance())) {
				object = apply(appearanceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractCityObject.isSetGenericApplicationPropertyOfCityObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractCityObject.getGenericApplicationPropertyOfCityObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractCoverage abstractCoverage) {
		return apply((AbstractFeature)abstractCoverage);
	}

	public T apply(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		return apply((AbstractCoverage)abstractDiscreteCoverage);
	}

	public T apply(AbstractFeature abstractFeature) {
		return null;
	}

	public T apply(AbstractFeatureCollection abstractFeatureCollection) {
		T object = apply((AbstractFeature)abstractFeatureCollection);
		if (object != null)
			return object;

		if (abstractFeatureCollection.isSetFeatureMember()) {
			for (FeatureMember featureMember : new ArrayList<FeatureMember>(abstractFeatureCollection.getFeatureMember())) {
				object = apply(featureMember);
				if (object != null)
					return object;
			}
		}

		if (abstractFeatureCollection.isSetFeatureMembers())
			apply(abstractFeatureCollection.getFeatureMembers());

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.AbstractOpening abstractOpening) {
		T object = apply((AbstractCityObject)abstractOpening);
		if (object != null)
			return object;

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.AbstractOpening abstractOpening) {
		T object = apply((AbstractCityObject)abstractOpening);
		if (object != null)
			return object;

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.AbstractOpening abstractOpening) {
		T object = apply((AbstractCityObject)abstractOpening);
		if (object != null)
			return object;

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractReliefComponent abstractReliefComponent) {
		T object = apply((AbstractCityObject)abstractReliefComponent);
		if (object != null)
			return object;

		if (abstractReliefComponent.isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractReliefComponent.getGenericApplicationPropertyOfReliefComponent())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractSite abstractSite) {
		T object = apply((AbstractCityObject)abstractSite);
		if (object != null)
			return object;

		if (abstractSite.isSetGenericApplicationPropertyOfSite()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSite.getGenericApplicationPropertyOfSite())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractSurfaceData abstractSurfaceData) {
		T object = apply((AbstractFeature)abstractSurfaceData);
		if (object != null)
			return object;

		if (abstractSurfaceData.isSetGenericApplicationPropertyOfSurfaceData()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractSurfaceData.getGenericApplicationPropertyOfSurfaceData())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractTexture abstractTexture) {
		T object = apply((AbstractSurfaceData)abstractTexture);
		if (object != null)
			return object;

		if (abstractTexture.isSetGenericApplicationPropertyOfTexture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTexture.getGenericApplicationPropertyOfTexture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractTransportationObject abstractTransportationObject) {
		T object = apply((AbstractCityObject)abstractTransportationObject);
		if (object != null)
			return object;

		if (abstractTransportationObject.isSetGenericApplicationPropertyOfTransportationObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTransportationObject.getGenericApplicationPropertyOfTransportationObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractTunnel abstractTunnel) {
		T object = apply((AbstractSite)abstractTunnel);
		if (object != null)
			return object;

		if (abstractTunnel.isSetOuterTunnelInstallation()) {
			for (TunnelInstallationProperty tunnelInstallationProperty : new ArrayList<TunnelInstallationProperty>(abstractTunnel.getOuterTunnelInstallation())) {
				object = apply(tunnelInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractTunnel.isSetInteriorTunnelInstallation()) {
			for (IntTunnelInstallationProperty intTunnelInstallationProperty : new ArrayList<IntTunnelInstallationProperty>(abstractTunnel.getInteriorTunnelInstallation())) {
				object = apply(intTunnelInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractTunnel.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(abstractTunnel.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractTunnel.isSetConsistsOfTunnelPart()) {
			for (TunnelPartProperty tunnelPartProperty : new ArrayList<TunnelPartProperty>(abstractTunnel.getConsistsOfTunnelPart())) {
				object = apply(tunnelPartProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractTunnel.isSetInteriorHollowSpace()) {
			for (InteriorHollowSpaceProperty interiorHollowSpaceProperty : new ArrayList<InteriorHollowSpaceProperty>(abstractTunnel.getInteriorHollowSpace())) {
				object = apply(interiorHollowSpaceProperty);
				if (object != null)
					return object;
			}
		}

		if (abstractTunnel.isSetGenericApplicationPropertyOfAbstractTunnel()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractTunnel.getGenericApplicationPropertyOfAbstractTunnel())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractVegetationObject abstractVegetationObject) {
		T object = apply((AbstractCityObject)abstractVegetationObject);
		if (object != null)
			return object;

		if (abstractVegetationObject.isSetGenericApplicationPropertyOfVegetationObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractVegetationObject.getGenericApplicationPropertyOfVegetationObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractWaterBoundarySurface abstractWaterBoundarySurface) {
		T object = apply((AbstractCityObject)abstractWaterBoundarySurface);
		if (object != null)
			return object;

		if (abstractWaterBoundarySurface.isSetGenericApplicationPropertyOfWaterBoundarySurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterBoundarySurface.getGenericApplicationPropertyOfWaterBoundarySurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(AbstractWaterObject abstractWaterObject) {
		T object = apply((AbstractCityObject)abstractWaterObject);
		if (object != null)
			return object;

		if (abstractWaterObject.isSetGenericApplicationPropertyOfWaterObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractWaterObject.getGenericApplicationPropertyOfWaterObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}		

		return null;
	}

	public T apply(Appearance appearance) {
		T object = apply((AbstractFeature)appearance);
		if (object != null)
			return object;

		if (appearance.isSetSurfaceDataMember())
			for (SurfaceDataProperty surfaceDataProperty : new ArrayList<SurfaceDataProperty>(appearance.getSurfaceDataMember())) {
				object = apply(surfaceDataProperty);
				if (object != null)
					return object;
			}

		if (appearance.isSetGenericApplicationPropertyOfAppearance()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(appearance.getGenericApplicationPropertyOfAppearance())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(GeoreferencedTexture georeferencedTexture) {
		T object = apply((AbstractTexture)georeferencedTexture);
		if (object != null)
			return object;

		if (georeferencedTexture.isSetGenericApplicationPropertyOfGeoreferencedTexture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(ParameterizedTexture parameterizedTexture) {
		T object = apply((AbstractTexture)parameterizedTexture);
		if (object != null)
			return object;

		if (parameterizedTexture.isSetTarget()) {
			for (TextureAssociation textureAssociation : new ArrayList<TextureAssociation>(parameterizedTexture.getTarget())) {
				if (textureAssociation.isSetTextureParameterization() && shouldWalk) {
					AbstractTextureParameterization textureParameterization = textureAssociation.getTextureParameterization();

					if (textureParameterization instanceof TexCoordGen) {
						TexCoordGen texCoordGen = (TexCoordGen)textureParameterization;
						if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen()) {
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordGen.getGenericApplicationPropertyOfTexCoordGen())) {
								object = apply(ade);
								if (object != null)
									return object;
							}
						}
					}

					else if (textureParameterization instanceof TexCoordList) {
						TexCoordList texCoordList = (TexCoordList)textureParameterization;
						if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList()) {
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordList.getGenericApplicationPropertyOfTexCoordList())) {
								object = apply(ade);
								if (object != null)
									return object;
							}
						}
					}

					if (textureParameterization.isSetGenericADEComponent()) {
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericADEElement())) {
							object = apply(ade);
							if (object != null)
								return object;
						}
					}

					if (textureParameterization.isSetGenericApplicationPropertyOfTextureParameterization()) {
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericApplicationPropertyOfTextureParameterization())) {
							object = apply(ade);
							if (object != null)
								return object;
						}
					}
				}				
			}
		}

		if (parameterizedTexture.isSetGenericApplicationPropertyOfParameterizedTexture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(parameterizedTexture.getGenericApplicationPropertyOfParameterizedTexture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(X3DMaterial x3dMaterial) {
		T object = apply((AbstractSurfaceData)x3dMaterial);
		if (object != null)
			return object;

		if (x3dMaterial.isSetGenericApplicationPropertyOfX3DMaterial()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(x3dMaterial.getGenericApplicationPropertyOfX3DMaterial())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Bridge bridge) {
		T object = apply((AbstractBridge)bridge);
		if (object != null)
			return object;

		if (bridge.isSetGenericApplicationPropertyOfBridge()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridge.getGenericApplicationPropertyOfBridge())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BridgeConstructionElement bridgeConstructionElement) {
		T object = apply((AbstractCityObject)bridgeConstructionElement);
		if (object != null)
			return object;

		if (bridgeConstructionElement.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(bridgeConstructionElement.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (bridgeConstructionElement.isSetGenericApplicationPropertyOfBridgeConstructionElement()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeConstructionElement.getGenericApplicationPropertyOfBridgeConstructionElement())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BridgeFurniture bridgeFurniture) {
		T object = apply((AbstractCityObject)bridgeFurniture);
		if (object != null)
			return object;

		if (bridgeFurniture.isSetGenericApplicationPropertyOfBridgeFurniture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeFurniture.getGenericApplicationPropertyOfBridgeFurniture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BridgeInstallation bridgeInstallation) {
		T object = apply((AbstractCityObject)bridgeInstallation);
		if (object != null)
			return object;

		if (bridgeInstallation.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(bridgeInstallation.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (bridgeInstallation.isSetGenericApplicationPropertyOfBridgeInstallation()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeInstallation.getGenericApplicationPropertyOfBridgeInstallation())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BridgePart bridgePart) {
		T object = apply((AbstractBridge)bridgePart);
		if (object != null)
			return object;

		if (bridgePart.isSetGenericApplicationPropertyOfBridgePart()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgePart.getGenericApplicationPropertyOfBridgePart())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BridgeRoom bridgeRoom) {
		T object = apply((AbstractCityObject)bridgeRoom);
		if (object != null)
			return object;

		if (bridgeRoom.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(bridgeRoom.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (bridgeRoom.isSetInteriorFurniture()) {
			for (org.citygml4j.model.citygml.bridge.InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<org.citygml4j.model.citygml.bridge.InteriorFurnitureProperty>(bridgeRoom.getInteriorFurniture())) {
				object = apply(interiorFurnitureProperty);
				if (object != null)
					return object;
			}
		}

		if (bridgeRoom.isSetBridgeRoomInstallation()) {
			for (IntBridgeInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBridgeInstallationProperty>(bridgeRoom.getBridgeRoomInstallation())) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (bridgeRoom.isSetGenericApplicationPropertyOfBridgeRoom()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeRoom.getGenericApplicationPropertyOfBridgeRoom())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(IntBridgeInstallation intBridgeInstallation) {
		T object = apply((AbstractCityObject)intBridgeInstallation);
		if (object != null)
			return object;

		if (intBridgeInstallation.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(intBridgeInstallation.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (intBridgeInstallation.isSetGenericApplicationPropertyOfIntBridgeInstallation()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(intBridgeInstallation.getGenericApplicationPropertyOfIntBridgeInstallation())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.CeilingSurface ceilingSurface) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)ceilingSurface);
		if (object != null)
			return object;

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.OuterCeilingSurface outerCeilingSurface) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)outerCeilingSurface);
		if (object != null)
			return object;

		if (outerCeilingSurface.isSetGenericApplicationPropertyOfOuterCeilingSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerCeilingSurface.getGenericApplicationPropertyOfOuterCeilingSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.ClosureSurface closureSurface) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)closureSurface);
		if (object != null)
			return object;

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.FloorSurface floorSurface) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)floorSurface);
		if (object != null)
			return object;

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.OuterFloorSurface outerFloorSurface) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)outerFloorSurface);
		if (object != null)
			return object;

		if (outerFloorSurface.isSetGenericApplicationPropertyOfOuterFloorSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerFloorSurface.getGenericApplicationPropertyOfOuterFloorSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.GroundSurface groundSurface) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)groundSurface);
		if (object != null)
			return object;

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.InteriorWallSurface interiorWallSurface) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)interiorWallSurface);
		if (object != null)
			return object;

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.RoofSurface roofSurface) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)roofSurface);
		if (object != null)
			return object;

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.WallSurface wallSurface) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractBoundarySurface)wallSurface);
		if (object != null)
			return object;

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.Door door) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractOpening)door);
		if (object != null)
			return object;

		if (door.isSetAddress()) {
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress())) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (door.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.bridge.Window window) {
		T object = apply((org.citygml4j.model.citygml.bridge.AbstractOpening)window);
		if (object != null)
			return object;

		if (window.isSetGenericApplicationPropertyOfWindow()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Building building) {
		T object = apply((AbstractBuilding)building);
		if (object != null)
			return object;

		if (building.isSetGenericApplicationPropertyOfBuilding()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(building.getGenericApplicationPropertyOfBuilding())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BuildingFurniture buildingFurniture) {
		T object = apply((AbstractCityObject)buildingFurniture);
		if (object != null)
			return object;

		if (buildingFurniture.isSetGenericApplicationPropertyOfBuildingFurniture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BuildingInstallation buildingInstallation) {
		T object = apply((AbstractCityObject)buildingInstallation);
		if (object != null)
			return object;

		if (buildingInstallation.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.building.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.building.BoundarySurfaceProperty>(buildingInstallation.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (buildingInstallation.isSetGenericApplicationPropertyOfBuildingInstallation()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingInstallation.getGenericApplicationPropertyOfBuildingInstallation())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BuildingPart buildingPart) {
		T object = apply((AbstractBuilding)buildingPart);
		if (object != null)
			return object;

		if (buildingPart.isSetGenericApplicationPropertyOfBuildingPart()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingPart.getGenericApplicationPropertyOfBuildingPart())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(IntBuildingInstallation intBuildingInstallation) {
		T object = apply((AbstractCityObject)intBuildingInstallation);
		if (object != null)
			return object;

		if (intBuildingInstallation.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.building.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.building.BoundarySurfaceProperty>(intBuildingInstallation.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (intBuildingInstallation.isSetGenericApplicationPropertyOfIntBuildingInstallation()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(intBuildingInstallation.getGenericApplicationPropertyOfIntBuildingInstallation())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Room room) {
		T object = apply((AbstractCityObject)room);
		if (object != null)
			return object;

		if (room.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.building.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.building.BoundarySurfaceProperty>(room.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetInteriorFurniture()) {
			for (org.citygml4j.model.citygml.building.InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<org.citygml4j.model.citygml.building.InteriorFurnitureProperty>(room.getInteriorFurniture())) {
				object = apply(interiorFurnitureProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetRoomInstallation()) {
			for (IntBuildingInstallationProperty intBuildingInstallationProperty : new ArrayList<IntBuildingInstallationProperty>(room.getRoomInstallation())) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (room.isSetGenericApplicationPropertyOfRoom()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(room.getGenericApplicationPropertyOfRoom())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.CeilingSurface ceilingSurface) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractBoundarySurface)ceilingSurface);
		if (object != null)
			return object;

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.OuterCeilingSurface outerCeilingSurface) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractBoundarySurface)outerCeilingSurface);
		if (object != null)
			return object;

		if (outerCeilingSurface.isSetGenericApplicationPropertyOfOuterCeilingSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerCeilingSurface.getGenericApplicationPropertyOfOuterCeilingSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.ClosureSurface closureSurface) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractBoundarySurface)closureSurface);
		if (object != null)
			return object;

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.FloorSurface floorSurface) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractBoundarySurface)floorSurface);
		if (object != null)
			return object;

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.OuterFloorSurface outerFloorSurface) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractBoundarySurface)outerFloorSurface);
		if (object != null)
			return object;

		if (outerFloorSurface.isSetGenericApplicationPropertyOfOuterFloorSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerFloorSurface.getGenericApplicationPropertyOfOuterFloorSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.GroundSurface groundSurface) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractBoundarySurface)groundSurface);
		if (object != null)
			return object;

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.InteriorWallSurface interiorWallSurface) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractBoundarySurface)interiorWallSurface);
		if (object != null)
			return object;

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.RoofSurface roofSurface) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractBoundarySurface)roofSurface);
		if (object != null)
			return object;

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.WallSurface wallSurface) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractBoundarySurface)wallSurface);
		if (object != null)
			return object;

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.Door door) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractOpening)door);
		if (object != null)
			return object;

		if (door.isSetAddress()) {
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress())) {
				object = apply(addressProperty);
				if (object != null)
					return object;
			}
		}

		if (door.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.building.Window window) {
		T object = apply((org.citygml4j.model.citygml.building.AbstractOpening)window);
		if (object != null)
			return object;

		if (window.isSetGenericApplicationPropertyOfWindow()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(HollowSpace hollowSpace) {
		T object = apply((AbstractCityObject)hollowSpace);
		if (object != null)
			return object;

		if (hollowSpace.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(hollowSpace.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (hollowSpace.isSetInteriorFurniture()) {
			for (org.citygml4j.model.citygml.tunnel.InteriorFurnitureProperty interiorFurnitureProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.InteriorFurnitureProperty>(hollowSpace.getInteriorFurniture())) {
				object = apply(interiorFurnitureProperty);
				if (object != null)
					return object;
			}
		}

		if (hollowSpace.isSetHollowSpaceInstallation()) {
			for (IntTunnelInstallationProperty intBuildingInstallationProperty : new ArrayList<IntTunnelInstallationProperty>(hollowSpace.getHollowSpaceInstallation())) {
				object = apply(intBuildingInstallationProperty);
				if (object != null)
					return object;
			}
		}

		if (hollowSpace.isSetGenericApplicationPropertyOfHollowSpace()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(hollowSpace.getGenericApplicationPropertyOfHollowSpace())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(IntTunnelInstallation intTunnelInstallation) {
		T object = apply((AbstractCityObject)intTunnelInstallation);
		if (object != null)
			return object;

		if (intTunnelInstallation.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(intTunnelInstallation.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (intTunnelInstallation.isSetGenericApplicationPropertyOfIntTunnelInstallation()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(intTunnelInstallation.getGenericApplicationPropertyOfIntTunnelInstallation())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Tunnel tunnel) {
		T object = apply((AbstractTunnel)tunnel);
		if (object != null)
			return object;

		if (tunnel.isSetGenericApplicationPropertyOfTunnel()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(tunnel.getGenericApplicationPropertyOfTunnel())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TunnelFurniture tunnelFurniture) {
		T object = apply((AbstractCityObject)tunnelFurniture);
		if (object != null)
			return object;

		if (tunnelFurniture.isSetGenericApplicationPropertyOfTunnelFurniture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(tunnelFurniture.getGenericApplicationPropertyOfTunnelFurniture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TunnelInstallation tunnelInstallation) {
		T object = apply((AbstractCityObject)tunnelInstallation);
		if (object != null)
			return object;

		if (tunnelInstallation.isSetBoundedBySurface()) {
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(tunnelInstallation.getBoundedBySurface())) {
				object = apply(boundarySurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (tunnelInstallation.isSetGenericApplicationPropertyOfTunnelInstallation()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(tunnelInstallation.getGenericApplicationPropertyOfTunnelInstallation())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TunnelPart tunnelPart) {
		T object = apply((AbstractTunnel)tunnelPart);
		if (object != null)
			return object;

		if (tunnelPart.isSetGenericApplicationPropertyOfTunnelPart()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(tunnelPart.getGenericApplicationPropertyOfTunnelPart())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.CeilingSurface ceilingSurface) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)ceilingSurface);
		if (object != null)
			return object;

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.OuterCeilingSurface outerCeilingSurface) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)outerCeilingSurface);
		if (object != null)
			return object;

		if (outerCeilingSurface.isSetGenericApplicationPropertyOfOuterCeilingSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerCeilingSurface.getGenericApplicationPropertyOfOuterCeilingSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.ClosureSurface closureSurface) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)closureSurface);
		if (object != null)
			return object;

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.FloorSurface floorSurface) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)floorSurface);
		if (object != null)
			return object;

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.OuterFloorSurface outerFloorSurface) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)outerFloorSurface);
		if (object != null)
			return object;

		if (outerFloorSurface.isSetGenericApplicationPropertyOfOuterFloorSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerFloorSurface.getGenericApplicationPropertyOfOuterFloorSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.GroundSurface groundSurface) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)groundSurface);
		if (object != null)
			return object;

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.InteriorWallSurface interiorWallSurface) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)interiorWallSurface);
		if (object != null)
			return object;

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.RoofSurface roofSurface) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)roofSurface);
		if (object != null)
			return object;

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.WallSurface wallSurface) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface)wallSurface);
		if (object != null)
			return object;

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.Door door) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractOpening)door);
		if (object != null)
			return object;

		if (door.isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(org.citygml4j.model.citygml.tunnel.Window window) {
		T object = apply((org.citygml4j.model.citygml.tunnel.AbstractOpening)window);
		if (object != null)
			return object;

		if (window.isSetGenericApplicationPropertyOfWindow()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(window.getGenericApplicationPropertyOfWindow())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CityFurniture cityFurniture) {
		T object = apply((AbstractCityObject)cityFurniture);
		if (object != null)
			return object;

		if (cityFurniture.isSetGenericApplicationPropertyOfCityFurniture()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityFurniture.getGenericApplicationPropertyOfCityFurniture())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CityObjectGroup cityObjectGroup) {
		T object = apply((AbstractCityObject)cityObjectGroup);
		if (object != null)
			return object;

		if (cityObjectGroup.isSetGroupMember()) {
			for (CityObjectGroupMember cityObjectGroupMember : new ArrayList<CityObjectGroupMember>(cityObjectGroup.getGroupMember())) {
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

		if (cityObjectGroup.isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Address address) {
		T object = apply((AbstractFeature)address);
		if (object != null)
			return object;

		if (address.isSetGenericApplicationPropertyOfAddress()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(address.getGenericApplicationPropertyOfAddress())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(CityModel cityModel) {
		T object = apply((AbstractFeatureCollection)cityModel);
		if (object != null)
			return object;

		if (cityModel.isSetCityObjectMember()) {
			for (CityObjectMember cityObjectMember : new ArrayList<CityObjectMember>(cityModel.getCityObjectMember())) {
				object = apply(cityObjectMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetAppearanceMember()) {
			for (AppearanceMember appearanceMember : new ArrayList<AppearanceMember>(cityModel.getAppearanceMember())) {
				object = apply(appearanceMember);
				if (object != null)
					return object;
			}
		}

		if (cityModel.isSetGenericApplicationPropertyOfCityModel()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityModel.getGenericApplicationPropertyOfCityModel())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(GenericCityObject genericCityObject) {
		T object = apply((AbstractCityObject)genericCityObject);
		if (object != null)
			return object;

		return null;
	}

	public T apply(LandUse landUse) {
		T object = apply((AbstractCityObject)landUse);
		if (object != null)
			return object;

		if (landUse.isSetGenericApplicationPropertyOfLandUse()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(landUse.getGenericApplicationPropertyOfLandUse())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(BreaklineRelief breaklineRelief) {
		T object = apply((AbstractReliefComponent)breaklineRelief);
		if (object != null)
			return object;

		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(MassPointRelief massPointRelief) {
		T object = apply((AbstractReliefComponent)massPointRelief);
		if (object != null)
			return object;

		if (massPointRelief.isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(massPointRelief.getGenericApplicationPropertyOfMassPointRelief())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(RasterRelief rasterRelief) {
		T object = apply((AbstractReliefComponent)rasterRelief);
		if (object != null)
			return object;

		if (rasterRelief.isSetGrid()) {
			object = apply(rasterRelief.getGrid());
			if (object != null)
				return object;
		}

		if (rasterRelief.isSetGenericApplicationPropertyOfRasterRelief()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(rasterRelief.getGenericApplicationPropertyOfRasterRelief())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(ReliefFeature reliefFeature) {
		T object = apply((AbstractCityObject)reliefFeature);
		if (object != null)
			return object;

		if (reliefFeature.isSetReliefComponent()) {
			for (ReliefComponentProperty reliefComponentProperty : new ArrayList<ReliefComponentProperty>(reliefFeature.getReliefComponent())) {
				object = apply(reliefComponentProperty);
				if (object != null)
					return object;
			}
		}

		if (reliefFeature.isSetGenericApplicationPropertyOfReliefFeature()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(reliefFeature.getGenericApplicationPropertyOfReliefFeature())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TINRelief tinRelief) {
		T object = apply((AbstractReliefComponent)tinRelief);
		if (object != null)
			return object;

		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(tinRelief.getGenericApplicationPropertyOfTinRelief())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		T object = apply((AbstractTransportationObject)auxiliaryTrafficArea);
		if (object != null)
			return object;

		if (auxiliaryTrafficArea.isSetGenericApplicationPropertyOfAuxiliaryTrafficArea()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(auxiliaryTrafficArea.getGenericApplicationPropertyOfAuxiliaryTrafficArea())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Railway railway) {
		T object = apply((TransportationComplex)railway);
		if (object != null)
			return object;

		if (railway.isSetGenericApplicationPropertyOfRailway()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(railway.getGenericApplicationPropertyOfRailway())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(RectifiedGridCoverage rectifiedGridCoverage) {
		T object = apply((AbstractDiscreteCoverage)rectifiedGridCoverage);
		if (object != null)
			return object;

		return null;
	}

	public T apply(Road road) {
		T object = apply((TransportationComplex)road);
		if (object != null)
			return object;

		if (road.isSetGenericApplicationPropertyOfRoad()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(road.getGenericApplicationPropertyOfRoad())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Square square) {
		T object = apply((TransportationComplex)square);
		if (object != null)
			return object;

		if (square.isSetGenericApplicationPropertyOfSquare()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(square.getGenericApplicationPropertyOfSquare())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Track track) {
		T object = apply((TransportationComplex)track);
		if (object != null)
			return object;

		if (track.isSetGenericApplicationPropertyOfTrack()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(track.getGenericApplicationPropertyOfTrack())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TrafficArea trafficArea) {
		T object = apply((AbstractTransportationObject)trafficArea);
		if (object != null)
			return object;

		if (trafficArea.isSetGenericApplicationPropertyOfTrafficArea()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(trafficArea.getGenericApplicationPropertyOfTrafficArea())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(TransportationComplex transportationComplex) {
		T object = apply((AbstractTransportationObject)transportationComplex);
		if (object != null)
			return object;

		if (transportationComplex.isSetTrafficArea()) {
			for (TrafficAreaProperty trafficAreaProperty : new ArrayList<TrafficAreaProperty>(transportationComplex.getTrafficArea())) {
				object = apply(trafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetAuxiliaryTrafficArea()) {
			for (AuxiliaryTrafficAreaProperty auxiliaryTrafficAreaProperty : new ArrayList<AuxiliaryTrafficAreaProperty>(transportationComplex.getAuxiliaryTrafficArea())) {
				object = apply(auxiliaryTrafficAreaProperty);
				if (object != null)
					return object;
			}
		}

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(transportationComplex.getGenericApplicationPropertyOfTransportationComplex())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(PlantCover plantCover) {
		T object = apply((AbstractVegetationObject)plantCover);
		if (object != null)
			return object;

		if (plantCover.isSetGenericApplicationPropertyOfPlantCover()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(plantCover.getGenericApplicationPropertyOfPlantCover())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(SolitaryVegetationObject solitaryVegetationObject) {
		T object = apply((AbstractVegetationObject)solitaryVegetationObject);
		if (object != null)
			return object;

		if (solitaryVegetationObject.isSetGenericApplicationPropertyOfSolitaryVegetationObject()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(solitaryVegetationObject.getGenericApplicationPropertyOfSolitaryVegetationObject())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(WaterBody waterBody) {
		T object = apply((AbstractWaterObject)waterBody);
		if (object != null)
			return object;

		if (waterBody.isSetBoundedBySurface()) {
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : new ArrayList<BoundedByWaterSurfaceProperty>(waterBody.getBoundedBySurface())) {
				object = apply(boundedByWaterSurfaceProperty);
				if (object != null)
					return object;
			}
		}

		if (waterBody.isSetGenericApplicationPropertyOfWaterBody()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterBody.getGenericApplicationPropertyOfWaterBody())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(WaterClosureSurface waterClosureSurface) {
		T object = apply((AbstractWaterBoundarySurface)waterClosureSurface);
		if (object != null)
			return object;

		if (waterClosureSurface.isSetGenericApplicationPropertyOfWaterClosureSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterClosureSurface.getGenericApplicationPropertyOfWaterClosureSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(WaterGroundSurface waterGroundSurface) {
		T object = apply((AbstractWaterBoundarySurface)waterGroundSurface);
		if (object != null)
			return object;

		if (waterGroundSurface.isSetGenericApplicationPropertyOfWaterGroundSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterGroundSurface.getGenericApplicationPropertyOfWaterGroundSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(WaterSurface waterSurface) {
		T object = apply((AbstractWaterBoundarySurface)waterSurface);
		if (object != null)
			return object;

		if (waterSurface.isSetGenericApplicationPropertyOfWaterSurface()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(waterSurface.getGenericApplicationPropertyOfWaterSurface())) {
				object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public <E extends AbstractFeature> T apply(FeatureProperty<E> featureProperty) {
		if (featureProperty.isSetFeature() && shouldWalk) {
			T object = featureProperty.getFeature().accept(this);
			if (object != null)
				return object;
		}

		if (featureProperty.isSetGenericADEElement()) {
			T object = apply(featureProperty.getGenericADEElement());
			if (object != null)
				return object;
		}

		return null;
	}

	public T apply(FeatureArrayProperty featureArrayProperty) {
		if (featureArrayProperty.isSetFeature()) {
			for (AbstractFeature feature : new ArrayList<AbstractFeature>(featureArrayProperty.getFeature())) {
				if (shouldWalk) {
					T object = feature.accept(this);
					if (object != null)
						return object;
				}					
			}
		}

		if (featureArrayProperty.isSetGenericADEElement()) {
			for (ADEComponent ade : new ArrayList<ADEComponent>(featureArrayProperty.getGenericADEElement())) {
				T object = apply(ade);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	public T apply(Element element, ElementDecl decl) {
		return null;
	}

	public T apply(ADEComponent adeComponent) {
		switch (adeComponent.getADEClass()) {
		case GENERIC_ELEMENT:
			return apply((ADEGenericElement)adeComponent);
		case MODEL_OBJECT:
			return apply((ADEModelObject)adeComponent);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public T apply(ADEModelObject adeModelObject) {
		if (adeWalkerHelper != null) {
			Object returnValue = adeWalkerHelper.invokeWalkerMethod(adeModelObject, "apply");
			if (returnValue != null)
				return (T)returnValue;
		}

		return null;
	}

	public T apply(ADEGenericElement adeGenericElement) {
		if (adeGenericElement.isSetContent() && shouldWalk && schemaHandler != null) {
			T object = adeGenericElement(adeGenericElement.getContent(), null);
			if (object != null)
				return object;
		}

		return null;
	}

	private T adeGenericElement(Element element, ElementDecl decl) {
		Schema schema = schemaHandler.getSchema(element.getNamespaceURI());
		T object = null;

		if (schema != null) {
			decl = schema.getElementDecl(element.getLocalName(), decl);
			if (decl != null && decl.isAbstractGML()) {
				object = apply(element, decl);
				if (object != null)
					return object;
			} else {
				object = iterateNodeList(element, decl);
				if (object != null)
					return object;
			}
		}

		return null;
	}

	private T iterateNodeList(Element element, ElementDecl decl) {
		NodeList nodeList = element.getChildNodes();

		List<Element> children = new ArrayList<Element>(nodeList.getLength());
		for (int i = 0; i < nodeList.getLength(); ++i) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
				children.add((Element)node);
		}	

		for (Element child : children) {
			if (shouldWalk) {
				T object = adeGenericElement((Element)child, decl);
				if (object != null)
					return object;
			}
		}

		return null;
	}

}
