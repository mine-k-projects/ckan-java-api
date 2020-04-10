package minek.ckan.v3.harvest.model;

import lombok.Data;
import minek.ckan.v3.harvest.model.enums.HarvestLogLevel;

import java.time.LocalDateTime;

// https://github.com/ckan/ckanext-harvest/blob/94f0438c0ec6bfd7c85e64a3c15338a4d7800f2c/ckanext/harvest/logic/dictization.py#L102
// 리턴 할때 id 필드는 제거 한다.
@Data
public class HarvestLog {
//    private UUID id;
    private String content;
    private HarvestLogLevel level;
    private LocalDateTime created;
}
