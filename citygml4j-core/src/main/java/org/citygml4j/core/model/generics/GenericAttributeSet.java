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

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.core.AbstractGenericAttribute;
import org.citygml4j.core.model.core.AbstractGenericAttributeProperty;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class GenericAttributeSet extends AbstractGenericAttribute<List<AbstractGenericAttributeProperty>> {
    private String codeSpace;

    public GenericAttributeSet() {
    }

    public GenericAttributeSet(String name, List<AbstractGenericAttributeProperty> value) {
        super(name, value);
    }

    @Override
    public List<AbstractGenericAttributeProperty> getValue() {
        if (super.getValue() == null)
            setValue(new ChildList<>(this));

        return super.getValue();
    }

    @Override
    public boolean isSetValue() {
        return super.isSetValue() && !super.getValue().isEmpty();
    }

    @Override
    public void setValue(List<AbstractGenericAttributeProperty> value) {
        super.setValue(asChild(value));
    }

    public String getCodeSpace() {
        return codeSpace;
    }

    public void setCodeSpace(String codeSpace) {
        this.codeSpace = codeSpace;
    }
}
