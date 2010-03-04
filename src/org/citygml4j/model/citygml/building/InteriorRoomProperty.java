package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.Association;

public interface InteriorRoomProperty extends BuildingModuleComponent, Association<Room> {
	public Room getRoom();
	public boolean isSetRoom();
	
	public void setRoom(Room room);
	public void unsetRoom();
}
