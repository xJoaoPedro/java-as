package Tabuleiro.TiposDeCasa;

import Jogo.Jogador;
import Tabuleiro.Casa;

public class Restituicao extends Casa {

    public Restituicao() {
        super("restituicao", "Restituição", false);
    }

    @Override
    public void executarAcao(Jogador jogadorAtual) {
        // Ao parar nesta casa, o jogador recebe do "banco" uma restituição equivalente a 10% do valor do seu salário.
    }
}
