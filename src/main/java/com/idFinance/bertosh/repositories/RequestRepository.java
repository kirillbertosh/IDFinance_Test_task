package com.idFinance.bertosh.repositories;

import com.idFinance.bertosh.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query(value = "select * from Request r where r.status = com.idFinance.bertosh.constants.Status.COMPLETED",
            nativeQuery = true)
    List<Request> findByStatusCompleted();

    @Query(value = "select * from Request r where r.status = com.idFinance.bertosh.constants.Status.REFUSED",
            nativeQuery = true)
    List<Request> findByStatusRefused();


}
