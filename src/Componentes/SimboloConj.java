package Componentes;

public enum SimboloConj {
    /**
     * Este enum representa os simbolos encravados em cada peça do jogo,
     * organizados em pares para cada peça na forma
     * {@code
     *  Simbolo[] {
     *     @param Simbolo.S_N, Simbolo da peça não promovida/normal
     *     @param Simbolo.S_P  Simbolo da peça promovida
     *  }
     * }
     */
    PEAO(new Simbolo[] {
        Simbolo.PEAO_N,
        Simbolo.PEAO_P
    }),
    LANCEIRO(new Simbolo[] {
        Simbolo.LANCEIRO_N,
        Simbolo.LANCEIRO_P
    }),
    CAVALO(new Simbolo[] {
        Simbolo.CAVALO_N,
        Simbolo.CAVALO_P
    }),
    PRATA(new Simbolo[] {
        Simbolo.PRATA_N,
        Simbolo.PRATA_P
    }),
    BISPO(new Simbolo[] {
        Simbolo.BISPO_N,
        Simbolo.BISPO_P
    }),
    TORRE(new Simbolo[] {
        Simbolo.TORRE_N,
        Simbolo.TORRE_P
    })
    ;

    public final Simbolo[] simbolos;

    /**
     * @param simbolos Par de simbolos gravados em cada peça
     */
    SimboloConj(Simbolo[] simbolos) {
        this.simbolos = simbolos;
    }

    /**
     * @return O par de simbolos que estão gravados em cada peça
     */
    public Simbolo[] getSimboloConj() {
        return this.simbolos;
    }
    
}
