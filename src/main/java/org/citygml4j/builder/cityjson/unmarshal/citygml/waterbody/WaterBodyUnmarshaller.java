/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.builder.cityjson.unmarshal.citygml.waterbody;

import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.cityjson.CityJSON;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.feature.Attributes;
import org.citygml4j.cityjson.feature.WaterBodyType;
import org.citygml4j.cityjson.geometry.AbstractGeometryObjectType;
import org.citygml4j.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.binding.ADEModelObject;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.waterbody.AbstractWaterBoundarySurface;
import org.citygml4j.model.citygml.waterbody.BoundedByWaterSurfaceProperty;
import org.citygml4j.model.citygml.waterbody.WaterBody;
import org.citygml4j.model.citygml.waterbody.WaterClosureSurface;
import org.citygml4j.model.citygml.waterbody.WaterGroundSurface;
import org.citygml4j.model.citygml.waterbody.WaterSurface;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;

import java.util.List;

public class WaterBodyUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;

	public WaterBodyUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}
	
	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		if (src instanceof WaterBodyType)
			return unmarshalWaterBody((WaterBodyType) src, cityJSON);

		return null;
	}

	public AbstractCityObject unmarshalSemantics(SemanticsType semanticsType, List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent) {
		AbstractWaterBoundarySurface boundarySurface = null;
		switch (semanticsType.getType()) {
			case "WaterSurface":
				boundarySurface = unmarshalWaterSurface(semanticsType, surfaces, lod);
				break;
			case "WaterGroundSurface":
				boundarySurface = unmarshalWaterGroundSurface(semanticsType, surfaces, lod);
				break;
			case "WaterClosureSurface":
				boundarySurface = unmarshalWaterClosureSurface(semanticsType, surfaces, lod);
				break;
			default:
				return null;
		}

		if (parent instanceof ADEModelObject) {
			boolean success = json.getADEUnmarshaller().assignSemanticSurface(boundarySurface, lod, parent);
			if (success)
				return boundarySurface;
		}

		if (boundarySurface != null && parent instanceof WaterBody)
			((WaterBody) parent).addBoundedBySurface(new BoundedByWaterSurfaceProperty(boundarySurface));

		return boundarySurface;
	}
	
	public void unmarshalWaterBody(WaterBodyType src, WaterBody dest, CityJSON cityJSON) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest, cityJSON);
		
		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();
			if (attributes.isSetClazz())
				dest.setClazz(new Code(attributes.getClazz()));

			if (attributes.isSetFunction())
				dest.addFunction(new Code(attributes.getFunction()));

			if (attributes.isSetUsage())
				dest.addUsage(new Code(attributes.getUsage()));
		}
		
		for (AbstractGeometryType geometryType : src.getGeometry()) {
			if (geometryType instanceof AbstractGeometryObjectType) {
				AbstractGeometryObjectType geometryObject = (AbstractGeometryObjectType) geometryType;
				AbstractGeometry geometry = json.getGMLUnmarshaller().unmarshal(geometryObject, dest);

				if (geometry != null) {
					int lod = geometryObject.getLod().intValue();

					if (geometry instanceof MultiCurve) {
						MultiCurve multiCurve = (MultiCurve) geometry;
						switch (lod) {
							case 0:
								dest.setLod0MultiCurve(new MultiCurveProperty(multiCurve));
								break;
							case 1:
								dest.setLod0MultiCurve(new MultiCurveProperty(multiCurve));
								break;
						}
					} else if (geometry instanceof MultiSurface || geometry instanceof CompositeSurface) {
						MultiSurface multiSurface = null;

						if (geometry instanceof MultiSurface)
							multiSurface = (MultiSurface) geometry;
						else {
							multiSurface = new MultiSurface();
							multiSurface.setSurfaceMember(((CompositeSurface) geometry).getSurfaceMember());
						}

						switch (lod) {
							case 0:
								dest.setLod0MultiSurface(new MultiSurfaceProperty(multiSurface));
								break;
							case 1:
								dest.setLod1MultiSurface(new MultiSurfaceProperty(multiSurface));
								break;
						}
					} else if (geometry instanceof AbstractSolid) {
						AbstractSolid solid = (AbstractSolid) geometry;
						switch (lod) {
							case 1:
								dest.setLod1Solid(new SolidProperty(solid));
								break;
							case 2:
								dest.setLod2Solid(new SolidProperty(solid));
								break;
							case 3:
								dest.setLod3Solid(new SolidProperty(solid));
								break;
						}
					}
				}
			}
		}
	}
	
	public WaterBody unmarshalWaterBody(WaterBodyType src, CityJSON cityJSON) {
		WaterBody dest = new WaterBody();
		unmarshalWaterBody(src, dest, cityJSON);
		
		return dest;
	}
	
	public void unmarshalAbstractWaterBoundarySurface(SemanticsType src, AbstractWaterBoundarySurface dest, List<AbstractSurface> surfaces, Number lod) {
		citygml.getCoreUnmarshaller().unmarshalSemanticsAttributes(src, dest);
		
		CompositeSurface compositeSurface = new CompositeSurface();
		for (AbstractSurface surface : surfaces)
			compositeSurface.addSurfaceMember(new SurfaceProperty(surface));

		switch (lod.intValue()) {
		case 2:
			dest.setLod2Surface(new SurfaceProperty(compositeSurface));
			break;
		case 3:
			dest.setLod3Surface(new SurfaceProperty(compositeSurface));
			break;
		}
	}
	
	public WaterSurface unmarshalWaterSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		WaterSurface dest = new WaterSurface();
		
		if (src.isSetAttributes()) {
			Object attribute = src.getAttributes().get("waterLevel");
			if (attribute instanceof String) {
				dest.setWaterLevel(new Code((String)attribute));
				src.getAttributes().remove("waterLevel");
			}
		}
		
		unmarshalAbstractWaterBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}
	
	public WaterGroundSurface unmarshalWaterGroundSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		WaterGroundSurface dest = new WaterGroundSurface();
		unmarshalAbstractWaterBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}
	
	public WaterClosureSurface unmarshalWaterClosureSurface(SemanticsType src, List<AbstractSurface> surfaces, Number lod) {
		WaterClosureSurface dest = new WaterClosureSurface();
		unmarshalAbstractWaterBoundarySurface(src, dest, surfaces, lod);

		return dest;
	}
	
}
