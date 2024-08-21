/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.citygml.bridge;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.binding.ADEBoundingBoxHelper;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractSite;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.common.base.ModelObjects;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.module.Module;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.time.LocalDate;
import java.util.List;

public abstract class AbstractBridge extends AbstractSite implements BridgeModuleComponent, StandardObjectClassifier {
	private Code clazz;
	private List<Code> function;
	private List<Code> usage;
	private Boolean isMovable;
	private LocalDate yearOfConstruction;
	private LocalDate yearOfDemolition;
	private SolidProperty lod1Solid;
	private SolidProperty lod2Solid;
	private SolidProperty lod3Solid;
	private SolidProperty lod4Solid;
	private MultiCurveProperty lod1TerrainIntersection;
	private MultiCurveProperty lod2TerrainIntersection;
	private MultiCurveProperty lod3TerrainIntersection;
	private MultiCurveProperty lod4TerrainIntersection;
	private MultiCurveProperty lod2MultiCurve;
	private MultiCurveProperty lod3MultiCurve;
	private MultiCurveProperty lod4MultiCurve;
	private MultiSurfaceProperty lod1MultiSurface;
	private MultiSurfaceProperty lod2MultiSurface;
	private MultiSurfaceProperty lod3MultiSurface;
	private MultiSurfaceProperty lod4MultiSurface;
	private List<BridgeInstallationProperty> outerBridgeInstallation;
	private List<BridgeConstructionElementProperty> outerBridgeConstructionElement;
	private List<IntBridgeInstallationProperty> interiorBridgeInstallation;
	private List<BoundarySurfaceProperty> boundedBySurface;
	private List<BridgePartProperty> bridgePart;
	private List<InteriorBridgeRoomProperty> interiorBridgeRoom;
	private List<AddressProperty> address;
	private List<ADEComponent> ade;

	public AbstractBridge() {
		
	}
	
	public AbstractBridge(Module module) {
		super(module);
	}
	
