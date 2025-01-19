/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package implementing_ades.model;

import org.citygml4j.core.model.ade.ADEObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class BuildingUndergroundProperty extends FeatureProperty<BuildingUnderground> implements ADEObject {

    public BuildingUndergroundProperty() {
    }

    public BuildingUndergroundProperty(BuildingUnderground object) {
        super(object);
    }

    public BuildingUndergroundProperty(String href) {
        super(href);
    }

    @Override
    public Class<BuildingUnderground> getTargetType() {
        return BuildingUnderground.class;
    }
}
