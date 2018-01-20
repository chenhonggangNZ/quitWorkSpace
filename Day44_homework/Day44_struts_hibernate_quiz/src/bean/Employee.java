package bean;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;

public class Employee extends ActionSupport{
    private int eid;
    private String ename;
    private String department;
    private Date hiredate;
    private String address;
    private String telnumber;
    private Integer age;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", department='" + department + '\'' +
                ", hiredate=" + hiredate +
                ", address='" + address + '\'' +
                ", telnumber='" + telnumber + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (eid != employee.eid) return false;
        if (ename != null ? !ename.equals(employee.ename) : employee.ename != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        if (hiredate != null ? !hiredate.equals(employee.hiredate) : employee.hiredate != null) return false;
        if (address != null ? !address.equals(employee.address) : employee.address != null) return false;
        if (telnumber != null ? !telnumber.equals(employee.telnumber) : employee.telnumber != null) return false;
        if (age != null ? !age.equals(employee.age) : employee.age != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid;
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (hiredate != null ? hiredate.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telnumber != null ? telnumber.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }
}
