package lk.ijse.shoemanagementsystem.api;

import lk.ijse.shoemanagementsystem.reqAndresp.response.JwtAuthResponse;
import lk.ijse.shoemanagementsystem.reqAndresp.secure.SignIn;
import lk.ijse.shoemanagementsystem.reqAndresp.secure.SignUp;
import lk.ijse.shoemanagementsystem.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "http://localhost:63342")
@RequiredArgsConstructor
public class UserAPI {
   private final AuthenticationService authenticationService;

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
