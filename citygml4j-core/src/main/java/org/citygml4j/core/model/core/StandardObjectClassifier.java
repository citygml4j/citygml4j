/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.xmlobjects.gml.model.basictypes.Code;

import java.util.List;

public interface StandardObjectClassifier {
    Code getClassifier();

    void setClassifier(Code classifier);

    List<Code> getFunctions();

    boolean isSetFunctions();

    void setFunctions(List<Code> functions);

    List<Code> getUsages();

    boolean isSetUsages();

    void setUsages(List<Code> usages);
}
