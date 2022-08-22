package models;

public class FilaFIFO {

    private int fila[];
    private int indice_ultimo;

    public FilaFIFO() {
        this.fila = new int[10];
        this.indice_ultimo = -1;
    }

    public FilaFIFO(int tamanho) {
        this.fila = new int[tamanho];
        this.indice_ultimo = -1;
    }

    public void enqueue(int num) {
        fila[indice_ultimo+1] = num;
        indice_ultimo++;
    }

    public int dequeue() {
        int num = fila[0];
        for(int i = 0; i < indice_ultimo; i++) {
            fila[i] = fila[i+1];
        }
        indice_ultimo--;
        return num;
    }

    public int rear() {
        return indice_ultimo >= 0 ? fila[indice_ultimo] : -1;
    }

    public int front() {
        return fila[0];
    }

    public int size() {
        return indice_ultimo + 1;
    }

    public boolean isEmpty() {
        return indice_ultimo == -1 ? true : false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (!this.isEmpty()) {
            for (int i = 0; i <= indice_ultimo; i++) {
                sb.append(fila[i]);
                if (i < indice_ultimo) {
                    sb.append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
