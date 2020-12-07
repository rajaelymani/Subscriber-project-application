package com.CanalPlus.SubscriberProject.controller;

import com.CanalPlus.SubscriberProject.database.dao.entity.Subscriber;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@CrossOrigin
@RestController
@RequestMapping(path = "/subscribers")
public interface ISubscriberController {

    @GetMapping
    public List<Subscriber> getAllSubscribers();

    @GetMapping("/{id}")
    public Subscriber retrieveSubscriber(@PathVariable long id);

    @PostMapping(value = "/addSubscriber", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addSubscriber(@RequestBody Subscriber subscriber);


    @PostMapping(value = "/updateAdressSubscriber/{subscriberId}/{newAdress}")
    public ResponseEntity<String> updateAdressSubscriber(@PathVariable long subscriberId,@PathVariable String newAdress);



}
