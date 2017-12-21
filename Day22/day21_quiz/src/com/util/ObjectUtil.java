package com.util;

import com.test.*;

import java.sql.SQLException;

public class ObjectUtil {
    public static Person getInstances(int uid) throws SQLException {
            String name = JdbcUtil.getName(uid);
            String user = JdbcUtil.getUsername(uid);
            String password = JdbcUtil.getPassword(uid);
            String job = JdbcUtil.getJob(uid);
            if (job.equalsIgnoreCase("Worker")){
                return new Worker(name,user,password,job);
            } else if (job.equalsIgnoreCase("Doctor")){
                return new Doctor(name,user,password,job);
            } else if (job.equalsIgnoreCase("Cooker")){
                return new Cooker(name,user,password,job);
            } else if (job.equalsIgnoreCase("Boss")){
                return new Boss(name,user,password,job);
            } else{
                return new Person(name,user,password,job);
            }
    }
}
