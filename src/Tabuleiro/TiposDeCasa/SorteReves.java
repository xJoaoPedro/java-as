package Tabuleiro.TiposDeCasa;

import Jogo.Baralho;
import Jogo.Carta;
import Jogo.Jogador;
import Tabuleiro.Casa;

public class SorteReves extends Casa {
    Baralho baralho;

    public SorteReves(Baralho baralho) {
        super("sortereves", "Sorte / Revés", false);
        this.baralho = baralho;
    }

    @Override
    public void executarAcao(Jogador jogadorAtual) {
        System.out.println("Você caiu em uma casa de Sorte / Revés!");
        System.out.println("Tirando carta...");
        Carta carta = baralho.tirarCarta();
        carta.executarAcao(jogadorAtual);
    }
}
