package org.citygml4j.xml.adapter.relief;

import org.citygml4j.model.relief.ExtentProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.AbstractGeometryPropertyAdapter;

import javax.xml.namespace.QName;

public class ExtentPropertyAdapter extends AbstractGeometryPropertyAdapter<ExtentProperty> {

    @Override
    public ExtentProperty createObject(QName name) throws ObjectBuildException {
        return new ExtentProperty();
    }
}
