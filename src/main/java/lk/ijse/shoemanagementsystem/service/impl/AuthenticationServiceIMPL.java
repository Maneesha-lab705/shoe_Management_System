package lk.ijse.shoemanagementsystem.service.impl;

import lk.ijse.shoemanagementsystem.util.Mapping;
import lk.ijse.shoemanagementsystem.dao.UserDao;
import lk.ijse.shoemanagementsystem.dto.UserDTO;
import lk.ijse.shoemanagementsystem.enums.Role;
import lk.ijse.shoemanagementsystem.reqAndresp.response.JwtAuthResponse;
import lk.ijse.shoemanagementsystem.reqAndresp.secure.SignIn;
import lk.ijse.shoemanagementsystem.reqAndresp.secure.SignUp;
import lk.ijse.shoemanagementsystem.service.AuthenticationService;
import lk.ijse.shoemanagementsystem.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserDao userRepo;
    private final JWTService jwtService;
    private final Mapping mapping;
    //utils
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        var userByEmail = userRepo.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
       var generatedToken = jwtService.generateToken(userByEmail);
       return JwtAuthResponse.builder().token(generatedToken).build() ;
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        var buildUser = UserDTO.builder()
                .id(UUID.randomUUID().toString())
                .employeeId(signUp.getEmployeeId())
                .email(signUp.getEmail())
                .name(signUp.getName())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(Role.valueOf(signUp.getRole()))
                .build();
        var savedUser = userRepo.save(mapping.toUserEntity(buildUser));
        var genToken = jwtService.generateToken(savedUser);
        return JwtAuthResponse.builder().token(genToken).build();
    }
}
