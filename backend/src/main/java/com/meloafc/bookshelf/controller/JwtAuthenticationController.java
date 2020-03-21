package com.meloafc.bookshelf.controller;

import com.meloafc.bookshelf.config.JwtTokenUtil;
import com.meloafc.bookshelf.dto.JwtRequestDTO;
import com.meloafc.bookshelf.dto.JwtResponseDTO;
import com.meloafc.bookshelf.dto.UserDTO;
import com.meloafc.bookshelf.mapper.UserMapper;
import com.meloafc.bookshelf.model.User;
import com.meloafc.bookshelf.service.JwtUserDetailsService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private UserMapper userMapper;

    public JwtAuthenticationController() {
        setUserMapper(new UserMapper());
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDTO requestDTO) throws Exception {

        authenticate(requestDTO.getEmail(), requestDTO.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(requestDTO.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(JwtResponseDTO.builder()
                .email(requestDTO.getEmail())
                .token(token)
                .build());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) throws Exception {
        User user = getUserMapper().convertToEntity(userDTO);
        return ResponseEntity.ok(getUserMapper().convertToDTO(userDetailsService.add(user)));
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
