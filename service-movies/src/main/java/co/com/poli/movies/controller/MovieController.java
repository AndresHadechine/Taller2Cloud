package co.com.poli.movies.controller;

import co.com.poli.movies.entities.Movie;
import co.com.poli.movies.helpers.Response;
import co.com.poli.movies.helpers.ResponseBuilder;
import co.com.poli.movies.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuilder builder;

    @GetMapping
    public Response findAll(){
        List<Movie> movies = movieService.findAll();
        if(movies.isEmpty()){
            return builder.failed("Movies is Empty");
        }
        return builder.success(movies);
    }

    @PostMapping
    public Response save (@RequestBody Movie movie){
        movieService.save(movie);
        return builder.success();
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Movie movie = movieService.findById(id);
        if(movie == null){
            return builder.failed("Not Found");
        }
        return builder.success(movie);
    }




}
