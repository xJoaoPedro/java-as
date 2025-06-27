package Tabuleiro.TiposDeCasa;

import Tabuleiro.Casa;

public class Imposto extends Casa {

    public Imposto(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void executarAcao() {
        // Ao parar nesta casa, o jogador deve pagar ao "banco" uma taxa de 5% sobre seu patrimônio total (saldo + valor dos imóveis).
    }
}
