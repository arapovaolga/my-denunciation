package my.complains.domains;

import my.complains.enums.ComplaintStatus;

public record Complaint(Informant informant, Violator violator, String denunciation, ComplaintStatus status) {

}
