package com.bms.dbapi.controller;


import com.bms.dbapi.models.AppUser;
import com.bms.dbapi.models.BookedSeat;
import com.bms.dbapi.repository.BookedSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/bookedSeat")
public class BookedSeatController {

    @Autowired
    BookedSeatRepository bookedSeatRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody BookedSeat bookedSeat){

        bookedSeatRepository.save(bookedSeat);
        return new ResponseEntity<>(bookedSeat, HttpStatus.CREATED);  // object instantiation, new keyword is used because, ResponseEntity is a class. new keyword is used to create an object from a class

    }

    @GetMapping("/{seatId}")
    public ResponseEntity<?> getUserById(@PathVariable UUID seatId){
        BookedSeat bookedSeat = bookedSeatRepository.findById(seatId).orElse(null);

        return new ResponseEntity<>(bookedSeat,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserById(@RequestBody BookedSeat bookedSeat){
        bookedSeatRepository.save(bookedSeat);
        return new ResponseEntity<>(bookedSeat,HttpStatus.CREATED);
    }

    @DeleteMapping("/{seatId}")
    public ResponseEntity<?> deleteUserById(@PathVariable UUID seatId){
        bookedSeatRepository.deleteById(seatId);

        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @GetMapping("/check")
    public ResponseEntity<?> isTheSeatBooked(@RequestParam UUID showId,
                                             @RequestParam int seat){
       BookedSeat bookedSeat = bookedSeatRepository.isSeatBooked(showId,seat);

       return new ResponseEntity<>(bookedSeat,HttpStatus.OK);
    }
}
