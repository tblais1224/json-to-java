package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jsonToJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "root" );
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from customerinfo where PurchasedDate=CURDATE() and Location " +
                "='Asia';");
        rs.next();
        while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getInt(3));
            System.out.println(rs.getString(4));
        }
        conn.close();
    }
}