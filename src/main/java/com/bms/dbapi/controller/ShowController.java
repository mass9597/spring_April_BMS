package com.bms.dbapi.controller;


import com.bms.dbapi.models.AppUser;
import com.bms.dbapi.models.Show;
import com.bms.dbapi.repository.ShowRepository;
import com.bms.dbapi.responsebody.ShowsByHallIdRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/show")
public class ShowController {

    @Autowired
    ShowRepository showRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Show show){

        showRepository.save(show);
        return new ResponseEntity<>(show, HttpStatus.CREATED);  // object instantiation, new keyword is used because, ResponseEntity is a class. new keyword is used to create an object from a class

    }

    @GetMapping("/{showId}")
    public ResponseEntity<?> getUserById(@PathVariable UUID showId){
        Show show = showRepository.findById(showId).orElse(null);

        return new ResponseEntity<>(show,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserById(@RequestBody Show show){
        showRepository.save(show);
        return new ResponseEntity<>(show,HttpStatus.CREATED);
    }

    @DeleteMapping("/{showId}")
    public ResponseEntity<?> deleteUserById(@PathVariable UUID showId){
        showRepository.deleteById(showId);

        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hall/{hallId}")

    public ResponseEntity<?> getShowsByHallId(@PathVariable UUID hallId){
        List<Show> shows =  showRepository.getShowByHallId(hallId);

        ShowsByHallIdRB showList = new ShowsByHallIdRB();

        showList.setShows(shows);

        return new ResponseEntity<>(showList,HttpStatus.OK);
    }
}
