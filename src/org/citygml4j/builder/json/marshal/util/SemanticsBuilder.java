package org.citygml4j.builder.json.marshal.util;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.citygml4j.binding.json.geometry.SemanticsType;
import org.citygml4j.builder.json.marshal.citygml.CityGMLMarshaller;
import org.citygml4j.model.citygml.core.AbstractCityObject;

public class SemanticsBuilder {
	private final CityGMLMarshaller citygml;
	private final List<SemanticsType> surfaces = new ArrayList<>();
	private final Map<AbstractCityObject, Integer> cityObjects = new IdentityHashMap<>();
	
	public SemanticsBuilder(CityGMLMarshaller citygml) {
		this.citygml = citygml;
	}
	
	public Integer addSemanticSurface(AbstractCityObject cityObject) {
		if (cityObject == null)
			return null;
		
		Integer index = null;
		if (!cityObjects.containsKey(cityObject)) {
			SemanticsType semantics = citygml.marshalSemantics(cityObject);
			if (semantics != null) {
				index = surfaces.size();
				surfaces.add(semantics);
			}
			
			cityObjects.put(cityObject, index);
		} else
			index = cityObjects.get(cityObject);

		return index;
	}

	public List<SemanticsType> getSurfaces() {
		return surfaces;
	}
	
}
