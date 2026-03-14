/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;

public class HtmlEscapes extends CharacterEscapes {
    private final int[] escapes;

    HtmlEscapes() {
        escapes = CharacterEscapes.standardAsciiEscapesForJSON();
        escapes['<'] = CharacterEscapes.ESCAPE_STANDARD;
        escapes['>'] = CharacterEscapes.ESCAPE_STANDARD;
        escapes['&'] = CharacterEscapes.ESCAPE_STANDARD;
        escapes['='] = CharacterEscapes.ESCAPE_STANDARD;
        escapes['\''] = CharacterEscapes.ESCAPE_STANDARD;
    }

    @Override
    public int[] getEscapeCodesForAscii() {
        return escapes;
    }

    @Override
    public SerializableString getEscapeSequence(int ch) {
        return null;
    }
}
