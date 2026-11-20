public class Cadastro {
    
    public static void cadastrar(String nome, int idade) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio!");
        }
        if (idade < 0 || idade > 120) {
            throw new IllegalArgumentException("A idade deve estar entre 0 e 120 anos! Valor: " + idade);
        }
        System.out.println("Sucesso! Usuário " + nome + ", " + idade + " anos cadastrado.");
    }

    public static void main(String[] args) {
        // Testando 4 casos: 1 válido, 3 inválidos
        String[] nomes = { "Carlos", "", null, "Ana" };
        int[] idades = { 25, 30, 45, 130 };

        for (int i = 0; i < 4; i++) {
            System.out.println("\nCaso " + (i + 1) + " -> Nome: " + nomes[i] + " | Idade: " + idades[i]);
            try {
                cadastrar(nomes[i], idades[i]);
            } catch (IllegalArgumentException e) {
                System.out.println("Falha capturada: " + e.getMessage());
            }
        }
    }
}
