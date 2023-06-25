package Componentes;

import java.io.*;

public class JogadorGyokushou extends Jogador implements Serializable {
	private static final long serialVersionUID = 576L;
    
    public JogadorGyokushou(String nome, int score, boolean eh_sente) {
        super(nome, score, eh_sente);
    }
    
    public JogadorGyokushou() { // Construtor vazio para teste de leitura e escrita. Pode sair depois.
        super();
    }
}