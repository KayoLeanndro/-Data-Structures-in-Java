import java.util.Arrays;

public class Vetor {
    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionaElemento(String elemento) throws Exception {

        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento.toLowerCase();
            this.tamanho++;
        } else {
            throw new Exception("Vetor já está cheio, não é possivel adicionar mais elementos");
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String busca(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        return this.elementos[posicao];
    }

    public boolean elementoExisteNoVetorForEach(String elemento) {
        for (String item : elementos) {
            if (item.equals(elemento.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public int elementoExisteNoVetorFor(String elemento) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Vetor [elementos=" + Arrays.toString(elementos)
                + ", tamanho="
                + tamanho + "]";
    }

    // public void adicionaElemento(String elemento){
    // for(int i = 0; i < this.elementos.length; i++){
    // if(this.elementos[i] == null){
    // this.elementos[i] = elemento;
    // break;
    // }
    // }
    // }
}