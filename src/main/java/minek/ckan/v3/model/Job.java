package minek.ckan.v3.model;

import lombok.Data;

import java.time.LocalDateTime;

// https://github.com/ckan/ckan/blob/0adbdd778a7569854d74e45f1fc147c2fe26d8d4/ckan/lib/jobs.py#L191
@Data
public class Job {
    private String id;
    private String title;
    private LocalDateTime created;
    private String queue;
}
