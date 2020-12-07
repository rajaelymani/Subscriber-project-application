package com.CanalPlus.SubscriberProject.database.dao.repository;

import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;




@CrossOrigin
@RepositoryRestResource
public interface SubscriberRepository extends JpaRepository<Subscriber, Object> {

    @Query("select s from Subscriber s where s.id = :x")
    public Subscriber getSubscriber(@Param("x") long subscriberId);


}
