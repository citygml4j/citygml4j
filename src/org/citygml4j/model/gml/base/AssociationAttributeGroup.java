/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.base;

import org.citygml4j.model.gml.GML;


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
