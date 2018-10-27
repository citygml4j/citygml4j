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

package org.citygml4j.binding.cityjson.geometry;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GeometryTemplatesType {
    private List<AbstractGeometryObjectType> templates = new ArrayList<>();
    @SerializedName("vertices-templates")
    private List<List<Double>> templatesVertices = new ArrayList<>();

    public void addTemplate(AbstractGeometryObjectType template) {
        if (template != null)
            templates.add(template);
    }

    public List<AbstractGeometryObjectType> getTemplates() {
        return templates;
    }

    public void setTemplates(List<AbstractGeometryObjectType> templates) {
        if (templates != null)
            this.templates = templates;
    }

    public void removeTemplate(AbstractGeometryObjectType template) {
        templates.remove(template);
    }

    public void unsetTemplates() {
        templates.clear();
    }

    public void addTemplatesVertex(List<Double> templatesVertex) {
        if (templatesVertex != null && templatesVertex.size() == 3)
            templatesVertices.add(templatesVertex);
    }

    public List<List<Double>> getTemplatesVertices() {
        return templatesVertices;
    }

    public void setTemplatesVertices(List<List<Double>> templatesVertices) {
        if (templatesVertices != null)
            this.templatesVertices = templatesVertices;
    }

    public void unsetTemplatesVertices() {
        templatesVertices.clear();
    }
}
