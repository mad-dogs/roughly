package com.maddogs.repo;

import com.maddogs.domain.Item;
import com.maddogs.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemRepository extends CrudRepository<Item,Long> {

}