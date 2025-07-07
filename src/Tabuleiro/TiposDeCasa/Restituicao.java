package Tabuleiro.TiposDeCasa;

import Jogo.Jogador;
import Tabuleiro.Casa;

import java.util.Scanner;

public class Restituicao extends Casa {
    Scanner scanner = new Scanner(System.in);

    public Restituicao() {
        super("restituicao", "Restituição", false);
    }

    @Override
    public void executarAcao(Jogador jogadorAtual) {
        System.out.println("Você parou em uma casa de Restituição, e irá receber 10% do seu salário!");

        jogadorAtual.setSaldo(jogadorAtual.getSaldo() + (jogadorAtual.getSalario() * 0.1));

        System.out.println("Seu saldo atual: R$ " + jogadorAtual.getSaldo());
        System.out.println("Pressione enter para continuar...");
        scanner.nextLine();
    }
}
