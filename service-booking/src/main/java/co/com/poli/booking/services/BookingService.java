package co.com.poli.booking.services;

import co.com.poli.booking.entities.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> findAll();
    void save(Booking booking);
    Booking findById(Long id);
    void delete(Booking booking);
    Booking findByUserId(Long userId);
}
