package org.citygml4j.builder.copy;

public class ShallowCopyBuilder extends CopyBuilder {

	@Override
	public Object copy(final Object target) {
		if (isNullCopy(target))
			return null;

		if (isShallowCopy(target))
			return target;

		return super.copy(target);
	}

}
