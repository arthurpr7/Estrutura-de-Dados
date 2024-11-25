import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] tamanhos = {100, 1000, 10000};
        String[] ordens = {"Crescente", "Decrescente", "Aleatoria"};

        for (int tamanho : tamanhos) {
            System.out.println("\nTamanho do conjunto: " + tamanho);
            for (String ordem : ordens) {
                int[] dados = gerarDados(tamanho, ordem);
                testar(ordem, dados, tamanho);
            }
        }
    }

    private static void testar(String ordem, int[] dados, int tamanho) {
        System.out.println("\nOrdem: " + ordem);

        Vetor vetor = new Vetor(tamanho);
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        long tempoInicio, tempoFim;

        tempoInicio = System.nanoTime();
        for (int valor : dados) vetor.inserir(valor);
        tempoFim = System.nanoTime();
        long tempoVetorInsercao = tempoFim - tempoInicio;

        tempoInicio = System.nanoTime();
        for (int valor : dados) arvoreBinaria.inserir(valor);
        tempoFim = System.nanoTime();
        long tempoArvoreBinariaInsercao = tempoFim - tempoInicio;

        tempoInicio = System.nanoTime();
        for (int valor : dados) arvoreAVL.inserir(valor);
        tempoFim = System.nanoTime();
        long tempoArvoreAVLInsercao = tempoFim - tempoInicio;

        System.out.println("Tempo de insercao no Vetor: " + tempoVetorInsercao + " ns");
        System.out.println("Tempo de insercao na Arvore Binaria: " + tempoArvoreBinariaInsercao + " ns");
        System.out.println("Tempo de insercao na Arvore AVL: " + tempoArvoreAVLInsercao + " ns");

        Vetor vetorBubble = new Vetor(tamanho);
        for (int valor : dados) vetorBubble.inserir(valor);
        tempoInicio = System.nanoTime();
        vetorBubble.bubbleSort();
        tempoFim = System.nanoTime();
        long tempoBubbleSort = tempoFim - tempoInicio;

        System.out.println("Tempo de Bubble Sort no Vetor: " + tempoBubbleSort + " ns");

        Vetor vetorQuick = new Vetor(tamanho);
        for (int valor : dados) vetorQuick.inserir(valor);
        tempoInicio = System.nanoTime();
        vetorQuick.quickSort();
        tempoFim = System.nanoTime();
        long tempoQuickSort = tempoFim - tempoInicio;

        System.out.println("Tempo de Quick Sort no Vetor: " + tempoQuickSort + " ns");

        int primeiro = dados[0];
        int ultimo = dados[tamanho - 1];
        int meio = dados[tamanho / 2];
        int valorAleatorio = dados[new Random().nextInt(tamanho)];
        int valorInexistente = -1;

        medirTempoBusca("Primeiro", vetor, arvoreBinaria, arvoreAVL, primeiro);
        medirTempoBusca("Ultimo", vetor, arvoreBinaria, arvoreAVL, ultimo);
        medirTempoBusca("Meio", vetor, arvoreBinaria, arvoreAVL, meio);
        medirTempoBusca("Aleatorio", vetor, arvoreBinaria, arvoreAVL, valorAleatorio);
        medirTempoBusca("Inexistente", vetor, arvoreBinaria, arvoreAVL, valorInexistente);
    }

    private static void medirTempoBusca(String tipo, Vetor vetor, ArvoreBinaria arvoreBinaria, ArvoreAVL arvoreAVL, int valor) {
        long tempoInicio, tempoFim;

        tempoInicio = System.nanoTime();
        vetor.buscar(valor);
        tempoFim = System.nanoTime();
        long tempoBuscaVetor = tempoFim - tempoInicio;

        tempoInicio = System.nanoTime();
        arvoreBinaria.buscar(valor);
        tempoFim = System.nanoTime();
        long tempoBuscaArvoreBinaria = tempoFim - tempoInicio;

        tempoInicio = System.nanoTime();
        arvoreAVL.buscar(valor);
        tempoFim = System.nanoTime();
        long tempoBuscaArvoreAVL = tempoFim - tempoInicio;

        System.out.println("Tempo de busca (" + tipo + ") no Vetor: " + tempoBuscaVetor + " ns");
        System.out.println("Tempo de busca (" + tipo + ") na Arvore Binaria: " + tempoBuscaArvoreBinaria + " ns");
        System.out.println("Tempo de busca (" + tipo + ") na Arvore AVL: " + tempoBuscaArvoreAVL + " ns");
    }

    private static int[] gerarDados(int tamanho, String ordem) {
        int[] dados = new int[tamanho];
        if ("Crescente".equals(ordem)) {
            for (int i = 0; i < tamanho; i++) dados[i] = i + 1;
        } else if ("Decrescente".equals(ordem)) {
            for (int i = 0; i < tamanho; i++) dados[i] = tamanho - i;
        } else { 
            Random random = new Random();
            for (int i = 0; i < tamanho; i++) dados[i] = random.nextInt(tamanho * 10);
        }
        return dados;
    }
}
