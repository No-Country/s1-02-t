package consultation.by.video.call.auth.controller;

import consultation.by.video.call.auth.entity.User;
import consultation.by.video.call.auth.response.UserResponse;
import consultation.by.video.call.auth.service.abstraction.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
@Api(value = "User Controller", description = "Crud basic for users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/me")
    @ApiOperation(value = "Get info user", notes = "Return a user info")
    public ResponseEntity<UserResponse> getMyUser() throws NotFoundException {
        User userInstance = (User) userService.getInfoUser();
        UserResponse response = userService.getById(userInstance.getId());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
