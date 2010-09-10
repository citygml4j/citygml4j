package org.citygml4j.model.citygml.core;

import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;

public interface ImplicitGeometry extends CoreModuleComponent, AbstractGML {
	public String getMimeType();
	public TransformationMatrix4x4 getTransformationMatrix();
	public String getLibraryObject();
	public GeometryProperty<? extends AbstractGeometry> getRelativeGMLGeometry();
	public PointProperty getReferencePoint();
	public boolean isSetMimeType();
	public boolean isSetTransformationMatrix();
	public boolean isSetLibraryObject();
	public boolean isSetRelativeGMLGeometry();
	public boolean isSetReferencePoint();
	
	public void setMimeType(String mimeType);
	public void setTransformationMatrix(TransformationMatrix4x4 transformationMatrix);
	public void setLibraryObject(String libraryObject);
	public void setRelativeGeometry(GeometryProperty<? extends AbstractGeometry> relativeGeometry);
	public void setReferencePoint(PointProperty referencePoint);
	public void unsetMimeType();
	public void unsetTransformationMatrix();
	public void unsetLibraryObject();
	public void unsetRelativeGMLGeometry();
	public void unsetReferencePoint();

}
