/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.core.model.dynamizer.TimeseriesComponentProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class TimeseriesComponentPropertyAdapter extends AbstractInlinePropertyAdapter<TimeseriesComponentProperty> {

    @Override
    public TimeseriesComponentProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new TimeseriesComponentProperty();
    }
}
