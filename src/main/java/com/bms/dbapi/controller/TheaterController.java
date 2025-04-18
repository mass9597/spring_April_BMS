package com.bms.dbapi.controller;


import com.bms.dbapi.models.AppUser;
import com.bms.dbapi.models.Theater;
import com.bms.dbapi.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/theater")
public class TheaterController {

    @Autowired
    TheaterRepository theaterRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Theater theater){

        theaterRepository.save(theater);
        return new ResponseEntity<>(theater, HttpStatus.CREATED);  // object instantiation, new keyword is used because, ResponseEntity is a class. new keyword is used to create an object from a class

    }

    @GetMapping("/{theaterId}")
    public ResponseEntity<?> getUserById(@PathVariable UUID theaterId){
        Theater theater = theaterRepository.findById(theaterId).orElse(null);

        return new ResponseEntity<>(theater,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserById(@RequestBody Theater theater){
        theaterRepository.save(theater);
        return new ResponseEntity<>(theater,HttpStatus.CREATED);
    }

    @DeleteMapping("/{theaterId}")
    public ResponseEntity<?> deleteUserById(@PathVariable UUID theaterId){
        theaterRepository.deleteById(theaterId);

        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
