package org.citygml4j.impl.jaxb.citygml.building._1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.XMLGregorianCalendar;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.AddressPropertyImpl;
import org.citygml4j.impl.jaxb.citygml.core._1.SiteImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LengthImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MeasureOrNullListImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiCurvePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SolidPropertyImpl;
import org.citygml4j.jaxb.citygml.bldg._1.AbstractBuildingType;
import org.citygml4j.jaxb.citygml.bldg._1.BoundarySurfacePropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.BuildingPartPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.IntBuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.InteriorRoomPropertyType;
import org.citygml4j.jaxb.citygml.core._1.AddressPropertyType;
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
	private AbstractBuildingType abstractBuilding;

	public AbstractBuildingImpl(AbstractBuildingType abstractBuilding) {
		super(abstractBuilding);
		this.abstractBuilding = abstractBuilding;
	}

	@Override
	public AbstractBuildingType getJAXBObject() {
		return abstractBuilding;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ABSTRACTBUILDING;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v1_0_0;
	}

	@Override
	public String getClazz() {
		return abstractBuilding.getClazz();
	}

	@Override
	public List<String> getFunction() {
		return abstractBuilding.getFunction();
	}

	@Override
	public List<String> getUsage() {
		return abstractBuilding.getUsage();
	}

	@Override
	public XMLGregorianCalendar getYearOfConstruction() {
		if (abstractBuilding.isSetYearOfConstruction())
			return abstractBuilding.getYearOfConstruction();

		return null;
	}

	@Override
	public XMLGregorianCalendar getYearOfDemolition() {
		if (abstractBuilding.isSetYearOfDemolition())
			return abstractBuilding.getYearOfDemolition();

		return null;
	}

	@Override
	public String getRoofType() {
		return abstractBuilding.getRoofType();
	}

	@Override
	public Length getMeasuredHeight() {
		if (abstractBuilding.isSetMeasuredHeight())
			return new LengthImpl(abstractBuilding.getMeasuredHeight());

		return null;
	}

	@Override
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

	@Override
	public MeasureOrNullList getStoreyHeightsAboveGround() {
		if (abstractBuilding.isSetStoreyHeightsAboveGround())
			return new MeasureOrNullListImpl(abstractBuilding.getStoreyHeightsAboveGround());

		return null;
	}

	@Override
	public MeasureOrNullList getStoreyHeightsBelowGround() {
		if (abstractBuilding.isSetStoreyHeightsBelowGround())
			return new MeasureOrNullListImpl(abstractBuilding.getStoreyHeightsBelowGround());

		return null;
	}

	@Override
	public SolidProperty getLod1Solid() {
		if (abstractBuilding.isSetLod1Solid())
			return new SolidPropertyImpl(abstractBuilding.getLod1Solid());

		return null;
	}

	@Override
	public SolidProperty getLod2Solid() {
		if (abstractBuilding.isSetLod2Solid())
			return new SolidPropertyImpl(abstractBuilding.getLod2Solid());

		return null;
	}

	@Override
	public SolidProperty getLod3Solid() {
		if (abstractBuilding.isSetLod3Solid())
			return new SolidPropertyImpl(abstractBuilding.getLod3Solid());

		return null;
	}

	@Override
	public SolidProperty getLod4Solid() {
		if (abstractBuilding.isSetLod4Solid())
			return new SolidPropertyImpl(abstractBuilding.getLod4Solid());

		return null;
	}

	@Override
	public MultiCurveProperty getLod1TerrainIntersection() {
		if (abstractBuilding.isSetLod1TerrainIntersection())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod1TerrainIntersection());

		return null;
	}

	@Override
	public MultiCurveProperty getLod2TerrainIntersection() {
		if (abstractBuilding.isSetLod2TerrainIntersection())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod2TerrainIntersection());

		return null;
	}

	@Override
	public MultiCurveProperty getLod3TerrainIntersection() {
		if (abstractBuilding.isSetLod3TerrainIntersection())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod3TerrainIntersection());

		return null;
	}

	@Override
	public MultiCurveProperty getLod4TerrainIntersection() {
		if (abstractBuilding.isSetLod4TerrainIntersection())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod4TerrainIntersection());

		return null;
	}

	@Override
	public MultiCurveProperty getLod2MultiCurve() {
		if (abstractBuilding.isSetLod2MultiCurve())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod2MultiCurve());

		return null;
	}

	@Override
	public MultiCurveProperty getLod3MultiCurve() {
		if (abstractBuilding.isSetLod3MultiCurve())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod3MultiCurve());

		return null;
	}

	@Override
	public MultiCurveProperty getLod4MultiCurve() {
		if (abstractBuilding.isSetLod4MultiCurve())
			return new MultiCurvePropertyImpl(abstractBuilding.getLod4MultiCurve());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod1MultiSurface() {
		if (abstractBuilding.isSetLod1MultiSurface())
			return new MultiSurfacePropertyImpl(abstractBuilding.getLod1MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod2MultiSurface() {
		if (abstractBuilding.isSetLod2MultiSurface())
			return new MultiSurfacePropertyImpl(abstractBuilding.getLod2MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod3MultiSurface() {
		if (abstractBuilding.isSetLod3MultiSurface())
			return new MultiSurfacePropertyImpl(abstractBuilding.getLod3MultiSurface());

		return null;
	}

	@Override
	public MultiSurfaceProperty getLod4MultiSurface() {
		if (abstractBuilding.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(abstractBuilding.getLod4MultiSurface());

		return null;
	}

	@Override
	public List<BoundarySurfaceProperty> getBoundedBySurfaces() {
		List<BoundarySurfaceProperty> boundarySurfacePropertyList = new ArrayList<BoundarySurfaceProperty>();

		for (BoundarySurfacePropertyType boundarySurfacePropertyType : abstractBuilding.getBoundedBySurfaces())
			boundarySurfacePropertyList.add(new BoundarySurfacePropertyImpl(boundarySurfacePropertyType));

		return boundarySurfacePropertyList;
	}

	@Override
	public List<BuildingInstallationProperty> getOuterBuildingInstallation() {
		List<BuildingInstallationProperty> buildingInstallationPropertyList = new ArrayList<BuildingInstallationProperty>();

		for (BuildingInstallationPropertyType buildingInstallationPropertyType : abstractBuilding.getOuterBuildingInstallation())
			buildingInstallationPropertyList.add(new BuildingInstallationPropertyImpl(buildingInstallationPropertyType));

		return buildingInstallationPropertyList;
	}

	@Override
	public List<IntBuildingInstallationProperty> getInteriorBuildingInstallation() {
		List<IntBuildingInstallationProperty> intBuildingInstallationPropertyList = new ArrayList<IntBuildingInstallationProperty>();

		for (IntBuildingInstallationPropertyType intBuildingInstallationPropertyType : abstractBuilding.getInteriorBuildingInstallation())
			intBuildingInstallationPropertyList.add(new IntBuildingInstallationPropertyImpl(intBuildingInstallationPropertyType));

		return intBuildingInstallationPropertyList;
	}

	@Override
	public List<BuildingPartProperty> getConsistsOfBuildingPart() {
		List<BuildingPartProperty> buildingPartPropertyList = new ArrayList<BuildingPartProperty>();

		for (BuildingPartPropertyType buildingPartPropertyType : abstractBuilding.getConsistsOfBuildingPart())
			buildingPartPropertyList.add(new BuildingPartPropertyImpl(buildingPartPropertyType));

		return buildingPartPropertyList;
	}

	@Override
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

	@Override
	public void addFunction(String function) {
		abstractBuilding.getFunction().add(function);
	}

	@Override
	public void addUsage(String usage) {
		abstractBuilding.getUsage().add(usage);
	}

	@Override
	public void setClazz(String clazz) {
		abstractBuilding.setClazz(clazz);
	}

	@Override
	public void setFunction(List<String> function) {
		abstractBuilding.unsetFunction();
		abstractBuilding.getFunction().addAll(function);
	}

	@Override
	public void setUsage(List<String> usage) {
		abstractBuilding.unsetUsage();
		abstractBuilding.getUsage().addAll(usage);
	}

	@Override
	public void setRoofType(String roofType) {
		abstractBuilding.setRoofType(roofType);
	}

	@Override
	public void setYearOfConstruction(XMLGregorianCalendar yearOfConstruction) {
		abstractBuilding.setYearOfConstruction(yearOfConstruction);
	}

	@Override
	public void setYearOfDemolition(XMLGregorianCalendar yearOfDemolition) {
		abstractBuilding.setYearOfDemolition(yearOfDemolition);
	}

	@Override
	public void setMeasuredHeight(Length length) {
		abstractBuilding.setMeasuredHeight(((LengthImpl)length).getJAXBObject());
	}

	@Override
	public void setStoreyHeightsAboveGround(MeasureOrNullList storeysHeightsAboveGround) {
		abstractBuilding.setStoreyHeightsAboveGround(((MeasureOrNullListImpl)storeysHeightsAboveGround).getJAXBObject());
	}

	@Override
	public void setStoreyHeightsBelowGround(MeasureOrNullList storeysBelowAboveGround) {
		abstractBuilding.setStoreyHeightsBelowGround(((MeasureOrNullListImpl)storeysBelowAboveGround).getJAXBObject());
	}

	@Override
	public void setStoreysAboveGround(Integer storeysAboveGround) {
		abstractBuilding.setStoreysAboveGround(new BigInteger(storeysAboveGround.toString()));
	}

	@Override
	public void setStoreysBelowGround(Integer storeysBelowGround) {
		abstractBuilding.setStoreysBelowGround(new BigInteger(storeysBelowGround.toString()));
	}

	@Override
	public void setLod1Solid(SolidProperty lod1Solid) {
		abstractBuilding.setLod1Solid(((SolidPropertyImpl)lod1Solid).getJAXBObject());
	}

	@Override
	public void setLod2Solid(SolidProperty lod2Solid) {
		abstractBuilding.setLod2Solid(((SolidPropertyImpl)lod2Solid).getJAXBObject());
	}

	@Override
	public void setLod3Solid(SolidProperty lod3Solid) {
		abstractBuilding.setLod3Solid(((SolidPropertyImpl)lod3Solid).getJAXBObject());
	}

	@Override
	public void setLod4Solid(SolidProperty lod4Solid) {
		abstractBuilding.setLod4Solid(((SolidPropertyImpl)lod4Solid).getJAXBObject());
	}

	@Override
	public void setLod1MultiSurface(MultiSurfaceProperty lod1MultiSurface) {
		abstractBuilding.setLod1MultiSurface(((MultiSurfacePropertyImpl)lod1MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod2MultiSurface(MultiSurfaceProperty lod2MultiSurface) {
		abstractBuilding.setLod2MultiSurface(((MultiSurfacePropertyImpl)lod2MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod3MultiSurface(MultiSurfaceProperty lod3MultiSurface) {
		abstractBuilding.setLod3MultiSurface(((MultiSurfacePropertyImpl)lod3MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		abstractBuilding.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	@Override
	public void addInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation) {
		abstractBuilding.getInteriorBuildingInstallation().add(((IntBuildingInstallationPropertyImpl)interiorBuildingInstallation).getJAXBObject());
	}

	@Override
	public void addOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation) {
		abstractBuilding.getOuterBuildingInstallation().add(((BuildingInstallationPropertyImpl)outerBuildingInstallation).getJAXBObject());
	}

	@Override
	public void setInteriorBuildingInstallation(List<IntBuildingInstallationProperty> interiorBuildingInstallation) {
		List<IntBuildingInstallationPropertyType> intInstPropList = new ArrayList<IntBuildingInstallationPropertyType>();

		for (IntBuildingInstallationProperty intInstProp : interiorBuildingInstallation)
			intInstPropList.add(((IntBuildingInstallationPropertyImpl)intInstProp).getJAXBObject());

		abstractBuilding.unsetInteriorBuildingInstallation();
		abstractBuilding.getInteriorBuildingInstallation().addAll(intInstPropList);
	}

	@Override
	public void setOuterBuildingInstallation(List<BuildingInstallationProperty> outerBuildingInstallation) {
		List<BuildingInstallationPropertyType> instPropList = new ArrayList<BuildingInstallationPropertyType>();

		for (BuildingInstallationProperty instProp : outerBuildingInstallation)
			instPropList.add(((BuildingInstallationPropertyImpl)instProp).getJAXBObject());

		abstractBuilding.unsetOuterBuildingInstallation();
		abstractBuilding.getOuterBuildingInstallation().addAll(instPropList);
	}

	@Override
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		abstractBuilding.getBoundedBySurfaces().add(((BoundarySurfacePropertyImpl)boundedBySurface).getJAXBObject());
	}

	@Override
	public void setBoundedBySurfaces(List<BoundarySurfaceProperty> boundedBySurfaces) {
		List<BoundarySurfacePropertyType> boundSurfPropTypeList = new ArrayList<BoundarySurfacePropertyType>();

		for (BoundarySurfaceProperty boundSurfProp : boundedBySurfaces)
			boundSurfPropTypeList.add(((BoundarySurfacePropertyImpl)boundSurfProp).getJAXBObject());

		abstractBuilding.unsetBoundedBySurfaces();
		abstractBuilding.getBoundedBySurfaces().addAll(boundSurfPropTypeList);
	}

	@Override
	public void addInteriorRoom(InteriorRoomProperty interiorRoom) {
		abstractBuilding.getInteriorRoom().add(((InteriorRoomPropertyImpl)interiorRoom).getJAXBObject());
	}

	@Override
	public void setInteriorRoom(List<InteriorRoomProperty> interiorRoom) {
		List<InteriorRoomPropertyType> intRoomPropTypeList = new ArrayList<InteriorRoomPropertyType>();

		for (InteriorRoomProperty intRoomProp : interiorRoom)
			intRoomPropTypeList.add(((InteriorRoomPropertyImpl)intRoomProp).getJAXBObject());

		abstractBuilding.unsetInteriorRoom();
		abstractBuilding.getInteriorRoom().addAll(intRoomPropTypeList);
	}

	@Override
	public void addConsistsOfBuildingPart(BuildingPartProperty buildingPart) {
		abstractBuilding.getConsistsOfBuildingPart().add(((BuildingPartPropertyImpl)buildingPart).getJAXBObject());
	}

	@Override
	public void setConsistsOfBuildingPart(List<BuildingPartProperty> buildingPart) {
		List<BuildingPartPropertyType> buildPartPropTypeList = new ArrayList<BuildingPartPropertyType>();

		for (BuildingPartProperty buildingPartProp : buildingPart)
			buildPartPropTypeList.add(((BuildingPartPropertyImpl)buildingPartProp).getJAXBObject());

		abstractBuilding.unsetConsistsOfBuildingPart();
		abstractBuilding.getConsistsOfBuildingPart().addAll(buildPartPropTypeList);

	}

	@Override
	public void addAddress(AddressProperty address) {
		abstractBuilding.getAddress().add(((AddressPropertyImpl)address).getJAXBObject());
	}

	@Override
	public List<AddressProperty> getAddress() {
		List<AddressProperty> addressPropertyList = new ArrayList<AddressProperty>();

		for (AddressPropertyType addressPropertyType : abstractBuilding.getAddress())
			addressPropertyList.add(new AddressPropertyImpl(addressPropertyType));

		return addressPropertyList;
	}

	@Override
	public void setAddress(List<AddressProperty> address) {
		List<AddressPropertyType> addressPropertyTypeList = new ArrayList<AddressPropertyType>();

		for (AddressProperty addressProperty : address)
			addressPropertyTypeList.add(((AddressPropertyImpl)addressProperty).getJAXBObject());

		abstractBuilding.unsetAddress();
		abstractBuilding.getAddress().addAll(addressPropertyTypeList);
	}

	@Override
	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection) {
		abstractBuilding.setLod1TerrainIntersection(((MultiCurvePropertyImpl)lod1TerrainIntersection).getJAXBObject());
	}

	@Override
	public void setLod2MultiCurve(MultiCurveProperty lod2MultiCurve) {
		abstractBuilding.setLod2MultiCurve(((MultiCurvePropertyImpl)lod2MultiCurve).getJAXBObject());
	}

	@Override
	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection) {
		abstractBuilding.setLod2TerrainIntersection(((MultiCurvePropertyImpl)lod2TerrainIntersection).getJAXBObject());
	}

	@Override
	public void setLod3MultiCurve(MultiCurveProperty lod3MultiCurve) {
		abstractBuilding.setLod3MultiCurve(((MultiCurvePropertyImpl)lod3MultiCurve).getJAXBObject());
	}

	@Override
	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection) {
		abstractBuilding.setLod3TerrainIntersection(((MultiCurvePropertyImpl)lod3TerrainIntersection).getJAXBObject());
	}

	@Override
	public void setLod4MultiCurve(MultiCurveProperty lod4MultiCurve) {
		abstractBuilding.setLod4MultiCurve(((MultiCurvePropertyImpl)lod4MultiCurve).getJAXBObject());
	}

	@Override
	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection) {
		abstractBuilding.setLod4TerrainIntersection(((MultiCurvePropertyImpl)lod4TerrainIntersection).getJAXBObject());
	}

	@Override
	public void addGenericApplicationPropertyOfAbstractBuilding(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			abstractBuilding.get_GenericApplicationPropertyOfAbstractBuilding().add(jaxbElem);
	}

	@Override
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

	@Override
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

	@Override
	public boolean isSetAddress() {
		return abstractBuilding.isSetAddress();
	}

	@Override
	public boolean isSetBoundedBySurfaces() {
		return abstractBuilding.isSetBoundedBySurfaces();
	}

	@Override
	public boolean isSetClazz() {
		return abstractBuilding.isSetClazz();
	}

	@Override
	public boolean isSetConsistsOfBuildingPart() {
		return abstractBuilding.isSetConsistsOfBuildingPart();
	}

	@Override
	public boolean isSetFunction() {
		return abstractBuilding.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfAbstractBuilding() {
		return abstractBuilding.isSet_GenericApplicationPropertyOfAbstractBuilding();
	}

	@Override
	public boolean isSetLod1MultiSurface() {
		return abstractBuilding.isSetLod1MultiSurface();
	}

	@Override
	public boolean isSetLod1TerrainIntersection() {
		return abstractBuilding.isSetLod1TerrainIntersection();
	}

	@Override
	public boolean isSetLod2MultiCurve() {
		return abstractBuilding.isSetLod2MultiCurve();
	}

	@Override
	public boolean isSetLod2MultiSurface() {
		return abstractBuilding.isSetLod2MultiSurface();
	}

	@Override
	public boolean isSetLod2TerrainIntersection() {
		return abstractBuilding.isSetLod2TerrainIntersection();
	}

	@Override
	public boolean isSetLod3MultiCurve() {
		return abstractBuilding.isSetLod3MultiCurve();
	}

	@Override
	public boolean isSetLod3MultiSurface() {
		return abstractBuilding.isSetLod3MultiSurface();
	}

	@Override
	public boolean isSetLod3TerrainIntersection() {
		return abstractBuilding.isSetLod3TerrainIntersection();
	}

	@Override
	public boolean isSetLod4MultiCurve() {
		return abstractBuilding.isSetLod4MultiCurve();
	}

	@Override
	public boolean isSetLod4MultiSurface() {
		return abstractBuilding.isSetLod4MultiSurface();
	}

	@Override
	public boolean isSetLod4TerrainIntersection() {
		return abstractBuilding.isSetLod4TerrainIntersection();
	}

	@Override
	public boolean isSetInteriorBuildingInstallation() {
		return abstractBuilding.isSetInteriorBuildingInstallation();
	}

	@Override
	public boolean isSetInteriorRoom() {
		return abstractBuilding.isSetInteriorRoom();
	}

	@Override
	public boolean isSetLod1Solid() {
		return abstractBuilding.isSetLod1Solid();
	}

	@Override
	public boolean isSetLod2Solid() {
		return abstractBuilding.isSetLod2Solid();
	}

	@Override
	public boolean isSetLod3Solid() {
		return abstractBuilding.isSetLod3Solid();
	}

	@Override
	public boolean isSetLod4Solid() {
		return abstractBuilding.isSetLod4Solid();
	}

	@Override
	public boolean isSetMeasuredHeight() {
		return abstractBuilding.isSetMeasuredHeight();
	}

	@Override
	public boolean isSetOuterBuildingInstallation() {
		return abstractBuilding.isSetOuterBuildingInstallation();
	}

	@Override
	public boolean isSetRoofType() {
		return abstractBuilding.isSetRoofType();
	}

	@Override
	public boolean isSetStoreyHeightsAboveGround() {
		return abstractBuilding.isSetStoreyHeightsAboveGround();
	}

	@Override
	public boolean isSetStoreyHeightsBelowGround() {
		return abstractBuilding.isSetStoreyHeightsBelowGround();
	}

	@Override
	public boolean isSetStoreysAboveGround() {
		return abstractBuilding.isSetStoreysAboveGround();
	}

	@Override
	public boolean isSetStoreysBelowGround() {
		return abstractBuilding.isSetStoreysBelowGround();
	}

	@Override
	public boolean isSetUsage() {
		return abstractBuilding.isSetUsage();
	}

	@Override
	public boolean isSetYearOfConstruction() {
		return abstractBuilding.isSetYearOfConstruction();
	}

	@Override
	public boolean isSetYearOfDemolition() {
		return abstractBuilding.isSetYearOfDemolition();
	}

	@Override
	public void unsetAddress() {
		abstractBuilding.unsetAddress();
	}

	@Override
	public void unsetBoundedBySurfaces() {
		abstractBuilding.unsetBoundedBySurfaces();
	}

	@Override
	public void unsetClazz() {
		abstractBuilding.setClazz(null);
	}

	@Override
	public void unsetConsistsOfBuildingPart() {
		abstractBuilding.unsetConsistsOfBuildingPart();
	}

	@Override
	public void unsetFunction() {
		abstractBuilding.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfAbstractBuilding() {
		abstractBuilding.unset_GenericApplicationPropertyOfAbstractBuilding();
	}

	@Override
	public void unsetLod1MultiSurface() {
		abstractBuilding.setLod1MultiSurface(null);
	}

	@Override
	public void unsetLod1TerrainIntersection() {
		abstractBuilding.setLod1TerrainIntersection(null);
	}

	@Override
	public void unsetLod2MultiCurve() {
		abstractBuilding.setLod2MultiCurve(null);
	}

	@Override
	public void unsetLod2MultiSurface() {
		abstractBuilding.setLod2MultiSurface(null);
	}

	@Override
	public void unsetLod2TerrainIntersection() {
		abstractBuilding.setLod2TerrainIntersection(null);
	}

	@Override
	public void unsetLod3MultiCurve() {
		abstractBuilding.setLod3MultiCurve(null);
	}

	@Override
	public void unsetLod3MultiSurface() {
		abstractBuilding.setLod3MultiSurface(null);
	}

	@Override
	public void unsetLod3TerrainIntersection() {
		abstractBuilding.setLod3TerrainIntersection(null);
	}

	@Override
	public void unsetLod4MultiCurve() {
		abstractBuilding.setLod4MultiCurve(null);
	}

	@Override
	public void unsetLod4MultiSurface() {
		abstractBuilding.setLod4MultiSurface(null);
	}

	@Override
	public void unsetLod4TerrainIntersection() {
		abstractBuilding.setLod4TerrainIntersection(null);
	}

	@Override
	public void unsetInteriorBuildingInstallation() {
		abstractBuilding.unsetInteriorBuildingInstallation();
	}

	@Override
	public void unsetInteriorRoom() {
		abstractBuilding.unsetInteriorRoom();
	}

	@Override
	public void unsetLod1Solid() {
		abstractBuilding.setLod1Solid(null);
	}

	@Override
	public void unsetLod2Solid() {
		abstractBuilding.setLod2Solid(null);
	}

	@Override
	public void unsetLod3Solid() {
		abstractBuilding.setLod3Solid(null);
	}

	@Override
	public void unsetLod4Solid() {
		abstractBuilding.setLod4Solid(null);
	}

	@Override
	public void unsetMeasuredHeight() {
		abstractBuilding.setMeasuredHeight(null);
	}

	@Override
	public void unsetOuterBuildingInstallation() {
		abstractBuilding.unsetOuterBuildingInstallation();
	}

	@Override
	public void unsetRoofType() {
		abstractBuilding.setRoofType(null);
	}

	@Override
	public void unsetStoreyHeightsAboveGround() {
		abstractBuilding.setStoreyHeightsAboveGround(null);
	}

	@Override
	public void unsetStoreyHeightsBelowGround() {
		abstractBuilding.setStoreyHeightsBelowGround(null);
	}

	@Override
	public void unsetStoreysAboveGround() {
		abstractBuilding.setStoreysAboveGround(null);
	}

	@Override
	public void unsetStoreysBelowGround() {
		abstractBuilding.setStoreysBelowGround(null);
	}

	@Override
	public void unsetUsage() {
		abstractBuilding.unsetUsage();
	}

	@Override
	public void unsetYearOfConstruction() {
		abstractBuilding.setYearOfConstruction(null);
	}

	@Override
	public void unsetYearOfDemolition() {
		abstractBuilding.setYearOfDemolition(null);
	}

	@Override
	public boolean unsetAddress(AddressProperty address) {
		if (abstractBuilding.isSetAddress())
			return abstractBuilding.getAddress().remove(((AddressPropertyImpl)address).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetBoundedBySurfaces(BoundarySurfaceProperty boundedBySurface) {
		if (abstractBuilding.isSetBoundedBySurfaces())
			return abstractBuilding.getBoundedBySurfaces().remove(((BoundarySurfacePropertyImpl)boundedBySurface).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetConsistsOfBuildingPart(BuildingPartProperty buildingPart) {
		if (abstractBuilding.isSetConsistsOfBuildingPart())
			return abstractBuilding.getConsistsOfBuildingPart().remove(((BuildingPartImpl)buildingPart).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetFunction(String function) {
		if (abstractBuilding.isSetFunction())
			return abstractBuilding.getFunction().remove(function);
		
		return false;
	}

	@Override
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

	@Override
	public boolean unsetInteriorBuildingInstallation(IntBuildingInstallationProperty interiorBuildingInstallation) {
		if (abstractBuilding.isSetInteriorBuildingInstallation())
			return abstractBuilding.getInteriorBuildingInstallation().remove(((IntBuildingInstallationPropertyImpl)interiorBuildingInstallation).getJAXBObject());
			
		return false;
	}

	@Override
	public boolean unsetInteriorRoom(InteriorRoomProperty interiorRoom) {
		if (abstractBuilding.isSetInteriorRoom())
			return abstractBuilding.getInteriorRoom().remove(((InteriorRoomPropertyImpl)interiorRoom).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetOuterBuildingInstallation(BuildingInstallationProperty outerBuildingInstallation) {
		if (abstractBuilding.isSetOuterBuildingInstallation())
			return abstractBuilding.getOuterBuildingInstallation().remove(((BuildingInstallationPropertyImpl)outerBuildingInstallation).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetUsage(String usage) {
		if (abstractBuilding.isSetUsage())
			return abstractBuilding.getUsage().remove(usage);
		
		return false;
	}
	
}
