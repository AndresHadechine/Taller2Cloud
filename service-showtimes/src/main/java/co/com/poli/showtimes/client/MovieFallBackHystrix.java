package co.com.poli.showtimes.client;

import co.com.poli.showtimes.helpers.Response;
import co.com.poli.showtimes.helpers.ResponseBuilder;
import co.com.poli.showtimes.model.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovieFallBackHystrix implements MovieClient{

    private final ResponseBuilder builder;

    @Override
    public Response findAll() {
        return builder.success(new Movie());
    }

}