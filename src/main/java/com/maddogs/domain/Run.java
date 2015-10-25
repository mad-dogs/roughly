package com.maddogs.domain;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Run extends PersistableDomainObject {

    @ManyToOne
    private User creator;
    private LocalDateTime createdDateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @RestResource(exported = false)
    private List<Inventory> inventory;

    public Run() {
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<Inventory> inventory) {
        this.inventory = inventory;
    }

    public List<Item> getInventoryItems(){
        return inventory.stream()
                .map(inventoryEntry -> inventoryEntry.getItem())
                .collect(Collectors.toList());
    }
}
