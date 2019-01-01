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

package org.citygml4j.binding.cityjson.metadata.feature;

import com.google.gson.annotations.JsonAdapter;
import org.citygml4j.binding.cityjson.metadata.ThematicModelType;

import java.util.HashMap;
import java.util.Map;

@JsonAdapter(CityObjectGroupDataTypeAdapter.class)
public class CityObjectGroupDataType extends AbstractFeatureDataType {
    transient Map<ThematicModelType, AbstractFeatureDataType> memberMetadata;

    public boolean isSetMemberMetadata() {
        return memberMetadata != null && !memberMetadata.isEmpty();
    }

    public void addMemberMetadata(AbstractFeatureDataType featureMetadata) {
        if (featureMetadata instanceof CityObjectGroupDataType)
            return;

        if (memberMetadata == null)
            memberMetadata = new HashMap<>();

        memberMetadata.put(featureMetadata.getType(), featureMetadata);
    }

    public Map<ThematicModelType, AbstractFeatureDataType> getMemberMetadata() {
        return memberMetadata;
    }

    public void setMemberMetadata(Map<ThematicModelType, AbstractFeatureDataType> memberMetadata) {
        this.memberMetadata = memberMetadata;
    }

    public void unsetMemberMetadata() {
        memberMetadata = null;
    }

    @Override
    public ThematicModelType getType() {
        return ThematicModelType.CITY_OBJECT_GROUP;
    }
}
