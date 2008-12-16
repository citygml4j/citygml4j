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

	@Override
	public String getContent() {
		return postalRouteName.getContent();
	}

	@Override
	public String getType() {
		return postalRouteName.getType();
	}

	@Override
	public void setContent(String content) {
		postalRouteName.setContent(content);
	}

	@Override
	public void setType(String type) {
		postalRouteName.setType(type);
	}

	@Override
	public String getCode() {
		return postalRouteName.getCode();
	}

	@Override
	public void setCode(String code) {
		postalRouteName.setCode(code);
	}
	
	@Override
	public boolean isSetContent() {
		return postalRouteName.isSetContent();
	}

	@Override
	public boolean isSetType() {
		return postalRouteName.isSetType();
	}

	@Override
	public void unsetContent() {
		postalRouteName.setContent(null);
	}

	@Override
	public void unsetType() {
		postalRouteName.setType(null);
	}

	@Override
	public boolean isSetCode() {
		return postalRouteName.isSetCode();
	}

	@Override
	public void unsetCode() {
		postalRouteName.setCode(null);
	}
}
