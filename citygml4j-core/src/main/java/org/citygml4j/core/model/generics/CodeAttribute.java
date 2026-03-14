/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.generics;

import org.citygml4j.core.model.core.AbstractGenericAttribute;
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
