package top.wwqi.model.dto;

/**
 * 前端传过来的登录DTO
 */
public class LoginDTO {
    private String name;
    private String password;
    private boolean userRole;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isUserRole() {
        return userRole;
    }

    public void setUserRole(boolean userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
