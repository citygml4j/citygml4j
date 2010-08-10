package org.citygml4j.model.gml.base;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;
import org.w3c.dom.Element;

public class MetaData implements GML, Associable {
	private Element content;
	private Object parent;
	
	public MetaData() {
		
	}
	
	public MetaData(Element content) {
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
		return GMLClass.META_DATA;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MetaData(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MetaData copy = (target == null) ? new MetaData() : (MetaData)target;

		if (isSetContent())
			copy.setContent((Element)copyBuilder.copy(content));		
		
		copy.unsetParent();
		
		return copy;
	}

}
