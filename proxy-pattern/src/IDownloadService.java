/**
 * Define o contrato para o serviço de download de arquivos.
 */
public interface IDownloadService {
    /**
     * Realiza o download de um arquivo.
     *
     * @param filename      O nome do arquivo a ser baixado.
     * @param isPremiumUser Indica se o usuário atual é premium.
     * @return Uma mensagem informando o resultado do download.
     */
    String downloadFile(String filename, boolean isPremiumUser);
}