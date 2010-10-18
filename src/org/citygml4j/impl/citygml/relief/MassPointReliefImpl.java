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
package org.citygml4j.impl.citygml.relief;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.FeatureFunctor;
import org.citygml4j.model.common.visitor.FeatureVisitor;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.module.citygml.ReliefModule;

public class MassPointReliefImpl extends AbstractReliefComponentImpl implements MassPointRelief {
	private MultiPointProperty reliefPoints;
	private List<ADEComponent> ade;

	public MassPointReliefImpl() {

	}

	public MassPointReliefImpl(ReliefModule module) {
		super(module);
	}

	public void addGenericApplicationPropertyOfMassPointRelief(ADEComponent ade) {
		if (this.ade == null)
			this.ade = new ChildList<ADEComponent>(this);

		this.ade.add(ade);
	}

	public List<ADEComponent> getGenericApplicationPropertyOfMassPointRelief() {
		if (ade == null)
			ade = new ChildList<ADEComponent>(this);

		return ade;
	}

	public MultiPointProperty getReliefPoints() {
		return reliefPoints;
	}

	public boolean isSetGenericApplicationPropertyOfMassPointRelief() {
		return ade != null && !ade.isEmpty();
	}

	public boolean isSetReliefPoints() {
		return reliefPoints != null;
	}

	public void setGenericApplicationPropertyOfMassPointRelief(List<ADEComponent> ade) {
		this.ade = new ChildList<ADEComponent>(this, ade);
	}

	public void setReliefPoints(MultiPointProperty reliefPoints) {
		if (reliefPoints != null)
			reliefPoints.setParent(this);

		this.reliefPoints = reliefPoints;
	}

	public void unsetGenericApplicationPropertyOfMassPointRelief() {
		if (isSetGenericApplicationPropertyOfMassPointRelief())
			ade.clear();

		ade = null;
	}

	public boolean unsetGenericApplicationPropertyOfMassPointRelief(ADEComponent ade) {
		return isSetGenericApplicationPropertyOfMassPointRelief() ? this.ade.remove(ade) : false;
	}

	public void unsetReliefPoints() {
		if (isSetReliefPoints())
			reliefPoints.unsetParent();

		reliefPoints = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.MASSPOINT_RELIEF;
	}

	@Override
	public BoundingShape calcBoundedBy(boolean setBoundedBy) {
		BoundingShape boundedBy = super.calcBoundedBy(false);
		if (boundedBy == null)
			boundedBy = new BoundingShapeImpl();

		if (isSetReliefPoints()) {
			if (reliefPoints.isSetMultiPoint()) {
				calcBoundedBy(boundedBy, reliefPoints.getMultiPoint());
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

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MassPointReliefImpl(), copyBuilder);
	}

	@Override
	public LodRepresentation getLodRepresentation() {
		LodRepresentation lodRepresentation = new LodRepresentation();

		if (isSetReliefPoints()) {
			List<GeometryProperty<? extends AbstractGeometry>> propertyList = lodRepresentation.getLodGeometry(getLod());
			if (propertyList != null)
				propertyList.add(reliefPoints);
		}

		return lodRepresentation;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MassPointRelief copy = (target == null) ? new MassPointReliefImpl() : (MassPointRelief)target;
		super.copyTo(copy, copyBuilder);

		if (isSetReliefPoints()) {
			copy.setReliefPoints((MultiPointProperty)copyBuilder.copy(reliefPoints));
			if (copy.getReliefPoints() == reliefPoints)
				reliefPoints.setParent(this);
		}

		if (isSetGenericApplicationPropertyOfMassPointRelief()) {
			for (ADEComponent part : ade) {
				ADEComponent copyPart = (ADEComponent)copyBuilder.copy(part);
				copy.addGenericApplicationPropertyOfMassPointRelief(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		return copy;
	}

	public void accept(FeatureVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(FeatureFunctor<T> visitor) {
		return visitor.apply(this);
	}

	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
