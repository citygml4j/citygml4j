package org.citygml4j.impl.jaxb.citygml.generics._0_4;

import java.util.List;

import org.citygml4j.impl.jaxb.citygml.core._0_4.CityObjectImpl;
import org.citygml4j.impl.jaxb.citygml.core._0_4.ImplicitRepresentationPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiCurvePropertyImpl;
import org.citygml4j.jaxb.citygml._0_4.GenericCityObjectType;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.citygml.generics.GenericsModule;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.MultiCurveProperty;

public class GenericCityObjectImpl extends CityObjectImpl implements GenericCityObject {
	private GenericCityObjectType genericCityObjectType;
	
	public GenericCityObjectImpl() {
		this(new GenericCityObjectType());
	}
	
	public GenericCityObjectImpl(GenericCityObjectType genericCityObjectType) {
		super(genericCityObjectType);
		this.genericCityObjectType = genericCityObjectType;
	}
	
	@Override
	public GenericCityObjectType getJAXBObject() {
		return genericCityObjectType;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.GENERICCITYOBJECT;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return GenericsModule.v0_4_0;
	}
	
	public void addFunction(String function) {
		genericCityObjectType.getFunction().add(function);
	}

	public void addUsage(String usage) {
		genericCityObjectType.getUsage().add(usage);
	}

	public String getClazz() {
		return genericCityObjectType.getClazz();
	}

	public List<String> getFunction() {
		return genericCityObjectType.getFunction();
	}

