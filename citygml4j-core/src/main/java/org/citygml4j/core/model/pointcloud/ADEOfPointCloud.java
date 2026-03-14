/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.pointcloud;

import org.citygml4j.core.model.ade.ADEProperty;

public abstract class ADEOfPointCloud extends ADEProperty {

    @Override
    public final Class<PointCloud> getTargetType() {
        return PointCloud.class;
    }
}
