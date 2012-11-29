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
 * $Id: ImplicitGeometry.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.module.citygml.CoreModule;

public class ImplicitGeometry extends AbstractGML implements CoreModuleComponent {
	private Code mimeType;
	private TransformationMatrix4x4 transformationMatrix;
	private String libraryObject;
	private GeometryProperty<? extends AbstractGeometry> relativeGeometry;
	private PointProperty referencePoint;
	private CoreModule module;	

	public ImplicitGeometry() {

	}

	public ImplicitGeometry(CoreModule module) {
		this.module = module;
	}

	public String getLibraryObject() {
		return libraryObject;
	}

	public Code getMimeType() {
		return mimeType;
	}

	public PointProperty getReferencePoint() {
		return referencePoint;
	}

	public GeometryProperty<? extends AbstractGeometry> getRelativeGMLGeometry() {
		return relativeGeometry;
	}

	public TransformationMatrix4x4 getTransformationMatrix() {
		return transformationMatrix;
	}

	public boolean isSetLibraryObject() {
		return libraryObject != null;
	}

	public boolean isSetMimeType() {
		return mimeType != null;
	}

	public boolean isSetReferencePoint() {
		return referencePoint != null;
	}

	public boolean isSetRelativeGMLGeometry() {
		return relativeGeometry != null;
	}

	public boolean isSetTransformationMatrix() {
		return transformationMatrix != null;
	}

	public void setLibraryObject(String libraryObject) {
		this.libraryObject = libraryObject;
	}

	public void setMimeType(Code mimeType) {
		this.mimeType = mimeType;
	}

	public void setReferencePoint(PointProperty referencePoint) {
		if (referencePoint != null)
			referencePoint.setParent(this);

		this.referencePoint = referencePoint;
	}

	public void setRelativeGeometry(GeometryProperty<? extends AbstractGeometry> relativeGeometry) {
		if (relativeGeometry != null)
			relativeGeometry.setParent(this);

		this.relativeGeometry = relativeGeometry;
	}

	public void setTransformationMatrix(TransformationMatrix4x4 transformationMatrix) {
		if (transformationMatrix != null)
			transformationMatrix.setParent(this);

		this.transformationMatrix = transformationMatrix;
	}

	public void unsetLibraryObject() {
		libraryObject = null;
	}

	public void unsetMimeType() {
		mimeType = null;
	}

	public void unsetReferencePoint() {
		if (isSetReferencePoint())
			referencePoint.unsetParent();

		referencePoint = null;
	}

	public void unsetRelativeGMLGeometry() {
		if (isSetRelativeGMLGeometry())
			relativeGeometry.unsetParent();

		relativeGeometry = null;
	}

	public void unsetTransformationMatrix() {
		if (isSetTransformationMatrix())
			transformationMatrix.unsetParent();

		transformationMatrix = null;
	}

	public BoundingBox calcBoundingBox() {
		if (relativeGeometry != null) {
			if (relativeGeometry.isSetGeometry()) {
				BoundingBox bbox = relativeGeometry.getGeometry().calcBoundingBox();
				if (bbox != null) {
					if (transformationMatrix != null && 
							referencePoint != null &&
							referencePoint.isSetPoint()) {
						Matrix m = transformationMatrix.getMatrix().copy();
						List<Double> point = referencePoint.getPoint().toList3d();								
						m.set(0, 3, m.get(0, 3) + point.get(0));
						m.set(1, 3, m.get(1, 3) + point.get(1));
						m.set(2, 3, m.get(2, 3) + point.get(2));
						bbox.transform3D(m);
					}
					
					return bbox;
				}
			} else {
				// xlink
			}
		}
		
		return null;
	}

	@Override
	public ModelType getModelType() {
		return ModelType.CITYGML;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.IMPLICIT_GEOMETRY;
	}

	public final CoreModule getCityGMLModule() {
		return module;
	}

	public boolean isSetCityGMLModule() {
		return module != null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ImplicitGeometry(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ImplicitGeometry copy = (target == null) ? new ImplicitGeometry() : (ImplicitGeometry)target;
		super.copyTo(copy, copyBuilder);

		if (isSetLibraryObject())
			copy.setLibraryObject(copyBuilder.copy(libraryObject));

		if (isSetMimeType())
			copy.setMimeType((Code)copyBuilder.copy(mimeType));

		if (isSetReferencePoint()) {
			copy.setReferencePoint((PointProperty)copyBuilder.copy(referencePoint));
			if (copy.getReferencePoint() == referencePoint)
				referencePoint.setParent(this);
		}

		if (isSetRelativeGMLGeometry()) {
			copy.setRelativeGeometry((GeometryProperty<? extends AbstractGeometry>)copyBuilder.copy(relativeGeometry));
			if (copy.getRelativeGMLGeometry() == relativeGeometry)
				relativeGeometry.setParent(this);
		}

		if (isSetTransformationMatrix()) {
			copy.setTransformationMatrix((TransformationMatrix4x4)copyBuilder.copy(transformationMatrix));
			if (copy.getTransformationMatrix() == transformationMatrix)
				transformationMatrix.setParent(this);
		}

		return copy;
	}

	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
