package com.maddogs.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Need extends PersistableDomainObject {

    @OneToOne
    private Item item;

    @OneToOne
    private Inventory fulfilledBy;

    public Need() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Inventory getFulfilledBy() {
        return fulfilledBy;
    }

    public void setFulfilledBy(Inventory fulfilledBy) {
        this.fulfilledBy = fulfilledBy;
    }
}
