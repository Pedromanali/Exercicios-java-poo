import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {
        Map<String, String> contatos = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU AGENDA ---");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Pesquisar contato");
            System.out.println("3. Remover contato");
            System.out.println("4. Listar todos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nomeAdd = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telAdd = scanner.nextLine();
                    contatos.put(nomeAdd, telAdd);
                    System.out.println("Contato salvo com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o nome para pesquisar: ");
                    String nomeBusca = scanner.nextLine();
                    // Tratando a busca sem resultado para não quebrar o programa
                    if (contatos.containsKey(nomeBusca)) {
                        System.out.println("Telefone de " + nomeBusca + ": " + contatos.get(nomeBusca));
                    } else {
                        System.out.println("Aviso: Contato não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o nome para remover: ");
                    String nomeRem = scanner.nextLine();
                    if (contatos.containsKey(nomeRem)) {
                        contatos.remove(nomeRem);
                        System.out.println("Contato removido com sucesso!");
                    } else {
                        System.out.println("Aviso: Contato não existe na agenda.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- LISTA DE CONTATOS ---");
                    if (contatos.isEmpty()) {
                        System.out.println("A agenda está vazia.");
                    } else {
                        for (String nome : contatos.keySet()) {
                            System.out.println("Nome: " + nome + " | Telefone: " + contatos.get(nome));
                        }
                    }
                    break;

                case 0:
                    System.out.println("Fechando agenda...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
