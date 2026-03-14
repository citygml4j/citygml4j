/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.versioning;

import org.citygml4j.core.model.core.AbstractFeatureWithLifespanReference;
import org.citygml4j.core.model.core.AbstractVersion;
import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.ArrayList;
import java.util.List;

public class Version extends AbstractVersion {
    private List<String> tags;
    private List<AbstractFeatureWithLifespanReference> versionMembers;

    public List<String> getTags() {
        if (tags == null)
            tags = new ArrayList<>();

        return tags;
    }

    public boolean isSetTags() {
        return tags != null && !tags.isEmpty();
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<AbstractFeatureWithLifespanReference> getVersionMembers() {
        if (versionMembers == null)
            versionMembers = new ChildList<>(this);

        return versionMembers;
    }

    public boolean isSetVersionMembers() {
        return versionMembers != null && !versionMembers.isEmpty();
    }

    public void setVersionMembers(List<AbstractFeatureWithLifespanReference> versionMembers) {
        this.versionMembers = asChild(versionMembers);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
