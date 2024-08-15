import java.util.Scanner;

/**
 * A classe Main é o ponto de entrada do programa.
 */
public class Main {

    /**
     * O método main é o ponto de entrada do programa.
     *
     * @param args argumentos da linha de comando
     */
    public static void main(String[] args) {
        PessoaCRUD pessoaCRUD = new PessoaCRUD();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("1 - Adicionar pessoa");
            System.out.println("2 - Consultar pessoa");
            System.out.println("3 - Atualizar pessoa");
            System.out.println("4 - Deletar pessoa");
            System.out.println("5 - Sair");
            System.out.print("Escolha o que fazer: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    Pessoa pessoa = new Pessoa(nome, idade, email, telefone);
                    pessoaCRUD.adicionar(pessoa);
                    System.out.println("Pessoa adicionada com sucesso");
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nomeConsulta = scanner.nextLine();
                    Pessoa pessoaConsultada = pessoaCRUD.consultarPessoa(nomeConsulta);
                    if (pessoaConsultada != null) {
                        pessoaCRUD.printarPessoa(pessoaConsultada);
                    } else {
                        System.out.println("Pessoa não encontrada");

                    }

                    break;
                case 3:
                    System.out.print("Nome: ");
                    String nomeAtualizar = scanner.nextLine();
                    Pessoa pessoaAtualizar = pessoaCRUD.consultarPessoa(nomeAtualizar);
                    if (pessoaAtualizar != null) {
                        System.out.print("Nome: ");
                        String nomeNovo = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idadeNova = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Email: ");
                        String emailNovo = scanner.nextLine();
                        System.out.print("Telefone: ");
                        String telefoneNovo = scanner.nextLine();
                        Pessoa novaPessoa = new Pessoa(nomeNovo, idadeNova, emailNovo, telefoneNovo);
                        pessoaCRUD.atualizarPessoa(nomeAtualizar, novaPessoa);
                    } else {
                        System.out.println("Pessoa não encontrada");
                    }
                    break;
                case 4:
                    System.out.print("Nome: ");
                    String nomeDeletar = scanner.nextLine();
                    if (pessoaCRUD.deletarPessoa(nomeDeletar)) {
                        System.out.println("Pessoa deletada");
                    } else {
                        System.out.println("Pessoa não encontrada");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
            System.out.println();
            System.out.println("==================================");
            System.out.println();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (opcao != 5);

        scanner.close();
    }
}