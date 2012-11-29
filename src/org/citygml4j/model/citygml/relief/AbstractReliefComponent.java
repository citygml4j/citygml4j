/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id$
 */
package org.citygml4j.model.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public abstract class AbstractReliefComponent extends AbstractCityObject implements ReliefModuleComponent {
	private int lod;
	private PolygonProperty extent;
	private List<ADEComponent> ade;
	private ReliefModule module;

	public AbstractReliefComponent() {
		
	}
	
	public AbstractReliefComponent(ReliefModule module) {
		this.module = module;
	}
	
	public void addGenericApplicationPropertyOfReliefComponent(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);
		
		this.ade.add(ade);
	}

	public PolygonProperty getExtent() {
		return extent;
	}

	public List<ADEComponent> getGenericApplicationPropertyOfReliefComponent() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public int getLod() {
		return lod;
	}

	public boolean isSetExtent() {
		return extent != null;
	}

	public boolean isSetGenericApplicationPropertyOfReliefComponent() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetLod() {
		return true;
	}

	public void setExtent(PolygonProperty extent) {
		if (extent != null)
			extent.setParent(this);

		this.extent = extent;
	}

	public void setGenericApplicationPropertyOfReliefComponent(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setLod(int lod) {
		if (lod >= 0 && lod <= 4)
			this.lod = lod;
	}

	public void unsetExtent() {
		if (isSetExtent())
			extent.unsetParent();

		extent = null;
	}

	public void unsetGenericApplicationPropertyOfReliefComponent() {
		if (isSetGenericApplicationPropertyOfReliefComponent())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfReliefComponent(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfReliefComponent() ? this.ade.remove(ade) : false;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = new BoundingShape();

		if (isSetExtent()) {
			if (extent.isSetPolygon()) {
				calcBoundedBy(boundedBy, extent.getPolygon());	
			} else {
				// xlink
			}
		}						

		if (boundedBy.isSetEnvelope()) {
			if (setBoundedBy)
				setBoundedBy(boundedBy);

			return boundedBy;
		} else
			return null;
	}

	public final ReliefModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		if (target == null)
			throw new IllegalArgumentException("Target argument must not be null for abstract copyable classes.");

		AbstractReliefComponent copy = (AbstractReliefComponent)target;		
		super.copyTo(copy, copyBuilder);

		if (isSetLod())
			copy.setLod(copyBuilder.copy(lod));

		if (isSetExtent()) {
			copy.setExtent((PolygonProperty)copyBuilder.copy(extent));
			if (copy.getExtent() == extent)
				extent.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfReliefComponent()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfReliefComponent(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}
}
