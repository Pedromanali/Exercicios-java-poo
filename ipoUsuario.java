public enum TipoUsuario {
    ESTUDANTE(3),
    PROFESSOR(10),
    VISITANTE(1);

    private final int limiteEmprestimos;

    TipoUsuario(int limiteEmprestimos) {
        this.limiteEmprestimos = limiteEmprestimos;
    }

    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }
}
public class Usuario {
    private String nome;
    private TipoUsuario tipo;

    public Usuario(String nome, TipoUsuario tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public void exibirPermissao() {
        System.out.println("Usuário: " + nome + " | Perfil: " + tipo + 
                           " | Limite de livros: " + tipo.getLimiteEmprestimos());
    }

    public static void main(String[] args) {
        Usuario u1 = new Usuario("Carlos", TipoUsuario.ESTUDANTE);
        Usuario u2 = new Usuario("Ana", TipoUsuario.PROFESSOR);

        u1.exibirPermissao();
        u2.exibirPermissao();
    }
}