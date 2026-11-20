public enum StatusPedido {
    AGUARDANDO, PAGO, ENVIADO, ENTREGUE, CANCELADO
}
public class Pedido {
    private int id;
    private StatusPedido status;

    public Pedido(int id) {
        this.id = id;
        this.status = StatusPedido.AGUARDANDO;
    }

    public void avancarStatus() {
        if (status == StatusPedido.ENTREGUE || status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("Não é possível alterar um pedido que já foi " + status);
        }

        switch (status) {
            case AGUARDANDO: status = StatusPedido.PAGO; break;
            case PAGO: status = StatusPedido.ENVIADO; break;
            case ENVIADO: status = StatusPedido.ENTREGUE; break;
            default: throw new IllegalStateException("Transição inválida.");
        }
        System.out.println("Pedido avançou para: " + status);
    }

    public void cancelar() {
        if (status == StatusPedido.ENTREGUE) {
            throw new IllegalStateException("Erro: Não se cancela um pedido já ENTREGUE!");
        }
        if (status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("O pedido já está cancelado.");
        }
        status = StatusPedido.CANCELADO;
        System.out.println("Pedido cancelado com sucesso.");
    }

    public StatusPedido getStatus() { return status; }

    public static void main(String[] args) {
        Pedido p = new Pedido(1);
        p.avancarStatus(); // Vira PAGO
        p.avancarStatus(); // Vira ENVIADO
        p.avancarStatus(); // Vira ENTREGUE

        try {
            p.cancelar(); // Deve falhar aqui
        } catch (IllegalStateException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }
    }
}S
