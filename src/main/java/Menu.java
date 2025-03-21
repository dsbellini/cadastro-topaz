import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

  private final Scanner scanner;
  private final List<Usuario> usuarios;

  public Menu() {
    this.scanner = new Scanner(System.in);
    this.usuarios = new ArrayList<>();
  }

  public void iniciar() {
    int opcao;

    do {
      exibirMenu();

      while (!scanner.hasNextInt()) {
        System.out.println("Entrada inválida! Digite um número.");
        scanner.next();
      }

      opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1:
          cadastrarUsuario();
          break;
        case 2:
          listarUsuarios();
          break;
        case 3:
          buscarUsuarioPorNome();
          break;
        case 4:
          removerUsuarioPorNome();
          break;
        case 0:
          System.out.println("Saindo do programa...");
          break;
        default:
          System.out.println("Opção inválida! Tente novamente.");
      }

    } while (opcao != 0);

    scanner.close();
    System.out.println("Programa encerrado. Obrigado por utilizar o sistema!");
  }

  // Métodos
  private void exibirMenu() {
    System.out.println("\n===== MENU PRINCIPAL =====");
    System.out.println("1. Cadastrar usuário");
    System.out.println("2. Listar usuários");
    System.out.println("3. Buscar usuário");
    System.out.println("4. Remover usuário");
    System.out.println("0. Sair");
    System.out.print("Escolha uma opção: ");
  }

  private void cadastrarUsuario() {
    System.out.println("\n=== Cadastro de Usuário ===");
    System.out.print("Nome: ");
    String nome = scanner.nextLine();

    String email;
    do {
      System.out.print("Email: ");
      email = scanner.nextLine();
      if (isInvalidEmail(email)) {
        System.out.println("Email inválido! Digite um email válido no formato mail@mail.com");
      }
    } while (isInvalidEmail(email));

    System.out.print("Idade: ");
    while (!scanner.hasNextInt()) {
      System.out.println("Idade inválida! Digite um número.");
      scanner.next();
    }

    int idade = scanner.nextInt();
    scanner.nextLine();

    usuarios.add(new Usuario(nome, email, idade));
    System.out.println("Usuário cadastrado com sucesso!");

    System.out.print("\nDeseja adicionar outro usuário? (S/N): ");
    String resposta = scanner.nextLine().trim().toLowerCase();

    if (resposta.equals("s")) {
      cadastrarUsuario();
    } else {
      System.out.println("\nPressione ENTER para voltar ao menu...");
      scanner.nextLine();
    }
  }

  private void listarUsuarios() {
    System.out.println("\n=== Lista de Usuários ===");

    if (usuarios.isEmpty()) {
      System.out.println("Nenhum usuário cadastrado.");
    } else {
      for (Usuario usuario : usuarios) {
        System.out.println(
            usuario.getNome() + " , " + usuario.getEmail() + " , " + usuario.getIdade());
      }
    }

    System.out.println("\nPressione ENTER para voltar ao menu...");
    scanner.nextLine();
  }

  private void buscarUsuarioPorNome() {
    System.out.println("\n=== Buscar Usuário ===");
    System.out.print("Digite o nome do usuário: ");
    String nomeBusca = scanner.nextLine();

    boolean encontrado = false;

    for (Usuario usuario : usuarios) {
      if (usuario.getNome().equalsIgnoreCase(nomeBusca)) {
        System.out.println("Usuário encontrado:");
        usuario.exibirInfo();
        encontrado = true;
        break;
      }
    }

    if (!encontrado) {
      System.out.println("Usuário não encontrado.");
    }

    System.out.print("\nDeseja buscar outro usuário? (S/N): ");
    String resposta = scanner.nextLine().trim().toLowerCase();

    if (resposta.equals("s")) {
      buscarUsuarioPorNome();
    } else {
      System.out.println("\nPressione ENTER para voltar ao menu...");
      scanner.nextLine();
    }
  }

  private void removerUsuarioPorNome() {
    System.out.println("\n=== Remover Usuário ===");
    System.out.print("Digite o nome do usuário: ");
    String nomeBusca = scanner.nextLine();

    boolean removido = false;

    for (Usuario usuario : usuarios) {
      if (usuario.getNome().equalsIgnoreCase(nomeBusca)) {
        usuarios.remove(usuario);
        System.out.println("Usuário removido com sucesso.");
        removido = true;
        break;
      }
    }

    if (!removido) {
      System.out.println("Usuário não encontrado.");
    }

    System.out.print("\nDeseja remover mais um usuário? (S/N): ");
    String resposta = scanner.nextLine().trim().toLowerCase();

    if (resposta.equals("s")) {
      removerUsuarioPorNome();
    } else {
      System.out.println("\nPressione ENTER para voltar ao menu...");
      scanner.nextLine();
    }
  }

  private static boolean isInvalidEmail(String email) {
    return !email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
  }

}