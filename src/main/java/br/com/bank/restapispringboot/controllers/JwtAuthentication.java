package br.com.bank.restapispringboot.controllers;

import br.com.bank.restapispringboot.jwtconfig.JwtTokenUtil;
import br.com.bank.restapispringboot.models.JwtRequest;
import br.com.bank.restapispringboot.models.JwtResponse;
import br.com.bank.restapispringboot.models.Person;
import br.com.bank.restapispringboot.repositories.PersonRepository;
import br.com.bank.restapispringboot.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class JwtAuthentication {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        final String email = authenticationRequest.getEmail();

        authenticate(email, authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(email);

        final String token = jwtTokenUtil.generateToken(userDetails);

        //fix later the fact that the database is being queried two times, one for the name and the other for email.
        final String name = userDetailsService.nameByUsername(email);

        return ResponseEntity.ok(new JwtResponse(token, email, name));
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody Person user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}