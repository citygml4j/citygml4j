/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.model;

import org.citygml4j.core.model.ade.ADEObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class EnergyPerformanceCertificationProperty extends AbstractInlineProperty<EnergyPerformanceCertification> implements ADEObject {

    public EnergyPerformanceCertificationProperty() {
    }

    public EnergyPerformanceCertificationProperty(EnergyPerformanceCertification object) {
        super(object);
    }

    @Override
    public Class<EnergyPerformanceCertification> getTargetType() {
        return EnergyPerformanceCertification.class;
    }
}
