/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.versioning;

import org.citygml4j.model.core.AbstractVersionTransition;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class VersionTransition extends AbstractVersionTransition {
    private String reason;
    private boolean clonePredecessor;
    private TransitionValue type;
    private VersionReference from;
    private VersionReference to;
    private List<TransactionProperty> transactions;
    private List<ADEOfVersionTransition> adeOfVersionTransition;

    public VersionTransition() {
    }

    public VersionTransition(boolean clonePredecessor) {
        this.clonePredecessor = clonePredecessor;
    }

    public VersionTransition(boolean clonePredecessor, VersionReference from, VersionReference to) {
        this.clonePredecessor = clonePredecessor;
        setFrom(from);
        setTo(to);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isClonePredecessor() {
        return clonePredecessor;
    }

    public void setClonePredecessor(boolean clonePredecessor) {
        this.clonePredecessor = clonePredecessor;
    }

    public TransitionValue getType() {
        return type;
    }

    public void setType(TransitionValue type) {
        this.type = type;
    }

    public VersionReference getFrom() {
        return from;
    }

    public void setFrom(VersionReference from) {
        this.from = asChild(from);
    }

    public VersionReference getTo() {
        return to;
    }

    public void setTo(VersionReference to) {
        this.to = asChild(to);
    }

    public List<TransactionProperty> getTransactions() {
        if (transactions == null)
            transactions = new ChildList<>(this);

        return transactions;
    }

    public void setTransactions(List<TransactionProperty> transactions) {
        this.transactions = asChild(transactions);
    }

    public List<ADEOfVersionTransition> getADEOfVersionTransition() {
        if (adeOfVersionTransition == null)
            adeOfVersionTransition = new ChildList<>(this);

        return adeOfVersionTransition;
    }

    public void setADEOfVersionTransition(List<ADEOfVersionTransition> adeOfVersionTransition) {
        this.adeOfVersionTransition = asChild(adeOfVersionTransition);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
