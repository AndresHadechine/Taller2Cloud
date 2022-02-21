package co.com.poli.booking.client;

import co.com.poli.booking.helpers.Response;
import co.com.poli.booking.helpers.ResponseBuilder;
import co.com.poli.booking.model.Movie;
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