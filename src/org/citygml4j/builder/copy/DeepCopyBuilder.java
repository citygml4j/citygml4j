/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.builder.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

import org.citygml4j.model.common.copy.Copyable;

public class DeepCopyBuilder extends CopyBuilder {
	private IdentityHashMap<Object, Object> visited = new IdentityHashMap<Object, Object>();
	
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
