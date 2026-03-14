/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.deprecated.cityobjectgroup;

import org.citygml4j.core.model.deprecated.cityobjectgroup.GroupParentMember;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.feature.AbstractFeatureMemberAdapter;

import javax.xml.namespace.QName;

public class GroupParentMemberAdapter extends AbstractFeatureMemberAdapter<GroupParentMember> {

    @Override
    public GroupParentMember createObject(QName name, Object parent) throws ObjectBuildException {
        return new GroupParentMember();
    }
}
