package main;

import java.util.ArrayList;
import model.Pessoa;
import model.Conta;

import javax.swing.*;

public class AgenciaBancaria {
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {
        int operacao =
                Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operação --- " +
                    "|   Opção 1 - Criar conta "+
                    "|   Opção 2 - Depositar "+
                    "|   Opção 3 - Sacar   "+
                    "|   Opção 4 - Transferir "+
                    "|   Opção 5 - Listar" +
                    "|   Opção 6 - Sair |"));


        switch (operacao) {
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
                transferir();
                break;

            case 5:
                listarContas();
                break;

            case 6:
                JOptionPane.showInputDialog(null, "Obrigado por usar nossa agência");
                System.exit(0);

            default:
                JOptionPane.showInputDialog("Opção inválida!");
                operacoes();
                break;
        }
    }

    public static void criarConta() {
        Pessoa pessoa = new Pessoa();

        pessoa.setName(JOptionPane.showInputDialog("Nome: "));

        pessoa.setCpf(JOptionPane.showInputDialog("Cpf: "));

        pessoa.setEmail(JOptionPane.showInputDialog("Email: "));


        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        JOptionPane.showInputDialog(null, "--- Sua conta foi criada com sucesso! ---");
        operacoes();

    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumeroConta() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        int numeroConta =
                Integer.parseInt(JOptionPane.showInputDialog(" Número da conta para depósito: "));
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            Double valorDeposito =
                    Double.parseDouble(JOptionPane.showInputDialog(" Qual valor deseja depositar:  "));
            conta.depositar(valorDeposito);
            JOptionPane.showInputDialog(null, "Valor depositado com sucesso!");
        }else{
            JOptionPane.showInputDialog("--- Conta não encontrada ---");
        }
        operacoes();
    }

    public static void sacar() {
        int numeroConta =
                Integer.parseInt(JOptionPane.showInputDialog("Número da conta para saque: "));
        Conta conta = encontrarConta(numeroConta);
        if(conta != null) {
            Double valorSaque =
                    Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar? "));
            conta.sacar(valorSaque);
        }else {
            JOptionPane.showInputDialog("--- Conta não encontrada ---");
        }
        operacoes();
    }

    public static void transferir() {
        int numeroContaRemetente =
                Integer.parseInt(JOptionPane.showInputDialog("Número da conta do remetente: "));
        Conta contaRemetente = encontrarConta(numeroContaRemetente);
        if(contaRemetente != null) {
            int numeroContaDestinatario =
                    Integer.parseInt(JOptionPane.showInputDialog("Número da conta do destinatário: "));
            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
            if(contaDestinatario != null) {
                Double valor =
                        Double.parseDouble(JOptionPane.showInputDialog("Qual valor da transaferência: "));
                contaRemetente.transferencia(contaDestinatario, valor);
            }else{
                JOptionPane.showInputDialog("--- A conta para depósito não foi encontrada ---");
            }
        }else{
            JOptionPane.showInputDialog("--- Conta para transferência não encontrada ---");
        }
        operacoes();
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                JOptionPane.showInputDialog(null, conta);
            }
        }else{
            JOptionPane.showInputDialog(null, "--- Não há contas cadastradas ---");
        }
        operacoes();
    }
}