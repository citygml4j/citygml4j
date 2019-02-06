/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.model.gml.feature.AbstractFeature;

public class CityObjectContext {
    private final AbstractFeature parent;
    private final CityJSON cityJSON;

    public CityObjectContext(AbstractFeature parent, CityJSON cityJSON) {
        this.parent = parent;
        this.cityJSON = cityJSON;
    }

    public AbstractFeature getParent() {
        return parent;
    }

    public CityJSON getCityJSON() {
        return cityJSON;
    }
}
