package lk.ijse.shoemanagementsystem.service;

import lk.ijse.shoemanagementsystem.reqAndresp.response.JwtAuthResponse;
import lk.ijse.shoemanagementsystem.reqAndresp.secure.SignIn;
import lk.ijse.shoemanagementsystem.reqAndresp.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
}
