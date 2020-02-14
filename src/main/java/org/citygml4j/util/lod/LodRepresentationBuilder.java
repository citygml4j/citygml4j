/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.util.lod;

import org.citygml4j.model.citygml.core.ImplicitRepresentationProperty;
import org.citygml4j.model.citygml.core.LodRepresentation;
import org.citygml4j.model.common.annotation.Lod;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.geometry.GeometryProperty;

import java.lang.reflect.Field;

public class LodRepresentationBuilder {

	private LodRepresentationBuilder() {
		// just to thwart instantiation
	}

	public static LodRepresentation buildRepresentation(Object object) {
		return buildFor(object, false);
	}
	
	@SuppressWarnings("unchecked")
	public static LodRepresentation buildFor(Object object, boolean getLodFromAttributeName) {
		LodRepresentation lods = new LodRepresentation();
		Class<?> objectType = object.getClass();

		do {
			for (Field field : objectType.getDeclaredFields()) {
				Class<?> type = field.getType();
				if (!GeometryProperty.class.isAssignableFrom(type) && !ImplicitRepresentationProperty.class.isAssignableFrom(type))
					continue;

				Integer lod = null;
				if (field.isAnnotationPresent(Lod.class)) {
					Lod lodProperty = field.getAnnotation(Lod.class);
					lod = lodProperty.value();
				} else if (getLodFromAttributeName) {
					String name = field.getName();
					if (name.length() > 3 && name.toLowerCase().startsWith("lod")) {
						try {
							lod = Integer.valueOf(name.substring(3, 4));
						} catch (NumberFormatException e) {
							continue;
						}
					}
				}

				try {
					if (!field.isAccessible())
						field.setAccessible(true);

					AssociationByRepOrRef<? extends AbstractGML> property = (AssociationByRepOrRef<? extends AbstractGML>) field.get(object);
					if (lod != null)
						lods.addRepresentation(lod, property);
					else
						lods.addRepresentation(property);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					//
				}
			}
		} while ((objectType = objectType.getSuperclass()) != Object.class && objectType != null);

		return lods;
	}

}
