package minek.ckan.v3.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class Sort<E extends Enum<?>> {
    private E field;
    private Sort.Direction direction;

    public enum Direction {
        asc, desc
    }

    public static <E extends Enum<?>> Sort<E> of(@NonNull E field, @NonNull Sort.Direction direction) {
        return new Sort<>(field, direction);
    }

    public static <E extends Enum<?>> Sort<E> asc(@NonNull E field) {
        return new Sort<>(field, Direction.asc);
    }

    public static <E extends Enum<?>> Sort<E> desc(@NonNull E field) {
        return new Sort<>(field, Direction.desc);
    }
}
