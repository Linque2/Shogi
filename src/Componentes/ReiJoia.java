/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ReiJoia extends Peça{
     /**
     * Construtor da classe ReiJoia que herda de "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolo Kanji representativo do ReiJoia
     * @param valor Valor do ReiJoia segundo as regras do jogo
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     */
    public ReiJoia(int x, int y, JogadorOushou jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.REI_JOIA.getSimboloConj(), Simbolo.REI_JOIA.getSimbolo(), ValorConj.REI_JOIA.getValorConj(), Valor.REI_JOIA.getValor(), capturada, false,"Images/ReiJoia.png", "Images/ReiJoia.png", tabuleiro);
        
    }

    /* public boolean andarPara(Coordenada Pi, Coordenada Pf, Tabuleiro tabuleiro) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        if (vetor.estaNaLista(Movimento.REI_JOIA.getMovimentos())) {
            setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
            return true;
        } else
            return false;
    } */

    public ArrayList<Coordenada> podeAndar() {
        ArrayList<Coordenada> jogadasPossíveis = new ArrayList<Coordenada>();
        for (Coordenada coordenada : Movimento.REI_JOIA.getMovimentos()) {
            Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
            if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
        }

        return jogadasPossíveis;
    }


    @Override
    /**
     * @return O método retorna sempre "false", pois o ReiJoia não possui promoção
     */
    public boolean promoverPeça() {
        return false;
    }

    @Override
    /**
     * @return O método retorna sempre "false", pois como o ReiJoia não pode ser promovido, ele também não pode ser despromovido
     */
    public boolean despromoverPeça() {
        return false;
    }
    
}
