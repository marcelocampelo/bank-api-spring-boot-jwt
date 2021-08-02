package br.com.bank.restapispringboot.models;

import br.com.bank.restapispringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String jwttoken;

    private final String email;

    private final String name;




    public JwtResponse(String jwttoken, String email, String name) {

        this.name = name;
        this.email = email;
        this.jwttoken = jwttoken;

    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }
}
