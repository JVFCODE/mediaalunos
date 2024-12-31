import java.util.ArrayList;
import java.util.Scanner;

class Usuario {
    private int id;
    private String nome;
    private String email;

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Email: " + email;
    }
}

public class CadastroCRUD {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static int contadorId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu de Cadastro:");
            System.out.println("1. Criar novo cadastro");
            System.out.println("2. Listar cadastros");
            System.out.println("3. Atualizar cadastro");
            System.out.println("4. Excluir cadastro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    criarUsuario(scanner);
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 3:
                    atualizarUsuario(scanner);
                    break;
                case 4:
                    excluirUsuario(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void criarUsuario(Scanner scanner) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        Usuario usuario = new Usuario(contadorId++, nome, email);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("\nLista de Usuários:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    private static void atualizarUsuario(Scanner scanner) {
        listarUsuarios();
        System.out.print("Digite o ID do usuário que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                System.out.print("Digite o novo nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o novo email: ");
                String email = scanner.nextLine();
                usuario.setNome(nome);
                usuario.setEmail(email);
                System.out.println("Usuário atualizado com sucesso!");
                return;
            }
        }

        System.out.println("Usuário com ID " + id + " não encontrado.");
    }

    private static void excluirUsuario(Scanner scanner) {
        listarUsuarios();
        System.out.print("Digite o ID do usuário que deseja excluir: ");
        int id = scanner.nextInt();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.remove(i);
                System.out.println("Usuário excluído com sucesso!");
                return;
            }
        }

        System.out.println("Usuário com ID " + id + " não encontrado.");
    }
}
