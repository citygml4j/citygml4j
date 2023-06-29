/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
	String getRemoteSchema();
	XLinkType getType();
	String getHref();
	String getRole();
	String getArcrole();
	String getTitle();
	XLinkShow getShow();
	XLinkActuate getActuate();
	boolean isSetRemoteSchema();
	boolean isSetType();
	boolean isSetHref();
	boolean isSetRole();
	boolean isSetArcrole();
	boolean isSetTitle();
	boolean isSetShow();
	boolean isSetActuate();

	void setRemoteSchema(String remoteSchema);
	void setType(XLinkType type);
	void setHref(String href);
	void setRole(String role);
	void setArcrole(String arcrole);
	void setTitle(String title);
	void setShow(XLinkShow show);
	void setActuate(XLinkActuate actuate);
	void unsetRemoteSchema();
	void unsetType();
	void unsetHref();
	void unsetRole();
	void unsetArcrole();
	void unsetTitle();
	void unsetShow();
	void unsetActuate();
}
