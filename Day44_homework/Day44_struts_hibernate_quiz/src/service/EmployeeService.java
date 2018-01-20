package service;

import bean.Employee;
import org.hibernate.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public static void add(Employee employee){
        HibernateUtil.handle(session -> {
           session.save(employee);
           return employee;
        });
    }

    public static Employee getEmployee(String aid) {
        Employee handle = HibernateUtil.handle(session -> {
            Integer i = Integer.parseInt(aid);
            System.out.println(i);
            Employee employee = session.get(Employee.class, i);
            return employee;
        });
        return handle;
    }

    public static List<Employee> getEmployees() {
        List<Employee> handle = HibernateUtil.handle(session -> {
            List<Employee> employees = new ArrayList<>();
            Query query = session.createQuery("from " + Employee.class.getName());
            List list = query.list();
            for (Object clazz : list) {
                Employee employee = (Employee) clazz;
                employees.add(employee);
            }
            return employees;
        });
        return handle;
    }
}
