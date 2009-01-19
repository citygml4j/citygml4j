package org.citygml4j.impl.jaxb.citygml.building._1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._1.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SolidPropertyImpl;
import org.citygml4j.jaxb.citygml.bldg._1.BoundarySurfacePropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.IntBuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.InteriorFurniturePropertyType;
import org.citygml4j.jaxb.citygml.bldg._1.RoomType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.SolidProperty;

public class RoomImpl extends CityObjectImpl implements Room {
	private RoomType roomType;

	public RoomImpl() {
		this(new RoomType());
	}

	public RoomImpl(RoomType roomType) {
		super(roomType);
		this.roomType = roomType;
	}

	@Override
	public RoomType getJAXBObject() {
		return roomType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ROOM;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v1_0_0;
	}

	@Override
	public List<BoundarySurfaceProperty> getBoundedBySurfaces() {
		List<BoundarySurfaceProperty> boundarySurfacePropertyList = new ArrayList<BoundarySurfaceProperty>();

		for (BoundarySurfacePropertyType boundarySurfacePropertyType : roomType.getBoundedBySurfaces())
			boundarySurfacePropertyList.add(new BoundarySurfacePropertyImpl(boundarySurfacePropertyType));

		return boundarySurfacePropertyList;
	}

	@Override
	public String getClazz() {
		return roomType.getClazz();
	}

	@Override
	public List<String> getFunction() {
		return roomType.getFunction();
	}

