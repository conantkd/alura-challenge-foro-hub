package com.alurachallenges.forohub.controllers;

import com.alurachallenges.forohub.dto.user.AuthUserData;
import com.alurachallenges.forohub.dto.JWTDatos;
import com.alurachallenges.forohub.models.User;
import com.alurachallenges.forohub.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AuthController
{

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(
            @Valid
            @RequestBody
            AuthUserData authUserData
    )
    {
        Authentication authToken = new UsernamePasswordAuthenticationToken(authUserData.username(),authUserData.password());

        var authUser = authManager.authenticate(authToken);
        var jwt = tokenService.generateToken((User) authUser.getPrincipal());

        Object responseBody = new Object() {
            public final int httpStatus = HttpStatus.OK.value();
            public final JWTDatos jwtData = new JWTDatos(jwt);
        };

        return ResponseEntity.ok().body(responseBody);
    }
}
