public record Coordenada(double latitude, double longitude) {
    public Coordenada {
        if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Coordenadas geográficas inválidas!");
        }
    }
}
public record Endereco(String rua, int numero, Coordenada coordenada) {
    public Endereco {
        if (rua == null || rua.isBlank()) {
            throw new IllegalArgumentException("A rua não pode ser vazia.");
        }
    }

    public static void main(String[] args) {
        Coordenada c1 = new Coordenada(-22.98, -46.99);
        Endereco e1 = new Endereco("Rua das Flores", 123, c1);
        Endereco e2 = new Endereco("Rua das Flores", 123, c1);

        System.out.println("Endereço 1: " + e1); // toString de graça
        System.out.println("Endereço 2: " + e2);
        System.out.println("São iguais? " + e1.equals(e2)); // equals de graça
    }
}
