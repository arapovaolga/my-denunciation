package my.users.clients;

import my.users.domains.Complaint;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("Complaints")
public interface ComplaintsClient {
    @RequestMapping("/complaints")
    Complaint createComplaint();
}
