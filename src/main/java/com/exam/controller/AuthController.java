package com.exam.controller;

import com.exam.config.JwtHelper;
import com.exam.models.JwtRequest;
import com.exam.models.JwtResponse;
import com.exam.models.User;
import com.exam.services.impl.UserDetailServiceImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private UserDetailServiceImpl userDetailServiceImpl;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/generate-token")
    public ResponseEntity<JwtResponse> getToken(@RequestBody JwtRequest request){

        this.doAuthenticate(request.getUsername(),request.getPassword());

        UserDetails userDetails = this.userDetailServiceImpl.loadUserByUsername(request.getUsername());
        String token = this.helper.generateToken(userDetails);


        return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);

    }


    private void doAuthenticate(String username,String password){
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,password);

        try{
            manager.authenticate(authentication);
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Invalid Username or Password !!");
        }
    }
    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal){
        return (User) this.userDetailServiceImpl.loadUserByUsername(principal.getName());
    }

}
