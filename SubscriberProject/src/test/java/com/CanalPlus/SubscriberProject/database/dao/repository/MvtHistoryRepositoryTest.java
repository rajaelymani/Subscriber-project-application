package com.CanalPlus.SubscriberProject.database.dao.repository;

import com.CanalPlus.SubscriberProject.SubscriberProjectApplication;
import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.MvtHistory;
import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ContextConfiguration(classes = {SubscriberProjectApplication.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ExtendWith(SpringExtension.class)
public class MvtHistoryRepositoryTest {
    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private SubscriberRepository subscriberRepository ;

    @Autowired
    private MvtHistoryRepository mvtHistoryRepository;

    @BeforeEach
    public void initEach(){
        Subscriber subscriber1 = new Subscriber(1, "rajae", "lymani", "velizy");
        Subscriber subscriber2 = new Subscriber(2, "user2", "user2", "versailles");

        Contract contract1 = new Contract(1,"velizy",subscriber1);
        Contract contract2 = new Contract(2,"versailles",subscriber2);


        MvtHistory mvtHistory1 = new MvtHistory(subscriber1.getId(),contract1.getId(),"Adress modification",new Date(),"Boulogne-Billancour","velizy");

        mvtHistoryRepository.save(mvtHistory1);
        subscriberRepository.save(subscriber1);
        subscriberRepository.save(subscriber2);
        contractRepository.save(contract1);
        contractRepository.save(contract2);

        assertNotNull(contractRepository);

    }



    @Test
    public void getMvtHistoryBySubscriberIdTest(){

        List<MvtHistory> listMvtHistory =  mvtHistoryRepository.getMvtHistoryBySubscriberId(1);
        assertNotNull(listMvtHistory);

    }

}
