/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.ade;

import org.atteo.classindex.IndexSubclasses;

@IndexSubclasses
public abstract class ADELoader<T extends ADE> {
    protected abstract void loadADE(T ade) throws ADEException;

    protected abstract void unloadADE(T ade) throws ADEException;
}