	public void addAddress(AddressProperty address) {
		getAddress().add(address);
	}

	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		getBoundedBySurface().add(boundedBySurface);
	}

	public void addConsistsOfBridgePart(BridgePartProperty bridgePart) {
		getConsistsOfBridgePart().add(bridgePart);
	}

	public void addFunction(Code function) {
		getFunction().add(function);
	}
	
	public void addUsage(Code usage) {
		getUsage().add(usage);
	}

	public void addGenericApplicationPropertyOfAbstractBridge(ADEComponent ade) {
		getGenericApplicationPropertyOfAbstractBridge().add(ade);
	}

	public void addInteriorBridgeInstallation(IntBridgeInstallationProperty interiorBridgeInstallation) {
		getInteriorBridgeInstallation().add(interiorBridgeInstallation);
	}

	public void addInteriorBridgeRoom(InteriorBridgeRoomProperty interiorBridgeRoom) {
		getInteriorBridgeRoom().add(interiorBridgeRoom);
	}

	public void addOuterBridgeInstallation(BridgeInstallationProperty outerBridgeInstallation) {
		getOuterBridgeInstallation().add(outerBridgeInstallation);
	}
	
	public void addOuterBridgeConstructionElement(BridgeConstructionElementProperty outerBridgeConstructionElement) {
		getOuterBridgeConstructionElement().add(outerBridgeConstructionElement);
	}

	public List<AddressProperty> getAddress() {
		if (address == null)
			address = new ChildList<>(this);

		return address;
	}

	public List<BoundarySurfaceProperty> getBoundedBySurface() {
		if (boundedBySurface == null)
			boundedBySurface = new ChildList<>(this);

		return boundedBySurface;
	}

	public Code getClazz() {
		return clazz;
	}

	public List<Code> getFunction() {
		if (function == null)
			function = new ChildList<>(this);

		return function;
	}
	
	public List<Code> getUsage() {
		if (usage == null)
			usage = new ChildList<>(this);

		return usage;
	}
	
	public Boolean getIsMovable() {
		return isMovable;
	}

	public List<BridgePartProperty> getConsistsOfBridgePart() {
		if (bridgePart == null)
			bridgePart = new ChildList<>(this);

		return bridgePart;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAbstractBridge() {
		if (ade == null)
			ade = new ChildList<>(this);

		return ade;
	}

	public List<IntBridgeInstallationProperty> getInteriorBridgeInstallation() {
		if (interiorBridgeInstallation == null)
			interiorBridgeInstallation = new ChildList<>(this);

		return interiorBridgeInstallation;
	}

	public List<InteriorBridgeRoomProperty> getInteriorBridgeRoom() {
		if (interiorBridgeRoom == null)
			interiorBridgeRoom = new ChildList<>(this);

		return interiorBridgeRoom;
	}

	public MultiSurfaceProperty getLod1MultiSurface() {
		return lod1MultiSurface;
	}

	public SolidProperty getLod1Solid() {
		return lod1Solid;
	}

	public MultiCurveProperty getLod1TerrainIntersection() {
		return lod1TerrainIntersection;
	}

	public MultiCurveProperty getLod2MultiCurve() {
		return lod2MultiCurve;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		return lod2MultiSurface;
	}

	public SolidProperty getLod2Solid() {
		return lod2Solid;
	}

	public MultiCurveProperty getLod2TerrainIntersection() {
		return lod2TerrainIntersection;
	}

	public MultiCurveProperty getLod3MultiCurve() {
		return lod3MultiCurve;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		return lod3MultiSurface;
	}

	public SolidProperty getLod3Solid() {
		return lod3Solid;
	}

	public MultiCurveProperty getLod3TerrainIntersection() {
		return lod3TerrainIntersection;
	}

	public MultiCurveProperty getLod4MultiCurve() {
		return lod4MultiCurve;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}

	public SolidProperty getLod4Solid() {
		return lod4Solid;
	}

	public MultiCurveProperty getLod4TerrainIntersection() {
		return lod4TerrainIntersection;
	}

	public List<BridgeInstallationProperty> getOuterBridgeInstallation() {
		if (outerBridgeInstallation == null)
			outerBridgeInstallation = new ChildList<>(this);

		return outerBridgeInstallation;
	}
	
	public List<BridgeConstructionElementProperty> getOuterBridgeConstructionElement() {
		if (outerBridgeConstructionElement == null)
			outerBridgeConstructionElement = new ChildList<>(this);

		return outerBridgeConstructionElement;
	}

	public LocalDate getYearOfConstruction() {
		return yearOfConstruction;
	}

	public LocalDate getYearOfDemolition() {
		return yearOfDemolition;
	}

	public boolean isSetAddress() {
		return address != null && !address.isEmpty();
	}

	public boolean isSetBoundedBySurface() {
		return boundedBySurface != null && !boundedBySurface.isEmpty();
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetConsistsOfBridgePart() {
		return bridgePart != null && !bridgePart.isEmpty();
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}
	
	public boolean isSetIsMovable() {
		return isMovable != null;
	}

	public boolean isSetGenericApplicationPropertyOfAbstractBridge() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetInteriorBridgeInstallation() {
		return interiorBridgeInstallation != null && !interiorBridgeInstallation.isEmpty();
	}
	
	public boolean isSetInteriorBridgeRoom() {
		return interiorBridgeRoom != null && !interiorBridgeRoom.isEmpty();
	}

	public boolean isSetLod1MultiSurface() {
		return lod1MultiSurface != null;
	}

	public boolean isSetLod1Solid() {
		return lod1Solid != null;
	}

	public boolean isSetLod1TerrainIntersection() {
		return lod1TerrainIntersection != null;
	}

	public boolean isSetLod2MultiCurve() {
		return lod2MultiCurve != null;
	}

	public boolean isSetLod2MultiSurface() {
		return lod2MultiSurface != null;
	}

	public boolean isSetLod2Solid() {
		return lod2Solid != null;
	}

	public boolean isSetLod2TerrainIntersection() {
		return lod2TerrainIntersection != null;
	}

	public boolean isSetLod3MultiCurve() {
		return lod3MultiCurve != null;
	}

	public boolean isSetLod3MultiSurface() {
		return lod3MultiSurface != null;
	}

	public boolean isSetLod3Solid() {
		return lod3Solid != null;
	}

	public boolean isSetLod3TerrainIntersection() {
		return lod3TerrainIntersection != null;
	}

	public boolean isSetLod4MultiCurve() {
		return lod4MultiCurve != null;
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}

	public boolean isSetLod4Solid() {
		return lod4Solid != null;
	}

	public boolean isSetLod4TerrainIntersection() {
		return lod4TerrainIntersection != null;
	}

	public boolean isSetOuterBridgeInstallation() {
		return outerBridgeInstallation != null && !outerBridgeInstallation.isEmpty();
	}
	
	public boolean isSetOuterBridgeConstructionElement() {
		return outerBridgeConstructionElement != null && !outerBridgeConstructionElement.isEmpty();
	}

	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public boolean isSetYearOfConstruction() {
		return yearOfConstruction != null;
	}

	public boolean isSetYearOfDemolition() {
		return yearOfDemolition != null;
	}

	public void setAddress(List<AddressProperty> address) {
		this.address = new ChildList<>(this, address);
	}

	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface) {
		this.boundedBySurface = new ChildList<>(this, boundedBySurface);
	}

	public void setClazz(Code clazz) {
		this.clazz = ModelObjects.setParent(clazz, this);
	}

	public void setFunction(List<Code> function) {
		this.function = new ChildList<>(this, function);
	}
	
	public void setUsage(List<Code> usage) {
		this.usage = new ChildList<>(this, usage);
	}
	
	public void setIsMovable(Boolean isMovable) {
		this.isMovable = isMovable;
	}

	public void setConsistsOfBridgePart(List<BridgePartProperty> bridgePart) {
		this.bridgePart = new ChildList<>(this, bridgePart);
	}

	public void setGenericApplicationPropertyOfAbstractBridge(List<ADEComponent> ade) {
		this.ade = new ChildList<>(this, ade);
	}

	public void setInteriorBridgeInstallation(List<IntBridgeInstallationProperty> interiorBridgeInstallation) {
		this.interiorBridgeInstallation = new ChildList<>(this, interiorBridgeInstallation);
	}

	public void setInteriorBridgeRoom(List<InteriorBridgeRoomProperty> interiorBridgeRoom) {
		this.interiorBridgeRoom = new ChildList<>(this, interiorBridgeRoom);
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		this.lod1MultiSurface = ModelObjects.setParent(lod1MultiSurface, this);
	}

	public void setLod1Solid(SolidProperty lod1Solid) {
		this.lod1Solid = ModelObjects.setParent(lod1Solid, this);
	}

	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection) {
		this.lod1TerrainIntersection = ModelObjects.setParent(lod1TerrainIntersection, this);
	}

	public void setLod2MultiCurve(MultiCurveProperty lod2MultiCurve) {
		this.lod2MultiCurve = ModelObjects.setParent(lod2MultiCurve, this);
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		this.lod2MultiSurface = ModelObjects.setParent(lod2MultiSurface, this);
	}

	public void setLod2Solid(SolidProperty lod2Solid) {
		this.lod2Solid = ModelObjects.setParent(lod2Solid, this);
	}

	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection) {
		this.lod2TerrainIntersection = ModelObjects.setParent(lod2TerrainIntersection, this);
	}

	public void setLod3MultiCurve(MultiCurveProperty lod3MultiCurve) {
		this.lod3MultiCurve = ModelObjects.setParent(lod3MultiCurve, this);
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		this.lod3MultiSurface = ModelObjects.setParent(lod3MultiSurface, this);
	}

	public void setLod3Solid(SolidProperty lod3Solid) {
		this.lod3Solid = ModelObjects.setParent(lod3Solid, this);
	}

	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection) {
		this.lod3TerrainIntersection = ModelObjects.setParent(lod3TerrainIntersection, this);
	}

	public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve) {
		this.lod4MultiCurve = ModelObjects.setParent(lod4MultiCurve, this);
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		this.lod4MultiSurface = ModelObjects.setParent(lod4MultiSurface, this);
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		this.lod4Solid = ModelObjects.setParent(lod4Solid, this);
	}

	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection) {
		this.lod4TerrainIntersection = ModelObjects.setParent(lod4TerrainIntersection, this);
	}

	public void setOuterBridgeInstallation(List<BridgeInstallationProperty> outerBridgeInstallation) {
		this.outerBridgeInstallation = new ChildList<>(this, outerBridgeInstallation);
	}
	
	public void setOuterBridgeConstructionElement(List<BridgeConstructionElementProperty> outerBridgeConstructionElement) {
		this.outerBridgeConstructionElement = new ChildList<>(this, outerBridgeConstructionElement);
	}

	public void setYearOfConstruction(LocalDate yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}
	
	public void setYearOfConstruction(int yearOfConstruction) {
		this.yearOfConstruction = LocalDate.of(yearOfConstruction, 1, 1);
	}

	public void setYearOfDemolition(LocalDate yearOfDemolition) {
		this.yearOfDemolition = yearOfDemolition;
	}
	
	public void setYearOfDemolition(int yearOfDemolition) {
		this.yearOfDemolition = LocalDate.of(yearOfDemolition, 1, 1);
	}

	public void unsetAddress() {
		address = ModelObjects.setNull(address);
	}

	public boolean unsetAddress(AddressProperty address) {
		return isSetAddress() && this.address.remove(address);
	}

	public void unsetBoundedBySurface() {
		boundedBySurface = ModelObjects.setNull(boundedBySurface);
	}

	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		return isSetBoundedBySurface() && this.boundedBySurface.remove(boundedBySurface);
	}

	public void unsetClazz() {
		clazz = ModelObjects.setNull(clazz);
	}

	public void unsetConsistsOfBridgePart() {
		bridgePart = ModelObjects.setNull(bridgePart);
	}

	public boolean unsetConsistsOfBridgePart(BridgePartProperty bridgePart) {
		return isSetConsistsOfBridgePart() && this.bridgePart.remove(bridgePart);
	}

	public void unsetFunction() {
		function = ModelObjects.setNull(function);
	}

	public boolean unsetFunction(Code function) {
		return isSetFunction() && this.function.remove(function);
	}
	
	public void unsetUsage() {
		usage = ModelObjects.setNull(usage);
	}

	public boolean unsetUsage(Code usage) {
		return isSetUsage() && this.usage.remove(usage);
	}
	
	public void unsetIsMovable() {
		isMovable = null;
	}

	public void unsetGenericApplicationPropertyOfAbstractBridge() {
		ade = ModelObjects.setNull(ade);
	}

	public boolean unsetGenericApplicationPropertyOfAbstractBridge(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfAbstractBridge() && this.ade.remove(ade);	}

	public void unsetInteriorBridgeInstallation() {
		interiorBridgeInstallation = ModelObjects.setNull(interiorBridgeInstallation);
	}

	public boolean unsetInteriorBridgeInstallation(IntBridgeInstallationProperty interiorBridgeInstallation) {
		return isSetInteriorBridgeInstallation() && this.interiorBridgeInstallation.remove(interiorBridgeInstallation);
	}

	public void unsetInteriorBridgeRoom() {
		interiorBridgeRoom = ModelObjects.setNull(interiorBridgeRoom);
	}

	public boolean unsetInteriorBridgeRoom(InteriorBridgeRoomProperty interiorBridgeRoom) {
		return isSetInteriorBridgeRoom() && this.interiorBridgeRoom.remove(interiorBridgeRoom);
	}

	public void unsetLod1MultiSurface() {
		lod1MultiSurface = ModelObjects.setNull(lod1MultiSurface);
	}

	public void unsetLod1Solid() {
		lod1Solid = ModelObjects.setNull(lod1Solid);
	}

	public void unsetLod1TerrainIntersection() {
		lod1TerrainIntersection = ModelObjects.setNull(lod1TerrainIntersection);
	}

	public void unsetLod2MultiCurve() {
		lod2MultiCurve = ModelObjects.setNull(lod2MultiCurve);
	}

	public void unsetLod2MultiSurface() {
		lod2MultiSurface = ModelObjects.setNull(lod2MultiSurface);
	}

	public void unsetLod2Solid() {
		lod2Solid = ModelObjects.setNull(lod2Solid);
	}

	public void unsetLod2TerrainIntersection() {
		lod2TerrainIntersection = ModelObjects.setNull(lod2TerrainIntersection);
	}

	public void unsetLod3MultiCurve() {
		lod3MultiCurve = ModelObjects.setNull(lod3MultiCurve);
	}

	public void unsetLod3MultiSurface() {
		lod3MultiSurface = ModelObjects.setNull(lod3MultiSurface);
	}

	public void unsetLod3Solid() {
		lod3Solid = ModelObjects.setNull(lod3Solid);
	}

	public void unsetLod3TerrainIntersection() {
		lod3TerrainIntersection = ModelObjects.setNull(lod3TerrainIntersection);
	}

	public void unsetLod4MultiCurve() {
		lod4MultiCurve = ModelObjects.setNull(lod4MultiCurve);
	}

	public void unsetLod4MultiSurface() {
		lod4MultiSurface = ModelObjects.setNull(lod4MultiSurface);
	}

	public void unsetLod4Solid() {
		lod4Solid = ModelObjects.setNull(lod4Solid);
	}

	public void unsetLod4TerrainIntersection() {
		lod4TerrainIntersection = ModelObjects.setNull(lod4TerrainIntersection);
	}

	public void unsetOuterBridgeInstallation() {
		outerBridgeInstallation = ModelObjects.setNull(outerBridgeInstallation);
	}
	
	public boolean unsetOuterBridgeInstallation(BridgeInstallationProperty outerBridgeInstallation) {
		return isSetOuterBridgeInstallation() && this.outerBridgeInstallation.remove(outerBridgeInstallation);
	}

	public void unsetOuterBridgeConstructionElement() {
		outerBridgeConstructionElement = ModelObjects.setNull(outerBridgeConstructionElement);
	}
	
	public boolean unsetOuterBridgeConstructionElement(BridgeConstructionElementProperty outerBridgeConstructionElement) {
		return isSetOuterBridgeConstructionElement() && this.outerBridgeConstructionElement.remove(outerBridgeConstructionElement);
	}

	public void unsetYearOfConstruction() {
		yearOfConstruction = null;
	}

	public void unsetYearOfDemolition() {
		yearOfDemolition = null;
	}

	@Override
	public BoundingShape calcBoundedBy(BoundingBoxOptions options) {
		BoundingShape boundedBy = super.calcBoundedBy(options);
		if (options.isUseExistingEnvelopes() && !boundedBy.isEmpty())
			return boundedBy;
		
		SolidProperty solidProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				solidProperty = lod1Solid;
				break;
			case 2:
				solidProperty = lod2Solid;
				break;
			case 3:
				solidProperty = lod3Solid;
				break;
			case 4:
				solidProperty = lod4Solid;
				break;
			}
			
			if (solidProperty != null) {
				if (solidProperty.isSetSolid()) {
					boundedBy.updateEnvelope(solidProperty.getSolid().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}
		
		MultiSurfaceProperty multiSurfaceProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				multiSurfaceProperty = lod1MultiSurface;
				break;
			case 2:
				multiSurfaceProperty = lod2MultiSurface;
				break;
			case 3:
				multiSurfaceProperty = lod3MultiSurface;
				break;
			case 4:
				multiSurfaceProperty = lod4MultiSurface;
				break;
			}
			
			if (multiSurfaceProperty != null) {
				if (multiSurfaceProperty.isSetMultiSurface()) {
					boundedBy.updateEnvelope(multiSurfaceProperty.getMultiSurface().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}
		
		MultiCurveProperty multiCurveProperty = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				multiCurveProperty = lod2MultiCurve;
				break;
			case 3:
				multiCurveProperty = lod3MultiCurve;
				break;
			case 4:
				multiCurveProperty = lod4MultiCurve;
				break;
			}
			
			if (multiCurveProperty != null) {
				if (multiCurveProperty.isSetMultiCurve()) {
					boundedBy.updateEnvelope(multiCurveProperty.getMultiCurve().calcBoundingBox());
				} else {
					// xlink
				}
			}
		}
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : getBoundedBySurface()) {
				if (boundarySurfaceProperty.isSetObject()) {
					boundedBy.updateEnvelope(boundarySurfaceProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink?
				}
			}
		}
		
		if (isSetOuterBridgeInstallation()) {
			for (BridgeInstallationProperty bridgeInstallationProperty : getOuterBridgeInstallation()) {
				if (bridgeInstallationProperty.isSetObject()) {
					boundedBy.updateEnvelope(bridgeInstallationProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink?
				}
			}
		}
		
		if (isSetOuterBridgeConstructionElement()) {
			for (BridgeConstructionElementProperty bridgeConstructionElementProperty : getOuterBridgeConstructionElement()) {
				if (bridgeConstructionElementProperty.isSetObject()) {
					boundedBy.updateEnvelope(bridgeConstructionElementProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink?
				}
			}
		}

		if (isSetConsistsOfBridgePart()) {
			for (BridgePartProperty bridgePartProperty : getConsistsOfBridgePart()) {
				if (bridgePartProperty.isSetObject()) {
					boundedBy.updateEnvelope(bridgePartProperty.getObject().calcBoundedBy(options).getEnvelope());
				} else {
					// xlink?
				}
			}
		}
		
		if (isSetGenericApplicationPropertyOfAbstractBridge()) {
			for (ADEComponent ade : getGenericApplicationPropertyOfAbstractBridge()) {
				if (ade.getADEClass() == ADEClass.MODEL_OBJECT)
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}
	
	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();

		lodRepresentation.addRepresentation(1, lod1Solid);
		lodRepresentation.addRepresentation(2, lod2Solid);
		lodRepresentation.addRepresentation(3, lod3Solid);
		lodRepresentation.addRepresentation(4, lod4Solid);

		lodRepresentation.addRepresentation(1, lod1MultiSurface);
		lodRepresentation.addRepresentation(2, lod2MultiSurface);
		lodRepresentation.addRepresentation(3, lod3MultiSurface);
		lodRepresentation.addRepresentation(4, lod4MultiSurface);

		lodRepresentation.addRepresentation(2, lod2MultiCurve);
		lodRepresentation.addRepresentation(3, lod3MultiCurve);
		lodRepresentation.addRepresentation(4, lod4MultiCurve);
		
		return lodRepresentation;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractBridge copy = (AbstractBridge)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz((Code)copyBuilder.copy(clazz));

		if (isSetFunction()) {
			for (Code part : function) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addFunction(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetUsage()) {
			for (Code part : usage) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addUsage(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetYearOfConstruction())
			copy.setYearOfConstruction((LocalDate)copyBuilder.copy(yearOfConstruction));
		
		if (isSetYearOfDemolition())
			copy.setYearOfDemolition((LocalDate)copyBuilder.copy(yearOfDemolition));
		
		if (isSetIsMovable())
			copy.setIsMovable(copyBuilder.copy(isMovable));
		
		if (isSetLod1Solid()) {
			copy.setLod1Solid((SolidProperty)copyBuilder.copy(lod1Solid));
			if (copy.getLod1Solid() == lod1Solid)
				lod1Solid.setParent(this);
		}
		
		if (isSetLod2Solid()) {
			copy.setLod2Solid((SolidProperty)copyBuilder.copy(lod2Solid));
			if (copy.getLod2Solid() == lod2Solid)
				lod2Solid.setParent(this);
		}
		
		if (isSetLod3Solid()) {
			copy.setLod3Solid((SolidProperty)copyBuilder.copy(lod3Solid));
			if (copy.getLod3Solid() == lod3Solid)
				lod3Solid.setParent(this);
		}
		
		if (isSetLod4Solid()) {
			copy.setLod4Solid((SolidProperty)copyBuilder.copy(lod4Solid));
			if (copy.getLod4Solid() == lod4Solid)
				lod4Solid.setParent(this);
		}
		
		if (isSetLod1TerrainIntersection()) {
			copy.setLod1TerrainIntersection((MultiCurveProperty)copyBuilder.copy(lod1TerrainIntersection));
			if (copy.getLod1TerrainIntersection() == lod1TerrainIntersection)
				lod1TerrainIntersection.setParent(this);
		}
		
		if (isSetLod2TerrainIntersection()) {
			copy.setLod2TerrainIntersection((MultiCurveProperty)copyBuilder.copy(lod2TerrainIntersection));
			if (copy.getLod2TerrainIntersection() == lod2TerrainIntersection)
				lod2TerrainIntersection.setParent(this);
		}
		
		if (isSetLod3TerrainIntersection()) {
			copy.setLod3TerrainIntersection((MultiCurveProperty)copyBuilder.copy(lod3TerrainIntersection));
			if (copy.getLod3TerrainIntersection() == lod3TerrainIntersection)
				lod3TerrainIntersection.setParent(this);
		}
		
		if (isSetLod4TerrainIntersection()) {
			copy.setLod4TerrainIntersection((MultiCurveProperty)copyBuilder.copy(lod4TerrainIntersection));
			if (copy.getLod4TerrainIntersection() == lod4TerrainIntersection)
				lod4TerrainIntersection.setParent(this);
		}
		
		if (isSetLod2MultiCurve()) {
			copy.setLod2MultiCurve((MultiCurveProperty)copyBuilder.copy(lod2MultiCurve));
			if (copy.getLod2MultiCurve() == lod2MultiCurve)
				lod2MultiCurve.setParent(this);
		}
		
		if (isSetLod3MultiCurve()) {
			copy.setLod3MultiCurve((MultiCurveProperty)copyBuilder.copy(lod3MultiCurve));
			if (copy.getLod3MultiCurve() == lod3MultiCurve)
				lod3MultiCurve.setParent(this);
		}
		
		if (isSetLod4MultiCurve()) {
			copy.setLod4MultiCurve((MultiCurveProperty)copyBuilder.copy(lod4MultiCurve));
			if (copy.getLod4MultiCurve() == lod4MultiCurve)
				lod4MultiCurve.setParent(this);
		}
		
		if (isSetLod1MultiSurface()) {
			copy.setLod1MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod1MultiSurface));
			if (copy.getLod1MultiSurface() == lod1MultiSurface)
				lod1MultiSurface.setParent(this);
		}
		
		if (isSetLod2MultiSurface()) {
			copy.setLod2MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod2MultiSurface));
			if (copy.getLod2MultiSurface() == lod2MultiSurface)
				lod2MultiSurface.setParent(this);
		}
		
		if (isSetLod3MultiSurface()) {
			copy.setLod3MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod3MultiSurface));
			if (copy.getLod3MultiSurface() == lod3MultiSurface)
				lod3MultiSurface.setParent(this);
		}
		
		if (isSetLod4MultiSurface()) {
			copy.setLod4MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod4MultiSurface));
			if (copy.getLod4MultiSurface() == lod4MultiSurface)
				lod4MultiSurface.setParent(this);
		}

		if (isSetAddress()) {
			for (AddressProperty part : address) {
				AddressProperty copyPart = (AddressProperty)copyBuilder.copy(part);
				copy.addAddress(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty part : boundedBySurface) {
				BoundarySurfaceProperty copyPart = (BoundarySurfaceProperty)copyBuilder.copy(part);
				copy.addBoundedBySurface(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetOuterBridgeInstallation()) {
			for (BridgeInstallationProperty part : outerBridgeInstallation) {
				BridgeInstallationProperty copyPart = (BridgeInstallationProperty)copyBuilder.copy(part);
				copy.addOuterBridgeInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetOuterBridgeConstructionElement()) {
			for (BridgeConstructionElementProperty part : outerBridgeConstructionElement) {
				BridgeConstructionElementProperty copyPart = (BridgeConstructionElementProperty)copyBuilder.copy(part);
				copy.addOuterBridgeConstructionElement(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorBridgeInstallation()) {
			for (IntBridgeInstallationProperty part : interiorBridgeInstallation) {
				IntBridgeInstallationProperty copyPart = (IntBridgeInstallationProperty)copyBuilder.copy(part);
				copy.addInteriorBridgeInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetConsistsOfBridgePart()) {
			for (BridgePartProperty part : bridgePart) {
				BridgePartProperty copyPart = (BridgePartProperty)copyBuilder.copy(part);
				copy.addConsistsOfBridgePart(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorBridgeRoom()) {
			for (InteriorBridgeRoomProperty part : interiorBridgeRoom) {
				InteriorBridgeRoomProperty copyPart = (InteriorBridgeRoomProperty)copyBuilder.copy(part);
				copy.addInteriorBridgeRoom(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfAbstractBridge()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfAbstractBridge(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
				
		return copy;
	}

}
