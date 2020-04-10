package minek.ckan.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import minek.ckan.v3.basic.model.Followee;
import minek.ckan.v3.basic.model.Member;
import minek.ckan.v3.basic.model.enums.ActivityType;
import minek.ckan.v3.basic.model.enums.Capacity;
import minek.ckan.v3.basic.model.enums.ObjectType;
import minek.ckan.v3.datastore.model.DatastoreSearchResult;
import minek.ckan.v3.datastore.model.enums.FieldType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Module extends SimpleModule {

    public Module() {
        addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS")));
        addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());

        addDeserializer(Member.class, new MemberDeserializer());
        addDeserializer(Followee.class, new FolloweeDeserializer());
        addDeserializer(DatastoreSearchResult.class, new DatastoreSearchResultDeserializer());

        addSerializer(ActivityType.class, new ActivityTypeSerializer());
        addDeserializer(ActivityType.class, new ActivityTypeDeserializer());

        addSerializer(Capacity.class, new CapacitySerializer());
        addDeserializer(Capacity.class, new CapacityDeserializer());

        addSerializer(ObjectType.class, new ObjectTypeSerializer());
        addDeserializer(ObjectType.class, new ObjectTypeDeserializer());

        addSerializer(FieldType.class, new FieldTypeSerializer());
        addDeserializer(FieldType.class, new FieldTypeDeserializer());
    }
}
