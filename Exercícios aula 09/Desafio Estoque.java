import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Produto {
    String codigo;
    String nome;
    double preco;
    int quantidade;
    int quantidadeMinima;
    String categoria;

    public Produto(String codigo, String nome, double preco, int quantidade, int quantidadeMinima, String categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.quantidadeMinima = quantidadeMinima;
        this.categoria = categoria;
    }
}

public class Estoque {
    private Map<String, Produto> produtosMap = new HashMap<>();
    private Set<String> categoriasSet = new HashSet<>(); // Set evita duplicatas automaticamente

    public boolean cadastrarProduto(Produto p) {
        if (produtosMap.containsKey(p.codigo)) {
            System.out.println("Erro: Já existe um produto com o código " + p.codigo);
            return false;
        }
        produtosMap.put(p.codigo, p);
        categoriasSet.add(p.categoria); // Adiciona a categoria ao Set
        System.out.println("Produto '" + p.nome + "' cadastrado com sucesso!");
        return true;
    }

    public void venderProduto(String codigo, int qtdVendida) {
        Produto p = produtosMap.get(codigo);
        if (p == null) {
            System.out.println("Erro: Produto não encontrado.");
            return;
        }

        if (p.quantidade < qtdVendida) {
            System.out.println("Erro: Estoque insuficiente para o produto " + p.nome + ". Disponível: " + p.quantidade);
        } else {
            p.quantidade -= qtdVendida;
            System.out.println("Venda realizada! Novo estoque de " + p.nome + ": " + p.quantidade);
        }
    }

    public void relatorioEstoqueBaixo() {
        System.out.println("\n--- RELATÓRIO: ESTOQUE ABAIXO DO MÍNIMO ---");
        boolean achou = false;
        for (Produto p : produtosMap.values()) {
            if (p.quantidade < p.quantidadeMinima) {
                System.out.println("- " + p.nome + " | Atual: " + p.quantidade + " | Mínimo exigido: " + p.quantidadeMinima);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum produto abaixo do estoque mínimo.");
        }
    }

    public double calcularValorTotalEstoque() {
        double total = 0;
        for (Produto p : produtosMap.values()) {
            total += (p.preco * p.quantidade);
        }
        return total;
    }

    public void listarCategorias() {
        System.out.println("\nCategorias cadastradas: " + categoriasSet);
    }

    public static void main(String[] args) {
        Estoque meuEstoque = new Estoque();

        Produto p1 = new Produto("001", "Mouse", 50.0, 10, 3, "Eletrônicos");
        Produto p2 = new Produto("002", "Teclado", 120.0, 2, 5, "Eletrônicos");
        Produto p3 = new Produto("003", "Caderno", 15.0, 20, 4, "Papelaria");

        meuEstoque.cadastrarProduto(p1);
        meuEstoque.cadastrarProduto(p2);
        meuEstoque.cadastrarProduto(p3);

        // Testando cadastro com código repetido (deve recusar)
        meuEstoque.cadastrarProduto(new Produto("001", "Mouse Duplicado", 45.0, 5, 2, "Eletrônicos"));

        // Testando venda com estoque insuficiente (deve recusar)
        meuEstoque.venderProduto("002", 4);

        // Testando venda normal
        meuEstoque.venderProduto("002", 1);

        // Relatório de estoque baixo
        meuEstoque.relatorioEstoqueBaixo();

        // Valor total
        System.out.println("\nValor total financeiro do estoque: R$ " + meuEstoque.calcularValorTotalEstoque());

        // Listar categorias sem repetição
        meuEstoque.listarCategorias();
    }
}
