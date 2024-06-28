public class Test {
    public static void main(String[] args) {
        IDownloadService downloadService = new DownloadProxy();

        // Usuário regular
        System.out.println(downloadService.downloadFile("documento.pdf", false));
        System.out.println(downloadService.downloadFile("video_premium.mp4", false));

        // Usuário premium
        System.out.println(downloadService.downloadFile("video_premium.mp4", true));
    }
}