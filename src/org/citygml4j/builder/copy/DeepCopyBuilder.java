package org.citygml4j.builder.copy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;

public class DeepCopyBuilder extends CopyBuilder {
	private IdentityHashMap<Object, Object> visited = new IdentityHashMap<Object, Object>();
	
	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public Object copy(Collection collection) {
		final Collection copy = new ArrayList(collection.size());
		
		for (final Object item : collection) {
			final Object copyItem = copy(item);
			copy.add(copyItem);
		}
		
		return copy;
	}
	
	@SuppressWarnings("unchecked")
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
