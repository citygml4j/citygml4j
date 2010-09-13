package org.citygml4j.impl.citygml.building;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.citygml.core.AbstractCityObjectImpl;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BoundarySurfaceProperty;
import org.citygml4j.model.citygml.building.IntBuildingInstallationProperty;
import org.citygml4j.model.citygml.building.InteriorFurnitureProperty;
import org.citygml4j.model.citygml.building.Room;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.module.citygml.BuildingModule;

public class RoomImpl extends AbstractCityObjectImpl implements Room {
	private String clazz;
	private List<String> function;
	private List<String> usage;
	private List<BoundarySurfaceProperty> boundedBySurface;
	private List<InteriorFurnitureProperty> interiorFurniture;
	private List<IntBuildingInstallationProperty> roomInstallation;
	private SolidProperty lod4Solid;
	private MultiSurfaceProperty lod4MultiSurface;
	private List<ADEComponent> ade;
	private BuildingModule module;
	
	public RoomImpl() {
		
	}
	
	public RoomImpl(BuildingModule module) {
		this.module = module;
	}
	
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		if (this.boundedBySurface == null)
			this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		this.boundedBySurface.add(boundedBySurface);
	}

	public void addFunction(String function) {
		if (this.function == null)
			this.function = new ArrayList<String>();

		this.function.add(function);
	}

	public void addGenericApplicationPropertyOfRoom(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		if (this.interiorFurniture == null)
			this.interiorFurniture = new ChildList<InteriorFurnitureProperty>(this);

		this.interiorFurniture.add(interiorFurniture);
	}

	public void addRoomInstallation(IntBuildingInstallationProperty roomInstallation) {
		if (this.roomInstallation == null)
			this.roomInstallation = new ChildList<IntBuildingInstallationProperty>(this);

		this.roomInstallation.add(roomInstallation);
	}

	public void addUsage(String usage) {
		if (this.usage == null)
			this.usage = new ArrayList<String>();

		this.usage.add(usage);
	}

	public List<BoundarySurfaceProperty> getBoundedBySurface() {
		if (boundedBySurface == null)
			boundedBySurface = new ChildList<BoundarySurfaceProperty>(this);

		return boundedBySurface;
	}

	public String getClazz() {
		return clazz;
	}

	public List<String> getFunction() {
		if (function == null)
			function = new ArrayList<String>();

		return function;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfRoom() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public List<InteriorFurnitureProperty> getInteriorFurniture() {
		if (interiorFurniture == null)
			interiorFurniture = new ChildList<InteriorFurnitureProperty>(this);

		return interiorFurniture;
	}

	public MultiSurfaceProperty getLod4MultiSurface() {
		return lod4MultiSurface;
	}

	public SolidProperty getLod4Solid() {
		return lod4Solid;
	}

	public List<IntBuildingInstallationProperty> getRoomInstallation() {
		if (roomInstallation == null)
			roomInstallation = new ChildList<IntBuildingInstallationProperty>(this);

		return roomInstallation;
	}

	public List<String> getUsage() {
		if (usage == null)
			usage = new ArrayList<String>();

		return usage;
	}

	public boolean isSetBoundedBySurface() {
		return boundedBySurface != null && !boundedBySurface.isEmpty();
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfRoom() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetInteriorFurniture() {
		return interiorFurniture != null && !interiorFurniture.isEmpty();
	}

	public boolean isSetLod4MultiSurface() {
		return lod4MultiSurface != null;
	}

	public boolean isSetLod4Solid() {
		return lod4Solid != null;
	}

	public boolean isSetRoomInstallation() {
		return roomInstallation != null && !roomInstallation.isEmpty();
	}

	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface) {
		this.boundedBySurface = new ChildList<BoundarySurfaceProperty>(this, boundedBySurface);
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setFunction(List<String> function) {
		this.function = function;
	}

	public void setGenericApplicationPropertyOfRoom(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setInteriorFurniture(List<InteriorFurnitureProperty> interiorFurniture) {
		this.interiorFurniture = new ChildList<InteriorFurnitureProperty>(this, interiorFurniture);
	}

	public void setLod4MultiSurface(MultiSurfaceProperty lod4MultiSurface) {
		if (lod4MultiSurface != null)
			lod4MultiSurface.setParent(this);
		
		this.lod4MultiSurface = lod4MultiSurface;
	}

	public void setLod4Solid(SolidProperty lod4Solid) {
		if (lod4Solid != null)
			lod4Solid.setParent(this);
		
		this.lod4Solid = lod4Solid;
	}

	public void setRoomInstallation(List<IntBuildingInstallationProperty> roomInstallation) {
		this.roomInstallation = new ChildList<IntBuildingInstallationProperty>(this, roomInstallation);
	}

	public void setUsage(List<String> usage) {
		this.usage = usage;
	}

	public void unsetBoundedBySurface() {
		if (isSetBoundedBySurface())
			boundedBySurface.clear();

		boundedBySurface = null;
	}

	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface) {
		return isSetBoundedBySurface() ? this.boundedBySurface.remove(boundedBySurface) : false;
	}

	public void unsetClazz() {
		clazz = null;
	}

	public void unsetFunction() {
		function = null;
	}

	public boolean unsetFunction(String function) {
		return isSetFunction() ? this.function.remove(function) : false;
	}

	public void unsetGenericApplicationPropertyOfRoom() {
		if (isSetGenericApplicationPropertyOfRoom())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfRoom(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfRoom() ? this.ade.remove(ade) : false;
	}

	public void unsetInteriorFurniture() {
		if (isSetInteriorFurniture())
			interiorFurniture.clear();

		interiorFurniture = null;
	}

	public boolean unsetInteriorFurniture(InteriorFurnitureProperty interiorFurniture) {
		return isSetInteriorFurniture() ? this.interiorFurniture.remove(interiorFurniture) : false;
	}

	public void unsetLod4MultiSurface() {
		if (isSetLod4MultiSurface())
			lod4MultiSurface.unsetParent();
		
		lod4MultiSurface = null;
	}

	public void unsetLod4Solid() {
		if (isSetLod4Solid())
			lod4Solid.unsetParent();
		
		lod4Solid = null;
	}

	public void unsetRoomInstallation() {
		if (isSetRoomInstallation())
			roomInstallation.clear();

		roomInstallation = null;
	}

	public boolean unsetRoomInstallation(IntBuildingInstallationProperty roomInstallation) {
		return isSetRoomInstallation() ? this.roomInstallation.remove(roomInstallation) : false;
	}

	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(String usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ROOM;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();
		
		if (isSetLod4MultiSurface()) {
			if (lod4MultiSurface.isSetMultiSurface()) {
				calcBoundedBy(boundedBy, lod4MultiSurface.getMultiSurface());			
			} else {
				// xlink
			}
		}
		
		if (isSetLod4Solid()) {
			if (lod4Solid.isSetSolid()) {
				calcBoundedBy(boundedBy, lod4Solid.getSolid());			
			} else {
				// xlink
			}
		}
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty boundarySurfaceProperty : boundedBySurface) {
				if (boundarySurfaceProperty.isSetObject()) {
					calcBoundedBy(boundedBy, boundarySurfaceProperty.getObject(), setBoundedBy);
				} else {
					// xlink
				}
			}
		}
		
		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}
	
	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();
		
		if (isSetLod4MultiSurface())
			lodRepresentation.getLod4Geometry().add(lod4MultiSurface);
		
		if (isSetLod4Solid())
			lodRepresentation.getLod4Geometry().add(lod4Solid);
		
		return lodRepresentation;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new RoomImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Room copy = (target == null) ? new RoomImpl() : (Room)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz(copyBuilder.copy(clazz));

		if (isSetFunction())
			copy.setFunction((List<String>)copyBuilder.copy(function));

		if (isSetUsage())
			copy.setFunction((List<String>)copyBuilder.copy(usage));
		
		if (isSetBoundedBySurface()) {
			for (BoundarySurfaceProperty part : boundedBySurface) {
				BoundarySurfaceProperty copyPart = (BoundarySurfaceProperty)copyBuilder.copy(part);
				copy.addBoundedBySurface(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetInteriorFurniture()) {
			for (InteriorFurnitureProperty part : interiorFurniture) {
				InteriorFurnitureProperty copyPart = (InteriorFurnitureProperty)copyBuilder.copy(part);
				copy.addInteriorFurniture(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetRoomInstallation()) {
			for (IntBuildingInstallationProperty part : roomInstallation) {
				IntBuildingInstallationProperty copyPart = (IntBuildingInstallationProperty)copyBuilder.copy(part);
				copy.addRoomInstallation(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetLod4MultiSurface()) {
			copy.setLod4MultiSurface((MultiSurfaceProperty)copyBuilder.copy(lod4MultiSurface));
			if (copy.getLod4MultiSurface() == lod4MultiSurface)
				lod4MultiSurface.setParent(this);
		}
		
		if (isSetLod4Solid()) {
			copy.setLod4Solid((SolidProperty)copyBuilder.copy(lod4Solid));
			if (copy.getLod4Solid() == lod4Solid)
				lod4Solid.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfRoom()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfRoom(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
	
	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
