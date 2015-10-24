package com.maddogs.domain;

import javax.persistence.Entity;

@Entity
public class Item extends PersistableDomainObject {

    private String description;
    //in minutes
    private int sourcingTime;

    public Item() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSourcingTime() {
        return sourcingTime;
    }

    public void setSourcingTime(int sourcingTime) {
        this.sourcingTime = sourcingTime;
    }
}