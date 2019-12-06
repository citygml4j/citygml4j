package org.citygml4j.xml.reader;

import org.citygml4j.CityGMLContext;

public class CityGMLInputFactory {
    public static final String CREATE_GENERIC_ADE_CONTENT = "org.citygml4j.createGenericADEContent";
    public static final String FAIL_ON_MISSING_ADE_SCHEMA = "org.citygml4j.failOnMissingADESchema";

    private final CityGMLContext context;

    public CityGMLInputFactory(CityGMLContext context) {
        this.context = context;
    }
}
