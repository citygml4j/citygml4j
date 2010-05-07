package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostOfficeElement;
import org.citygml4j.model.xal.PostOfficeNumber;
import org.citygml4j.model.xal.XALClass;

public class PostOfficeNumberImpl extends XALBaseImpl implements PostOfficeNumber {
	private PostOfficeElement.PostOfficeNumber postOfficeNumber;
	
	public PostOfficeNumberImpl() {
		postOfficeNumber = new PostOfficeElement.PostOfficeNumber();
	}
	
	public PostOfficeNumberImpl(PostOfficeElement.PostOfficeNumber postOfficeNumber) {
		this.postOfficeNumber = postOfficeNumber;
	}
	
	@Override
	public PostOfficeElement.PostOfficeNumber getJAXBObject() {
		return postOfficeNumber;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTOFFICENUMBER;
	}

	public String getContent() {
		return postOfficeNumber.getContent();
	}

	public String getIndicator() {
		return postOfficeNumber.getIndicator();
	}

	public String getIndicatorOccurrence() {
		return postOfficeNumber.getIndicatorOccurrence();
	}

	public void setContent(String content) {
		postOfficeNumber.setContent(content);
	}

	public void setIndicator(String indicator) {
		postOfficeNumber.setIndicator(indicator);
	}

	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			postOfficeNumber.setIndicatorOccurrence(indicatorOccurrence);
	}

	public String getCode() {
		return postOfficeNumber.getCode();
	}

	public void setCode(String code) {
		postOfficeNumber.setCode(code);
	}

	public boolean isSetContent() {
		return postOfficeNumber.isSetContent();
	}

	public boolean isSetIndicator() {
		return postOfficeNumber.isSetIndicator();
	}

	public boolean isSetIndicatorOccurrence() {
		return postOfficeNumber.isSetIndicatorOccurrence();
	}

	public void unsetContent() {
		postOfficeNumber.setContent(null);
	}

	public void unsetIndicator() {
		postOfficeNumber.setIndicator(null);
	}

	public void unsetIndicatorOccurrence() {
		postOfficeNumber.setIndicatorOccurrence(null);
	}

	public boolean isSetCode() {
		return postOfficeNumber.isSetCode();
	}

	public void unsetCode() {
		postOfficeNumber.setCode(null);
	}

}
