/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.util.reference;

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
