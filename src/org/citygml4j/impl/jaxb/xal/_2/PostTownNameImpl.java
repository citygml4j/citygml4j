package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostalCodeElement;
import org.citygml4j.model.xal.PostTownName;
import org.citygml4j.model.xal.XALClass;

public class PostTownNameImpl extends XALBaseImpl implements PostTownName {
	private PostalCodeElement.PostTown.PostTownName postTownName;
	
	public PostTownNameImpl() {
		postTownName = new PostalCodeElement.PostTown.PostTownName();
	}
	
	public PostTownNameImpl(PostalCodeElement.PostTown.PostTownName postTownName) {
		this.postTownName = postTownName;
	}
	
	@Override
	public PostalCodeElement.PostTown.PostTownName getJAXBObject() {
		return postTownName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTTOWNNAME;
	}

	public String getContent() {
		return postTownName.getContent();
	}

	public String getType() {
		return postTownName.getType();
	}

	public void setContent(String content) {
		postTownName.setContent(content);
	}

	public void setType(String type) {
		postTownName.setType(type);
	}

	public String getCode() {
		return postTownName.getCode();
	}

	public void setCode(String code) {
		postTownName.setCode(code);
	}

	public boolean isSetContent() {
		return postTownName.isSetContent();
	}

	public boolean isSetType() {
		return postTownName.isSetType();
	}

	public void unsetContent() {
		postTownName.setContent(null);
	}

	public void unsetType() {
		postTownName.setType(null);
	}

	public boolean isSetCode() {
		return postTownName.isSetCode();
	}

	public void unsetCode() {
		postTownName.setCode(null);
	}
}
