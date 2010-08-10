package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.Associable;
import org.w3c.dom.Element;

public class GenericValueObject implements GML, Associable {
	private Element content;
	private Object parent;
	
	public GenericValueObject() {
		
	}
	
	public GenericValueObject(Element content) {
		this.content = content;
	}
	
	public Element getContent() {
		return content;
	}
	
	public boolean isSetContent() {
		return content != null;
	}
	
	public void setContent(Element content) {
		this.content = content;
	}
	
	public void unsetContent() {
		content = null;
	}

	public String getLocalName() {
		return isSetContent() ? content.getLocalName() : null;
	}
	
	public String getPrefix() {
		return isSetContent() ? content.getPrefix() : null;
	}
	
	public String getNamespaceURI() {
		return isSetContent() ? content.getNamespaceURI() : null;
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

	public GMLClass getGMLClass() {
		return GMLClass.GENERIC_VALUE_OBJECT;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GenericValueObject(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GenericValueObject copy = (target == null) ? new GenericValueObject() : (GenericValueObject)target;

		if (isSetContent())
			copy.setContent((Element)copyBuilder.copy(content));		
		
		copy.unsetParent();
		
		return copy;
	}

}
