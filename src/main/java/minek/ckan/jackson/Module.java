package minek.ckan.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import minek.ckan.v3.Followee;
import minek.ckan.v3.Member;
import minek.ckan.v3.enums.ActivityType;
import minek.ckan.v3.enums.Capacity;
import minek.ckan.v3.enums.ObjectType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Module extends SimpleModule {

    public Module() {
        addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")));
        addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")));
        addDeserializer(Member.class, new MemberJsonDeserializer());
        addDeserializer(ActivityType.class, new ActivityTypeJsonDeserializer());
        addDeserializer(Capacity.class, new CapacityJsonDeserializer());
        addDeserializer(ObjectType.class, new ObjectTypeJsonDeserializer());
        addDeserializer(Followee.class, new FolloweeDeserializer());
    }
}