	@Override
	public MultiSurfaceProperty getLod4MultiSurface() {
		if (roomType.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(roomType.getLod4MultiSurface());

		return null;
	}

	@Override
	public SolidProperty getLod4Solid() {
		if (roomType.isSetLod4Solid())
			return new SolidPropertyImpl(roomType.getLod4Solid());

		return null;
	}

	@Override
	public List<String> getUsage() {
		return roomType.getUsage();
	}

	@Override
	public List<InteriorFurnitureProperty> getInteriorFurniture() {
		List<InteriorFurnitureProperty> interiorFurniturePropertyList = new ArrayList<InteriorFurnitureProperty>();

		for (InteriorFurniturePropertyType interiorFurniturePropertyType : roomType.getInteriorFurniture())
			interiorFurniturePropertyList.add(new InteriorFurniturePropertyImpl(interiorFurniturePropertyType));

		return interiorFurniturePropertyList;
	}

	@Override
	public List<IntBuildingInstallationProperty> getRoomInstallation() {
		List<IntBuildingInstallationProperty> intBuildingInstallationPropertyList = new ArrayList<IntBuildingInstallationProperty>();

		for (IntBuildingInstallationPropertyType intBuildingInstallationPropertyType : roomType.getRoomInstallation())
			intBuildingInstallationPropertyList.add(new IntBuildingInstallationPropertyImpl(intBuildingInstallationPropertyType));

		return intBuildingInstallationPropertyList;
	}

	@Override
	public void calcBoundedBy() {
		if (getLod4MultiSurface() != null) {
			MultiSurfaceProperty multiSurfaceProperty = getLod4MultiSurface();
			MultiSurface multiSurface = multiSurfaceProperty.getMultiSurface();
			if (multiSurface != null) {
				calcBoundedBy(multiSurface);
			} else {
				// xlink?
			}
		}

		if (getLod4Solid() != null) {
			SolidProperty solidProperty = getLod4Solid();
			AbstractSolid abstractSolid = solidProperty.getSolid();
			if (abstractSolid != null) {
				calcBoundedBy(abstractSolid);
			} else {
				// xlink?
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
	}

	@Override
	public void addFunction(String function) {
		roomType.getFunction().add(function);
	}

	@Override
	public void addUsage(String usage) {
		roomType.getUsage().add(usage);
	}

	@Override
	public void setClazz(String clazz) {
		roomType.setClazz(clazz);
	}

	@Override
	public void setFunction(List<String> function) {
		roomType.unsetFunction();
		roomType.getFunction().addAll(function);
	}

	@Override
	public void setUsage(List<String> usage) {
		roomType.unsetUsage();
		roomType.getUsage().addAll(usage);
	}

	@Override
	public void addRoomInstallation(IntBuildingInstallationProperty roomInstallation) {
		roomType.getRoomInstallation().add(((IntBuildingInstallationPropertyImpl)roomInstallation).getJAXBObject());
	}

	@Override
	public void setRoomInstallation(List<IntBuildingInstallationProperty> roomInstallation) {
		List<IntBuildingInstallationPropertyType> intInstPropList = new ArrayList<IntBuildingInstallationPropertyType>();

		for (IntBuildingInstallationProperty intInstProp : roomInstallation)
			intInstPropList.add(((IntBuildingInstallationPropertyImpl)intInstProp).getJAXBObject());

		roomType.unsetRoomInstallation();
		roomType.getRoomInstallation().addAll(intInstPropList);
	}

	@Override
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		roomType.getBoundedBySurfaces().add(((BoundarySurfacePropertyImpl)boundedBySurface).getJAXBObject());
	}

	@Override
	public void setBoundedBySurfaces(List<BoundarySurfaceProperty> boundedBySurfaces) {
		List<BoundarySurfacePropertyType> boundSurfPropTypeList = new ArrayList<BoundarySurfacePropertyType>();

		for (BoundarySurfaceProperty boundSurfProp : boundedBySurfaces)
			boundSurfPropTypeList.add(((BoundarySurfacePropertyImpl)boundSurfProp).getJAXBObject());

		roomType.unsetBoundedBySurfaces();
		roomType.getBoundedBySurfaces().addAll(boundSurfPropTypeList);
	}

	@Override
	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		roomType.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	@Override
	public void setLod4Solid(SolidProperty lod4Solid) {
		roomType.setLod4Solid(((SolidPropertyImpl)lod4Solid).getJAXBObject());
	}

	@Override
	public void addInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		roomType.getInteriorFurniture().add(((InteriorFurniturePropertyImpl)interiorFurniture).getJAXBObject());
	}

	@Override
	public void setInteriorFurniture(List<InteriorFurnitureProperty> interiorFurniture) {
		List<InteriorFurniturePropertyType> intFurniturePropTypeList = new ArrayList<InteriorFurniturePropertyType>();

		for (InteriorFurnitureProperty intFurnitureProp : interiorFurniture)
			intFurniturePropTypeList.add(((InteriorFurniturePropertyImpl)intFurnitureProp).getJAXBObject());

		roomType.unsetInteriorFurniture();
		roomType.getInteriorFurniture().addAll(intFurniturePropTypeList);
	}

	@Override
	public void addGenericApplicationPropertyOfRoom(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			roomType.get_GenericApplicationPropertyOfRoom().add(jaxbElem);
	}

	@Override
	public List<ADEComponent> getGenericApplicationPropertyOfRoom() {
		List<ADEComponent> adeList = new ArrayList<ADEComponent>();

		for (JAXBElement<?> elem : roomType.get_GenericApplicationPropertyOfRoom()) {
			if (elem.getValue() != null) {
				ADEComponent ade = ModelMapper.ADE.toADEComponent(elem.getValue(), elem.getName());
				if (ade != null)
					adeList.add(ade);
			}
		}

		return adeList;
	}

	@Override
	public void setGenericApplicationPropertyOfRoom(List<ADEComponent> adeObject) {
		List<JAXBElement<?>> elemList = new ArrayList<JAXBElement<?>>();

		for (ADEComponent ade : adeObject) {
			JAXBElement<?> elem = ModelMapper.ADE.toJAXB(ade);
			if (elem != null)
				elemList.add(elem);
		}

		if (!elemList.isEmpty()) {
			roomType.unset_GenericApplicationPropertyOfRoom();
			roomType.get_GenericApplicationPropertyOfRoom().addAll(elemList);
		}
	}

	@Override
	public boolean isSetBoundedBySurfaces() {
		return roomType.isSetBoundedBySurfaces();
	}

	@Override
	public boolean isSetClazz() {
		return roomType.isSetClazz();
	}

	@Override
	public boolean isSetFunction() {
		return roomType.isSetFunction();
	}

	@Override
	public boolean isSetGenericApplicationPropertyOfRoom() {
		return roomType.isSet_GenericApplicationPropertyOfRoom();
	}

	@Override
	public boolean isSetInteriorFurniture() {
		return roomType.isSetInteriorFurniture();
	}

	@Override
	public boolean isSetLod4MultiSurface() {
		return roomType.isSetLod4MultiSurface();
	}

	@Override
	public boolean isSetLod4Solid() {
		return roomType.isSetLod4Solid();
	}

	@Override
	public boolean isSetRoomInstallation() {
		return roomType.isSetRoomInstallation();
	}

	@Override
	public boolean isSetUsage() {
		return roomType.isSetUsage();
	}

	@Override
	public void unsetBoundedBySurfaces() {
		roomType.unsetBoundedBySurfaces();
	}

	@Override
	public void unsetClazz() {
		roomType.setClazz(null);
	}

	@Override
	public void unsetFunction() {
		roomType.unsetFunction();
	}

	@Override
	public void unsetGenericApplicationPropertyOfRoom() {
		roomType.unset_GenericApplicationPropertyOfRoom();
	}

	@Override
	public void unsetInteriorFurniture() {
		roomType.unsetInteriorFurniture();
	}

	@Override
	public void unsetLod4MultiSurface() {
		roomType.setLod4MultiSurface(null);
	}

	@Override
	public void unsetLod4Solid() {
		roomType.setLod4Solid(null);
	}

	@Override
	public void unsetRoomInstallation() {
		roomType.unsetRoomInstallation();
	}

	@Override
	public void unsetUsage() {
		roomType.unsetUsage();
	}

	@Override
	public boolean unsetBoundedBySurfaces(BoundarySurfaceProperty boundedBySurface) {
		if (roomType.isSetBoundedBySurfaces())
			return roomType.getBoundedBySurfaces().remove(((BoundarySurfacePropertyImpl)boundedBySurface).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetFunction(String function) {
		if (roomType.isSetFunction())
			return roomType.getFunction().remove(function);
		
		return false;
	}

	@Override
	public boolean unsetGenericApplicationPropertyOfRoom(ADEComponent adeObject) {
		if (roomType.isSet_GenericApplicationPropertyOfRoom()) {
			Iterator<JAXBElement<?>> iter = roomType.get_GenericApplicationPropertyOfRoom().iterator();
			while (iter.hasNext()) {
				JAXBElement<?> elem = iter.next();
				if (elem.getValue() != null && elem.getValue().equals(adeObject.getJAXBObject())) {
					iter.remove();
					return true;
				}
			}				
		}

		return false;
	}

	@Override
	public boolean unsetInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		if (roomType.isSetInteriorFurniture())
			return roomType.getInteriorFurniture().remove(((InteriorFurniturePropertyImpl)interiorFurniture).getJAXBObject());
			
		return false;
	}

	@Override
	public boolean unsetRoomInstallation(IntBuildingInstallationProperty roomInstallation) {
		if (roomType.isSetRoomInstallation())
			return roomType.getRoomInstallation().remove(((IntBuildingInstallationPropertyImpl)roomInstallation).getJAXBObject());
		
		return false;
	}

	@Override
	public boolean unsetUsage(String usage) {
		if (roomType.isSetUsage())
			return roomType.getUsage().remove(usage);
		
		return false;
	}
	
}
