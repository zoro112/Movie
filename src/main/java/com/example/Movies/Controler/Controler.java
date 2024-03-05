package com.example.Movies.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.Movies.DOA.Movie;
import com.example.Movies.DOA.ServiceMovie;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/movie")
public class Controler {
    @Autowired
    private ServiceMovie srv;

    @GetMapping()
    public ResponseEntity<List<Movie>> index() {
        System.out.println("cccc");
        return new ResponseEntity<List<Movie>>(srv.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMoviebyimdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(srv.findMoviebyimdbId(imdbId), HttpStatus.OK);
    }
}