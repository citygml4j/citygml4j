package org.citygml4j.binding.cityjson.geometry;

import com.google.gson.annotations.JsonAdapter;

import java.util.Map;

@JsonAdapter(GeometryTypeAdapter.class)
public abstract class AbstractGeometryType {
    public abstract GeometryTypeName getType();
    public abstract void updateIndexes(Map<Integer, Integer> indexMap);
}
