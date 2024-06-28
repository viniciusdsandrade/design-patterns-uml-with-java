/**
 * Proxy para o serviço de download que controla o acesso a arquivos premium.
 * <p>
 * Este proxy implementa a interface {@link IDownloadService} e delega a operação
 * de download para um objeto {@link DownloadService} real. No entanto, ele
 * adiciona uma camada de lógica adicional para restringir o acesso a arquivos
 * marcados como "premium" a usuários que não possuem uma assinatura premium.
 */
public class DownloadProxy implements IDownloadService {
    /**
     * O serviço de download real que será utilizado pelo proxy.
     */
    private final DownloadService realService;

    /**
     * Construtor da classe DownloadProxy.
     * <p>
     * Inicializa o serviço de download real.
     */
    public DownloadProxy() {
        this.realService = new DownloadService();
    }

    /**
     * {@inheritDoc}
     * <p>
     * Este metodo verifica se o arquivo solicitado é um arquivo premium e se o usuário
     * possui permissão para baixá-lo. Se o arquivo for premium e o usuário não for
     * premium, o download será negado. Caso contrário, o download será delegado
     * para o serviço de download real.
     */
    @Override
    public String downloadFile(String filename, boolean isPremiumUser) {
        if (filename.contains("premium") && !isPremiumUser)
            return "Acesso negado. Arquivo premium disponível apenas para membros premium.";
        else
            return realService.downloadFile(filename, isPremiumUser);
    }
}