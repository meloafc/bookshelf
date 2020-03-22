package com.meloafc.bookshelf.service;

import com.meloafc.bookshelf.exception.InvalidValueException;
import com.meloafc.bookshelf.model.User;
import com.meloafc.bookshelf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService extends GenericService<User, Long> implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

    @Override
    public User add(User entity) {
        entity.setPassword(bcryptEncoder.encode(entity.getPassword()));
        return super.add(entity);
    }

    @Override
    public void validate(User entity) {
        if(userRepository.existsByEmail(entity.getEmail())) {
            throw new InvalidValueException("email unavailable: " + entity.getEmail());
        }
        super.validate(entity);
    }

    public String getLoggedEmail() {
        return ((org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    public User getLoggedUser() {
        User user = userRepository.findByEmail(getLoggedEmail());
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + getLoggedEmail());
        }
        return user;
    }
}
