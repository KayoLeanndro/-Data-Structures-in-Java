# Data-Structures-in-Java

Repositório criado para fins estudantis, criado para me aprofundar em estrutura de dados na linguagem JAVA.

# Conteúdo:

### O que são estrutura de dados?

É uma estrutura de dados que armazena/organiza dados/infomações de modo que possam ser acessados e manipulados de forma eficiente.

![Imagem das estruturas de dados](images/estruturaDados.png)

### Estrutura de dados

   <details>
  <summary>Vetores (Arrays)</summary>

 ### Um array é uma estrutura de dados que armazena uma coleção de elementos de tal forma que cada um dos elementos possa ser identificado por, pelo menos um indice ou uma chave.
  
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

```java
  // B G D E F -> Posicao removida é 1(G)
    // 0 1 2 3 4 -> Tamanho 5
    // Vetor[1] = Vetor[2]
    // Vetor[2] = Vetor[3]
    // Vetor[3] = Vetor[4]
    public void remove(int posicao) {
        if (!(posicao < this.tamanho && posicao >= 0)) {
            throw new IllegalArgumentException("Posição invalida");
        }

        // O i irá receber a posição, e enquanto o i for menor do que o (tamanho - 1) =
        // tamanho original do array
        // o i irá aumentar fazendo com que as proximas posicões do array recebam os
        // valores das posições adjacentes e assim removendo o elemento da posição
        // escolhida.
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = elementos[i + 1];
        }
        tamanho--;

    }
```
- **Generalizando o tipo dos elementos**
  ### Object X Generics <ㅤTㅤ>
    Quando pensamos em generalizar para que possamos colocar diversos tipos de dados em uma estrutura como uma lista, usando Object ou genéricos (como <T>), devemos considerar vários fatores importantes. Um dos principais pontos é a segurança de tipo (Type Safety), mas há também outros aspectos como reusabilidade, legibilidade, manutenção e desempenho. 
    #### Segurança de tipo(Type Safety):
     - Usando o `Object`
       - Quando utilizamos o `Object` em uma estrutura de dados, o compilador permite que seja armazenado, Pois o `Object` é *SUPERCLASSE* de todas as classes em java.

       - Isso significa que você pode inserir qualquer tipo de dado(Como ´String´, ´Integer´, ou até mesmo Objetos) à estrutura de dados. 

    - Problema com o `Object`    
      - Embora isso possa parecer flexivel, o problema é que a verificação do tipo de objeto só ocorre em _Tempo de execução_ , o que pode levar a exceção como `ClassCastException` se você tentar fazer um cast incorreto.


       ```java
        List list = new ArrayList();
        list.add("String");
        list.add(10);  // Adiciona um número inteiro, que pode ser indesejado
        String str = (String) list.get(0);  // Necessário fazer cast
        Integer num = (Integer) list.get(1);  // Isso pode causar ClassCastException
       ```

       - Usando o `Generics`
        - Quando utilizamos o `Generics`, nós definimos explicitamente o tipo de dados que a estrutura de dados possa armazenar. 

       - Isso signigica que o compilador pode verificar os tipos de dados em _tempo de execução_ e garantir que o tipo do dado esteja correto. E assim, evitando o risco de   exceções em tempo de execução. 

       ```java
      List<String> list = new ArrayList<>();
      list.add("Texto");  
      String str = list.get(0);  // Não há necessidade de cast, já sabemos que é uma String
       ```

    
