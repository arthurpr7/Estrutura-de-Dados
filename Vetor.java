

public class Vetor {
    private int[] dados;
    private int tamanho;

    public Vetor(int capacidade) {
        dados = new int[capacidade];
        tamanho = 0;
    }

    public void inserir(int valor) {
        if (tamanho < dados.length) {
            dados[tamanho++] = valor;
        }
    }

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (dados[i] == valor) return i;
        }
        return -1;
    }

    public void bubbleSort() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - i - 1; j++) {
                if (dados[j] > dados[j + 1]) {
                    int temp = dados[j];
                    dados[j] = dados[j + 1];
                    dados[j + 1] = temp;
                }
            }
        }
    }

    public void quickSort() {
        quickSortRecursivo(0, tamanho - 1);
    }

    private void quickSortRecursivo(int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(inicio, fim);
            quickSortRecursivo(inicio, pivo - 1);
            quickSortRecursivo(pivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int pivo = dados[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (dados[j] <= pivo) {
                i++;
                int temp = dados[i];
                dados[i] = dados[j];
                dados[j] = temp;
            }
        }
        int temp = dados[i + 1];
        dados[i + 1] = dados[fim];
        dados[fim] = temp;
        return i + 1;
    }
}
