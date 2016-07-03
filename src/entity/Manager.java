package entity;

/**
 * Created by hjc on 16-7-3.
 */
public class Manager {
    private String manager_id;
    //管理员id

    private String manager_name;
    //管理员用户名

    private String manager_password;
    //管理员密码

    public Manager() {
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_password() {
        return manager_password;
    }

    public void setManager_password(String manager_password) {
        this.manager_password = manager_password;
    }
}
