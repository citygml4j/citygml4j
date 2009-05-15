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

	public String getContent() {
		return postBoxNumberSuffix.getContent();
	}

	public String getNumberSuffixSeparator() {
		return postBoxNumberSuffix.getNumberSuffixSeparator();
	}

	public void setContent(String content) {
		postBoxNumberSuffix.setContent(content);
	}

	public void setNumberSuffixSeparator(String numberSuffixSeparator) {
		postBoxNumberSuffix.setNumberSuffixSeparator(numberSuffixSeparator);
	}

	public String getCode() {
		return postBoxNumberSuffix.getCode();
	}

	public void setCode(String code) {
		postBoxNumberSuffix.setCode(code);
	}

	public boolean isSetContent() {
		return postBoxNumberSuffix.isSetContent();
	}

	public boolean isSetNumberSuffixSeparator() {
		return postBoxNumberSuffix.isSetNumberSuffixSeparator();
	}

	public void unsetContent() {
		postBoxNumberSuffix.setContent(null);
	}

	public void unsetNumberSuffixSeparator() {
		postBoxNumberSuffix.setNumberSuffixSeparator(null);
	}

	public boolean isSetCode() {
		return postBoxNumberSuffix.isSetCode();
	}

	public void unsetCode() {
		postBoxNumberSuffix.setCode(null);
	}
}
