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
