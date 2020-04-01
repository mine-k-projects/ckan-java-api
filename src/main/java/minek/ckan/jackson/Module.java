package minek.ckan.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import minek.ckan.v3.model.Followee;
import minek.ckan.v3.model.Member;
import minek.ckan.v3.model.enums.ActivityType;
import minek.ckan.v3.model.enums.Capacity;
import minek.ckan.v3.model.enums.ObjectType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Module extends SimpleModule {

    public Module() {
        addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")));
        addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")));

        addDeserializer(Member.class, new MemberJsonDeserializer());
        addDeserializer(Followee.class, new FolloweeDeserializer());

        addSerializer(ActivityType.class, new ActivityTypeJsonSerializer());
        addDeserializer(ActivityType.class, new ActivityTypeJsonDeserializer());

        addSerializer(Capacity.class, new CapacityJsonSerializer());
        addDeserializer(Capacity.class, new CapacityJsonDeserializer());

        addSerializer(ObjectType.class, new ObjectTypeJsonSerializer());
        addDeserializer(ObjectType.class, new ObjectTypeJsonDeserializer());
    }
}
