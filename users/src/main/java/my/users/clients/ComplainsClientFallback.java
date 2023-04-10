package my.users.clients;

import my.users.domains.Complaint;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ComplainsClientFallback implements ComplainsClient {

    @Override
    public List<Complaint> createComplaint(String description) {
        System.out.println("!!!fallback!!!");
        return Collections.emptyList();
    }

}
