package minek.ckan.v3.basic.model;

import lombok.Data;

import java.util.List;

@Data
public class TagSearch {
    private int count;
    private List<Tag> results;
}
