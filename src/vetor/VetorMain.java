public class VetorMain {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(2);

        try {
            vetor.adicionaElemento("1");
            vetor.adicionaElemento("2");
            vetor.adicionaElemento("3");    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    
    }
}
