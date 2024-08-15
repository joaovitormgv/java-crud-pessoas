/**
 * A classe Pessoa representa uma pessoa com nome, idade, email e telefone.
 */
public class Pessoa {
    private String nome;
    private int idade;
    private String email;
    private String telefone;

    /**
     * Construtor da classe Pessoa.
     *
     * @param nome     o nome da pessoa
     * @param idade    a idade da pessoa
     * @param email    o email da pessoa
     * @param telefone o telefone da pessoa
     */
    public Pessoa(String nome, int idade, String email, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }

    /**
     * Obtém o nome da pessoa.
     *
     * @return o nome da pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     *
     * @param nome o novo nome da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a idade da pessoa.
     *
     * @return a idade da pessoa
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade da pessoa.
     *
     * @param idade a nova idade da pessoa
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Obtém o email da pessoa.
     *
     * @return o email da pessoa
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email da pessoa.
     *
     * @param email o novo email da pessoa
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o telefone da pessoa.
     *
     * @return o telefone da pessoa
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone da pessoa.
     *
     * @param telefone o novo telefone da pessoa
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}