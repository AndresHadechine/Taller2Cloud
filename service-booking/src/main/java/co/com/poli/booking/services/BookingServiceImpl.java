package co.com.poli.booking.services;

import co.com.poli.booking.client.MovieClient;
import co.com.poli.booking.entities.Booking;
import co.com.poli.booking.model.Movie;
import co.com.poli.booking.repositories.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;
    private final MovieClient movieClient;

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        List<Movie> movies = (List<Movie>) movieClient.findAll().getData();

//        List<Movie> movies = new ArrayList<>();
//        Movie movie = new Movie(7L,"El rey escorpión","Moga Ricachón", 3);
//        Movie movie2 = new Movie(14L,"La patada del Mocho","Moga Ricachón Junior", 4);
//        movies.add(movie);
//        movies.add(movie2);

        return bookingRepository.findAll()
                .stream()
                .map(booking -> booking
                        .toBuilder()
                        .movies(movies).build())
                .collect(Collectors.toList());

    }

    @Override
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    public Booking findById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }

    @Override
    public Booking findByUserId(Long userId) {
        //Mejorar (El codigo lo hizo Marycarmen)
        List<Booking> bookings = bookingRepository.findAll();
        List<Booking> booking = bookings.stream().filter(booking1 -> Objects.equals(booking1.getUserId(), userId)).collect(Collectors.toList());
        return bookingRepository.findById(booking.get(0).getId()).orElse(null);
    }
}
