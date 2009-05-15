package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostBoxElement;
import org.citygml4j.model.xal.PostBoxNumber;
import org.citygml4j.model.xal.XALClass;

public class PostBoxNumberImpl extends XALBaseImpl implements PostBoxNumber {
	private PostBoxElement.PostBoxNumber postBoxNumber;
	
	public PostBoxNumberImpl() {
		postBoxNumber = new PostBoxElement.PostBoxNumber();
	}
	
	public PostBoxNumberImpl(PostBoxElement.PostBoxNumber postBoxNumber) {
		this.postBoxNumber = postBoxNumber;
	}
	
	@Override
	public PostBoxElement.PostBoxNumber getJAXBObject() {
		return postBoxNumber;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTBOXNUMBER;
	}

	public String getContent() {
		return postBoxNumber.getContent();
	}

	public void setContent(String content) {
		postBoxNumber.setContent(content);
	}

	public String getCode() {
		return postBoxNumber.getCode();
	}

	public void setCode(String code) {
		postBoxNumber.setCode(code);
	}

	public boolean isSetContent() {
		return postBoxNumber.isSetContent();
	}

	public void unsetContent() {
		postBoxNumber.setContent(null);
	}

	public boolean isSetCode() {
		return postBoxNumber.isSetCode();
	}

	public void unsetCode() {
		postBoxNumber.setCode(null);
	}
}
