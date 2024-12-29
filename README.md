# Data-Structures-in-Java

Repositório criado para fins estudantis, criado para me aprofundar em estrutura de dados na linguagem JAVA.

# Conteúdo:

### O que são estrutura de dados?

É uma estrutura de dados que armazena/organiza dados/infomações de modo que possam ser acessados e manipulados de forma eficiente.

![Imagem das estruturas de dados](images/estruturaDados.png)

### Estrutura de dados

   <details>
  <summary>Vetores (Arrays)</summary>
  
  <br>
  
  - **Criação de um Vetor**  
    - Exemplo de criação de um vetor:  
      ```java
      tipo[] novo_array = new tipo[tamanho];
      ```

- **Iterando um Vetor**

  - Exemplo de iteração usando um `for`:

    ```java
    for (int i = 0; i < novo_array.length; i++) {
        // Acessando o elemento do vetor
        System.out.println(novo_array[i]);
    }
    ```

    - Exemplo de iteração usando um `foreach`:

    ```java
    for (tipo elemento : novo_array) {
      // Acessando o elemento do vetor
      System.out.println(elemento);
    }
    ```

- **Classe Vetor utilizada**

```java
  public class Vetor{
  private String[] elementos;
  private int tamanho;

    public Vetor(int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }
  }
```

- **Adicionando elemento no final do vetor**

```java
   public void adicionaElemento(String elemento) throws Exception{
      //Itera os elementos dentro do array e aumenta o tamanho até o seu limite total
      if(this.tamanho < this.elementos.length){
          this.elementos[this.tamanho] = elemento;
          this.tamanho++;
      }
      else{
          throw new Exception("Vetor já está cheio, não é possivel adicionar mais elementos");
      }
  }
```

- **Verificando a quantidade de elementos no vetor**

```java
  public int tamanho(){
      return this.tamanho;
  }
```

- **Imprimindo os elementos do vetor**

```java
  @Override
  public String toString(){
      return "Vetor [elementos=" + Arrays.toString(elementos)
                      + ", tamanho="
                      + tamanho + "]";
  }
```

- **Verificando se um elemento existe no vetor**

  - Exemplo de iteração usando um `for`:
    ```java
     public int elementoExisteNoVetorFor(String elemento) {
        for (int i = 0; i < this.elementos.length; i++) {
          if (elementos[i].equals(elemento.toUpperCase())) {
              return i;
          }
    }
      return -1;
    }
    ```
  - Exemplo de iteração usando um `foreach`:

    ```java
    public boolean elementoExisteNoVetorForEach(String elemento) {
       for (String item : elementos) {
          if (item.equals(elemento.toUpperCase())) {
              return true;
          }
      }
      return false;
    }
    ```

- **Adicionando elemento em qualquer posição**
  ```java
     // Representação visual da adição do elemento na posição escolhida no vetor.
    // Quero adicionar Z na posicao 2

    // 0 1 2 3 4 5 6 = tamanho do array é 5
    // B C E F G + +

    // Overloading de metodo
    public boolean adicionar(int posicao, String elemento) {
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
  ```

- **Adicionando mais capacidade ao vetor**

  ```Java
   // Metodo que só será utilizado dentro da classe vetor
    private void aumentarCapacidade() {
        if (this.tamanho == this.elementos.length) {
            // A melhor forma de aumentar a capacidade do vetor é dobrando o tamanho dele
            String[] elementosNovos = new String[this.elementos.length * 2];

            for (int i = 0; i <= this.elementos.length; i++) {
                elementosNovos[i] = elementos[i];
            }

            this.elementos = elementosNovos;

        }
    }
  ```

- **Removendo elemento do vetor**
- **Generalizando o tipo dos elementos**
- **Definindo o tipo do vetor dinamicamente**

</details>

- Pilhas(Stacks)
- Filas(Queues)
- Listas encadeadas(Linked Lists)
- Listas Duplamente Encadeadas(Doubly-Linked Lists)
- Conjuntos(Sets)
- Tabelas de Hashing(HashTables)
- Arvores(Trees)
- Grafos(Graphs)

### Algoritmos

- Algoritmos de Ordenação
  - Bolha (Bubbe Sort)
  - Seleção (Selection Sort)
  - Inserção (Inserction Sort)
  - Merge Sort
  - Quick Sort

<br>

<details>
  <summary>Algoritmos de Busca/Pesquisa</summary>

### Busca Sequencial

- Percorre a lista elemento por elemento até encontrar o valor desejado ou atingir o final da lista.
- Ideal para listas pequenas ou não ordenadas.

  ### Métodos de Busca sequencial no Vetor

- **Elemento Existe no Vetor (com ForEach):**

  ```java
  //Tipo da variavel do parametro pode ser qualquer tipo de dado, desde que seja do mesmo tipo do array que está sendo buscado.
  public boolean elementoExisteNoVetorForEach(String elemento) {
      for (String item : elementos) {
          if (item.equals(elemento.toLowerCase())) {
              return true;
          }
      }
      return false;
  }
  ```

  - Verifica se um elemento existe no vetor usando um laço `for-each`.
  - Retorna `true` se o elemento for encontrado, caso contrário, `false`.

- **Elemento Existe no Vetor (com For):**
  ```java
  //Tipo da variavel do parametro pode ser qualquer tipo de dado, desde que seja do mesmo tipo do array que está sendo buscado.
  public int elementoExisteNoVetorFor(String elemento) {
      for (int i = 0; i < this.elementos.length; i++) {
          if (elementos[i].equals(elemento)) {
              return i;
          }
      }
      return -1;
  }
  ```
  - Busca o índice do elemento no vetor usando um laço `for`.
  - Retorna o índice do elemento se encontrado, ou `-1` se não existir.

### Busca Binária

- Divide a lista ordenada em metades sucessivas para localizar o elemento desejado.
- Muito eficiente, com complexidade O(log n), mas exige que a lista esteja previamente ordenada.

</details>

#### Qual estrutura de dados você usaria ?

- Buscar uma coleção de registros do banco de dados ?

- Registro de chamadas de métodos e funções de um compilador ?

- Sistema de bancos, hospitais ?

- Manipular uma coleção de registros únicos ?

- Organizar Relacionamentos de redes sociais (Twitter, Facebook) ?
