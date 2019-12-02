package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.model.tunnel.TunnelConstructiveElementProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class TunnelConstructiveElementPropertyAdapter extends AbstractFeaturePropertyAdapter<TunnelConstructiveElementProperty> {

    @Override
    public TunnelConstructiveElementProperty createObject(QName name) throws ObjectBuildException {
        return new TunnelConstructiveElementProperty();
    }
}
