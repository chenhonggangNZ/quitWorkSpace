package bean;

import com.opensymphony.xwork2.ActionSupport;

public class Admin extends ActionSupport {
    private int aid;
    private String username;
    private String password;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin admin = (Admin) o;

        if (aid != admin.aid) return false;
        if (username != null ? !username.equals(admin.username) : admin.username != null) return false;
        if (password != null ? !password.equals(admin.password) : admin.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
