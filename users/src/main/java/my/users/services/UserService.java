package my.users.services;

import my.users.aspects.Loggable;
import my.users.clients.ComplainsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Qualifier("my.users.clients.ComplainsClient")
    @Autowired
    private ComplainsClient complainsClient;

    @Loggable
    @Scheduled(fixedDelay = 1000)
    public void init() {
        System.out.println("init schedule");
        complainsClient.createComplaint("String description");
//        System.out.println(getInformant());
    }

//    @HystrixCommand(fallbackMethod = "defaultUser")
//    public Informant getInformant() throws RuntimeException {
//        if (true) {
//            throw new RuntimeException();
//        }
//        return new Informant("???", new Date(), "???", "???");
//    }
//
//    public Informant defaultUser() {
//        return new Informant("Anonymous", new Date(), "unknown", "-1");
//    }

}
