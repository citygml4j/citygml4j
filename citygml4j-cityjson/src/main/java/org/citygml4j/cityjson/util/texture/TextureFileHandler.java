/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.util.texture;

@FunctionalInterface
public interface TextureFileHandler {
    String getImageURI(String imageURI);
}
