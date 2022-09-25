package com.example.jpatwodb.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JWTService {

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    public String genToken(AuthRequest authRequest) {
        //取帳號密碼驗證
        Authentication authentication =
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPw());
        authentication = authenticationManager.authenticate(authentication);
        //取UserDetails中的username加密
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtil.sign(userDetails.getUsername());
    }

    public Map<String, Object> parseToken(String token) {
        return jwtUtil.verify(token);
    }

}
