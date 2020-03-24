package minek.ckan.retrofit;

import retrofit2.Converter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LocalDateTimeConverter implements Converter<LocalDateTime, String> {

    final private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String convert(LocalDateTime value) throws IOException {
        return value.format(formatter);
    }
}