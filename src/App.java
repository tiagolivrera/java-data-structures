import models.Pilha;

public class App {
    public static void main(String[] args) throws Exception {

        Pilha p1 = new Pilha();

        p1.push(1);
        p1.push(2);
        p1.push(3);
        p1.push(4);
        p1.push(5);

        System.out.println(p1.toString() + " Size: " + p1.size());

        p1.pop();
        p1.pop();
        p1.pop();
        p1.pop();
        p1.pop();

        System.out.println(p1.toString() + " Size: " + p1.size());
    }
}
