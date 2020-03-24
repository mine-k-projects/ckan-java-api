package minek.ckan.retrofit;

import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class ConverterFactory extends Converter.Factory {

    final LocalDateTimeConverter localDateTimeConverter = new LocalDateTimeConverter();

    @Override
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == LocalDateTime.class) {
            return localDateTimeConverter;
        }
        return super.stringConverter(type, annotations, retrofit);
    }
}