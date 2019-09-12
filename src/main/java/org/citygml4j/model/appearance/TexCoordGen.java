package org.citygml4j.model.appearance;

import org.citygml4j.model.core.TransformationMatrix3x4;
import org.xmlobjects.gml.model.geometry.SRSReference;

import java.util.ArrayList;
import java.util.List;

public class TexCoordGen extends AbstractTextureParameterization implements SRSReference {
    private TransformationMatrix3x4 worldToTexture;
    private String srsName;
    private Integer srsDimension;
    private List<String> axisLabels;
    private List<String> uomLabels;

    public TransformationMatrix3x4 getWorldToTexture() {
        return worldToTexture;
    }

    public void setWorldToTexture(TransformationMatrix3x4 worldToTexture) {
        this.worldToTexture = asChild(worldToTexture);
    }

    @Override
    public String getSrsName() {
        return srsName;
    }

    @Override
    public void setSrsName(String srsName) {
        this.srsName = srsName;
    }

    @Override
    public Integer getSrsDimension() {
        return srsDimension;
    }

    @Override
    public void setSrsDimension(Integer srsDimension) {
        if (srsDimension == null || srsDimension > 0)
            this.srsDimension = srsDimension;
    }

    @Override
    public List<String> getAxisLabels() {
        return axisLabels;
    }

    @Override
    public void setAxisLabels(List<String> axisLabels) {
        if (axisLabels == null)
            axisLabels = new ArrayList<>();

        this.axisLabels = axisLabels;
    }

    @Override
    public List<String> getUomLabels() {
        if (uomLabels == null)
            uomLabels = new ArrayList<>();

        return uomLabels;
    }

    @Override
    public void setUomLabels(List<String> uomLabels) {
        this.uomLabels = uomLabels;
    }
}
