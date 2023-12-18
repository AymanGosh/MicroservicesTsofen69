import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryFinallyExample {
    public static void main(String[] args) {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("example.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Code that may throw exceptions while working with the resource
            String line = bufferedReader.readLine();
            System.out.println("Read from file: " + line);
        } finally {
            // Ensure resource (fileReader) is always closed
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    // Handle close exception if needed
                    System.err.println("Error closing FileReader: " + e.getMessage());
                }
            }
        }
    }
}
