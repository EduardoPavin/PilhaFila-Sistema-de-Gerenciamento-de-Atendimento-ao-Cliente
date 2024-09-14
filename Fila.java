public class Fila {
    private Node inicio;
    private Node fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }




    public void adicionarCliente(Elemento novoCliente) {
        Node novoNo = new Node(novoCliente);
        if (fim == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }
    }


    public Elemento atenderProximoCliente() {
        if (inicio == null) {
            System.out.println("Fila está vazia.");
            return null;
        }
        Elemento clienteAtendido = inicio.getData();
        inicio = inicio.getProximo();
        if (inicio == null) {
            fim = null;
        }
        return clienteAtendido;
    }
}
