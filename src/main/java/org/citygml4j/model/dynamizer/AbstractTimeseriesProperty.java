package org.citygml4j.model.dynamizer;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.feature.FeatureProperty;

public class AbstractTimeseriesProperty extends FeatureProperty<AbstractTimeseries> implements CityGMLObject {

    public AbstractTimeseriesProperty() {
    }

    public AbstractTimeseriesProperty(AbstractTimeseries object) {
        super(object);
    }

    public AbstractTimeseriesProperty(String href) {
        super(href);
    }

    @Override
    public Class<AbstractTimeseries> getTargetType() {
        return AbstractTimeseries.class;
    }
}
