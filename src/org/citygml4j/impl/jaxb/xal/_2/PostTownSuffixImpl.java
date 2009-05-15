package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostalCodeElement;
import org.citygml4j.model.xal.PostTownSuffix;
import org.citygml4j.model.xal.XALClass;

public class PostTownSuffixImpl extends XALBaseImpl implements PostTownSuffix {
	private PostalCodeElement.PostTown.PostTownSuffix postTownSuffix;
	
	public PostTownSuffixImpl() {
		postTownSuffix = new PostalCodeElement.PostTown.PostTownSuffix();
	}
	
	public PostTownSuffixImpl(PostalCodeElement.PostTown.PostTownSuffix postTownSuffix) {
		this.postTownSuffix = postTownSuffix;
	}
	
	@Override
	public PostalCodeElement.PostTown.PostTownSuffix getJAXBObject() {
		return postTownSuffix;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTTOWNSUFFIX;
	}

	public String getContent() {
		return postTownSuffix.getContent();
	}

	public void setContent(String content) {
		postTownSuffix.setContent(content);
	}

	public String getCode() {
		return postTownSuffix.getCode();
	}

	public void setCode(String code) {
		postTownSuffix.setCode(code);
	}

	public boolean isSetContent() {
		return postTownSuffix.isSetContent();
	}

	public void unsetContent() {
		postTownSuffix.setContent(null);
	}

	public boolean isSetCode() {
		return postTownSuffix.isSetCode();
	}

	public void unsetCode() {
		postTownSuffix.setCode(null);
	}
}
