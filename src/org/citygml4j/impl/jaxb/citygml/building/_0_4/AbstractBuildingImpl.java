package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.AddressPropertyImpl;
import org.citygml4j.impl.jaxb.citygml.core._0_4.SiteImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LengthImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MeasureOrNullListImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiCurvePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SolidPropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.AddressPropertyType;
import org.citygml4j.jaxb.citygml._0_4.BoundarySurfacePropertyType;
import org.citygml4j.jaxb.citygml._0_4.BuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml._0_4.BuildingPartPropertyType;
import org.citygml4j.jaxb.citygml._0_4.IntBuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml._0_4.InteriorRoomPropertyType;
import org.citygml4j.jaxb.citygml._0_4._AbstractBuildingType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.BuildingInstallationProperty;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.BuildingPartProperty;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.Length;
import org.citygml4j.model.gml.MeasureOrNullList;
import org.citygml4j.model.gml.MultiCurve;
import org.citygml4j.model.gml.MultiCurveProperty;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.SolidProperty;

public abstract class AbstractBuildingImpl extends SiteImpl implements AbstractBuilding {
	private _AbstractBuildingType abstractBuilding;

	public AbstractBuildingImpl(_AbstractBuildingType abstractBuilding) {
		super(abstractBuilding);
		this.abstractBuilding = abstractBuilding;
	}

	@Override
	public _AbstractBuildingType getJAXBObject() {
		return abstractBuilding;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACTBUILDING;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v0_4_0;
	}

	public String getClazz() {
		return abstractBuilding.getClazz();
	}

	public List<String> getFunction() {
		return abstractBuilding.getFunction();
	}

	public List<String> getUsage() {
		return abstractBuilding.getUsage();
	}

	public XMLGregorianCalendar getYearOfConstruction() {
		if (abstractBuilding.isSetYearOfConstruction())
			return abstractBuilding.getYearOfConstruction();

		return null;
	}

	public XMLGregorianCalendar getYearOfDemolition() {
		if (abstractBuilding.isSetYearOfDemolition())
			return abstractBuilding.getYearOfDemolition();

		return null;
	}

	public String getRoofType() {
		return abstractBuilding.getRoofType();
	}

	public Length getMeasuredHeight() {
		if (abstractBuilding.isSetMeasuredHeight())
			return new LengthImpl(abstractBuilding.getMeasuredHeight());

		return null;
	}

	public Integer getStoreysAboveGround() {
		if (abstractBuilding.isSetStoreysAboveGround())
			return new Integer(abstractBuilding.getStoreysAboveGround().intValue());

		return null;
	}

	public Integer getStoreysBelowGround() {
		if (abstractBuilding.isSetStoreysBelowGround())
			return new Integer(abstractBuilding.getStoreysBelowGround().intValue());

		return null;
	}

	public MeasureOrNullList getStoreyHeightsAboveGround() {
		if (abstractBuilding.isSetStoreyHeightsAboveGround())
			return new MeasureOrNullListImpl(abstractBuilding.getStoreyHeightsAboveGround());

		return null;
	}

	public MeasureOrNullList getStoreyHeightsBelowGround() {
		if (abstractBuilding.isSetStoreyHeightsBelowGround())
			return new MeasureOrNullListImpl(abstractBuilding.getStoreyHeightsBelowGround());

		return null;
	}

	public SolidProperty getLod1Solid() {
		if (abstractBuilding.isSetLod1Solid())
			return new SolidPropertyImpl(abstractBuilding.getLod1Solid());

		return null;
	}

	public SolidProperty getLod2Solid() {
		if (abstractBuilding.isSetLod2Solid())
			return new SolidPropertyImpl(abstractBuilding.getLod2Solid());

		return null;
	}

	public SolidProperty getLod3Solid() {
		if (abstractBuilding.isSetLod3Solid())
			return new SolidPropertyImpl(abstractBuilding.getLod3Solid());

		return null;
	}

