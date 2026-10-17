import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaLoginDicionario{
    public static void main(String[] args){
        List<String[]>usuariosCadastrados = new ArrayList<>();
        usuariosCadastrados.add(new String[]{"admin","12345"});
        usuariosCadastrados.add(new String[]{"joao","123"});
        usuariosCadastrados.add(new String[]{"maria","abcde"});

        Scanner scanner=new Scanner(System.in);

        boolean loginSucesso =false;

        while(!loginSucesso){
            System.out.println("===TELA DE LOGIN===");
            System.out.print("Digite o usuário: ");
            String usuarioDigitado = scanner.nextLine();

            System.out.print("Digite a senha: ");
            String senhaDigitada =scanner.nextLine();

            boolean usuarioEncontrado = false;

            for (String[] credencial : usuariosCadastrados){
                String usuarioBanco = credencial[0];
                String senhaBanco = credencial[1];

                if(usuarioBanco.equals(usuarioDigitado) && senhaBanco.equals(senhaDigitada)){
                    usuarioEncontrado = true;
                    break;
                }
            }

             if (usuarioEncontrado){
                System.out.println("\nLogin realizado com sucesso! Bem-vindo(a), " + usuarioDigitado + "!\n");
                loginSucesso = true;
            } else {
                   System.out.println("\nUsuário ou senha incorretos. Tente novamente.\n");
            }
        }
        scanner.close();
    }
}
