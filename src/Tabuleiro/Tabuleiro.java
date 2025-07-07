package Tabuleiro;

import Tabuleiro.TiposDeCasa.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tabuleiro {
    Casa inicio;
    Casa fim;
    List<Casa> casasParaMontar;

    public Tabuleiro() {
        this.inicio = new Inicio();

        this.casasParaMontar = new ArrayList<>(Arrays.asList(
                new Imposto(), new Imposto(),
                new Restituicao(), new Restituicao(),
                new Prisao(), new Prisao(),
                new SorteReves(), new SorteReves(),
                new SorteReves(), new SorteReves(),
                new SorteReves(), new SorteReves()
        ));

        this.fim = null;
    }

    public void montarTabuleiro(ArrayList<Imovel> imoveis) {
        this.casasParaMontar.addAll(imoveis);

        Collections.shuffle(casasParaMontar);

        inicio.proximo = this.casasParaMontar.removeLast();
        this.fim = inicio.proximo;

        while (!this.casasParaMontar.isEmpty()) {
            this.fim.proximo = this.casasParaMontar.removeLast();
            this.fim = this.fim.proximo;
        }

        this.fim.proximo = this.inicio;
    }

    public Casa getInicio() {
        return inicio;
    }
}
