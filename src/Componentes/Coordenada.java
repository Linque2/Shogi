package Componentes;

public class Coordenada {
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
}
