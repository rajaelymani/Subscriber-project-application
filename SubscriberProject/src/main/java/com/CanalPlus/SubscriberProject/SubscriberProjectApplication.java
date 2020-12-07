package com.CanalPlus.SubscriberProject;

import com.CanalPlus.SubscriberProject.database.dao.entity.Contract;
import com.CanalPlus.SubscriberProject.database.dao.entity.MvtHistory;
import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import com.CanalPlus.SubscriberProject.database.dao.repository.ContractRepository;
import com.CanalPlus.SubscriberProject.database.dao.repository.SubscriberRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootApplication
public class SubscriberProjectApplication {

	private static final Logger logger = LogManager.getLogger(SubscriberProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SubscriberProjectApplication.class, args);

		logger.info("CanalPlus Test started");

	}

	@Bean
	CommandLineRunner runner(SubscriberRepository subscriberRepository, ContractRepository contractRepository){
		Subscriber subscriber1 = new Subscriber(1, "rajae", "lymani", "velizy");
		Subscriber subscriber2 = new Subscriber(2, "user2", "user2", "versailles");

		Contract contract1 = new Contract(1,"velizy",subscriber1);
		Contract contract2 = new Contract(2,"velizy",subscriber1);
		Contract contract3 = new Contract(3,"velizy",subscriber1);

		Contract contract4 = new Contract(4,"versailles",subscriber2);
		Contract contract5 = new Contract(5,"versailles",subscriber2);
		Contract contract6 = new Contract(6,"versailles",subscriber2);



		return args -> {
			subscriberRepository.save(subscriber1);
			subscriberRepository.save(subscriber2);

			contractRepository.save(contract1);
			contractRepository.save(contract2);
			contractRepository.save(contract3);
			contractRepository.save(contract4);
			contractRepository.save(contract5);
			contractRepository.save(contract6);
		};




	}


}
