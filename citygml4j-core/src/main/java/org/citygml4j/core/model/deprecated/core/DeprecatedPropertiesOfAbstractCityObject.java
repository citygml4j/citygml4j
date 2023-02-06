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

package org.citygml4j.core.model.deprecated.core;

import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class DeprecatedPropertiesOfAbstractCityObject extends DeprecatedPropertiesOfAbstractFeature {
    private List<AbstractCityObjectProperty> generalizesTo;

    public List<AbstractCityObjectProperty> getGeneralizesTo() {
        if (generalizesTo == null)
            generalizesTo = new ChildList<>(this);

        return generalizesTo;
    }

    public boolean isSetGeneralizesTo() {
        return generalizesTo != null && !generalizesTo.isEmpty();
    }

    public void setGeneralizesTo(List<AbstractCityObjectProperty> generalizesTo) {
        this.generalizesTo = asChild(generalizesTo);
    }
}
