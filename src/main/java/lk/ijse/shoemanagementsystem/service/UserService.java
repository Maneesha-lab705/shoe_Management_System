package lk.ijse.shoemanagementsystem.service;

import lk.ijse.shoemanagementsystem.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    void save(UserDTO user);
}
