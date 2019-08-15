package org.citygml4j.adapter.xml.core;

import org.citygml4j.model.core.AppearanceMember;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class AppearanceMemberAdapter extends AbstractFeatureMemberAdapter<AppearanceMember> {

    @Override
    public AppearanceMember createObject(QName name) {
        return new AppearanceMember();
    }
}
