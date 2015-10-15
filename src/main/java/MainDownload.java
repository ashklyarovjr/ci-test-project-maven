import downloader.FileDownloader;
import utils.PathsKeeper;

import java.io.IOException;

public class MainDownload {
    public static void main(String[] args) throws IOException {
        FileDownloader.downloadAFileFromNetWithNio(PathsKeeper.INPUT_FILE_URL, PathsKeeper.OUTPUT_FILE_PATH_NIO);
        System.out.println("Please, check " + PathsKeeper.OUTPUT_FILE_PATH_NIO + " file");

        FileDownloader.downloadFileWithFileUtils(PathsKeeper.INPUT_FILE_URL, PathsKeeper.OUTPUT_FILE_PATH_FUTILS);
        System.out.println("Please, check " + PathsKeeper.OUTPUT_FILE_PATH_FUTILS + " file");
    }
}
