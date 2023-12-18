import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionExample {
    public static void main(String[] args) {
        try {
            // Attempting to read from a file that may not exist
            readFile("nonexistent.txt");
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }
    }

    private static void readFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
