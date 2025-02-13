package vetor;

import java.lang.reflect.Array;
import java.util.Arrays;

public class VetorGenerics<T> {
    private T[] elementos;
    private int tamanho;

    // Uso mais elegante de instaciar um tipo Generics Type
    public VetorGenerics(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public VetorGenerics(Class<T> tipoClasse, int capacidade) {
        this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
        this.tamanho = 0;
    }

    public boolean adicionaElemento(T elemento) {
        this.aumentarCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public Object busca(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        return this.elementos[posicao];
    }

    public boolean elementoExisteNoVetorForEach(T elemento) {
        for (T item : elementos) {
            if (item.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int elementoExisteNoVetorFor(T elemento) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    // Representação visual da adição do elemento na posição escolhida no vetor.
    // Quero adicionar Z na posicao 2

    // 0 1 2 3 4 5 6 = tamanho do array é 5
    // B C E F G + +

    // Overloading de metodo
    public boolean adicionar(int posicao, T elemento) {
        // Verifica se a posição está dentro das posições disponiveis dentro do vetor
        if (!(posicao < this.tamanho && posicao >= 0)) {
            throw new IllegalArgumentException("Posição invalida");
        }

        this.aumentarCapacidade();
        // Loop do final do vetor até a posição que o novo elemento será inserido
        // int i = this.tamanho - 1 =
        // this.elementos[i + 1] = this.elementos[i]; =
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;

        return false;
    }

    // Metodo que só será utilizado dentro da classe vetor
    private void aumentarCapacidade() {
        if (this.tamanho == this.elementos.length) {

            // Não é possivel criar um array de tipo generico em java, o tipo `T` não é mais
            // acessivel em tempo de execução devido ao type erasure
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];

            for (int i = 0; i <= this.elementos.length; i++) {
                elementosNovos[i] = elementos[i];
            }

            this.elementos = elementosNovos;

        }
    }

    // B G D E F -> Posicao removida é 1(G)
    // 0 1 2 3 4 -> Tamanho 5
    // Vetor[1] = Vetor[2]
    // Vetor[2] = Vetor[3]
    // Vetor[3] = Vetor[4]

    public void remove(int posicao) {
        if (!(posicao < this.tamanho && posicao >= 0)) {
            throw new IllegalArgumentException("Posição invalida");
        }

        // O i irá receber a posição, e enquanto o i for menor do que o (tamanho - 1) =
        // tamanho original do array
        // o i irá aumentar fazendo com que as proximas posicões do array recebam os
        // valores das posições adjacentes e assim removendo o elemento da posição
        // escolhida.
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = elementos[i + 1];
        }
        tamanho--;

    }

    @Override
    public String toString() {
        return "Vetor [elementos=" + Arrays.toString(elementos)
                + ", tamanho="
                + tamanho + "]";
    }
}
