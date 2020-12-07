package com.CanalPlus.SubscriberProject.controller;

import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.MvtHistory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/mvtHistory")
public interface IMvtHistoryController {

    @GetMapping("/{subscriberId}")
    public List<MvtHistory> getMvtHistoryBySubscriberId(@PathVariable long subscriberId);
}
