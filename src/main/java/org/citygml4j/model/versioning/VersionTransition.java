package org.citygml4j.model.versioning;

import org.citygml4j.model.core.AbstractVersionTransition;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public class VersionTransition extends AbstractVersionTransition {
    private String reason;
    private boolean clonePredecessor;
    private TransitionValue type;
    private VersionProperty from;
    private VersionProperty to;
    private List<TransactionProperty> transactions;
    private List<ADEPropertyOfVersionTransition> adeProperties;

    public VersionTransition() {
    }

    public VersionTransition(boolean clonePredecessor) {
        this.clonePredecessor = clonePredecessor;
    }

    public VersionTransition(boolean clonePredecessor, VersionProperty from, VersionProperty to) {
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

    public VersionProperty getFrom() {
        return from;
    }

    public void setFrom(VersionProperty from) {
        this.from = asChild(from);
    }

    public VersionProperty getTo() {
        return to;
    }

    public void setTo(VersionProperty to) {
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

    public List<ADEPropertyOfVersionTransition> getADEPropertiesOfVersionTransition() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfVersionTransition(List<ADEPropertyOfVersionTransition> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
