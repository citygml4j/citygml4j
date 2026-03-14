/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.ade;

import org.citygml4j.core.ade.ADE;
import org.citygml4j.xml.module.ade.ADEModule;

import java.util.List;

public interface CityGMLADE extends ADE {
    List<ADEModule> getADEModules();
}
