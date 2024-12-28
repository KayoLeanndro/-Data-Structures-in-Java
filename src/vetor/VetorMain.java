public class VetorMain {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(10);

        try {
            vetor.adicionaElemento("B");
            vetor.adicionaElemento("C");
            vetor.adicionaElemento("F");
            vetor.adicionaElemento("G");
            vetor.adicionaElemento("H");
            vetor.adicionaElemento("I");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // System.out.println(vetor.tamanho());
        // System.out.println(vetor.toString());

        // System.out.println(vetor.busca(2));

        // System.out.println(vetor.elementoExisteNoVetorFor("23"));
        // System.out.println(vetor.elementoExisteNoVetorForEach("kl"));

        // vetor.adicionar(0, "A");

        // System.out.println(vetor.toString());

        System.out.println(vetor.toString());

        vetor.adicionar(2, "Z");

        System.out.println(vetor.toString());
    }
}
