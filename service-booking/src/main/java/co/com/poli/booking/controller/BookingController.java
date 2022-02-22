package co.com.poli.booking.controller;

import co.com.poli.booking.entities.Booking;
import co.com.poli.booking.helpers.Response;
import co.com.poli.booking.helpers.ResponseBuilder;
import co.com.poli.booking.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResponseBuilder builder;

    @GetMapping
    public Response findAll(){
        List<Booking> bookings = bookingService.findAll();
        if(bookings.isEmpty()){
            return builder.failed("Bookings is Empty");
        }
        return builder.success(bookings);
    }

    @PostMapping
    public Response save (@RequestBody Booking booking){
        bookingService.save(booking);
        return builder.success();
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        Booking booking = bookingService.findById(id);
        if(booking == null){
            return builder.failed("Not Found");
        }
        return builder.success(booking);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Booking booking = bookingService.findById(id);
        if (booking == null){
            return builder.failed("Not Found");
        }
        bookingService.delete(booking);
        return builder.success(booking);
    }

    @GetMapping("/idUser/{idUser}")
    public Response findByIdUser(@PathVariable("idUser") Long idUser){
        Booking booking = bookingService.findByUserId(idUser);
        if(booking == null){
            return builder.failed("Not Found");
        }
        return builder.success(booking);
    }
}
