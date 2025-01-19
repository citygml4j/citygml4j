/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
