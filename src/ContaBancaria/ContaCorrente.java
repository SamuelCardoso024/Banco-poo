package ContaBancaria;
public class ContaCorrente extends ContaBancaria {
    private double limite;

    public ContaCorrente(String titular, int agencia,
            int numeroConta, double saldo, double limite) {
        super(titular, agencia, numeroConta, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
         if (status != StatusConta.ATIVA) {
            System.out.println("Operação não permitida: conta " + status + ".");
        } else if (valor <= 0) {
            System.out.println("Valor de saque inválido. O valor deve ser maior que zero.");
        } else if (valor > (saldo + limite)) {
            System.out.println("Saldo insuficiente. O valor do saque excede o saldo disponível e o limite da conta.");
        } else {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        }
    }

    @Override
    public double calcularTaxaManutencao() {
        double taxa = limite * 0.01;
        System.out.println("Taxa de manutenção da conta corrente: R$ " + taxa);
        return taxa;
    }

    @Override
    public void emitirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        System.out.println("Titutar: " + getTitular());
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Limite: " + limite);
    };

}
