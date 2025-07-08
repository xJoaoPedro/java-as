package Jogo;

import java.util.function.Consumer;

public class Carta {
    String mensagem;
    Consumer<Jogador> acao;

    public Carta(String mensagem, Consumer<Jogador> acao) {
        this.mensagem = mensagem;
        this.acao = acao;
    }

    public void executarAcao(Jogador jogador) {
        System.out.println("Carta: " + this.mensagem);
        acao.accept(jogador);
    }
}
