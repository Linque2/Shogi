import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import Componentes.*;

public enum MenuOperacoes {
    HOME("\n1 - Novo jogo\n2 - Listar jogos salvos\n3 - Salvar jogo\n4 - Sair"),

    SALVOS("\n1 - Abrir um jogo\n2 - Deletar um jogo\n3 - Deletar todos os jogos\n4 - Voltar\n"),

    SAIR("");

    private final String texto;

    MenuOperacoes(String texto) {
        this.texto = texto;
    }

    public String texto() {
        return texto;
    }

    public MenuOperacoes processarInput(int input, Scanner scanner, ArrayList<Tabuleiro> jogosAbertos) {
        switch (this) {
            case HOME:
                switch (input) {
                    case 1: // Novo jogo
                        Main.Menu.novoJogo(scanner);
                        return HOME;
                    case 2: // Listar jogos salvos
                    	if (Main.Menu.listarJogosSalvos())
                    		return SALVOS;
                        return HOME;
                    case 3: // Salvar jogo
                    	Main.Menu.salvarJogo(scanner, jogosAbertos);
                    	return HOME;
                    case 4: // Voltar
                    	return SAIR;
                    default:
                        return HOME;
                }
            case SALVOS:
                switch (input) {
                    case 1: // Abrir um jogo
                    	Main.Menu.abrirJogo(scanner, jogosAbertos);
                        return HOME;
                    case 2: // Deletar um jogo
                    	Main.Menu.deletarJogo(scanner);
                    	return HOME;
                    case 3: // Deletar todos os jogos
                        Main.Menu.deletarTodosOsJogos();
                        return HOME;
                    case 4: // Voltar
                        return HOME;
                    default:
                        return SALVOS;
                }
            case SAIR:
                return SAIR;
            default:
                throw new AssertionError("Menu de tipo desconhecido: " + this);
        }
    }    
}