
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class jsonToJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;

        ArrayList<CustomerDetails> arrayCustomers = new ArrayList<CustomerDetails>();

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "root");

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select * from customerinfo where Location = 'Asia' and PurchasedDate = " +
                "CURDATE();");

        while (rs.next()) {
            CustomerDetails customer = new CustomerDetails();

            customer.setCourseName(rs.getString(1));
            customer.setPurchaseDate(rs.getString(2));
            customer.setAmount(rs.getInt(3));
            customer.setLocation(rs.getString(4));

            arrayCustomers.add(customer);
        }

        for (int i = 0; i < arrayCustomers.size(); i++) {
            ObjectMapper o = new ObjectMapper();
            // o.writeValue(new File("C:\\Users\\tomal\\Documents\\javaCode\\JsonJava\\customerInfo.json"), customer);
            o.writeValue(new File("C:\\Users\\tomal\\OneDrive\\Documents\\javaCode\\json-to-java\\customerInfo" + i + ".json"), arrayCustomers.get(i));
            Gson g = new Gson();
            String jsonString = g.toJson(arrayCustomers.get(i));
            js.add(jsonString);
        }

        JsonObject jo = new JsonObject();
        jo.put("data","");
        JsonArray js = new JsonArray();

        connection.close();
    }
}