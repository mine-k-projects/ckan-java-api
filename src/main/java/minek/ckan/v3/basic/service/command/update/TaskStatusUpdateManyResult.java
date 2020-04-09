package minek.ckan.v3.basic.service.command.update;

import lombok.Data;
import minek.ckan.v3.basic.model.TaskStatus;

import java.util.List;

@Data
public class TaskStatusUpdateManyResult {
    private List<TaskStatus> results;
}
