package com.trabajo.curso.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trabajo.curso.exception.UsuarioNotFoundException;
import com.trabajo.curso.model.Usuario;
import com.trabajo.curso.security.jwt.JwtRequest;
import com.trabajo.curso.security.jwt.JwtResponse;
import com.trabajo.curso.security.jwt.JwtUtil;
import com.trabajo.curso.service.impl.UserDetailsServiceImpl;


@RestController
@CrossOrigin("*") // Para evitar problemas de CORS
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;
    private final JwtUtil jwtUtils;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService, JwtUtil jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/generar-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        try{
            autenticar(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch (UsuarioNotFoundException exception){
            exception.printStackTrace();
            throw new Exception("Error en el username o password");
        }

        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void autenticar(String username, String password) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException disabledException){
            throw new Exception("USER_DISABLED: "+ disabledException.getMessage());
        }catch (BadCredentialsException badCredentialsException){
            throw new Exception("INVALID_CREDENTIALS: "+ badCredentialsException.getMessage());
        }

    }

    @GetMapping("/actual")
    public Usuario obtenerUsuarioActual(Principal principal){
        return (Usuario) this.userDetailsService.loadUserByUsername(principal.getName());
    }

}
