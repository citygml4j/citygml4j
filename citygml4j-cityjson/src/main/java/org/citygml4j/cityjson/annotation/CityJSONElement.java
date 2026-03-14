/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.annotation;

import org.citygml4j.cityjson.model.CityJSONVersion;

import java.lang.annotation.*;

@Documented
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CityJSONElement {
    String name();

    String schema();

    CityJSONVersion version();
}
