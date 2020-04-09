package minek.ckan.v3.basic.service.command.create;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserCreate {
    private String name;
    private String email;
    private String password;
    private UUID id;
    private String fullname;
    private String about;
}
