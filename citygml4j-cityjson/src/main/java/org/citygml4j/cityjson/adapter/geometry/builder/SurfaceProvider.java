/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.builder;

import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import java.util.List;

@FunctionalInterface
interface SurfaceProvider {
    List<SurfaceProperty> getSurfaces();
}