	public GeometryProperty getLod0Geometry() {
		if (genericCityObjectType.isSetLod0Geometry())
			return new GeometryPropertyImpl(genericCityObjectType.getLod0Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod0ImplicitRepresentation() {
		if (genericCityObjectType.isSetLod0ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(genericCityObjectType.getLod0ImplicitRepresentation());

		return null;
	}

	public MultiCurveProperty getLod0TerrainIntersection() {
		if (genericCityObjectType.isSetLod0TerrainIntersection())
			return new MultiCurvePropertyImpl(genericCityObjectType.getLod0TerrainIntersection());

		return null;
	}

	public GeometryProperty getLod1Geometry() {
		if (genericCityObjectType.isSetLod1Geometry())
			return new GeometryPropertyImpl(genericCityObjectType.getLod1Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod1ImplicitRepresentation() {
		if (genericCityObjectType.isSetLod1ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(genericCityObjectType.getLod1ImplicitRepresentation());

		return null;
	}

	public MultiCurveProperty getLod1TerrainIntersection() {
		if (genericCityObjectType.isSetLod1TerrainIntersection())
			return new MultiCurvePropertyImpl(genericCityObjectType.getLod1TerrainIntersection());

		return null;
	}

	public GeometryProperty getLod2Geometry() {
		if (genericCityObjectType.isSetLod2Geometry())
			return new GeometryPropertyImpl(genericCityObjectType.getLod2Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod2ImplicitRepresentation() {
		if (genericCityObjectType.isSetLod2ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(genericCityObjectType.getLod2ImplicitRepresentation());

		return null;
	}

	public MultiCurveProperty getLod2TerrainIntersection() {
		if (genericCityObjectType.isSetLod2TerrainIntersection())
			return new MultiCurvePropertyImpl(genericCityObjectType.getLod2TerrainIntersection());

		return null;
	}

	public GeometryProperty getLod3Geometry() {
		if (genericCityObjectType.isSetLod3Geometry())
			return new GeometryPropertyImpl(genericCityObjectType.getLod3Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod3ImplicitRepresentation() {
		if (genericCityObjectType.isSetLod3ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(genericCityObjectType.getLod3ImplicitRepresentation());

		return null;
	}

	public MultiCurveProperty getLod3TerrainIntersection() {
		if (genericCityObjectType.isSetLod3TerrainIntersection())
			return new MultiCurvePropertyImpl(genericCityObjectType.getLod3TerrainIntersection());

		return null;
	}

	public GeometryProperty getLod4Geometry() {
		if (genericCityObjectType.isSetLod4Geometry())
			return new GeometryPropertyImpl(genericCityObjectType.getLod4Geometry());

		return null;
	}

	public ImplicitRepresentationProperty getLod4ImplicitRepresentation() {
		if (genericCityObjectType.isSetLod4ImplicitRepresentation())
			return new ImplicitRepresentationPropertyImpl(genericCityObjectType.getLod4ImplicitRepresentation());

		return null;
	}

	public MultiCurveProperty getLod4TerrainIntersection() {
		if (genericCityObjectType.isSetLod4TerrainIntersection())
			return new MultiCurvePropertyImpl(genericCityObjectType.getLod4TerrainIntersection());

		return null;
	}

	public List<String> getUsage() {
		return genericCityObjectType.getUsage();
	}

	public void setClazz(String clazz) {
		genericCityObjectType.setClazz(clazz);
	}

	public void setFunction(List<String> function) {
		genericCityObjectType.unsetFunction();
		genericCityObjectType.getFunction().addAll(function);
	}

	public void setLod0Geometry(GeometryProperty lod0Geometry) {
		genericCityObjectType.setLod0Geometry(((GeometryPropertyImpl)lod0Geometry).getJAXBObject());
	}

	public void setLod0ImplicitRepresentation(ImplicitRepresentationProperty lod0ImplicitRepresentation) {
		genericCityObjectType.setLod0ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod0ImplicitRepresentation).getJAXBObject());
	}

	public void setLod1Geometry(GeometryProperty lod1Geometry) {
		genericCityObjectType.setLod1Geometry(((GeometryPropertyImpl)lod1Geometry).getJAXBObject());
	}

	public void setLod1ImplicitRepresentation(ImplicitRepresentationProperty lod1ImplicitRepresentation) {
		genericCityObjectType.setLod1ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod1ImplicitRepresentation).getJAXBObject());
	}

	public void setLod2Geometry(GeometryProperty lod2Geometry) {
		genericCityObjectType.setLod2Geometry(((GeometryPropertyImpl)lod2Geometry).getJAXBObject());
	}

	public void setLod2ImplicitRepresentation(ImplicitRepresentationProperty lod2ImplicitRepresentation) {
		genericCityObjectType.setLod2ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod2ImplicitRepresentation).getJAXBObject());
	}

	public void setLod3Geometry(GeometryProperty lod3Geometry) {
		genericCityObjectType.setLod3Geometry(((GeometryPropertyImpl)lod3Geometry).getJAXBObject());
	}

	public void setLod3ImplicitRepresentation(ImplicitRepresentationProperty lod3ImplicitRepresentation) {
		genericCityObjectType.setLod3ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod3ImplicitRepresentation).getJAXBObject());
	}

	public void setLod4Geometry(GeometryProperty lod4Geometry) {
		genericCityObjectType.setLod4Geometry(((GeometryPropertyImpl)lod4Geometry).getJAXBObject());
	}

	public void setLod4ImplicitRepresentation(ImplicitRepresentationProperty lod4ImplicitRepresentation) {
		genericCityObjectType.setLod4ImplicitRepresentation(((ImplicitRepresentationPropertyImpl)lod4ImplicitRepresentation).getJAXBObject());
	}

	public void setUsage(List<String> usage) {
		genericCityObjectType.unsetUsage();
		genericCityObjectType.getUsage().addAll(usage);
	}
	
	public void setLod0TerrainIntersection(MultiCurveProperty lod0TerrainIntersection) {
		genericCityObjectType.setLod0TerrainIntersection(((MultiCurvePropertyImpl)lod0TerrainIntersection).getJAXBObject());
	}

	public void setLod1TerrainIntersection(MultiCurveProperty lod1TerrainIntersection) {
		genericCityObjectType.setLod1TerrainIntersection(((MultiCurvePropertyImpl)lod1TerrainIntersection).getJAXBObject());
	}

	public void setLod2TerrainIntersection(MultiCurveProperty lod2TerrainIntersection) {
		genericCityObjectType.setLod2TerrainIntersection(((MultiCurvePropertyImpl)lod2TerrainIntersection).getJAXBObject());
	}

	public void setLod3TerrainIntersection(MultiCurveProperty lod3TerrainIntersection) {
		genericCityObjectType.setLod3TerrainIntersection(((MultiCurvePropertyImpl)lod3TerrainIntersection).getJAXBObject());
	}

	public void setLod4TerrainIntersection(MultiCurveProperty lod4TerrainIntersection) {
		genericCityObjectType.setLod4TerrainIntersection(((MultiCurvePropertyImpl)lod4TerrainIntersection).getJAXBObject());
	}

	@Override
	public void calcBoundedBy() {
		// obviously we cannot rely on remote geometry objects for this...
		GeometryProperty geometryProperty = null;

		for (int lod = 0; lod < 5; lod++) {
			switch (lod) {
			case 0:
				geometryProperty = getLod0Geometry();
				break;
			case 1:
				geometryProperty = getLod1Geometry();
				break;
			case 2:
				geometryProperty = getLod2Geometry();
				break;
			case 3:
				geometryProperty = getLod3Geometry();
				break;
			case 4:
				geometryProperty = getLod4Geometry();
				break;
			}

			if (geometryProperty != null) {
				AbstractGeometry abstractGeometry = geometryProperty.getGeometry();
				if (abstractGeometry != null) {
					calcBoundedBy(abstractGeometry);
				} else {
					// xlink?
				}
			}
		}
	}

	public boolean isSetClazz() {
		return genericCityObjectType.isSetClazz();
	}

	public boolean isSetFunction() {
		return genericCityObjectType.isSetFunction();
	}

	public boolean isSetLod0Geometry() {
		return genericCityObjectType.isSetLod0Geometry();
	}

	public boolean isSetLod0ImplicitRepresentation() {
		return genericCityObjectType.isSetLod0ImplicitRepresentation();
	}

	public boolean isSetLod0TerrainIntersection() {
		return genericCityObjectType.isSetLod0TerrainIntersection();
	}

	public boolean isSetLod1Geometry() {
		return genericCityObjectType.isSetLod1Geometry();
	}

	public boolean isSetLod1ImplicitRepresentation() {
		return genericCityObjectType.isSetLod1ImplicitRepresentation();
	}

	public boolean isSetLod1TerrainIntersection() {
		return genericCityObjectType.isSetLod1TerrainIntersection();
	}

	public boolean isSetLod2Geometry() {
		return genericCityObjectType.isSetLod2Geometry();
	}

	public boolean isSetLod2ImplicitRepresentation() {
		return genericCityObjectType.isSetLod2ImplicitRepresentation();
	}

	public boolean isSetLod2TerainIntersection() {
		return genericCityObjectType.isSetLod2TerrainIntersection();
	}

	public boolean isSetLod3Geometry() {
		return genericCityObjectType.isSetLod3Geometry();
	}

	public boolean isSetLod3ImplicitRepresentation() {
		return genericCityObjectType.isSetLod3ImplicitRepresentation();
	}

	public boolean isSetLod3TerrainIntersection() {
		return genericCityObjectType.isSetLod3TerrainIntersection();
	}

	public boolean isSetLod4Geometry() {
		return genericCityObjectType.isSetLod4Geometry();
	}

	public boolean isSetLod4ImplicitRepresentation() {
		return genericCityObjectType.isSetLod4ImplicitRepresentation();
	}

	public boolean isSetLod4TerrainIntersection() {
		return genericCityObjectType.isSetLod4TerrainIntersection();
	}

	public boolean isSetUsage() {
		return genericCityObjectType.isSetUsage();
	}

	public void unsetClazz() {
		genericCityObjectType.setClazz(null);
	}

	public void unsetFunction() {
		genericCityObjectType.unsetFunction();
	}

	public void unsetLod0Geometry() {
		genericCityObjectType.setLod0Geometry(null);
	}

	public void unsetLod0ImplicitRepresentation() {
		genericCityObjectType.setLod0ImplicitRepresentation(null);
	}

	public void unsetLod0TerrainIntersection() {
		genericCityObjectType.setLod0TerrainIntersection(null);
	}

	public void unsetLod1Geometry() {
		genericCityObjectType.setLod1Geometry(null);
	}

	public void unsetLod1ImplicitRepresentation() {
		genericCityObjectType.setLod1ImplicitRepresentation(null);
	}

	public void unsetLod1TerrainIntersection() {
		genericCityObjectType.setLod1TerrainIntersection(null);
	}

	public void unsetLod2Geometry() {
		genericCityObjectType.setLod2Geometry(null);
	}

	public void unsetLod2ImplicitRepresentation() {
		genericCityObjectType.setLod2ImplicitRepresentation(null);
	}

	public void unsetLod2TerrainIntersection() {
		genericCityObjectType.setLod2TerrainIntersection(null);
	}

	public void unsetLod3Geometry() {
		genericCityObjectType.setLod3Geometry(null);
	}

	public void unsetLod3ImplicitRepresentation() {
		genericCityObjectType.setLod3ImplicitRepresentation(null);
	}

	public void unsetLod3TerrainIntersection() {
		genericCityObjectType.setLod3TerrainIntersection(null);
	}

	public void unsetLod4Geometry() {
		genericCityObjectType.setLod4Geometry(null);
	}

	public void unsetLod4ImplicitRepresentation() {
		genericCityObjectType.setLod4ImplicitRepresentation(null);
	}

	public void unsetLod4TerrainIntersection() {
		genericCityObjectType.setLod4TerrainIntersection(null);
	}

	public void unsetUsage() {
		genericCityObjectType.unsetUsage();
	}

	public boolean unsetFunction(String function) {
		if (genericCityObjectType.isSetFunction())
			return genericCityObjectType.getFunction().remove(function);
		
		return false;
	}
	
	public boolean unsetUsage(String usage) {
		if (genericCityObjectType.isSetUsage())
			return genericCityObjectType.getUsage().remove(usage);
		
		return false;
	}
	
}
