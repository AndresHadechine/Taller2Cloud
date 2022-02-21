package co.com.poli.booking.client;

import co.com.poli.booking.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "service-movies",fallback = MovieFallBackHystrix.class)
@FeignClient(name = "service-movie")
public interface MovieClient {

    @GetMapping("/multi/v1/movies")
    Response findAll();
}
