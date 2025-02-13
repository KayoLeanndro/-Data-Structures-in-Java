package vetor;

public class VetorObjectMain {
    public static void main(String[] args) {
        Contato c1 = new Contato("Kayo", "81986228400", "kayoleanndro2@gmail.com");
        Contato c2 = new Contato("Leao", "81986228870", "Tigre@gmail.com");
        Contato c3 = new Contato("Tigre", "81986222323", "Leao@gmail.com");

        VetorObject vetorObject = new VetorObject(3);

        // vetorObject.adicionaElemento(c1);
        // vetorObject.adicionaElemento(c2);
        // vetorObject.adicionaElemento(c3);

        // System.out.println(vetorObject.toString());

        // int pos = vetorObject.elementoExisteNoVetorFor(c2);
        // System.out.println(pos > -1 ? "Existe elemento no vetor" : "Não existe
        // elemento no vetor");

    }
}
