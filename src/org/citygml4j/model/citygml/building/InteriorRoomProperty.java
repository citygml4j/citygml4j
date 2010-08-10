package org.citygml4j.model.citygml.building;

import org.citygml4j.model.gml.feature.FeatureProperty;

public interface InteriorRoomProperty extends BuildingModuleComponent, FeatureProperty<Room> {
	public Room getRoom();
	public boolean isSetRoom();
	
	public void setRoom(Room room);
	public void unsetRoom();
}
