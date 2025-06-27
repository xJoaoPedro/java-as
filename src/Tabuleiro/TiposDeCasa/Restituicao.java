package Tabuleiro.TiposDeCasa;

import Tabuleiro.Casa;

public class Restituicao extends Casa {

    public Restituicao(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void executarAcao() {
        // Ao parar nesta casa, o jogador recebe do "banco" uma restituição equivalente a 10% do valor do seu salário.
    }
}
