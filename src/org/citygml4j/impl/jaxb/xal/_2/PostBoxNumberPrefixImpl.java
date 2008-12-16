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

	@Override
	public String getContent() {
		return postBoxNumberPrefix.getContent();
	}

	@Override
	public String getNumberPrefixSeparator() {
		return postBoxNumberPrefix.getNumberPrefixSeparator();
	}

	@Override
	public void setContent(String content) {
		postBoxNumberPrefix.setContent(content);
	}

	@Override
	public void setNumberPrefixSeparator(String numberPrefixSeparator) {
		postBoxNumberPrefix.setNumberPrefixSeparator(numberPrefixSeparator);
	}

	@Override
	public String getCode() {
		return postBoxNumberPrefix.getCode();
	}

	@Override
	public void setCode(String code) {
		postBoxNumberPrefix.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return postBoxNumberPrefix.isSetContent();
	}

	@Override
	public boolean isSetNumberPrefixSeparator() {
		return postBoxNumberPrefix.isSetNumberPrefixSeparator();
	}

	@Override
	public void unsetContent() {
		postBoxNumberPrefix.setContent(null);
	}

	@Override
	public void unsetNumberPrefixSeparator() {
		postBoxNumberPrefix.setNumberPrefixSeparator(null);
	}

	@Override
	public boolean isSetCode() {
		return postBoxNumberPrefix.isSetCode();
	}

	@Override
	public void unsetCode() {
		postBoxNumberPrefix.setCode(null);
	}
}
