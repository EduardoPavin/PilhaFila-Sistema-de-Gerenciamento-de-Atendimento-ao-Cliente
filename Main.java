import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha pilha = new Pilha();
        Fila fila = new Fila();

        Elemento[] historico = Inicializador.inicializarHistoricoSolicitacoes();
        for (Elemento elem : historico) {
            pilha.adicionarSolicitacao(elem);
        }
        Elemento[] cliente = Inicializador.inicializarFilaClientes();
        for (Elemento elem : cliente) {
            fila.adicionarCliente(elem);
        }

        int opcao;
        do {
            System.out.println("[1] Adicionar Solicitação");
            System.out.println("[2] Remover Solicitação por ID");
            System.out.println("[3] Buscar Solicitação por ID");
            System.out.println("[4] Mostrar Histórico de Solicitações");
            System.out.println("[5] Adicionar Cliente à Fila");
            System.out.println("[6] Atender Próximo Cliente");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID da solicitação: ");
                    String id = scanner.nextLine();
                    System.out.print("Digite o motivo da solicitação: ");
                    String variavelX = scanner.nextLine();
                    System.out.print("Digite a data: ");
                    String variavelY = scanner.nextLine();
                    Elemento novaSolicitacao = new Elemento(id, variavelX, variavelY);
                    pilha.adicionarSolicitacao(novaSolicitacao);
                    break;
                case 2:
                    System.out.print("Digite o ID da solicitação a ser removida: ");
                    String idRemover = scanner.nextLine();
                    pilha.removerSolicitacaoPorId(idRemover);
                    break;
                case 3:
                    System.out.print("Digite o ID da solicitação a ser buscada: ");
                    String idBuscar = scanner.nextLine();
                    Elemento solicitacaoEncontrada = pilha.buscarSolicitacaoPorId(idBuscar);
                    if (solicitacaoEncontrada != null) {
                        System.out.println("ID: " + solicitacaoEncontrada.getId() + " | Descricao: "
                                + solicitacaoEncontrada.getVariavelX() + " | Data e Hora: "
                                + solicitacaoEncontrada.getVariavelY());
                    }
                    break;
                case 4:
                    pilha.mostrarHistorico();
                    break;
                case 5:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o número de identificação: ");
                    String numeroIdentificacao = scanner.nextLine();
                    System.out.print("Digite o motivo do atendimento: ");
                    String motivoAtendimento = scanner.nextLine();
                    Elemento novoCliente = new Elemento(nome, numeroIdentificacao, motivoAtendimento);
                    fila.adicionarCliente(novoCliente);
                    break;
                case 6:
                    Elemento clienteAtendido = fila.atenderProximoCliente();
                    if (clienteAtendido != null) {
                        System.out.println("Cliente atendido: ");
                        System.out.println("ID: " + clienteAtendido.getId() + " | Nome: "
                                + clienteAtendido.getVariavelX() + " | Motivo: "
                                + clienteAtendido.getVariavelY());
                    } else {
                        System.out.println("Nenhum cliente na fila");
                    }
                    break;
                case 0:
                    System.out.println("PROGRAMA FECHANDO");
                    break;
                default:
                    System.out.println("Opção inválida!!!");
            }
        } while (opcao != 0);
        scanner.close();
    }
}
