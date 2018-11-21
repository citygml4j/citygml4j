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
package org.citygml4j.builder.cityjson.json.io.writer;

import com.google.gson.stream.JsonWriter;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.geometry.TransformType;
import org.citygml4j.binding.cityjson.metadata.MetadataType;
import org.citygml4j.model.citygml.core.CityModel;

import java.util.List;

public class CityJSONWriter extends AbstractCityJSONWriter {

	public CityJSONWriter(JsonWriter writer, CityJSONOutputFactory factory) {
		super(writer, factory);
	}

	public void write(CityModel cityModel) throws CityJSONWriteException {
		CityJSON cityJSON = marshaller.marshal(cityModel);
		if (cityJSON != null) {
			MetadataType metadata = this.metadata != null ? this.metadata : new MetadataType();

			if (!metadata.isSetGeographicalExtent() && !cityJSON.getVertices().isEmpty()) {
				List<Double> bbox = cityJSON.calcBoundingBox();
				if (cityJSON.isSetTransform()) {
					TransformType transform = cityJSON.getTransform();
					for (int i = 0; i < bbox.size(); i++)
						bbox.set(i, bbox.get(i) * transform.getScale().get(i%3) + transform.getTranslate().get(i%3));
				}
				
				metadata.setGeographicalExtent(bbox);
			}

			if (!metadata.isSetPresentLoDs() && cityJSON.hasCityObjects())
				metadata.setPresentLoDs(cityJSON.calcPresentLoDs());

			cityJSON.setMetadata(metadata);			
			gson.toJson(cityJSON, CityJSON.class, writer);
		}
	}

}
