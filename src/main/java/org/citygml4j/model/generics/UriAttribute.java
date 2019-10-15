package org.citygml4j.model.generics;

import org.citygml4j.model.core.AbstractGenericAttribute;

public class UriAttribute extends AbstractGenericAttribute<String> {

    public UriAttribute() {
    }

    public UriAttribute(String name, String value) {
        super(name, value);
    }
}
