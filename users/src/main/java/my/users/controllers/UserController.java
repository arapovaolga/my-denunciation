package my.users.controllers;

import my.users.domains.Informant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class UserController {

    @PostMapping
    public Informant getUser() {
        return new Informant("fullname", new Date(), "re", "1");
    }

}
