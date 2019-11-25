import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractJson {
    public static void main(String[] args) throws IOException {
        ObjectMapper o = new ObjectMapper();
        CustomerDetailsAppium c = o.readValue(new File("C:\\Users\\tomal\\OneDrive\\Documents\\javaCode\\json-to-java\\customerInfo0.json"), CustomerDetailsAppium.class);

        System.out.println(c.getCourseName() + " " + c.getStudentName());
    }
}
