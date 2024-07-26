//package com.example.expensetracker.controller;
//
//import com.example.expensetracker.config.JwtTokenUtil;
//import com.example.expensetracker.model.User;
//import com.example.expensetracker.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/users")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping("/authenticate")
//    public Map<String, String> authenticate(@RequestBody User user) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//            );
//        } catch (AuthenticationException e) {
//            throw new UsernameNotFoundException("Invalid username or password");
//        }
//
//        final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
//        final String jwtToken = jwtTokenUtil.generateToken(userDetails.getUsername());
//
//        Map<String, String> response = new HashMap<>();
//        response.put("token", jwtToken);
//        return response;
//    }
//}
