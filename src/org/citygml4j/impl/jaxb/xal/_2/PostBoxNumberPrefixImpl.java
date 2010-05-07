package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostBoxElement;
import org.citygml4j.model.xal.PostBoxNumberPrefix;
import org.citygml4j.model.xal.XALClass;

public class PostBoxNumberPrefixImpl extends XALBaseImpl implements PostBoxNumberPrefix {
	private PostBoxElement.PostBoxNumberPrefix postBoxNumberPrefix;
	
	public PostBoxNumberPrefixImpl() {
		postBoxNumberPrefix = new PostBoxElement.PostBoxNumberPrefix();
	}
	
	public PostBoxNumberPrefixImpl(PostBoxElement.PostBoxNumberPrefix postBoxNumberPrefix) {
		this.postBoxNumberPrefix = postBoxNumberPrefix;
	}
	
	@Override
	public PostBoxElement.PostBoxNumberPrefix getJAXBObject() {
		return postBoxNumberPrefix;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTBOXNUMBERPREFIX;
	}

	public String getContent() {
		return postBoxNumberPrefix.getContent();
	}

	public String getNumberPrefixSeparator() {
		return postBoxNumberPrefix.getNumberPrefixSeparator();
	}

	public void setContent(String content) {
		postBoxNumberPrefix.setContent(content);
	}

	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		postBoxNumberPrefix.setNumberPrefixSeparator(numberPrefixSeparator);
	}

	public String getCode() {
		return postBoxNumberPrefix.getCode();
	}

	public void setCode(String code) {
		postBoxNumberPrefix.setCode(code);
	}

	public boolean isSetContent() {
		return postBoxNumberPrefix.isSetContent();
	}

	public boolean isSetNumberPrefixSeparator() {
		return postBoxNumberPrefix.isSetNumberPrefixSeparator();
	}

	public void unsetContent() {
		postBoxNumberPrefix.setContent(null);
	}

	public void unsetNumberPrefixSeparator() {
		postBoxNumberPrefix.setNumberPrefixSeparator(null);
	}

	public boolean isSetCode() {
		return postBoxNumberPrefix.isSetCode();
	}

	public void unsetCode() {
		postBoxNumberPrefix.setCode(null);
	}
}
