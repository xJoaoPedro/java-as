package Tabuleiro.TiposDeCasa;

import Jogo.Jogador;
import Tabuleiro.Casa;

public class Prisao extends Casa {

    public Prisao() {
        super("prisao", "Prisão", false);
    }

    @Override
    public void executarAcao(Jogador jogadorAtual) {
        System.out.println("Você parou na prisão!");
        System.out.println("Boa sorte nas próximas rodadas para sair...");
    }
}
