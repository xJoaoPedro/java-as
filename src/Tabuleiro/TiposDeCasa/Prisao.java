package Tabuleiro.TiposDeCasa;

import Tabuleiro.Casa;

public class Prisao extends Casa {

    public Prisao(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void executarAcao() {
//        Um jogador enviado para a casa "Prisão" permanece lá por no máximo 3 rodadas, com sua jogada alterada.Em cada
//        uma dessas rodadas, o jogador deve tentar sair seguindo a regra:
//        Sucesso:
//        Se obtiver um resultado de dados duplos(números iguais), ele é libertado imediatamente.O jogador então avança
//        no tabuleiro o número de casas correspondente à soma dos dados.
//                Falha:Se não obtiver dados duplos, ele permanece na prisão e passa a vez.Se esta for sua terceira
//        tentativa e ele falhar novamente, ele é libertado, mas só poderá jogar normalmente no seu próximo turno.
    }
}
