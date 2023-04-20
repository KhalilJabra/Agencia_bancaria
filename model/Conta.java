package model;

import utils.Utils;

import javax.swing.*;

public class Conta {
    private static int accountCounter = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;


    public Conta(Pessoa pessoa) {
        this.numeroConta = Conta.accountCounter;
        this.pessoa = pessoa;
        this.updateSaldo();
        Conta.accountCounter += 1;
    }


    public int getNumeroConta() {
        return numeroConta;
    }
    public Pessoa getClient() {
        return pessoa;
    }
    public void setClient(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private void updateSaldo() {
        this.saldo = this.getSaldo();
    }

    public String toString() {

        return "\nBank account: " + this.getNumeroConta() +
                "\nCliente: " + this.pessoa.getName() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n" ;
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showInputDialog(null, "Seu depósito foi realizado com sucesso!");
        }else{
            JOptionPane.showInputDialog(null, "Não foi possivel realizar o depósito!");
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            JOptionPane.showInputDialog(null,"Saque realizado com sucesso!");
        }else{
            JOptionPane.showInputDialog(null, "Não foi possível realizar o saque!");
        }
    }

    public void transferencia(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showInputDialog(null, "Transferência realizada com sucesso!");
        }else{
            JOptionPane.showInputDialog(null, "Não foi possível realizar a tranferência");
        }

    }
}