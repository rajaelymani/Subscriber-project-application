package com.CanalPlus.SubscriberProject.database.dao.repository;

import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface ContractRepository extends JpaRepository<Contract, Object> {

    @Query("select c from Contract c where c.subscriber.id = :s")
    public List<Contract> getAllContractBySubscriberId(@Param("s") long subscriberId);


}
