/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.model;

import org.citygml4j.core.model.ade.ADEObject;
import org.xmlobjects.gml.model.GMLObject;

import java.util.ArrayList;
import java.util.List;

public class EnergyPerformanceCertification extends GMLObject implements ADEObject {
    private List<String> certificationNames;
    private String certificationId;

    public List<String> getCertificationNames() {
        if (certificationNames == null) {
            certificationNames = new ArrayList<>();
        }

        return certificationNames;
    }

    public boolean isSetCertificationNames() {
        return certificationNames != null && !certificationNames.isEmpty();
    }

    public void setCertificationNames(List<String> certificationNames) {
        this.certificationNames = certificationNames;
    }

    public String getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(String certificationId) {
        this.certificationId = certificationId;
    }
}
