package minek.ckan.retrofit;

import minek.ckan.v3.service.command.criteria.ResourceSearchCriteria;
import retrofit2.Converter;

import java.io.IOException;

public class ResourceSearchCriteriaConverter implements Converter<ResourceSearchCriteria, String> {

    @Override
    public String convert(ResourceSearchCriteria value) throws IOException {
        return value.getField().name() + ":" + value.getValue();
    }
}
