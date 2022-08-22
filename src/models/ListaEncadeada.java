package models;

public class ListaEncadeada {

    private Node lista[];
    private int indice_ultimo;
    private int maximo;

    public ListaEncadeada() {
        this.indice_ultimo = -1;
        this.lista = new Node[10];
        this.maximo = 10;
    }

    public ListaEncadeada(int tamanho) {
        this.indice_ultimo = -1;
        this.lista = new Node[tamanho];
        this.maximo = tamanho;
    }

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

    public int size() {
        return indice_ultimo + 1;
    }

    public void printList() {
        System.out.println(this.toString());
    }

    public void printListWithIndexes() {
        for (int i = 0; i <= indice_ultimo; i++) {
            System.out.println("[" + lista[i].numero + ", -> " + lista[i].indice_proximo + "]");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (indice_ultimo > -1) {
            for (int i = 0; i <= indice_ultimo; i++) {
                sb.append(lista[i].numero);
                if (i < indice_ultimo) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
