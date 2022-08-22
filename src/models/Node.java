package models;

public class Node {
    public int numero;
    public int indice_proximo;

    public Node(int numero, int indice_proximo) {
        this.numero = numero;
        this.indice_proximo = indice_proximo;
    }

    public Node(int numero) {
        this.numero = numero;
    }

    public Node() {
    }
}