package org.citygml4j.builder.copy;

import java.lang.reflect.Field;

import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;

public class ObjectCopier {
	
	public <T> T copyTo(T source, T target, CopyBuilder copyBuilder) {
		ModelObject tmp = null;
		if (copyBuilder instanceof DeepCopyBuilder && target instanceof ModelObject) {
			DeepCopyBuilder deepCopyBuilder = (DeepCopyBuilder)copyBuilder;
			tmp = deepCopyBuilder.getTarget();
			deepCopyBuilder.setTarget((ModelObject)target);
		}
		
		for (Field sourceField : source.getClass().getDeclaredFields()) {
			try {
				Field targetField = target.getClass().getDeclaredField(sourceField.getName());
				if (targetField == null)
					continue;
				
				sourceField.setAccessible(true);
				targetField.setAccessible(true);
				
				Object value = sourceField.get(source);
				Object copy = copyBuilder.copy(value);
				
				if (copy != null) {
					targetField.set(target, copy);
					if (value != copy && copy instanceof Child && target instanceof ModelObject)
						((Child)copy).setParent((ModelObject)target);
				}
				
			} catch (Exception e) {
				// 
			}
			
		}
		
		if (copyBuilder instanceof DeepCopyBuilder)
			((DeepCopyBuilder)copyBuilder).setTarget(tmp);
		
		if (target instanceof Child)
			((Child)target).unsetParent();
		
		return target;
	}
	
}
