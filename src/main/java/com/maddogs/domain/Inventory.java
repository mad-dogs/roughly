package com.maddogs.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Inventory extends PersistableDomainObject{

    @OneToOne
    private Item item;

    @OneToOne(optional = true)
    private Need fulfilled;

    public Inventory() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Need getFulfilled() {
        return fulfilled;
    }

    public void setFulfilled(Need fulfilled) {
        this.fulfilled = fulfilled;
    }
}
