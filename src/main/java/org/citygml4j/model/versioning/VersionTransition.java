package org.citygml4j.model.versioning;

import org.citygml4j.model.core.AbstractVersionTransition;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class VersionTransition extends AbstractVersionTransition {
    private String reason;
    private boolean clonePredecessor;
    private TransitionValue type;
    private VersionProperty from;
    private VersionProperty to;
    private List<TransactionProperty> transactions;
    private List<ADEOfVersionTransition> adeOfVersionTransition;

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
