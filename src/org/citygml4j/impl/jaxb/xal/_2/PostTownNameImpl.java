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

	@Override
	public String getContent() {
		return postTownName.getContent();
	}

	@Override
	public String getType() {
		return postTownName.getType();
	}

	@Override
	public void setContent(String content) {
		postTownName.setContent(content);
	}

	@Override
	public void setType(String type) {
		postTownName.setType(type);
	}

	@Override
	public String getCode() {
		return postTownName.getCode();
	}

	@Override
	public void setCode(String code) {
		postTownName.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return postTownName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return postTownName.isSetType();
	}

	@Override
	public void unsetContent() {
		postTownName.setContent(null);
	}

	@Override
	public void unsetType() {
		postTownName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return postTownName.isSetCode();
	}

	@Override
	public void unsetCode() {
		postTownName.setCode(null);
	}
}
