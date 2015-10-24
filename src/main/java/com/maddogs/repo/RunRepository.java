package com.maddogs.repo;

import com.maddogs.domain.Run;
import com.maddogs.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "run", path = "run")
public interface RunRepository extends CrudRepository<Run,Long> {

}