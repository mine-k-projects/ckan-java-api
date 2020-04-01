package minek.ckan.v3.service.command.criteria.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Sort<E extends Enum<?>> {
    protected E field;
    protected Direction direction;

    public abstract String separate();

    public enum Direction {
        asc, desc
    }
}
