package Componentes;

import java.util.*;

public enum MovimentoConj {
    /**
     * Este enum representa os movimentos correspondentes as formas providas e não promovidas de uma peça,
     * organizados em pares para cada peça na forma
     * {@code
     *  Movimento[] {
     *     @param Movimento.S_N, Movimento da peça não promovida/normal
     *     @param Movimento.S_P  Movimento da peça promovida
     *  }
     * }
     */
    REI_JOIA(new Movimento[] {
        Movimento.REI_JOIA
    }),
    REI(new Movimento[] {
        Movimento.REI
    }),
    OURO(new Movimento[] {
        Movimento.OURO
    }),
    PEAO(new Movimento[] {
        Movimento.PEAO_N,
        Movimento.PEAO_P
    }),
    LANCEIRO(new Movimento[] {
        Movimento.LANCEIRO_N,
        Movimento.LANCEIRO_P
    }),
    CAVALO(new Movimento[] {
        Movimento.CAVALO_N,
        Movimento.CAVALO_P
    }),
    PRATA(new Movimento[] {
        Movimento.PRATA_N,
        Movimento.PRATA_P
    }),
    BISPO(new Movimento[] {
        Movimento.BISPO_N,
        Movimento.BISPO_P
    }),
    TORRE(new Movimento[] {
        Movimento.TORRE_N,
        Movimento.TORRE_P
    });


     private final ArrayList<Movimento> movimentos;
     

     /**
      * @param sentidos lista de vetores unitarios associados ao movimento de uma peça
      */
     MovimentoConj(Movimento[] sentidos) {
        List<Movimento> lista = Arrays.asList(sentidos);
        ArrayList<Movimento> movimentos = new ArrayList<Movimento>(lista);
        this.movimentos = movimentos;
     }
 
     /**
      * @return Retorna uma lista com dois elementos, o primeiro guarda todos os movimentos para a forma não promovida da peça, o segundo para a forma promovida
      */
     public ArrayList<Movimento> getMovimentos() { 
        return this.movimentos;
     }
}
