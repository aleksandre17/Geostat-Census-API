package com.apps.censusapp.repository;

import com.apps.censusapp.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUserName(String username);

    UserEntity findByUserId(String userId);
}
