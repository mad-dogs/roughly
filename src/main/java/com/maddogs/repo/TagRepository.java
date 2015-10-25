package com.maddogs.repo;

import com.maddogs.domain.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "tag", path = "tag", excerptProjection = TagProjection.class)
public interface TagRepository extends CrudRepository<Tag,Long> {

    @Query("SELECT t FROM Tag t WHERE t.expireDateTime IS NULL OR t.expireDateTime < CURRENT_TIME")
    List<Tag> active();

}