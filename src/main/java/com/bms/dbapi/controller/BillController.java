package com.bms.dbapi.controller;

import com.bms.dbapi.models.AppUser;
import com.bms.dbapi.models.Bill;
import com.bms.dbapi.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/bill")

public class BillController {

    @Autowired
    BillRepository billRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Bill bill){

        billRepository.save(bill);
        return new ResponseEntity<>(bill, HttpStatus.CREATED);  // object instantiation, new keyword is used because, ResponseEntity is a class. new keyword is used to create an object from a class

    }

    @GetMapping("/{billId}")
    public ResponseEntity<?> getUserById(@PathVariable UUID billId){
        Bill bill= billRepository.findById(billId).orElse(null);

        return new ResponseEntity<>(bill,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserById(@RequestBody Bill bill){
        billRepository.save(bill);
        return new ResponseEntity<>(bill,HttpStatus.CREATED);
    }

    @DeleteMapping("/{billId}")
    public ResponseEntity<?> deleteUserById(@PathVariable UUID billId){
        billRepository.deleteById(billId);

        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
