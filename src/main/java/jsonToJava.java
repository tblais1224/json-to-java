
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jsonToJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "root" );
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from customerinfo where Location = 'Asia' and PurchasedDate = " +
                "CURDATE();");
        while (rs.next()) {
            CustomerDetails customer =  new CustomerDetails();
            customer.setCourseName(rs.getString(1));
            customer.setPurchaseDate(rs.getString(2));
            customer.setAmount(rs.getInt(3));
            customer.setLocation(rs.getString(4));

            System.out.println(customer.getCourseName());
            System.out.println(customer.getPurchaseDate());
            System.out.println(customer.getAmount());
            System.out.println(customer.getLocation());
        }
        connection.close();
    }
}