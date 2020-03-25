package minek.ckan.v3.enums;

public class Role {

    public interface Permission {
    }

    private Role() {
    }

    public enum Admin implements Permission {
        admin
    }

    public enum Editor implements Permission {
        read, delete_dataset, create_dataset, update_dataset, manage_group
    }

    public enum Member implements Permission {
        read, manage_group
    }
}