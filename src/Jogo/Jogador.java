package Jogo;

import Tabuleiro.Casa;
import Tabuleiro.TiposDeCasa.Imovel;

import java.util.ArrayList;

public class Jogador {
    String nome;
    double saldo = 0;
    double salario = 0;
    int rodadasNaPrisao = 0;
    Casa atual = null;
    public ArrayList<Imovel> imoveis = new ArrayList<>();

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSalario() {
        return salario;
    }

    public int getRodadasNaPrisao() {
        return rodadasNaPrisao;
    }

    public void setRodadasNaPrisao(int rodadasNaPrisao) {
        this.rodadasNaPrisao = rodadasNaPrisao;
    }
}
