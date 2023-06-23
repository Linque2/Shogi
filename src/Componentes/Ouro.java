/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */
package Componentes;

public class Ouro extends Peça{

     /**
     * Construtor da classe Ouro que herda de "Peça"
     * @param coordenada Coordenadas da casa onde a peça está no momento
     * @param jogador Parâmetro que o construtor recebe como o jogador com que a peça está no momento
     * @param simbolo Kanji representativo do ouro
     * @param valor Valor do ouro segundo as regras do jogo
     * @param capturada "true" se a peça foi capturada e está no banco de peças,
     * "false" se a peça não foi capturada e está em jogo
     */
    public Ouro(Coordenada coordenada, Jogador jogador, char simbolo, int valor, boolean capturada) {
        super(coordenada, jogador, SimboloConj.OURO.getSimboloConj(), ValorConj.OURO.getValorConj(), capturada, 0);
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
        if (vetor.estaNaLista(MovimentoConj.OURO.getMovimentos().get(getPromovida()).getMovimentos())) {
            setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
            return true;
        } else
            return false;
    }

    /**
     * Função para testes
     * @param args
     */
    public static void main(String[] args) {
        Coordenada vetor = new Coordenada(0, 1);
        System.out.println(vetor);
        System.out.println(MovimentoConj.OURO.getMovimentos().get(0));
        if (vetor.estaNaLista(MovimentoConj.OURO.getMovimentos().get(0).getMovimentos())) 
            System.out.println("TRUE!");
        else
            System.out.println("FALSE!");
    }


    
    
}
