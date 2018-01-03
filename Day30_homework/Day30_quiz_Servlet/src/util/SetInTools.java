package util;

import bean.Person;
import exception.RegisterException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SetInTools {

    private static PreparedStatement pstate;
    private static ResultSet resultSet;
    private static int uid;

    public static boolean SetIn(Person person){

        Connection connection = JdbcUtil.getConnection();
        String sql = "INSERT INTO users VALUES(null,?,null,?)";
        try {
            RegisterTools.Register(person);
            pstate = connection.prepareStatement(sql);
            pstate.setString(1,person.getUsername());
            pstate.setString(2,person.getPassword());
            int i = pstate.executeUpdate();
            pstate.close();
            sql = "SELECT uid FROM users WHERE username=? AND password=?";
            pstate = connection.prepareStatement(sql);
            pstate.setString(1,person.getUsername());
            pstate.setString(2,person.getPassword());
            resultSet = pstate.executeQuery();
            while(resultSet.next()){
                String isuid = resultSet.getString(1);
                uid = Integer.parseInt(isuid);
            }
            resultSet.close();
            pstate.close();
            sql = "INSERT INTO person VALUES(?,?,?,?,?)";
            pstate = connection.prepareStatement(sql);
            pstate.setString(1,String.valueOf(uid));
            pstate.setString(2,person.getName());
            pstate.setString(3,String.valueOf(person.getAge()));
            pstate.setString(4,person.getGender());
            pstate.setString(5,person.getJob());
            int i1 = pstate.executeUpdate();
            pstate.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } catch (RegisterException e) {
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
    }
}
