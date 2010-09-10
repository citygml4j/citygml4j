package org.citygml4j.impl.gml.base;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.MetaData;
import org.citygml4j.model.gml.base.MetaDataProperty;

public class MetaDataPropertyImpl extends AssociationByRepOrRefImpl<MetaData> implements MetaDataProperty {
	private String about;
	
	public String getAbout() {
		return about;
	}

	public MetaData getMetaData() {
		return super.getObject();
	}

	public boolean isSetAbout() {
		return about != null;
	}

	public boolean isSetMetaData() {
		return super.isSetObject();
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public void setMetaData(MetaData metaData) {
		super.setObject(metaData);
	}

	public void unsetAbout() {
		about = null;
	}

	public void unsetMetaData() {
		super.unsetObject();
	}

	public GMLClass getGMLClass() {
		return GMLClass.META_DATA_PROPERTY;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MetaDataPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MetaDataProperty copy = (target == null) ? new MetaDataPropertyImpl() : (MetaDataProperty)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetAbout())
			copy.setAbout(copyBuilder.copy(about));
		
		return copy;
	}

}
