package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.GeometricComplexType;
import org.citygml4j.jaxb.gml._3_1_1.GeometricPrimitivePropertyType;
import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricPrimitiveProperty;

public class GeometricComplexImpl extends AbstractGeometryImpl implements GeometricComplex {
	private GeometricComplexType geometricComplexType;

	public GeometricComplexImpl() {
		this(new GeometricComplexType());
	}

	public GeometricComplexImpl(GeometricComplexType geometricComplexType) {
		super(geometricComplexType);
		this.geometricComplexType = geometricComplexType;
	}

	@Override
	public GeometricComplexType getJAXBObject() {
		return geometricComplexType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRICCOMPLEX;
	}

	public List<GeometricPrimitiveProperty> getElement() {
		List<GeometricPrimitiveProperty> geometricPrimitivePropertyList = new ArrayList<GeometricPrimitiveProperty>();

		for (GeometricPrimitivePropertyType geometricPrimitivePropertyType : geometricComplexType.getElement())
			geometricPrimitivePropertyList.add(new GeometricPrimitivePropertyImpl(geometricPrimitivePropertyType));

		return geometricPrimitivePropertyList;
	}

	public void addElement(GeometricPrimitiveProperty geometricPrimitiveProperty) {
		geometricComplexType.getElement().add(((GeometricPrimitivePropertyImpl)geometricPrimitiveProperty).getJAXBObject());
	}

	public void setElement(List<GeometricPrimitiveProperty> geometricPrimitiveProperty) {
		List<GeometricPrimitivePropertyType> primitivePropertyTypeList = new ArrayList<GeometricPrimitivePropertyType>();

		for (GeometricPrimitiveProperty primitiveProperty : geometricPrimitiveProperty)
			primitivePropertyTypeList.add(((GeometricPrimitivePropertyImpl)primitiveProperty).getJAXBObject());

		geometricComplexType.unsetElement();
		geometricComplexType.getElement().addAll(primitivePropertyTypeList);
	}

	public void calcBoundingBox(Point min, Point max) {
		if (isSetElement()) {
			for (GeometricPrimitiveProperty geometricPrimitiveProperty : getElement()) {
				AbstractGeometricPrimitive abstractGeometricPrimitive = geometricPrimitiveProperty.getGeometricPrimitive();
				if (abstractGeometricPrimitive != null)
					abstractGeometricPrimitive.calcBoundingBox(min, max);
			}
		}
	}

	public boolean isSetElement() {
		return geometricComplexType.isSetElement();
	}

	public void unsetElement() {
		geometricComplexType.unsetElement();
	}

	public boolean unsetElement(GeometricPrimitiveProperty geometricPrimitiveProperty) {
		if (geometricComplexType.isSetElement())
			return geometricComplexType.getElement().remove(((GeometricPrimitivePropertyImpl)geometricPrimitiveProperty).getJAXBObject());
		
		return false;
	}

}
