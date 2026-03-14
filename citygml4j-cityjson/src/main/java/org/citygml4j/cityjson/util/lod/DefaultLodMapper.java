/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.util.lod;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultLodMapper implements LodMapper {
    private final Map<Integer, Double> mappings = new HashMap<>();
    private Strategy strategy = Strategy.MAXIMUM_LOD;

    public enum Strategy {
        MAXIMUM_LOD,
        MINIMUM_LOD
    }

    public DefaultLodMapper withMappingStrategy(Strategy strategy) {
        this.strategy = strategy;
        return this;
    }

    @Override
    public void buildMapping(Set<Double> lods) {
        mappings.clear();
        lods.stream()
                .sorted(strategy == Strategy.MAXIMUM_LOD ?
                        Comparator.naturalOrder() :
                        Comparator.reverseOrder())
                .forEach(lod -> mappings.put(lod.intValue(), lod));
    }

    @Override
    public double getMappingFor(int lod) {
        return mappings.getOrDefault(lod, (double) lod);
    }
}
