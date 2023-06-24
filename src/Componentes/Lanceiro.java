/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public class Lanceiro extends Peça {
    /**
     * Construtor da classe Lanceiro que herda de "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolo Kanji representativo do ouro
     * @param valor Valor do ouro segundo as regras do jogo
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     */
    public Lanceiro(Coordenada coordenada, Jogador jogador, Simbolo[] simbolos, Simbolo simbolo,Valor[] valores, Valor valor, boolean capturada) {
        super(coordenada, jogador, SimboloConj.LANCEIRO.getSimboloConj(), Simbolo.LANCEIRO_N.getSimbolo(), ValorConj.LANCEIRO.getValorConj(), Valor.LANCEIRO_N.getValor(), capturada, false);
    }

    // métodos de get e set

    /**
     * Calcula um vetor subtraindo Pi de Pf
     * Em seguida verifica se ele está na lista de movimentos possíveis da peça, registradas no enum MovimentoConj(index)
     * @return "true" caso a jogada seja possível, e translada a posição da peça para a nova posição
     * @return "false" caso a jogada seja impossível
     */
    public boolean andarPara(Coordenada Pi, Coordenada Pf) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;
            
        switch(estaPromovida){
            case 0: // O quando a peçça não está  promovida
                if (vetor.contemVetorParalelo(Movimento.LANCEIRO_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case 1: // 1 quando a peça está promovida
                if (vetor.estaNaLista(Movimento.LANCEIRO_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
        return false;
    }       

    /**
     * Função para testes
     * @param args
     */
    public static void main(String[] args) {
        Coordenada vetor = new Coordenada(0, 8);
        System.out.println(vetor);
        System.out.println(Movimento.LANCEIRO_N.getMovimentos());
        if (vetor.contemVetorParalelo(Movimento.LANCEIRO_N.getMovimentos())) 
            System.out.println("TRUE!");
        else
            System.out.println("FALSE!");
    }
}
