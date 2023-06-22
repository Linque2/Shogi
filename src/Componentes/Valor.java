/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public enum Valor {
    /**
     * Peças comuns
     */
    REI_JOIA(-1),   //Em um jogo real o rei não possui valor, pois não pode ser capturado
    REI(-1),        //
    OURO(5),
    PEAO_N(1),
    LANCEIRO_N(3),
    CAVALO_N(3),
    PRATA_N(5),
    BISPO_N(8),
    TORRE_N(9),
    /**
     *Peças promovidas
     */
    PEAO_P(7),
    LANCEIRO_P(6),
    CAVALO_P(6),
    PRATA_P(6),
    BISPO_P(12),
    TORRE_P(13);

    private final int valor;

    /**
     * @param valor Valor de cada peça segundo as regras do jogo
     */
    Valor(int valor) {
        this.valor = valor;
    }

    /**
     * @return Valor de uma peça dada
     */
    public int getValor() {
        return this.valor;
    }
}
