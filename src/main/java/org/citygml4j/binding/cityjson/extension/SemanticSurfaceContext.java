package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;

import java.util.List;

public class SemanticSurfaceContext {
    private final List<AbstractSurface> surfaces;
    private final Number lod;
    private final AbstractCityObject parent;

    public SemanticSurfaceContext(List<AbstractSurface> surfaces, Number lod, AbstractCityObject parent) {
        this.surfaces = surfaces;
        this.lod = lod;
        this.parent = parent;
    }

    public SemanticSurfaceContext(Number lod, AbstractCityObject parent) {
        this(null, lod, parent);
    }

    public boolean isSetSurfaces() {
        return surfaces != null;
    }

    public List<AbstractSurface> getSurfaces() {
        return surfaces;
    }

    public Number getLod() {
        return lod;
    }

    public AbstractCityObject getParent() {
        return parent;
    }
}
