/**
 * Implementação real do serviço de download de arquivos.
 */
public class DownloadService implements IDownloadService {

    /**
     * {@inheritDoc}
     * <p>
     * Esta implementação sempre permite o download, independentemente do tipo de arquivo ou status do usuário.
     */
    @Override
    public String downloadFile(String filename, boolean isPremiumUser) {
        System.out.println("Downloading file: " + filename);
        return "Download completo: " + filename;
    }
}