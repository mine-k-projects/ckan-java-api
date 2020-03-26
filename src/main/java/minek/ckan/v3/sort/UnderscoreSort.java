package minek.ckan.v3.sort;

import lombok.NonNull;

public class UnderscoreSort<E extends Enum<?>> extends Sort<E> {

    public UnderscoreSort(E field, Direction direction) {
        super(field, direction);
    }

    @Override
    public String separate() {
        return "_";
    }

    public static <E extends Enum<?>> UnderscoreSort<E> of(@NonNull E field, @NonNull Direction direction) {
        return new UnderscoreSort<>(field, direction);
    }
}
