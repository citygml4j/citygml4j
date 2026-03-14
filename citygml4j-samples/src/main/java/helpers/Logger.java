/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package helpers;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Logger {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
    private final Instant start = Instant.now();

    public static Logger start(Class<?> type) {
        Logger log = new Logger();
        log.print("Starting " + type.getSimpleName() + " program");
        return log;
    }

    public void print(String message) {
        System.out.println("[" + LocalTime.now().format(formatter) + "] " + message);
    }

    public void finish() {
        Duration elapsed = Duration.between(start, Instant.now());
        print("Sample citygml4j program finished after " + elapsed.getSeconds() + "." + (elapsed.getNano() / 1000_000) + "s");
    }
}