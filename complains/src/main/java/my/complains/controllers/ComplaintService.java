package my.complains.controllers;

import my.complains.domains.Complaint;
import my.complains.domains.Informant;
import my.complains.domains.Violator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@RestController
public class ComplaintService {

    @PostMapping("/complaints")
    public Complaint createComplaint(String description) {
        System.out.println(description);
        return new Complaint(new Informant("0", new Date(), "0", "0"), new Violator("1", new Date(), "1", "1"), "test");
    }

    @GetMapping("/complaints")
    public Collection<Complaint> getComplaints() {
        System.out.println("get complaints");
        return Collections.singletonList(new Complaint(new Informant("0", new Date(), "0", "0"), new Violator("1", new Date(), "1", "1"), "test"));
    }

}
