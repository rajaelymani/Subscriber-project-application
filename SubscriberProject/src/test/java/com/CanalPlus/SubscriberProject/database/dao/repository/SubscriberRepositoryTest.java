package com.CanalPlus.SubscriberProject.database.dao.repository;


import com.CanalPlus.SubscriberProject.SubscriberProjectApplication;
import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;


@ContextConfiguration(classes = {SubscriberProjectApplication.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@ExtendWith(SpringExtension.class)
public class SubscriberRepositoryTest {

    @Autowired
    private SubscriberRepository subscriberRepository ;

    @BeforeEach
    public void initEach() {
        Subscriber subscriber1 = new Subscriber(1, "rajae", "lymani", "velizy");
        Subscriber subscriber2 = new Subscriber(2, "user2", "user2", "versailles");
        //when(this.subscriberRepository.getSubscriber(1)).thenReturn(subscriber1);

        subscriberRepository.save(subscriber1);
        subscriberRepository.save(subscriber2);

        assertNotNull(subscriberRepository);

    }

    @Test
    public void testGetSubscriber() {

        Subscriber expectedSubscriber = new Subscriber();
        expectedSubscriber.setId(1);
        expectedSubscriber.setFirstname("rajae");
        expectedSubscriber.setLastname("lymani");
        expectedSubscriber.setPrincipaladress("velizy");

        assertNotNull(expectedSubscriber);

        assertEquals(subscriberRepository.getSubscriber(1).getId(),expectedSubscriber.getId());
        assertEquals(subscriberRepository.getSubscriber(1).getFirstname(),expectedSubscriber.getFirstname());
        assertEquals(subscriberRepository.getSubscriber(1).getLastname(),expectedSubscriber.getLastname());
        assertEquals(subscriberRepository.getSubscriber(1).getPrincipaladress(),expectedSubscriber.getPrincipaladress());

    }




}
