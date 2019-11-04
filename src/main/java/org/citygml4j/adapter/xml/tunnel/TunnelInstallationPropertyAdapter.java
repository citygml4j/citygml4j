package org.citygml4j.adapter.xml.tunnel;

import org.citygml4j.model.tunnel.TunnelInstallationProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeaturePropertyAdapter;

import javax.xml.namespace.QName;

public class TunnelInstallationPropertyAdapter extends AbstractFeaturePropertyAdapter<TunnelInstallationProperty> {

    @Override
    public TunnelInstallationProperty createObject(QName name) throws ObjectBuildException {
        return new TunnelInstallationProperty();
    }
}
