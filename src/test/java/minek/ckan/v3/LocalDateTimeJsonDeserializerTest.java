package minek.ckan.v3;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LocalDateTimeJsonDeserializerTest {

    @Test
    public void format() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(formatter);
        System.out.println(format);
    }

}