/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.util.reference;

import org.xmlobjects.model.Child;

import java.util.*;

public class Referees {
    public static final String PROPERTY_NAME = Referees.class.getName();
    private final Map<Child, Boolean> referees = new IdentityHashMap<>();

    public Referees() {
    }

    public Referees(Collection<? extends Child> referees) {
        addAll(referees);
    }

    public Set<Child> get() {
        return referees.keySet();
    }

    public <T extends Child> List<T> get(Class<T> type) {
        List<T> referees = null;

       for (Child referee : this.referees.keySet()) {
           if (type.isAssignableFrom(referee.getClass())) {
               if (referees == null) {
                   referees = new ArrayList<>();
               }

               referees.add(type.cast(referee));
           }
       }

       return referees != null ? referees : Collections.emptyList();
    }

    public void add(Child referee) {
        if (referee != null) {
            referees.put(referee, Boolean.TRUE);
        }
    }

    public void addAll(Collection<? extends Child> referees) {
        if (referees != null) {
            referees.forEach(v -> this.referees.put(v, Boolean.TRUE));
        }
    }

    public boolean isEmpty() {
        return referees.isEmpty();
    }
}
