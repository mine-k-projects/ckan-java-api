package minek.ckan.v3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.model.enums.Capacity;
import minek.ckan.v3.model.enums.ObjectType;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Member {
    private UUID id;
    private ObjectType type;
    private Capacity capacity;
}
