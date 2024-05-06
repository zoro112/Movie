
package com.example.Movies.DOA;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface MovieRep extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> findMovieByImdbId(String imdbId);

    @Query(value = "{'genres': {$regex : ?0, $options: 'i'}}")
    List<Movie> findMovieByGenresContaining(String genre);

    @Query(value = "{'genres': {$regex : ?0, $options: 'i'}}", fields = "{ 'title' : 1, 'imdbId' : 1,'poster':1 }")
    List<MovieRecord> findByStatusIncludeItemAndStatusFields(String genre);
}