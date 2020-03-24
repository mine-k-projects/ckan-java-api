package minek.ckan.retrofit;

import retrofit2.Converter;

import java.io.IOException;

class EnumConverter implements Converter<Enum<?>, String> {

    @Override
    public String convert(Enum<?> value) throws IOException {
        String name = value.name();
        if (name.startsWith("_")) {
            return name.substring(1);
        }
        return name;
    }
}