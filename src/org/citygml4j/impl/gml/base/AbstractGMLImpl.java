package org.citygml4j.impl.gml.base;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.Code;

public abstract class AbstractGMLImpl implements AbstractGML {
	private String id;
	private StringOrRef description;
	private List<Code> name;
	private List<MetaDataProperty> metaDataProperty;
	private Object parent;

	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_GML;
	}
	
	public String getId() {
		return id;
	}

	public boolean isSetId() {
		return id != null;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void unsetId() {
		id = null;
	}

	public void addMetaDataProperty(MetaDataProperty metaDataProperty) {
		if (this.metaDataProperty == null)
			this.metaDataProperty = new ChildList<MetaDataProperty>(this);
		
		this.metaDataProperty.add(metaDataProperty);
	}
	
	public void addName(Code name) {
		if (this.name == null)
			this.name = new ChildList<Code>(this);

		this.name.add(name);
	}

	public StringOrRef getDescription() {
		return description;
	}

	public List<MetaDataProperty> getMetaDataProperty() {
		if (metaDataProperty == null)
			metaDataProperty = new ChildList<MetaDataProperty>(this);
		
		return metaDataProperty;
	}
	
	public List<Code> getName() {
		if (name == null)
			name = new ChildList<Code>(this);

		return name;
	}

	public boolean isSetDescription() {
		return description != null;
	}

	public boolean isSetMetaDataProperty() {
		return metaDataProperty != null && !metaDataProperty.isEmpty();
	}

	public boolean isSetName() {
		return name != null && !name.isEmpty();
	}

	public void setDescription(StringOrRef description) {
		if (description != null)
			description.setParent(this);

		this.description = description;
	}

	public void setMetaDataProperty(List<MetaDataProperty> metaDataProperty) {
		this.metaDataProperty = new ChildList<MetaDataProperty>(this, metaDataProperty);
	}

	public void setName(List<Code> name) {
		this.name = new ChildList<Code>(this, name);
	}

	public void unsetDescription() {
		if (isSetDescription())
			description.unsetParent();

		description = null;
	}

	public void unsetMetaDataProperty() {
		if (isSetMetaDataProperty())
			metaDataProperty.clear();
		
		metaDataProperty = null;
	}
	
	public boolean unsetMetaDataProperty(MetaDataProperty metaDataProperty) {
		return isSetMetaDataProperty() ? this.metaDataProperty.remove(metaDataProperty) : false;
	}

	public void unsetName() {
		if (isSetName())
			name.clear();

		name = null;
	}

	public boolean unsetName(Code name) {
		return isSetName() ? this.name.remove(name) : false;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractGML copy = (AbstractGML)target;

		if (isSetId())
			copy.setId(copyBuilder.copy(id));

		if (isSetDescription()) {
			copy.setDescription((StringOrRef)copyBuilder.copy(description));
			if (copy.getDescription() == description)
				description.setParent(this);
		}

		if (isSetName()) {
			for (Code part : name) {
				Code copyPart = (Code)copyBuilder.copy(part);
				copy.addName(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}			
		}
		
		if (isSetMetaDataProperty()) {
			for (MetaDataProperty part : metaDataProperty) {
				MetaDataProperty copyPart = (MetaDataProperty)copyBuilder.copy(part);
				copy.addMetaDataProperty(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		copy.unsetParent();

		return copy;
	}

}
