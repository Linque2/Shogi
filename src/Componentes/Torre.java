/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */
package Componentes;

public class Torre extends Peça{

    public Torre(Coordenada coordenada, Jogador jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada) {
        super(coordenada, jogador, SimboloConj.TORRE.getSimboloConj(), Simbolo.TORRE_N.getSimbolo() , Valor.TORRE_N.getValor(), capturada, false);
    };

    public boolean andarPara(Coordenada Pi, Coordenada Pf) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        switch(getPromovida()){
            case true: // 1 quando a peça está promovida
                if (vetor.estaNaLista(Movimento.TORRE_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case false: // O quando a peça não está  promovida
                if (vetor.contemVetorParalelo(Movimento.TORRE_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
        return false; 
    }
    
    boolean promovida;
    
}
