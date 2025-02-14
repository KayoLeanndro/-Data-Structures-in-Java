package atividades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import vetor.Contato;

public class VetorAcc {

    // Desafio: Utilize a classe Lista Ou Vetor Contato e desenvolva os seguintes
    // items.
    // 1. Crie um vetor com capacidade para 20 contatos.
    // 2. Insira 30 contatos no vetor
    // 3.Crie um exemplo para utilizar cada metodo da classe lista;
    public static void main(String[] args) {

        List<Contato> listaContatos = new ArrayList<>();

        criarContatosDinamicamente(listaContatos, 30);
    }

    private static int obterOpcoesMenu(Scanner sc){

        boolean entradaValida = false;

        while(!entradaValida) {
            System.out.println("Digite a opção desejada");
            System.out.println("1  - Adiciona contato no final do vetor"); 
            System.out.println("2  - Adiciona contato em uma posição especifica");
            System.out.println("3  - Obtém contato por posição especifica");
            System.out.println("4  - Consulta último indice do contato");
            System.out.println("6  - Verificar se o contato existe");
            System.out.println("7  - Excluir por posição");
            System.out.println("8  - Excluir Contato");
            System.out.println("9  - Verifica tamanho do vetor");
            System.out.println("10 - Excluir todos os contatos do vetor");
            System.out.println("11 - Imprime vetor ");
            System.out.println("0  - Sair ");
        }
        
        try{
            String entrada = sc.nextLine();
            int opcao = Integer.parseInt(entrada);
            
            if(opcao >= 0 && opcao <= 11){
                entradaValida = true;
            }

        }catch(Exception e){
            System.out.println("Entrada inválida, digite novamente");
        }

        return 0;
    }

    private static void criarContatosDinamicamente(List<Contato> listaContatos, int quantidade) {
        // Adicionando uma quantidade de contatos na lista.
        for (int i = 0; i < quantidade; i++) {
            Contato contato = new Contato();
            contato.setNome("Contato: " + i);
            contato.setEmail("Contato:" + i + "@gmail.com");
            contato.setTelefone("Telefone: " + i);
            listaContatos.add(contato);
        }
    }

}
