package com.CanalPlus.SubscriberProject.controller.impl;

import com.CanalPlus.SubscriberProject.controller.ISubscriberController;
import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.MvtHistory;
import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import com.CanalPlus.SubscriberProject.database.dao.repository.ContractRepository;
import com.CanalPlus.SubscriberProject.database.dao.repository.MvtHistoryRepository;
import com.CanalPlus.SubscriberProject.database.dao.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Date;
import java.util.List;

@Component
public class SubscriberControllerImpl implements ISubscriberController {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private MvtHistoryRepository mvtHistoryRepository;



    @Override
    public List<Subscriber> getAllSubscribers() {
        List<Subscriber> Subscribers = subscriberRepository.findAll();
        return Subscribers;
    }

    @Override
    public Subscriber retrieveSubscriber(@PathVariable long id) {
        return subscriberRepository.getSubscriber(id);

    }

    @Override
    public ResponseEntity<String> addSubscriber(@RequestBody  Subscriber subscriber) {
        subscriberRepository.save(subscriber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateAdressSubscriber(@PathVariable long subscriberId,@PathVariable String newAdress) {
        Subscriber subscriber = this.retrieveSubscriber(subscriberId);
        subscriber.setPrincipaladress(newAdress);
        subscriberRepository.save(subscriber);

        //update the contract adress
        List<Contract> listContract = contractRepository.getAllContractBySubscriberId(subscriberId);
        for (int i=0; i < listContract.size(); i++){

            String oldAdressValue = listContract.get(i).getAdress();
            listContract.get(i).setAdress(newAdress);
            contractRepository.save(listContract.get(i));


            //save the changes in the MvtHistory table.
            MvtHistory mvtHistory = new MvtHistory(subscriberId,listContract.get(i).getId(),"Adress modification",new Date(),newAdress,oldAdressValue);
            mvtHistoryRepository.save(mvtHistory);
        }



        return new ResponseEntity<>(HttpStatus.OK);
    }


}
