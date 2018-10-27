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
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CoreModule;

import java.util.List;

public class TransformationMatrix4x4 implements CoreModuleComponent, Child, Copyable {
	private Matrix matrix;
	private CoreModule module;
	private ModelObject parent;
	
	public TransformationMatrix4x4() {
		matrix = new Matrix(4, 4);
	}

	public TransformationMatrix4x4(CoreModule module) {
		this.module = module;
	}
	
	public TransformationMatrix4x4(Matrix matrix) {
		if (matrix == null)
			throw new IllegalArgumentException("Matrix must not be null.");
		
		if (matrix.getRowDimension() != 4 || matrix.getColumnDimension() != 4)
			throw new IllegalArgumentException("Matrix dimensions must be 4x4.");
		
		this.matrix = matrix;
	}
	
	public TransformationMatrix4x4(List<Double> vals) {
		if (vals == null)
			throw new IllegalArgumentException("Value list must not be null.");
		
		if (vals.size() != 16)
			throw new IllegalArgumentException("List size must be 16.");

		matrix = new Matrix(4, 4);
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
		
		if (matrix.getRowDimension() != 4 || matrix.getColumnDimension() != 4)
			throw new IllegalArgumentException("Matrix dimensions must be 4x4.");

		this.matrix = matrix;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSFORMATION_MATRIX_4X4;
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
		return copyTo(new TransformationMatrix4x4(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TransformationMatrix4x4 copy = (target == null) ? new TransformationMatrix4x4() : (TransformationMatrix4x4)target;
		
		copy.setMatrix((Matrix)copyBuilder.copy(matrix));
		
		copy.unsetParent();
		
		return copy;
	}
	
}
