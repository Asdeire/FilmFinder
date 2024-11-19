package com.asdeire.film_finder.controller;

import com.asdeire.film_finder.dto.MovieInfo;
import com.asdeire.film_finder.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/search")
    public String searchMovie(@RequestParam String title, Model model) {
        MovieInfo movieInfo = movieService.getMovieInfo(title); // Change here to MovieInfo

        if (movieInfo != null) {
            model.addAttribute("movieInfo", movieInfo); // Pass the MovieInfo object to the model
        } else {
            model.addAttribute("error", "Movie not found or invalid title.");
        }
        return "result";
    }


}
