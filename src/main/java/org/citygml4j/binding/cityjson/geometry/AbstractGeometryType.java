package org.citygml4j.binding.cityjson.geometry;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(GeometryTypeAdapter.class)
public abstract class AbstractGeometryType {
    public abstract GeometryTypeName getType();
}
