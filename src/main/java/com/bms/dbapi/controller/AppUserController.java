package com.bms.dbapi.controller;


import com.bms.dbapi.models.AppUser;
import com.bms.dbapi.repository.AppUserRepository;
import com.bms.dbapi.responsebody.AdminResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/user")
public class AppUserController {

    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody AppUser user){

        appUserRepository.save(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);  // object instantiation, new keyword is used because, ResponseEntity is a class. new keyword is used to create an object from a class

    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable UUID userId){
        AppUser user = appUserRepository.findById(userId).orElse(null);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserById(@RequestBody AppUser user){
        appUserRepository.save(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable UUID userId){
       appUserRepository.deleteById(userId);

        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }

    @GetMapping("/admins")
        public ResponseEntity<?> getAllAdmins(){
            List<AppUser> admins= appUserRepository.getAllAdmins();
            AdminResponseBody response = new AdminResponseBody();

            response.setAdmins(admins);

            return new ResponseEntity<>(response,HttpStatus.OK);
        }

    @GetMapping("/email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){

       AppUser user = appUserRepository.findByEmail(email);

       return new ResponseEntity(user,HttpStatus.OK);
    }



}
