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
package org.citygml4j.model.citygml.generics;

import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.StandardObjectClassifier;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;

public interface GenericCityObject extends GenericsModuleComponent, AbstractCityObject, StandardObjectClassifier {
	public GeometryProperty<? extends AbstractGeometry> getLod0Geometry();
	public GeometryProperty<? extends AbstractGeometry> getLod1Geometry();
	public GeometryProperty<? extends AbstractGeometry> getLod2Geometry();
	public GeometryProperty<? extends AbstractGeometry> getLod3Geometry();
	public GeometryProperty<? extends AbstractGeometry> getLod4Geometry();
	public MultiCurveProperty getLod0TerrainIntersection();
	public MultiCurveProperty getLod1TerrainIntersection();
	public MultiCurveProperty getLod2TerrainIntersection();
	public MultiCurveProperty getLod3TerrainIntersection();
	public MultiCurveProperty getLod4TerrainIntersection();
	public ImplicitRepresentationProperty getLod0ImplicitRepresentation();
	public ImplicitRepresentationProperty getLod1ImplicitRepresentation();
	public ImplicitRepresentationProperty getLod2ImplicitRepresentation();
	public ImplicitRepresentationProperty getLod3ImplicitRepresentation();
	public ImplicitRepresentationProperty getLod4ImplicitRepresentation();
	public boolean isSetLod0Geometry();
	public boolean isSetLod1Geometry();
	public boolean isSetLod2Geometry();
	public boolean isSetLod3Geometry();
	public boolean isSetLod4Geometry();
	public boolean isSetLod0TerrainIntersection();
	public boolean isSetLod1TerrainIntersection();
	public boolean isSetLod2TerrainIntersection();
	public boolean isSetLod3TerrainIntersection();
	public boolean isSetLod4TerrainIntersection();
	public boolean isSetLod0ImplicitRepresentation();
	public boolean isSetLod1ImplicitRepresentation();
	public boolean isSetLod2ImplicitRepresentation();
	public boolean isSetLod3ImplicitRepresentation();
	public boolean isSetLod4ImplicitRepresentation();
	
	public void setLod0Geometry(GeometryProperty<? extends AbstractGeometry> lod0Geometry);
	public void setLod1Geometry(GeometryProperty<? extends AbstractGeometry> lod1Geometry);
	public void setLod2Geometry(GeometryProperty<? extends AbstractGeometry> lod2Geometry);
	public void setLod3Geometry(GeometryProperty<? extends AbstractGeometry> lod3Geometry);
	public void setLod4Geometry(GeometryProperty<? extends AbstractGeometry> lod4Geometry);
	public void setLod0TerrainIntersection(MultiCurveProperty lod0TerrainIntersection);
	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection);
	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection);
	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection);
	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection);
	public void setLod0ImplicitRepresentation(ImplicitRepresentationProperty lod0ImplicitRepresentation);
	public void setLod1ImplicitRepresentation(ImplicitRepresentationProperty lod1ImplicitRepresentation);
	public void setLod2ImplicitRepresentation(ImplicitRepresentationProperty lod2ImplicitRepresentation);
	public void setLod3ImplicitRepresentation(ImplicitRepresentationProperty lod3ImplicitRepresentation);
	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation);
	public void unsetLod0Geometry();
	public void unsetLod1Geometry();
	public void unsetLod2Geometry();
	public void unsetLod3Geometry();
	public void unsetLod4Geometry();
	public void unsetLod0TerrainIntersection();
	public void unsetLod1TerrainIntersection();
	public void unsetLod2TerrainIntersection();
	public void unsetLod3TerrainIntersection();
	public void unsetLod4TerrainIntersection();
	public void unsetLod0ImplicitRepresentation();
	public void unsetLod1ImplicitRepresentation();
	public void unsetLod2ImplicitRepresentation();
	public void unsetLod3ImplicitRepresentation();
	public void unsetLod4ImplicitRepresentation();
}
