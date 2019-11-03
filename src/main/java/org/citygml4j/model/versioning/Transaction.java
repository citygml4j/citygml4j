package org.citygml4j.model.versioning;

import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.core.AbstractFeatureWithLifespanProperty;
import org.xmlobjects.gml.model.GMLObject;

public class Transaction extends GMLObject implements CityGMLObject {
    private TransactionValue type;
    private AbstractFeatureWithLifespanProperty oldFeature;
    private AbstractFeatureWithLifespanProperty newFeature;

    public Transaction() {
    }

    public Transaction(TransactionValue type) {
        this.type = type;
    }

    public Transaction(TransactionValue type, AbstractFeatureWithLifespanProperty oldFeature, AbstractFeatureWithLifespanProperty newFeature) {
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

    public AbstractFeatureWithLifespanProperty getOldFeature() {
        return oldFeature;
    }

    public void setOldFeature(AbstractFeatureWithLifespanProperty oldFeature) {
        this.oldFeature = asChild(oldFeature);
    }

    public AbstractFeatureWithLifespanProperty getNewFeature() {
        return newFeature;
    }

    public void setNewFeature(AbstractFeatureWithLifespanProperty newFeature) {
        this.newFeature = asChild(newFeature);
    }
}
