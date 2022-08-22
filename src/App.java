import models.FilaFIFO;
import models.HashMap;
import models.ListaEncadeada;
import models.Node;
import models.Pilha;

public class App {
    public static void main(String[] args) throws Exception {

        Pilha p = new Pilha();
        FilaFIFO f = new FilaFIFO();
        ListaEncadeada l = new ListaEncadeada();
        HashMap m = new HashMap();

        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);

        System.out.println("Pilha após o push: " + p.toString() + " Top: " + p.top() + " Size: " + p.size());

        p.pop();
        p.pop();
        p.pop();
        p.pop();

        System.out.println("Pilha após o pop:  " + p.toString() + " Size: " + p.size());

        f.enqueue(1);
        f.enqueue(2);
        f.enqueue(3);
        f.enqueue(4);

        System.out.println("\nFila após enqueue: " + f.toString() + " Front: " + f.front() + " Rear: " + f.rear()
                + " Size: " + f.size());

        f.dequeue();
        f.dequeue();
        f.dequeue();
        f.dequeue();

        System.out.println("Fila após dequeue: " + f.toString() + " Size: " + f.size());

        l.push(new Node(1));
        l.push(new Node(2));
        l.push(new Node(3));
        l.push(new Node(4));

        System.out.println("\nLista Encadeada apṕs push: " + l.toString());
        l.insert(1, new Node(333));
        System.out.println("Inserindo numero 333 na posicao 1: " + l.toString());
        l.remove(2);
        System.out.println("Removendo numero na posicao 2: " + l.toString());

        m.put(10, 1);
        m.put(11, 1);
        m.put(12, 1);
        m.put(13, 1);
        m.put(14, 1);
        m.put(15, 1);
        m.put(16, 1);
        m.put(17, 1);
        m.put(18, 1);
        m.put(19, 1);
        m.put(20, 2);

        System.out.println("\nHashMap: " + m.toString());
        m.delete(20);
        System.out.println("Removendo bucket de chave 20: " + m.toString());
    }
}
