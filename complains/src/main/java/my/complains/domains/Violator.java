package my.complains.domains;

import java.util.Date;

public record Violator(String fullname, Date birthday, String region, String code) {
}
