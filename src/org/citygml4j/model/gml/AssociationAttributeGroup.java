package org.citygml4j.model.gml;

public interface AssociationAttributeGroup extends GML {
	public String getRemoteSchema();
	public String getType();
	public String getHref();
	public String getRole();
	public String getArcrole();
	public String getTitle();
	public String getShow();
	public String getActuate();
	public boolean isSetRemoteSchema();
	public boolean isSetType();
	public boolean isSetHref();
	public boolean isSetRole();
	public boolean isSetArcrole();
	public boolean isSetTitle();
	public boolean isSetShow();
	public boolean isSetActuate();

	public void setRemoteSchema(String remoteSchema);
	public void setType(String type);
	public void setHref(String href);
	public void setRole(String role);
	public void setArcrole(String arcrole);
	public void setTitle(String title);
	public void setShow(String show);
	public void setActuate(String actuate);
	public void unsetRemoteSchema();
	public void unsetType();
	public void unsetHref();
	public void unsetRole();
	public void unsetArcrole();
	public void unsetTitle();
	public void unsetShow();
	public void unsetActuate();
}
