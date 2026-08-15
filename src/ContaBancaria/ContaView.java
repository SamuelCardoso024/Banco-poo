package ContaBancaria;

import java.util.Scanner;

public class ContaView {

    private Scanner scanner = new Scanner(System.in);

    public int exibirMenu() {
        System.out.println("");
        System.out.println("=== Banco POO ===");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar ");
        System.out.println("3 - Sacar");
        System.out.println("4 - Emitir Extrato");
        System.out.println("5 - Listar Contas");
        System.out.println("0 - Sair ");
        System.out.println("Escolha uma Opção!");
        return scanner.nextInt();


    };


    public int escolherTipoConta() {
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.println("TIPO DE CONTA");
        return scanner.nextInt();
    };

    public String lerTexto(String rotulo) {
        System.out.println(rotulo);
        scanner.nextLine();
        return scanner.nextLine();
    };

    public int lerInteiro(String rotulo) {
        System.out.println(rotulo);
        return scanner.nextInt();
    };

    public double lerValor(String rotulo) {
        System.out.println(rotulo);
        return scanner.nextDouble();
    };

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
        
  };

    public void listarContas(ContaBancaria[] contas, int total) {
        if (total == 0) {
            System.out.println("Nenhuma conta cadastrada.");
            return;
        } 
        System.out.println("=== Contas cadastradas ===");
        for(int i = 0; i < total; i++) {
            ContaBancaria conta = contas[i];
            System.out.printf("Nº %d | %s | Titular: %s | Saldo: R$ %.2f | Status: %s%n", 
            conta.getNumeroConta(),
            conta.getClass().getSimpleName(),
            conta.getTitular(),
            conta.getSaldo(),
            conta.getStatus());
        };

    };


}
