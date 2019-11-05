package org.citygml4j.model.relief;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.coverage.RectifiedGridCoverage;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class GridProperty extends FeatureProperty<RectifiedGridCoverage> implements CityGMLObject {

    public GridProperty() {
    }

    public GridProperty(RectifiedGridCoverage object) {
        super(object);
    }

    public GridProperty(String href) {
        super(href);
    }

    @Override
    public Class<RectifiedGridCoverage> getTargetType() {
        return RectifiedGridCoverage.class;
    }
}
