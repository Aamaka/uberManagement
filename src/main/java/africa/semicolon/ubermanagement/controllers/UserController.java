package africa.semicolon.ubermanagement.controllers;

import africa.semicolon.ubermanagement.dtos.requests.BookUserRequest;
import africa.semicolon.ubermanagement.dtos.requests.CreateUserRequest;
import africa.semicolon.ubermanagement.dtos.requests.LoginUserRequest;
import africa.semicolon.ubermanagement.dtos.responses.BookUserResponse;
import africa.semicolon.ubermanagement.dtos.responses.CreateUserResponse;
import africa.semicolon.ubermanagement.dtos.responses.LoginUserResponse;
import africa.semicolon.ubermanagement.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/uber")
public class UserController {
    private  final UserServices services;

    @PostMapping("/createUser")
    public CreateUserResponse createUser(@RequestBody CreateUserRequest request){
        return services.createUser(request);
    }

    @GetMapping("/login")
    public LoginUserResponse login(@RequestBody LoginUserRequest request){
        return services.login(request);
    }

    @PostMapping("/book")
    public BookUserResponse book (@RequestBody BookUserRequest request){
        return services.book(request);
    }
}
