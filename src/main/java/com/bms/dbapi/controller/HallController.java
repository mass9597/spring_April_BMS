package com.bms.dbapi.controller;


import com.bms.dbapi.models.AppUser;
import com.bms.dbapi.models.Hall;
import com.bms.dbapi.repository.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/hall")
public class HallController {

    @Autowired
    HallRepository hallRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Hall hall){

        hallRepository.save(hall);
        return new ResponseEntity<>(hall, HttpStatus.CREATED);  // object instantiation, new keyword is used because, ResponseEntity is a class. new keyword is used to create an object from a class

    }

    @GetMapping("/{hallId}")
    public ResponseEntity<?> getUserById(@PathVariable UUID hallId){
        Hall hall = hallRepository.findById(hallId).orElse(null);

        return new ResponseEntity<>(hall,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserById(@RequestBody Hall hall)
    {
        hallRepository.save(hall);
        return new ResponseEntity<>(hall,HttpStatus.CREATED);
    }

    @DeleteMapping("/{hallId}")
    public ResponseEntity<?> deleteUserById(@PathVariable UUID hallId){
        hallRepository.deleteById(hallId);

        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
