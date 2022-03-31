package consultation.by.video.call.auth.controller;

import consultation.by.video.call.auth.entity.User;
import consultation.by.video.call.auth.request.UserAuthenticatedRequest;
import consultation.by.video.call.auth.request.UserRegisterRequest;
import consultation.by.video.call.auth.response.UserAuthenticatedResponse;
import consultation.by.video.call.auth.response.UserRegisterResponse;
import consultation.by.video.call.auth.service.abstraction.IAuthenticationService;
import consultation.by.video.call.auth.service.abstraction.IRegisterUserService;
import consultation.by.video.call.auth.service.abstraction.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@Api(value = "Authentication controller", description = "This API has a Authenticated for users")
public class AuthenticationController {

    @Autowired
    private IRegisterUserService registerUserService;
//
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;
//
    @PostMapping("/register")
    @ApiOperation(value = "Register user", notes = "Return a user register" )
    public ResponseEntity<UserRegisterResponse> register(@Valid @RequestBody UserRegisterRequest request) {
        UserRegisterResponse userRegisterResponse = registerUserService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userRegisterResponse);
    }
//
    @PostMapping("/login")
    @ApiOperation(value = "Login user", notes = "Return email, role and token" )
    public ResponseEntity<UserAuthenticatedResponse> login(@Valid @RequestBody UserAuthenticatedRequest request){
        UserAuthenticatedResponse response = authenticationService.authentication(request);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/me")
    @ApiOperation(value = "Get infoUser", notes = "Return info User logged")
    public ResponseEntity<User> userLogged() throws NotFoundException{
        return new ResponseEntity<>(userService.getInfoUser(), HttpStatus.OK);
    }
}
