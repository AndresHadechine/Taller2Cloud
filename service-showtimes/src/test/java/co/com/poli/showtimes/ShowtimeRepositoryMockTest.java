package co.com.poli.showtimes;

import co.com.poli.showtimes.entities.Showtime;
import co.com.poli.showtimes.repositories.ShowtimeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.util.List;

@DataJpaTest
public class ShowtimeRepositoryMockTest {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Test
    public void when_findAll_return_ListShowtimes(){
        Showtime showtime = Showtime.builder()
                .date(Date.valueOf("2024-12-22"))
                .build();
        showtimeRepository.save(showtime);
        List<Showtime> users = showtimeRepository.findAll();
        Assertions.assertThat(users.size()).isEqualTo(4);
    }
}
