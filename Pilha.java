public class Pilha {
    private Node topo;

    public Pilha() {
        this.topo = null;
    }



    public void adicionarSolicitacao(Elemento novaSolicitacao) {
        Node novoNo = new Node(novaSolicitacao);
        novoNo.setProximo(topo);
        topo = novoNo;
    }



    public boolean removerSolicitacaoPorId(String id) {
        if (topo == null) {
            System.out.println("Histórico vazio");
            return false;
        }

        if (topo.getData().getId().equals(id)) {
            topo = topo.getProximo();
            return true;
        }

        Node atual = topo;
        while (atual.getProximo() != null) {
            if (atual.getProximo().getData().getId().equals(id)) {
                atual.setProximo(atual.getProximo().getProximo());
                return true;
            }
            atual = atual.getProximo();
        }
        System.out.println("Solicitação encontrada.");
        return false;
    }





    public Elemento buscarSolicitacaoPorId(String id) {
        Node atual = topo;
        while (atual != null) {
            if (atual.getData().getId().equals(id)) {
                return atual.getData();
            }
            atual = atual.getProximo();
        }
        System.out.println("não encontrada.");
        return null;
    }




    public void mostrarHistorico() {
        Node atual = topo;
        if (atual == null) {
            System.out.println("Histórico vazio.");
            return;
        }
        while (atual != null) {
            Elemento elem = atual.getData();
            System.out.println("ID: " + elem.getId() + " | Descrição: " + elem.getVariavelX() + " | Data e Hora: " + elem.getVariavelY());
            atual = atual.getProximo();
        }
    }

}
