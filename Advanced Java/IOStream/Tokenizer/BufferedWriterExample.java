import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            String data = "Hello, I/O streams!";
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
