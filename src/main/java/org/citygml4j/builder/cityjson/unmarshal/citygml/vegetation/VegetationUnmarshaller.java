/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.cityjson.unmarshal.citygml.vegetation;

import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.*;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.ImplicitGeometry;
import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.vegetation.AbstractVegetationObject;
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

import java.util.concurrent.locks.ReentrantLock;

public class VegetationUnmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	private BiFunctionTypeMapper<CityJSON, AbstractCityObject> typeMapper;

	public VegetationUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}

	private BiFunctionTypeMapper<CityJSON, AbstractCityObject> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObject>create()
							.with(PlantCoverType.class, this::unmarshalPlantCover)
							.with(SolitaryVegetationObjectType.class, this::unmarshalSolitaryVegetationObject);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		return getTypeMapper().apply(src, cityJSON);
	}

	public void unmarshalAbstractVegetationObject(AbstractVegetationObjectType src, AbstractVegetationObject dest, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest, cityJSON);
	}
	
	public void unmarshalPlantCover(PlantCoverType src, PlantCover dest, CityJSON cityJSON) {
		unmarshalAbstractVegetationObject(src, dest, cityJSON);
		
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
			AbstractGeometry geometry = null;
			int lod = 0;

			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest, cityJSON);
				lod = geometryObject.getLod().intValue();
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType) geometryType;
				geometry = citygml.getCoreUnmarshaller().unmarshalAndTransformGeometryInstance(geometryInstance, dest, cityJSON);
				lod = (int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD);
			}

			if (geometry != null) {
				if (geometry instanceof MultiSurface) {
					MultiSurface multiSurface = (MultiSurface) geometry;
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
				} else if (geometry instanceof MultiSolid) {
					MultiSolid multiSolid = (MultiSolid) geometry;
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
		unmarshalPlantCover(src, dest, cityJSON);
		
		return dest;
	}

	public void unmarshalSolitaryVegetationObject(SolitaryVegetationObjectType src, SolitaryVegetationObject dest, CityJSON cityJSON) {
		unmarshalAbstractVegetationObject(src, dest, cityJSON);
		
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
			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest, cityJSON);

				if (geometry != null) {
					int lod = geometryObject.getLod().intValue();
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
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType) geometryType;
				ImplicitGeometry geometry = citygml.getCoreUnmarshaller().unmarshalGeometryInstance(geometryInstance, cityJSON);

				if (geometry != null) {
					switch ((int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD)) {
						case 1:
							dest.setLod1ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
						case 2:
							dest.setLod2ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
						case 3:
							dest.setLod3ImplicitRepresentation(new ImplicitRepresentationProperty(geometry));
							break;
					}
				}
			}
		}
	}
	
	public SolitaryVegetationObject unmarshalSolitaryVegetationObject(SolitaryVegetationObjectType src, CityJSON cityJSON) {
		SolitaryVegetationObject dest = new SolitaryVegetationObject();
		unmarshalSolitaryVegetationObject(src, dest, cityJSON);

		return dest;
	}
}
