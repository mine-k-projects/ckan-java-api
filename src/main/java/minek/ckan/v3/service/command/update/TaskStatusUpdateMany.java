package minek.ckan.v3.service.command.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import minek.ckan.v3.model.TaskStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class TaskStatusUpdateMany {
    private List<TaskStatus> data;

    public static TaskStatusUpdateMany of(List<TaskStatus> data) {
        return new TaskStatusUpdateMany(data);
    }
}
