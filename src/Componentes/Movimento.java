package Componentes;

import java.util.*;

public enum Movimento {
    /**
     * Este enum guarda lista de vetores unitários, 
     * correspondentes aos movimentos possíveis de cada peça
     */

     //Peças normais
    REI(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.SE,
        SentidosFundamentais.NO,
        SentidosFundamentais.SO
    }),
    REI_JOIA(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.SE,
        SentidosFundamentais.NO,
        SentidosFundamentais.SO
    }),
    OURO(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.NO,
    }),
    PEAO_N(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE
    }),
    LANCEIRO_N(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
    }),
    CAVALO_N(new SentidosFundamentais[] {
        SentidosFundamentais.L_NE,
        SentidosFundamentais.L_NO
    }),
    PRATA_N(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.SE,
        SentidosFundamentais.NO,
        SentidosFundamentais.SO
    }),
    BISPO_N(new SentidosFundamentais[] {
        SentidosFundamentais.NE,
        SentidosFundamentais.SE,
        SentidosFundamentais.NO,
        SentidosFundamentais.SO
    }),
    TORRE_N(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
    }),
    //Peças promovidas
    PEAO_P(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.NO,
    }),
    LANCEIRO_P(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.NO,
    }),
    CAVALO_P(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.NO,
    }),
    PRATA_P(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.NO,
    }),
    BISPO_P(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.SE,
        SentidosFundamentais.NO,
        SentidosFundamentais.SO
    }),
    TORRE_P(new SentidosFundamentais[] {
        SentidosFundamentais.NORTE,
        SentidosFundamentais.SUL,
        SentidosFundamentais.LESTE,
        SentidosFundamentais.OESTE,
        SentidosFundamentais.NE,
        SentidosFundamentais.SE,
        SentidosFundamentais.NO,
        SentidosFundamentais.SO
    });


    private final ArrayList<SentidosFundamentais> movimentos;

    /**
     * @param sentidos lista de vetores unitarios associados ao movimento de uma peça
     */
    Movimento(SentidosFundamentais[] sentidos) {
        List<SentidosFundamentais> lista = Arrays.asList(sentidos);
        ArrayList<SentidosFundamentais> movimentos = new ArrayList<SentidosFundamentais>(lista); // Transforma o SentidosFundamentais[] em ArrayList<SentidosFundamentais>
        this.movimentos = movimentos;
    }

    /**
     * @return Vetores unitários para o deslocamento de cada peça
     */
    public ArrayList<SentidosFundamentais> getMovimentos() {
        return this.movimentos;
    }
}
