package org.citygml4j.impl.jaxb.xal._2;

import org.citygml4j.jaxb.xal.PostalRouteType;
import org.citygml4j.model.xal.PostalRouteName;
import org.citygml4j.model.xal.XALClass;

public class PostalRouteNameImpl extends XALBaseImpl implements PostalRouteName {
	private PostalRouteType.PostalRouteName postalRouteName;
	
	public PostalRouteNameImpl() {
		postalRouteName = new PostalRouteType.PostalRouteName();
	}
	
	public PostalRouteNameImpl(PostalRouteType.PostalRouteName postalRouteName) {
		this.postalRouteName = postalRouteName;
	}
	
	@Override
	public PostalRouteType.PostalRouteName getJAXBObject() {
		return postalRouteName;
	}

	@Override
	public XALClass getXALClass() {
		return XALClass.POSTALROUTENAME;
	}

	public String getContent() {
		return postalRouteName.getContent();
	}

	public String getType() {
		return postalRouteName.getType();
	}

	public void setContent(String content) {
		postalRouteName.setContent(content);
	}

	public void setType(String type) {
		postalRouteName.setType(type);
	}

	public String getCode() {
		return postalRouteName.getCode();
	}

	public void setCode(String code) {
		postalRouteName.setCode(code);
	}
	
	public boolean isSetContent() {
		return postalRouteName.isSetContent();
	}

	public boolean isSetType() {
		return postalRouteName.isSetType();
	}

	public void unsetContent() {
		postalRouteName.setContent(null);
	}

	public void unsetType() {
		postalRouteName.setType(null);
	}

	public boolean isSetCode() {
		return postalRouteName.isSetCode();
	}

	public void unsetCode() {
		postalRouteName.setCode(null);
	}
}
