import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


//Using ByteArrayInputStream and ByteArrayOutputStream for in-memory I/O:
//allow you to create an input stream or output stream backed by a byte array. 
//Use Case: When you need to process data that is already in memory or when you want to keep data in memory.
//Advantages: They provide an efficient way to work with data in memory without the need for physical files.

public class ByteArrayStreamExample {
    public static void main(String[] args) {
        // Writing to ByteArrayOutputStream
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            String data = "Hello, ByteArray streams!";
            baos.write(data.getBytes());

            // Reading from ByteArrayInputStream
            try (ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray())) {
                int value;
                while ((value = bais.read()) != -1) {
                    System.out.print((char) value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 