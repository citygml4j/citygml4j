package org.citygml4j.impl.citygml.building;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.Door;
import org.citygml4j.model.citygml.core.AddressProperty;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class DoorImpl extends OpeningImpl implements Door {
	private List<AddressProperty> address;
	private List<ADEComponent> ade;
	
	public DoorImpl() {
		
	}
	
	public DoorImpl(BuildingModule module) {
		super(module);
	}
	
	public void addAddress(AddressProperty address) {
		if (this.address == null)
			this.address = new ChildList<AddressProperty>(this);

		this.address.add(address);
	}

	public void addGenericApplicationPropertyOfDoor(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}
	
	public List<AddressProperty> getAddress() {
		if (address == null)
			address = new ChildList<AddressProperty>(this);

		return address;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfDoor() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}
	
	public boolean isSetAddress() {
		return address != null && !address.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfDoor() {
		return ade != null && !ade.isEmpty();
	}
	
	public void setAddress(List<AddressProperty> address) {
		this.address = new ChildList<AddressProperty>(this, address);
	}

	public void setGenericApplicationPropertyOfDoor(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}
	
	public void unsetAddress() {
		if (isSetAddress())
			address.clear();

		address = null;
	}

	public boolean unsetAddress(AddressProperty address) {
		return isSetAddress() ? this.address.remove(address) : false;
	}

	public void unsetGenericApplicationPropertyOfDoor() {
		if (isSetGenericApplicationPropertyOfDoor())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfDoor(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfDoor() ? this.ade.remove(ade) : false;
	}	

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.DOOR;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DoorImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Door copy = (target == null) ? new DoorImpl() : (Door)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetAddress()) {
			for (AddressProperty part : address) {
				AddressProperty copyPart = (AddressProperty)copyBuilder.copy(part);
				copy.addAddress(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGenericApplicationPropertyOfDoor()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfDoor(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public void visit(FeatureVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(FeatureFunction<T> visitor) {
		return visitor.accept(this);
	}
	
	public void visit(GMLVisitor visitor) {
		visitor.accept(this);
	}
	
	public <T> T apply(GMLFunction<T> visitor) {
		return visitor.accept(this);
	}

}
