package com.maddogs.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Tag extends PersistableDomainObject{

    @OneToOne
    private TagType tagType;
    @ManyToOne
    private User creator;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Need> needs;
    private LocalDateTime createdDateTime;
    private int numberOfPeople;
    private int numberOfDogs;
    @Embedded
    private Location position;

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

    public Location getPosition() {
        return position;
    }

    public void setPosition(Location position) {
        this.position = position;
    }

    public List<Item> getNeedItems(){
        return needs.stream().map(need -> need.getItem()).collect(Collectors.toList());
    }
}
