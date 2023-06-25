package Componentes;

import java.util.*;
import java.io.*;

public class Coordenada implements Serializable {
	private static final long serialVersionUID = 441L;
	private int c_x;
    private int c_y;

    /**
     * @param c_x coordenada no eixo x
     * @param c_y coordenada no eixo y
     */
    public Coordenada(int c_x, int c_y) {
        this.c_x = c_x;
        this.c_y = c_y;
    }

    //métodos de get e set

    /**
     * @return coordenada do ponto em relação a x
     */
    public int getC_x() {
        return this.c_x;
    }

    /**
     * @param c_x é a nova coordenada do ponto em relação a x
     */
    public void setC_x(int c_x) {
        this.c_x = c_x;
    }

    /**
     * @return coordenada do ponto em relação a y
     */
    public int getC_y() {
        return this.c_y;
    }

    /**
     * @param c_y é a nova coordenada do ponto em relação a y
     */
    public void setC_y(int c_y) {
        this.c_y = c_y;
    }

    //demais métodos

    /**
     * @param Pi é o ponto inicial
     * @param Pf é o ponto final
     * @return Vetor deslocamento entre os dois pontos
     */
    public static Coordenada calculaVetor(Coordenada Pi, Coordenada Pf) {
        int v_x = Pf.getC_x() - Pi.getC_x();
        int v_y = Pf.getC_y() - Pi.getC_y();
        Coordenada vetor = new Coordenada(v_x, v_y);
        return vetor;
    }

    /**
     * Translada um ponto segundo o é colocado como parẫmetro
     * @param coordIni Coordenadas do ponto antes de ser transladado
     * @param vetor Vetor associado a tranlação do potno
     * @return  As coordenadas do ponto após a translação
     */
    public static Coordenada transladarCoordenada(Coordenada coordIni, Coordenada vetor) {
        int tc_x = coordIni.c_x + vetor.c_x;
        int tc_y = coordIni.c_y + vetor.c_y;
        Coordenada t_coordenada = new Coordenada(tc_x, tc_y);
        return t_coordenada;
    }

    /**
     * Itera sobre uma lista de coordenadas e confere se uma em específico está contida
     * @param listaCoord Lista de coordenadas em que iremos iterar
     * @return "true" se o ponto dado está na lista
     * @return "false" se o ponto dado não está na lista
     */
    public boolean estaNaLista(ArrayList<Coordenada> listaCoord) {
        for (Coordenada coordenada : listaCoord) {
            if (coordenada.getC_x() == getC_x() && coordenada.getC_y() == getC_y())
                return true;
        }
        return false;
    }

    /**
     * Verifica se o vetor dadeo é paralelo a um outro
     * @param vetor Vetor que queremos comparar com o vetor que chama o método
     * @return "true" se os vetores forem paralelos
     * @retuen "false" se os vetores não forem paralelos
     */
    public boolean ehParalelo(Coordenada vetor) {
        try {
            if (vetor.getC_x()/getC_x() == vetor.getC_y()/getC_y())
                return true;
            else 
                return false;
        } catch(ArithmeticException divisãoPorZero) {
            if (getC_x() == 0 && getC_y() == 0) 
                return false;
            else if ((getC_x() == 0 && getC_x() !=  vetor.getC_x()) || (getC_y() == 0 && getC_y() !=  vetor.getC_y()))
                return false;
            else if ((getC_x() == 0 && getC_x() ==  vetor.getC_x()) || (getC_y() == 0 && getC_y() ==  vetor.getC_y()))
                return true;
            else 
                return false;
        }
    }

    /**
     * Itera sobre uma lista de coordenadas(vetores) e verifica se o vetor que faz a chamada é paralelo a algum  
     * @param listaCoord Lista de coordenadas(vetores) sobre a qual iremos iterar
     * @return "true" se houver um vetor paralelo na lista
     * @return "false" se não houver um vetor paralelo na lista
     */
    public boolean contemVetorParalelo(ArrayList<Coordenada> listaCoord) {
        for (Coordenada vetor : listaCoord) {
            if (this.ehParalelo(vetor)) 
                return true; 
        }
        return false;
    }
    
    @Override
    public String toString() {
        String saida = "(" + getC_x() + "," + getC_y() + ")";
        return saida;
    }
}
