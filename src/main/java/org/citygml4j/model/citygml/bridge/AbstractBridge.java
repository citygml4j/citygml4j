/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.module.citygml.BridgeModule;
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
	private BridgeModule module;	
	
	public AbstractBridge() {
		
	}
	
	public AbstractBridge(BridgeModule module) {
		this.module = module;
	}
	
	public void addAddress(AddressProperty address) {
		if (this.address == null)
			this.address = new ChildList<AddressProperty>(this);

		this.address.add(address);
	}

	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		if (this.boundedBySurface == null)
			this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		this.boundedBySurface.add(boundedBySurface);
	}

	public void addConsistsOfBridgePart(BridgePartProperty bridgePart) {
		if (this.bridgePart == null)
			this.bridgePart = new ChildList<BridgePartProperty>(this);

		this.bridgePart.add(bridgePart);
	}

	public void addFunction(Code function) {
		if (this.function == null)
			this.function = new ChildList<Code>(this);

		this.function.add(function);
	}
	
	public void addUsage(Code function) {
		if (this.usage == null)
			this.usage = new ChildList<Code>(this);

		this.usage.add(function);
	}

	public void addGenericApplicationPropertyOfAbstractBridge(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addInteriorBridgeInstallation(IntBridgeInstallationProperty interiorBridgeInstallation) {
		if (this.interiorBridgeInstallation == null)
			this.interiorBridgeInstallation = new ChildList<IntBridgeInstallationProperty>(this);

		this.interiorBridgeInstallation.add(interiorBridgeInstallation);
	}

	public void addInteriorBridgeRoom(InteriorBridgeRoomProperty interiorBridgeRoom) {
		if (this.interiorBridgeRoom == null)
			this.interiorBridgeRoom = new ChildList<InteriorBridgeRoomProperty>(this);

		this.interiorBridgeRoom.add(interiorBridgeRoom);
	}

	public void addOuterBridgeInstallation(BridgeInstallationProperty outerBridgeInstallation) {
		if (this.outerBridgeInstallation == null)
			this.outerBridgeInstallation = new ChildList<BridgeInstallationProperty>(this);

		this.outerBridgeInstallation.add(outerBridgeInstallation);
	}
	
	public void addOuterBridgeConstructionElement(BridgeConstructionElementProperty outerBridgeConstructionElement) {
		if (this.outerBridgeConstructionElement == null)
			this.outerBridgeConstructionElement = new ChildList<BridgeConstructionElementProperty>(this);

		this.outerBridgeConstructionElement.add(outerBridgeConstructionElement);
	}

	public List<AddressProperty> getAddress() {
		if (address == null)
			address = new ChildList<AddressProperty>(this);

		return address;
	}

	public List<BoundarySurfaceProperty> getBoundedBySurface() {
		if (boundedBySurface == null)
			boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		return boundedBySurface;
	}

	public Code getClazz() {
		return clazz;
	}

	public List<Code> getFunction() {
		if (function == null)
			function = new ChildList<Code>(this);

		return function;
	}
	
	public List<Code> getUsage() {
		if (usage == null)
			usage = new ChildList<Code>(this);

		return usage;
	}
	
	public Boolean getIsMovable() {
		return isMovable;
	}

	public List<BridgePartProperty> getConsistsOfBridgePart() {
		if (bridgePart == null)
			bridgePart = new ChildList<BridgePartProperty>(this);

		return bridgePart;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAbstractBridge() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<IntBridgeInstallationProperty> getInteriorBridgeInstallation() {
		if (interiorBridgeInstallation == null)
			interiorBridgeInstallation = new ChildList<IntBridgeInstallationProperty>(this);

		return interiorBridgeInstallation;
	}

	public List<InteriorBridgeRoomProperty> getInteriorBridgeRoom() {
		if (interiorBridgeRoom == null)
			interiorBridgeRoom = new ChildList<InteriorBridgeRoomProperty>(this);

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
			outerBridgeInstallation = new ChildList<BridgeInstallationProperty>(this);

		return outerBridgeInstallation;
	}
	
	public List<BridgeConstructionElementProperty> getOuterBridgeConstructionElement() {
		if (outerBridgeConstructionElement == null)
			outerBridgeConstructionElement = new ChildList<BridgeConstructionElementProperty>(this);

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
		this.address = new ChildList<AddressProperty>(this, address);
	}

	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface) {
		this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this, boundedBySurface);
	}

	public void setClazz(Code clazz) {
		this.clazz = clazz;
	}

	public void setFunction(List<Code> function) {
		this.function = new ChildList<Code>(this, function);
	}
	
	public void setUsage(List<Code> usage) {
		this.usage = new ChildList<Code>(this, usage);
	}
	
	public void setIsMovable(Boolean isMovable) {
		this.isMovable = isMovable;
	}

	public void setConsistsOfBridgePart(List<BridgePartProperty> bridgePart) {
		this.bridgePart = new ChildList<BridgePartProperty>(this, bridgePart);
	}

	public void setGenericApplicationPropertyOfAbstractBridge(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setInteriorBridgeInstallation(List<IntBridgeInstallationProperty> interiorBridgeInstallation) {
		this.interiorBridgeInstallation = new ChildList<IntBridgeInstallationProperty>(this, interiorBridgeInstallation);
	}

	public void setInteriorBridgeRoom(List<InteriorBridgeRoomProperty> interiorBridgeRoom) {
		this.interiorBridgeRoom = new ChildList<InteriorBridgeRoomProperty>(this, interiorBridgeRoom);
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		if (lod1MultiSurface != null)
			lod1MultiSurface.setParent(this);
		
		this.lod1MultiSurface = lod1MultiSurface;
	}

	public void setLod1Solid(SolidProperty lod1Solid) {
		if (lod1Solid != null)
			lod1Solid.setParent(this);
		
		this.lod1Solid = lod1Solid;
	}

	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection) {
		if (lod1TerrainIntersection != null)
			lod1TerrainIntersection.setParent(this);
		
		this.lod1TerrainIntersection = lod1TerrainIntersection;
	}

	public void setLod2MultiCurve(MultiCurveProperty lod2MultiCurve) {
		if (lod2MultiCurve != null)
			lod2MultiCurve.setParent(this);
		
		this.lod2MultiCurve = lod2MultiCurve;
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		if (lod2MultiSurface != null)
			lod2MultiSurface.setParent(this);
		
		this.lod2MultiSurface = lod2MultiSurface;
	}

	public void setLod2Solid(SolidProperty lod2Solid) {
		if (lod2Solid != null)
			lod2Solid.setParent(this);
		
		this.lod2Solid = lod2Solid;
	}

	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection) {
		if (lod2TerrainIntersection != null)
			lod2TerrainIntersection.setParent(this);
		
		this.lod2TerrainIntersection = lod2TerrainIntersection;
	}

	public void setLod3MultiCurve(MultiCurveProperty lod3MultiCurve) {
		if (lod3MultiCurve != null)
			lod3MultiCurve.setParent(this);
		
		this.lod3MultiCurve = lod3MultiCurve;
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		if (lod3MultiSurface != null)
			lod3MultiSurface.setParent(this);
		
		this.lod3MultiSurface = lod3MultiSurface;
	}

	public void setLod3Solid(SolidProperty lod3Solid) {
		if (lod3Solid != null)
			lod3Solid.setParent(this);
		
		this.lod3Solid = lod3Solid;
	}

	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection) {
		if (lod3TerrainIntersection != null)
			lod3TerrainIntersection.setParent(this);
		
		this.lod3TerrainIntersection = lod3TerrainIntersection;
	}

	public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve) {
		if (lod4MultiCurve != null)
			lod4MultiCurve.setParent(this);
		
		this.lod4MultiCurve = lod4MultiCurve;
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		if (lod4MultiSurface != null)
			lod4MultiSurface.setParent(this);
		
		this.lod4MultiSurface = lod4MultiSurface;
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		if (lod4Solid != null)
			lod4Solid.setParent(this);
		
		this.lod4Solid = lod4Solid;
	}

	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection) {
		if (lod4TerrainIntersection != null)
			lod4TerrainIntersection.setParent(this);
		
		this.lod4TerrainIntersection = lod4TerrainIntersection;
	}

	public void setOuterBridgeInstallation(List<BridgeInstallationProperty> outerBridgeInstallation) {
		this.outerBridgeInstallation = new ChildList<BridgeInstallationProperty>(this, outerBridgeInstallation);
	}
	
	public void setOuterBridgeConstructionElement(List<BridgeConstructionElementProperty> outerBridgeConstructionElement) {
		this.outerBridgeConstructionElement = new ChildList<BridgeConstructionElementProperty>(this, outerBridgeConstructionElement);
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
		if (isSetAddress())
			address.clear();

		address = null;
	}

	public boolean unsetAddress(AddressProperty address) {
		return isSetAddress() ? this.address.remove(address) : false;
	}

	public void unsetBoundedBySurface() {
		if (isSetBoundedBySurface())
			boundedBySurface.clear();

		boundedBySurface = null;
	}

	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		return isSetBoundedBySurface() ? this.boundedBySurface.remove(boundedBySurface) : false;
	}

	public void unsetClazz() {
		clazz = null;
	}

	public void unsetConsistsOfBridgePart() {
		if (isSetConsistsOfBridgePart())
			bridgePart.clear();

		bridgePart = null;
	}

	public boolean unsetConsistsOfBridgePart(BridgePartProperty bridgePart) {
		return isSetConsistsOfBridgePart() ? this.bridgePart.remove(bridgePart) : false;
	}

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(Code function) {
		return isSetFunction() ? this.function.remove(function) : false;
	}
	
	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(Code usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}
	
	public void unsetIsMovable() {
		isMovable = null;
	}

	public void unsetGenericApplicationPropertyOfAbstractBridge() {
		if (isSetGenericApplicationPropertyOfAbstractBridge())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfAbstractBridge(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfAbstractBridge() ? this.ade.remove(ade) : false;	}

	public void unsetInteriorBridgeInstallation() {
		if (isSetInteriorBridgeInstallation())
			interiorBridgeInstallation.clear();

		interiorBridgeInstallation = null;
	}

	public boolean unsetInteriorBridgeInstallation(IntBridgeInstallationProperty interiorBridgeInstallation) {
		return isSetInteriorBridgeInstallation() ? this.interiorBridgeInstallation.remove(interiorBridgeInstallation) : false;
	}

	public void unsetInteriorBridgeRoom() {
		if (isSetInteriorBridgeRoom())
			interiorBridgeRoom.clear();

		interiorBridgeRoom = null;
	}

	public boolean unsetInteriorBridgeRoom(InteriorBridgeRoomProperty interiorBridgeRoom) {
		return isSetInteriorBridgeRoom() ? this.interiorBridgeRoom.remove(interiorBridgeRoom) : false;
	}

	public void unsetLod1MultiSurface() {
		if (isSetLod1MultiSurface())
			lod1MultiSurface.unsetParent();
		
		lod1MultiSurface = null;
	}

	public void unsetLod1Solid() {
		if (isSetLod1Solid())
			lod1Solid.unsetParent();
		
		lod1Solid = null;
	}

	public void unsetLod1TerrainIntersection() {
		if (isSetLod1TerrainIntersection())
			lod1TerrainIntersection.unsetParent();
		
		lod1TerrainIntersection = null;
	}

	public void unsetLod2MultiCurve() {
		if (isSetLod2MultiCurve())
			lod2MultiCurve.unsetParent();
		
		lod2MultiCurve = null;
	}

	public void unsetLod2MultiSurface() {
		if (isSetLod2MultiSurface())
			lod2MultiSurface.unsetParent();
		
		lod2MultiSurface = null;
	}

	public void unsetLod2Solid() {
		if (isSetLod2Solid())
			lod2Solid.unsetParent();
		
		lod2Solid = null;
	}

	public void unsetLod2TerrainIntersection() {
		if (isSetLod2TerrainIntersection())
			lod2TerrainIntersection.unsetParent();
		
		lod2TerrainIntersection = null;
	}

	public void unsetLod3MultiCurve() {
		if (isSetLod3MultiCurve())
			lod3MultiCurve.unsetParent();
		
		lod3MultiCurve = null;
	}

	public void unsetLod3MultiSurface() {
		if (isSetLod3MultiSurface())
			lod3MultiSurface.unsetParent();
		
		lod3MultiSurface = null;
	}

	public void unsetLod3Solid() {
		if (isSetLod3Solid())
			lod3Solid.unsetParent();
		
		lod3Solid = null;
	}

	public void unsetLod3TerrainIntersection() {
		if (isSetLod3TerrainIntersection())
			lod3TerrainIntersection.unsetParent();
		
		lod3TerrainIntersection = null;
	}

	public void unsetLod4MultiCurve() {
		if (isSetLod4MultiCurve())
			lod4MultiCurve.unsetParent();
		
		lod4MultiCurve = null;
	}

	public void unsetLod4MultiSurface() {
		if (isSetLod4MultiSurface())
			lod4MultiSurface.unsetParent();
		
		lod4MultiSurface = null;
	}

	public void unsetLod4Solid() {
		if (isSetLod4Solid())
			lod4Solid.unsetParent();
		
		lod4Solid = null;
	}

	public void unsetLod4TerrainIntersection() {
		if (isSetLod4TerrainIntersection())
			lod4TerrainIntersection.unsetParent();
		
		lod4TerrainIntersection = null;
	}

	public void unsetOuterBridgeInstallation() {
		if (isSetOuterBridgeInstallation())
			outerBridgeInstallation.clear();

		outerBridgeInstallation = null;
	}
	
	public boolean unsetOuterBridgeInstallation(BridgeInstallationProperty outerBridgeInstallation) {
		return isSetOuterBridgeInstallation() ? this.outerBridgeInstallation.remove(outerBridgeInstallation) : false;
	}

	public void unsetOuterBridgeConstructionElement() {
		if (isSetOuterBridgeConstructionElement())
			outerBridgeConstructionElement.clear();

		outerBridgeConstructionElement = null;
	}
	
	public boolean unsetOuterBridgeConstructionElement(BridgeConstructionElementProperty outerBridgeConstructionElement) {
		return isSetOuterBridgeConstructionElement() ? this.outerBridgeConstructionElement.remove(outerBridgeConstructionElement) : false;
	}

	public void unsetYearOfConstruction() {
		yearOfConstruction = null;
	}

	public void unsetYearOfDemolition() {
		yearOfDemolition = null;
	}

	public final BridgeModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
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
					boundedBy.updateEnvelope(ADEBoundingBoxHelper.calcBoundedBy((ADEModelObject)ade, this, options).getEnvelope());
			}
		}
		
		if (options.isAssignResultToFeatures())
			setBoundedBy(boundedBy);
		
		return boundedBy;
	}
	
	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();
		
		GeometryProperty<? extends AbstractGeometry> property = null;		
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				property = lod1Solid;
				break;
			case 2:
				property = lod2Solid;
				break;
			case 3:
				property = lod3Solid;
				break;
			case 4:
				property = lod4Solid;
				break;
			}
			
			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}
		
		property = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				property = lod1MultiSurface;
				break;
			case 2:
				property = lod2MultiSurface;
				break;
			case 3:
				property = lod3MultiSurface;
				break;
			case 4:
				property = lod4MultiSurface;
				break;
			}
			
			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}
		
		property = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				property = lod2MultiCurve;
				break;
			case 3:
				property = lod3MultiCurve;
				break;
			case 4:
				property = lod4MultiCurve;
				break;
			}
			
			if (property != null)
				lodRepresentation.addRepresentation(lod, property);
		}
		
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
