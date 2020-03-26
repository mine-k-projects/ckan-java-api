package minek.ckan.retrofit;

import minek.ckan.v3.sort.Sort;
import retrofit2.Converter;
import retrofit2.Retrofit;
import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.LocalDateTime;

public class ConverterFactory extends Converter.Factory {

    final LocalDateTimeConverter localDateTimeConverter = new LocalDateTimeConverter();
    final EnumConverter enumConverter = new EnumConverter();
    final SortConverter sortConverter = new SortConverter();

    @Override
    public Converter<?, String> stringConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type == LocalDateTime.class) {
            return localDateTimeConverter;
        } else if (type instanceof ParameterizedType) {
            if (Sort.class.isAssignableFrom(((ParameterizedTypeImpl) type).getRawType())) {
                return sortConverter;
            }
        } else if (((Class<?>) type).isEnum()) {
            return enumConverter;
        }
        return super.stringConverter(type, annotations, retrofit);
    }
}