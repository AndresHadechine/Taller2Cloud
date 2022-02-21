package co.com.poli.showtimes.services;

import co.com.poli.showtimes.client.MovieClient;
import co.com.poli.showtimes.entities.Showtime;
import co.com.poli.showtimes.model.Movie;
import co.com.poli.showtimes.repositories.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService {

    private final ShowtimeRepository showtimeRepository;
    private final MovieClient movieClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Showtime showtime) {
        showtimeRepository.save(showtime);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Showtime showtime) {
        showtimeRepository.delete(showtime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {
        List<Movie> movies = (List<Movie>) movieClient.findAll().getData();
        return showtimeRepository.findAll().stream()
                .map(showtime -> showtime
                        .toBuilder()
                        .movies(movies).build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime findById(Long id) {
        return showtimeRepository.findById(id).orElse(null);
    }
}
