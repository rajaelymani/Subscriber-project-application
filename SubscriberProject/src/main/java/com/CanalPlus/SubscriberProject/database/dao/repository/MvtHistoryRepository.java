package com.CanalPlus.SubscriberProject.database.dao.repository;

import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.MvtHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource
public interface MvtHistoryRepository extends JpaRepository<MvtHistory, Object> {

    @Query("select m from MvtHistory m where m.subscriberId = :s")
    public List<MvtHistory> getMvtHistoryBySubscriberId(@Param("s") long subscriberId);
}
