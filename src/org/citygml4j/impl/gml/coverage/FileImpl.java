package org.citygml4j.impl.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.coverage.File;
import org.citygml4j.model.gml.coverage.FileValueModel;
import org.citygml4j.model.gml.coverage.RangeParameters;

public class FileImpl implements File {
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
		File copy = (target == null) ? new FileImpl() : (File)target;
		
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
		return copyTo(new FileImpl(), copyBuilder);
	}

}
