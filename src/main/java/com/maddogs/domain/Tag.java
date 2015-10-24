package com.maddogs.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Tag extends PersistableDomainObject{

    @OneToOne
    private TagType tagType;
    @ManyToOne
    private User creator;
    @OneToMany
    private List<Need> needs;
    private LocalDateTime createdDateTime;
    private int numberOfPeople;
    private int numberOfDogs;

    public Tag() {
    }

    public TagType getTagType() {
        return tagType;
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Need> getNeeds() {
        return needs;
    }

    public void setNeeds(List<Need> needs) {
        this.needs = needs;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfDogs() {
        return numberOfDogs;
    }

    public void setNumberOfDogs(int numberOfDogs) {
        this.numberOfDogs = numberOfDogs;
    }
}
