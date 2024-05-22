package lk.ijse.shoemanagementsystem.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.shoemanagementsystem.util.Mapping;
import lk.ijse.shoemanagementsystem.dao.UserDao;
import lk.ijse.shoemanagementsystem.dto.UserDTO;
import lk.ijse.shoemanagementsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    private final UserDao userRepo;
    private final Mapping map;
    @Override
    public UserDetailsService userDetailsService() {
        return username ->
                userRepo.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void save(UserDTO user) {
        map.toUserDTO(userRepo.save(map.toUserEntity(user)));
    }
}
