package com.maddogs.repo;

import com.maddogs.domain.Tag;
import com.maddogs.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tag", path = "tag", excerptProjection = TagProjection.class)
public interface TagRepository extends CrudRepository<Tag,Long> {

}