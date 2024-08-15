import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe PessoaCRUD fornece operações CRUD para objetos Pessoa.
 */
public class PessoaCRUD {
    private List<Pessoa> pessoas = new ArrayList<>();
    private final String arquivo = "src/main/resources/pessoas.txt";

    /**
     * Construtor da classe PessoaCRUD.
     * Inicializa a lista de pessoas e carrega os dados do arquivo.
     */
    public PessoaCRUD() {
        this.pessoas = new ArrayList<>();
        carregarPessoasDoArquivo();
    }

    /**
     * Adiciona uma nova pessoa à lista e salva no arquivo.
     *
     * @param pessoa a pessoa a ser adicionada
     */
    public void adicionar(Pessoa pessoa) {
        pessoas.add(pessoa);
        salvarPessoasNoArquivo();
    }

    /**
     * Consulta uma pessoa pelo nome.
     *
     * @param nome o nome da pessoa a ser consultada
     * @return a pessoa encontrada ou null se não encontrada
     */
    public Pessoa consultarPessoa(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equalsIgnoreCase(nome)) {
                return pessoa;
            }
        }
        return null;
    }

    /**
     * Atualiza os dados de uma pessoa existente.
     *
     * @param nome o nome da pessoa a ser atualizada
     * @param novaPessoa os novos dados da pessoa
     * @return true se a pessoa foi atualizada, false caso contrário
     */
    public boolean atualizarPessoa(String nome, Pessoa novaPessoa) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equalsIgnoreCase(nome)) {
                pessoas.set(i, novaPessoa);
                salvarPessoasNoArquivo();
                return true;
            }
        }
        return false;
    }

    /**
     * Deleta uma pessoa da lista pelo nome.
     *
     * @param nome o nome da pessoa a ser deletada
     * @return true se a pessoa foi deletada, false caso contrário
     */
    public boolean deletarPessoa(String nome) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equalsIgnoreCase(nome)) {
                pessoas.remove(i);
                salvarPessoasNoArquivo();
                return true;
            }
        }
        return false;
    }

    /**
     * Carrega os dados das pessoas a partir de um arquivo.
     */
    public void carregarPessoasDoArquivo() {
        try {
            FileInputStream fi = new FileInputStream(arquivo);
            InputStreamReader isr = new InputStreamReader(fi);
            BufferedReader br = new BufferedReader(isr);
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String nome = dados[0].split(":")[1].trim();
                int idade = Integer.parseInt(dados[1].split(":")[1].trim());
                String email = dados[2].split(":")[1].trim();
                String telefone = dados[3].split(":")[1].trim();

                Pessoa pessoa = new Pessoa(nome, idade, email, telefone);
                pessoas.add(pessoa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Salva os dados das pessoas no arquivo.
     */
    public void salvarPessoasNoArquivo() {
        try {
            FileOutputStream fo = new FileOutputStream(arquivo);
            OutputStreamWriter ow = new OutputStreamWriter(fo);
            BufferedWriter bw = new BufferedWriter(ow);
            for (Pessoa pessoa : pessoas) {
                bw.write("nome: " + pessoa.getNome() + "; idade: " + pessoa.getIdade() + "; email: " + pessoa.getEmail() + "; telefone: " + pessoa.getTelefone());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprime os dados de uma pessoa.
     *
     * @param pessoa a pessoa a ser impressa
     */
    public void printarPessoa(Pessoa pessoa) {
        System.out.printf("Nome: %s, Idade: %d, Email: %s, Telefone: %s\n", pessoa.getNome(), pessoa.getIdade(), pessoa.getEmail(), pessoa.getTelefone());
    }
}