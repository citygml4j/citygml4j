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
package org.citygml4j.builder.cityjson.unmarshal.citygml.transportation;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.AbstractTransportationComplexType;
import org.citygml4j.binding.cityjson.feature.RailwayType;
import org.citygml4j.binding.cityjson.feature.RoadType;
import org.citygml4j.binding.cityjson.feature.TransportSquareType;
import org.citygml4j.binding.cityjson.feature.TransportationComplexAttributes;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.AbstractSurfaceCollectionType;
import org.citygml4j.binding.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.binding.cityjson.geometry.SemanticsType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.transportation.AbstractTransportationObject;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficArea;
import org.citygml4j.model.citygml.transportation.AuxiliaryTrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.Railway;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.Square;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.citygml.transportation.TrafficAreaProperty;
import org.citygml4j.model.citygml.transportation.TransportationComplex;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.List;
import java.util.stream.Collectors;

public class TransportationUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	private final BiFunctionTypeMapper<CityJSON, AbstractCityObject> typeMapper;

	public TransportationUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();

		typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObject>create()
				.with(RoadType.class, this::unmarshalRoad)
				.with(RailwayType.class, this::unmarshalRailway)
				.with(TransportSquareType.class, this::unmarshalTransportSquare);
	}

	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		return typeMapper.apply(src, cityJSON);
	}

	public AbstractCityObject unmarshalSemantics(SemanticsType semanticsType, List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent) {
		AbstractTransportationObject traffixArea = null;
		switch (semanticsType.getType()) {
			case "TrafficArea":
				traffixArea = unmarshalTrafficArea(semanticsType, surfaces, lod);
				break;
			case "AuxiliaryTrafficArea":
				traffixArea = unmarshalAuxiliaryTrafficArea(semanticsType, surfaces, lod);
				break;
		}

		if (parent instanceof TransportationComplex) {
			TransportationComplex complex = (TransportationComplex) parent;
			if (traffixArea instanceof TrafficArea)
				complex.addTrafficArea(new TrafficAreaProperty((TrafficArea) traffixArea));
			else if (traffixArea != null)
				complex.addAuxiliaryTrafficArea(new AuxiliaryTrafficAreaProperty((AuxiliaryTrafficArea) traffixArea));
		}

		return traffixArea;
	}

	public void unmarshalTransportationComplex(AbstractTransportationComplexType src, TransportationComplex dest) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetAttributes()) {
			TransportationComplexAttributes attributes = src.getAttributes();

			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));

			if (attributes.isSetSurfaceMaterials()) {
				StringAttribute surfaceMaterial = new StringAttribute();
				surfaceMaterial.setName("surfaceMaterial");
				surfaceMaterial.setValue(attributes.getSurfaceMaterials().stream().collect(Collectors.joining(" ")));
				dest.addGenericAttribute(surfaceMaterial);
			}
		}

		for (AbstractGeometryType geometryType : src.getGeometry()) {
			MultiSurface multiSurface = null;
			int lod = 0;

			if (geometryType instanceof AbstractSurfaceCollectionType) {
				AbstractSurfaceCollectionType surfaceType = (AbstractSurfaceCollectionType) geometryType;
				multiSurface = json.getGMLUnmarshaller().unmarshalMultiSurface(surfaceType, dest);
				lod = surfaceType.getLod().intValue();
			} else if (geometryType instanceof GeometryInstanceType) {
				GeometryInstanceType geometryInstance = (GeometryInstanceType) geometryType;
				AbstractGeometry geometry = citygml.getCoreUnmarshaller().unmarshalAndTransformGeometryInstance(geometryInstance, dest);
				if (geometry instanceof MultiSurface) {
					multiSurface = (MultiSurface)geometry;
					lod = (int) geometry.getLocalProperty(CityJSONUnmarshaller.GEOMETRY_INSTANCE_LOD);
				}
			}

			if (multiSurface != null) {
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
		}
	}

	public Road unmarshalRoad(RoadType src, CityJSON cityJSON) {
		Road dest = new Road();
		unmarshalTransportationComplex(src, dest);

		return dest;
	}

	public Railway unmarshalRailway(RailwayType src, CityJSON cityJSON) {
		Railway dest = new Railway();
		unmarshalTransportationComplex(src, dest);

		return dest;
	}

	public Square unmarshalTransportSquare(TransportSquareType src, CityJSON cityJSON) {
		Square dest = new Square();
		unmarshalTransportationComplex(src, dest);

		return dest;
	}

	public void unmarshalTrafficArea(SemanticsType src, TrafficArea dest, List<AbstractSurface> surfaces, Number lod) {
		dest.setId(DefaultGMLIdManager.getInstance().generateUUID());
		
		if (src.isSetAttributes()) {
			Object attribute = src.getAttributes().get("surfaceMaterial");
			if (attribute instanceof String) {
				dest.setSurfaceMaterial(new Code((String)attribute));
				src.getAttributes().remove("surfaceMaterial");
			}
			
			attribute = src.getAttributes().get("class");
			if (attribute instanceof String) {
				dest.setClazz(new Code((String)attribute));
				src.getAttributes().remove("class");
			}
			
			attribute = src.getAttributes().get("function");
			if (attribute instanceof String) {
				dest.addFunction(new Code((String)attribute));
				src.getAttributes().remove("function");
			}
			
			attribute = src.getAttributes().get("usage");
			if (attribute instanceof String) {
				dest.addFunction(new Code((String)attribute));
				src.getAttributes().remove("usage");
			}
			
			citygml.getGenericsUnmarshaller().unmarshalSemanticsAttributes(src.getAttributes(), dest);
		}
		
		MultiSurface multiSurface = new MultiSurface();
		for (AbstractSurface surface : surfaces)
			multiSurface.addSurfaceMember(new SurfaceProperty(surface));

		switch (lod.intValue()) {
		case 2:
			dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		case 3:
			dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		}
	}

	public TrafficArea unmarshalTrafficArea(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		TrafficArea dest = new TrafficArea();
		unmarshalTrafficArea(src, dest, surfaces, lod);

		return dest;
	}

	public void unmarshalAuxiliaryTrafficArea(SemanticsType src, AuxiliaryTrafficArea dest, List<AbstractSurface> surfaces, Number lod) {
		dest.setId(DefaultGMLIdManager.getInstance().generateUUID());
		
		if (src.isSetAttributes()) {
			Object attribute = src.getAttributes().get("surfaceMaterial");
			if (attribute instanceof String) {
				dest.setSurfaceMaterial(new Code((String)attribute));
				src.getAttributes().remove("surfaceMaterial");
			}
			
			attribute = src.getAttributes().get("class");
			if (attribute instanceof String) {
				dest.setClazz(new Code((String)attribute));
				src.getAttributes().remove("class");
			}
			
			attribute = src.getAttributes().get("function");
			if (attribute instanceof String) {
				dest.addFunction(new Code((String)attribute));
				src.getAttributes().remove("function");
			}
			
			attribute = src.getAttributes().get("usage");
			if (attribute instanceof String) {
				dest.addFunction(new Code((String)attribute));
				src.getAttributes().remove("usage");
			}
			
			citygml.getGenericsUnmarshaller().unmarshalSemanticsAttributes(src.getAttributes(), dest);
		}
		
		MultiSurface multiSurface = new MultiSurface();
		for (AbstractSurface surface : surfaces)
			multiSurface.addSurfaceMember(new SurfaceProperty(surface));

		switch (lod.intValue()) {
		case 2:
			dest.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		case 3:
			dest.setLod3MultiSurface(new MultiSurfaceProperty(multiSurface));
			break;
		}
	}

	public AuxiliaryTrafficArea unmarshalAuxiliaryTrafficArea(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		AuxiliaryTrafficArea dest = new AuxiliaryTrafficArea();
		unmarshalAuxiliaryTrafficArea(src, dest, surfaces, lod);
		
		return dest;
	}
}
