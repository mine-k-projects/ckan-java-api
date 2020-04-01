package minek.ckan.v3.model;

import lombok.Data;

import java.util.UUID;

@Data
public class UserAutocomplete {
    private String fullname;
    private UUID id;
    private String name;
}
