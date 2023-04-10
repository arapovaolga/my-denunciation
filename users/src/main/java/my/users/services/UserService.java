package my.users.services;

import jakarta.annotation.PostConstruct;
import my.users.clients.ComplainsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Qualifier("my.users.clients.ComplainsClient")
    @Autowired
    private ComplainsClient complainsClient;

    @PostConstruct
    public void init() {
        complainsClient.createComplaint("String description");
    }
}
