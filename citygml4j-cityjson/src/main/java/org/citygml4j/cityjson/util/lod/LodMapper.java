/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.util.lod;

import java.util.Set;

public interface LodMapper {
    void buildMapping(Set<Double> lods);

    double getMappingFor(int lod);
}
