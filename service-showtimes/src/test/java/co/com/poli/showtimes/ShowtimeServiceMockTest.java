package co.com.poli.showtimes;


import co.com.poli.showtimes.entities.Showtime;
import co.com.poli.showtimes.repositories.ShowtimeRepository;
import co.com.poli.showtimes.services.ShowtimeService;
import co.com.poli.showtimes.services.ShowtimeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest
public class ShowtimeServiceMockTest {

    @Mock
    private ShowtimeRepository showtimeRepository;
    private ShowtimeService showtimeService;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.openMocks(this);
        showtimeService = new ShowtimeServiceImpl(showtimeRepository);

        Showtime showtime = Showtime.builder().date(Date.valueOf("2022-02-19")).build();
        Mockito.when(showtimeRepository.findById(1L))
                .thenReturn(Optional.of(showtime));
    }

    @Test
    public void when_findById_return_user(){
        Showtime showtime = showtimeService.findById(1L);
        Assertions.assertThat(showtime.getDate()).isEqualTo("2022-02-19");
    }
}