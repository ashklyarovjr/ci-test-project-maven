package downloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileDownloader {
    public static void downloadAFileFromNetWithNio(String inputFileUrl, String outputFilePath) throws IOException {
        System.out.println("Downloading file with NIO...");
        URL url = new URL(inputFileUrl);
        long start = System.currentTimeMillis();
        try (ReadableByteChannel channel = Channels.newChannel(url.openStream());
             FileOutputStream stream = new FileOutputStream(outputFilePath)) {
            stream.getChannel().transferFrom(channel, 0, Long.MAX_VALUE);
        }
        System.out.println("File downloaded successfully.");
        System.out.println("Download time with NIO: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void downloadFileWithFileUtils(String inputFileUrl, String outputFilePath) throws IOException {
        System.out.println("Downloading file with FileUtils...");
        URL url = new URL(inputFileUrl);
        File file = new File(outputFilePath);
        long start = System.currentTimeMillis();
        FileUtils.copyURLToFile(url, file);
        System.out.println("File downloaded successfully.");
        System.out.println("Download time with FileUtils: " + (System.currentTimeMillis() - start) + " ms");
    }
}
