package org.citygml4j.model.versioning;

import org.citygml4j.model.core.AbstractFeatureWithLifespanProperty;
import org.citygml4j.model.core.AbstractVersion;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.ArrayList;
import java.util.List;

public class Version extends AbstractVersion {
    private List<String> tags;
    private List<AbstractFeatureWithLifespanProperty> versionMembers;
    private List<ADEPropertyOfVersion<?>> adeProperties;

    public List<String> getTags() {
        if (tags == null)
            tags = new ArrayList<>();

        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<AbstractFeatureWithLifespanProperty> getVersionMembers() {
        if (versionMembers == null)
            versionMembers = new ChildList<>(this);

        return versionMembers;
    }

    public void setVersionMembers(List<AbstractFeatureWithLifespanProperty> versionMembers) {
        this.versionMembers = asChild(versionMembers);
    }

    public List<ADEPropertyOfVersion<?>> getADEPropertiesOfVersion() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfVersion(List<ADEPropertyOfVersion<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
