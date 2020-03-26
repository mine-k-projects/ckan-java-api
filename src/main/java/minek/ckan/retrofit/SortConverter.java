package minek.ckan.retrofit;

import minek.ckan.v3.sort.Sort;
import retrofit2.Converter;

import java.io.IOException;

class SortConverter implements Converter<Sort<?>, String> {

    @Override
    public String convert(Sort<?> value) throws IOException {
        return value.getField().name() + value.separate() + value.getDirection().name();
    }
}