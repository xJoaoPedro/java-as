package Tabuleiro.TiposDeCasa;

import Tabuleiro.Casa;

public class Imovel extends Casa {

    String nome;
    String nomeJogador = null;
    double precoCompra;
    double precoAluguel;

    public Imovel(String tipo, String nome, double precoCompra, double precoAluguel) {
        this.tipo = tipo;
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoAluguel = precoAluguel;
    }

    @Override
    public void executarAcao() {
        // Propriedade que pode ser comprada por um jogador. Se um jogador parar em um imóvel que já possui um dono,
        // ele deve pagar o aluguel correspondente.

    }
}
