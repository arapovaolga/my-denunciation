package my.complains.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import my.complains.domains.Complaint;
import my.complains.domains.Informant;
import my.complains.domains.Violator;
import my.complains.enums.ComplaintStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
public class ComplaintService {

    @PostMapping("/complaints")
    public List<Complaint> createComplaint(String description) {
        System.out.println(description);
        return Collections.singletonList(new Complaint(new Informant("0", new Date(), "0", "0"), new Violator("1", new Date(), "1", "1"), "test", ComplaintStatus.TO_DO));
    }

    @GetMapping("/complaints/{complaintId}")
    public Collection<Complaint> getComplaints(@PathVariable String complaintId) {
        System.out.println("get complaints");
        return Collections.singletonList(new Complaint(new Informant("0", new Date(), "0", "0"), new Violator("1", new Date(), "1", "1"), "test", ComplaintStatus.TO_DO));
    }

}
