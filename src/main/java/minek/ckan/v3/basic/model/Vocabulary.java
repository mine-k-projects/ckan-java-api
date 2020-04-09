package minek.ckan.v3.basic.model;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Vocabulary {
    private UUID id;
    private String name;
    private List<Tag> tags;
}
