package com.asdeire.film_finder.service;

import com.asdeire.film_finder.dto.MovieInfo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieService {

    @Value("${omdb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public MovieInfo getMovieInfo(String title) {
        String url = UriComponentsBuilder.fromHttpUrl("http://www.omdbapi.com/")
                .queryParam("t", title)
                .queryParam("apikey", apiKey)
                .toUriString();

        JsonNode response = restTemplate.getForObject(url, JsonNode.class);

        if (response != null && response.has("Error")) {
            return null; // Movie not found or some error occurred
        }

        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setTitle(response.get("Title").asText());
        movieInfo.setYear(response.get("Year").asText());
        movieInfo.setGenre(response.get("Genre").asText());
        movieInfo.setRating(response.get("imdbRating").asText());
        movieInfo.setDirector(response.get("Director").asText());
        movieInfo.setActors(response.get("Actors").asText());
        movieInfo.setPlot(response.get("Plot").asText());
        movieInfo.setPosterUrl(response.get("Poster").asText());
        movieInfo.setImdbId(response.get("imdbID").asText());

        return movieInfo;
    }

}

