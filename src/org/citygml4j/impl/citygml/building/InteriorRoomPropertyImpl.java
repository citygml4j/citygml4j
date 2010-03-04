package org.citygml4j.impl.citygml.building;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.AssociationImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.module.citygml.BuildingModule;

public class InteriorRoomPropertyImpl extends AssociationImpl<Room> implements InteriorRoomProperty {
	private BuildingModule module;
	
	public InteriorRoomPropertyImpl() {
		
	}
	
	public InteriorRoomPropertyImpl(BuildingModule module) {
		this.module = module;
	}
	
	public Room getRoom() {
		return super.getObject();
	}

	public boolean isSetRoom() {
		return super.isSetObject();
	}

	public void setRoom(Room room) {
		super.setObject(room);
	}

	public void unsetRoom() {
		super.unsetObject();
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIORROOMPROPERTY;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new InteriorRoomPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		InteriorRoomProperty copy = (target == null) ? new InteriorRoomPropertyImpl() : (InteriorRoomProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
