package org.citygml4j.binding.cityjson.extension;

import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.model.gml.feature.AbstractFeature;

public class CityObjectContext {
    private final AbstractFeature parent;
    private final CityJSON cityJSON;

    public CityObjectContext(AbstractFeature parent, CityJSON cityJSON) {
        this.parent = parent;
        this.cityJSON = cityJSON;
    }

    public AbstractFeature getParent() {
        return parent;
    }

    public CityJSON getCityJSON() {
        return cityJSON;
    }
}
