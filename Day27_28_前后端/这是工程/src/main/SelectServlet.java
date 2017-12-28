package main;

import net.sf.json.JSONArray;
import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        List<Person> persons = new ArrayList<>();
        Connection connection = JdbcUtil.getConnection();
        String sql = "SELECT uid FROM person";
        try {
            PreparedStatement pstate = connection.prepareStatement(sql);
            ResultSet resultSet = pstate.executeQuery();
            while(resultSet.next()){
                    String isuid = resultSet.getString(1);
                    int uid = Integer.parseInt(isuid);
                    int age = Integer.parseInt(JdbcUtil.getAge(uid));
                    persons.add(new Person(JdbcUtil.getName(uid),JdbcUtil.getGender(uid),age,JdbcUtil.getJob(uid)));
            }
            JSONArray jsonArray = JSONArray.fromObject(persons);
            resp.getWriter().write(jsonArray.toString());
            resultSet.close();
            pstate.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
