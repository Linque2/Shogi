package Componentes;

import java.util.*;

public enum Movimento {
    /**
     * Este enum guarda lista de vetores unitários, 
     * correspondentes aos movimentos possíveis de cada peça
     */

     //Peças normais
    REI(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    REI_JOIA(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    OURO(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais(),
    }),
    PEAO_N(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais()
    }),
    LANCEIRO_N(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
    }),
    CAVALO_N(new Coordenada[] {
        SentidosFundamentais.L_NE.getSentidosFundamentais(),
        SentidosFundamentais.L_NO.getSentidosFundamentais()
    }),
    PRATA_N(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    BISPO_N(new Coordenada[] {
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    TORRE_N(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais()
    }),
    //Peças promovidas
    PEAO_P(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais()
    }),
    LANCEIRO_P(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais()
    }),
    CAVALO_P(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais()
    }),
    PRATA_P(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais()
    }),
    BISPO_P(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    TORRE_P(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }), 
    GyokuREI(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    GyokuREI_JOIA(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    GyokuOURO(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais(),
    }),
    GyokuPEAO_N(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais()
    }),
    GyokuLANCEIRO_N(new Coordenada[] {
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
    }),
    GyokuCAVALO_N(new Coordenada[] {
        SentidosFundamentais.L_NE.getSentidosFundamentais(),
        SentidosFundamentais.L_NO.getSentidosFundamentais()
    }),
    GyokuPRATA_N(new Coordenada[] {
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais()
    }),
    GyokuBISPO_N(new Coordenada[] {
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais()
    }),
    GyokuTORRE_N(new Coordenada[] {
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais()
    }),
    //Peças promovidas
    GyokuPEAO_P(new Coordenada[] {
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    GyokuLANCEIRO_P(new Coordenada[] {
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    GyokuCAVALO_P(new Coordenada[] {
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    GyokuPRATA_P(new Coordenada[] {
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais()
    }),
    GyokuBISPO_P(new Coordenada[] {
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais()
    }),
    GyokuTORRE_P(new Coordenada[] {
        SentidosFundamentais.SUL.getSentidosFundamentais(),
        SentidosFundamentais.NORTE.getSentidosFundamentais(),
        SentidosFundamentais.LESTE.getSentidosFundamentais(),
        SentidosFundamentais.OESTE.getSentidosFundamentais(),
        SentidosFundamentais.SE.getSentidosFundamentais(),
        SentidosFundamentais.NE.getSentidosFundamentais(),
        SentidosFundamentais.SO.getSentidosFundamentais(),
        SentidosFundamentais.NO.getSentidosFundamentais()
    });


    private final ArrayList<Coordenada> movimentos;

    /**
     * @param sentidos lista de vetores unitarios associados ao movimento de uma peça
     */
    Movimento(Coordenada[] sentidos) {
        List<Coordenada> lista = Arrays.asList(sentidos);
        ArrayList<Coordenada> movimentos = new ArrayList<Coordenada>(lista); // Transforma o Coordenada[] em ArrayList<Coordenada>
        this.movimentos = movimentos;
    }

    /**
     * @return Vetores unitários para o deslocamento de cada peça
     */
    public ArrayList<Coordenada> getMovimentos() {
        return this.movimentos;
    }

    @Override
    public String toString() {
        String saida = "";
        for (Coordenada coordenada : getMovimentos())
            saida += coordenada.toString();
        return saida;
    }
}
