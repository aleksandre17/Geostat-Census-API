package com.apps.censusapp.repository;

import com.apps.censusapp.entity.SupervisionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressingSupervisionRepository extends CrudRepository<SupervisionEntity, Long> {

    @Query(value = "SELECT * FROM addressing_supervision where addressing_uuid = ?1", nativeQuery = true)
    SupervisionEntity findByAddressingUuid(String addressingId);
}
