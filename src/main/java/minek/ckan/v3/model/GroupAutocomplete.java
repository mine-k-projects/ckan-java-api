package minek.ckan.v3.model;

import lombok.Data;

import java.util.UUID;

@Data
public class GroupAutocomplete {
    private String title;
    private UUID id;
    private String name;
}
