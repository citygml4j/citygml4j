package org.citygml4j.impl.citygml.cityobjectgroup;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.commons.child.ChildList;
import org.citygml4j.impl.citygml.core.CityObjectImpl;
import org.citygml4j.impl.gml.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupParent;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.module.citygml.CityObjectGroupModule;
import org.citygml4j.visitor.GMLFunction;
import org.citygml4j.visitor.GMLVisitor;
import org.citygml4j.visitor.FeatureFunction;
import org.citygml4j.visitor.FeatureVisitor;

public class CityObjectGroupImpl extends CityObjectImpl implements CityObjectGroup {
	private String clazz;
	private List<String> function;
	private List<String> usage;
	private List<CityObjectGroupMember> groupMember;
	private CityObjectGroupParent groupParent;
	private GeometryProperty geometry;
	private List<ADEComponent> ade;
	private CityObjectGroupModule module;
	
	public CityObjectGroupImpl() {
		
	}
	
	public CityObjectGroupImpl(CityObjectGroupModule module) {
		this.module = module;
	}
	
	public void addFunction(String function) {
		if (this.function == null)
			this.function = new ArrayList<String>();
		
		this.function.add(function);
	}

	public void addGenericApplicationPropertyOfCityObjectGroup(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public void addGroupMember(CityObjectGroupMember groupMember) {
		if (this.groupMember == null)
			this.groupMember = new ChildList<CityObjectGroupMember>(this);

		this.groupMember.add(groupMember);
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

	public List<ADEComponent> getGenericApplicationPropertyOfCityObjectGroup() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public GeometryProperty getGeometry() {
		return geometry;
	}

	public List<CityObjectGroupMember> getGroupMember() {
		if (groupMember == null)
			groupMember = new ChildList<CityObjectGroupMember>(this);

		return groupMember;
	}

	public CityObjectGroupParent getGroupParent() {
		return groupParent;
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

	public boolean isSetGenericApplicationPropertyOfCityObjectGroup() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetGeometry() {
		return geometry != null;
	}

	public boolean isSetGroupMember() {
		return groupMember != null && !groupMember.isEmpty();
	}

	public boolean isSetGroupParent() {
		return groupParent != null;
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

	public void setGenericApplicationPropertyOfCityObjectGroup(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setGeometry(GeometryProperty geometry) {
		if (geometry != null)
			geometry.setParent(this);
		
		this.geometry = geometry;
	}

	public void setGroupMember(List<CityObjectGroupMember> groupMember) {
		this.groupMember = new ChildList<CityObjectGroupMember>(this, groupMember);
	}

	public void setGroupParent(CityObjectGroupParent groupParent) {
		if (groupParent != null)
			groupParent.setParent(this);
		
		this.groupParent = groupParent;
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

	public void unsetGenericApplicationPropertyOfCityObjectGroup() {
		if (isSetGenericApplicationPropertyOfCityObjectGroup())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfCityObjectGroup(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfCityObjectGroup() ? this.ade.remove(ade) : false;
	}

	public void unsetGeometry() {
		if (isSetGeometry())
			geometry.unsetParent();
		
		geometry = null;
	}

	public void unsetGroupMember() {
		if (isSetGroupMember())
			groupMember.clear();

		groupMember = null;
	}

	public boolean unsetGroupMember(CityObjectGroupMember groupMember) {
		return isSetGroupMember() ? this.groupMember.remove(groupMember) : false;
	}

	public void unsetGroupParent() {
		if (isSetGroupParent())
			groupParent.unsetParent();
		
		groupParent = null;
	}

	public void unsetUsage() {
		usage = null;
	}

	public boolean unsetUsage(String usage) {
		return isSetUsage() ? this.usage.remove(usage) : false;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.CITYOBJECTGROUP;
	}

	public final CityObjectGroupModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShapeImpl();
		
		if (isSetGeometry()) {
			if (geometry.isSetGeometry()) {
				calcBoundedBy(boundedBy, geometry.getGeometry());
			} else {
				// xlink
			}
		}
		
		if (isSetGroupMember()) {
			for (CityObjectGroupMember member : groupMember) {
				if (member.isSetObject()) {
					calcBoundedBy(boundedBy, member.getObject(), setBoundedBy);
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
		return copyTo(new CityObjectGroupImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CityObjectGroup copy = (target == null) ? new CityObjectGroupImpl() : (CityObjectGroup)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetClazz())
			copy.setClazz(copyBuilder.copy(clazz));
		
		if (isSetFunction())
			copy.setFunction((List<String>)copyBuilder.copy(function));
		
		if (isSetUsage())
			copy.setFunction((List<String>)copyBuilder.copy(usage));
		
		if (isSetGroupMember()) {
			for (CityObjectGroupMember part : groupMember) {
				CityObjectGroupMember copyPart = (CityObjectGroupMember)copyBuilder.copy(part);
				copy.addGroupMember(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetGroupParent()) {
			copy.setGroupParent((CityObjectGroupParent)copyBuilder.copy(groupParent));
			if (copy.getGroupParent() == groupParent)
				groupParent.setParent(this);
		}
		
		if (isSetGeometry()) {
			copy.setGeometry((GeometryProperty)copyBuilder.copy(geometry));
			if (copy.getGeometry() == geometry)
				geometry.setParent(this);
		}
		
		if (isSetGenericApplicationPropertyOfCityObjectGroup()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfCityObjectGroup(copyPart);
				
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
