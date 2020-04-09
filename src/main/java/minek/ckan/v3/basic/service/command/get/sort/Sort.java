package minek.ckan.v3.basic.service.command.get.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sort {
    private String field;
    private Direction direction;
}