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

package org.citygml4j.core.util.reference;

import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.feature.AbstractFeature;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

public enum ResolveMode {
    ALL_OBJECTS(AbstractGML.class),
    FEATURES_ONLY(AbstractFeature.class),
    GEOMETRIES_ONLY(AbstractGeometry.class);

    private final Class<? extends AbstractGML> type;

    ResolveMode(Class<? extends AbstractGML> type) {
        this.type = type;
    }

    Class<? extends AbstractGML> getType() {
        return type;
    }
}
