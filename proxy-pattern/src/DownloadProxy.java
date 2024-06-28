public class DownloadProxy implements IDownloadService {
    private final DownloadService realService;

    public DownloadProxy() {
        this.realService = new DownloadService();
    }

    @Override
    public String downloadFile(String filename, boolean isPremiumUser) {
        if (filename.contains("premium") && !isPremiumUser)
            return "Acesso negado. Arquivo premium disponível apenas para membros premium.";
        else
            return realService.downloadFile(filename, isPremiumUser);
    }
}