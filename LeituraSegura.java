import java.util.Scanner;

public class LeituraSegura {
    
    // Método estático que insiste até receber um inteiro válido
    public static int lerInteiro(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = sc.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Erro: Entrada inválida! Digite apenas números inteiros.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- CADASTRO COM LEITURA SEGURA ---");
        int idade = lerInteiro(sc, "Digite sua idade: ");
        int anoNascimento = lerInteiro(sc, "Digite seu ano de nascimento: ");

        System.out.println("\nDados lidos com sucesso!");
        System.out.println("Idade informada: " + idade);
        System.out.println("Ano de nascimento informado: " + anoNascimento);

        sc.close();
    }
}