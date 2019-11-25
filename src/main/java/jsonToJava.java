
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jsonToJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        CustomerDetails customer = new CustomerDetails();
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "root");
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from customerinfo where Location = 'Asia' and PurchasedDate = " +
                "CURDATE() LIMIT 1;");
        while (rs.next()) {
            customer.setCourseName(rs.getString(1));
            customer.setPurchaseDate(rs.getString(2));
            customer.setAmount(rs.getInt(3));
            customer.setLocation(rs.getString(4));
        }
        ObjectMapper o = new ObjectMapper();
        // o.writeValue(new File("C:\\Users\\tomal\\Documents\\javaCode\\JsonJava\\customerInfo.json"), customer);
        o.writeValue(new File("C:\\Users\\tomal\\OneDrive\\Documents\\javaCode\\json-to-java\\customerInfo.json"), customer);

        connection.close();
    }
}