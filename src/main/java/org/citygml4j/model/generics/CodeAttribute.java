package org.citygml4j.model.generics;

import org.citygml4j.model.core.AbstractGenericAttribute;
import org.xmlobjects.gml.model.basictypes.Code;

public class CodeAttribute extends AbstractGenericAttribute<Code> {

    public CodeAttribute() {
    }

    public CodeAttribute(String name, Code value) {
        super(name, value);
    }

    @Override
    public void setValue(Code value) {
        super.setValue(asChild(value));
    }
}
