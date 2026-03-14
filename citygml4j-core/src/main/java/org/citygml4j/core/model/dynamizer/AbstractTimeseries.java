/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.dynamizer;

import org.citygml4j.core.model.core.AbstractFeature;
import org.xmlobjects.gml.model.temporal.TimePosition;

public abstract class AbstractTimeseries extends AbstractFeature {
    private TimePosition firstTimestamp;
    private TimePosition lastTimestamp;

    public TimePosition getFirstTimestamp() {
        return firstTimestamp;
    }

    public void setFirstTimestamp(TimePosition firstTimestamp) {
        this.firstTimestamp = asChild(firstTimestamp);
    }

    public TimePosition getLastTimestamp() {
        return lastTimestamp;
    }

    public void setLastTimestamp(TimePosition lastTimestamp) {
        this.lastTimestamp = asChild(lastTimestamp);
    }
}
