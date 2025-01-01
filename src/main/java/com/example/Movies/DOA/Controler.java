package com.example.Movies.DOA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/movie")
@CrossOrigin(origins = { "*" })
public class Controler {
    @Autowired
    private ServiceMovie srv;
    System.out.println("TEST");
    /*
     * @GetMapping()
     * public ResponseEntity<List<Movie>> index() {
     * System.out.println("TEST");
     * return new ResponseEntity<List<Movie>>(srv.findAllMovies(), HttpStatus.OK);
     * }
     */
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMoviebyimdbId(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(srv.findMoviebyimdbId(imdbId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<MovieRecord>> getMoviebyGenre(@RequestParam(defaultValue = "") String genre) {
        System.out.println(genre);
        return new ResponseEntity<List<MovieRecord>>(srv.findMoviebygenres(genre), HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        srv.save(movie);
        return new ResponseEntity<Movie>(movie, HttpStatus.OK);
    }
}