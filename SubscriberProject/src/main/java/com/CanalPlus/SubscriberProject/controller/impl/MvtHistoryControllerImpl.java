package com.CanalPlus.SubscriberProject.controller.impl;

import com.CanalPlus.SubscriberProject.controller.IMvtHistoryController;
import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.MvtHistory;
import com.CanalPlus.SubscriberProject.database.dao.repository.MvtHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
public class MvtHistoryControllerImpl implements IMvtHistoryController {
    @Autowired
    private MvtHistoryRepository mvtHistoryRepository;

    @Override
    public List<MvtHistory> getMvtHistoryBySubscriberId(@PathVariable long subscriberId) {
        return mvtHistoryRepository.getMvtHistoryBySubscriberId(subscriberId);
    }
}
