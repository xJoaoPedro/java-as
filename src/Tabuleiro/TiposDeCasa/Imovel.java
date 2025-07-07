package Tabuleiro.TiposDeCasa;

import Jogo.Jogador;
import Tabuleiro.Casa;

public class Imovel extends Casa {
    String nomeJogador = null;
    double precoCompra;
    double precoAluguel;

    public Imovel(String nome, double precoCompra, double precoAluguel) {
        super("imovel", nome, false);
        this.precoCompra = precoCompra;
        this.precoAluguel = precoAluguel;
    }

    @Override
    public void executarAcao(Jogador jogador) {
        // Propriedade que pode ser comprada por um jogador. Se um jogador parar em um imóvel que já possui um dono,
        // ele deve pagar o aluguel correspondente.

    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }
}
