package ContaBancaria;
public class Teste {
    public static void main(String[] args) {        

        //Upcasting
        ContaBancaria[] contas = new ContaBancaria[3];

        contas[0] = new ContaCorrente("Ana Silva", 101, 10011, 100.0, 500.0);
        contas[1] = new ContaPoupanca("Bruno Souza", 202, 10022, 50.0, 0.005);
        

        System.out.println("===Sacando R$ 300,00 de cada conta (polimorfismo)===");                                                                                             
        for (ContaBancaria conta : contas) {
            System.out.println("Titular: " + conta.getTitular() + ", Saldo antes do saque: R$" + conta.getSaldo());
            conta.sacar(1100.0);
            System.out.println("Saldo após o saque: R$" + conta.getSaldo());
            System.out.println();
        }

        System.out.println("===Rendendo juros só onde faz sentido===");

        for(ContaBancaria conta : contas){
            if(conta instanceof ContaPoupanca){

                ContaPoupanca poupanca = (ContaPoupanca) conta; // Downcasting
                poupanca.renderJuros();
                System.out.println("Titular: " + poupanca.getTitular() + 
                ", Saldo após render juros: R$" + poupanca.getSaldo());

            }else{
                System.out.println("Titular: " + conta.getTitular() + 
                ", Saldo: R$" + conta.getSaldo() + " (não é uma conta poupança, não rende juros)");
            }
        }

        System.out.println();
        System.out.println("===Processando saques com polimorfismo===");
        System.out.println("Saldo inicial da conta 0: R$" + contas[0].getSaldo());
         System.out.println("Saldo inicial da conta 1: R$" + contas[1].getSaldo());        
        processarSaque(contas[0], 200.0);  
        System.out.println(); 
        processarSaque(contas[1], 200.0);



    }

    static void processarSaque(ContaBancaria conta, double valor){

        System.out.println("Processando saque de R$" + valor + " para a conta do titular: " + conta.getTitular());
        conta.sacar(valor);
    }
}
