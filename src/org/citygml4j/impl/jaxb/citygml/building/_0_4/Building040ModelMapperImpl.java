package org.citygml4j.impl.jaxb.citygml.building._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.impl.jaxb.citygml.AbstractCityGMLModelMapperImpl;
import org.citygml4j.jaxb.citygml._0_4.BuildingFurnitureType;
import org.citygml4j.jaxb.citygml._0_4.BuildingInstallationType;
import org.citygml4j.jaxb.citygml._0_4.BuildingPartType;
import org.citygml4j.jaxb.citygml._0_4.BuildingType;
import org.citygml4j.jaxb.citygml._0_4.CeilingSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.ClosureSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.DoorType;
import org.citygml4j.jaxb.citygml._0_4.FloorSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.GroundSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.IntBuildingInstallationType;
import org.citygml4j.jaxb.citygml._0_4.InteriorWallSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.RoofSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.RoomType;
import org.citygml4j.jaxb.citygml._0_4.WallSurfaceType;
import org.citygml4j.jaxb.citygml._0_4.WindowType;
import org.citygml4j.jaxb.citygml._0_4._AbstractBuildingType;
import org.citygml4j.jaxb.citygml._0_4._BoundarySurfaceType;
import org.citygml4j.jaxb.citygml._0_4._OpeningType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.AbstractBuilding;
import org.citygml4j.model.citygml.building.BoundarySurface;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingFurniture;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.building.CeilingSurface;
import org.citygml4j.model.citygml.building.ClosureSurface;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.building.FloorSurface;
import org.citygml4j.model.citygml.building.GroundSurface;
import org.citygml4j.model.citygml.building.IntBuildingInstallation;
import org.citygml4j.model.citygml.building.InteriorWallSurface;
import org.citygml4j.model.citygml.building.Opening;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.building.WallSurface;
import org.citygml4j.model.citygml.building.Window;
import org.citygml4j.model.citygml.core.CityGMLBase;

public class Building040ModelMapperImpl extends AbstractCityGMLModelMapperImpl {

	public Building toCityGML(BuildingType building, QName name) {		
		if (building.getClass().equals(BuildingType.class))
			return new BuildingImpl(building);
		else
			return (Building)jaxb2ade(building, name, Building.class);
	}
	
	public BuildingPart toCityGML(BuildingPartType buildingPart, QName name) {		
		if (buildingPart.getClass().equals(BuildingPartType.class))
			return new BuildingPartImpl(buildingPart);
		else
			return (BuildingPart)jaxb2ade(buildingPart, name, BuildingPart.class);
	}
	
	public BuildingFurniture toCityGML(BuildingFurnitureType buildingFurniture, QName name) {		
		if (buildingFurniture.getClass().equals(BuildingFurnitureType.class))
			return new BuildingFurnitureImpl(buildingFurniture);
		else
			return (BuildingFurniture)jaxb2ade(buildingFurniture, name, BuildingFurniture.class);
	}
	
	public BuildingInstallation toCityGML(BuildingInstallationType buildingInstallation, QName name) {		
		if (buildingInstallation.getClass().equals(BuildingInstallationType.class))
			return new BuildingInstallationImpl(buildingInstallation);
		else
			return (BuildingInstallation)jaxb2ade(buildingInstallation, name, BuildingInstallation.class);
	}
	
	public IntBuildingInstallation toCityGML(IntBuildingInstallationType intBuildingInstallation, QName name) {		
		if (intBuildingInstallation.getClass().equals(IntBuildingInstallationType.class))
			return new IntBuildingInstallationImpl(intBuildingInstallation);
		else
			return (IntBuildingInstallation)jaxb2ade(intBuildingInstallation, name, IntBuildingInstallation.class);
	}
	
	public CeilingSurface toCityGML(CeilingSurfaceType ceilingSurface, QName name) {		
		if (ceilingSurface.getClass().equals(CeilingSurfaceType.class))
			return new CeilingSurfaceImpl(ceilingSurface);
		else
			return (CeilingSurface)jaxb2ade(ceilingSurface, name, CeilingSurface.class);
	}
	
	public ClosureSurface toCityGML(ClosureSurfaceType closureSurface, QName name) {		
		if (closureSurface.getClass().equals(ClosureSurfaceType.class))
			return new ClosureSurfaceImpl(closureSurface);
		else
			return (ClosureSurface)jaxb2ade(closureSurface, name, ClosureSurface.class);
	}
	
