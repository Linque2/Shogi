package Componentes;
import java.util.*;
import java.io.*;

public class JogadorOushou extends Jogador implements Serializable {
	private static final long serialVersionUID = 729L;
    
    public JogadorOushou(String nome, int score, boolean eh_sente) {
        super(nome, score, eh_sente);
    }
    
    public JogadorOushou() { // Construtor vazio para teste de leitura e escrita. Pode sair depois.
        super();
    }
}
