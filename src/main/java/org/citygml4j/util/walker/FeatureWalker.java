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
import org.citygml4j.model.citygml.building.CeilingSurface;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.InteriorWallSurface;
import org.citygml4j.model.citygml.building.OuterCeilingSurface;
import org.citygml4j.model.citygml.building.OuterFloorSurface;
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
import org.citygml4j.model.common.visitor.FeatureVisitor;
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

public abstract class FeatureWalker extends Walker implements FeatureVisitor {
	protected SchemaHandler schemaHandler;
	protected ADEWalkerHelper<FeatureWalker> adeWalkerHelper;

	public FeatureWalker() {
		CityGMLContext context = CityGMLContext.getInstance();
		if (context.hasADEContexts()) {
			for (ADEContext adeContext : CityGMLContext.getInstance().getADEContexts())
				useADEWalker(adeContext.createDefaultFeatureWalker());
		}
	}

	public final FeatureWalker setSchemaHandler(SchemaHandler schemaHandler) {
		this.schemaHandler = schemaHandler;
		return this;
	}

	public final SchemaHandler getSchemaHandler() {
		return schemaHandler;
	}
	
	public final FeatureWalker useADEWalker(ADEWalker<FeatureWalker> walker) {
		if (walker != null) {
			if (adeWalkerHelper == null)
				adeWalkerHelper = new ADEWalkerHelper<>();

			walker.setParentWalker(this);
			adeWalkerHelper.addADEWalker(walker);
		}

		return this;
	}
	
	@SafeVarargs
	public final FeatureWalker useADEWalkers(ADEWalker<FeatureWalker>... walkers) {
		for (ADEWalker<FeatureWalker> walker : walkers)
			useADEWalker(walker);

		return this;
	}

