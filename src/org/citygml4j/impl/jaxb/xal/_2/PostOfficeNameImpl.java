package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostOfficeElement;
import org.citygml4j.model.xal.PostOfficeName;
import org.citygml4j.model.xal.XALClass;

public class PostOfficeNameImpl extends XALBaseImpl implements PostOfficeName {
	private PostOfficeElement.PostOfficeName postOfficeName;
	
	public PostOfficeNameImpl() {
		postOfficeName = new PostOfficeElement.PostOfficeName();
	}
	
	public PostOfficeNameImpl(PostOfficeElement.PostOfficeName postOfficeName) {
		this.postOfficeName = postOfficeName;
	}
	
	@Override
	public PostOfficeElement.PostOfficeName getJAXBObject() {
		return postOfficeName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTOFFICENAME;
	}

	public String getContent() {
		return postOfficeName.getContent();
	}

	public String getType() {
		return postOfficeName.getType();
	}

	public void setContent(String content) {
		postOfficeName.setContent(content);
	}

	public void setType(String type) {
		postOfficeName.setType(type);
	}

	public String getCode() {
		return postOfficeName.getCode();
	}

	public void setCode(String code) {
		postOfficeName.setCode(code);
	}

	public boolean isSetContent() {
		return postOfficeName.isSetContent();
	}

	public boolean isSetType() {
		return postOfficeName.isSetType();
	}

	public void unsetContent() {
		postOfficeName.setContent(null);
	}

	public void unsetType() {
		postOfficeName.setType(null);
	}

	public boolean isSetCode() {
		return postOfficeName.isSetCode();
	}

	public void unsetCode() {
		postOfficeName.setCode(null);
	}
}
