package org.citygml4j.impl.jaxb.citygml.core._1;

import java.util.List;

import org.citygml4j.impl.jaxb.gml._3_1_1.AbstractGMLImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.PointPropertyImpl;
import org.citygml4j.jaxb.citygml.core._1.ImplicitGeometryType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.PointProperty;

public class ImplicitGeometryImpl extends AbstractGMLImpl implements ImplicitGeometry {
	private ImplicitGeometryType implicitGeometryType;

	public ImplicitGeometryImpl() {
		this(new ImplicitGeometryType());
	}

	public ImplicitGeometryImpl(ImplicitGeometryType implicitGeometryType) {
		super(implicitGeometryType);
		this.implicitGeometryType = implicitGeometryType;
	}

	@Override
	public ImplicitGeometryType getJAXBObject() {
		return implicitGeometryType;
	}

	public String getLibraryObject() {
		return implicitGeometryType.getLibraryObject();
	}

	public String getMimeType() {
		return implicitGeometryType.getMimeType();
	}

	public PointProperty getReferencePoint() {
		if (implicitGeometryType.isSetReferencePoint())
			return new PointPropertyImpl(implicitGeometryType.getReferencePoint());

		return null;
	}

	public GeometryProperty getRelativeGMLGeometry() {
		if (implicitGeometryType.isSetRelativeGMLGeometry())
			return new GeometryPropertyImpl(implicitGeometryType.getRelativeGMLGeometry());

		return null;
	}

	public TransformationMatrix4x4 getTransformationMatrix() {
		if (implicitGeometryType.isSetTransformationMatrix()) {
			List<Double> vals = implicitGeometryType.getTransformationMatrix();
			if (vals.size() >= 16) 
				return new TransformationMatrix4x4Impl(vals.subList(0, 16));
		}

		return null;
	}

	public void setLibraryObject(String libraryObject) {
		implicitGeometryType.setLibraryObject(libraryObject);
	}

	public void setMimeType(String mimeType) {
		implicitGeometryType.setMimeType(mimeType);
	}

	public void setReferencePoint(PointProperty referencePoint) {
		implicitGeometryType.setReferencePoint(((PointPropertyImpl)referencePoint).getJAXBObject());
	}

	public void setRelativeGeometry(GeometryProperty relativeGeometry) {
		implicitGeometryType.setRelativeGMLGeometry(((GeometryPropertyImpl)relativeGeometry).getJAXBObject());
	}

	public void setTransformationMatrix(TransformationMatrix4x4 transformationMatrix) {
		implicitGeometryType.unsetTransformationMatrix();
		implicitGeometryType.getTransformationMatrix().addAll(transformationMatrix.getMatrix().toRowPackedList());
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.IMPLICITGEOMETRY;
	}

	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}
	
	public boolean isSetLibraryObject() {
		return implicitGeometryType.isSetLibraryObject();
	}

	public boolean isSetMimeType() {
		return implicitGeometryType.isSetMimeType();
	}

	public boolean isSetReferencePoint() {
		return implicitGeometryType.isSetReferencePoint();
	}

	public boolean isSetRelativeGMLGeometry() {
		return implicitGeometryType.isSetRelativeGMLGeometry();
	}

	public boolean isSetTransformationMatrix() {
		return implicitGeometryType.isSetTransformationMatrix();
	}

	public void unsetLibraryObject() {
		implicitGeometryType.setLibraryObject(null);
	}

	public void unsetMimeType() {
		implicitGeometryType.setMimeType(null);
	}

	public void unsetReferencePoint() {
		implicitGeometryType.setReferencePoint(null);
	}

	public void unsetRelativeGMLGeometry() {
		implicitGeometryType.setRelativeGMLGeometry(null);
	}

	public void unsetTransformationMatrix() {
		implicitGeometryType.unsetTransformationMatrix();
	}
}
