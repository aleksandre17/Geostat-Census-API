package com.apps.censusapp.repository;

import com.apps.censusapp.entity.Addressing;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AddressingRepository extends CrudRepository<Addressing, Long> {

    @Query(value = "SELECT * FROM addressings where uuid = ?1", nativeQuery = true)
    Addressing findByUuid(String uuid);

    @Transactional
    @Modifying
    @Query(value = "UPDATE addressings SET addressing_status_id = 3 where uuid in (?1)", nativeQuery = true)
    Integer updateAddressingStatus(List<String> uuids);
}
