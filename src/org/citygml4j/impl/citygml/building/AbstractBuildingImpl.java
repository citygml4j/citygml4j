package org.citygml4j.impl.citygml.building;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.citygml.core.SiteImpl;
import org.citygml4j.impl.gml.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingPartProperty;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.Length;
import org.citygml4j.model.gml.MeasureOrNullList;
import org.citygml4j.model.gml.MultiCurveProperty;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.module.citygml.BuildingModule;

public abstract class AbstractBuildingImpl extends SiteImpl implements AbstractBuilding {
	private String clazz;
	private List<String> function;
	private List<String> usage;
	private GregorianCalendar yearOfConstruction;
	private GregorianCalendar yearOfDemolition;
	private String roofType;
	private Length measuredHeight;
	private Integer storeysAboveGround;
	private Integer storeysBelowGround;
	private MeasureOrNullList storeyHeightsAboveGround;
	private MeasureOrNullList storeyHeightsBelowGround;
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
	private List<BuildingInstallationProperty> outerBuildingInstallation;
	private List<IntBuildingInstallationProperty> interiorBuildingInstallation;
	private List<BoundarySurfaceProperty> boundedBySurface;
	private List<BuildingPartProperty> buildingPart;
	private List<InteriorRoomProperty> interiorRoom;
	private List<AddressProperty> address;
	private List<ADEComponent> ade;
	private BuildingModule module;	
	
	public AbstractBuildingImpl() {
		
	}
	
	public AbstractBuildingImpl(BuildingModule module) {
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

	public void addConsistsOfBuildingPart(BuildingPartProperty buildingPart) {
		if (this.buildingPart == null)
			this.buildingPart = new ChildList<BuildingPartProperty>(this);

		this.buildingPart.add(buildingPart);
	}

	public void addFunction(String function) {
		if (this.function == null)
			this.function = new ArrayList<String>();
		
		this.function.add(function);
	}

	public void addGenericApplicationPropertyOfAbstractBuilding(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation) {
		if (this.interiorBuildingInstallation == null)
			this.interiorBuildingInstallation = new ChildList<IntBuildingInstallationProperty>(this);

		this.interiorBuildingInstallation.add(interiorBuildingInstallation);
	}

	public void addInteriorRoom(InteriorRoomProperty interiorRoom) {
		if (this.interiorRoom == null)
			this.interiorRoom = new ChildList<InteriorRoomProperty>(this);

		this.interiorRoom.add(interiorRoom);
	}

	public void addOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation) {
		if (this.outerBuildingInstallation == null)
			this.outerBuildingInstallation = new ChildList<BuildingInstallationProperty>(this);

		this.outerBuildingInstallation.add(outerBuildingInstallation);
	}

