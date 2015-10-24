package com.maddogs.repo;

import com.maddogs.domain.Organisation;
import com.maddogs.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "organisation", path = "organisation")
public interface OrganisationRepository extends CrudRepository<Organisation,Long> {

}