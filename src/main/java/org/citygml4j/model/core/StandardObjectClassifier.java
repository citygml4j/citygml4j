package org.citygml4j.model.core;

import org.xmlobjects.gml.model.basictypes.Code;

import java.util.List;

public interface StandardObjectClassifier {
    Code getClassifier();
    void setClassifier(Code classifier);
    List<Code> getFunctions();
    void setFunctions(List<Code> functions);
    List<Code> getUsages();
    void setUsages(List<Code> usages);
}
