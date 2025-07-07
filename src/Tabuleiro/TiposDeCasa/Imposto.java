package Tabuleiro.TiposDeCasa;

import Jogo.Jogador;
import Tabuleiro.Casa;

import java.util.Scanner;

public class Imposto extends Casa {
    Scanner scanner = new Scanner(System.in);

    public Imposto() {
        super("imposto", "Casa de imposto", false);
    }

    @Override
    public void executarAcao(Jogador jogadorAtual) {
        System.out.println("Você parou em uma casa de imposto!");

        double total = jogadorAtual.getSaldo();

        for (int i = 0; i < jogadorAtual.imoveis.size(); i++) {
            total += jogadorAtual.imoveis.get(i).precoCompra;
        }

        jogadorAtual.setSaldo(jogadorAtual.getSaldo() - (total * 0.05));

        System.out.println("Você pagou ao banco: R$ " + (total * 0.05));
        System.out.println("Seu saldo atual: R$ " + jogadorAtual.getSaldo());
        System.out.println("Pressione enter para continuar...");
        scanner.nextLine();
    }
}
