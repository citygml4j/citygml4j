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

package org.citygml4j.xml.adapter.deprecated.building;

import org.citygml4j.core.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.core.AbstractSpaceBoundaryPropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Namespaces;

public class AbstractBoundarySurfacePropertyAdapter extends AbstractSpaceBoundaryPropertyAdapter {

    @Override
    public void writeChildElements(AbstractSpaceBoundaryProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        namespaces = namespaces.copy().removeAll(
                CityGMLConstants.CITYGML_2_0_BRIDGE_NAMESPACE,
                CityGMLConstants.CITYGML_2_0_TUNNEL_NAMESPACE,
                CityGMLConstants.CITYGML_2_0_WATERBODY_NAMESPACE,
                CityGMLConstants.CITYGML_1_0_WATERBODY_NAMESPACE
        );

        super.writeChildElements(object, namespaces, writer);
    }
}
