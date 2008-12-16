package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostBoxElement;
import org.citygml4j.model.xal.PostBoxNumberExtension;
import org.citygml4j.model.xal.XALClass;

public class PostBoxNumberExtensionImpl extends XALBaseImpl implements PostBoxNumberExtension {
	private PostBoxElement.PostBoxNumberExtension postBoxNumberExtension;
	
	public PostBoxNumberExtensionImpl() {
		postBoxNumberExtension = new PostBoxElement.PostBoxNumberExtension();
	}
	
	public PostBoxNumberExtensionImpl(PostBoxElement.PostBoxNumberExtension postBoxNumberExtension) {
		this.postBoxNumberExtension = postBoxNumberExtension;
	}
	
	@Override
	public PostBoxElement.PostBoxNumberExtension getJAXBObject() {
		return postBoxNumberExtension;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTBOXNUMBEREXTENSION;
	}

	@Override
	public String getContent() {
		return postBoxNumberExtension.getContent();
	}

	@Override
	public String getNumberExtensionSeparator() {
		return postBoxNumberExtension.getNumberExtensionSeparator();
	}

	@Override
	public void setContent(String content) {
		postBoxNumberExtension.setContent(content);
	}

	@Override
	public void setNumberExtensionSeparator(String numberExtensionSeparator) {
		postBoxNumberExtension.setNumberExtensionSeparator(numberExtensionSeparator);
	}

	@Override
	public boolean isSetContent() {
		return postBoxNumberExtension.isSetContent();
	}

	@Override
	public boolean isSetNumberExtensionSeparator() {
		return postBoxNumberExtension.isSetNumberExtensionSeparator();
	}

	@Override
	public void unsetContent() {
		postBoxNumberExtension.setContent(null);
	}

	@Override
	public void unsetNumberExtensionSeparator() {
		postBoxNumberExtension.setNumberExtensionSeparator(null);
	}

}
