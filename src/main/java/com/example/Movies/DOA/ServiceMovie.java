package com.example.Movies.DOA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceMovie {
    private MovieRep movieR;

    public ServiceMovie(MovieRep movieR) {
        this.movieR = movieR;

    }

    public List<Movie> findAllMovies() {
        return movieR.findAll();
    }

    public Optional<Movie> findMoviebyimdbId(String imdbId) {
        // TODO Auto-generated method stub
        return movieR.findMovieByImdbId(imdbId);
    }

    public Movie save(Movie movie) {
        // TODO Auto-generated method stub
        return movieR.save(movie);
    }

    public List<MovieRecord> findMoviebygenres(String genre) {
        // TODO Auto-generated method stub
        return movieR.findByStatusIncludeItemAndStatusFields(genre);
    }

}
