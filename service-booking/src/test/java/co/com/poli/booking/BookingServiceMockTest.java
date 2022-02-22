package co.com.poli.booking;

import co.com.poli.booking.entities.Booking;
import co.com.poli.booking.model.Movie;
import co.com.poli.booking.repositories.BookingRepository;
import co.com.poli.booking.services.BookingService;
import co.com.poli.booking.services.BookingServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BookingServiceMockTest {

    @Mock
    private BookingRepository bookingRepository;
    private BookingService bookingService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.openMocks(this);
        bookingService = new BookingServiceImpl(bookingRepository);

        Booking booking = Booking.builder()
                .id(10L)
                .userId(700L)
                .showTimeId(333L)
                .movies(Movie(8L, "Los simpson", "Matt_Groening",5 ))
                .build();
        Mockito.when(bookingRepository.findById(10L))
                .thenReturn(Optional.of(booking));
    }
    @Test
    public void when_findById_return_booking(){
        Booking booking = bookingService.findById(10L);
        Assertions.assertThat(booking.getUserId()).isEqualTo(700L);
    }
}
