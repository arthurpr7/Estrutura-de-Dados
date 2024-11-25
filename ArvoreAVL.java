

public class ArvoreAVL {
    private No raiz;

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No atual, int valor) {
        if (atual == null) return new No(valor);

        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        } else {
            return atual; 
        }

        atual.altura = 1 + Math.max(altura(atual.esquerda), altura(atual.direita));
        return balancear(atual);
    }

    private int altura(No no) {
        return no == null ? 0 : no.altura;
    }

    private No balancear(No no) {
        int fatorBalanceamento = getFatorBalanceamento(no);

        if (fatorBalanceamento > 1) {
            if (getFatorBalanceamento(no.esquerda) < 0) {
                no.esquerda = rotacionarEsquerda(no.esquerda);
            }
            return rotacionarDireita(no);
        }

        if (fatorBalanceamento < -1) {
            if (getFatorBalanceamento(no.direita) > 0) {
                no.direita = rotacionarDireita(no.direita);
            }
            return rotacionarEsquerda(no);
        }

        return no;
    }

    private int getFatorBalanceamento(No no) {
        return no == null ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private No rotacionarDireita(No y) {
        No x = y.esquerda;
        No T = x.direita;

        x.direita = y;
        y.esquerda = T;

        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));
        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));

        return x;
    }

    private No rotacionarEsquerda(No x) {
        No y = x.direita;
        No T = y.esquerda;

        y.esquerda = x;
        x.direita = T;

        x.altura = 1 + Math.max(altura(x.esquerda), altura(x.direita));
        y.altura = 1 + Math.max(altura(y.esquerda), altura(y.direita));

        return y;
    }

    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No atual, int valor) {
        if (atual == null) return false;

        if (valor == atual.valor) return true;

        if (valor < atual.valor) {
            return buscarRecursivo(atual.esquerda, valor);
        } else {
            return buscarRecursivo(atual.direita, valor);
        }
    }
}
