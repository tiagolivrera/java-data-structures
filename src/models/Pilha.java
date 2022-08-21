package models;

public class Pilha {

    private int pilha[];
    private int indice;

    public Pilha() {
        this.pilha = new int[10];
        this.indice = -1;
    }

    public Pilha(int tamanho) {
        this.pilha = new int[tamanho];
        this.indice = -1;
    }

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

    public int top() {
        return pilha[0];
    }

    public boolean isEmpty() {
        return indice == -1 ? true : false;
    }

    public int size() {
        return indice + 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!this.isEmpty()) {
            for (int i = 0; i <= indice; i++) {
                sb.append(pilha[i]);
                if (i < indice) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
