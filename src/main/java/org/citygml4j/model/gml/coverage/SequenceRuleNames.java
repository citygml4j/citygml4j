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
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public enum SequenceRuleNames implements GML, Copyable {
	LINEAR("Linear"),
    BOUSTROPHEDONIC("Boustrophedonic"),
    CANTOR_DIAGONAL("Cantor-diagonal"),
    SPIRAL("Spiral"),
    MORTON("Morton"),
    HILBERT("Hilbert");

	private final String value;

	SequenceRuleNames(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public static SequenceRuleNames fromValue(String v) {
		v = v.trim();

		for (SequenceRuleNames c: SequenceRuleNames.values())
			if (c.value.equals(v))
				return c;

		return LINEAR;
	}

	public String toString() {
		return value;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.SEQUENCE_RULE_NAMES;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		return (target == null) ? LINEAR : this;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return this;
	}

}
