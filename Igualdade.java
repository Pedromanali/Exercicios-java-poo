import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Igualdade {
    public static void main(String[] args) {
        List<AlunoIgual> lista = new ArrayList<>();

        AlunoIgual a1 = new AlunoIgual("123", "João");
        lista.add(a1);

        // Aluno com a mesma matrícula, mas instanciado em outro objeto na memória
        AlunoIgual a2 = new AlunoIgual("123", "João");

        boolean contem = lista.contains(a2);
        System.out.println("Contém o aluno na lista? " + contem);
    }
}

class AlunoIgual {
    private String matricula;
    private String nome;

    public AlunoIgual(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoIgual that = (AlunoIgual) o;
        return Objects.equals(matricula, that.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}