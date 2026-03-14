/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.geometry;

public class Transform {
    private Vertex scale;
    private Vertex translate;

    public Transform() {
    }

    public Transform(Vertex scale, Vertex translate) {
        this.scale = scale;
        this.translate = translate;
    }

    public Vertex getScale() {
        return scale != null ? scale : Vertex.of(0, 0, 0);
    }

    public void setScale(Vertex scale) {
        this.scale = scale;
    }

    public Vertex getTranslate() {
        return translate != null ? translate : Vertex.of(1, 1, 1);
    }

    public void setTranslate(Vertex translate) {
        this.translate = translate;
    }
}
