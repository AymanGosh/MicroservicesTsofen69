import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileNotFoundException {
    public static void main(String[] args) {
        try {
            // Attempting to open a file that does not exist
            FileInputStream fileInputStream = new FileInputStream("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException: " + e.getMessage());
        }
    }
}



try (FileReader reader = new FileReader("file.txt")) {
    // Code that works with the reader
} catch (IOException e) {
    // Any IOException during resource closing will be caught here
}
