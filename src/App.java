import models.FilaFIFO;
import models.ListaEncadeada;
import models.Node;
import models.Pilha;

public class App {
    public static void main(String[] args) throws Exception {

        Pilha p1 = new Pilha();
        FilaFIFO f1 = new FilaFIFO();

        ListaEncadeada l = new ListaEncadeada();
        
        l.push(new Node(13));
        l.push(new Node(23));
        l.push(new Node(34));
        l.push(new Node(44));
        l.push(new Node(55));
        l.push(new Node(65));
        
        //l.insert(0, new Node(-1));

        l.printList();

        l.remove(3);

        l.printListWithIndexes();



    }
}
