package com.maddogs.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends PersistableDomainObject{

    private String name;

    @OneToMany
    private List<Tag> tags;

    @OneToMany
    private List<Run> runs;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
