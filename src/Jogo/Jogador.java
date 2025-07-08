package Jogo;

import Tabuleiro.Casa;
import Tabuleiro.TiposDeCasa.Imovel;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Jogador {
    Random random = new Random();

    String nome;
    double saldo = 0;
    double salario = 0;
    int rodadasNaPrisao = 0;
    Casa atual = null;
    boolean desistiu = false;
    public ArrayList<Imovel> imoveis = new ArrayList<>();

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void vaParaOInicio() {
        while (!Objects.equals(atual.getTipo(), "inicio")) {
            atual = atual.getProximo();
        }
    }

    public void vaParaAPrisao() {
        while (!Objects.equals(atual.getTipo(), "prisao")) {
            atual = atual.getProximo();
        }
    }

    public void avanceCasas(int casas) {
        for (int i = 0; i < casas; i++) {
            this.atual = this.atual.getProximo();
        }
        this.atual.executarAcao(this);
    }

    public void volteCasas(int casas) {
        for (int i = 0; i > casas; i--) {
            this.atual = this.atual.getAnterior();
        }
        this.atual.executarAcao(this);
    }

    public void jogarNovamente() {
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;

        System.out.println("Você tirou " + dado1 + " e " + dado2 + ". Total: " + (dado1 + dado2) + ".");
        System.out.println("Avançando " + (dado1 + dado2) + " casas...");

        for (int i = 0; i < (dado1 + dado2); i++) {
            this.atual = this.atual.getProximo();
            this.atual.verificarInicio(this);
        }
        this.atual.executarAcao(this);
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