	public FloorSurface toCityGML(FloorSurfaceType floorSurface, QName name) {		
		if (floorSurface.getClass().equals(FloorSurfaceType.class))
			return new FloorSurfaceImpl(floorSurface);
		else
			return (FloorSurface)jaxb2ade(floorSurface, name, FloorSurface.class);
	}
	
	public GroundSurface toCityGML(GroundSurfaceType groundSurface, QName name) {		
		if (groundSurface.getClass().equals(GroundSurfaceType.class))
			return new GroundSurfaceImpl(groundSurface);
		else
			return (GroundSurface)jaxb2ade(groundSurface, name, GroundSurface.class);
	}
	
	public InteriorWallSurface toCityGML(InteriorWallSurfaceType interiorWallSurface, QName name) {		
		if (interiorWallSurface.getClass().equals(InteriorWallSurfaceType.class))
			return new InteriorWallSurfaceImpl(interiorWallSurface);
		else
			return (InteriorWallSurface)jaxb2ade(interiorWallSurface, name, InteriorWallSurface.class);
	}
	
	public RoofSurface toCityGML(RoofSurfaceType roofSurface, QName name) {		
		if (roofSurface.getClass().equals(RoofSurfaceType.class))
			return new RoofSurfaceImpl(roofSurface);
		else
			return (RoofSurface)jaxb2ade(roofSurface, name, RoofSurface.class);
	}
	
	public WallSurface toCityGML(WallSurfaceType wallSurface, QName name) {		
		if (wallSurface.getClass().equals(WallSurfaceType.class))
			return new WallSurfaceImpl(wallSurface);
		else
			return (WallSurface)jaxb2ade(wallSurface, name, WallSurface.class);
	}
	
	public Room toCityGML(RoomType room, QName name) {		
		if (room.getClass().equals(RoomType.class))
			return new RoomImpl(room);
		else
			return (Room)jaxb2ade(room, name, Room.class);
	}
	
	public Door toCityGML(DoorType door, QName name) {		
		if (door.getClass().equals(DoorType.class))
			return new DoorImpl(door);
		else
			return (Door)jaxb2ade(door, name, Door.class);
	}
	
	public Window toCityGML(WindowType window, QName name) {		
		if (window.getClass().equals(WindowType.class))
			return new WindowImpl(window);
		else
			return (Window)jaxb2ade(window, name, Window.class);
	}
	
	public AbstractBuilding toCityGML(_AbstractBuildingType abstractBuilding, QName name) {		
		// we are just checking ADEs
		return (AbstractBuilding)jaxb2ade(abstractBuilding, name, AbstractBuilding.class);
	}
	
	public BoundarySurface toCityGML(_BoundarySurfaceType boundarySurface, QName name) {		
		// we are just checking ADEs
		return (BoundarySurface)jaxb2ade(boundarySurface, name, BoundarySurface.class);
	}
	
	public Opening toCityGML(_OpeningType opening, QName name) {		
		// we are just checking ADEs
		return (Opening)jaxb2ade(opening, name, Opening.class);
	}
	
