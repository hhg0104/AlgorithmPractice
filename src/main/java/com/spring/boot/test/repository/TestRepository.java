package com.spring.boot.test.repository;

import com.spring.boot.test.entity.TestEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TestRepository extends CrudRepository<TestEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE TEST " +
            "SET CNT=?1 " +
            "WHERE ID=?2",
            nativeQuery = true)
    void updateCntById(int cnt, int id);

}
