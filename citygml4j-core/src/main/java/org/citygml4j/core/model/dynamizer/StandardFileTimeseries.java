/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;

public class StandardFileTimeseries extends AbstractAtomicTimeseries {
    private String fileLocation;
    private Code fileType;
    private Code mimeType;

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

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
