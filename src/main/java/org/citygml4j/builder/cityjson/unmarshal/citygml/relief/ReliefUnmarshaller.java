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
package org.citygml4j.builder.cityjson.unmarshal.citygml.relief;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.feature.TINReliefType;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.CompositeSurfaceType;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.cityjson.unmarshal.citygml.CityGMLUnmarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.citygml.relief.ReliefComponentProperty;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.citygml.relief.TinProperty;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;

public class ReliefUnmarshaller {
	private final CityJSONUnmarshaller json;
	private final CityGMLUnmarshaller citygml;

	public ReliefUnmarshaller(CityGMLUnmarshaller citygml) {
		this.citygml = citygml;
		json = citygml.getCityJSONUnmarshaller();
	}

	public AbstractCityObject unmarshal(AbstractCityObjectType src, CityJSON cityJSON) {
		if (src instanceof TINReliefType)
			return unmarshalTINRelief((TINReliefType)src);

		return null;
	}

	public void unmarshalTINRelief(TINReliefType src, ReliefFeature dest) {
		citygml.getCoreUnmarshaller().unmarshalAbstractCityObject(src, dest);

		if (src.isSetAttributes()) {
			Attributes attributes = src.getAttributes();
			if (attributes.isSetClazz()) {
				StringAttribute clazz = new StringAttribute(attributes.getClazz());
				clazz.setName("class");
				dest.addGenericAttribute(clazz);
			}

			if (attributes.isSetFunction()) {
				StringAttribute function = new StringAttribute(attributes.getFunction());
				function.setName("function");
				dest.addGenericAttribute(function);
			}

			if (attributes.isSetUsage()) {
				StringAttribute usage = new StringAttribute(attributes.getUsage());
				usage.setName("usage");
				dest.addGenericAttribute(usage);
			}
		}

		for (AbstractGeometryType geometryType : src.getGeometry()) {
			if (geometryType instanceof CompositeSurfaceType) {
				CompositeSurfaceType compositeSurface = (CompositeSurfaceType) geometryType;
				TriangulatedSurface geometry = json.getGMLUnmarshaller().unmarshalTriangulatedSurface(compositeSurface, dest);

				if (geometry != null) {
					TINRelief tinRelief = new TINRelief();
					int lod = compositeSurface.getLod().intValue();
					
					tinRelief.setLod(lod);
					if (lod > dest.getLod())
						dest.setLod(lod);
					
					tinRelief.setTin(new TinProperty(geometry));
					dest.addReliefComponent(new ReliefComponentProperty(tinRelief));
				}	
			}
		}
	}

	public ReliefFeature unmarshalTINRelief(TINReliefType src) {
		ReliefFeature dest = new ReliefFeature();
		unmarshalTINRelief(src, dest);

		return dest;
	}

}