	public void addUsage(String usage) {
		if (this.usage == null)
			this.usage = new ArrayList<String>();

		this.usage.add(usage);
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

	public String getClazz() {
		return clazz;
	}

	public List<BuildingPartProperty> getConsistsOfBuildingPart() {
		if (buildingPart == null)
			buildingPart = new ChildList<BuildingPartProperty>(this);

		return buildingPart;
	}

	public List<String> getFunction() {
		if (function == null)
			function = new ArrayList<String>();
		
		return function;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAbstractBuilding() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<IntBuildingInstallationProperty> getInteriorBuildingInstallation() {
		if (interiorBuildingInstallation == null)
			interiorBuildingInstallation = new ChildList<IntBuildingInstallationProperty>(this);

		return interiorBuildingInstallation;
	}

	public List<InteriorRoomProperty> getInteriorRoom() {
		if (interiorRoom == null)
			interiorRoom = new ChildList<InteriorRoomProperty>(this);

		return interiorRoom;
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

	public Length getMeasuredHeight() {
		return measuredHeight;
	}

	public List<BuildingInstallationProperty> getOuterBuildingInstallation() {
		if (outerBuildingInstallation == null)
			outerBuildingInstallation = new ChildList<BuildingInstallationProperty>(this);

		return outerBuildingInstallation;
	}

	public String getRoofType() {
		return roofType;
	}

	public MeasureOrNullList getStoreyHeightsAboveGround() {
		return storeyHeightsAboveGround;
	}

	public MeasureOrNullList getStoreyHeightsBelowGround() {
		return storeyHeightsBelowGround;
	}

	public Integer getStoreysAboveGround() {
		return storeysAboveGround;
	}

	public Integer getStoreysBelowGround() {
		return storeysBelowGround;
	}

	public List<String> getUsage() {
		if (usage == null)
			usage = new ArrayList<String>();

		return usage;
	}

	public GregorianCalendar getYearOfConstruction() {
		return yearOfConstruction;
	}

	public GregorianCalendar getYearOfDemolition() {
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

	public boolean isSetConsistsOfBuildingPart() {
		return buildingPart != null && !buildingPart.isEmpty();
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfAbstractBuilding() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetInteriorBuildingInstallation() {
		return interiorBuildingInstallation != null && !interiorBuildingInstallation.isEmpty();
	}

	public boolean isSetInteriorRoom() {
		return interiorRoom != null && !interiorRoom.isEmpty();
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

	public boolean isSetMeasuredHeight() {
		return measuredHeight != null;
	}

	public boolean isSetOuterBuildingInstallation() {
		return outerBuildingInstallation != null && !outerBuildingInstallation.isEmpty();
	}

	public boolean isSetRoofType() {
		return roofType != null;
	}

	public boolean isSetStoreyHeightsAboveGround() {
		return storeyHeightsAboveGround != null;
	}

	public boolean isSetStoreyHeightsBelowGround() {
		return storeyHeightsBelowGround != null;
	}

	public boolean isSetStoreysAboveGround() {
		return storeysAboveGround != null;
	}

	public boolean isSetStoreysBelowGround() {
		return storeysBelowGround != null;
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

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setConsistsOfBuildingPart(List<BuildingPartProperty> buildingPart) {
		this.buildingPart = new ChildList<BuildingPartProperty>(this, buildingPart);
	}

	public void setFunction(List<String> function) {
		this.function = function;
	}

	public void setGenericApplicationPropertyOfAbstractBuilding(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setInteriorBuildingInstallation(List<IntBuildingInstallationProperty> interiorBuildingInstallation) {
		this.interiorBuildingInstallation = new ChildList<IntBuildingInstallationProperty>(this, interiorBuildingInstallation);
	}

	public void setInteriorRoom(List<InteriorRoomProperty> interiorRoom) {
		this.interiorRoom = new ChildList<InteriorRoomProperty>(this, interiorRoom);
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

	public void setMeasuredHeight(Length measuredHeight) {
		if (measuredHeight != null)
			measuredHeight.setParent(this);
		
		this.measuredHeight = measuredHeight;
	}

	public void setOuterBuildingInstallation(List<BuildingInstallationProperty> outerBuildingInstallation) {
		this.outerBuildingInstallation = new ChildList<BuildingInstallationProperty>(this, outerBuildingInstallation);
	}

	public void setRoofType(String roofType) {
		this.roofType = roofType;
	}

	public void setStoreyHeightsAboveGround(MeasureOrNullList storeyHeightsAboveGround) {
		if (storeyHeightsAboveGround != null)
			storeyHeightsAboveGround.setParent(this);
		
		this.storeyHeightsAboveGround = storeyHeightsAboveGround;
	}

	public void setStoreyHeightsBelowGround(MeasureOrNullList storeyHeightsBelowGround) {
		if (storeyHeightsBelowGround != null)
			storeyHeightsBelowGround.setParent(this);
		
		this.storeyHeightsBelowGround = storeyHeightsBelowGround;
	}

	public void setStoreysAboveGround(Integer storeysAboveGround) {
		if (storeysAboveGround >= 0)
			this.storeysAboveGround = storeysAboveGround;
	}

	public void setStoreysBelowGround(Integer storeysBelowGround) {
		if (storeysBelowGround >= 0)
			this.storeysBelowGround = storeysBelowGround;
	}

	public void setUsage(List<String> usage) {
		this.usage = usage;
	}

	public void setYearOfConstruction(GregorianCalendar yearOfConstruction) {
		this.yearOfConstruction = yearOfConstruction;
	}

	public void setYearOfDemolition(GregorianCalendar yearOfDemolition) {
		this.yearOfDemolition = yearOfDemolition;
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

	public void unsetConsistsOfBuildingPart() {
		if (isSetConsistsOfBuildingPart())
			buildingPart.clear();

		buildingPart = null;
	}

	public boolean unsetConsistsOfBuildingPart(BuildingPartProperty buildingPart) {
		return isSetConsistsOfBuildingPart() ? this.buildingPart.remove(buildingPart) : false;
	}

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(String function) {
		return isSetFunction() ? this.function.remove(function) : false;
	}

	public void unsetGenericApplicationPropertyOfAbstractBuilding() {
		if (isSetGenericApplicationPropertyOfAbstractBuilding())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfAbstractBuilding(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfAbstractBuilding() ? this.ade.remove(ade) : false;	}

	public void unsetInteriorBuildingInstallation() {
		if (isSetInteriorBuildingInstallation())
			interiorBuildingInstallation.clear();

		interiorBuildingInstallation = null;
	}

	public boolean unsetInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation) {
		return isSetInteriorBuildingInstallation() ? this.interiorBuildingInstallation.remove(interiorBuildingInstallation) : false;
	}

	public void unsetInteriorRoom() {
		if (isSetInteriorRoom())
			interiorRoom.clear();

		interiorRoom = null;
	}

	public boolean unsetInteriorRoom(InteriorRoomProperty interiorRoom) {
		return isSetInteriorRoom() ? this.interiorRoom.remove(interiorRoom) : false;
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

	public void unsetMeasuredHeight() {
		if (isSetMeasuredHeight())
			measuredHeight.unsetParent();
		
		measuredHeight = null;
	}

	public void unsetOuterBuildingInstallation() {
		if (isSetOuterBuildingInstallation())
			outerBuildingInstallation.clear();

		outerBuildingInstallation = null;
	}

	public boolean unsetOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation) {
		return isSetOuterBuildingInstallation() ? this.outerBuildingInstallation.remove(outerBuildingInstallation) : false;
	}

	public void unsetRoofType() {
		roofType = null;
	}

	public void unsetStoreyHeightsAboveGround() {
		if (isSetStoreyHeightsAboveGround())
			storeyHeightsAboveGround.unsetParent();
		
		storeyHeightsAboveGround = null;
	}

	public void unsetStoreyHeightsBelowGround() {
		if (isSetStoreyHeightsBelowGround())
			storeyHeightsBelowGround.unsetParent();
		
		storeyHeightsBelowGround = null;
	}

	public void unsetStoreysAboveGround() {
		storeysAboveGround = null;
	}

	public void unsetStoreysBelowGround() {
		storeysBelowGround = null;
	}

	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(String usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}

	public void unsetYearOfConstruction() {
		yearOfConstruction = null;
	}

	public void unsetYearOfDemolition() {
		yearOfDemolition = null;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACTBUILDING;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();
		
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
					calcBoundedBy(boundedBy, solidProperty.getSolid());
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
					calcBoundedBy(boundedBy, multiSurfaceProperty.getMultiSurface());
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
					calcBoundedBy(boundedBy, multiCurveProperty.getMultiCurve());
				} else {
					// xlink
				}
			}
		}
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : getBoundedBySurface()) {
				if (boundarySurfaceProperty.isSetObject()) {
					calcBoundedBy(boundedBy, boundarySurfaceProperty.getObject(), setBoundedBy);
				} else {
					// xlink?
				}
			}
		}
		
		if (isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty buildingInstallationProperty : getOuterBuildingInstallation()) {
				if (buildingInstallationProperty.isSetObject()) {
					calcBoundedBy(boundedBy, buildingInstallationProperty.getObject(), setBoundedBy);
				} else {
					// xlink?
				}
			}
		}

		if (isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty buildingPartProperty : getConsistsOfBuildingPart()) {
				if (buildingPartProperty.isSetObject()) {
					calcBoundedBy(boundedBy, buildingPartProperty.getObject(), setBoundedBy);
				} else {
					// xlink?
				}
			}
		}
		
		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractBuilding copy = (AbstractBuilding)target;		
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz(copyBuilder.copy(clazz));

		if (isSetFunction())
			copy.setFunction((List<String>)copyBuilder.copy(function));

		if (isSetUsage())
			copy.setFunction((List<String>)copyBuilder.copy(usage));
		
		if (isSetYearOfConstruction())
			copy.setYearOfConstruction((GregorianCalendar)copyBuilder.copy(yearOfConstruction));
		
		if (isSetYearOfDemolition())
			copy.setYearOfDemolition((GregorianCalendar)copyBuilder.copy(yearOfDemolition));
		
		if (isSetRoofType())
			copy.setRoofType(copyBuilder.copy(roofType));
		
		if (isSetStoreysAboveGround())
			copy.setStoreysAboveGround((Integer)copyBuilder.copy(storeysAboveGround));
		
		if (isSetStoreysBelowGround())
			copy.setStoreysBelowGround((Integer)copyBuilder.copy(storeysBelowGround));

		if (isSetMeasuredHeight()) {
			copy.setMeasuredHeight((Length)copyBuilder.copy(measuredHeight));
			if (copy.getMeasuredHeight() == measuredHeight)
				measuredHeight.setParent(this);
		}
		
		if (isSetStoreyHeightsAboveGround()) {
			copy.setStoreyHeightsAboveGround((MeasureOrNullList)copyBuilder.copy(storeyHeightsAboveGround));
			if (copy.getStoreyHeightsAboveGround() == storeyHeightsAboveGround)
				storeyHeightsAboveGround.setParent(this);
		}
		
		if (isSetStoreyHeightsBelowGround()) {
			copy.setStoreyHeightsBelowGround((MeasureOrNullList)copyBuilder.copy(storeyHeightsBelowGround));
			if (copy.getStoreyHeightsBelowGround() == storeyHeightsBelowGround)
				storeyHeightsBelowGround.setParent(this);
		}
		
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
		
		if (isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty part : outerBuildingInstallation) {
				BuildingInstallationProperty copyPart = (BuildingInstallationProperty)copyBuilder.copy(part);
				copy.addOuterBuildingInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorBuildingInstallation()) {
			for (IntBuildingInstallationProperty part : interiorBuildingInstallation) {
				IntBuildingInstallationProperty copyPart = (IntBuildingInstallationProperty)copyBuilder.copy(part);
				copy.addInteriorBuildingInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty part : buildingPart) {
				BuildingPartProperty copyPart = (BuildingPartProperty)copyBuilder.copy(part);
				copy.addConsistsOfBuildingPart(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorRoom()) {
			for (InteriorRoomProperty part : interiorRoom) {
				InteriorRoomProperty copyPart = (InteriorRoomProperty)copyBuilder.copy(part);
				copy.addInteriorRoom(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfAbstractBuilding()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfAbstractBuilding(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
				
		return copy;
	}

}
