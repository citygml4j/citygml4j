/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades;

import implementing_ades.module.TestADEModule;
import implementing_ades.walker.TestADEWalker;
import org.citygml4j.core.visitor.ADEWalker;
import org.citygml4j.xml.ade.CityGMLADE;
import org.citygml4j.xml.module.ade.ADEModule;

import java.util.Collections;
import java.util.List;

public class TestADE implements CityGMLADE {

    @Override
    public String getName() {
        return "TestADE";
    }

    @Override
    public String getVersion() {
        return "2.0";
    }

    @Override
    public List<ADEModule> getADEModules() {
        return Collections.singletonList(new TestADEModule());
    }

    @Override
    public ADEWalker getADEWalker() {
        return new TestADEWalker();
    }
}
