package org.citygml4j.impl.xal;

import java.util.Iterator;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.XALFunctor;
import org.citygml4j.model.common.visitor.XALVisitor;
import org.citygml4j.model.xal.AddressLine;
import org.citygml4j.model.xal.ThoroughfareNumber;
import org.citygml4j.model.xal.ThoroughfareNumberFrom;
import org.citygml4j.model.xal.ThoroughfareNumberFromContent;
import org.citygml4j.model.xal.ThoroughfareNumberPrefix;
import org.citygml4j.model.xal.ThoroughfareNumberSuffix;
import org.citygml4j.model.xal.XALClass;

public class ThoroughfareNumberFromImpl implements ThoroughfareNumberFrom {
	private List<ThoroughfareNumberFromContent> content;
	private String code;
	private Object parent;

	public void addAddressLine(AddressLine addressLine) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContentImpl(addressLine));
	}

	public void addContent(ThoroughfareNumberFromContent content) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(content);
	}

	public void addThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContentImpl(thoroughfareNumber));
	}

	public void addThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContentImpl(thoroughfareNumberPrefix));
	}

	public void addThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContentImpl(thoroughfareNumberSuffix));
	}

	public void addString(String string) {
		if (this.content == null)
			this.content = new ChildList<ThoroughfareNumberFromContent>(this);

		this.content.add(new ThoroughfareNumberFromContentImpl(string));
	}

	public List<ThoroughfareNumberFromContent> getContent() {
		if (content == null)
			content = new ChildList<ThoroughfareNumberFromContent>(this);

		return content;
	}

	public boolean isSetContent() {
		return content != null && !content.isEmpty();
	}

	public void setContent(List<ThoroughfareNumberFromContent> content) {
		this.content = new ChildList<ThoroughfareNumberFromContent>(this, content);
	}

	public boolean unsetAddressLine(AddressLine addressLine) {
		boolean success = false;

		if (isSetContent()) {
			Iterator<ThoroughfareNumberFromContent> iter = content.iterator();
			while (iter.hasNext()) {
				ThoroughfareNumberFromContent content = iter.next();

				if (content != null && content.equals(addressLine)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;
	}

	public void unsetContent() {
		if (isSetContent())
			content.clear();

		content = null;
	}

	public boolean unsetContent(ThoroughfareNumberFromContent content) {
		return isSetContent() ? this.content.remove(content) : false;
	}

	public boolean unsetThoroughfareNumber(ThoroughfareNumber thoroughfareNumber) {
		boolean success = false;

		if (isSetContent()) {
			Iterator<ThoroughfareNumberFromContent> iter = content.iterator();
			while (iter.hasNext()) {
				ThoroughfareNumberFromContent content = iter.next();

				if (content != null && content.equals(thoroughfareNumber)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;	
	}

	public boolean unsetThoroughfareNumberPrefix(ThoroughfareNumberPrefix thoroughfareNumberPrefix) {
		boolean success = false;

		if (isSetContent()) {
			Iterator<ThoroughfareNumberFromContent> iter = content.iterator();
			while (iter.hasNext()) {
				ThoroughfareNumberFromContent content = iter.next();

				if (content != null && content.equals(thoroughfareNumberPrefix)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;
	}

	public boolean unsetThoroughfareNumberSuffix(ThoroughfareNumberSuffix thoroughfareNumberSuffix) {
		boolean success = false;

		if (isSetContent()) {
			Iterator<ThoroughfareNumberFromContent> iter = content.iterator();
			while (iter.hasNext()) {
				ThoroughfareNumberFromContent content = iter.next();

				if (content != null && content.equals(thoroughfareNumberSuffix)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;
	}

	public boolean unsetString(String string) {
		boolean success = false;

		if (isSetContent()) {
			Iterator<ThoroughfareNumberFromContent> iter = content.iterator();
			while (iter.hasNext()) {
				ThoroughfareNumberFromContent content = iter.next();

				if (content != null && content.equals(string)) {
					iter.remove();
					success = true;
					break;
				}
			}
		}

		return success;
	}

	public XALClass getXALClass() {
		return XALClass.THOROUGHFARE_NUMBER_FROM;
	}

	public String getCode() {
		return code;
	}

	public boolean isSetCode() {
		return code != null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void unsetCode() {
		code = null;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ThoroughfareNumberFromImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ThoroughfareNumberFrom copy = (target == null) ? new ThoroughfareNumberFromImpl() : (ThoroughfareNumberFrom)target;

		if (isSetContent()) {
			for (ThoroughfareNumberFromContent part : content) {
				ThoroughfareNumberFromContent copyPart = (ThoroughfareNumberFromContent)copyBuilder.copy(part);
				copy.addContent(copyPart);

				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}

		if (isSetCode())
			copy.setCode(copyBuilder.copy(code));

		copy.unsetParent();

		return copy;
	}
	
	public void visit(XALVisitor visitor) {
		visitor.visit(this);
	}
	
	public <T> T visit(XALFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
