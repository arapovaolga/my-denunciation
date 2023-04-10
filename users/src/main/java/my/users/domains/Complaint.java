package my.users.domains;

import my.users.enums.ComplaintStatus;

public record Complaint(Informant informant, Violator violator, String denunciation, ComplaintStatus status) {

}
