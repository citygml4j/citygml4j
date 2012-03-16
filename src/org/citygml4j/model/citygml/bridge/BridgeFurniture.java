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
package org.citygml4j.model.citygml.bridge;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface BridgeFurniture extends BridgeModuleComponent, AbstractCityObject, StandardObjectClassifier {
	public GeometryProperty<? extends AbstractGeometry> getLod4Geometry();
	public ImplicitRepresentationProperty getLod4ImplicitRepresentation();
	public List<ADEComponent> getGenericApplicationPropertyOfBridgeFurniture();
	public boolean isSetLod4Geometry();
	public boolean isSetLod4ImplicitRepresentation();
	public boolean isSetGenericApplicationPropertyOfBridgeFurniture();
	
	public void setLod4Geometry(GeometryProperty<? extends AbstractGeometry> lod4Geometry);
	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation);	
	public void addGenericApplicationPropertyOfBridgeFurniture(ADEComponent ade);
	public void setGenericApplicationPropertyOfBridgeFurniture(List<ADEComponent> ade);
	public void unsetLod4Geometry();
	public void unsetLod4ImplicitRepresentation();
	public void unsetGenericApplicationPropertyOfBridgeFurniture();
	public boolean unsetGenericApplicationPropertyOfBridgeFurniture(ADEComponent ade);
}
