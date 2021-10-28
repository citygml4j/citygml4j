/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.versioning;

import org.citygml4j.model.core.AbstractVersion;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.model.ChildList;

import java.util.ArrayList;
import java.util.List;

public class Version extends AbstractVersion {
    private List<String> tags;
    private List<Reference> versionMembers;
    private List<ADEOfVersion> adeOfVersion;

    public List<String> getTags() {
        if (tags == null)
            tags = new ArrayList<>();

        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Reference> getVersionMembers() {
        if (versionMembers == null)
            versionMembers = new ChildList<>(this);

        return versionMembers;
    }

    public void setVersionMembers(List<Reference> versionMembers) {
        this.versionMembers = asChild(versionMembers);
    }

    public List<ADEOfVersion> getADEOfVersion() {
        if (adeOfVersion == null)
            adeOfVersion = new ChildList<>(this);

        return adeOfVersion;
    }

    public void setADEOfVersion(List<ADEOfVersion> adeOfVersion) {
        this.adeOfVersion = asChild(adeOfVersion);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
