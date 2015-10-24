package com.maddogs.repo;

import com.maddogs.domain.Need;
import com.maddogs.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "need", path = "need")
public interface NeedRepository extends CrudRepository<Need,Long> {

}