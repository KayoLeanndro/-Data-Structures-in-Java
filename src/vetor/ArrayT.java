package vetor;

import java.util.ArrayList;

public class ArrayT {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<String>();
        array.add("A");
        array.add("B");
        array.add("C");

        // Metodo que adiciona um elemento no index escolhido
        array.add(1, "Elemento");

        // Metodo de busca de algum elemento no array
        boolean existe = array.contains("B");
        if (existe) {
            System.out.println("O elemento existe no Array");
        } else {
            System.out.println("O elemento não existe no Array");
        }

        // Metodo que busca o index de um determinado parametro passado nos parentesees
        int pos = array.indexOf("B");
        if (pos > -1) {
            System.out.println("Elemento existe no array");
        } else {
            System.out.println("O elemento não existe no array");
        }

        // Metodo que busca o elemento de um determinado index
        String index = "Elemento do Index: " + array.get(3);
        System.out.println(index);

        // Metodo que remove um elemento do array e metodo que remove elemento de um
        // index
        array.remove("B"); // Elemento/Objeto
        array.remove(1); // Index

        // Metodo que verifica o tamanho do array
        int tamanho = array.size();
        System.out.println(tamanho);

        System.out.println(array);
    }

}
