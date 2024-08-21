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
package org.citygml4j.builder.cityjson.unmarshal.citygml.transportation;

import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.*;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.cityjson.geometry.GeometryInstanceType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.transportation.*;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurve;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.util.mapper.BiFunctionTypeMapper;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class TransportationUnmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;
	private BiFunctionTypeMapper<CityJSON, AbstractCityObject> typeMapper;

	public TransportationUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}

	private BiFunctionTypeMapper<CityJSON, AbstractCityObject> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = BiFunctionTypeMapper.<CityJSON, AbstractCityObject>create()
							.with(RoadType.class, this::unmarshalRoad)
							.with(RailwayType.class, this::unmarshalRailway)
							.with(TransportSquareType.class, this::unmarshalTransportSquare);
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

	public AbstractCityObject unmarshalSemanticSurface(SemanticsType semanticsType, List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent, CityJSON cityJSON) {
		AbstractTransportationObject trafficArea = null;
		switch (semanticsType.getType()) {
			case "TrafficArea":
				trafficArea = unmarshalTrafficArea(semanticsType, surfaces, lod, cityJSON);
				break;
			case "AuxiliaryTrafficArea":
				trafficArea = unmarshalAuxiliaryTrafficArea(semanticsType, surfaces, lod, cityJSON);
				break;
			default:
				return null;
		}

		if (parent instanceof ADEModelObject) {
			boolean success = json.getADEUnmarshaller().assignSemanticSurface(trafficArea, lod, parent);
			if (success)
				return trafficArea;
		}

		if (parent instanceof TransportationComplex) {
			TransportationComplex complex = (TransportationComplex) parent;
			if (trafficArea instanceof TrafficArea)
				complex.addTrafficArea(new TrafficAreaProperty((TrafficArea) trafficArea));
			else if (trafficArea != null)
				complex.addAuxiliaryTrafficArea(new AuxiliaryTrafficAreaProperty((AuxiliaryTrafficArea) trafficArea));
		}

		return trafficArea;
	}

	public void unmarshalTransportationComplex(AbstractTransportationComplexType src, TransportationComplex dest, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest, cityJSON);

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
				surfaceMaterial.setValue(String.join(" ", attributes.getSurfaceMaterials()));
				dest.addGenericAttribute(surfaceMaterial);
			}
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
				} else if (geometry instanceof MultiCurve && lod == 0) {
					CompositeCurve compositeCurve = new CompositeCurve();
					compositeCurve.setCurveMember(((MultiCurve) geometry).getCurveMember());

					GeometricComplexProperty property = new GeometricComplexProperty(compositeCurve);
					dest.setLod0Network(Collections.singletonList(property));
				}
			}
		}
	}

	public void unmarshalRoad(RoadType src, Road dest, CityJSON cityJSON) {
		unmarshalTransportationComplex(src, dest, cityJSON);
	}

	public Road unmarshalRoad(RoadType src, CityJSON cityJSON) {
		Road dest = new Road();
		unmarshalRoad(src, dest, cityJSON);

		return dest;
	}

	public void unmarshalRailway(RailwayType src, Railway dest, CityJSON cityJSON) {
		unmarshalTransportationComplex(src, dest, cityJSON);
	}

	public Railway unmarshalRailway(RailwayType src, CityJSON cityJSON) {
		Railway dest = new Railway();
		unmarshalRailway(src, dest, cityJSON);

		return dest;
	}

	public void unmarshalTransportSquare(TransportSquareType src, Square dest, CityJSON cityJSON) {
		unmarshalTransportationComplex(src, dest, cityJSON);
	}

	public Square unmarshalTransportSquare(TransportSquareType src, CityJSON cityJSON) {
		Square dest = new Square();
		unmarshalTransportSquare(src, dest, cityJSON);

		return dest;
	}

	public void unmarshalTrafficArea(SemanticsType src, TrafficArea dest, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
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

			citygml.getCoreUnmarshaller().marshalSemanticSurface(src, dest, cityJSON);
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

	public TrafficArea unmarshalTrafficArea(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		TrafficArea dest = new TrafficArea();
		unmarshalTrafficArea(src, dest, surfaces, lod, cityJSON);

		return dest;
	}

	public void unmarshalAuxiliaryTrafficArea(SemanticsType src, AuxiliaryTrafficArea dest, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().marshalSemanticSurface(src, dest, cityJSON);

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

	public AuxiliaryTrafficArea unmarshalAuxiliaryTrafficArea(SemanticsType src, List<AbstractSurface> surfaces, Number lod, CityJSON cityJSON) {
		AuxiliaryTrafficArea dest = new AuxiliaryTrafficArea();
		unmarshalAuxiliaryTrafficArea(src, dest, surfaces, lod, cityJSON);
		
		return dest;
	}
}
