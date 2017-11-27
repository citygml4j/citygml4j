package org.citygml4j.builder.json.marshal.citygml.vegetation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.binding.json.feature.AbstractCityObjectType;
import org.citygml4j.binding.json.feature.PlantCoverAttributes;
import org.citygml4j.binding.json.feature.PlantCoverType;
import org.citygml4j.binding.json.feature.SolitaryVegetationObjectAttributes;
import org.citygml4j.binding.json.feature.SolitaryVegetationObjectType;
import org.citygml4j.binding.json.geometry.AbstractGeometryType;
import org.citygml4j.binding.json.geometry.GeometryTypeName;
import org.citygml4j.builder.json.marshal.CityJSONMarshaller;
import org.citygml4j.builder.json.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.util.mapper.TypeMapper;

public class VegetationMarshaller {
	private final CityJSONMarshaller json;
	private final CityGMLMarshaller citygml;
	private final TypeMapper<List<AbstractCityObjectType>> typeMapper;

	public VegetationMarshaller(CityGMLMarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONMarshaller();

		typeMapper = TypeMapper.<List<AbstractCityObjectType>>create()
				.with(PlantCover.class, this::marshalPlantCover)
				.with(SolitaryVegetationObject.class, this::marshalSolitaryVegetationObject);
	}

	public List<AbstractCityObjectType> marshal(ModelObject src) {
		return typeMapper.apply(src);
	}

	public void marshalPlantCover(PlantCover src, PlantCoverType dest) {
		PlantCoverAttributes attributes = new PlantCoverAttributes();
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, attributes);

		if (src.isSetClazz())
			attributes.setClazz(src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					attributes.setFunction(function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					attributes.setUsage(usage.getValue());
					break;
				}
			}
		}

		if (src.isSetAverageHeight())
			attributes.setAverageHeight(src.getAverageHeight().getValue());
		
		if (attributes.hasAttributes())
			dest.setAttributes(attributes);
		
		if (src.isSetLod1MultiSurface()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSurface());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod2MultiSurface()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2MultiSurface());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3MultiSurface()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3MultiSurface());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod1MultiSolid()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSolid());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod2MultiSolid()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2MultiSolid());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod3MultiSolid()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3MultiSolid());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
	}
	
	public List<AbstractCityObjectType> marshalPlantCover(PlantCover src) {
		PlantCoverType dest = new PlantCoverType(src.getId());
		marshalPlantCover(src, dest);

		return Collections.singletonList(dest);
	}

	public void marshalSolitaryVegetationObject(SolitaryVegetationObject src, SolitaryVegetationObjectType dest) {
		SolitaryVegetationObjectAttributes attributes = new SolitaryVegetationObjectAttributes();
		citygml.getCoreMarshaller().marshalAbstractCityObject(src, dest, attributes);

		if (src.isSetClazz())
			attributes.setClazz(src.getClazz().getValue());

		if (src.isSetFunction()) {
			for (Code function : src.getFunction()) {
				if (function.isSetValue()) {
					attributes.setFunction(function.getValue());
					break;
				}
			}
		}

		if (src.isSetUsage()) {
			for (Code usage : src.getUsage()) {
				if (usage.isSetValue()) {
					attributes.setUsage(usage.getValue());
					break;
				}
			}
		}

		if (src.isSetSpecies())
			attributes.setSpecies(src.getSpecies().getValue());

		if (src.isSetTrunkDiameter())
			attributes.setTrunkDiameter(src.getTrunkDiameter().getValue());

		if (src.isSetCrownDiameter())
			attributes.setCrownDiameter(src.getCrownDiameter().getValue());		

		if (attributes.hasAttributes())
			dest.setAttributes(attributes);

		Map<Integer, GeometryTypeName> geometryTypes = new HashMap<>();
		if (src.isSetLod1Geometry()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1Geometry());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
				geometryTypes.put(1, geometry.getType());
			}
		}

		if (src.isSetLod2Geometry()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
				geometryTypes.put(2, geometry.getType());
			}
		}

		if (src.isSetLod3Geometry()) {
			AbstractGeometryType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
				geometryTypes.put(3, geometry.getType());
			}
		}

		if (src.isSetLod1ImplicitRepresentation()) {
			AbstractGeometryType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(1) != geometry.getType()) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod2ImplicitRepresentation()) {
			AbstractGeometryType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(2) != geometry.getType()) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3ImplicitRepresentation()) {
			AbstractGeometryType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation());
			if (geometry != null && geometryTypes.get(3) != geometry.getType()) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
	}

	public List<AbstractCityObjectType> marshalSolitaryVegetationObject(SolitaryVegetationObject src) {
		SolitaryVegetationObjectType dest = new SolitaryVegetationObjectType(src.getId());
		marshalSolitaryVegetationObject(src, dest);

		return Collections.singletonList(dest);
	}
}