	public JAXBElement<? extends BuildingType> toJAXB(Building building) {
		if (!(building instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createBuilding(((BuildingImpl)building).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)building, BuildingType.class);
	}
	
	public JAXBElement<? extends BuildingPartType> toJAXB(BuildingPart buildingPart) {
		if (!(buildingPart instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createBuildingPart(((BuildingPartImpl)buildingPart).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)buildingPart, BuildingPartType.class);
	}
	
	public JAXBElement<? extends BuildingFurnitureType> toJAXB(BuildingFurniture buildingFurniture) {
		if (!(buildingFurniture instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createBuildingFurniture(((BuildingFurnitureImpl)buildingFurniture).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)buildingFurniture, BuildingFurnitureType.class);
	}
	
	public JAXBElement<? extends BuildingInstallationType> toJAXB(BuildingInstallation buildingInstallation) {
		if (!(buildingInstallation instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createBuildingInstallation(((BuildingInstallationImpl)buildingInstallation).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)buildingInstallation, BuildingInstallationType.class);
	}
	
	public JAXBElement<? extends IntBuildingInstallationType> toJAXB(IntBuildingInstallation intBuildingInstallation) {
		if (!(intBuildingInstallation instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createIntBuildingInstallation(((IntBuildingInstallationImpl)intBuildingInstallation).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)intBuildingInstallation, IntBuildingInstallationType.class);
	}
	
	public JAXBElement<? extends CeilingSurfaceType> toJAXB(CeilingSurface ceilingSurface) {
		if (!(ceilingSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createCeilingSurface(((CeilingSurfaceImpl)ceilingSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)ceilingSurface, CeilingSurfaceType.class);
	}
	
	public JAXBElement<? extends ClosureSurfaceType> toJAXB(ClosureSurface closureSurface) {
		if (!(closureSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createClosureSurface(((ClosureSurfaceImpl)closureSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)closureSurface, ClosureSurfaceType.class);
	}
	
	public JAXBElement<? extends FloorSurfaceType> toJAXB(FloorSurface floorSurface) {
		if (!(floorSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createFloorSurface(((FloorSurfaceImpl)floorSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)floorSurface, FloorSurfaceType.class);
	}
	
	public JAXBElement<? extends GroundSurfaceType> toJAXB(GroundSurface groundSurface) {
		if (!(groundSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createGroundSurface(((GroundSurfaceImpl)groundSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)groundSurface, GroundSurfaceType.class);
	}
	
	public JAXBElement<? extends InteriorWallSurfaceType> toJAXB(InteriorWallSurface interiorWallSurface) {
		if (!(interiorWallSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createInteriorWallSurface(((InteriorWallSurfaceImpl)interiorWallSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)interiorWallSurface, InteriorWallSurfaceType.class);
	}
	
	public JAXBElement<? extends RoofSurfaceType> toJAXB(RoofSurface roofSurface) {
		if (!(roofSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createRoofSurface(((RoofSurfaceImpl)roofSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)roofSurface, RoofSurfaceType.class);
	}
	
	public JAXBElement<? extends WallSurfaceType> toJAXB(WallSurface wallSurface) {
		if (!(wallSurface instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createWallSurface(((WallSurfaceImpl)wallSurface).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)wallSurface, WallSurfaceType.class);
	}
	
	public JAXBElement<? extends RoomType> toJAXB(Room room) {
		if (!(room instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createRoom(((RoomImpl)room).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)room, RoomType.class);
	}
	
	public JAXBElement<? extends DoorType> toJAXB(Door door) {
		if (!(door instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createDoor(((DoorImpl)door).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)door, DoorType.class);
	}
	
	public JAXBElement<? extends WindowType> toJAXB(Window window) {
		if (!(window instanceof ADEComponent))
			return ObjectFactory.CITYGML_0_4.createWindow(((WindowImpl)window).getJAXBObject());
		else
			return ade2jaxb((ADEComponent)window, WindowType.class);
	}
	
	public JAXBElement<? extends _AbstractBuildingType> toJAXB(AbstractBuilding abstractBuilding) {
		// we are just checking ADEs
		if (abstractBuilding instanceof ADEComponent)
			return ade2jaxb((ADEComponent)abstractBuilding, _AbstractBuildingType.class);
		
		return null;
	}
	
	public JAXBElement<? extends _BoundarySurfaceType> toJAXB(BoundarySurface boundarySurface) {
		// we are just checking ADEs
		if (boundarySurface instanceof ADEComponent)
			return ade2jaxb((ADEComponent)boundarySurface, _BoundarySurfaceType.class);
		
		return null;
	}
	
	public JAXBElement<? extends _OpeningType> toJAXB(Opening opening) {
		// we are just checking ADEs
		if (opening instanceof ADEComponent)
			return ade2jaxb((ADEComponent)opening, _OpeningType.class);
		
		return null;
	}
	
	public CityGMLBase toCityGML(JAXBElement<?> jaxbElem) {
		CityGMLBase cityGMLBase = null;
		
		if (jaxbElem.getValue() != null) {
			Object value = jaxbElem.getValue();
			QName name = jaxbElem.getName();
			
			if (value instanceof BuildingType)
				cityGMLBase = toCityGML((BuildingType)value, name);
			else if (value instanceof BuildingPartType)
				cityGMLBase = toCityGML((BuildingPartType)value, name);
			else if (value instanceof BuildingFurnitureType)
				cityGMLBase = toCityGML((BuildingFurnitureType)value, name);
			else if (value instanceof BuildingInstallationType)
				cityGMLBase = toCityGML((BuildingInstallationType)value, name);
			else if (value instanceof IntBuildingInstallationType)
				cityGMLBase = toCityGML((IntBuildingInstallationType)value, name);	
			else if (value instanceof CeilingSurfaceType)
				cityGMLBase = toCityGML((CeilingSurfaceType)value, name);	
			else if (value instanceof ClosureSurfaceType)
				cityGMLBase = toCityGML((ClosureSurfaceType)value, name);	
			else if (value instanceof FloorSurfaceType)
				cityGMLBase = toCityGML((FloorSurfaceType)value, name);	
			else if (value instanceof GroundSurfaceType)
				cityGMLBase = toCityGML((GroundSurfaceType)value, name);	
			else if (value instanceof InteriorWallSurfaceType)
				cityGMLBase = toCityGML((InteriorWallSurfaceType)value, name);	
			else if (value instanceof RoofSurfaceType)
				cityGMLBase = toCityGML((RoofSurfaceType)value, name);	
			else if (value instanceof WallSurfaceType)
				cityGMLBase = toCityGML((WallSurfaceType)value, name);	
			else if (value instanceof RoomType)
				cityGMLBase = toCityGML((RoomType)value, name);	
			else if (value instanceof DoorType)
				cityGMLBase = toCityGML((DoorType)value, name);	
			else if (value instanceof WindowType)
				cityGMLBase = toCityGML((WindowType)value, name);
			else if (value instanceof _AbstractBuildingType)
				cityGMLBase = toCityGML((_AbstractBuildingType)value, name);	
			else if (value instanceof _BoundarySurfaceType)
				cityGMLBase = toCityGML((_BoundarySurfaceType)value, name);	
			else if (value instanceof _OpeningType)
				cityGMLBase = toCityGML((_OpeningType)value, name);
		}

		return cityGMLBase;
	}

	public JAXBElement<?> toJAXB(CityGMLBase cityGML) {
		JAXBElement<?> jaxbElem = null;
		
		if (cityGML instanceof Building)
			jaxbElem = toJAXB((Building)cityGML);
		else if (cityGML instanceof BuildingPart)
			jaxbElem = toJAXB((BuildingPart)cityGML);
		else if (cityGML instanceof BuildingFurniture)
			jaxbElem = toJAXB((BuildingFurniture)cityGML);
		else if (cityGML instanceof BuildingInstallation)
			jaxbElem = toJAXB((BuildingInstallation)cityGML);	
		else if (cityGML instanceof IntBuildingInstallation)
			jaxbElem = toJAXB((IntBuildingInstallation)cityGML);
		else if (cityGML instanceof CeilingSurface)
			jaxbElem = toJAXB((CeilingSurface)cityGML);
		else if (cityGML instanceof ClosureSurface)
			jaxbElem = toJAXB((ClosureSurface)cityGML);
		else if (cityGML instanceof FloorSurface)
			jaxbElem = toJAXB((FloorSurface)cityGML);
		else if (cityGML instanceof GroundSurface)
			jaxbElem = toJAXB((GroundSurface)cityGML);
		else if (cityGML instanceof InteriorWallSurface)
			jaxbElem = toJAXB((InteriorWallSurface)cityGML);
		else if (cityGML instanceof RoofSurface)
			jaxbElem = toJAXB((RoofSurface)cityGML);
		else if (cityGML instanceof WallSurface)
			jaxbElem = toJAXB((WallSurface)cityGML);
		else if (cityGML instanceof Room)
			jaxbElem = toJAXB((Room)cityGML);
		else if (cityGML instanceof Door)
			jaxbElem = toJAXB((Door)cityGML);
		else if (cityGML instanceof Window)
			jaxbElem = toJAXB((Window)cityGML);
		else if (cityGML instanceof AbstractBuilding)
			jaxbElem = toJAXB((AbstractBuilding)cityGML);
		else if (cityGML instanceof BoundarySurface)
			jaxbElem = toJAXB((BoundarySurface)cityGML);
		else if (cityGML instanceof Opening)
			jaxbElem = toJAXB((Opening)cityGML);
		
		return jaxbElem;
	}

}
