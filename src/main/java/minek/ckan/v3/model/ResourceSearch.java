package minek.ckan.v3.model;

import lombok.Data;

import java.util.List;

@Data
public class ResourceSearch {
    private int count;
    private List<Resource> results;
}
