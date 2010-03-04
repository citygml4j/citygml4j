package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.MetaData;
import org.citygml4j.model.gml.MetaDataProperty;

public class MetaDataPropertyImpl implements MetaDataProperty {
	private MetaData metaData;
	private String about;
	private String actuate;
	private String arcrole;
	private String href;
	private String remoteSchema;
	private String role;
	private String show;
	private String title;
	private String type;
	private Object parent;
	
	public String getAbout() {
		return about;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public boolean isSetAbout() {
		return about != null;
	}

	public boolean isSetMetaData() {
		return metaData != null;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setMetaData(MetaData metaData) {
		if (metaData != null)
			metaData.setParent(this);
		
		this.metaData = metaData;
	}

	public void unsetAbout() {
		about = null;
	}

	public void unsetMetaData() {
		if (isSetMetaData())
			metaData.unsetParent();
		
		metaData = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.METADATAPROPERTY;
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
		return copyTo(new MetaDataPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MetaDataProperty copy = (target == null) ? new MetaDataPropertyImpl() : (MetaDataProperty)target;
		
		if (isSetMetaData()) {
			copy.setMetaData((MetaData)copyBuilder.copy(metaData));
			if (copy.getMetaData() == metaData)
				metaData.setParent(this);
		}
		
		if (isSetAbout())
			copy.setAbout(copyBuilder.copy(about));
		
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

}
