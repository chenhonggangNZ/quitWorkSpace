package bean;

public class People {
   private int uid;
   private String name;
   private int age;
   private String gender;
   private String job;

    public People() {
    }

    public People(int uid, String name, int age, String gender, String job) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.job = job;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "People{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;

        People people = (People) o;

        if (getUid() != people.getUid()) return false;
        if (getAge() != people.getAge()) return false;
        if (getName() != null ? !getName().equals(people.getName()) : people.getName() != null) return false;
        if (getGender() != null ? !getGender().equals(people.getGender()) : people.getGender() != null) return false;
        return getJob() != null ? getJob().equals(people.getJob()) : people.getJob() == null;
    }

    @Override
    public int hashCode() {
        int result = getUid();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getAge();
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getJob() != null ? getJob().hashCode() : 0);
        return result;
    }
}
