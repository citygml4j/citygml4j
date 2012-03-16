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
package org.citygml4j.model.citygml.building;

import java.util.List;

import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface IntBuildingInstallation extends BuildingModuleComponent, AbstractCityObject, StandardObjectClassifier {
	public GeometryProperty<? extends AbstractGeometry> getLod4Geometry();
	public ImplicitRepresentationProperty getLod4ImplicitRepresentation();
	public List<BoundarySurfaceProperty> getBoundedBySurface();
	public List<ADEComponent> getGenericApplicationPropertyOfIntBuildingInstallation();
	public boolean isSetLod4Geometry();
	public boolean isSetLod4ImplicitRepresentation();
	public boolean isSetBoundedBySurface();
	public boolean isSetGenericApplicationPropertyOfIntBuildingInstallation();
	
	public void setLod4Geometry(GeometryProperty<? extends AbstractGeometry> lod4Geometry);	
	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation);
	public void addGenericApplicationPropertyOfIntBuildingInstallation(ADEComponent ade);
	public void setGenericApplicationPropertyOfIntBuildingInstallation(List<ADEComponent> ade);
	public void setBoundedBySurface(List<BoundarySurfaceProperty> boundedBySurface);
	public void addBoundedBySurface(BoundarySurfaceProperty boundedBySurface);
	public void unsetLod4Geometry();
	public void unsetLod4ImplicitRepresentation();
	public void unsetBoundedBySurface();
	public boolean unsetBoundedBySurface(BoundarySurfaceProperty boundedBySurface);
	public void unsetGenericApplicationPropertyOfIntBuildingInstallation();
	public boolean unsetGenericApplicationPropertyOfIntBuildingInstallation(ADEComponent ade);
}
