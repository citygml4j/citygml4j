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

	@Override
	public String getContent() {
		return postBoxNumber.getContent();
	}

	@Override
	public void setContent(String content) {
		postBoxNumber.setContent(content);
	}

	@Override
	public String getCode() {
		return postBoxNumber.getCode();
	}

	@Override
	public void setCode(String code) {
		postBoxNumber.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return postBoxNumber.isSetContent();
	}

	@Override
	public void unsetContent() {
		postBoxNumber.setContent(null);
	}

	@Override
	public boolean isSetCode() {
		return postBoxNumber.isSetCode();
	}

	@Override
	public void unsetCode() {
		postBoxNumber.setCode(null);
	}
}
