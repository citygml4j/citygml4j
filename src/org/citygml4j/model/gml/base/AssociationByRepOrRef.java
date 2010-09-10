package org.citygml4j.model.gml.base;

import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.child.Child;

public interface AssociationByRepOrRef<T extends Associable & Child> extends AssociationByRep<T>, AssociationAttributeGroup {

}
