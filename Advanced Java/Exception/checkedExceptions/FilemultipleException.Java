import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MultipleExceptionHandling {
    public static void main(String[] args) {
        try {
            readFile("nonexistent.txt");
        } catch (FileNotFoundException e) {
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } catch (Exception e) {
            // Catching a more general Exception, can be used as a fallback
            System.err.println("Caught Exception: " + e.getMessage());
        }
    }

    private static void readFile(String fileName) throws FileNotFoundException, IOException {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            // Code that works with the bufferedReader
        } finally {
            // Ensure the BufferedReader is always closed
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.err.println("Error closing BufferedReader: " + e.getMessage());
                }
            }
        }
    }
}
