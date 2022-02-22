package co.com.poli.users.controller;

import co.com.poli.users.entities.User;
import co.com.poli.users.helpers.Response;
import co.com.poli.users.helpers.ResponseBuilder;
import co.com.poli.users.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuilder builder;

    @PostMapping
    public Response save(@RequestBody User user){
        userService.save(user);
        return builder.success(user);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if(user == null){
            return builder.failed("Not Found");
        }
        userService.delete(user);
        return builder.success(user);
    }

    @GetMapping
    public Response findAll(){
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return builder.failed("Users is Empty");
        }
        return builder.success(users);
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id){
        User user = userService.findById(id);
        if(user == null){
            return builder.failed("Not Found");
        }
        return builder.success(user);
    }
}
