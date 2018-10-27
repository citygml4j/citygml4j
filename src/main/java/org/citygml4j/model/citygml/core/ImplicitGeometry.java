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
package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.List;

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

	public BoundingBox calcBoundingBox(BoundingBoxOptions options) {
		if (relativeGeometry != null && relativeGeometry.isSetGeometry()) {
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
					bbox.transform3d(m);
				}

				return bbox;
			}
		} else if (options.isUseReferencePointAsFallbackForImplicitGeometries()
				&& referencePoint != null && referencePoint.isSetPoint()) {
			List<Double> coord = referencePoint.getPoint().toList3d();

			if (transformationMatrix != null) {
				Matrix m = transformationMatrix.getMatrix();
				coord.set(0, coord.get(0) + m.get(0, 3));
				coord.set(1, coord.get(1) + m.get(1, 3));
				coord.set(2, coord.get(2) + m.get(2, 3));
			}

			return new BoundingBox(
					new Point(coord.get(0), coord.get(1), coord.get(2)),
					new Point(coord.get(0), coord.get(1), coord.get(2)));			
		}

		return null;
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
