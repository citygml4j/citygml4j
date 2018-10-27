/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.cityjson.marshal.citygml.vegetation;

import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.PlantCoverAttributes;
import org.citygml4j.binding.cityjson.feature.PlantCoverType;
import org.citygml4j.binding.cityjson.feature.SolitaryVegetationObjectAttributes;
import org.citygml4j.binding.cityjson.feature.SolitaryVegetationObjectType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.binding.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.builder.cityjson.marshal.CityJSONMarshaller;
import org.citygml4j.builder.cityjson.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.vegetation.PlantCover;
import org.citygml4j.model.citygml.vegetation.SolitaryVegetationObject;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.util.mapper.TypeMapper;

import java.util.Collections;
import java.util.List;

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
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSurface());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod2MultiSurface()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2MultiSurface());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3MultiSurface()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3MultiSurface());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod1MultiSolid()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1MultiSolid());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod2MultiSolid()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2MultiSolid());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}
		
		if (src.isSetLod3MultiSolid()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3MultiSolid());
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

		if (src.isSetLod1Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod1Geometry());
			if (geometry != null) {
				geometry.setLod(1);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod2Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod2Geometry());
			if (geometry != null) {
				geometry.setLod(2);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod3Geometry()) {
			AbstractGeometryObjectType geometry = json.getGMLMarshaller().marshalGeometryProperty(src.getLod3Geometry());
			if (geometry != null) {
				geometry.setLod(3);
				dest.addGeometry(geometry);
			}
		}

		if (src.isSetLod1ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod1ImplicitRepresentation(), 1);
			if (geometry != null)
				dest.addGeometry(geometry);
		}

		if (src.isSetLod2ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod2ImplicitRepresentation(), 2);
			if (geometry != null)
				dest.addGeometry(geometry);
		}

		if (src.isSetLod3ImplicitRepresentation()) {
			GeometryInstanceType geometry = citygml.getCoreMarshaller().marshalImplicitRepresentationProperty(src.getLod3ImplicitRepresentation(), 3);
			if (geometry != null)
				dest.addGeometry(geometry);
		}
	}

	public List<AbstractCityObjectType> marshalSolitaryVegetationObject(SolitaryVegetationObject src) {
		SolitaryVegetationObjectType dest = new SolitaryVegetationObjectType(src.getId());
		marshalSolitaryVegetationObject(src, dest);

		return Collections.singletonList(dest);
	}
}
