package com.project.gestion_examens.security;

import com.project.gestion_examens.entities.User;
import com.project.gestion_examens.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not " +
                "found " +
                "with email: " + email));
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        List<String> permissions = user.getRole().getAllPermissions();
        permissions.forEach(permission -> authorities.add(new SimpleGrantedAuthority("ROLE_"  + permission)));
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), authorities);
    }
}
