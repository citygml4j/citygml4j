package org.citygml4j.impl.jaxb.citygml.building._0_4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SolidPropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.BoundarySurfacePropertyType;
import org.citygml4j.jaxb.citygml._0_4.IntBuildingInstallationPropertyType;
import org.citygml4j.jaxb.citygml._0_4.InteriorFurniturePropertyType;
import org.citygml4j.jaxb.citygml._0_4.RoomType;
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
		return BuildingModule.v0_4_0;
	}

	public List<BoundarySurfaceProperty> getBoundedBySurfaces() {
		List<BoundarySurfaceProperty> boundarySurfacePropertyList = new ArrayList<BoundarySurfaceProperty>();

		for (BoundarySurfacePropertyType boundarySurfacePropertyType : roomType.getBoundedBySurfaces())
			boundarySurfacePropertyList.add(new BoundarySurfacePropertyImpl(boundarySurfacePropertyType));

		return boundarySurfacePropertyList;
	}

	public String getClazz() {
		return roomType.getClazz();
	}

	public List<String> getFunction() {
		return roomType.getFunction();
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		if (roomType.isSetLod4MultiSurface())
			return new MultiSurfacePropertyImpl(roomType.getLod4MultiSurface());

		return null;
	}

	public SolidProperty getLod4Solid() {
		if (roomType.isSetLod4Solid())
			return new SolidPropertyImpl(roomType.getLod4Solid());

		return null;
	}

	public List<String> getUsage() {
		return roomType.getUsage();
	}

	public List<InteriorFurnitureProperty> getInteriorFurniture() {
		List<InteriorFurnitureProperty> interiorFurniturePropertyList = new ArrayList<InteriorFurnitureProperty>();

		for (InteriorFurniturePropertyType interiorFurniturePropertyType : roomType.getInteriorFurniture())
			interiorFurniturePropertyList.add(new InteriorFurniturePropertyImpl(interiorFurniturePropertyType));

		return interiorFurniturePropertyList;
	}

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

	public void addFunction(String function) {
		roomType.getFunction().add(function);
	}

	public void addUsage(String usage) {
		roomType.getUsage().add(usage);
	}

	public void setClazz(String clazz) {
		roomType.setClazz(clazz);
	}

	public void setFunction(List<String> function) {
		roomType.unsetFunction();
		roomType.getFunction().addAll(function);
	}

	public void setUsage(List<String> usage) {
		roomType.unsetUsage();
		roomType.getUsage().addAll(usage);
	}

	public void addRoomInstallation(IntBuildingInstallationProperty roomInstallation) {
		roomType.getRoomInstallation().add(((IntBuildingInstallationPropertyImpl)roomInstallation).getJAXBObject());
	}

	public void setRoomInstallation(List<IntBuildingInstallationProperty> roomInstallation) {
		List<IntBuildingInstallationPropertyType> intInstPropList = new ArrayList<IntBuildingInstallationPropertyType>();

		for (IntBuildingInstallationProperty intInstProp : roomInstallation)
			intInstPropList.add(((IntBuildingInstallationPropertyImpl)intInstProp).getJAXBObject());

		roomType.unsetRoomInstallation();
		roomType.getRoomInstallation().addAll(intInstPropList);
	}

	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		roomType.getBoundedBySurfaces().add(((BoundarySurfacePropertyImpl)boundedBySurface).getJAXBObject());
	}

	public void setBoundedBySurfaces(List<BoundarySurfaceProperty> boundedBySurfaces) {
		List<BoundarySurfacePropertyType> boundSurfPropTypeList = new ArrayList<BoundarySurfacePropertyType>();

		for (BoundarySurfaceProperty boundSurfProp : boundedBySurfaces)
			boundSurfPropTypeList.add(((BoundarySurfacePropertyImpl)boundSurfProp).getJAXBObject());

		roomType.unsetBoundedBySurfaces();
		roomType.getBoundedBySurfaces().addAll(boundSurfPropTypeList);
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		roomType.setLod4MultiSurface(((MultiSurfacePropertyImpl)lod4MultiSurface).getJAXBObject());
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		roomType.setLod4Solid(((SolidPropertyImpl)lod4Solid).getJAXBObject());
	}

	public void addInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		roomType.getInteriorFurniture().add(((InteriorFurniturePropertyImpl)interiorFurniture).getJAXBObject());
	}

	public void setInteriorFurniture(List<InteriorFurnitureProperty> interiorFurniture) {
		List<InteriorFurniturePropertyType> intFurniturePropTypeList = new ArrayList<InteriorFurniturePropertyType>();

		for (InteriorFurnitureProperty intFurnitureProp : interiorFurniture)
			intFurniturePropTypeList.add(((InteriorFurniturePropertyImpl)intFurnitureProp).getJAXBObject());

		roomType.unsetInteriorFurniture();
		roomType.getInteriorFurniture().addAll(intFurniturePropTypeList);
	}

	public void addGenericApplicationPropertyOfRoom(ADEComponent adeObject) {
		JAXBElement<?> jaxbElem = ModelMapper.ADE.toJAXB(adeObject);
		if (jaxbElem != null)
			roomType.get_GenericApplicationPropertyOfRoom().add(jaxbElem);
	}

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

	public boolean isSetBoundedBySurfaces() {
		return roomType.isSetBoundedBySurfaces();
	}

	public boolean isSetClazz() {
		return roomType.isSetClazz();
	}

	public boolean isSetFunction() {
		return roomType.isSetFunction();
	}

	public boolean isSetGenericApplicationPropertyOfRoom() {
		return roomType.isSet_GenericApplicationPropertyOfRoom();
	}

	public boolean isSetInteriorFurniture() {
		return roomType.isSetInteriorFurniture();
	}

	public boolean isSetLod4MultiSurface() {
		return roomType.isSetLod4MultiSurface();
	}

	public boolean isSetLod4Solid() {
		return roomType.isSetLod4Solid();
	}

	public boolean isSetRoomInstallation() {
		return roomType.isSetRoomInstallation();
	}

	public boolean isSetUsage() {
		return roomType.isSetUsage();
	}

	public void unsetBoundedBySurfaces() {
		roomType.unsetBoundedBySurfaces();
	}

	public void unsetClazz() {
		roomType.setClazz(null);
	}

	public void unsetFunction() {
		roomType.unsetFunction();
	}

	public void unsetGenericApplicationPropertyOfRoom() {
		roomType.unset_GenericApplicationPropertyOfRoom();
	}

	public void unsetInteriorFurniture() {
		roomType.unsetInteriorFurniture();
	}

	public void unsetLod4MultiSurface() {
		roomType.setLod4MultiSurface(null);
	}

	public void unsetLod4Solid() {
		roomType.setLod4Solid(null);
	}

	public void unsetRoomInstallation() {
		roomType.unsetRoomInstallation();
	}

	public void unsetUsage() {
		roomType.unsetUsage();
	}

	public boolean unsetBoundedBySurfaces(BoundarySurfaceProperty boundedBySurface) {
		if (roomType.isSetBoundedBySurfaces())
			return roomType.getBoundedBySurfaces().remove(((BoundarySurfacePropertyImpl)boundedBySurface).getJAXBObject());
		
		return false;
	}

	public boolean unsetFunction(String function) {
		if (roomType.isSetFunction())
			return roomType.getFunction().remove(function);
		
		return false;
	}

	public boolean unsetGenericApplicationPropertyOfRoom(ADEComponent adeObject) {
		if (roomType.isSet_GenericApplicationPropertyOfRoom()) {
			Iterator<JAXBElement<?>> iter = roomType.get_GenericApplicationPropertyOfRoom().iterator();
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

	public boolean unsetInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		if (roomType.isSetInteriorFurniture())
			return roomType.getInteriorFurniture().remove(((InteriorFurniturePropertyImpl)interiorFurniture).getJAXBObject());
		
		return false;
	}

	public boolean unsetRoomInstallation(IntBuildingInstallationProperty roomInstallation) {
		if (roomType.isSetRoomInstallation())
			return roomType.getRoomInstallation().remove(((IntBuildingInstallationPropertyImpl)roomInstallation).getJAXBObject());
		
		return false;
	}

	public boolean unsetUsage(String usage) {
		if (roomType.isSetUsage())
			return roomType.getUsage().remove(usage);
		
		return false;
	}

}
