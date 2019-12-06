package org.citygml4j.xml.ade;

import org.atteo.classindex.IndexSubclasses;
import org.citygml4j.visitor.ADEWalker;
import org.citygml4j.xml.module.ade.ADEModule;

import java.util.List;

@IndexSubclasses
public interface ADEContext {
    List<ADEModule> getADEModules();

    default ADEWalker getADEWalker() {
        return null;
    }
}
