/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.binding.cityjson.metadata;

public class ConstraintsType {
    private LegalConstraintsType legalConstraints;
    private SecurityConstraintsType securityConstraints;
    private String userNote;

    public boolean isSetLegalConstraints() {
        return legalConstraints != null;
    }

    public LegalConstraintsType getLegalConstraints() {
        return legalConstraints;
    }

    public void setLegalConstraints(LegalConstraintsType legalConstraints) {
        this.legalConstraints = legalConstraints;
    }

    public void unsetLegalConstraints() {
        legalConstraints = null;
    }

    public boolean isSetSecurityConstraints() {
        return securityConstraints != null;
    }

    public SecurityConstraintsType getSecurityConstraints() {
        return securityConstraints;
    }

    public void setSecurityConstraints(SecurityConstraintsType securityConstraints) {
        this.securityConstraints = securityConstraints;
    }

    public void unsetSecurityConstraints() {
        securityConstraints = null;
    }

    public boolean isSetUserNote() {
        return userNote != null;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    public void unsetUserNote() {
        userNote = null;
    }
}
