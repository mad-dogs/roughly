package com.maddogs.repo;

import com.maddogs.domain.TagType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tagtype", path = "tagtype")
public interface TagTypeRepository extends CrudRepository<TagType,Long> {

}