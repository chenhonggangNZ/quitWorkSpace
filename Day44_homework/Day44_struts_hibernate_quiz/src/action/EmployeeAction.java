package action;

import bean.Employee;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.EmployeeService;

import java.util.List;

public class EmployeeAction extends ActionSupport {
    private Employee employee = new Employee();
    private List<Employee> employees;
    private String eid;

    public String add(){
        EmployeeService.add(employee);
        return SUCCESS;
    }

    public String emp(){
        String eid = ServletActionContext.getRequest().getParameter("eid");
        System.out.println(eid);
        Employee employee = EmployeeService.getEmployee(eid);
        ServletActionContext.getRequest().setAttribute("employee",employee);
        return SUCCESS;
    }

    public String employeess(){
        System.out.println("dsfdfs");
        List<Employee> employees = EmployeeService.getEmployees();
        System.out.println(employees);
        ServletActionContext.getRequest().setAttribute("employees",employees);
        return SUCCESS;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }
}
