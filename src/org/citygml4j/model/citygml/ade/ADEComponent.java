package org.citygml4j.model.citygml.ade;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.builder.copy.DeepCopyBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.w3c.dom.Element;

public class ADEComponent implements CityGML, Child, Copyable {
	private Element content;
	private Object parent;	
	
	public ADEComponent() {
		
	}
	
	public ADEComponent(Element content) {
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

	public ModelType getModelType() {
		return ModelType.CITYGML_ADE;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.ADE_COMPONENT;
	}

	public CityGMLModule getCityGMLModule() {
		return null;
	}

	public boolean isSetCityGMLModule() {
		return false;
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ADEComponent(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ADEComponent copy = (target == null) ? new ADEComponent() : (ADEComponent)target;
		
		if (isSetContent()) {
			if (copyBuilder instanceof DeepCopyBuilder)
				copy.setContent((Element)content.cloneNode(true));
			else
				copy.setContent((Element)copyBuilder.copy(content));
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public void visit(FeatureVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T apply(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}
	
}
