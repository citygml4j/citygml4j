package org.citygml4j.model.citygml.core;

import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;

public interface TransformationMatrix3x4 extends CoreModuleComponent, Child, Copyable {
	public Matrix getMatrix();
	public boolean isSetMatrix();
	
	public void setMatrix(Matrix matrix);
}
