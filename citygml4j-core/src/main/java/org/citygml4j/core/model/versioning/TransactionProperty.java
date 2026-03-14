/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.versioning;

import org.citygml4j.core.model.CityGMLObject;
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
