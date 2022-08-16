package africa.semicolon.ubermanagement.controllers;

import africa.semicolon.ubermanagement.dtos.requests.CreateUserRequest;
import africa.semicolon.ubermanagement.dtos.responses.CreateUserResponse;
import africa.semicolon.ubermanagement.services.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/uber")
public class UserController {
    private  final UserServices services;

    @PostMapping("/createUser")
    public CreateUserResponse createUser(CreateUserRequest request){
        return services.createUser(request);
    }
}
