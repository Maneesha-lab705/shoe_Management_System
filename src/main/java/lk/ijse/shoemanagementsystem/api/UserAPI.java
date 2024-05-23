package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.dto.UserDTO;
import lk.ijse.shoemanagementsystem.reqAndresp.response.JwtAuthResponse;
import lk.ijse.shoemanagementsystem.reqAndresp.secure.SignIn;
import lk.ijse.shoemanagementsystem.reqAndresp.secure.SignUp;
import lk.ijse.shoemanagementsystem.service.AuthenticationService;
import lk.ijse.shoemanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class UserAPI {
   private final AuthenticationService authenticationService;

   private final UserService userService;
    @GetMapping("/getUser")
    List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }

    //signup
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
       return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }
    //signIn
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }
}
