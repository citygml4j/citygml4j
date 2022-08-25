/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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