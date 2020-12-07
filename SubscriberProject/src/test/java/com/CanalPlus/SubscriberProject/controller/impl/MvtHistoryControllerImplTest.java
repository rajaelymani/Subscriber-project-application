package com.CanalPlus.SubscriberProject.controller.impl;

import com.CanalPlus.SubscriberProject.SubscriberProjectApplication;
import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.MvtHistory;
import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import com.CanalPlus.SubscriberProject.database.dao.repository.ContractRepository;
import com.CanalPlus.SubscriberProject.database.dao.repository.MvtHistoryRepository;
import com.CanalPlus.SubscriberProject.database.dao.repository.SubscriberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {SubscriberProjectApplication.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ExtendWith(SpringExtension.class)
class MvtHistoryControllerImplTest {

    @InjectMocks
    private MvtHistoryControllerImpl mvtHistoryController;


    @Mock
    private MvtHistoryRepository mvtHistoryRepository;



    @BeforeEach
    void setUp() {
        Subscriber subscriber1 = new Subscriber(1, "rajae", "lymani", "velizy");
        Contract contract1 = new Contract(1,"velizy",subscriber1);
        MvtHistory mvtHistory1 = new MvtHistory(subscriber1.getId(),contract1.getId(),"Adress modification",new Date(),"Boulogne-Billancour","velizy");

        List<MvtHistory> mvtHistories = new ArrayList<MvtHistory>();
        mvtHistories.add(mvtHistory1);
        when(mvtHistoryRepository.getMvtHistoryBySubscriberId(1L)).thenReturn(mvtHistories);

    }

    @Test
    void getMvtHistoryBySubscriberId() {
        assertEquals(this.mvtHistoryController.getMvtHistoryBySubscriberId(1L).size(),1);
    }
}