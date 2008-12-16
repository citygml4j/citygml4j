package org.citygml4j.impl.jaxb.citygml.building._0_4;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.impl.jaxb.ModelMapper;
import org.citygml4j.impl.jaxb.gml._3_1_1.AssociationImpl;
import org.citygml4j.jaxb.citygml._0_4.InteriorRoomPropertyType;
import org.citygml4j.jaxb.citygml._0_4.RoomType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.building.BuildingModule;
import org.citygml4j.model.citygml.building.InteriorRoomProperty;
import org.citygml4j.model.citygml.building.Room;

public class InteriorRoomPropertyImpl extends AssociationImpl<Room> implements InteriorRoomProperty {
	private InteriorRoomPropertyType interiorRoomPropertyType;

	public InteriorRoomPropertyImpl() {
		this(new InteriorRoomPropertyType());
	}

	public InteriorRoomPropertyImpl(InteriorRoomPropertyType interiorRoomPropertyType) {
		super(interiorRoomPropertyType);
		this.interiorRoomPropertyType = interiorRoomPropertyType;
	}

	@Override
	public InteriorRoomPropertyType getJAXBObject() {
		return interiorRoomPropertyType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INTERIORROOMPROPERTY;
	}
	
	@Override
	public final CityGMLModule getCityGMLModule() {
		return BuildingModule.v0_4_0;
	}

	@Override
	public Room getObject() {
		if (interiorRoomPropertyType.isSet_Object()) {
			JAXBElement<?> interiorRoom = interiorRoomPropertyType.get_Object();
			
			if (interiorRoom.getValue() != null) {
				Object elem = interiorRoom.getValue();
				QName name = interiorRoom.getName();
				
				if (elem instanceof RoomType)
					return ModelMapper.BLDG_0_4.toCityGML((RoomType)elem, name);
			}
		}

		return null;
	}

	@Override
	public void setObject(Room object) {
		JAXBElement<?> jaxbElem = ModelMapper.BLDG_0_4.toJAXB(object);
		interiorRoomPropertyType.set_Object(jaxbElem);
	}

}
