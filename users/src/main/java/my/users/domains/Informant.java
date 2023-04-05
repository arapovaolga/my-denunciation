package my.users.domains;

import java.util.Date;

public record Informant(String fullname, Date birthday, String region, String code) {
}
