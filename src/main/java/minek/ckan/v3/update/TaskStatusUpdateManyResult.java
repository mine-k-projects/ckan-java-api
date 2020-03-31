package minek.ckan.v3.update;

import lombok.Data;
import minek.ckan.v3.TaskStatus;

import java.util.List;

@Data
public class TaskStatusUpdateManyResult {
    private List<TaskStatus> results;
}
