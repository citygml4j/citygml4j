/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.dynamizer;

import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class StandardFileTimeseries extends AbstractAtomicTimeseries {
    private String fileLocation;
    private Code fileType;
    private Code mimeType;
    private List<ADEOfStandardFileTimeseries> adeOfStandardFileTimeseries;

    public StandardFileTimeseries() {
    }

    public StandardFileTimeseries(String observationProperty, String fileLocation, Code fileType) {
        super(observationProperty);
        this.fileLocation = fileLocation;
        setFileType(fileType);
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public Code getFileType() {
        return fileType;
    }

    public void setFileType(Code fileType) {
        this.fileType = asChild(fileType);
    }

    public Code getMimeType() {
        return mimeType;
    }

    public void setMimeType(Code mimeType) {
        this.mimeType = asChild(mimeType);
    }

    public List<ADEOfStandardFileTimeseries> getADEOfStandardFileTimeseries() {
        if (adeOfStandardFileTimeseries == null)
            adeOfStandardFileTimeseries = new ChildList<>(this);

        return adeOfStandardFileTimeseries;
    }

    public void setADEOfStandardFileTimeseries(List<ADEOfStandardFileTimeseries> adeOfStandardFileTimeseries) {
        this.adeOfStandardFileTimeseries = asChild(adeOfStandardFileTimeseries);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
