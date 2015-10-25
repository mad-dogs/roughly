package com.maddogs.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Need extends PersistableDomainObject {

    @OneToOne
    private Item item;

    @OneToOne(optional = true, cascade = CascadeType.PERSIST)
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