- **Definindo o tipo do vetor dinamicamente**

    - Para Entendermos melhor o que iremos fazer a seguir, precisamos entender um conceito bastante interessante chamado `Type Erasure`

   #### Type erasure (apagamento de tipo):

    * *O Type Erasure é um mecanismo em Java que remove informações sobre tipos genéricos em tempo de compilação. Isso significa que, durante a execução, o tipo genérico T é substituído pelo seu limite superior (Object, por padrão). Como consequência:*
      * Não é possível acessar ou criar instâncias do tipo genérico diretamente em tempo de execução.
      * Isso leva a limitações, como a impossibilidade de criar arrays de tipos genéricos diretamente.


  ```java
    private void aumentarCapacidade() {
       if (this.tamanho == this.elementos.length) {

        // Não é possível criar um array de tipo genérico diretamente
        // Isso gera um erro de compilação: "Cannot create a generic array of T"
        T[] elementosNovos = new T[this.elementos.length * 2]; 

        for (int i = 0; i < this.elementos.length; i++) {
            elementosNovos[i] = elementos[i];
        }

        this.elementos = elementosNovos;
     }
  }
  ```
  #### Por que isso não funciona?
  A tentativa de criar new T[] falha porque o tipo T não é mais acessível em tempo de execução devido ao Type Erasure.

  #### Como resolver ?
  Embora não possamos criar diretamente um array genérico, podemos usar as seguintes abordagens:


  ```java
    private void aumentarCapacidade() {
       if (this.tamanho == this.elementos.length) {

        // Cria um array de Object e faz o cast para T[]
        T[] elementosNovos = (T[]) new Object[this.elementos.length * 2]; 

        for (int i = 0; i < this.elementos.length; i++) {
            elementosNovos[i] = elementos[i];
        }

        this.elementos = elementosNovos;
     }
  }
  ```

  - A limitação de criar arrays genéricos em Java está diretamente relacionada ao conceito de Type Erasure.
  - Para contornar essa limitação, você pode usar arrays de Object[] com cast, reflexão, ou estruturas como ArrayList, dependendo das suas necessidades.
  - Sempre que possível, escolha soluções que garantam segurança de tipo e simplicidade no código.

  - **Metodos Com o tipo ´Object´**

  ```java
     public boolean adicionaElemento(Object elemento) {
        this.aumentarCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }
  ```

  ```java
    public boolean elementoExisteNoVetorForEach(Object elemento) {
        for (Object item : elementos) {
            if (item.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int elementoExisteNoVetorFor(Object elemento) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }
  ```
  ```java
     public boolean adicionar(int posicao, Object elemento) {
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
  ```java
        private void aumentarCapacidade() {
        if (this.tamanho == this.elementos.length) {
            // A melhor forma de aumentar a capacidade do vetor é dobrando o tamanho dele
            // Obs: Depende muito do caso em que você está tentando fazer isso, pode
            // acarretar um OutOfMemoryError
            Object[] elementosNovos = new Object[this.elementos.length * 2];

            for (int i = 0; i <= this.elementos.length; i++) {
                elementosNovos[i] = elementos[i];
            }

            this.elementos = elementosNovos;

        }
    }
  ```

  - **Metodos Com o tipo T(Generics)´**

  ```java
     // Uso mais elegante de instaciar um tipo Generics Type
    public VetorGenerics(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public VetorGenerics(Class<T> tipoClasse, int capacidade) {
        this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
        this.tamanho = 0;
    }
  ```

  ```java
    public boolean adicionaElemento(T elemento) {
        this.aumentarCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }
  ```
  ```java
      public boolean elementoExisteNoVetorForEach(T elemento) {
        for (T item : elementos) {
            if (item.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public int elementoExisteNoVetorFor(T elemento) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }
  ```
  ```java
       public boolean adicionar(int posicao, T elemento) {
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
    ```java
       private void aumentarCapacidade() {
        if (this.tamanho == this.elementos.length) {

            // Não é possivel criar um array de tipo generico em java, o tipo `T` não é mais
            // acessivel em tempo de execução devido ao type erasure
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];

            for (int i = 0; i <= this.elementos.length; i++) {
                elementosNovos[i] = elementos[i];
            }

            this.elementos = elementosNovos;

        }
    }
  ```

  ## Listas

  * Mas conhecida como ArrayList, é uma Classe que introduz uma facilidade maior de manipular um Array da forma convencional.

 ``` java
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
```
   




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
  - Bolha (Bubble Sort)
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
