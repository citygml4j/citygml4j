/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.util.texture;

import java.nio.file.Paths;

public final class DefaultTextureFileHandler implements TextureFileHandler {

    @Override
    public String getImageURI(String imageURI) {
        try {
            if (imageURI != null && !Paths.get(imageURI).isAbsolute()) {
                imageURI = imageURI.replace("\\", "/");
            }
        } catch (Exception e) {
            //
        }

        return imageURI;
    }
}
