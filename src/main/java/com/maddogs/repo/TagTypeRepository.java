package com.maddogs.repo;

import com.maddogs.domain.Need;
import com.maddogs.domain.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tag", path = "tag")
public interface TagTypeRepository extends CrudRepository<Tag,Long> {

}