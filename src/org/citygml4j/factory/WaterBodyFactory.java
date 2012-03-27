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
package org.citygml4j.factory;

import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;

public class WaterBodyFactory {

	public WaterBodyFactory() {
		
	}

	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty() {
		return new BoundedByWaterSurfaceProperty();
	}
	
	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty(AbstractWaterBoundarySurface waterBoundarySurface) {
		BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty = new BoundedByWaterSurfaceProperty();
		boundedByWaterSurfaceProperty.setWaterBoundarySurface(waterBoundarySurface);
		return boundedByWaterSurfaceProperty;
	}
	
	public BoundedByWaterSurfaceProperty createBoundedByWaterSurfaceProperty(String xlink) {
		BoundedByWaterSurfaceProperty boundedByWaterSurfaceProperty = new BoundedByWaterSurfaceProperty();
		boundedByWaterSurfaceProperty.setHref(xlink);
		return boundedByWaterSurfaceProperty;
	}

	public WaterBody createWaterBody() {
		return new WaterBody();
	}

	public WaterClosureSurface createWaterClosureSurface() {
		return new WaterClosureSurface();
	}

	public WaterGroundSurface createWaterGroundSurface() {
		return new WaterGroundSurface();
	}

	public WaterSurface createWaterSurface() {
		return new WaterSurface();
	}
		
}
