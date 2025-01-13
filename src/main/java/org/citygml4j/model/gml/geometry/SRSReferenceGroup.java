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
package org.citygml4j.model.gml.geometry;

import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.gml.feature.AbstractFeature;

public interface SRSReferenceGroup extends SRSInformationGroup {
    String getSrsName();

    Integer getSrsDimension();

    boolean isSetSrsName();

    boolean isSetSrsDimension();

    void setSrsName(String srsName);

    void setSrsDimension(Integer srsDimension);

    void unsetSrsName();

    void unsetSrsDimension();

    default String getInheritedSrsName() {
        if (getSrsName() == null && this instanceof Child) {
            Child child = (Child) this;
            ModelObject parent;

            while ((parent = child.getParent()) != null) {
                if (parent instanceof AbstractGeometry)
                    return ((AbstractGeometry) parent).getInheritedSrsName();
                else if (parent instanceof AbstractFeature) {
                    AbstractFeature feature = (AbstractFeature) parent;
                    if (feature.isSetBoundedBy()
                            && feature.getBoundedBy().isSetEnvelope()
                            && feature.getBoundedBy().getEnvelope().isSetSrsName())
                        return feature.getBoundedBy().getEnvelope().getSrsName();
                }

                if (parent instanceof Child)
                    child = (Child) parent;
                else
                    break;
            }
        }

        return getSrsName();
    }
}
