package org.citygml4j.model.appearance;

import org.citygml4j.model.core.TransformationMatrix2x2;
import org.xmlobjects.gml.model.common.ChildList;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;

import java.util.ArrayList;
import java.util.List;

public class GeoreferencedTexture extends AbstractTexture {
    private Boolean preferWorldFile;
    private PointProperty referencePoint;
    private TransformationMatrix2x2 orientation;
    private List<String> targets;
    private List<ADEPropertyOfGeoreferencedTexture> adeProperties;

    public Boolean getPreferWorldFile() {
        return preferWorldFile;
    }

    public void setPreferWorldFile(Boolean preferWorldFile) {
        this.preferWorldFile = preferWorldFile;
    }

    public PointProperty getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(PointProperty referencePoint) {
        this.referencePoint = asChild(referencePoint);
    }

    public TransformationMatrix2x2 getOrientation() {
        return orientation;
    }

    public void setOrientation(TransformationMatrix2x2 orientation) {
        this.orientation = asChild(orientation);
    }

    public List<String> getTargets() {
        if (targets == null)
            targets = new ArrayList<>();

        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

    public List<ADEPropertyOfGeoreferencedTexture> getADEPropertiesOfGeoreferencedTexture() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfGeoreferencedTexture(List<ADEPropertyOfGeoreferencedTexture> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
