package Componentes;
import java.util.*;

public class JogadorOushou extends Jogador {
    
    public JogadorOushou(String nome, int score, boolean eh_sente) {
        super(nome, score, eh_sente);
    }

    /**
     * No Shogi, o Furigoma é a maneira de determinar quem é o primeiro a jogar (Sente) e quem joga em seguida (Gote).
     * O Oushou, jogador com maior score, arremessa 5 peões
     * se o número de peões com a face padrão virada para cima for maior ou igual a 3, o Oushou começa a partida
     * caso o número de peões com a face promovida virada para cima for maior ou igual a 3, o Gyokushou começa a partida
     * @return o jogador Sente (quem começa a partida)
     */
    public Jogador Furigoma(Jogador gyokushou, Jogador oushou) {
        Random random = new Random();
        int numCartasPadrao = random.nextInt(6);
        if (numCartasPadrao >= 3) {
            gyokushou.setEh_sente(false);
            oushou.setEh_sente(true);
            return oushou;  
        }
        else {
            gyokushou.setEh_sente(true);
            oushou.setEh_sente(false);
            return gyokushou;        
        }
    }
}
