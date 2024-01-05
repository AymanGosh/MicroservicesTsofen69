import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("output.txt")) {
            String data = "Hello, I/O streams!";
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
