package minek.ckan.v3.service.command.update;

import lombok.Data;
import minek.ckan.v3.model.TaskStatus;

import java.util.List;

@Data
public class TaskStatusUpdateManyResult {
    private List<TaskStatus> results;
}
