package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.Association;
import org.citygml4j.model.gml.GMLClass;

public abstract class AssociationImpl<T extends AbstractGML> implements Association<T> {
	private T object;
	private ADEComponent genericADEComponent;
	private String actuate;
	private String arcrole;
	private String href;
	private String remoteSchema;
	private String role;
	private String show;
	private String title;
	private String type;
	private Object parent;

	public T getObject() {
		return object;
	}

	public boolean isSetObject() {
		return object != null;
	}

	public void setObject(T object) {
		if (object != null)
			object.setParent(this);
		
		this.object = object;
	}

	public void unsetObject() {
		if (isSetObject())
			object.unsetParent();
		
		object = null;
	}
	
	public ADEComponent getGenericADEComponent() {
		return genericADEComponent;
	}

	public boolean isSetGenericADEComponent() {
		return genericADEComponent != null;
	}
	
	public void setGenericADEComponent(ADEComponent genericADEComponent) {
		if (genericADEComponent != null)
			genericADEComponent.setParent(this);
		
		this.genericADEComponent = genericADEComponent;
	}
	
	public void unsetGenericADEComponent() {
		if (isSetGenericADEComponent())
			genericADEComponent.unsetParent();
		
		genericADEComponent = null;
	}

	public String getActuate() {
		return actuate;
	}

	public String getArcrole() {
		return arcrole;
	}

	public String getHref() {
		return href;
	}

	public String getRemoteSchema() {
		return remoteSchema;
	}

	public String getRole() {
		return role;
	}

	public String getShow() {
		return show;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		if (type == null)
			return "simple";
		else
			return type;
	}

	public boolean isSetActuate() {
		return actuate != null;
	}

	public boolean isSetArcrole() {
		return arcrole != null;
	}

	public boolean isSetHref() {
		return href != null;
	}

	public boolean isSetRemoteSchema() {
		return remoteSchema != null;
	}

	public boolean isSetRole() {
		return role != null;
	}

	public boolean isSetShow() {
		return show != null;
	}

	public boolean isSetTitle() {
		return title != null;
	}

	public boolean isSetType() {
		return type != null;
	}

	public void setActuate(String actuate) {
		this.actuate = actuate;
	}

	public void setArcrole(String arcrole) {
		this.arcrole = arcrole;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setRemoteSchema(String remoteSchema) {
		this.remoteSchema = remoteSchema;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setShow(String show) {
		this.show = show;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(String type) {
		this.type = "simple";
	}

	public void unsetActuate() {
		actuate = null;
	}

	public void unsetArcrole() {
		arcrole = null;
	}

	public void unsetHref() {
		href = null;
	}

	public void unsetRemoteSchema() {
		remoteSchema = null;
	}

	public void unsetRole() {
		role = null;
	}

	public void unsetShow() {
		show = null;
	}

	public void unsetTitle() {
		title = null;
	}

	public void unsetType() {
		type = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.ASSOCIATION;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
            throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		Association<T> copy = (Association<T>)target;
        
		if (isSetObject()) {
			copy.setObject((T)copyBuilder.copy(object));
			if (copy.getObject() == object)
				object.setParent(this);
		}
		
		if (isSetGenericADEComponent()) {
			copy.setGenericADEComponent((ADEComponent)copyBuilder.copy(genericADEComponent));
			if (copy.getGenericADEComponent() == genericADEComponent)
				genericADEComponent.setParent(this);
		}
			
		if (isSetActuate())
			copy.setActuate(copyBuilder.copy(actuate));

		if (isSetArcrole())
			copy.setArcrole(copyBuilder.copy(arcrole));
		
		if (isSetHref())
			copy.setHref(copyBuilder.copy(href));
		
		if (isSetRemoteSchema())
			copy.setRemoteSchema(copyBuilder.copy(remoteSchema));
		
		if (isSetRole())
			copy.setRole(copyBuilder.copy(role));
		
		if (isSetShow())
			copy.setShow(copyBuilder.copy(show));

		if (isSetTitle())
			copy.setTitle(copyBuilder.copy(title));
		
		if (isSetType())
			copy.setType(copyBuilder.copy(type));
		
		copy.unsetParent();
		
        return copy;
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

}
