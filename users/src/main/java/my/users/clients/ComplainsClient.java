package my.users.clients;

import my.users.domains.Complaint;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "complains", fallback = ComplainsClientFallback.class)
public interface ComplainsClient {

    @RequestMapping(method = RequestMethod.POST, value = "/complaints")
    List<Complaint> createComplaint(String description);

}
