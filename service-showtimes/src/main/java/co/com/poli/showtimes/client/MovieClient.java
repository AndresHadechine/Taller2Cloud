package co.com.poli.showtimes.client;

import co.com.poli.showtimes.helpers.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-movie")
public interface MovieClient {

    @GetMapping("/multi/v1/movies")
    Response findAll();
}