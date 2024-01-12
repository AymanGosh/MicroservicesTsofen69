package createThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


class FileDownloader extends Thread {
    private String url;
    private String destinationPath;

    public FileDownloader(String url, String destinationPath) {
        this.url = url;
        this.destinationPath = destinationPath;
    }

    public void run() {
        System.out.println("Downloading file from " + url);

        try {
            // Open a connection to the URL
            URL urlObj = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlObj.openStream()));

            // Create a destination file
            Path destinationFile = Path.of(destinationPath, getFileName(url));
            Files.createDirectories(destinationFile.getParent());

            // Read lines and convert them to bytes before writing to the file
            byte[] contentBytes = reader.lines().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString().getBytes(StandardCharsets.UTF_8);

            Files.write(destinationFile, contentBytes, StandardOpenOption.CREATE);

            reader.close();
        } catch (IOException e) {
            System.err.println("Error downloading file from " + url + ": " + e.getMessage());
        }

        System.out.println("Download from " + url + " complete. File saved at: " + destinationPath + "\n");
    }

    private String getFileName(String url) {
        // Extracts the file name from the URL
        return url.substring(url.lastIndexOf('/') + 1);
    }
}

public class MultiThreadFileDownloader {
    public static void main(String[] args) {
        // URLs of files to download concurrently
        String[] fileUrls = {
                "https://github.com/dfparker2002/books-2/blob/master/head-first-java.pdf",
                "https://www.tutorialspoint.com/java/java_tutorial.pdf",
                "https://pepa.holla.cz/wp-content/uploads/2016/10/microservices-for-java-developers.pdf"
        };

        // Destination path to save downloaded files
        String destinationPath = "C:\\Users\\Dawodk\\Desktop\\Tsofen\\MicroservicesTsofen69";

        // Create and start a thread for each file URL
        for (String fileUrl : fileUrls) {
            FileDownloader downloader = new FileDownloader(fileUrl, destinationPath);
            downloader.start();
        }
    }
}
