package co.com.poli.showtimes.controller;


import co.com.poli.showtimes.entities.Showtime;
import co.com.poli.showtimes.helpers.Response;
import co.com.poli.showtimes.helpers.ResponseBuilder;
import co.com.poli.showtimes.services.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@RequestBody Showtime showtime){
        showtimeService.save(showtime);
        return builder.success(showtime);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Showtime showtime = showtimeService.findById(id);
        if(showtime == null){
            return builder.failed("Not Found");
        }
        showtimeService.delete(showtime);
        return builder.success(showtime);
    }

    @GetMapping
    public Response findAll(){
        List<Showtime> showtime = showtimeService.findAll();
        if(showtime.isEmpty()){
            return builder.failed("Users is Empty");
        }
        return builder.success(showtime);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Showtime showtime = showtimeService.findById(id);
        if(showtime == null){
            return builder.failed("Not Found");
        }
        return builder.success(showtime);
    }
}
