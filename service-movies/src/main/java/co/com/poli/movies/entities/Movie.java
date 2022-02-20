package co.com.poli.movies.entities;

import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;
    @NotEmpty(message = "El titulo no debe ser vacio")
    @Column(name = "title")
    private String title;
    @NotEmpty(message = "El director no debe ser vacio")
    @Column(name = "director")
    private String director;
    //Rango de 1 - 5
    @Column(name = "rating")
    private int rating;
}
