public class SaldoInsuficienteException extends Exception {
    private double falta;

    public SaldoInsuficienteException(double saldoAtual, double valorSolicitado) {
        super("Saldo insuficiente. Faltam R$ " + (valorSolicitado - saldoAtual) + " para realizar a operação.");
        this.falta = valorSolicitado - saldoAtual;
    }

    public double getFalta() {
        return falta;
    }
}