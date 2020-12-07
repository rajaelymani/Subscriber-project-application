package com.CanalPlus.SubscriberProject.controller.impl;

import com.CanalPlus.SubscriberProject.SubscriberProjectApplication;
import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import com.CanalPlus.SubscriberProject.database.dao.repository.ContractRepository;
import com.CanalPlus.SubscriberProject.database.dao.repository.SubscriberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {SubscriberProjectApplication.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ExtendWith(SpringExtension.class)
class SubscriberControllerImplTest {

    @InjectMocks
    private SubscriberControllerImpl subscriberController;

    @Mock
    private ContractRepository contractRepository;

    @Mock
    private SubscriberRepository subscriberRepository;

    @BeforeEach
    void setUp() {
        Subscriber subscriber1 = new Subscriber(1, "rajae", "lymani", "velizy");
        Subscriber subscriber2 = new Subscriber(2, "user2", "user2", "versailles");

        List<Subscriber> subscribers = new ArrayList<Subscriber>();
        subscribers.add(subscriber1);
        subscribers.add(subscriber2);
        when(this.subscriberRepository.findAll()).thenReturn(subscribers);
        when(this.subscriberRepository.getSubscriber(1L)).thenReturn(subscriber1);


    }

    @Test
    void getAllSubscribers() {
        List<Subscriber> subscribers = this.subscriberRepository.findAll();
        assertEquals(subscriberController.getAllSubscribers().size(),subscribers.size());
    }

    @Test
    void retrieveSubscriber() {
        assertEquals(this.subscriberController.retrieveSubscriber(1L).getPrincipaladress(),"velizy");
    }

}