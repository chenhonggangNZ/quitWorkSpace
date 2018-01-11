package com.xinyou.bookstore.user.domain;

public class Admin {
    private int aid;
    private String adminname;
    private String password;
    private int authorization;

    public Admin() {
    }

    public Admin(int aid, String adminname, String password, int authorization) {
        this.aid = aid;
        this.adminname = adminname;
        this.password = password;
        this.authorization = authorization;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthorization() {
        return authorization;
    }

    public void setAuthorization(int authorization) {
        this.authorization = authorization;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aid=" + aid +
                ", adminname='" + adminname + '\'' +
                ", password='" + password + '\'' +
                ", authorization=" + authorization +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Admin)) return false;

        Admin admin = (Admin) o;

        if (getAid() != admin.getAid()) return false;
        if (getAuthorization() != admin.getAuthorization()) return false;
        if (getAdminname() != null ? !getAdminname().equals(admin.getAdminname()) : admin.getAdminname() != null)
            return false;
        return getPassword() != null ? getPassword().equals(admin.getPassword()) : admin.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getAid();
        result = 31 * result + (getAdminname() != null ? getAdminname().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + getAuthorization();
        return result;
    }
}
