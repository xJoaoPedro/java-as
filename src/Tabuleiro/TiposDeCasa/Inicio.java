package Tabuleiro.TiposDeCasa;

import Jogo.Jogador;
import Tabuleiro.Casa;

public class Inicio extends Casa {

    public Inicio() {
        super("inicio", "Início", true);
    }

    @Override
    public void executarAcao(Jogador jogadorAtual) {
        // Jogo.Jogador recebe um salario predefinido
    }

    @Override
    public void verificarInicio(Jogador jogadorAtual) {
        executarAcao(jogadorAtual);
    }
}