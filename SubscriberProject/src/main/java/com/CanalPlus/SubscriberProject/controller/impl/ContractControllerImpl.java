package com.CanalPlus.SubscriberProject.controller.impl;

import com.CanalPlus.SubscriberProject.controller.IContractController;
import com.CanalPlus.SubscriberProject.controller.ISubscriberController;
import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import com.CanalPlus.SubscriberProject.database.dao.repository.ContractRepository;
import com.CanalPlus.SubscriberProject.database.dao.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class ContractControllerImpl implements IContractController {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;


    @Override
    public Contract addContract(@PathVariable (value = "subscriberId") Long subscriberId,
                                              @RequestBody Contract contract) {
        return subscriberRepository.findById(subscriberId).map(subscriber -> {
            contract.setSubscriber(subscriber);
            return contractRepository.save(contract);
        }).orElseThrow(() -> new ResourceNotFoundException("SubscriberId " + subscriberId + " not found"));
    }

}
