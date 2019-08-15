package org.citygml4j.model.generics;

import java.time.LocalDate;

public class DateAttribute extends AbstractGenericAttribute<LocalDate> {

    public DateAttribute() {
    }

    public DateAttribute(String name, LocalDate value) {
        super(name, value);
    }
}
