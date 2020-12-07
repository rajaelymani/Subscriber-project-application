package com.CanalPlus.SubscriberProject.controller;

import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/contracts")
public interface IContractController {



    @PostMapping(value = "/{subscriberId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Contract addContract(@PathVariable (value = "subscriberId") Long subscriberId,
                                               @RequestBody Contract contract);
}
