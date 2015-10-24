package com.maddogs.domain;

import javax.persistence.Entity;

@Entity
public class TagType extends PersistableDomainObject {

    private String type;
    //in minutes
    private int expiryTime;

    public TagType() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(int expiryTime) {
        this.expiryTime = expiryTime;
    }
}
