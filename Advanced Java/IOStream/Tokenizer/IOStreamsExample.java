import java.io.*;

public class IOStreamsExample {
    public static void main(String[] args) {
        // Byte Streams Example
        byteStreamsExample();

        // Character Streams Example
        characterStreamsExample();
    }

    private static void byteStreamsExample() {
        System.out.println("----- Byte Streams Example -----");

        // FileInputStream and FileOutputStream
        try (FileInputStream fis = new FileInputStream("input.bin");
             FileOutputStream fos = new FileOutputStream("output.bin")) {

            // Reading from a file using FileInputStream
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); // Convert bytes to characters for display
                fos.write(data); // Writing to another file using FileOutputStream
            }
            System.out.println("\nByte Streams Example Completed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void characterStreamsExample() {
        System.out.println("----- Character Streams Example -----");

        // FileReader and FileWriter
        //FileReader is a class in Java that is used to create a Reader for reading the contents of a file.
        //It reads the file character by character, making it suitable for reading plain text files.
        //It does not provide buffering, so it may be less efficient for reading large files because it involves more system calls.
        try (FileReader reader = new FileReader("input.txt");
             FileWriter writer = new FileWriter("output.txt")) {

            // Reading from a file using FileReader
            int data;
            while ((data = reader.read()) != -1) {
                System.out.print((char) data);
                writer.write(data); // Writing to another file using FileWriter
            }
            System.out.println("\nCharacter Streams Example Completed");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // BufferedReader and BufferedWriter

        //BufferedReader is a class in Java that provides buffering capabilities for reading from a Reader, such as a FileReader.
        //It reads data in larger chunks (a buffer), reducing the number of system calls and making it more efficient, especially when dealing with large files.
              //It provides methods like readLine() for reading lines of text, which can be convenient for processing text-based files.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))) {

            // Reading line by line using BufferedReader
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.write(line); // Writing line by line using BufferedWriter
                bufferedWriter.newLine(); // Adding a newline character
            }
            System.out.println("Character Streams (Buffered) Example Completed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
