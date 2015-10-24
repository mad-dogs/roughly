package com.maddogs.repo;

import com.maddogs.domain.Inventory;
import com.maddogs.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "inventory", path = "inventory")
public interface InventoryRepository extends CrudRepository<Inventory,Long> {

}