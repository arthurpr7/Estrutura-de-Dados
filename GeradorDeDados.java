import java.util.Random;

public class GeradorDeDados {
    public static int[] gerarCrescente(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = i + 1;
        }
        return dados;
    }

    public static int[] gerarDecrescente(int tamanho) {
        int[] dados = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            dados[i] = tamanho - i;
        }
        return dados;
    }

    public static int[] gerarAleatorio(int tamanho) {
        int[] dados = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            dados[i] = random.nextInt(tamanho * 10);
        }
        return dados;
    }
}
