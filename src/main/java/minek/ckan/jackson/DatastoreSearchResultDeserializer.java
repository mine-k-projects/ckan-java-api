package minek.ckan.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import minek.ckan.v3.datastore.model.DatastoreSearchResult;
import minek.ckan.v3.datastore.model.Field;
import minek.ckan.v3.datastore.model.enums.RecordsFormat;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DatastoreSearchResultDeserializer extends JsonDeserializer<DatastoreSearchResult> {

    @Override
    public DatastoreSearchResult deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        ObjectMapper objectCodec = (ObjectMapper) p.getCodec();
        JsonNode jsonNode = objectCodec.readTree(p);

        boolean include_total = jsonNode.get("include_total").asBoolean();
        String resource_id = jsonNode.get("resource_id").asText();
        boolean distinct = jsonNode.get("distinct").asBoolean();
        boolean plain = jsonNode.get("plain").asBoolean();
        String records_format = jsonNode.get("records_format").asText();
        JsonNode records = jsonNode.get("records");
        JsonNode fields = jsonNode.get("fields");
        JsonNode links = jsonNode.get("_links");

        DatastoreSearchResult result = new DatastoreSearchResult();
        result.setIncludeTotal(include_total);
        result.setResourceId(UUID.fromString(resource_id));
        result.setDistinct(distinct);
        result.setPlain(plain);
        result.setRecordsFormat(RecordsFormat.valueOf(records_format));
        result.setFields(
                objectCodec.readValue(fields.toString(), new TypeReference<List<Field>>() {
                })
        );
        result.setLinks(
                objectCodec.readValue(links.toString(), DatastoreSearchResult.Link.class)
        );

        switch (result.getRecordsFormat()) {
            case objects:
                result.setRecords(
                        new DatastoreSearchResult.ObjectRecords(
                                objectCodec.readValue(records.toString(), new TypeReference<List<Map<String, Object>>>() {
                                })
                        )
                );
                break;
            case lists:
                result.setRecords(
                        new DatastoreSearchResult.ListRecords(
                                objectCodec.readValue(records.toString(), new TypeReference<List<List<Object>>>() {
                                })
                        )
                );
                break;
            case csv:
                result.setRecords(
                        new DatastoreSearchResult.CsvRecords(records.asText())
                );
                break;
            case tsv:
                result.setRecords(
                        new DatastoreSearchResult.TsvRecords(records.asText())
                );
                break;
        }

        return result;
    }
}
