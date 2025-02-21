package atividades;

import java.util.Scanner;
import vetor.Contato;
import vetor.VetorGenerics;

public class VetorAcc {

    // Desafio: Utilize a classe Lista Ou Vetor Contato e desenvolva os seguintes
    // items.
    // 1. Crie um vetor com capacidade para 20 contatos.
    // 2. Insira 30 contatos no vetor
    // 3.Crie um exemplo para utilizar cada metodo da classe lista;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VetorGenerics<Contato> listaContatos = new VetorGenerics<Contato>(20);

        criarContatosDinamicamente(listaContatos, 30);

        int opcao = 1;

        while (opcao != 0) {
            opcao = obterOpcoesMenu(sc);

            switch (opcao) {
                case 1:
                    adicionarContatoFinal(sc, listaContatos);
                    break;
                case 2:
                    adicionarContatoPosicao(sc, listaContatos);
                    break;
                case 3:
                    obtemPosicaoEspecifica(sc, listaContatos);
                    break;
                case 4:
                    obtemContato(sc, listaContatos);
                    break;
                case 5:
                    obtemPosicaoEspecifica(sc, listaContatos);
                    break;
                case 6:
                    excluirPorPosicao(sc, listaContatos);
                    break;
                default:
                    break;
            }
        }
    }

    private static int obterOpcoesMenu(Scanner sc) {
        boolean entradaValida = false;
        int opcao = -1; // Inicializa com um valor inválido

        while (!entradaValida) {
            System.out.println("Digite a opção desejada");
            System.out.println("1  - Adiciona contato no final do vetor");
            System.out.println("2  - Adiciona contato em uma posição especifica");
            System.out.println("3  - Obtém contato por posição especifica");
            System.out.println("4  - Consulta contato");
            System.out.println("5  - Consulta Ultimo item do vetor");
            System.out.println("6  - Excluir por posição");
            System.out.println("7  - Excluir Contato");
            System.out.println("8 - Excluir todos os contatos do vetor");
            System.out.println("9 - Imprime vetor ");
            System.out.println("0  - Sair ");

            try {
                String entrada = sc.nextLine();
                opcao = Integer.parseInt(entrada);

                if (opcao >= 0 && opcao <= 11) {
                    entradaValida = true;
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida, digite novamente");
            }
        }

        return opcao;
    }

    private static void criarContatosDinamicamente(VetorGenerics<Contato> listaContatos, int quantidade) {
        // Adicionando uma quantidade de contatos na lista.
        for (int i = 0; i < quantidade; i++) {
            Contato contato = new Contato();
            contato.setNome("Contato: " + i);
            contato.setEmail("Contato:" + i + "@gmail.com");
            contato.setTelefone("Telefone: " + i);
            listaContatos.adicionaElemento(contato);
        }
    }

    public static void adicionarContatoFinal(Scanner sc, VetorGenerics<Contato> listaContatos) {
        // Adicionar o contato Final
        System.out.println("Criando um contato, entre com as informações:");
        String nome = leInformacao("Entre com o nome", sc);
        String telefone = leInformacao("Entre com o telefone", sc);
        String email = leInformacao("Entre com o e-mail", sc);

        Contato contato = new Contato(nome, telefone, email);

        listaContatos.adicionaElemento(contato);

        System.out.println("Contato adicionado com sucesso!");
        System.out.println(contato);
    }

    public static void adicionarContatoPosicao(Scanner sc, VetorGenerics<Contato> listaContatos) {
        // Adicionar o contato Final
        System.out.println("Criando um contato, entre com as informações:");
        String nome = leInformacao("Entre com o nome", sc);
        String telefone = leInformacao("Entre com o telefone", sc);
        String email = leInformacao("Entre com o e-mail", sc);

        Contato contato = new Contato(nome, telefone, email);

        int pos = leInformacaoInt("Entre com a posição a adicionar o contato", sc);

        try {
            listaContatos.adicionar(pos, contato);
            System.out.println("Contato adicionado com sucesso!");
            System.out.println(contato);
        } catch (Exception e) {
            System.out.println("Posição invalida, contato não adicionado");
        }
    }

    public static void obtemPosicaoEspecifica(Scanner sc, VetorGenerics<Contato> listaContatos) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", sc);

        try {
            Contato contato = (Contato) listaContatos.busca(pos);
            System.out.println(contato);
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }

    }

    public static void obtemContato(Scanner sc, VetorGenerics<Contato> listaContatos) {
        int pos = leInformacaoInt("Entre com a posição a ser pesquisada", sc);

        try {
            Contato contato = (Contato) listaContatos.busca(pos);
            System.out.println(contato);

            System.out.println("Fazendo pesquisa do contato encontrado:");
            int posicaoEncontrada = listaContatos.elementoExisteNoVetorFor(contato);
            if (posicaoEncontrada != -1) {
                System.out.println("Contato encontrado na posição: " + posicaoEncontrada);
            } else {
                System.out.println("Contato não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Posição inválida!");
        }
    }

    public static void obtemUtimoItemVetor(Scanner sc, VetorGenerics<Contato> listaContatos) {
        int pos = leInformacaoInt("Entre com a posição pesquisada", sc);

        try {
            Contato contato = (Contato) listaContatos.busca(pos);
            System.out.println("Fazendo pesquisa do ultimo indice do contato encontrado");
            System.out.println("Contato existe na posicão" + pos + ", segue os dados");
            System.out.println(contato);

        } catch (Exception e) {
            System.out.println("Posição Invalido");
        }
    }

    public static void excluirPorPosicao(Scanner sc, VetorGenerics<Contato> listaContatos) {
        int pos = leInformacaoInt("Entre com a posição pesquisada", sc);

        try {
            listaContatos.remove(pos);
            System.out.println("Contato excluido com sucesso");

        } catch (Exception e) {
            System.out.println("Posição Invalido");
        }
    }

    private static int leInformacaoInt(String msg, Scanner sc) {
        boolean entradaValida = false;
        int num = 0;

        while (!entradaValida) {
            try {
                System.out.println(msg);
                String entrada = sc.nextLine();
                num = Integer.parseInt(entrada);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Entrada inválida, por favor, digite um número.");
            }
        }

        return num;
    }

    private static String leInformacao(String msg, Scanner sc) {
        System.out.println(msg);
        String entrada = sc.nextLine();

        return entrada;
    }

}
