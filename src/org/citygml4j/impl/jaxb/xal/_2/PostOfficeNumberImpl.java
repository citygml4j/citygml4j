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

	@Override
	public String getContent() {
		return postOfficeNumber.getContent();
	}

	@Override
	public String getIndicator() {
		return postOfficeNumber.getIndicator();
	}

	@Override
	public String getIndicatorOccurrence() {
		return postOfficeNumber.getIndicatorOccurrence();
	}

	@Override
	public void setContent(String content) {
		postOfficeNumber.setContent(content);
	}

	@Override
	public void setIndicator(String indicator) {
		postOfficeNumber.setIndicator(indicator);
	}

	@Override
	public void setIndicatorOccurrence(String indicatorOccurrence) {
		if (indicatorOccurrence.equals("Before") || indicatorOccurrence.equals("After"))
			postOfficeNumber.setIndicatorOccurrence(indicatorOccurrence);
	}

	@Override
	public String getCode() {
		return postOfficeNumber.getCode();
	}

	@Override
	public void setCode(String code) {
		postOfficeNumber.setCode(code);
	}

	@Override
	public boolean isSetContent() {
		return postOfficeNumber.isSetContent();
	}

	@Override
	public boolean isSetIndicator() {
		return postOfficeNumber.isSetIndicator();
	}

	@Override
	public boolean isSetIndicatorOccurrence() {
		return postOfficeNumber.isSetIndicatorOccurrence();
	}

	@Override
	public void unsetContent() {
		postOfficeNumber.setContent(null);
	}

	@Override
	public void unsetIndicator() {
		postOfficeNumber.setIndicator(null);
	}

	@Override
	public void unsetIndicatorOccurrence() {
		postOfficeNumber.setIndicatorOccurrence(null);
	}

	@Override
	public boolean isSetCode() {
		return postOfficeNumber.isSetCode();
	}

	@Override
	public void unsetCode() {
		postOfficeNumber.setCode(null);
	}

}
