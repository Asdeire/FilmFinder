package com.asdeire.film_finder.controller;

import com.asdeire.film_finder.dto.MovieInfo;
import com.asdeire.film_finder.service.EmailService;
import com.asdeire.film_finder.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MovieController {

    private final MovieService movieService;
    private final EmailService emailService;

    public MovieController(MovieService movieService, EmailService emailService) {
        this.movieService = movieService;
        this.emailService = emailService;
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

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String recipient, @RequestParam String subject, @RequestParam String message, Model model) {
        if (recipient == null || subject == null || message == null) {
            model.addAttribute("error", "All fields are required.");
            return "result";
        }
        try {
            emailService.sendEmail(recipient, subject, message);
            model.addAttribute("success", "Email sent successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to send email: " + e.getMessage());
            return "result";
        }

        return "index";
    }
}
