package main;

import util.JdbcUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String personname = req.getParameter("personname");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String job = req.getParameter("job");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String sql = "INSERT INTO person VALUES(?,?,?,?,?)";
        Connection connection = JdbcUtil.getConnection();
        try{
        PreparedStatement pstate = connection.prepareStatement(sql);
        pstate.setString(1,"3");
        pstate.setString(2,personname);
        pstate.setString(3,String.valueOf(age));
        pstate.setString(4,gender);
        pstate.setString(5,job);
            int i = pstate.executeUpdate();
            pstate.close();
            connection.close();
            if (i > 0){
                resp.getWriter().write("插入成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
}
