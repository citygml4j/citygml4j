/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.adapter;

import implementing_ades.model.EnergyPerformanceCertificationProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;

import javax.xml.namespace.QName;

public class EnergyPerformanceCertificationPropertyAdapter extends AbstractInlinePropertyAdapter<EnergyPerformanceCertificationProperty> {

    @Override
    public EnergyPerformanceCertificationProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new EnergyPerformanceCertificationProperty();
    }
}
