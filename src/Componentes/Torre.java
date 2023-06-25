/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */
package Componentes;

public class Torre extends Peça{

    public Torre(int x, int y,Jogador jogador, Simbolo[] simbolos, char simbolo, Valor[] valores, int valor, boolean capturada) {
        super(x, y, jogador, SimboloConj.TORRE.getSimboloConj(), Simbolo.TORRE_N.getSimbolo() , ValorConj.TORRE.getValorConj() ,Valor.TORRE_N.getValor(), capturada, false, "Images/Torre.png", "Images/Torre_P.png");
    };

    public boolean andarPara(Coordenada Pi, Coordenada Pf) {
        Coordenada vetor = Coordenada.calculaVetor(Pi, Pf);
        int estaPromovida;
        if (getPromovida() == true)
            estaPromovida = 1;
        else
            estaPromovida = 0;
            
        switch(estaPromovida){
            case 1: // 1 quando a peça está promovida
                if (vetor.estaNaLista(Movimento.TORRE_P.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
            case 2: // O quando a peça não está  promovida
                if (vetor.contemVetorParalelo(Movimento.TORRE_N.getMovimentos())) {
                    setCoordenada(Coordenada.transladarCoordenada(getCoordenada(), vetor));
                    return true;
                } else
                    return false;
        }
        return false; 
    }
    
}
