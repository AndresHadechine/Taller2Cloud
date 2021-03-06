package co.com.poli.showtimes.entities;

import co.com.poli.showtimes.model.Movie;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "showtimes")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @Column(name = "date", nullable = false)
    private Date date;
    @Transient
    private List<Movie> movies;
}
