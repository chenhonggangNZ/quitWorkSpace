package bean;

import com.opensymphony.xwork2.ActionSupport;

public class User extends ActionSupport{
    private int uid;
    private String username;
    private String nickname;
    private String password;
    private String repassword;
    private String telphone;
    private String email;
    private String focs;

    public User() {
    }

    public User(int uid, String username, String nickname, String password, String repassword, String telphone, String email, String focs) {
        this.uid = uid;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.repassword = repassword;
        this.telphone = telphone;
        this.email = email;
        this.focs = focs;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFocs() {
        return focs;
    }

    public void setFocs(String focs) {
        this.focs = focs;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                ", focs='" + focs + '\'' +
                '}';
    }
}
