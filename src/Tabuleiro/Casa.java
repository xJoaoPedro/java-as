package Tabuleiro;

import Jogo.Jogador;

public class Casa {
    protected String tipo;
    protected String nome;
    protected Casa proximo;
    protected Casa anterior;
    protected boolean isInicio;

    public Casa(String tipo, String nome, boolean isInicio) {
        this.tipo = tipo;
        this.nome = nome;
        this.proximo = null;
        this.anterior = null;
        this.isInicio = isInicio;
    }

    public void executarAcao(Jogador jogadorAtual) {};

    public void verificarInicio(Jogador jogadorAtual) {};

    public String getNome() {
        return nome;
    }

    public Casa getProximo() {
        return proximo;
    }

    public Casa getAnterior() {
        return anterior;
    }

    public String getTipo() {
        return tipo;
    }
}