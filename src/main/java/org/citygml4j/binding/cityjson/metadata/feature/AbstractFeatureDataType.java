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

import org.citygml4j.binding.cityjson.metadata.LoDType;
import org.citygml4j.binding.cityjson.metadata.ThematicModelType;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractFeatureDataType {
    private Integer uniqueFeatureCount;
    private Integer aggregateFeatureCount;
    private Map<LoDType, Integer> presentLoDs;

    public abstract ThematicModelType getType();

    public boolean isSetUniqueFeatureCount() {
        return uniqueFeatureCount != null;
    }

    public Integer getUniqueFeatureCount() {
        return uniqueFeatureCount;
    }

    public void setUniqueFeatureCount(Integer uniqueFeatureCount) {
        this.uniqueFeatureCount = uniqueFeatureCount;
    }

    public void unsetUniqueFeatureCount() {
        uniqueFeatureCount = null;
    }

    public boolean isSetAggregateFeatureCount() {
        return aggregateFeatureCount != null;
    }

    public Integer getAggregateFeatureCount() {
        return aggregateFeatureCount;
    }

    public void setAggregateFeatureCount(Integer aggregateFeatureCount) {
        this.aggregateFeatureCount = aggregateFeatureCount;
    }

    public void unsetAggregateFeatureCount() {
        aggregateFeatureCount = null;
    }

    public boolean isSetPresentLoDs() {
        return presentLoDs != null;
    }

    public void addPresentLoD(LoDType lod) {
        if (presentLoDs == null)
            presentLoDs = new HashMap<>();

        presentLoDs.merge(lod, 1, Integer::sum);
    }

    public Map<LoDType, Integer> getPresentLoDs() {
        return presentLoDs;
    }

    public void setPresentLoDs(Map<LoDType, Integer> presentLoDs) {
        if (presentLoDs != null && !presentLoDs.isEmpty())
            this.presentLoDs = presentLoDs;
    }

    public void unsetPresentLoDs() {
        presentLoDs = null;
    }
}
