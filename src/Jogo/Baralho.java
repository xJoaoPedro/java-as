package Jogo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Baralho {
    public Stack<Carta> cartas = new Stack<>();
    List<Carta> todasCartas = new ArrayList<>();

    public Baralho() {
        todasCartas.add(new Carta("Ganhe R$500", jogador -> {
            System.out.println("Boa notícia! Você encontrou dinheiro esquecido em uma conta antiga. +R$500!");
            jogador.setSaldo(jogador.getSaldo() + 500);
        }));

        todasCartas.add(new Carta("Perca R$200", jogador -> {
            System.out.println("Que azar! Teve que pagar uma multa inesperada. -R$200.");
            jogador.setSaldo(jogador.getSaldo() - 200);
        }));

        todasCartas.add(new Carta("Vá para o início", jogador -> {
            System.out.println("Volte direto para o início do tabuleiro. Sem passar pela Partida, sem receber R$200!");
            jogador.vaParaOInicio();
        }));

        todasCartas.add(new Carta("Ganhe um turno extra", jogador -> {
            System.out.println("Sortudo! Você jogará novamente.");
            jogador.jogarNovamente();
        }));

        todasCartas.add(new Carta("Vá para a prisão", jogador -> {
            System.out.println("Infelizmente... Você foi preso! Vá direto para a prisão, sem passar pela Partida.");
            jogador.vaParaAPrisao();
        }));

        todasCartas.add(new Carta("Avance 3 casas", jogador -> {
            System.out.println("Avance 3 casas no tabuleiro! Quem sabe o que te espera?");
            jogador.avanceCasas(3);
        }));

        todasCartas.add(new Carta("Volte 2 casas", jogador -> {
            System.out.println("Ops! Volte 2 casas... Espero que não caia numa propriedade cara.");
            jogador.volteCasas(2);
        }));

        todasCartas.add(new Carta("Ganhe R$1000", jogador -> {
            System.out.println("Parabéns! Você venceu um sorteio relâmpago. +R$1.000!");
            jogador.setSaldo(jogador.getSaldo() + 1000);
        }));

        todasCartas.add(new Carta("Nada!", jogador -> {
            System.out.println("Silêncio... Nada acontece. Siga o jogo.");
        }));

        todasCartas.add(new Carta("Receba herança de R$30.000", jogador -> {
            System.out.println("Um parente distante faleceu e te deixou R$30.000 de herança. Sortudo!");
            jogador.setSaldo(jogador.getSaldo() + 30000);
        }));

        todasCartas.add(new Carta("Pague R$150 de imposto", jogador -> {
            System.out.println("Imposto de renda caiu na sua conta. Pague R$150.");
            jogador.setSaldo(jogador.getSaldo() - 150);
        }));

        todasCartas.add(new Carta("Ganhe um turno extra", jogador -> {
            System.out.println("Você tirou a carta dourada! Jogue novamente!");
            jogador.jogarNovamente();
        }));

        todasCartas.add(new Carta("Perde metade do dinheiro", jogador -> {
            System.out.println("Crise no mercado! Você perdeu metade do seu dinheiro.");
            jogador.setSaldo(jogador.getSaldo() / 2);
        }));

        todasCartas.add(new Carta("Multiplique seu dinheiro por 2", jogador -> {
            System.out.println("Investimento milagroso! Seu saldo dobrou!");
            jogador.setSaldo(jogador.getSaldo() * 2);
        }));

        todasCartas.add(new Carta("Perde metade do dinheiro", jogador -> {
            System.out.println("Um golpe financeiro te atingiu em cheio. Metade do seu dinheiro se foi!");
            jogador.setSaldo(jogador.getSaldo() / 2);
        }));

        todasCartas.add(new Carta("Multiplique seu dinheiro por 2", jogador -> {
            System.out.println("Promoção relâmpago! Seu dinheiro foi dobrado pela sorte.");
            jogador.setSaldo(jogador.getSaldo() * 2);
        }));

        cartas.addAll(todasCartas);
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta tirarCarta() {
        if (this.cartas.isEmpty()) {
            cartas.addAll(todasCartas);
            Collections.shuffle(cartas);
        }

        return this.cartas.pop();
    }
}
