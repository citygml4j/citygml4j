/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.copy;

import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.copy.Copyable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

public class DeepCopyBuilder extends CopyBuilder {
	private IdentityHashMap<Object, Object> visited = new IdentityHashMap<Object, Object>();
	private ModelObject target;

	public ModelObject getTarget() {
		return target;
	}
	
	public void setTarget(ModelObject target) {
		this.target = target;
	}
	
	public void unsetTarget() {
		target = null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object copy(final Object target) {
		if (isNullCopy(target))
			return null;

		if (isShallowCopy(target))
			return target;

		Object copy = visited.get(target);
		
		if (copy != null)
			return copy;
		else if (target instanceof ChildList)
			copy = copy((ChildList)target);
		else if (target instanceof Collection)
			copy = copy((Collection)target);
		else if (target instanceof Map)
			copy = copy((Map)target);
		else if (target instanceof Copyable)
			copy = ((Copyable)target).copy(this);
		else
			copy = super.copy(target);
		
		if (copy != null)
			visited.put(target, copy);
		
		return copy;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object copy(ChildList childList) {
		if (target == null)
			return copy((Collection)childList);
		
		final ChildList copy = new ChildList(target);
		for (final Object item : childList) {
			final Object copyItem = copy(item);
			copy.add((Child)copyItem);
		}
		
		return copy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object copy(Collection collection) {
		final Collection copy = new ArrayList(collection.size());
		
		for (final Object item : collection) {
			final Object copyItem = copy(item);
			copy.add(copyItem);
		}
		
		return copy;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object copy(Map map) {
		final Map copy = new HashMap(map.size());
		
		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry entry = (Map.Entry)it.next();
	        final Object copyKey = copy(entry.getKey());
	        final Object copyValue = copy(entry.getValue());
	        map.put(copyKey, copyValue);
	    }
		
	    return copy;
	}
}
