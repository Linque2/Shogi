package Componentes;

public enum SentidosFundamentais {
    
    NORTE(new Coordenada(-1, 0)),
    SUL(new Coordenada(1,0)),
    LESTE(new Coordenada(0,-1)),
    OESTE(new Coordenada(0, 1)),
    NE(new Coordenada(-1, 1)),
    SE(new Coordenada(1,1)),
    NO(new Coordenada(-1, -1)),
    SO(new Coordenada(1, -1)),
    L_NE(new Coordenada(-2,1)),
    L_NO(new Coordenada(-2, -1)),
    L_SE(new Coordenada(2,1)),
    L_SO(new Coordenada(2,-1));

    private final Coordenada vetor;

    /**
     * @param vetor Relacionado ao vetor únitário dos pontos cardeais e colaterais
     */
    SentidosFundamentais(Coordenada vetor) {
        this.vetor = vetor;
    }

    public Coordenada getSentidosFundamentais() {
        return vetor;        
    }
}
