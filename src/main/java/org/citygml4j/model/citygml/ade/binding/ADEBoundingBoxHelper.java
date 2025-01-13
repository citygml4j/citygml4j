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
package org.citygml4j.model.citygml.ade.binding;

import org.citygml4j.model.gml.base.ArrayAssociation;
import org.citygml4j.model.gml.base.AssociationByRep;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.util.bbox.BoundingBoxOptions;

import java.util.Arrays;
import java.util.Collection;

public class ADEBoundingBoxHelper {

    public static BoundingShape calcBoundedBy(ADEModelObject ade, BoundingBoxOptions options) {
        BoundingShape boundedBy = new BoundingShape();
        updateEnvelope(ade, boundedBy, options);
        return boundedBy;
    }

    private static void updateEnvelope(Object object, BoundingShape boundedBy, BoundingBoxOptions options) {
        if (object instanceof AbstractGeometry) {
            boundedBy.updateEnvelope(((AbstractGeometry) object).calcBoundingBox());
        } else if (object instanceof AbstractFeature) {
            boundedBy.updateEnvelope(((AbstractFeature) object).calcBoundedBy(options).getEnvelope());
        } else if (object instanceof ADEGenericApplicationProperty<?>) {
            updateEnvelope(((ADEGenericApplicationProperty<?>) object).getValue(), boundedBy, options);
        } else if (object instanceof ArrayAssociation<?>) {
            ((ArrayAssociation<?>) object).getObject().forEach(v -> updateEnvelope(v, boundedBy, options));
        } else if (object instanceof AssociationByRep<?>) {
            updateEnvelope(((AssociationByRep<?>) object).getObject(), boundedBy, options);
        } else if (object instanceof Collection<?>) {
            ((Collection<?>) object).forEach(v -> updateEnvelope(v, boundedBy, options));
        } else if (object instanceof Object[]) {
            Arrays.stream(((Object[]) object)).forEach(v -> updateEnvelope(v, boundedBy, options));
        }
    }
}
