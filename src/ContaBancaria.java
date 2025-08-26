public class ContaBancaria {
  // *** ENCAPSULAMENTO AQUI ***
  // O atributo "saldo" é privado (private)
  // Isso significa que ele só pode ser acessado diretamente DENTRO desta classe.
  private double saldo;

  // Construtor para iniciar a conta com um saldo inicial
    public ContaBancaria(double saldoInicial) {
        if (saldoInicial > 0) {
            this.saldo = saldoInicial;
        }else{
            this.saldo = 0;
        }
    }

    // *** ENCAPSULAMENTO AQUI ***
    // Metodo Público para depositar. É a "porta" de entrada de dinheiro.
    //Ele controla com o saldo pode ser aumentado.
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado com sucesso. Novo saldo: " + this.saldo);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }
    // *** ENCAPSULAMENTO AQUI ***
    // Método Público para sacar. É a "porta" de saída de dinheiro.
    // Ele tem regras para proteger saldo.
    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println("Saque realizado com sucesso. Novo saldo: " + this.saldo);
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }

    // *** ENCAPSULAMENTO AQUI ***
    // Método Público para consutar o saldo.
    // Permite VER o saldo, mas não modificá-lo diferente.


    public double getSaldo() {
        return saldo;
    }

    // Como usar:
    class Main {
        public static void main(String[] args) {
            ContaBancaria minhaConta = new ContaBancaria(100.0);

            // Não podemos fazer isso, pois 'saldo' é privado! O código nem compila.
            // MinhaConta.saldo = -500.0; // X acesso direto bloqueado!

            // Usados oa Métodos públicos (as "portas") para interagir com o objetivo
            minhaConta.depositar(50.0); // ok
            minhaConta.sacar(30.0); // ok
            minhaConta.sacar(200.0); // Saldo insuficiente, a regra protegeu a conta!

            System.out.println("Saldo final " + minhaConta.getSaldo()); // Apenas consuta
        }
    }
}
