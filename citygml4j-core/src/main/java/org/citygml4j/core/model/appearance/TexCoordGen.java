/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.core.model.appearance;

import org.citygml4j.core.model.core.TransformationMatrix3x4;
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
    public boolean isSetAxisLabels() {
        return axisLabels != null && !axisLabels.isEmpty();
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
    public boolean isSetUomLabels() {
        return uomLabels != null && !uomLabels.isEmpty();
    }

    @Override
    public void setUomLabels(List<String> uomLabels) {
        this.uomLabels = uomLabels;
    }
}
