package Tabuleiro.TiposDeCasa;

import Jogo.Jogador;
import Tabuleiro.Casa;

import java.util.Scanner;

public class Inicio extends Casa {
    Scanner scanner = new Scanner(System.in);

    public Inicio() {
        super("inicio", "Início", true);
    }

    @Override
    public void executarAcao(Jogador jogadorAtual) {
        System.out.println("Você passou pelo início, hora de receber seu salário de R$ " + jogadorAtual.getSalario());
        jogadorAtual.setSaldo(jogadorAtual.getSaldo() + jogadorAtual.getSalario());

        System.out.println("Seu saldo atual: R$ " + jogadorAtual.getSaldo());
        System.out.println("Pressione enter para continuar andando...");
        scanner.nextLine();
    }

    @Override
    public void verificarInicio(Jogador jogadorAtual) {
        executarAcao(jogadorAtual);
    }
}