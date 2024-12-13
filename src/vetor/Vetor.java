public class Vetor{
    private String[] elementos;
    private int tamanho;

    public Vetor(int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionaElemento(String elemento) throws Exception{
        
        if(this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        }
        else{
            throw new Exception("Vetor já está cheio, não é possivel adicionar mais elementos");
        }
    }

    // public void adicionaElemento(String elemento){
    //     for(int i = 0; i < this.elementos.length; i++){
    //         if(this.elementos[i] == null){
    //             this.elementos[i] = elemento;
    //             break;
    //         }
    //     }
    // }
}