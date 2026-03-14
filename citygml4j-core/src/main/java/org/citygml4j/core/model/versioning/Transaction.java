/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.versioning;

import org.citygml4j.core.model.CityGMLObject;
import org.citygml4j.core.model.core.AbstractFeatureWithLifespanReference;
import org.xmlobjects.gml.model.GMLObject;

public class Transaction extends GMLObject implements CityGMLObject {
    private TransactionValue type;
    private AbstractFeatureWithLifespanReference oldFeature;
    private AbstractFeatureWithLifespanReference newFeature;

    public Transaction() {
    }

    public Transaction(TransactionValue type) {
        this.type = type;
    }

    public Transaction(TransactionValue type, AbstractFeatureWithLifespanReference oldFeature, AbstractFeatureWithLifespanReference newFeature) {
        this.type = type;
        setOldFeature(oldFeature);
        setNewFeature(newFeature);
    }

    public TransactionValue getType() {
        return type;
    }

    public void setType(TransactionValue type) {
        this.type = type;
    }

    public AbstractFeatureWithLifespanReference getOldFeature() {
        return oldFeature;
    }

    public void setOldFeature(AbstractFeatureWithLifespanReference oldFeature) {
        this.oldFeature = asChild(oldFeature);
    }

    public AbstractFeatureWithLifespanReference getNewFeature() {
        return newFeature;
    }

    public void setNewFeature(AbstractFeatureWithLifespanReference newFeature) {
        this.newFeature = asChild(newFeature);
    }
}
