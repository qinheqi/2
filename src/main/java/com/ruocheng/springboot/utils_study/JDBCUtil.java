package com.ruocheng.springboot.utils_study;

import com.ruocheng.springboot.entity.User;

import java.sql.*;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class JDBCUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/sys_user?serverTimezone=GMT%2b8";
        try {
            return DriverManager.getConnection(url, "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static User executeQuery(String username, String password) {
        String sql = " select * from user where username = '" + username + "' and password = '" + password + "'";
        // 语法糖 try-resources
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                String username1 = rs.getString("username");
                String password1 = rs.getString("password");
                User user = new User();
                user.setUsername(username1);
                user.setPassword(password1);
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
