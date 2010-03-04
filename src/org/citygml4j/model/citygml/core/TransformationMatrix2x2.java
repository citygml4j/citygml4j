package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.geometry.Matrix;

public interface TransformationMatrix2x2 extends CoreModuleComponent, Child, Copyable {
	public Matrix getMatrix();
	public boolean isSetMatrix();

	public void setMatrix(Matrix matrix);
}
