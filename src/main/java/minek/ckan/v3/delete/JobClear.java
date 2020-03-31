package minek.ckan.v3.delete;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JobClear {
    private List<String> queues;

    public static JobClear of(List<String> queues) {
        return new JobClear(queues);
    }
}
