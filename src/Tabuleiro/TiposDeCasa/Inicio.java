package Tabuleiro.TiposDeCasa;

import Tabuleiro.Casa;

public class Inicio extends Casa {

    public Inicio(String tipo) {
        this.tipo = tipo;
        this.isInicio = true;
    }

    @Override
    public void executarAcao() {
        // Jogador recebe um salario predefinido
    }
}