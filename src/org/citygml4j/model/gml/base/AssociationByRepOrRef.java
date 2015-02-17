/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.gml.base;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;

public abstract class AssociationByRepOrRef<T extends Associable & Child> extends AssociationByRep<T> implements AssociationAttributeGroup {
	private XLinkActuate actuate;
	private String arcrole;
	private String href;
	private String remoteSchema;
	private String role;
	private XLinkShow show;
	private String title;
	private XLinkType type;
	
	public AssociationByRepOrRef() {

	}

	public AssociationByRepOrRef(T object) {
		super(object);
	}
	
	public AssociationByRepOrRef(String href) {
		this.href = href;
	}

	public XLinkActuate getActuate() {
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

	public XLinkShow getShow() {
		return show;
	}

	public String getTitle() {
		return title;
	}

	public XLinkType getType() {
		return type == null ? XLinkType.SIMPLE : type;
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

	public void setActuate(XLinkActuate actuate) {
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

	public void setShow(XLinkShow show) {
		this.show = show;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setType(XLinkType type) {
		this.type = XLinkType.SIMPLE;
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
		return GMLClass.ASSOCIATION_BY_REP_OR_REF;
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
            throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AssociationByRepOrRef<T> copy = (AssociationByRepOrRef<T>)target;
		super.copyTo(copy, copyBuilder);
			
		if (isSetActuate())
			copy.setActuate((XLinkActuate)copyBuilder.copy(actuate));

		if (isSetArcrole())
			copy.setArcrole(copyBuilder.copy(arcrole));
		
		if (isSetHref())
			copy.setHref(copyBuilder.copy(href));
		
		if (isSetRemoteSchema())
			copy.setRemoteSchema(copyBuilder.copy(remoteSchema));
		
		if (isSetRole())
			copy.setRole(copyBuilder.copy(role));
		
		if (isSetShow())
			copy.setShow((XLinkShow)copyBuilder.copy(show));

		if (isSetTitle())
			copy.setTitle(copyBuilder.copy(title));
		
		if (isSetType())
			copy.setType((XLinkType)copyBuilder.copy(type));
		
		copy.unsetParent();
		
        return copy;
	}

}
