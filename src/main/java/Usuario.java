public class Usuario {
  private String nome;
  private String email;
  private int idade;

  public Usuario(String nome, String email, int idade) {
    this.nome = nome;
    this.email = email;
    this.idade = idade;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public int getIdade() {
    return idade;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  // Método para exibir informações
  public void exibirInfo() {
    System.out.println("Nome: " + nome);
    System.out.println("Email: " + email);
    System.out.println("Idade: " + idade);
  }
}
