package org.citygml4j.model.versioning;

import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.base.AbstractInlineProperty;

public class TransactionProperty extends AbstractInlineProperty<Transaction> implements CityGMLObject {

    public TransactionProperty() {
    }

    public TransactionProperty(Transaction object) {
        super(object);
    }

    @Override
    public Class<Transaction> getTargetType() {
        return Transaction.class;
    }
}
