package org.citygml4j.impl.citygml.core;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AbstractGMLImpl;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.module.citygml.CoreModule;

public class ImplicitGeometryImpl extends AbstractGMLImpl implements ImplicitGeometry {
	private String mimeType;
	private TransformationMatrix4x4 transformationMatrix;
	private String libraryObject;
	private GeometryProperty<? extends AbstractGeometry> relativeGeometry;
	private PointProperty referencePoint;
	private CoreModule module;	

	public ImplicitGeometryImpl() {
		
	}
	
	public ImplicitGeometryImpl(CoreModule module) {
		this.module = module;
	}
	
	public String getLibraryObject() {
		return libraryObject;
	}

	public String getMimeType() {
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

	public void setMimeType(String mimeType) {
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
		return copyTo(new ImplicitGeometryImpl(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ImplicitGeometry copy = (target == null) ? new ImplicitGeometryImpl() : (ImplicitGeometry)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetLibraryObject())
			copy.setLibraryObject(copyBuilder.copy(libraryObject));
		
		if (isSetMimeType())
			copy.setMimeType(copyBuilder.copy(mimeType));
		
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
