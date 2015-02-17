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
package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CoreModule;

public class TransformationMatrix2x2 implements CoreModuleComponent, Child, Copyable {
	private Matrix matrix;
	private CoreModule module;
	private ModelObject parent;
	
	public TransformationMatrix2x2() {
		matrix = new Matrix(2, 2);
	}

	public TransformationMatrix2x2(CoreModule module) {
		this.module = module;
	}
	
	public TransformationMatrix2x2(Matrix matrix) {
		if (matrix == null)
			throw new IllegalArgumentException("Matrix must not be null.");
		
		if (matrix.getRowDimension() != 2 || matrix.getColumnDimension() != 2)
			throw new IllegalArgumentException("Matrix dimensions must be 2x2.");
		
		this.matrix = matrix;
	}

	public TransformationMatrix2x2(List<Double> vals) {
		if (vals == null)
			throw new IllegalArgumentException("Value list must not be null.");
		
		if (vals.size() != 4)
			throw new IllegalArgumentException("List size must be 4.");

		matrix = new Matrix(2, 2);
		matrix.setMatrix(vals);
	}

	public Matrix getMatrix() {
		return matrix;
	}
	
	public boolean isSetMatrix() {
		return matrix != null;
	}

	public void setMatrix(Matrix matrix) {
		if (matrix == null)
			throw new IllegalArgumentException("Matrix must not be null.");
		
		if (matrix.getRowDimension() != 2 || matrix.getColumnDimension() != 2)
			throw new IllegalArgumentException("Matrix dimensions must be 2x2.");

		this.matrix = matrix;
	}

	public ModelType getModelType() {
		return ModelType.CITYGML;
	}
	
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSFORMATION_MATRIX_2X2;
	}

	public CityGMLModule getCityGMLModule() {
		return module;
	}
	
	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TransformationMatrix2x2(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TransformationMatrix2x2 copy = (target == null) ? new TransformationMatrix2x2() : (TransformationMatrix2x2)target;
		
		copy.setMatrix((Matrix)copyBuilder.copy(matrix));
		
		copy.unsetParent();
		
		return copy;
	}
	
}
