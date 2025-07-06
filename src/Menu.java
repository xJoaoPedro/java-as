import Tabuleiro.TiposDeCasa.Imovel;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    ArrayList<Imovel> imoveis = new ArrayList<>();
    ArrayList<Jogador> jogadores = new ArrayList<>();

    public void iniciar() {
        while (true) {
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
            scanner.nextLine();

            while (opcao < 0 || opcao > 4) {
                System.out.println("Opção inválida. digite uma opção entre 0-4");
                opcao = scanner.nextInt();
                scanner.nextLine();
            }

            switch (opcao) {
                case 1:
                    gerenciarJogadores();
                    break;
                case 2:
                    gerenciarImoveis();
                    break;
                case 3:
                    // definirConfigs();
                    break;
                case 4:
                    // TODO COMPLETAR ESSA LOGICA
                    // if (this.jogadores.size() < 2 || // continuar a logica aqui)

                case 0:
                    System.out.println("Fechando o programa...");
                    System.exit(0);
            }
        }
    }

    public void gerenciarJogadores() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n\n");
            System.out.println("--- Menu de Jogadores ---");
            System.out.println("(Atualmente: " + this.jogadores.size() + "/6 jogadores cadastrados)");
            System.out.println("1. Cadastrar Novo Jogador");
            System.out.println("2. Listar Jogadores Cadastrados");
            System.out.println("3. Remover Jogador");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("\n>> Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            while (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida. digite uma opção entre 1-4");
                opcao = scanner.nextInt();
                scanner.nextLine();
            }

            switch (opcao) {
                case 1: {
                    System.out.print("\n>> Digite o nome do novo jogador: ");
                    String nome = scanner.next();
                    this.jogadores.add(new Jogador(nome));
                    System.out.println("Jogador criado com sucesso!");
                    break;
                }
                case 2: {
                    printarJogadores();
                    break;
                }
                case 3: {
                    printarJogadores();
                    System.out.print(">> Digite o ID do jogador que deseja remover: ");
                    int opcao2 = this.scanner.nextInt();
                    while (opcao2 < 0 || opcao2 > this.jogadores.size() - 1) {
                        System.out.println("ID inválido, favor digitar um novo ID");
                        opcao2 = this.scanner.nextInt();
                    }
                    this.jogadores.remove(opcao2);
                    System.out.println("Jogador removido com sucesso!");
                    break;
                }
                case 4: {
                    continuar = false;
                    break;
                }
            }
        }
    }

    public void gerenciarImoveis() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n\n");
            System.out.println("--- Menu de Imóveis ---");
            System.out.println("(Atualmente: " + this.imoveis.size() + "/40 imóveis cadastrados)");
            System.out.println("1. Cadastrar Novo Imóvel");
            System.out.println("2. Listar Imóveis Cadastrados");
            System.out.println("3. Remover Imóvel");
            System.out.println("4. Voltar ao Menu Principal");
            System.out.print("\n>> Escolha uma opção: ");

            int opcao = this.scanner.nextInt();
            scanner.nextLine();

            while (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida, escolha entre 1-4");
                opcao = this.scanner.nextInt();
                scanner.nextLine();
            }

            switch (opcao) {
                case 1: {
                    System.out.print("\n>> Digite o nome do novo imóvel: ");
                    String nome = scanner.nextLine();
                    System.out.print("\n>> Digite o preço de compra de " + nome + ": ");
                    double precoCompra = scanner.nextDouble();
                    System.out.print("\n>> Digite o preço de aluguel de " + nome + ": ");
                    double precoAluguel = scanner.nextDouble();
                    scanner.nextLine();
                    this.imoveis.add(new Imovel("imovel", nome, precoCompra, precoAluguel));
                    System.out.println("Imóvel criado com sucesso!");
                    break;
                }
                case 2: {
                    printarImoveis();
                    break;
                }
                case 3: {
                    printarImoveis();
                    System.out.print(">> Digite o ID do imóvel que deseja remover: ");
                    int opcao2 = this.scanner.nextInt();
                    while (opcao2 < 0 || opcao2 > this.imoveis.size() - 1) {
                        System.out.println("ID inválido, favor digitar um novo ID");
                        opcao2 = this.scanner.nextInt();
                    }
                    this.imoveis.remove(opcao2);
                    System.out.println("Imóvel removido com sucesso!");
                    break;
                }
                case 4:
                    continuar = false;
                    break;
            }
        }
    }

    public void printarJogadores() {
        System.out.println("--- Jogadores cadastrados ---");
        for (int i = 0; i < this.jogadores.size(); i++) {
            Jogador jogador = this.jogadores.get(i);
            System.out.println(i + ". " + jogador.nome + " - Saldo: " + jogador.saldo);
        }
    }

    public void printarImoveis() {
        System.out.println("--- Imóveis Cadastrados ---");
        for (int i = 0; i < this.imoveis.size(); i++) {
            Imovel imovel = this.imoveis.get(i);
            System.out.println(i + ". " + imovel.getNome() + " - Preço: R$ " + imovel.getPrecoCompra() + " - Aluguel: R$ " + imovel.getPrecoAluguel());
        }
    }
}
