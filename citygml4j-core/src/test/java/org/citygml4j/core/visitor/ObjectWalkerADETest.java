/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.visitor;

import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.core.AbstractFeature;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectWalkerADETest {

    public static class BaseADEFeature extends AbstractFeature implements ADEObject {
        Building inherited;

        @Override
        public void accept(ObjectVisitor visitor) {
            visitor.visit((ADEObject) this);
        }
    }

    public static class ADEFeature extends BaseADEFeature {
        static Building shared = new Building();
        Building own;
    }

    @Test
    void walksInheritedAdeFieldsButNotStaticFields() {
        Building inherited = new Building();
        inherited.setId("inherited");
        Building own = new Building();
        own.setId("own");
        ADEFeature.shared.setId("shared");

        ADEFeature feature = new ADEFeature();
        feature.inherited = inherited;
        feature.own = own;

        List<String> visited = new ArrayList<>();
        feature.accept(new ObjectWalker() {
            @Override
            public void visit(Building building) {
                visited.add(building.getId());
            }
        });

        visited.sort(null);
        assertEquals(List.of("inherited", "own"), visited);
    }
}
