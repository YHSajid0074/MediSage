package com.example.MediSage.config.security;

import com.example.MediSage.auth.CustomUserDetails;
import com.example.MediSage.auth.model.User;
import com.example.MediSage.auth.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepository;
    public CustomUserDetailsService(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepository.findByUsernameOrEmail(username.strip(), username.strip());
        if (Objects.isNull(foundUser)) {
            throw new UsernameNotFoundException(username);
        }

        Set<String> grantedAuthorities = foundUser
                .getRoles()
                .stream()
                .map(e -> "ROLE_" + e.getRoleType())
                .collect(Collectors.toSet());

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setId(foundUser.getId());
        customUserDetails.setUsername(foundUser.getUsername());
        customUserDetails.setPassword(foundUser.getPassword());
        customUserDetails.setEmail(foundUser.getEmail());
        customUserDetails.setRoles(grantedAuthorities);

        return customUserDetails;
    }
}
