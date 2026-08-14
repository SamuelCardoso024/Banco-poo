package ContaBancaria;

public class ContaController {
    private ContaBancaria[] contas = new ContaBancaria[10];
    private int total = 0;
    private ContaView view = new ContaView();

    public void iniciar() {

        int opcao;
        do {

            opcao = view.exibirMenu();
            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    emitirExtrato();
                    break;
                case 5:
                    view.listarContas(contas, total);
                    break;
                case 0:
                    view.exibirMensagem("Encerrando..");
                    break;
                default:
                    view.exibirMensagem("Opção invalida");
                    break;
            }
        } while (opcao != 0);
    }

    private void criarConta() {
        if (total == contas.length) {
            view.exibirMensagem("limite de contas atingido");
            return;
        };
        
        int tipo = view.escolherTipoConta();
        String titular = view.lerTexto("Titular");
        int agencia = view.lerInteiro("Agencia");
        double saldoInicial = view.lerValor("Saldo Inicial: R$");
        int numeroConta = 1000 + total; 

        switch(tipo) {
            case 1:
                double limite = view.lerValor("Lista do cheque especial: R$");
                contas[total] = new ContaCorrente(titular, agencia, numeroConta, saldoInicial, limite);
                break;
            case 2: 
                double taxaJuros = view.lerValor("Taxa de Juros");
                contas[total] = new ContaPoupanca(titular, agencia, numeroConta, saldoInicial, taxaJuros);
                break;
            default: 
                view.exibirMensagem("Tipo de Conta inválido");
                return;
        };
        total++;
    };

    private void depositar() {
        ContaBancaria conta = selecionarConta();
        if(conta == null) {
            return;
        }

        double valor = view.lerValor("Valor para depósito: ");
        conta.depositar(valor);
    };

    private void sacar() {
        ContaBancaria conta = selecionarConta();
        if(conta == null) {
            return;
        }

        double valor = view.lerValor("Valor para saque: ");
        conta.sacar(valor);
    };

    private void emitirExtrato() {
        ContaBancaria conta = selecionarConta();
        if(conta == null) {
            return;
        }

        conta.emitirExtrato();
    };

    private ContaBancaria selecionarConta() {
        if (total == 0) {
            view.exibirMensagem("Nenhuma conta cadastrada");
            return null;
        };
        int numeroConta = view.lerInteiro("numero da conta");

        for (int i = 0; i < total; i++) {
            if (contas[i].getNumeroConta() == numeroConta) {
                  return contas[i];
            };
        };
        view.exibirMensagem("Conta não cadastrada");
            return null;
        
    };
};
