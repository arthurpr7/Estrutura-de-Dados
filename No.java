public class No {
    int valor;
    No esquerda, direita;
    int altura; 

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = 1; 
    }

    public No(int valor, int altura) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.altura = altura;
    }
}
