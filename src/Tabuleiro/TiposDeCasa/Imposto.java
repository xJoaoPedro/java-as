package Tabuleiro.TiposDeCasa;

import Jogo.Jogador;
import Tabuleiro.Casa;

public class Imposto extends Casa {

    public Imposto() {
        super("imposto", "Casa de imposto", false);
    }

    @Override
    public void executarAcao(Jogador jogadorAtual) {
        // Ao parar nesta casa, o jogador deve pagar ao "banco" uma taxa de 5% sobre seu patrimônio total (saldo + valor dos imóveis).
    }
}
