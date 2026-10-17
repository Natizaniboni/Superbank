import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaLoginDicionarioPOO {
    public static void main(String[] args) {

        List<Usuario> usuariosCadastrados = new ArrayList<>();

        usuariosCadastrados.add(new Usuario("admin", "12345"));
        usuariosCadastrados.add(new Usuario("joao", "123"));
        usuariosCadastrados.add(new Usuario("maria", "abcde"));

        Scanner scanner = new Scanner(System.in);

        boolean loginSucesso = false;
        boolean op = true;

        do {
            System.out.println("Sistema BANCARIO");            
            System.out.println("-------------------------------------------");
            System.out.println("1 - Cadastro de usuários");
            System.out.println("2 - Acesso ao sistema - Login");
            System.out.println("3 - Sair");
            System.out.print("Digite o numero da sua opção: ");
            byte opcao = scanner.nextByte();
            if (opcao == 1) {

                scanner.nextLine();
                System.out.println("Digite o nome do usuário :" );
                String usuarioDigitado = scanner.nextLine();
                System.out.print("Digite a senha: ");
                String senhaDigitada = scanner.nextLine();
                usuariosCadastrados.add(new Usuario(usuarioDigitado, senhaDigitada));
                System.out.println("Usuário registrado com sucesso!!!");
            } else if (opcao == 2) {
                while (!loginSucesso) {
                    
                    scanner.nextLine();
                    System.out.println("===TELA DE LOGIN===");
                    System.out.print("Digite o usuário: ");
                    String usuarioDigitado = scanner.nextLine();

                    System.out.print("Digite a senha: ");
                    String senhaDigitada = scanner.nextLine();

                    boolean usuarioEncontrado = false;

                    for (Usuario credencial : usuariosCadastrados) {
                        String usuarioBanco = credencial.getNome();
                        String senhaBanco = credencial.getSenha();

                        if (usuarioBanco.equals(usuarioDigitado) && senhaBanco.equals(senhaDigitada)) {
                            usuarioEncontrado = true;
                            break;
                        }
                    }

                    if (usuarioEncontrado) {
                        System.out.println("\nLogin realizado com sucesso! Bem-vindo(a), " + usuarioDigitado + "!\n");
                        loginSucesso = true;
                        op=false;
                    } else {
                        System.out.println("\nUsuário ou senha incorretos. Tente novamente.\n");
                    }
                }

            } else if (opcao == 3) {
                System.out.println("Saindo do sistema...");
                op = false;
            } else {
                System.out.println("Opção inválida!!!");
            }

        } while (op);

        scanner.close();
    }
}
