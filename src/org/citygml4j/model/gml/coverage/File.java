/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id: File.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public class File implements GML, Child, Copyable {
	private RangeParameters rangeParameters;
	private String fileName;
	private FileValueModel fileStructure;
	private String mimeType;
	private String compression;
	private ModelObject parent;

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.FILE;
	}

	public RangeParameters getRangeParameters() {
		return rangeParameters;
	}

	public String getFileName() {
		return fileName;
	}

	public FileValueModel getFileStructure() {
		return fileStructure;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getCompression() {
		return compression;
	}

	public boolean isSetRangeParameters() {
		return rangeParameters != null;
	}

	public boolean isSetFileName() {
		return fileName != null;
	}

	public boolean isSetFileStructure() {
		return fileStructure != null;
	}

	public boolean isSetMimeType() {
		return mimeType != null;
	}

	public boolean isSetCompression() {
		return compression != null;
	}

	public void setRangeParameters(RangeParameters rangeParameters) {
		if (rangeParameters != null)
			rangeParameters.setParent(this);
		
		this.rangeParameters = rangeParameters;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setFileStructure(FileValueModel fileStructure) {
		this.fileStructure = fileStructure;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public void setCompression(String compression) {
		this.compression = compression;
	}

	public void unsetRangeParameters() {
		if (isSetRangeParameters())
			rangeParameters.unsetParent();
		
		rangeParameters = null;
	}

	public void unsetFileName() {
		fileName = null;
	}

	public void unsetFileStructure() {
		fileStructure = null;
	}

	public void unsetMimeType() {
		mimeType = null;
	}

	public void unsetCompression() {
		compression = null;
	}
	
	public ModelObject getParent() {
		return parent;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		File copy = (target == null) ? new File() : (File)target;
		
		if (isSetRangeParameters()) {
			copy.setRangeParameters((RangeParameters)copyBuilder.copy(rangeParameters));
			if (copy.getRangeParameters() == rangeParameters)
				rangeParameters.setParent(this);
		}
		
		if (isSetFileName())
			copy.setFileName(copyBuilder.copy(fileName));
		
		if (isSetFileStructure())
			copy.setFileStructure((FileValueModel)copyBuilder.copy(fileStructure));
		
		if (isSetMimeType())
			copy.setMimeType(copyBuilder.copy(mimeType));
		
		if (isSetCompression())
			copy.setCompression(copyBuilder.copy(compression));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new File(), copyBuilder);
	}

}
