import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeCompras {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        List<String> lista = new ArrayList<>();

        System.out.println("--- Cadastro de Itens ---");
        System.out.println("Digite os itens da lista (ou 'fim' para encerrar):");

        // Loop para ler itens até digitar "fim"
        while (true) {
            System.out.print("Item: ");
            String item = leitor.nextLine();

            // Verifica se o usuário quer parar (ignora maiúsculas/minúsculas)
            if (item.equalsIgnoreCase("fim")) {
                break;
            }

            lista.add(item);
        }

        // Mostra a lista numerada
        System.out.println("\n--- Sua Lista de Compras ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }

        // Mostra o total de itens
        System.out.println("Total de itens: " + lista.size());

        // Remoção de um item pelo nome
        System.out.println("\n--- Remover Item ---");
        System.out.print("Digite o nome do item que deseja remover: ");
        String itemParaRemover = leitor.nextLine();

        // O método remove() retorna true se achou e removeu, ou false se não existia
        if (lista.remove(itemParaRemover)) {
            System.out.println("Item \"" + itemParaRemover + "\" removido com sucesso!");
        } else {
            System.out.println("Aviso: O item \"" + itemParaRemover + "\" não foi encontrado na lista.");
        }

        // Exibe a lista final atualizada
        System.out.println("\n--- Lista Atualizada ---");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
        System.out.println("Total final: " + lista.size());

        leitor.close();
    }
}