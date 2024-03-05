package com.example.Movies.DOA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceMovie {
    @Autowired
    private MovieRep movieR;

    public List<Movie> findAllMovies() {
        return movieR.findAll();
    }

    public Optional<Movie> findMoviebyimdbId(String imdbId) {
        // TODO Auto-generated method stub
        return movieR.findMovieByImdbId(imdbId);
    }

}
