package com.maddogs.repo;

import com.maddogs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestToolsRepository extends JpaRepository<User, Long>{

}
