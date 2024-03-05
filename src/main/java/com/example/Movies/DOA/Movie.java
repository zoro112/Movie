package com.example.Movies.DOA;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Indicates that this class represents a MongoDB document and specifies the collection name
@Document(collection = "Movies")
// Lombok annotations for generating getters, setters, toString(), equals(), and
// hashCode() methods
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    // MongoDB's ObjectId as the identifier for this document
    @Id
    private ObjectId id;
    // IMDB ID of the movie
    private String imdbId;
    // Title of the movie
    private String title;
    // Release date of the movie
    private String releaseDate;
    // Link to the movie trailer
    private String trailerLink;
    // Link to the movie poster
    private String poster;
    // List of links to backdrops of the movie
    private List<String> backdrops;
    // List of genres the movie belongs to
    private List<String> genres;
    // List of reviews associated with the movie (using DocumentReference to another
    // collection)
    @DocumentReference
    private List<Review> reviews;

    // Constructor for creating a Movie object without ObjectId
    public Movie(String imdbId, String title, String releaseDate, String trailerLink, String poster,
            List<String> backdrops, List<String> genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.backdrops = backdrops;
        this.genres = genres;
    }
}
