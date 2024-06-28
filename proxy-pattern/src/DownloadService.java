public class DownloadService implements IDownloadService {
    @Override
    public String downloadFile(String filename, boolean isPremiumUser) {
        System.out.println("Downloading file: " + filename);
        return "Download completo: " + filename;
    }
}