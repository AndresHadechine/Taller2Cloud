package co.com.poli.booking;

import co.com.poli.booking.entities.Booking;
import co.com.poli.booking.repositories.BookingRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class BookingRepositoryMockTest {

    @Autowired
    private BookingRepository bookingRepository;

    @Test
    public void when_findAll_return_listBookings(){
        Booking booking = Booking.builder()
                .userId(800L)
                .showTimeId(900L)
                .build();

        bookingRepository.save(booking);
        List<Booking> bookings = bookingRepository.findAll();
        Assertions.assertThat(bookings.size()).isEqualTo(4);
    }

}
