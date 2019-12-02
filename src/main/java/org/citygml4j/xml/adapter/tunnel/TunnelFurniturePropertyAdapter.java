package org.citygml4j.xml.adapter.tunnel;

import org.citygml4j.model.tunnel.TunnelFurnitureProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class TunnelFurniturePropertyAdapter extends AbstractFeaturePropertyAdapter<TunnelFurnitureProperty> {

    @Override
    public TunnelFurnitureProperty createObject(QName name) throws ObjectBuildException {
        return new TunnelFurnitureProperty();
    }
}
