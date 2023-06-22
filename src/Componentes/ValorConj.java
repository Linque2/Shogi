package Componentes;

public enum ValorConj {
     /**
     * Este enum representa os valores referentes a cada peça do jogo,
     * organizados em pares para cada peça na forma
     * {@code
     *  Valor[] {
     *     @param Valor.S_N, Valor da peça não promovida/normal
     *     @param Valor.S_P  Valor da peça promovida
     *  }
     * }
     */
    PEAO(new Valor[] {
        Valor.PEAO_N,
        Valor.PEAO_P
    }),
    LANCEIRO(new Valor[] {
        Valor.LANCEIRO_N,
        Valor.LANCEIRO_P
    }),
    CAVALO(new Valor[] {
        Valor.CAVALO_N,
        Valor.CAVALO_P
    }),
    PRATA(new Valor[] {
        Valor.PRATA_N,
        Valor.PRATA_P
    }),
    BISPO(new Valor[] {
        Valor.BISPO_N,
        Valor.BISPO_P
    }),
    TORRE(new Valor[] {
        Valor.TORRE_N,
        Valor.TORRE_P
    });
    
    private final Valor[] valores;

    /**
     * @param valores Par dos valores associados a uma peça, um para cada estado
     */
    ValorConj(Valor[] valores) {
        this.valores = valores;
    }

    /**
     * @return 
     */
    public Valor[] getValorConj() {
        return this.valores;
    }

}
