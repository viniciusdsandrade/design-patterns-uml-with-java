public class Test {
    public static void main(String[] args) {
        // Cria uma instância do proxy de download.
        IDownloadService downloadService = new DownloadProxy();

        // Simula um usuário regular tentando baixar arquivos.
        System.out.println(downloadService.downloadFile("documento.pdf", false));
        System.out.println(downloadService.downloadFile("video_premium.mp4", false));

        // Simula um usuário premium tentando baixar um arquivo premium.
        System.out.println(downloadService.downloadFile("video_premium.mp4", true));
    }
}