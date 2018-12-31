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

package org.citygml4j.binding.cityjson.metadata;

public class SourceType {
    private String description;
    private String sourceSpatialResolution;
    private String sourceReferenceSystem;
    private String sourceCitation;
    private String sourceMetadata;
    private String scope;

    public boolean isSetDescription() {
        return description != null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void unsetDescription() {
        description = null;
    }

    public boolean isSetSourceSpatialResolution() {
        return sourceSpatialResolution != null;
    }

    public String getSourceSpatialResolution() {
        return sourceSpatialResolution;
    }

    public void setSourceSpatialResolution(String sourceSpatialResolution) {
        this.sourceSpatialResolution = sourceSpatialResolution;
    }

    public void unsetSourceSpatialResolution() {
        sourceSpatialResolution = null;
    }

    public boolean isSetSourceReferenceSystem() {
        return sourceReferenceSystem != null;
    }

    public String getSourceReferenceSystem() {
        return sourceReferenceSystem;
    }

    public void setSourceReferenceSystem(int epsg) {
        if (epsg > 999 && epsg < 100000)
            sourceReferenceSystem = "urn:ogc:def:crs:EPSG::" + epsg;
    }

    public void unsetSourceReferenceSystem() {
        sourceReferenceSystem = null;
    }

    public boolean isSetSourceCitation() {
        return sourceCitation != null;
    }

    public String getSourceCitation() {
        return sourceCitation;
    }

    public void setSourceCitation(String sourceCitation) {
        if (sourceCitation != null && sourceCitation.matches("^(https?|ftp)://.*"))
            this.sourceCitation = sourceCitation;
    }

    public void unsetSourceCitation() {
        sourceCitation = null;
    }

    public boolean isSetSourceMetadata() {
        return sourceMetadata != null;
    }

    public String getSourceMetadata() {
        return sourceMetadata;
    }

    public void setSourceMetadata(String sourceMetadata) {
        if (sourceMetadata != null && sourceMetadata.matches("^(https?|ftp)://.*"))
            this.sourceMetadata = sourceMetadata;
    }

    public void unsetSourceMetadata() {
        sourceMetadata = null;
    }

    public boolean isSetScope() {
        return scope != null;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void unsetScope() {
        scope = null;
    }
}
