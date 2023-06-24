/**
 * Criado por Rafael Masato Haga Costa em 22/06/2023
 */

package Componentes;

public enum Simbolo {
    /**
     * Códigos unicode para o símbolo de cada peça
     * Observe que a maioria das peças possui uma versão padrão e outra promovida, 
     * que por sua vez são representadass por ideogramas distintos.
     * Como temos essa dualidade presente em algumas peças, criamos a classe enum "SimboloConj",
     * que contém uma "tupla" com os ideogramas de ambas as formas da peça
     * As excessões a regra são os Reis e o Ouro, que não possuem promoção
     */
    //Peças normais
    REI_JOIA('\u7389'),
    REI('\u738B'),
    OURO('\u91D1'),
    PEAO_N('\u6B69'),
    LANCEIRO_N('\u9999'),
    CAVALO_N('\u6842'),
    PRATA_N('\u9280'),
    BISPO_N('\u89D2'),
    TORRE_N('\u98DB'),
    //Peças promovidas
    PEAO_P('\u3068'),
    LANCEIRO_P('\u674F'),
    CAVALO_P('\u4ECA'),
    PRATA_P('\u5168'),
    BISPO_P('\u99AC'),
    TORRE_P('\u9F8D');

    private final char simbolo;

    /**
     * @param simbolo Kanji de cada peça, usado em notação de jogo
     */
    Simbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return Kanji de uma peça dada
     */
    public char getSimbolo() {
        return this.simbolo;
    }
}
