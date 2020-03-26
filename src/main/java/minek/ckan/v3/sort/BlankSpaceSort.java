package minek.ckan.v3.sort;

import lombok.NonNull;

public class BlankSpaceSort<E extends Enum<?>> extends Sort<E> {

    public BlankSpaceSort(E field, Direction direction) {
        super(field, direction);
    }

    @Override
    public String separate() {
        return " ";
    }

    public static <E extends Enum<?>> BlankSpaceSort<E> of(@NonNull E field, @NonNull Direction direction) {
        return new BlankSpaceSort<>(field, direction);
    }
}
