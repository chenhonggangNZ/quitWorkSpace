package dao;

public class Person {
    private String name;
    private String gender;
    private int age;
    private String job;
    private String username;
    private String password;

    public Person(){

    }

    public Person(String name,String gender,int age,String job,String username,String password){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.username = username;
        this.password = password;
    }

    public Person(String name ,String gender,int age,String job){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.job= job;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
