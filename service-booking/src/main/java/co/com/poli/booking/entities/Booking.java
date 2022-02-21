package co.com.poli.booking.entities;

import co.com.poli.booking.model.Movie;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(name = "users_id", nullable = false)
    private Long userId;
    @Column(name = "show_times_id", nullable = false)
    private Long showTimeId;
    @Transient
    private List<Movie> movies;
}
