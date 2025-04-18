package com.bms.dbapi.controller;


import com.bms.dbapi.models.AppUser;
import com.bms.dbapi.models.Movie;
import com.bms.dbapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody Movie movie){

        movieRepository.save(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);  // object instantiation, new keyword is used because, ResponseEntity is a class. new keyword is used to create an object from a class

    }

    @GetMapping("/{movieId}")
    public ResponseEntity<?> getUserById(@PathVariable UUID movieId){
        Movie movie = movieRepository.findById(movieId).orElse(null);

        return new ResponseEntity<>(movie,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUserById(@RequestBody Movie movie){
        movieRepository.save(movie);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteUserById(@PathVariable UUID movieId){
        movieRepository.deleteById(movieId);

        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}
