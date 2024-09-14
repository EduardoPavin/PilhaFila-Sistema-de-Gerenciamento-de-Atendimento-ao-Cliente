
public class Node {
    private Elemento data;
    private Node proximo;

    public Node(Elemento data) {
        this.data = data;
        this.proximo = null;
    }

    public Elemento getData() {
        return data;
    }

    public void setData(Elemento data) {
        this.data = data;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }
}
