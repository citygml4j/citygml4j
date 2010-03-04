package org.citygml4j.impl.citygml.building;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.citygml.core.CityObjectImpl;
import org.citygml4j.impl.gml.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.BuildingInstallation;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.module.citygml.BuildingModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class BuildingInstallationImpl extends CityObjectImpl implements BuildingInstallation {
	private String clazz;
	private List<String> function;
	private List<String> usage;
	private GeometryProperty lod2Geometry;
	private GeometryProperty lod3Geometry;
	private GeometryProperty lod4Geometry;
	private List<ADEComponent> ade;
	private BuildingModule module;
	
	public BuildingInstallationImpl() {
		
	}
	
	public BuildingInstallationImpl(BuildingModule module) {
		this.module = module;
	}
	
	public void addFunction(String function) {
		if (this.function == null)
			this.function = new ArrayList<String>();
		
		this.function.add(function);
	}

	public void addGenericApplicationPropertyOfBuildingInstallation(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addUsage(String usage) {
		if (this.usage == null)
			this.usage = new ArrayList<String>();

		this.usage.add(usage);
	}

	public String getClazz() {
		return clazz;
	}

	public List<String> getFunction() {
		if (function == null)
			function = new ArrayList<String>();

		return function;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfBuildingInstallation() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public GeometryProperty getLod2Geometry() {
		return lod2Geometry;
	}

	public GeometryProperty getLod3Geometry() {
		return lod3Geometry;
	}

	public GeometryProperty getLod4Geometry() {
		return lod4Geometry;
	}

	public List<String> getUsage() {
		if (usage == null)
			usage = new ArrayList<String>();

		return usage;
	}

	public boolean isSetClazz() {
		return clazz != null;
	}

	public boolean isSetFunction() {
		return function != null && !function.isEmpty();
	}

	public boolean isSetGenericApplicationPropertyOfBuildingInstallation() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod2Geometry() {
		return lod2Geometry != null;
	}

	public boolean isSetLod3Geometry() {
		return lod3Geometry != null;
	}

	public boolean isSetLod4Geometry() {
		return lod4Geometry != null;
	}

	public boolean isSetUsage() {
		return usage != null && !usage.isEmpty();
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public void setFunction(List<String> function) {
		this.function = function;
	}

	public void setGenericApplicationPropertyOfBuildingInstallation(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod2Geometry(GeometryProperty lod2Geometry) {
		if (lod2Geometry != null)
			lod2Geometry.setParent(this);
		
		this.lod2Geometry = lod2Geometry;
	}

	public void setLod3Geometry(GeometryProperty lod3Geometry) {
		if (lod3Geometry != null)
			lod3Geometry.setParent(this);
		
		this.lod3Geometry = lod3Geometry;
	}

	public void setLod4Geometry(GeometryProperty lod4Geometry) {
		if (lod4Geometry != null)
			lod4Geometry.setParent(this);
		
		this.lod4Geometry = lod4Geometry;
	}

	public void setUsage(List<String> usage) {
		this.usage = usage;
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

	public void unsetGenericApplicationPropertyOfBuildingInstallation() {
		if (isSetGenericApplicationPropertyOfBuildingInstallation())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfBuildingInstallation(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfBuildingInstallation() ? this.ade.remove(ade) : false;
	}

	public void unsetLod2Geometry() {
		if (isSetLod2Geometry())
			lod2Geometry.unsetParent();
		
		lod2Geometry = null;
	}

	public void unsetLod3Geometry() {
		if (isSetLod3Geometry())
			lod3Geometry.unsetParent();
		
		lod3Geometry = null;
	}

	public void unsetLod4Geometry() {
		if (isSetLod4Geometry())
			lod4Geometry.unsetParent();
		
		lod4Geometry = null;
	}

	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(String usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.BUILDINGINSTALLATION;
	}

	public final BuildingModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();
		GeometryProperty geometryProperty = null;

		for (int lod = 2; lod < 5; lod++) {
			switch (lod) {
			case 2:
				geometryProperty = lod2Geometry;
				break;
			case 3:
				geometryProperty = lod3Geometry;
				break;
			case 4:
				geometryProperty = lod4Geometry;
				break;
			}
			
			if (geometryProperty != null) {
				if (geometryProperty.isSetGeometry()) {
					calcBoundedBy(boundedBy, geometryProperty.getGeometry());
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new BuildingInstallationImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		BuildingInstallation copy = (target == null) ? new BuildingInstallationImpl() : (BuildingInstallation)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz(copyBuilder.copy(clazz));

		if (isSetFunction())
			copy.setFunction((List<String>)copyBuilder.copy(function));

		if (isSetUsage())
			copy.setFunction((List<String>)copyBuilder.copy(usage));
		
		if (isSetLod2Geometry()) {
			copy.setLod2Geometry((GeometryProperty)copyBuilder.copy(lod2Geometry));
			if (copy.getLod2Geometry() == lod2Geometry)
				lod2Geometry.setParent(this);
		}
		
		if (isSetLod3Geometry()) {
			copy.setLod3Geometry((GeometryProperty)copyBuilder.copy(lod3Geometry));
			if (copy.getLod3Geometry() == lod3Geometry)
				lod3Geometry.setParent(this);
		}
		
		if (isSetLod4Geometry()) {
			copy.setLod4Geometry((GeometryProperty)copyBuilder.copy(lod4Geometry));
			if (copy.getLod4Geometry() == lod4Geometry)
				lod4Geometry.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfBuildingInstallation()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfBuildingInstallation(copyPart);

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
