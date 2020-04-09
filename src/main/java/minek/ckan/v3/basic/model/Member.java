package minek.ckan.v3.basic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.basic.model.enums.Capacity;
import minek.ckan.v3.basic.model.enums.ObjectType;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Member {
    private UUID id;
    private ObjectType type;
    private Capacity capacity;
}
