/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

public abstract class AbstractAtomicTimeseries extends AbstractTimeseries {
    private String observationProperty;
    private String uom;

    public AbstractAtomicTimeseries() {
    }

    public AbstractAtomicTimeseries(String observationProperty) {
        this.observationProperty = observationProperty;
    }

    public String getObservationProperty() {
        return observationProperty;
    }

    public void setObservationProperty(String observationProperty) {
        this.observationProperty = observationProperty;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}
