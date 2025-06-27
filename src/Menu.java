import Tabuleiro.TiposDeCasa.Imovel;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Imovel> imoveis = new ArrayList<>();
    ArrayList<Jogador> jogadores = new ArrayList<>();

    public void iniciar() {
        System.out.println("=========================================");
        System.out.println("=== SIMULADOR DE JOGO DE TABULEIRO    ===");
        System.out.println("=========================================");

        System.out.println("Seja bem-vindo! Antes de começar, vamos configurar a partida.");
        System.out.println("--- MENU DE CONFIGURAÇÃO ---");
        System.out.println("1. Gerenciar Jogadores");
        System.out.println("2. Gerenciar Imóveis");
        System.out.println("3. Definir Configurações da Partida");
        System.out.println("4. Iniciar Jogo");
        System.out.println("0. Sair do Programa");
        System.out.print("\n>> Escolha uma opção: ");

        int opcao = scanner.nextInt();

        while (opcao < 0 || opcao > 4) {
            System.out.println("Opção inválida. digite uma opção entre 0-4");
            opcao = scanner.nextInt();
        }

        switch (opcao) {
            case 1:
                gerenciarJogadores();
                break;
            case 0:
                System.out.println("Fechando o programa...");
                System.exit(0);
        }
    }

    public void gerenciarJogadores() {
        System.out.println("\n\n");
        System.out.println("--- Menu de Jogadores ---");
        System.out.println("(Atualmente: " + this.jogadores.size() + "/6 jogadores cadastrados)");
        System.out.println("1. Cadastrar Novo Jogador");
        System.out.println("2. Listar Jogadores Cadastrados");
        System.out.println("3. Remover Jogador");
        System.out.println("4. Voltar ao Menu Principal");
        System.out.print("\n>> Escolha uma opção: ");

        int opcao = scanner.nextInt();

        while (opcao < 1 || opcao > 4) {
            System.out.println("Opção inválida. digite uma opção entre 1-4");
            opcao = scanner.nextInt();
        }

        switch (opcao) {
            case 1: {
                System.out.print("\n>> Digite o nome do novo jogador: ");
                String nome = scanner.next();
                this.jogadores.add(new Jogador(nome));
                break;
            }
            case 2: {
                printarJogadores();
                break;
            }
            case 3: {
                printarJogadores();
                break;
            }
            case 4: {

            }
        }


    }

    public void printarJogadores() {
        for (int i = 0; i < this.jogadores.size(); i++) {
            Jogador jogador = this.jogadores.get(i);
            System.out.println(i + ". " + jogador.nome + " - Saldo: " + jogador.saldo);
        }
    }
}
