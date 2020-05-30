package org.citygml4j.model.ade.generic;

import org.w3c.dom.Element;

public interface ADEGenericPropertyContainer {
    Element getValue();
    void setValue(Element value);
}
