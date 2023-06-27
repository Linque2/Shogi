/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;
import javax.swing.ImageIcon;
import java.util.ArrayList;


public class Rei extends Peça{
     /**
     * Construtor da classe Rei que herda de "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolo Kanji representativo do Rei
     * @param valor Valor do Rei segundo as regras do jogo
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     */
    public Rei(int x, int y, Jogador jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada, Tabuleiro tabuleiro) {
        super(x, y, jogador, SimboloConj.REI.getSimboloConj(), Simbolo.REI.getSimbolo(), ValorConj.REI.getValorConj(),Valor.REI.getValor(), capturada, false, "Images/Rei.png", "Images/Rei.png", tabuleiro);
    }

    /* public boolean andarPara(Coordenada Pi, Coordenada Pf, Tabuleiro tabuleiro) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        if (vetor.estaNaLista(Movimento.REI.getMovimentos())) {
            setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
            return true;
        } else
            return false;
    } */

    public ArrayList<Coordenada> podeAndar() {
        ArrayList<Coordenada> jogadasPossíveis = new ArrayList<Coordenada>();
        for (Coordenada coordenada : Movimento.REI.getMovimentos()) {
            Coordenada posiçãoFinal = Coordenada.transladarCoordenada(getCoordenada(), coordenada);
            if (getTabuleiro().estaNoTabuleiro(posiçãoFinal))
                if (!(getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()] != null && getTabuleiro().getGrid()[posiçãoFinal.getC_x()][posiçãoFinal.getC_y()].getJogador().equals(getJogador())))
                jogadasPossíveis.add(Coordenada.transladarCoordenada(getCoordenada(), coordenada));
        }

        return jogadasPossíveis;
    }

    @Override
    /**
     * @return O método retorna sempre "false", pois o Rei não possui promoção
     */
    public boolean promoverPeça() {
        return false;
    }

    @Override
    /**
     * @return O método retorna sempre "false", pois como o Rei não pode ser promovido, ele também não pode ser despromovido
     */
    public boolean despromoverPeça() {
        return false;
    }

    public void atualizarImagem() {
        getListImageIcon().clear();
        if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/ImagensInvertidas/Rei.png"));
        } else if (getJogador() instanceof JogadorGyokushou) {
            getListImageIcon().add(new ImageIcon("src/Images/Rei.png"));
        }
    } 

    

}
