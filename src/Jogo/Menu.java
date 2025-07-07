package Jogo;

import Tabuleiro.Tabuleiro;
import Tabuleiro.TiposDeCasa.Imovel;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    Tabuleiro tabuleiro = new Tabuleiro();
    ArrayList<Imovel> imoveis = new ArrayList<>();
    ArrayList<Jogador> jogadores = new ArrayList<>();
    double saldoInicial;
    double salario;
    int numeroRodadas;
    int rodadaAtual = 0;

    public Menu() {
        this.jogadores.add(new Jogador("Joao"));
        this.jogadores.add(new Jogador("Vini"));

        this.imoveis.add(new Imovel( "Casa do Bosque", 200000.00, 1100.00));
        this.imoveis.add(new Imovel("Apartamento Central", 350000.00, 1800.00));
        this.imoveis.add(new Imovel("Vila das Flores", 400000.00, 2200.00));
        this.imoveis.add(new Imovel("Pousada da Praia", 500000.00, 2700.00));
        this.imoveis.add(new Imovel("Mansão da Colina", 600000.00, 3300.00));
        this.imoveis.add(new Imovel("Residência do Lago", 450000.00, 2500.00));
        this.imoveis.add(new Imovel("Cobertura Diamante", 700000.00, 3700.00));
        this.imoveis.add(new Imovel("Edifício Horizonte", 550000.00, 2900.00));
        this.imoveis.add(new Imovel("Chácara do Sol", 300000.00, 1600.00));
        this.imoveis.add(new Imovel("Fazenda Boa Vista", 250000.00, 1300.00));

        this.saldoInicial = 1000000.00;
        this.salario = 4500.00;
        this.numeroRodadas = 10;
    }

    public void iniciar() {
        while (true) {
            System.out.println("\n");
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
                case 1: {
                    gerenciarJogadores();
                    break;
                }
                case 2: {
                    gerenciarImoveis();
                    break;
                }
                case 3: {
                    definirConfigs();
                    break;
                }
                case 4: {
                    if (validarJogo()) {
                        jogar();
                    }
                    break;
                }
                case 0: {
                    System.out.println("Fechando o programa...");
                    System.exit(0);
                }
            }
        }
    }

    public void gerenciarJogadores() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n\n");
            System.out.println("--- Jogo.Menu de Jogadores ---");
            System.out.println("(Atualmente: " + this.jogadores.size() + "/6 jogadores cadastrados)");
            System.out.println("1. Cadastrar Novo Jogo.Jogador");
            System.out.println("2. Listar Jogadores Cadastrados");
            System.out.println("3. Remover Jogo.Jogador");
            System.out.println("4. Voltar ao Jogo.Menu Principal");
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
                    System.out.println("Jogo.Jogador criado com sucesso!");
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
                    System.out.println("Jogo.Jogador removido com sucesso!");
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
            System.out.println("--- Jogo.Menu de Imóveis ---");
            System.out.println("(Atualmente: " + this.imoveis.size() + "/30 imóveis cadastrados)");
            System.out.println("1. Cadastrar Novo Imóvel");
            System.out.println("2. Listar Imóveis Cadastrados");
            System.out.println("3. Remover Imóvel");
            System.out.println("4. Voltar ao Jogo.Menu Principal");
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
                    this.imoveis.add(new Imovel(nome, precoCompra, precoAluguel));
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
                case 4: {
                    continuar = false;
                    break;
                }
            }
        }
    }

    public void definirConfigs() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n\n");
            System.out.println("--- Configurações da Partida ---");
            System.out.println("1. Definir saldo inicial (Atual: R$ " + this.saldoInicial + ")");
            System.out.println("2. Definir salário por volta (Atual: R$ " + this.salario + ")");
            System.out.println("3. Definir nº máximo de rodadas (Atual: " + this.numeroRodadas + ")");
            System.out.println("4. Voltar ao Jogo.Menu Principal");
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
                    System.out.print("\n>> Digite o valor do saldo inicial dos jogadores: ");
                    this.saldoInicial = scanner.nextDouble();
                    System.out.println("Saldo inicial inserido!");
                    break;
                }
                case 2: {
                    System.out.print("\n>> Digite o valor do salário recebido por volta: ");
                    this.salario = scanner.nextDouble();
                    System.out.println("Salário dos jogadores inserido!");
                    break;
                }
                case 3: {
                    System.out.print("\n>> Digite o numero máximo de rodadas: ");
                    this.numeroRodadas = scanner.nextInt();
                    System.out.println("Numero de rodadas inserido!");
                    break;
                }
                case 4: {
                    continuar = false;
                    break;
                }
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

    public boolean validarJogo() {
        if (this.jogadores.size() < 2) {
            System.out.println("ERRO: O jogo não pode ser iniciado.");
            System.out.println("Motivo: Mínimo de 2 jogadores não alcançado (apenas " + this.jogadores.size() + " jogador).");
            return false;
        }

        if (this.imoveis.size() < 10) {
            System.out.println("ERRO: O jogo não pode ser iniciado.");
            System.out.println("Motivo: Mínimo de 10 imóveis não alcançado (apenas " + this.imoveis.size() + " cadastrados).");
            return false;
        }

        if (this.saldoInicial == 0) {
            System.out.println("ERRO: O jogo não pode ser iniciado.");
            System.out.println("Motivo: O saldo inicial não foi definido.");
            return false;
        }

        if (this.salario == 0) {
            System.out.println("ERRO: O jogo não pode ser iniciado.");
            System.out.println("Motivo: O salário não foi deifinido.");
            return false;
        }

        if (this.numeroRodadas == 0) {
            System.out.println("ERRO: O jogo não pode ser iniciado.");
            System.out.println("Motivo: O número de rodadas não foi deifinido.");
            return false;
        }

        System.out.println("Tudo pronto! iniciando jogo...");
        return true;
    }

    public void desistir(Jogador jogadorAtual) {
        this.jogadores.remove(jogadorAtual);
        // TODO REMOVER A POSSE DOS IMOVEIS DO JOGADOR Q SAIU
        System.out.println("Você desistiu do jogo, até mais!");
    }

    public void jogar() {
        tabuleiro.montarTabuleiro(this.imoveis);

        this.jogadores.forEach(jogador -> {
            jogador.atual = this.tabuleiro.getInicio();
            jogador.saldo = this.saldoInicial;
            jogador.salario = this.salario;
        });

        while (this.rodadaAtual < this.numeroRodadas) {
            this.rodadaAtual++;

            this.jogadores.forEach(jogadorAtual -> {
                if (jogadorAtual.getRodadasNaPrisao() > 3) {
//                     TODO VERIFICAR SE È A 3 RODADA E TIRAR DA PRISAO E FAZER A PARTE DO SORTE/REVES
                }
                if (Objects.equals(jogadorAtual.atual.getTipo(), "prisao")) {
                    jogadorAtual.setRodadasNaPrisao(jogadorAtual.getRodadasNaPrisao() + 1);

                    System.out.println("=========================================");
                    System.out.println("=== RODADA " + this.rodadaAtual + " / " + this.numeroRodadas + " - VEZ DE: " + jogadorAtual.getNome() + " (NA PRISÃO) ===");
                    System.out.println("=========================================");
                    System.out.println("Você está na prisão! (" + jogadorAtual.getRodadasNaPrisao() + "ª de 3 tentativas para sair)");
                    System.out.println("\n>> Pressione enter para rolar os dados e tentar sair");
                    scanner.nextLine();

                    int dado1 = random.nextInt(6) + 1;
                    int dado2 = random.nextInt(6) + 1;


                    if (dado1 == dado2) {
                        jogadorAtual.setRodadasNaPrisao(0);
                        System.out.println(dado1 + " e " + dado2 + "! Você está livre! Avance " + (dado1 + dado2) + " casas!");

                        for (int i = 0; i < (dado1 + dado2); i++) {
                            jogadorAtual.atual = jogadorAtual.atual.getProximo();
                            jogadorAtual.atual.verificarInicio(jogadorAtual);
                        }
                        jogadorAtual.atual.executarAcao(jogadorAtual);
                    } else {
                        System.out.println ("Você tirou " + dado1 + " e " + dado2 + ". Não são duplos.");
                        System.out.println("Você permanece na prisão.");
                        System.out.println("Pressione Enter para finalizar o turno...");
                        scanner.nextLine();
                    }
                } else {
                    System.out.println("=========================================");
                    System.out.println("=== RODADA " + this.rodadaAtual + " / " + this.numeroRodadas + " - VEZ DE: " + jogadorAtual.nome + "       ===");
                    System.out.println("=========================================");
                    System.out.println("Posição Atual: " + jogadorAtual.atual.getNome());
                    System.out.println("Saldo: R$ " + jogadorAtual.saldo);
                    System.out.println("\n--- O que você deseja fazer? ---");
                    System.out.println("1. Lançar Dados e Mover");
                    System.out.println("2. Ver Meu Status Completo (Saldo e Propriedades)");
                    System.out.println("3. Desistir do Jogo");
                    System.out.print("\n>> Escolha uma opção: ");

                    int opcao = this.scanner.nextInt();
                    scanner.nextLine();
                    while (opcao < 1 || opcao > 3) {
                        System.out.println("Opção inválida, digite uma opção entre 1-3");
                        opcao = this.scanner.nextInt();
                        scanner.nextLine();
                    }

                    switch (opcao) {
                        case 1: {
                            int dado1 = random.nextInt(6) + 1;
                            int dado2 = random.nextInt(6) + 1;

                            System.out.println("Você tirou " + dado1 + " e " + dado2 + ". Total: " + (dado1 + dado2) + ".");
                            System.out.println("Avançando " + (dado1 + dado2) + " casas...");

                            for (int i = 0; i < (dado1 + dado2); i++) {
                                jogadorAtual.atual = jogadorAtual.atual.getProximo();
                                jogadorAtual.atual.verificarInicio(jogadorAtual);
                            }
                            jogadorAtual.atual.executarAcao(jogadorAtual);
                            break;
                        }
                        case 3: {
                            desistir(jogadorAtual);
                            break;
                        }
                    }
                }
            });
        }
    }
}
