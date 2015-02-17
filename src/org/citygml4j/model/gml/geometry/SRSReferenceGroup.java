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
package org.citygml4j.model.gml.geometry;

public interface SRSReferenceGroup extends SRSInformationGroup {
	public String getSrsName();
	public String getInheritedSrsName();
	public Integer getSrsDimension();
	public boolean isSetSrsName();
	public boolean isSetSrsDimension();

	public void setSrsName(String srsName);
	public void setSrsDimension(Integer srsDimension);
	public void unsetSrsName();
	public void unsetSrsDimension();
}
