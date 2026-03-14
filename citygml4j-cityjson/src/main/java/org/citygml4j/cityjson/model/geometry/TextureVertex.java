/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.model.geometry;

public class TextureVertex {
    private double s;
    private double t;

    private TextureVertex(double s, double t) {
        this.s = s;
        this.t = t;
    }

    public static TextureVertex of(double s, double t) {
        return new TextureVertex(s, t);
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }
}
