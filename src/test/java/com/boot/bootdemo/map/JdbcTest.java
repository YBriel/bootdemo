package com.boot.bootdemo.map;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * author: yuzq
 * create: 2021-01-20 19:12
 **/
public class JdbcTest {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.0.239:3306/test123", "yzcx_dev", "yzcx123");
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from book");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
