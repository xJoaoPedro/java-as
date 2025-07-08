package Tabuleiro.TiposDeCasa;

import Jogo.Jogador;
import Tabuleiro.Casa;

import java.util.Scanner;

public class Imovel extends Casa {
    Scanner scanner = new Scanner(System.in);

    Jogador proprietario = null;
    double precoCompra;
    double precoAluguel;

    public Imovel(String nome, double precoCompra, double precoAluguel) {
        super("imovel", nome, false);
        this.precoCompra = precoCompra;
        this.precoAluguel = precoAluguel;
    }

    @Override
    public void executarAcao(Jogador jogador) {
        System.out.println("Você parou em: '" + this.nome + "'.");

        if (this.proprietario == null) {
            System.out.println("Este imóvel não tem proprietário.");
            System.out.println("Preço de Compra: R$ " + this.precoCompra);
            System.out.println("Valor do aluguel: R$ " + this.precoAluguel);
            System.out.println("--- O que você deseja fazer? ---");
            System.out.println("1. Comprar Imóvel");
            System.out.println("2. Passar a vez");
            System.out.print("\n>> Escolha uma opção: ");

            int opcao = this.scanner.nextInt();
            scanner.nextLine();

            while (opcao < 1 || opcao > 2) {
                System.out.println("Opção inválida, digite uma opção entre 1-2");
                opcao = this.scanner.nextInt();
                scanner.nextLine();
            }

            switch (opcao) {
                case 1: {
                    if (jogador.getSaldo() >= this.precoCompra) {
                        jogador.setSaldo(jogador.getSaldo() - this.precoCompra);
                        this.proprietario = jogador;
                        jogador.imoveis.add(this);

                        System.out.println("Parabéns! Você comprou '" + this.nome + "' por R$ " + this.precoCompra + ".");
                        System.out.println("Seu novo saldo é: R$ " + jogador.getSaldo());
                        System.out.println("Pressione enter para finalizar o turno...");
                        scanner.nextLine();
                    } else {
                        System.out.println("Seu saldo é insuficiente para comprar este imóvel.");
                        System.out.println("Pressione enter para finalizar o turno...");
                        scanner.nextLine();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Você pulou a vez, continuando...");
                    break;
                }
            }

        } else {
            System.out.println("Este imóvel pertence a " + this.proprietario.getNome());
            System.out.println("Pagando o aluguel de " + this.precoAluguel + "...");

            jogador.setSaldo(jogador.getSaldo() - this.precoAluguel);
            this.proprietario.setSaldo(this.proprietario.getSaldo() + this.precoAluguel);

            System.out.println("Seu novo saldo: R$ " + jogador.getSaldo());
            System.out.println("Pressione enter para continuar...");
            scanner.nextLine();
        }
    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void removerProprietario() {
        this.proprietario = null;
    }
}
