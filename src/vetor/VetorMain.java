public class VetorMain {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(3);

        try {
            vetor.adicionaElemento("1");
            vetor.adicionaElemento("2");  
            vetor.adicionaElemento("kkl");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(vetor.tamanho());
        
        System.out.println(vetor.toString());

        System.out.println(vetor.busca(2));

        System.out.println(vetor.elementoExisteNoVetorFor("23"));
        System.out.println(vetor.elementoExisteNoVetorForEach("kl"));
    }
}
