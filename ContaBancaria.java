public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do depósito não pode ser negativo!");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("O valor do saque não pode ser negativo!");
        }
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente! Saldo atual: R$ " + saldo);
        }
        saldo -= valor;
    }

    public double getSaldo() {
        return saldo;
    }
}