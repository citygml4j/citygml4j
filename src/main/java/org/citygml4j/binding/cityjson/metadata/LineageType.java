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

package org.citygml4j.binding.cityjson.metadata;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LineageType {
    private String statement;
    private String scope;
    private String additionalDocumentation;
    private List<String> featureIDs;
    private List<ThematicModelType> thematicModels;
    @SerializedName("source")
    private List<SourceType> sources;
    private ProcessStepType processStep;

    public boolean isSetStatement() {
        return statement != null;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void unsetStatement() {
        statement = null;
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

    public boolean isSetAdditionalDocumentation() {
        return additionalDocumentation != null;
    }

    public String getAdditionalDocumentation() {
        return additionalDocumentation;
    }

    public void setAdditionalDocumentation(String additionalDocumentation) {
        if (additionalDocumentation != null && additionalDocumentation.matches("^(https?|ftp)://.*"))
            this.additionalDocumentation = additionalDocumentation;
    }

    public void unsetAdditionalDocumentation() {
        additionalDocumentation = null;
    }

    public boolean isSetFeatureIDs() {
        return featureIDs != null && !featureIDs.isEmpty();
    }

    public List<String> getFeatureIDs() {
        return featureIDs;
    }

    public void addFeatureID(String featureID) {
        if (featureIDs == null)
            featureIDs = new ArrayList<>();

        featureIDs.add(featureID);
    }

    public void setFeatureID(List<String> featureIDs) {
        this.featureIDs = featureIDs;
    }

    public void unsetFeatureIDs() {
        featureIDs = null;
    }

    public boolean isSetThematicModels() {
        return thematicModels != null;
    }

    public List<ThematicModelType> getThematicModels() {
        return thematicModels;
    }

    public void addThematicModel(ThematicModelType thematicModel) {
        if (thematicModels == null)
            thematicModels = new ArrayList<>();

        thematicModels.add(thematicModel);
    }

    public void setThematicModels(List<ThematicModelType> thematicModels) {
        this.thematicModels = thematicModels;
    }

    public void unsetThematicModels() {
        thematicModels = null;
    }

    public boolean isSetSources() {
        return sources != null;
    }

    public List<SourceType> getSources() {
        return sources;
    }

    public void addSource(SourceType source) {
        if (sources == null)
            sources = new ArrayList<>();

        sources.add(source);
    }

    public void setSources(List<SourceType> sources) {
        this.sources = sources;
    }

    public void unsetSources() {
        sources = null;
    }

    public boolean isSetProcessStep() {
        return processStep != null;
    }

    public ProcessStepType getProcessStep() {
        return processStep;
    }

    public void setProcessStep(ProcessStepType processStep) {
        this.processStep = processStep;
    }

    public void unsetProcessStep() {
        processStep = null;
    }
}
