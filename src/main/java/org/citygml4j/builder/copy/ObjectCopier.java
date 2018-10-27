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

import java.lang.reflect.Field;

public class ObjectCopier {
	
	private ObjectCopier() {
		// just to thwart instantiation
	}
	
	public static <T> T copyTo(T source, T target, CopyBuilder copyBuilder) {
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
