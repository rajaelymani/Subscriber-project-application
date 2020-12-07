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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ContextConfiguration(classes = {SubscriberProjectApplication.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ExtendWith(SpringExtension.class)
class ContractControllerImplTest {

    @InjectMocks
    private ContractControllerImpl contractController;


    @Mock
    private ContractRepository contractRepository;

    @Mock
    private SubscriberRepository subscriberRepository;

    @Test
    void addContract() {

        Subscriber subscriber1 = new Subscriber(1, "rajae", "lymani", "velizy");

        Contract contract1 = new Contract(1,"velizy",subscriber1);



        when(subscriberRepository.findById(1L)).thenReturn(java.util.Optional.of(subscriber1));
        when(contractRepository.save(contract1)).thenReturn(contract1);



        Contract expectedContract = this.contractController.addContract(1L,contract1);
        assertEquals(expectedContract.getAdress(),contract1.getAdress());





    }
}