package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final String PATTERN = "[yyyy-MM-dd'T'HH:mm:ss.SSSSSS][yyyy-MM-dd HH:mm:ss.SSSSSS]";

    private final DateTimeFormatter formatter;

    public LocalDateTimeDeserializer() {
        this.formatter = DateTimeFormatter.ofPattern(PATTERN);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return LocalDateTime.parse(p.getText(), formatter);
    }
}