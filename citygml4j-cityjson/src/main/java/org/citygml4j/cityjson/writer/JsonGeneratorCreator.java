/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import tools.jackson.core.JacksonException;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.ObjectWriter;

@FunctionalInterface
interface JsonGeneratorCreator {
    JsonGenerator create(ObjectWriter objectWriter) throws JacksonException;
}
