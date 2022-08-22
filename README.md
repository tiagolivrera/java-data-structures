# Complexidades assintóticas de tempo e espaço

## 1. Pilha:

###### Método Push:

```java
 public void push(int num) {
        if (this.isEmpty()) {
            pilha[0] = num;
            indice++;
            return;
        }

        for (int i = indice; i >= 0; i--) {
            pilha[i + 1] = pilha[i];
        }

        pilha[0] = num;
        indice++;
    }
```

- **Complexidade de Tempo:** O(n), dado  n o número de elementos na pilha, o novo elemento é colocado sempre no topo, e um laço for percorre a pilha para levar os elementos que já estavam presentes  uma posição adiante.

- **Complexidade de espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente.

###### Método Pop:

```java
public int pop() {
        int num = -1;
        if (!this.isEmpty()) {
            num = pilha[0];
            for (int i = 0; i < indice; i++) {
                pilha[i] = pilha[i + 1];
            }
            indice--;
        }
        return num;
    }
```

- **Complexidade de Tempo:**  O(n), dado n o número de elementos da pilha, o elemento a ser removido é o que encontra-se no topo, e um laço for percorre a pilha para levar os elementos que já estavam presentes uma posição atrás.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente.



## 2. Fila:

###### Método Enqueue:

```java
public void enqueue(int num) {
        fila[indice_ultimo+1] = num;
        indice_ultimo++;
    }
```

- **Complexidade de Tempo:** O(1), dado que é salvo o índice do último elemento inserido na fila, o próximo elemento é colocado na posição indice_ultimo +1.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente.

###### Método Dequeue:

```java
public int dequeue() {
        int num = fila[0];
        for(int i = 0; i < indice_ultimo; i++) {
            fila[i] = fila[i+1];
        }
        indice_ultimo--;
        return num;
    }
```

- **Complexidade de Tempo:** O(n), dado n o número de elementos da fila, o elemento a ser removido é o que encontra-se na posição 0, e um laço for percorre a fila para levar os elementos que já estavam presentes uma posição atrás.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente.

###### Método Rear:

```java
public int rear() {
        return indice_ultimo >= 0 ? fila[indice_ultimo] : -1;
    }
```

- **Complexidade de Tempo:** O(1), dado que retorna o último elemento da fila, para o qual já se sabia o índice para acessá-lo.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente.

**Método Front:**

```java
public int front() {
        return fila[0];
    }
```

- **Complexidade de Tempo:** O(1), dado que retorna o primeiro elemento da fila, para o qual já se sabia o índice para acessá-lo.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente.

## 3. Lista Encadeada:

###### Método Push:

```java
public void push(Node node) {
        if (indice_ultimo < maximo - 1) {
            if (indice_ultimo == -1) {
                node.indice_proximo = -1;
                lista[0] = node;
                indice_ultimo++;
            } else {
                lista[indice_ultimo].indice_proximo = indice_ultimo + 1;
                node.indice_proximo = -1;
                lista[indice_ultimo + 1] = node;
                indice_ultimo++;
            }
        }
    }
```

- **Complexidade de Tempo:** O(1), dado que o método push insere o elemento na última posição da lista, para o qual já se sabia o índice.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente.

###### Método Pop:

```java
public Node pop() {
        Node n = null;
        if (indice_ultimo > 0) {
            n = lista[indice_ultimo];
            lista[indice_ultimo - 1].indice_proximo = -1;
            indice_ultimo--;
        } else {
            n = lista[0];
            indice_ultimo = -1;
        }
        return n;
    }
```

- **Complexidade de Tempo:** O(1), dado que o método pop remove o elemento na última posição da lista, para o qual já se sabia o índice.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente e declara uma variável do tipo Node.

**Método Insert:**

```java
public void insert(int index, Node node) {
        if (indice_ultimo < maximo - 1) {
            int i = 0;
            while(i <= indice_ultimo) {
                if (i == index) {
                    for(int j = indice_ultimo; j >= i; j--) {
                        lista[j+1] = lista[j];
                        lista[j+1].indice_proximo++;
                    }
                    node.indice_proximo = i+1;
                    lista[i] = node;
                    lista[indice_ultimo+1].indice_proximo = -1;
                    indice_ultimo++;
                    break;
                }
                i++;
            }
        }
    }
```

- **Complexidade de Tempo:** O($n²$), dado que o método insert utiliza um laço while para navegar entre os índices da lista, e ao encontrar o índice certo, entra em um laço for para afastar os elementos existentes para inserir o novo nó.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente.

###### Método Remove:

```java
public void remove(int index) {
        if(index <= indice_ultimo && index >= 0) {
            int i = 0;
            while(i <= indice_ultimo) {
                if(i == index) {
                    for(int j = i; j < indice_ultimo; j++) {
                        lista[j] = lista[j+1];
                        lista[j].indice_proximo--;
                    }
                    lista[indice_ultimo-1].indice_proximo = -1;
                    indice_ultimo--;
                    break;
                }
                i++;
            }
        }
    }
```

- **Complexidade de Tempo:** O(n²), dado que o método remove utiliza um laço while para navegar entre os índices da lista, e ao encontrar o índice certo, entra em um laço for para deslocar os elementos existentes na direção do nó removido.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente.

###### Método ElementAt:

```java
public Node elementAt(int index) {
        int i = 0;
        Node n = null;
        while(i <= indice_ultimo) {
            if(index == 0) {
                n = lista[0];
                break;
            }
            if(lista[i].indice_proximo == index) {
                n = lista[i+1];
                break;
            }
            i++;
        }
        return n;
    }
```

- **Complexidade de Tempo:** O(n), dado n o número de elementos da fila, a função utiliza um laço while para percorrer os índices dos nós na lista, e ao encontar a posição correta, retorna o nó referente a posição solicitada.

- **Complexidade de Espaço:** O(1), dado que a função não requer a criação de estruturas de dados, apenas manipula uma lista de inteiros declarados externamente e declara uma variável do tipo Node.

## 4. HashMap:

###### Função Hash:

```java
private static int funcao_hash(int key) {
        return Math.abs(key) % 10;
    }
```

Dado que o map possui 10 posições, utiliza-se o resto da divisão por 10, que retorna um número entre 0 e 9, e a função abs() garante que o índice será positivo mesmo se a chave for um inteiro negativo.

**Observação:** A classe HashMap implementada não faz tratamento de colisão. Todas as colisões substituem as posições originais no map.


