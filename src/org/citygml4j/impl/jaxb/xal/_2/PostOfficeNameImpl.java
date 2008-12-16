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

	@Override
	public String getContent() {
		return postOfficeName.getContent();
	}

	@Override
	public String getType() {
		return postOfficeName.getType();
	}

	@Override
	public void setContent(String content) {
		postOfficeName.setContent(content);
	}

	@Override
	public void setType(String type) {
		postOfficeName.setType(type);
	}

	@Override
	public String getCode() {
		return postOfficeName.getCode();
	}

	@Override
	public void setCode(String code) {
		postOfficeName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return postOfficeName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return postOfficeName.isSetType();
	}

	@Override
	public void unsetContent() {
		postOfficeName.setContent(null);
	}

	@Override
	public void unsetType() {
		postOfficeName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return postOfficeName.isSetCode();
	}

	@Override
	public void unsetCode() {
		postOfficeName.setCode(null);
	}
}
