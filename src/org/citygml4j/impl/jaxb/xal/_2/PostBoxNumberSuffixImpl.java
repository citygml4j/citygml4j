package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostBoxElement;
import org.citygml4j.model.xal.PostBoxNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class PostBoxNumberSuffixImpl extends XALBaseImpl implements PostBoxNumberSuffix {
	private PostBoxElement.PostBoxNumberSuffix postBoxNumberSuffix;
	
	public PostBoxNumberSuffixImpl() {
		postBoxNumberSuffix = new PostBoxElement.PostBoxNumberSuffix();
	}
	
	public PostBoxNumberSuffixImpl(PostBoxElement.PostBoxNumberSuffix postBoxNumberSuffix) {
		this.postBoxNumberSuffix = postBoxNumberSuffix;
	}
	
	@Override
	public PostBoxElement.PostBoxNumberSuffix getJAXBObject() {
		return postBoxNumberSuffix;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTBOXNUMBERSUFFIX;
	}

	@Override
	public String getContent() {
		return postBoxNumberSuffix.getContent();
	}

	@Override
	public String getNumberSuffixSeparator() {
		return postBoxNumberSuffix.getNumberSuffixSeparator();
	}

	@Override
	public void setContent(String content) {
		postBoxNumberSuffix.setContent(content);
	}

	@Override
	public void setNumberSuffixSeparator(String numberSuffixSeparator) {
		postBoxNumberSuffix.setNumberSuffixSeparator(numberSuffixSeparator);
	}

	@Override
	public String getCode() {
		return postBoxNumberSuffix.getCode();
	}

	@Override
	public void setCode(String code) {
		postBoxNumberSuffix.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return postBoxNumberSuffix.isSetContent();
	}

	@Override
	public boolean isSetNumberSuffixSeparator() {
		return postBoxNumberSuffix.isSetNumberSuffixSeparator();
	}

	@Override
	public void unsetContent() {
		postBoxNumberSuffix.setContent(null);
	}

	@Override
	public void unsetNumberSuffixSeparator() {
		postBoxNumberSuffix.setNumberSuffixSeparator(null);
	}

	@Override
	public boolean isSetCode() {
		return postBoxNumberSuffix.isSetCode();
	}

	@Override
	public void unsetCode() {
		postBoxNumberSuffix.setCode(null);
	}
}
