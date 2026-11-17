import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Exceções personalizadas
class LivroNaoEncontradoException extends Exception {
    public LivroNaoEncontradoException(String msg) { super(msg); }
}

class LivroIndisponivelException extends Exception {
    public LivroIndisponivelException(String msg) { super(msg); }
}

class LimiteDeEmprestimosException extends Exception {
    public LimiteDeEmprestimosException(String msg) { super(msg); }
}

class Livro {
    String titulo;
    boolean disponivel;

    public Livro(String titulo, boolean disponivel) {
        this.titulo = titulo;
        this.disponivel = disponivel;
    }
}

public class Biblioteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Livro> catalogo = new ArrayList<>();
        
        // Cadastrando alguns livros iniciais
        catalogo.add(new Livro("Java para Iniciantes", true));
        catalogo.add(new Livro("Estrutura de Dados", false));
        catalogo.add(new Livro("Algoritmos Avançados", true));

        int emprestimosAtuais = 0;
        int opcao = -1;

        do {
            System.out.println("\n--- SISTEMA DA BIBLIOTECA ---");
            System.out.println("1. Listar livros");
            System.out.println("2. Emprestar livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = sc.nextLine();
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida! Digite apenas números.");
                continue; // Volta para o início do loop sem quebrar
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CATÁLOGO DE LIVROS ---");
                    for (int i = 0; i < catalogo.size(); i++) {
                        Livro l = catalogo.get(i);
                        String status = l.disponivel ? "Disponível" : "Emprestado";
                        System.out.println((i + 1) + ". " + l.titulo + " [" + status + "]");
                    }
                    break;

                case 2:
                    System.out.print("Digite o título do livro que deseja emprestar: ");
                    String tituloBusca = sc.nextLine().trim();

                    try {
                        // Verifica limite de empréstimos
                        if (emprestimosAtuais >= 3) {
                            throw new LimiteDeEmprestimosException("Você já atingiu o limite máximo de 3 empréstimos!");
                        }

                        Livro livroEncontrado = null;
                        for (Livro l : catalogo) {
                            if (l.titulo.equalsIgnoreCase(tituloBusca)) {
                                livroEncontrado = l;
                                break;
                            }
                        }

                        // Verifica se o livro existe
                        if (livroEncontrado == null) {
                            throw new LivroNaoEncontradoException("O livro '" + tituloBusca + "' não existe no acervo.");
                        }

                        // Verifica se está disponível
                        if (!livroEncontrado.disponivel) {
                            throw new LivroIndisponivelException("O livro '" + livroEncontrado.titulo + "' já está emprestado.");
                        }

                        // Empréstimo bem-sucedido
                        livroEncontrado.disponivel = false;
                        emprestimosAtuais++;
                        System.out.println("✅ Empréstimo realizado com sucesso! (Total ativos: " + emprestimosAtuais + "/3)");

                    } catch (LivroNaoEncontradoException | LivroIndisponivelException | LimiteDeEmprestimosException e) {
                        System.out.println("❌ Erro: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema da biblioteca...");
                    break;

                default:
                    System.out.println("⚠️ Opção inexistente! Escolha uma opção válida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}