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

import com.google.gson.annotations.JsonAdapter;
import org.citygml4j.binding.cityjson.feature.DateTimeAdapter;

import java.time.ZonedDateTime;

public class ProcessStepType {
    private String description;
    private String rationale;
    @JsonAdapter(DateTimeAdapter.class)
    private ZonedDateTime stepDateTime;
    private ContactDetailsType processor;
    private String reference;
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

    public boolean isSetRationale() {
        return rationale != null;
    }

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }

    public void unsetRationale() {
        rationale = null;
    }

    public boolean isSetStepDateTime() {
        return stepDateTime != null;
    }

    public ZonedDateTime getStepDateTime() {
        return stepDateTime;
    }

    public void setStepDateTime(ZonedDateTime stepDateTime) {
        this.stepDateTime = stepDateTime;
    }

    public void unsetStepDateTime() {
        stepDateTime = null;
    }

    public boolean isSetProcessor() {
        return processor != null;
    }

    public ContactDetailsType getProcessor() {
        return processor;
    }

    public void setProcessor(ContactDetailsType processor) {
        this.processor = processor;
    }

    public void unsetProcessor() {
        processor = null;
    }

    public boolean isSetReference() {
        return reference != null;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        if (reference != null && reference.matches("^(https?|ftp)://.*"))
            this.reference = reference;
    }

    public void unsetReference() {
        reference = null;
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