	public void visit(org.citygml4j.model.citygml.bridge.AbstractBoundarySurface abstractBoundarySurface) {
		visit((AbstractCityObject)abstractBoundarySurface);

		if (abstractBoundarySurface.isSetOpening())
			for (org.citygml4j.model.citygml.bridge.OpeningProperty openingProperty : new ArrayList<org.citygml4j.model.citygml.bridge.OpeningProperty>(abstractBoundarySurface.getOpening()))
				visit(openingProperty);

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.AbstractBoundarySurface abstractBoundarySurface) {
		visit((AbstractCityObject)abstractBoundarySurface);

		if (abstractBoundarySurface.isSetOpening())
			for (org.citygml4j.model.citygml.building.OpeningProperty openingProperty : new ArrayList<org.citygml4j.model.citygml.building.OpeningProperty>(abstractBoundarySurface.getOpening()))
				visit(openingProperty);

		if (abstractBoundarySurface.isSetGenericApplicationPropertyOfBoundarySurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractBoundarySurface.getGenericApplicationPropertyOfBoundarySurface()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.AbstractBoundarySurface abstractBoundarySurface) {
		visit((AbstractCityObject)abstractBoundarySurface);

		if (abstractBoundarySurface.isSetOpening())
			for (org.citygml4j.model.citygml.tunnel.OpeningProperty openingProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.OpeningProperty>(abstractBoundarySurface.getOpening()))
				visit(openingProperty);

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
	}

	public void visit(AbstractDiscreteCoverage abstractDiscreteCoverage) {
		visit((AbstractCoverage)abstractDiscreteCoverage);
	}

	public void visit(AbstractFeature abstractFeature) {
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

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.building.AbstractOpening abstractOpening) {
		visit((AbstractCityObject)abstractOpening);

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening()))
				visit(ade);
	}

	public void visit(org.citygml4j.model.citygml.tunnel.AbstractOpening abstractOpening) {
		visit((AbstractCityObject)abstractOpening);

		if (abstractOpening.isSetGenericApplicationPropertyOfOpening())
			for (ADEComponent ade : new ArrayList<ADEComponent>(abstractOpening.getGenericApplicationPropertyOfOpening()))
				visit(ade);
	}

	public void visit(AbstractReliefComponent abstractReliefComponent) {
		visit((AbstractCityObject)abstractReliefComponent);

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

		if (georeferencedTexture.isSetGenericApplicationPropertyOfGeoreferencedTexture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(georeferencedTexture.getGenericApplicationPropertyOfGeoreferencedTexture()))
				visit(ade);
	}

	public void visit(ParameterizedTexture parameterizedTexture) {
		visit((AbstractTexture)parameterizedTexture);

		if (parameterizedTexture.isSetTarget()) {
			for (TextureAssociation textureAssociation : new ArrayList<TextureAssociation>(parameterizedTexture.getTarget())) {
				if (textureAssociation.isSetTextureParameterization() && shouldWalk) {
					AbstractTextureParameterization textureParameterization = textureAssociation.getTextureParameterization();

					if (textureParameterization instanceof TexCoordGen) {
						TexCoordGen texCoordGen = (TexCoordGen)textureParameterization;
						if (texCoordGen.isSetGenericApplicationPropertyOfTexCoordGen()) 
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordGen.getGenericApplicationPropertyOfTexCoordGen()))
								visit(ade);
					} 

					else if (textureParameterization instanceof TexCoordList) {
						TexCoordList texCoordList = (TexCoordList)textureParameterization;
						if (texCoordList.isSetGenericApplicationPropertyOfTexCoordList()) 
							for (ADEComponent ade : new ArrayList<ADEComponent>(texCoordList.getGenericApplicationPropertyOfTexCoordList()))
								visit(ade);
					}

					if (textureParameterization.isSetGenericADEComponent())
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericADEElement()))
							visit(ade);

					if (textureParameterization.isSetGenericApplicationPropertyOfTextureParameterization()) 
						for (ADEComponent ade : new ArrayList<ADEComponent>(textureParameterization.getGenericApplicationPropertyOfTextureParameterization()))
							visit(ade);
				}
			}
		}

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

		if (bridgeConstructionElement.isSetGenericApplicationPropertyOfBridgeConstructionElement())
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeConstructionElement.getGenericApplicationPropertyOfBridgeConstructionElement()))
				visit(ade);
	}

	public void visit(BridgeFurniture bridgeFurniture) {
		visit((AbstractCityObject)bridgeFurniture);

		if (bridgeFurniture.isSetGenericApplicationPropertyOfBridgeFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeFurniture.getGenericApplicationPropertyOfBridgeFurniture()))
				visit(ade);
	}

	public void visit(BridgeInstallation bridgeInstallation) {
		visit((AbstractCityObject)bridgeInstallation);

		if (bridgeInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(bridgeInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

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

		if (bridgeRoom.isSetGenericApplicationPropertyOfBridgeRoom())
			for (ADEComponent ade : new ArrayList<ADEComponent>(bridgeRoom.getGenericApplicationPropertyOfBridgeRoom()))
				visit(ade);
	}

	public void visit(IntBridgeInstallation intBridgeInstallation) {
		visit((AbstractCityObject)intBridgeInstallation);

		if (intBridgeInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.bridge.BoundarySurfaceProperty>(intBridgeInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

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

		if (buildingFurniture.isSetGenericApplicationPropertyOfBuildingFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(buildingFurniture.getGenericApplicationPropertyOfBuildingFurniture()))
				visit(ade);
	}

	public void visit(BuildingInstallation buildingInstallation) {
		visit((AbstractCityObject)buildingInstallation);

		if (buildingInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.building.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.building.BoundarySurfaceProperty>(buildingInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

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

		if (room.isSetGenericApplicationPropertyOfRoom())
			for (ADEComponent ade : new ArrayList<ADEComponent>(room.getGenericApplicationPropertyOfRoom()))
				visit(ade);
	}

	public void visit(CeilingSurface ceilingSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)ceilingSurface);

		if (ceilingSurface.isSetGenericApplicationPropertyOfCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(ceilingSurface.getGenericApplicationPropertyOfCeilingSurface()))
				visit(ade);
	}

	public void visit(OuterCeilingSurface outerCeilingSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)outerCeilingSurface);

		if (outerCeilingSurface.isSetGenericApplicationPropertyOfOuterCeilingSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerCeilingSurface.getGenericApplicationPropertyOfOuterCeilingSurface()))
				visit(ade);
	}

	public void visit(ClosureSurface closureSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)closureSurface);

		if (closureSurface.isSetGenericApplicationPropertyOfClosureSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(closureSurface.getGenericApplicationPropertyOfClosureSurface()))
				visit(ade);
	}

	public void visit(FloorSurface floorSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)floorSurface);

		if (floorSurface.isSetGenericApplicationPropertyOfFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(floorSurface.getGenericApplicationPropertyOfFloorSurface()))
				visit(ade);
	}

	public void visit(OuterFloorSurface outerFloorSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)outerFloorSurface);

		if (outerFloorSurface.isSetGenericApplicationPropertyOfOuterFloorSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(outerFloorSurface.getGenericApplicationPropertyOfOuterFloorSurface()))
				visit(ade);
	}

	public void visit(GroundSurface groundSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)groundSurface);

		if (groundSurface.isSetGenericApplicationPropertyOfGroundSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(groundSurface.getGenericApplicationPropertyOfGroundSurface()))
				visit(ade);
	}

	public void visit(InteriorWallSurface interiorWallSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)interiorWallSurface);

		if (interiorWallSurface.isSetGenericApplicationPropertyOfInteriorWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(interiorWallSurface.getGenericApplicationPropertyOfInteriorWallSurface()))
				visit(ade);
	}

	public void visit(RoofSurface roofSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)roofSurface);

		if (roofSurface.isSetGenericApplicationPropertyOfRoofSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(roofSurface.getGenericApplicationPropertyOfRoofSurface()))
				visit(ade);
	}

	public void visit(WallSurface wallSurface) {
		visit((org.citygml4j.model.citygml.building.AbstractBoundarySurface)wallSurface);

		if (wallSurface.isSetGenericApplicationPropertyOfWallSurface())
			for (ADEComponent ade : new ArrayList<ADEComponent>(wallSurface.getGenericApplicationPropertyOfWallSurface()))
				visit(ade);
	}

	public void visit(Door door) {
		visit((org.citygml4j.model.citygml.building.AbstractOpening)door);

		if (door.isSetAddress())
			for (AddressProperty addressProperty : new ArrayList<AddressProperty>(door.getAddress()))
				visit(addressProperty);

		if (door.isSetGenericApplicationPropertyOfDoor())
			for (ADEComponent ade : new ArrayList<ADEComponent>(door.getGenericApplicationPropertyOfDoor()))
				visit(ade);
	}

	public void visit(Window window) {
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

		if (hollowSpace.isSetGenericApplicationPropertyOfHollowSpace())
			for (ADEComponent ade : new ArrayList<ADEComponent>(hollowSpace.getGenericApplicationPropertyOfHollowSpace()))
				visit(ade);
	}

	public void visit(IntTunnelInstallation intTunnelInstallation) {
		visit((AbstractCityObject)intTunnelInstallation);

		if (intTunnelInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(intTunnelInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

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

		if (tunnelFurniture.isSetGenericApplicationPropertyOfTunnelFurniture())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tunnelFurniture.getGenericApplicationPropertyOfTunnelFurniture()))
				visit(ade);
	}

	public void visit(TunnelInstallation tunnelInstallation) {
		visit((AbstractCityObject)tunnelInstallation);

		if (tunnelInstallation.isSetBoundedBySurface())
			for (org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty boundarySurfaceProperty : new ArrayList<org.citygml4j.model.citygml.tunnel.BoundarySurfaceProperty>(tunnelInstallation.getBoundedBySurface()))
				visit(boundarySurfaceProperty);

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

		if (cityObjectGroup.isSetGenericApplicationPropertyOfCityObjectGroup())
			for (ADEComponent ade : new ArrayList<ADEComponent>(cityObjectGroup.getGenericApplicationPropertyOfCityObjectGroup()))
				visit(ade);
	}

	public void visit(Address address) {
		visit((AbstractFeature)address);

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
	}

	public void visit(LandUse landUse) {
		visit((AbstractCityObject)landUse);

		if (landUse.isSetGenericApplicationPropertyOfLandUse())
			for (ADEComponent ade : new ArrayList<ADEComponent>(landUse.getGenericApplicationPropertyOfLandUse()))
				visit(ade);
	}

	public void visit(BreaklineRelief breaklineRelief) {
		visit((AbstractReliefComponent)breaklineRelief);

		if (breaklineRelief.isSetGenericApplicationPropertyOfBreaklineRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(breaklineRelief.getGenericApplicationPropertyOfBreaklineRelief()))
				visit(ade);
	}

	public void visit(MassPointRelief massPointRelief) {
		visit((AbstractReliefComponent)massPointRelief);

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

		if (tinRelief.isSetGenericApplicationPropertyOfTinRelief())
			for (ADEComponent ade : new ArrayList<ADEComponent>(tinRelief.getGenericApplicationPropertyOfTinRelief()))
				visit(ade);
	}

	public void visit(AuxiliaryTrafficArea auxiliaryTrafficArea) {
		visit((AbstractTransportationObject)auxiliaryTrafficArea);

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

		if (transportationComplex.isSetGenericApplicationPropertyOfTransportationComplex())
			for (ADEComponent ade : new ArrayList<ADEComponent>(transportationComplex.getGenericApplicationPropertyOfTransportationComplex()))
				visit(ade);
	}

	public void visit(PlantCover plantCover) {
		visit((AbstractVegetationObject)plantCover);

		if (plantCover.isSetGenericApplicationPropertyOfPlantCover())
			for (ADEComponent ade : new ArrayList<ADEComponent>(plantCover.getGenericApplicationPropertyOfPlantCover()))
				visit(ade);
	}

	public void visit(SolitaryVegetationObject solitaryVegetationObject) {
		visit((AbstractVegetationObject)solitaryVegetationObject);

		if (solitaryVegetationObject.isSetGenericApplicationPropertyOfSolitaryVegetationObject())
			for (ADEComponent ade : new ArrayList<ADEComponent>(solitaryVegetationObject.getGenericApplicationPropertyOfVegetationObject()))
				visit(ade);
	}

	public void visit(WaterBody waterBody) {
		visit((AbstractWaterObject)waterBody);

		if (waterBody.isSetBoundedBySurface())
			for (BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty : new ArrayList<BoundedByWaterSurfaceProperty>(waterBody.getBoundedBySurface()))
				visit(boundedByWaterSurfaceProperty);

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
			if (decl != null && decl.isFeature())
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

}
