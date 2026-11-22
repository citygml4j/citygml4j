/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.cityobjectgroup;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

class CityObjectGroupTest {

    @Test
    void setGroupMembersSetsParent() {
        RoleProperty member = new RoleProperty(new Role());
        List<RoleProperty> members = new ArrayList<>(List.of(member));

        CityObjectGroup group = new CityObjectGroup();
        group.setGroupMembers(members);

        assertSame(group, member.getParent());
        RoleProperty added = new RoleProperty(new Role());
        group.getGroupMembers().add(added);
        assertSame(group, added.getParent());
    }
}
