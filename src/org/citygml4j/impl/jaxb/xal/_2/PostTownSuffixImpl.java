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

	@Override
	public String getContent() {
		return postTownSuffix.getContent();
	}

	@Override
	public void setContent(String content) {
		postTownSuffix.setContent(content);
	}

	@Override
	public String getCode() {
		return postTownSuffix.getCode();
	}

	@Override
	public void setCode(String code) {
		postTownSuffix.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return postTownSuffix.isSetContent();
	}

	@Override
	public void unsetContent() {
		postTownSuffix.setContent(null);
	}

	@Override
	public boolean isSetCode() {
		return postTownSuffix.isSetCode();
	}

	@Override
	public void unsetCode() {
		postTownSuffix.setCode(null);
	}
}
