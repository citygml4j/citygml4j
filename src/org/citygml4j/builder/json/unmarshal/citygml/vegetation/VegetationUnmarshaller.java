package org.citygml4j.builder.json.unmarshal.citygml.vegetation;

import org.citygml4j.binding.json.CityJSON;
import org.citygml4j.binding.json.feature.AbstractCityObjectType;
import org.citygml4j.binding.json.feature.PlantCoverAttributes;
import org.citygml4j.binding.json.feature.PlantCoverType;
import org.citygml4j.binding.json.feature.SolitaryVegetationObjectAttributes;
import org.citygml4j.binding.json.feature.SolitaryVegetationObjectType;
import org.citygml4j.binding.json.geometry.AbstractGeometryType;
import org.citygml4j.builder.json.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.json.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolidProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

public class VegetationUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	private final BiFunctionTypeMapper<CityJSON, AbstractCityObject> typeMapper;

	public VegetationUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();

		typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObject>create()
				.with(PlantCoverType.class, this::unmarshalPlantCover)
				.with(SolitaryVegetationObjectType.class, this::unmarshalSolitaryVegetationObject);
	}

	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		return typeMapper.apply(src, cityJSON);
	}
	
	public void unmarshalPlantCover(PlantCoverType src, PlantCover dest) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);
		
		if (src.isSetAttributes()) {
			PlantCoverAttributes attributes = src.getAttributes();
			
			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));
			
			if (attributes.isSetAverageHeight())
				dest.setAverageHeight(new Length(attributes.getAverageHeight()));
		}
		
		for (AbstractGeometryType geometryType : src.getGeometry()) {
			AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryType, dest);

			if (geometry != null) {
				int lod = geometryType.getLod().intValue();

				if (geometry instanceof MultiSurface) {
					MultiSurface multiSurface = (MultiSurface)geometry;
					switch (lod) {
					case 1:
						dest.setLod1MultiSurface(new MultiSurfaceProperty(multiSurface));
						break;
					case 2:
						dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
						break;
					case 3:
						dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
						break;
					}
				}

				else if (geometry instanceof MultiSolid) {
					MultiSolid multiSolid = (MultiSolid)geometry;
					switch (lod) {
					case 1:
						dest.setLod1MultiSolid(new MultiSolidProperty(multiSolid));
						break;
					case 2:
						dest.setLod2MultiSolid(new MultiSolidProperty(multiSolid));
						break;
					case 3:
						dest.setLod3MultiSolid(new MultiSolidProperty(multiSolid));
						break;
					}
				}
			}
		}
	}

	public PlantCover unmarshalPlantCover(PlantCoverType src, CityJSON cityJSON) {
		PlantCover dest = new PlantCover();
		unmarshalPlantCover(src, dest);
		
		return dest;
	}

	public void unmarshalSolitaryVegetationObject(SolitaryVegetationObjectType src, SolitaryVegetationObject dest) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);
		
		if (src.isSetAttributes()) {
			SolitaryVegetationObjectAttributes attributes = src.getAttributes();
			
			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));
			
			if (attributes.isSetSpecies())
				dest.setSpecies(new Code(attributes.getSpecies()));
			
			if (attributes.isSetTrunkDiameter())
				dest.setTrunkDiameter(new Length(attributes.getTrunkDiameter()));
			
			if (attributes.isSetCrownDiameter())
				dest.setCrownDiameter(new Length(attributes.getCrownDiameter()));
		}
		
		for (AbstractGeometryType geometryType : src.getGeometry()) {
			AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryType, dest);

			if (geometry != null) {
				int lod = geometryType.getLod().intValue();
				switch (lod) {
				case 1:
					dest.setLod1Geometry(new GeometryProperty<>(geometry));
					break;
				case 2:
					dest.setLod2Geometry(new GeometryProperty<>(geometry));
					break;
				case 3:
					dest.setLod3Geometry(new GeometryProperty<>(geometry));
					break;
				}
			}	
		}
	}
	
	public SolitaryVegetationObject unmarshalSolitaryVegetationObject(SolitaryVegetationObjectType src, CityJSON cityJSON) {
		SolitaryVegetationObject dest = new SolitaryVegetationObject();
		unmarshalSolitaryVegetationObject(src, dest);

		return dest;
	}
}