	public SolidProperty getLod4Solid() {
		if (abstractBuilding.isSetLod4Solid())
			return new SolidPropertyImpl(abstractBuilding.getLod4Solid());

		return null;
	}

	public MultiCurveProperty getLod1TerrainIntersection() {
		if (abstractBuilding.isSetLod1TerrainIntersection())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod1TerrainIntersection());

		return null;
	}

	public MultiCurveProperty getLod2TerrainIntersection() {
		if (abstractBuilding.isSetLod2TerrainIntersection())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod2TerrainIntersection());

		return null;
	}

	public MultiCurveProperty getLod3TerrainIntersection() {
		if (abstractBuilding.isSetLod3TerrainIntersection())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod3TerrainIntersection());

		return null;
	}

	public MultiCurveProperty getLod4TerrainIntersection() {
		if (abstractBuilding.isSetLod4TerrainIntersection())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod4TerrainIntersection());

		return null;
	}

	public MultiCurveProperty getLod2MultiCurve() {
		if (abstractBuilding.isSetLod2MultiCurve())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod2MultiCurve());

		return null;
	}

	public MultiCurveProperty getLod3MultiCurve() {
		if (abstractBuilding.isSetLod3MultiCurve())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod3MultiCurve());

		return null;
	}

	public MultiCurveProperty getLod4MultiCurve() {
		if (abstractBuilding.isSetLod4MultiCurve())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod4MultiCurve());

		return null;
	}

	public MultiSurfaceProperty getLod1MultiSurface() {
		if (abstractBuilding.isSetLod1MultiSurface())
			return new MultiSurfacePropertyImpl(abstractBuilding.getLod1MultiSurface());

		return null;
	}

	public MultiSurfaceProperty getLod2MultiSurface() {
		if (abstractBuilding.isSetLod2MultiSurface())
			return new MultiSurfacePropertyImpl(abstractBuilding.getLod2MultiSurface());

		return null;
	}

	public MultiSurfaceProperty getLod3MultiSurface() {
		if (abstractBuilding.isSetLod3MultiSurface())
			return new MultiSurfacePropertyImpl(abstractBuilding.getLod3MultiSurface());

		return null;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		if (abstractBuilding.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(abstractBuilding.getLod4MultiSurface());

		return null;
	}

	public List<BoundarySurfaceProperty> getBoundedBySurfaces() {
		List<BoundarySurfaceProperty> boundarySurfacePropertyList = new ArrayList<BoundarySurfaceProperty>();

		for (BoundarySurfacePropertyType boundarySurfacePropertyType : abstractBuilding.getBoundedBySurfaces())
			boundarySurfacePropertyList.add(new BoundarySurfacePropertyImpl(boundarySurfacePropertyType));

		return boundarySurfacePropertyList;
	}

	public List<BuildingInstallationProperty> getOuterBuildingInstallation() {
		List<BuildingInstallationProperty> buildingInstallationPropertyList = new ArrayList<BuildingInstallationProperty>();

		for (BuildingInstallationPropertyType buildingInstallationPropertyType : abstractBuilding.getOuterBuildingInstallation())
			buildingInstallationPropertyList.add(new BuildingInstallationPropertyImpl(buildingInstallationPropertyType));

		return buildingInstallationPropertyList;
	}

	public List<IntBuildingInstallationProperty> getInteriorBuildingInstallation() {
		List<IntBuildingInstallationProperty> intBuildingInstallationPropertyList = new ArrayList<IntBuildingInstallationProperty>();

		for (IntBuildingInstallationPropertyType intBuildingInstallationPropertyType : abstractBuilding.getInteriorBuildingInstallation())
			intBuildingInstallationPropertyList.add(new IntBuildingInstallationPropertyImpl(intBuildingInstallationPropertyType));

		return intBuildingInstallationPropertyList;
	}

	public List<BuildingPartProperty> getConsistsOfBuildingPart() {
		List<BuildingPartProperty> buildingPartPropertyList = new ArrayList<BuildingPartProperty>();

		for (BuildingPartPropertyType buildingPartPropertyType : abstractBuilding.getConsistsOfBuildingPart())
			buildingPartPropertyList.add(new BuildingPartPropertyImpl(buildingPartPropertyType));

		return buildingPartPropertyList;
	}

	public List<InteriorRoomProperty> getInteriorRoom() {
		List<InteriorRoomProperty> interiorRoomPropertyList = new ArrayList<InteriorRoomProperty>();

		for (InteriorRoomPropertyType interiorRoomPropertyType : abstractBuilding.getInteriorRoom())
			interiorRoomPropertyList.add(new InteriorRoomPropertyImpl(interiorRoomPropertyType));

		return interiorRoomPropertyList;
	}

	@Override
	public void calcBoundedBy() {
		SolidProperty solidProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				solidProperty = getLod1Solid();
				break;
			case 2:
				solidProperty = getLod2Solid();
				break;
			case 3:
				solidProperty = getLod3Solid();
				break;
			case 4:
				solidProperty = getLod4Solid();
				break;
			}

			if (solidProperty != null) {
				AbstractSolid abstractSolid = solidProperty.getSolid();
				if (abstractSolid != null) {
					calcBoundedBy(abstractSolid);
				} else {
					// xlink?
				}
			}
		}

		MultiSurfaceProperty multiSurfaceProperty = null;
		for (int lod = 1; lod < 5; lod++) {
			switch (lod) {
			case 1:
				multiSurfaceProperty = getLod1MultiSurface();
				break;
			case 2:
				multiSurfaceProperty = getLod2MultiSurface();
				break;
			case 3:
				multiSurfaceProperty = getLod3MultiSurface();
				break;
			case 4:
				multiSurfaceProperty = getLod4MultiSurface();
				break;
			}

			if (multiSurfaceProperty != null) {
				MultiSurface multiSurface = multiSurfaceProperty.getMultiSurface();
				if (multiSurface != null) {
					calcBoundedBy(multiSurface);
				} else {
					// xlink?
				}
			}
		}

		MultiCurveProperty multiCurveProperty = null;
		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				multiCurveProperty = getLod2MultiCurve();
				break;
			case 3:
				multiCurveProperty = getLod3MultiCurve();
				break;
			case 4:
				multiCurveProperty = getLod4MultiCurve();
				break;
			}

			if (multiCurveProperty != null) {
				MultiCurve multiCurve = multiCurveProperty.getMultiCurve();
				if (multiCurve != null) {
					calcBoundedBy(multiCurve);
				} else {
					// xlink?
				}
			}
		}

		if (isSetBoundedBySurfaces()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : getBoundedBySurfaces()) {
				if (boundarySurfaceProperty.isSetObject()) {
					calcBoundedBy(boundarySurfaceProperty.getObject());
				} else {
					// xlink?
				}
			}
		}

		if (isSetOuterBuildingInstallation()) {
			for (BuildingInstallationProperty buildingInstallationProperty : getOuterBuildingInstallation()) {
				if (buildingInstallationProperty.isSetObject()) {
					calcBoundedBy(buildingInstallationProperty.getObject());
				} else {
					// xlink?
				}
			}
		}

		if (isSetConsistsOfBuildingPart()) {
			for (BuildingPartProperty buildingPartProperty : getConsistsOfBuildingPart()) {
				if (buildingPartProperty.isSetObject()) {
					calcBoundedBy(buildingPartProperty.getObject());
				} else {
					// xlink?
				}
			}
		}
	}

	public void addFunction(String function) {
		abstractBuilding.getFunction().add(function);
	}

	public void addUsage(String usage) {
		abstractBuilding.getUsage().add(usage);
	}

	public void setClazz(String clazz) {
		abstractBuilding.setClazz(clazz);
	}

	public void setFunction(List<String> function) {
		abstractBuilding.unsetFunction();
		abstractBuilding.getFunction().addAll(function);
	}

	public void setUsage(List<String> usage) {
		abstractBuilding.unsetUsage();
		abstractBuilding.getUsage().addAll(usage);
	}

	public void setRoofType(String roofType) {
		abstractBuilding.setRoofType(roofType);
	}

	public void setYearOfConstruction(XMLGregorianCalendar yearOfConstruction) {
		abstractBuilding.setYearOfConstruction(yearOfConstruction);
	}

	public void setYearOfDemolition(XMLGregorianCalendar yearOfDemolition) {
		abstractBuilding.setYearOfDemolition(yearOfDemolition);
	}

	public void setMeasuredHeight(Length length) {
		abstractBuilding.setMeasuredHeight(((LengthImpl)length).getJAXBObject());
	}

	public void setStoreyHeightsAboveGround(MeasureOrNullList storeysHeightsAboveGround) {
		abstractBuilding.setStoreyHeightsAboveGround(((MeasureOrNullListImpl)storeysHeightsAboveGround).getJAXBObject());
	}

	public void setStoreyHeightsBelowGround(MeasureOrNullList storeysBelowAboveGround) {
		abstractBuilding.setStoreyHeightsBelowGround(((MeasureOrNullListImpl)storeysBelowAboveGround).getJAXBObject());
	}

	public void setStoreysAboveGround(Integer storeysAboveGround) {
		abstractBuilding.setStoreysAboveGround(new BigInteger(storeysAboveGround.toString()));
	}

	public void setStoreysBelowGround(Integer storeysBelowGround) {
		abstractBuilding.setStoreysBelowGround(new BigInteger(storeysBelowGround.toString()));
	}

	public void setLod1Solid(SolidProperty lod1Solid) {
		abstractBuilding.setLod1Solid(((SolidPropertyImpl)lod1Solid).getJAXBObject());
	}

	public void setLod2Solid(SolidProperty lod2Solid) {
		abstractBuilding.setLod2Solid(((SolidPropertyImpl)lod2Solid).getJAXBObject());
	}

	public void setLod3Solid(SolidProperty lod3Solid) {
		abstractBuilding.setLod3Solid(((SolidPropertyImpl)lod3Solid).getJAXBObject());
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		abstractBuilding.setLod4Solid(((SolidPropertyImpl)lod4Solid).getJAXBObject());
	}

	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		abstractBuilding.setLod1MultiSurface(((MultiSurfacePropertyImpl)lod1MultiSurface).getJAXBObject());
	}

	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		abstractBuilding.setLod2MultiSurface(((MultiSurfacePropertyImpl)lod2MultiSurface).getJAXBObject());
	}

	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		abstractBuilding.setLod3MultiSurface(((MultiSurfacePropertyImpl)lod3MultiSurface).getJAXBObject());
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		abstractBuilding.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	public void addInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation) {
		abstractBuilding.getInteriorBuildingInstallation().add(((IntBuildingInstallationPropertyImpl)interiorBuildingInstallation).getJAXBObject());
	}

	public void addOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation) {
		abstractBuilding.getOuterBuildingInstallation().add(((BuildingInstallationPropertyImpl)outerBuildingInstallation).getJAXBObject());
	}

	public void setInteriorBuildingInstallation(List<IntBuildingInstallationProperty> interiorBuildingInstallation) {
		List<IntBuildingInstallationPropertyType> intInstPropList = new ArrayList<IntBuildingInstallationPropertyType>();

		for (IntBuildingInstallationProperty intInstProp : interiorBuildingInstallation)
			intInstPropList.add(((IntBuildingInstallationPropertyImpl)intInstProp).getJAXBObject());

		abstractBuilding.unsetInteriorBuildingInstallation();
		abstractBuilding.getInteriorBuildingInstallation().addAll(intInstPropList);
	}

	public void setOuterBuildingInstallation(List<BuildingInstallationProperty> outerBuildingInstallation) {
		List<BuildingInstallationPropertyType> instPropList = new ArrayList<BuildingInstallationPropertyType>();

		for (BuildingInstallationProperty instProp : outerBuildingInstallation)
			instPropList.add(((BuildingInstallationPropertyImpl)instProp).getJAXBObject());

		abstractBuilding.unsetOuterBuildingInstallation();
		abstractBuilding.getOuterBuildingInstallation().addAll(instPropList);
	}

	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		abstractBuilding.getBoundedBySurfaces().add(((BoundarySurfacePropertyImpl)boundedBySurface).getJAXBObject());
	}

	public void setBoundedBySurfaces(List<BoundarySurfaceProperty> boundedBySurfaces) {
		List<BoundarySurfacePropertyType> boundSurfPropTypeList = new ArrayList<BoundarySurfacePropertyType>();

		for (BoundarySurfaceProperty boundSurfProp : boundedBySurfaces)
			boundSurfPropTypeList.add(((BoundarySurfacePropertyImpl)boundSurfProp).getJAXBObject());

		abstractBuilding.unsetBoundedBySurfaces();
		abstractBuilding.getBoundedBySurfaces().addAll(boundSurfPropTypeList);
	}

	public void addInteriorRoom(InteriorRoomProperty interiorRoom) {
		abstractBuilding.getInteriorRoom().add(((InteriorRoomPropertyImpl)interiorRoom).getJAXBObject());
	}

	public void setInteriorRoom(List<InteriorRoomProperty> interiorRoom) {
		List<InteriorRoomPropertyType> intRoomPropTypeList = new ArrayList<InteriorRoomPropertyType>();

		for (InteriorRoomProperty intRoomProp : interiorRoom)
			intRoomPropTypeList.add(((InteriorRoomPropertyImpl)intRoomProp).getJAXBObject());

		abstractBuilding.unsetInteriorRoom();
		abstractBuilding.getInteriorRoom().addAll(intRoomPropTypeList);
	}

	public void addConsistsOfBuildingPart(BuildingPartProperty buildingPart) {
		abstractBuilding.getConsistsOfBuildingPart().add(((BuildingPartPropertyImpl)buildingPart).getJAXBObject());
	}

	public void setConsistsOfBuildingPart(List<BuildingPartProperty> buildingPart) {
		List<BuildingPartPropertyType> buildPartPropTypeList = new ArrayList<BuildingPartPropertyType>();

		for (BuildingPartProperty buildingPartProp : buildingPart)
			buildPartPropTypeList.add(((BuildingPartPropertyImpl)buildingPartProp).getJAXBObject());

		abstractBuilding.unsetConsistsOfBuildingPart();
		abstractBuilding.getConsistsOfBuildingPart().addAll(buildPartPropTypeList);

	}

	public void addAddress(AddressProperty address) {
		abstractBuilding.getAddress().add(((AddressPropertyImpl)address).getJAXBObject());
	}

	public List<AddressProperty> getAddress() {
		List<AddressProperty> addressPropertyList = new ArrayList<AddressProperty>();

		for (AddressPropertyType addressPropertyType : abstractBuilding.getAddress())
			addressPropertyList.add(new AddressPropertyImpl(addressPropertyType));

		return addressPropertyList;
	}

	public void setAddress(List<AddressProperty> address) {
		List<AddressPropertyType> addressPropertyTypeList = new ArrayList<AddressPropertyType>();

		for (AddressProperty addressProperty : address)
			addressPropertyTypeList.add(((AddressPropertyImpl)addressProperty).getJAXBObject());

		abstractBuilding.unsetAddress();
		abstractBuilding.getAddress().addAll(addressPropertyTypeList);
	}

	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection) {
		abstractBuilding.setLod1TerrainIntersection(((MultiCurvePropertyImpl)lod1TerrainIntersection).getJAXBObject());
	}

	public void setLod2MultiCurve(MultiCurveProperty lod2MultiCurve) {
		abstractBuilding.setLod2MultiCurve(((MultiCurvePropertyImpl)lod2MultiCurve).getJAXBObject());
	}

	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection) {
		abstractBuilding.setLod2TerrainIntersection(((MultiCurvePropertyImpl)lod2TerrainIntersection).getJAXBObject());
	}

	public void setLod3MultiCurve(MultiCurveProperty lod3MultiCurve) {
		abstractBuilding.setLod3MultiCurve(((MultiCurvePropertyImpl)lod3MultiCurve).getJAXBObject());
	}

	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection) {
		abstractBuilding.setLod3TerrainIntersection(((MultiCurvePropertyImpl)lod3TerrainIntersection).getJAXBObject());
	}

	public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve) {
		abstractBuilding.setLod4MultiCurve(((MultiCurvePropertyImpl)lod4MultiCurve).getJAXBObject());
	}

	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection) {
		abstractBuilding.setLod4TerrainIntersection(((MultiCurvePropertyImpl)lod4TerrainIntersection).getJAXBObject());
	}

	public void addGenericApplicationPropertyOfAbstractBuilding(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			abstractBuilding.get_GenericApplicationPropertyOfAbstractBuilding().add(jaxbElem);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfAbstractBuilding() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : abstractBuilding.get_GenericApplicationPropertyOfAbstractBuilding()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	public void setGenericApplicationPropertyOfAbstractBuilding(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			abstractBuilding.unset_GenericApplicationPropertyOfAbstractBuilding();
			abstractBuilding.get_GenericApplicationPropertyOfAbstractBuilding().addAll(elemList);
		}
	}

	public boolean isSetAddress() {
		return abstractBuilding.isSetAddress();
	}

	public boolean isSetBoundedBySurfaces() {
		return abstractBuilding.isSetBoundedBySurfaces();
	}

	public boolean isSetClazz() {
		return abstractBuilding.isSetClazz();
	}

	public boolean isSetConsistsOfBuildingPart() {
		return abstractBuilding.isSetConsistsOfBuildingPart();
	}

	public boolean isSetFunction() {
		return abstractBuilding.isSetFunction();
	}

	public boolean isSetGenericApplicationPropertyOfAbstractBuilding() {
		return abstractBuilding.isSet_GenericApplicationPropertyOfAbstractBuilding();
	}

	public boolean isSetLod1MultiSurface() {
		return abstractBuilding.isSetLod1MultiSurface();
	}

	public boolean isSetLod1TerrainIntersection() {
		return abstractBuilding.isSetLod1TerrainIntersection();
	}

	public boolean isSetLod2MultiCurve() {
		return abstractBuilding.isSetLod2MultiCurve();
	}

	public boolean isSetLod2MultiSurface() {
		return abstractBuilding.isSetLod2MultiSurface();
	}

	public boolean isSetLod2TerrainIntersection() {
		return abstractBuilding.isSetLod2TerrainIntersection();
	}

	public boolean isSetLod3MultiCurve() {
		return abstractBuilding.isSetLod3MultiCurve();
	}

	public boolean isSetLod3MultiSurface() {
		return abstractBuilding.isSetLod3MultiSurface();
	}

	public boolean isSetLod3TerrainIntersection() {
		return abstractBuilding.isSetLod3TerrainIntersection();
	}

	public boolean isSetLod4MultiCurve() {
		return abstractBuilding.isSetLod4MultiCurve();
	}

	public boolean isSetLod4MultiSurface() {
		return abstractBuilding.isSetLod4MultiSurface();
	}

	public boolean isSetLod4TerrainIntersection() {
		return abstractBuilding.isSetLod4TerrainIntersection();
	}

	public boolean isSetInteriorBuildingInstallation() {
		return abstractBuilding.isSetInteriorBuildingInstallation();
	}

	public boolean isSetInteriorRoom() {
		return abstractBuilding.isSetInteriorRoom();
	}

	public boolean isSetLod1Solid() {
		return abstractBuilding.isSetLod1Solid();
	}

	public boolean isSetLod2Solid() {
		return abstractBuilding.isSetLod2Solid();
	}

	public boolean isSetLod3Solid() {
		return abstractBuilding.isSetLod3Solid();
	}

	public boolean isSetLod4Solid() {
		return abstractBuilding.isSetLod4Solid();
	}

	public boolean isSetMeasuredHeight() {
		return abstractBuilding.isSetMeasuredHeight();
	}

	public boolean isSetOuterBuildingInstallation() {
		return abstractBuilding.isSetOuterBuildingInstallation();
	}

	public boolean isSetRoofType() {
		return abstractBuilding.isSetRoofType();
	}

	public boolean isSetStoreyHeightsAboveGround() {
		return abstractBuilding.isSetStoreyHeightsAboveGround();
	}

	public boolean isSetStoreyHeightsBelowGround() {
		return abstractBuilding.isSetStoreyHeightsBelowGround();
	}

	public boolean isSetStoreysAboveGround() {
		return abstractBuilding.isSetStoreysAboveGround();
	}

	public boolean isSetStoreysBelowGround() {
		return abstractBuilding.isSetStoreysBelowGround();
	}

	public boolean isSetUsage() {
		return abstractBuilding.isSetUsage();
	}

	public boolean isSetYearOfConstruction() {
		return abstractBuilding.isSetYearOfConstruction();
	}

	public boolean isSetYearOfDemolition() {
		return abstractBuilding.isSetYearOfDemolition();
	}

	public void unsetAddress() {
		abstractBuilding.unsetAddress();
	}

	public void unsetBoundedBySurfaces() {
		abstractBuilding.unsetBoundedBySurfaces();
	}

	public void unsetClazz() {
		abstractBuilding.setClazz(null);
	}

	public void unsetConsistsOfBuildingPart() {
		abstractBuilding.unsetConsistsOfBuildingPart();
	}

	public void unsetFunction() {
		abstractBuilding.unsetFunction();
	}

	public void unsetGenericApplicationPropertyOfAbstractBuilding() {
		abstractBuilding.unset_GenericApplicationPropertyOfAbstractBuilding();
	}

	public void unsetLod1MultiSurface() {
		abstractBuilding.setLod1MultiSurface(null);
	}

	public void unsetLod1TerrainIntersection() {
		abstractBuilding.setLod1TerrainIntersection(null);
	}

	public void unsetLod2MultiCurve() {
		abstractBuilding.setLod2MultiCurve(null);
	}

	public void unsetLod2MultiSurface() {
		abstractBuilding.setLod2MultiSurface(null);
	}

	public void unsetLod2TerrainIntersection() {
		abstractBuilding.setLod2TerrainIntersection(null);
	}

	public void unsetLod3MultiCurve() {
		abstractBuilding.setLod3MultiCurve(null);
	}

	public void unsetLod3MultiSurface() {
		abstractBuilding.setLod3MultiSurface(null);
	}

	public void unsetLod3TerrainIntersection() {
		abstractBuilding.setLod3TerrainIntersection(null);
	}

	public void unsetLod4MultiCurve() {
		abstractBuilding.setLod4MultiCurve(null);
	}

	public void unsetLod4MultiSurface() {
		abstractBuilding.setLod4MultiSurface(null);
	}

	public void unsetLod4TerrainIntersection() {
		abstractBuilding.setLod4TerrainIntersection(null);
	}

	public void unsetInteriorBuildingInstallation() {
		abstractBuilding.unsetInteriorBuildingInstallation();
	}

	public void unsetInteriorRoom() {
		abstractBuilding.unsetInteriorRoom();
	}

	public void unsetLod1Solid() {
		abstractBuilding.setLod1Solid(null);
	}

	public void unsetLod2Solid() {
		abstractBuilding.setLod2Solid(null);
	}

	public void unsetLod3Solid() {
		abstractBuilding.setLod3Solid(null);
	}

	public void unsetLod4Solid() {
		abstractBuilding.setLod4Solid(null);
	}

	public void unsetMeasuredHeight() {
		abstractBuilding.setMeasuredHeight(null);
	}

	public void unsetOuterBuildingInstallation() {
		abstractBuilding.unsetOuterBuildingInstallation();
	}

	public void unsetRoofType() {
		abstractBuilding.setRoofType(null);
	}

	public void unsetStoreyHeightsAboveGround() {
		abstractBuilding.setStoreyHeightsAboveGround(null);
	}

	public void unsetStoreyHeightsBelowGround() {
		abstractBuilding.setStoreyHeightsBelowGround(null);
	}

	public void unsetStoreysAboveGround() {
		abstractBuilding.setStoreysAboveGround(null);
	}

	public void unsetStoreysBelowGround() {
		abstractBuilding.setStoreysBelowGround(null);
	}

	public void unsetUsage() {
		abstractBuilding.unsetUsage();
	}

	public void unsetYearOfConstruction() {
		abstractBuilding.setYearOfConstruction(null);
	}

	public void unsetYearOfDemolition() {
		abstractBuilding.setYearOfDemolition(null);
	}

	public boolean unsetAddress(AddressProperty address) {
		if (abstractBuilding.isSetAddress())
			return abstractBuilding.getAddress().remove(((AddressPropertyImpl)address).getJAXBObject());
			
		return false;
	}

	public boolean unsetBoundedBySurfaces(BoundarySurfaceProperty boundedBySurface) {
		if (abstractBuilding.isSetBoundedBySurfaces())
			return abstractBuilding.getBoundedBySurfaces().remove(((BoundarySurfacePropertyImpl)boundedBySurface).getJAXBObject());
			
		return false;
	}

	public boolean unsetConsistsOfBuildingPart(BuildingPartProperty buildingPart) {
		if (abstractBuilding.isSetConsistsOfBuildingPart())
			return abstractBuilding.getConsistsOfBuildingPart().remove(((BuildingPartPropertyImpl)buildingPart).getJAXBObject());
		
		return false;
	}

	public boolean unsetFunction(String function) {
		if (abstractBuilding.isSetFunction())
			return abstractBuilding.getFunction().remove(function);
		
		return false;
	}

	public boolean unsetGenericApplicationPropertyOfAbstractBuilding(ADEComponent adeObject) {
		if (abstractBuilding.isSet_GenericApplicationPropertyOfAbstractBuilding()) {
			Iterator<JAXBElement<?>> iter = abstractBuilding.get_GenericApplicationPropertyOfAbstractBuilding().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue() != null) {
					JAXBElement<?> ade = ModelMapper.ADE.toJAXB(adeObject);
					if (ade != null && ade.getValue() != null && elem.getValue().equals(ade.getValue())) {
						iter.remove();
						return true;
					}
				}
			}				
		}

		return false;
	}

	public boolean unsetInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation) {
		if (abstractBuilding.isSetInteriorBuildingInstallation())
			return abstractBuilding.getInteriorBuildingInstallation().remove(((IntBuildingInstallationPropertyImpl)interiorBuildingInstallation).getJAXBObject());
		
		return false;
	}

	public boolean unsetInteriorRoom(InteriorRoomProperty interiorRoom) {
		if (abstractBuilding.isSetInteriorRoom())
			return abstractBuilding.getInteriorRoom().remove(((InteriorRoomPropertyImpl)interiorRoom).getJAXBObject());
		
		return false;
	}

	public boolean unsetOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation) {
		if (abstractBuilding.isSetOuterBuildingInstallation())
			return abstractBuilding.getOuterBuildingInstallation().remove(((BuildingInstallationPropertyImpl)outerBuildingInstallation).getJAXBObject());
		
		return false;
	}

	public boolean unsetUsage(String usage) {
		if (abstractBuilding.isSetUsage())
			return abstractBuilding.getUsage().remove(usage);
		
		return false;
	}

}
