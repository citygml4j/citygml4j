/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.gml.base;

import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;


public interface AssociationAttributeGroup extends GML {
	public String getRemoteSchema();
	public XLinkType getType();
	public String getHref();
	public String getRole();
	public String getArcrole();
	public String getTitle();
	public XLinkShow getShow();
	public XLinkActuate getActuate();
	public boolean isSetRemoteSchema();
	public boolean isSetType();
	public boolean isSetHref();
	public boolean isSetRole();
	public boolean isSetArcrole();
	public boolean isSetTitle();
	public boolean isSetShow();
	public boolean isSetActuate();

	public void setRemoteSchema(String remoteSchema);
	public void setType(XLinkType type);
	public void setHref(String href);
	public void setRole(String role);
	public void setArcrole(String arcrole);
	public void setTitle(String title);
	public void setShow(XLinkShow show);
	public void setActuate(XLinkActuate actuate);
	public void unsetRemoteSchema();
	public void unsetType();
	public void unsetHref();
	public void unsetRole();
	public void unsetArcrole();
	public void unsetTitle();
	public void unsetShow();
	public void unsetActuate();
}
