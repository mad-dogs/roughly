package com.maddogs.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
public class Inventory extends PersistableDomainObject{

    @OneToOne
    private Item item;

    @OneToOne(optional = true)
    private Need fulfilled;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime fulfilledDateTime;

    public LocalDateTime getFulfilledDateTime() {
        return fulfilledDateTime;
    }

    public void setFulfilledDateTime(LocalDateTime fulfilledDateTime) {
        this.fulfilledDateTime = fulfilledDateTime;
    }

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
